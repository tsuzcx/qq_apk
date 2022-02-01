package com.tencent.tbs.one.impl.loader;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneComponent;
import com.tencent.tbs.one.TBSOneDelegate;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.impl.base.Logging;
import com.tencent.tbs.one.impl.base.ThreadUtils;
import com.tencent.tbs.one.impl.base.task.CompletionTask;
import com.tencent.tbs.one.impl.base.task.Task;
import com.tencent.tbs.one.impl.base.task.TaskRunner;
import com.tencent.tbs.one.impl.base.task.TaskRunner.Listener;
import com.tencent.tbs.one.impl.base.task.ThreadPoolTaskRunner;
import com.tencent.tbs.one.impl.common.DEPSConfig;
import com.tencent.tbs.one.impl.common.DEPSConfig.ComponentConfig;
import com.tencent.tbs.one.impl.common.ManifestConfig;
import com.tencent.tbs.one.impl.common.ManifestConfig.FileConfig;
import com.tencent.tbs.one.impl.common.ManifestConfig.ParentConfig;
import com.tencent.tbs.one.impl.common.PathService;
import com.tencent.tbs.one.impl.common.Statistics;
import com.tencent.tbs.one.impl.loader.dex.DexUtils;
import com.tencent.tbs.one.impl.policy.PolicyManager;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ComponentLoader
  implements TaskRunner.Listener
{
  private static final int INITIALIZATION_PROGRESS_BASE = 90;
  private static final int INSTALLATION_PROGRESS_BASE = 20;
  private Map<String, ClassLoader> mClassLoaders;
  private ComponentImpl mComponent;
  private DEPSConfig.ComponentConfig mConfig;
  private ArrayList<TBSOneCallback<File>> mInstallationCallbacks = new ArrayList();
  private File mInstallationDirectory;
  private boolean mIsRunning;
  private String mLastDescription;
  private int mLastErrorCode;
  private int mLastInstallationProgress;
  private int mLastProgress;
  private ArrayList<TBSOneCallback<TBSOneComponent>> mLoadCallbacks = new ArrayList();
  private ManifestConfig mManifestConfig;
  private String mName;
  private PolicyManager mPolicyManager;
  
  public ComponentLoader(PolicyManager paramPolicyManager, String paramString)
  {
    this.mName = paramString;
    this.mPolicyManager = paramPolicyManager;
  }
  
  private Set<String> collectLibrarySearchPaths()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add(this.mInstallationDirectory.getAbsolutePath());
    String[] arrayOfString = this.mConfig.getDependencies();
    if (arrayOfString != null)
    {
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        localHashSet.addAll(this.mPolicyManager.getLoader(str).collectLibrarySearchPaths());
        i += 1;
      }
    }
    return localHashSet;
  }
  
  private void fail(int paramInt, String paramString, Throwable paramThrowable)
  {
    int j = -1;
    Object localObject = this.mName;
    Logging.w("Failed to install or load component %s, error: [%d] %s", new Object[] { localObject, Integer.valueOf(paramInt), paramString });
    Logging.e("[%s] {%s} Failed to install or load component, error: [%d] %s", new Object[] { this.mPolicyManager.getCategory(), localObject, Integer.valueOf(paramInt), paramString, paramThrowable });
    DEPSConfig localDEPSConfig = this.mPolicyManager.getDEPSConfig();
    if (localDEPSConfig != null) {}
    for (int i = localDEPSConfig.getVersionCode();; i = -1)
    {
      if (this.mConfig != null) {
        j = this.mConfig.getVersionCode();
      }
      Statistics.reportError(i, (String)localObject, j, paramInt, paramString, paramThrowable);
      paramThrowable = new Bundle();
      paramThrowable.putBoolean("is_ignore_frequency_limitation", true);
      paramThrowable.putBoolean("is_ignore_wifi_state", true);
      paramThrowable.putBoolean("is_ignore_flow_control", true);
      this.mPolicyManager.doUpdate(paramThrowable);
      this.mLastErrorCode = paramInt;
      this.mLastDescription = paramString;
      this.mConfig = null;
      this.mManifestConfig = null;
      this.mInstallationDirectory = null;
      this.mComponent = null;
      this.mLastProgress = 0;
      this.mIsRunning = false;
      paramThrowable = (TBSOneCallback[])this.mInstallationCallbacks.toArray(new TBSOneCallback[0]);
      this.mInstallationCallbacks.clear();
      localObject = (TBSOneCallback[])this.mLoadCallbacks.toArray(new TBSOneCallback[0]);
      this.mLoadCallbacks.clear();
      j = paramThrowable.length;
      i = 0;
      while (i < j)
      {
        paramThrowable[i].onError(paramInt, paramString);
        i += 1;
      }
    }
    j = localObject.length;
    i = 0;
    while (i < j)
    {
      localObject[i].onError(paramInt, paramString);
      i += 1;
    }
  }
  
  private void finishInstallation(File paramFile)
  {
    int i = 0;
    Logging.i("[%s] {%s} Finished installing component at %s", new Object[] { this.mPolicyManager.getCategory(), this.mName, paramFile.getAbsolutePath() });
    this.mInstallationDirectory = paramFile;
    TBSOneCallback[] arrayOfTBSOneCallback = (TBSOneCallback[])this.mInstallationCallbacks.toArray(new TBSOneCallback[0]);
    this.mInstallationCallbacks.clear();
    int j = arrayOfTBSOneCallback.length;
    while (i < j)
    {
      TBSOneCallback localTBSOneCallback = arrayOfTBSOneCallback[i];
      localTBSOneCallback.onProgressChanged(this.mLastProgress, 100);
      localTBSOneCallback.onCompleted(paramFile);
      i += 1;
    }
  }
  
  private void finishLoading(ComponentImpl paramComponentImpl)
  {
    int i = 0;
    Logging.i("[%s] {%s} Finished loading component %s", new Object[] { this.mPolicyManager.getCategory(), this.mName, paramComponentImpl });
    this.mComponent = paramComponentImpl;
    int j = this.mLastProgress;
    this.mLastProgress = 100;
    TBSOneCallback[] arrayOfTBSOneCallback = (TBSOneCallback[])this.mLoadCallbacks.toArray(new TBSOneCallback[0]);
    this.mLoadCallbacks.clear();
    int k = arrayOfTBSOneCallback.length;
    while (i < k)
    {
      TBSOneCallback localTBSOneCallback = arrayOfTBSOneCallback[i];
      localTBSOneCallback.onProgressChanged(j, 100);
      localTBSOneCallback.onCompleted(paramComponentImpl);
      i += 1;
    }
  }
  
  private ClassLoader getCallingClassLoader()
  {
    try
    {
      Object localObject = Class.forName("dalvik.system.VMStack").getMethod("getCallingClassLoader", new Class[0]);
      ((Method)localObject).setAccessible(true);
      localObject = ((Method)localObject).invoke(null, new Object[0]);
      if ((localObject instanceof ClassLoader))
      {
        localObject = (ClassLoader)localObject;
        return localObject;
      }
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  private File getComponentFile(String paramString)
  {
    Object localObject;
    if (this.mPolicyManager.useBuiltinOnly())
    {
      localObject = this.mPolicyManager.getDelegate();
      if (localObject != null)
      {
        localObject = ((TBSOneDelegate)localObject).shouldOverrideFilePath(this.mPolicyManager.getCategory(), this.mName, this.mConfig.getVersionCode(), paramString);
        if (localObject != null) {
          paramString = new File((String)localObject);
        }
      }
    }
    do
    {
      return paramString;
      return PathService.getComponentFileInNativeLibraryDirectory(PathService.getNativeLibraryDirectory(this.mPolicyManager.getCallerContext()), this.mName, paramString);
      localObject = new File(this.mInstallationDirectory, paramString);
      paramString = (String)localObject;
    } while (((File)localObject).exists());
    Logging.w("Failed to find component file %s in installation directory", new Object[] { ((File)localObject).getAbsolutePath() });
    return localObject;
  }
  
  private String getLibrarySearchPath(String paramString)
  {
    String str2 = TextUtils.join(File.pathSeparator, collectLibrarySearchPaths());
    Logging.i("[%s] {%s} Collected librarySearchPath %s", new Object[] { this.mPolicyManager.getCategory(), this.mName, str2 });
    String str1 = str2;
    if (this.mPolicyManager.useBuiltinOnly())
    {
      TBSOneDelegate localTBSOneDelegate = this.mPolicyManager.getDelegate();
      str1 = str2;
      if (localTBSOneDelegate != null)
      {
        paramString = localTBSOneDelegate.shouldOverrideLibrarySearchPath(this.mPolicyManager.getCategory(), this.mName, this.mConfig.getVersionCode(), paramString, str2);
        str1 = str2;
        if (paramString != null) {
          str1 = paramString;
        }
      }
    }
    return str1;
  }
  
  private ClassLoader getOrCreateClassLoader(Context paramContext, String paramString)
  {
    String str1 = this.mPolicyManager.getCategory();
    String str2 = this.mName;
    Object localObject1;
    if (this.mClassLoaders != null)
    {
      localObject1 = (ClassLoader)this.mClassLoaders.get(paramString);
      if (localObject1 != null)
      {
        Logging.i("[%s] {%s} Reusing class loader %s %s", new Object[] { str1, str2, paramString, localObject1 });
        return localObject1;
      }
    }
    File localFile = getComponentFile(paramString);
    if (!localFile.exists()) {
      throw new TBSOneException(105, "Failed to find dex file " + localFile.getAbsolutePath());
    }
    Logging.i("[%s] {%s} Creating class loader %s from %s", new Object[] { str1, str2, paramString, localFile.getAbsolutePath() });
    label173:
    String str3;
    label205:
    long l;
    Object localObject3;
    if (this.mManifestConfig == null)
    {
      localObject2 = null;
      if (localObject2 != null) {
        break label390;
      }
      localObject1 = null;
      if (localObject1 == null) {
        break label464;
      }
      str3 = ((ManifestConfig.ParentConfig)localObject1).getComponentName();
      if (!TextUtils.isEmpty(str3)) {
        break label400;
      }
      localObject1 = getOrCreateClassLoader(paramContext, ((ManifestConfig.ParentConfig)localObject1).getPath());
      str3 = getLibrarySearchPath(localFile.getAbsolutePath());
      l = System.currentTimeMillis();
      localObject3 = this.mInstallationDirectory.getAbsolutePath();
      if (localObject2 != null) {
        break label493;
      }
    }
    label390:
    label400:
    label464:
    label493:
    for (Object localObject2 = null;; localObject2 = ((ManifestConfig.FileConfig)localObject2).getSealedPackage())
    {
      paramContext = DexUtils.createClassLoader(paramContext, localFile, (String)localObject3, str3, (ClassLoader)localObject1, (String)localObject2, this.mPolicyManager.getBooleanConfiguration("async_dex_optimization", false));
      Logging.i("[%s] {%s} Created dex class loader %s %s cost %dms", new Object[] { str1, str2, paramString, paramContext, Long.valueOf(System.currentTimeMillis() - l) });
      if (this.mClassLoaders == null) {
        this.mClassLoaders = new HashMap();
      }
      this.mClassLoaders.put(paramString, paramContext);
      if (this.mPolicyManager.useBuiltinOnly())
      {
        paramString = this.mPolicyManager.getDelegate();
        if (paramString != null) {
          paramString.onDexLoaded(str1, str2, this.mConfig.getVersionCode(), localFile.getAbsolutePath(), paramContext);
        }
      }
      return paramContext;
      localObject2 = this.mManifestConfig.getFileConfig(paramString);
      break;
      localObject1 = ((ManifestConfig.FileConfig)localObject2).getParentConfig();
      break label173;
      localObject3 = this.mPolicyManager.getLoader(str3);
      if (localObject3 == null) {
        throw new TBSOneException(404, "Failed to get loaded dependency " + str3);
      }
      localObject1 = ((ComponentLoader)localObject3).getOrCreateClassLoader(paramContext, ((ManifestConfig.ParentConfig)localObject1).getPath());
      break label205;
      localObject1 = getCallingClassLoader();
      if (localObject1 != null) {
        break label205;
      }
      for (;;)
      {
        localObject1 = this.mPolicyManager.getCallerContext().getClassLoader();
      }
    }
  }
  
  /* Error */
  private void initializeComponent()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 53	com/tencent/tbs/one/impl/loader/ComponentLoader:mPolicyManager	Lcom/tencent/tbs/one/impl/policy/PolicyManager;
    //   4: invokevirtual 164	com/tencent/tbs/one/impl/policy/PolicyManager:getCategory	()Ljava/lang/String;
    //   7: astore 6
    //   9: aload_0
    //   10: getfield 51	com/tencent/tbs/one/impl/loader/ComponentLoader:mName	Ljava/lang/String;
    //   13: astore 7
    //   15: aload_0
    //   16: getfield 85	com/tencent/tbs/one/impl/loader/ComponentLoader:mConfig	Lcom/tencent/tbs/one/impl/common/DEPSConfig$ComponentConfig;
    //   19: invokevirtual 178	com/tencent/tbs/one/impl/common/DEPSConfig$ComponentConfig:getVersionCode	()I
    //   22: istore_2
    //   23: ldc_w 444
    //   26: iconst_2
    //   27: anewarray 4	java/lang/Object
    //   30: dup
    //   31: iconst_0
    //   32: aload 6
    //   34: aastore
    //   35: dup
    //   36: iconst_1
    //   37: aload 7
    //   39: aastore
    //   40: invokestatic 229	com/tencent/tbs/one/impl/base/Logging:i	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   43: new 446	com/tencent/tbs/one/impl/loader/ComponentImpl
    //   46: dup
    //   47: aload 7
    //   49: aload_0
    //   50: getfield 85	com/tencent/tbs/one/impl/loader/ComponentLoader:mConfig	Lcom/tencent/tbs/one/impl/common/DEPSConfig$ComponentConfig;
    //   53: invokevirtual 449	com/tencent/tbs/one/impl/common/DEPSConfig$ComponentConfig:getVersionName	()Ljava/lang/String;
    //   56: iload_2
    //   57: aload_0
    //   58: getfield 113	com/tencent/tbs/one/impl/loader/ComponentLoader:mInstallationDirectory	Ljava/io/File;
    //   61: invokespecial 452	com/tencent/tbs/one/impl/loader/ComponentImpl:<init>	(Ljava/lang/String;Ljava/lang/String;ILjava/io/File;)V
    //   64: astore 5
    //   66: aload_0
    //   67: ldc_w 454
    //   70: invokespecial 342	com/tencent/tbs/one/impl/loader/ComponentLoader:getComponentFile	(Ljava/lang/String;)Ljava/io/File;
    //   73: astore 4
    //   75: aload 4
    //   77: invokevirtual 309	java/io/File:exists	()Z
    //   80: ifeq +853 -> 933
    //   83: ldc_w 456
    //   86: iconst_3
    //   87: anewarray 4	java/lang/Object
    //   90: dup
    //   91: iconst_0
    //   92: aload 6
    //   94: aastore
    //   95: dup
    //   96: iconst_1
    //   97: aload 7
    //   99: aastore
    //   100: dup
    //   101: iconst_2
    //   102: aload 4
    //   104: invokevirtual 119	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   107: aastore
    //   108: invokestatic 229	com/tencent/tbs/one/impl/base/Logging:i	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   111: aload_0
    //   112: aload 4
    //   114: invokestatic 460	com/tencent/tbs/one/impl/common/ManifestConfig:parse	(Ljava/io/File;)Lcom/tencent/tbs/one/impl/common/ManifestConfig;
    //   117: putfield 203	com/tencent/tbs/one/impl/loader/ComponentLoader:mManifestConfig	Lcom/tencent/tbs/one/impl/common/ManifestConfig;
    //   120: aload_0
    //   121: getfield 203	com/tencent/tbs/one/impl/loader/ComponentLoader:mManifestConfig	Lcom/tencent/tbs/one/impl/common/ManifestConfig;
    //   124: invokevirtual 464	com/tencent/tbs/one/impl/common/ManifestConfig:getEventPairs	()[Landroid/util/Pair;
    //   127: astore 4
    //   129: aload 4
    //   131: ifnull +106 -> 237
    //   134: ldc_w 466
    //   137: iconst_3
    //   138: anewarray 4	java/lang/Object
    //   141: dup
    //   142: iconst_0
    //   143: aload 6
    //   145: aastore
    //   146: dup
    //   147: iconst_1
    //   148: aload 7
    //   150: aastore
    //   151: dup
    //   152: iconst_2
    //   153: aload 4
    //   155: aastore
    //   156: invokestatic 229	com/tencent/tbs/one/impl/base/Logging:i	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   159: aload 4
    //   161: arraylength
    //   162: istore_3
    //   163: iconst_0
    //   164: istore_1
    //   165: iload_1
    //   166: iload_3
    //   167: if_icmpge +90 -> 257
    //   170: aload 4
    //   172: iload_1
    //   173: aaload
    //   174: astore 8
    //   176: aload_0
    //   177: getfield 53	com/tencent/tbs/one/impl/loader/ComponentLoader:mPolicyManager	Lcom/tencent/tbs/one/impl/policy/PolicyManager;
    //   180: new 468	com/tencent/tbs/one/impl/common/ReceiverConfig
    //   183: dup
    //   184: aload 7
    //   186: aload 8
    //   188: getfield 474	android/util/Pair:second	Ljava/lang/Object;
    //   191: checkcast 476	java/lang/String
    //   194: aload 8
    //   196: getfield 479	android/util/Pair:first	Ljava/lang/Object;
    //   199: checkcast 476	java/lang/String
    //   202: invokespecial 482	com/tencent/tbs/one/impl/common/ReceiverConfig:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   205: invokevirtual 486	com/tencent/tbs/one/impl/policy/PolicyManager:registerReceiverConfig	(Lcom/tencent/tbs/one/impl/common/ReceiverConfig;)V
    //   208: iload_1
    //   209: iconst_1
    //   210: iadd
    //   211: istore_1
    //   212: goto -47 -> 165
    //   215: astore 4
    //   217: aload_0
    //   218: aload 4
    //   220: invokevirtual 489	com/tencent/tbs/one/TBSOneException:getErrorCode	()I
    //   223: aload 4
    //   225: invokevirtual 492	com/tencent/tbs/one/TBSOneException:getMessage	()Ljava/lang/String;
    //   228: aload 4
    //   230: invokevirtual 496	com/tencent/tbs/one/TBSOneException:getCause	()Ljava/lang/Throwable;
    //   233: invokespecial 66	com/tencent/tbs/one/impl/loader/ComponentLoader:fail	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   236: return
    //   237: ldc_w 498
    //   240: iconst_2
    //   241: anewarray 4	java/lang/Object
    //   244: dup
    //   245: iconst_0
    //   246: aload 6
    //   248: aastore
    //   249: dup
    //   250: iconst_1
    //   251: aload 7
    //   253: aastore
    //   254: invokestatic 229	com/tencent/tbs/one/impl/base/Logging:i	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   257: aload_0
    //   258: getfield 53	com/tencent/tbs/one/impl/loader/ComponentLoader:mPolicyManager	Lcom/tencent/tbs/one/impl/policy/PolicyManager;
    //   261: invokevirtual 293	com/tencent/tbs/one/impl/policy/PolicyManager:getCallerContext	()Landroid/content/Context;
    //   264: astore 8
    //   266: aload_0
    //   267: getfield 203	com/tencent/tbs/one/impl/loader/ComponentLoader:mManifestConfig	Lcom/tencent/tbs/one/impl/common/ManifestConfig;
    //   270: invokevirtual 501	com/tencent/tbs/one/impl/common/ManifestConfig:getResourcePackagePath	()Ljava/lang/String;
    //   273: astore 9
    //   275: aconst_null
    //   276: astore 4
    //   278: aload 9
    //   280: invokestatic 369	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   283: ifne +388 -> 671
    //   286: aload_0
    //   287: aload 9
    //   289: invokespecial 342	com/tencent/tbs/one/impl/loader/ComponentLoader:getComponentFile	(Ljava/lang/String;)Ljava/io/File;
    //   292: astore 4
    //   294: ldc_w 503
    //   297: iconst_4
    //   298: anewarray 4	java/lang/Object
    //   301: dup
    //   302: iconst_0
    //   303: aload 6
    //   305: aastore
    //   306: dup
    //   307: iconst_1
    //   308: aload 7
    //   310: aastore
    //   311: dup
    //   312: iconst_2
    //   313: aload 9
    //   315: aastore
    //   316: dup
    //   317: iconst_3
    //   318: aload 4
    //   320: invokevirtual 119	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   323: aastore
    //   324: invokestatic 229	com/tencent/tbs/one/impl/base/Logging:i	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   327: aload 4
    //   329: invokevirtual 309	java/io/File:exists	()Z
    //   332: ifne +35 -> 367
    //   335: aload_0
    //   336: bipush 105
    //   338: new 346	java/lang/StringBuilder
    //   341: dup
    //   342: invokespecial 347	java/lang/StringBuilder:<init>	()V
    //   345: ldc_w 505
    //   348: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: aload 4
    //   353: invokevirtual 119	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   356: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   362: aconst_null
    //   363: invokespecial 66	com/tencent/tbs/one/impl/loader/ComponentLoader:fail	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   366: return
    //   367: new 507	com/tencent/tbs/one/impl/loader/resource/ResourcesContext
    //   370: dup
    //   371: aload 8
    //   373: aload 4
    //   375: invokevirtual 119	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   378: invokespecial 510	com/tencent/tbs/one/impl/loader/resource/ResourcesContext:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   381: astore 4
    //   383: aload 5
    //   385: aload 4
    //   387: invokevirtual 514	com/tencent/tbs/one/impl/loader/ComponentImpl:setResourcesContext	(Landroid/content/Context;)V
    //   390: aload_0
    //   391: getfield 203	com/tencent/tbs/one/impl/loader/ComponentLoader:mManifestConfig	Lcom/tencent/tbs/one/impl/common/ManifestConfig;
    //   394: invokevirtual 517	com/tencent/tbs/one/impl/common/ManifestConfig:getEntryDexPath	()Ljava/lang/String;
    //   397: astore 9
    //   399: aload 9
    //   401: invokestatic 369	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   404: ifne +506 -> 910
    //   407: aload_0
    //   408: aload 8
    //   410: aload 9
    //   412: invokespecial 374	com/tencent/tbs/one/impl/loader/ComponentLoader:getOrCreateClassLoader	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/ClassLoader;
    //   415: astore 11
    //   417: aload 5
    //   419: aload 11
    //   421: invokevirtual 521	com/tencent/tbs/one/impl/loader/ComponentImpl:setEntryClassLoader	(Ljava/lang/ClassLoader;)V
    //   424: aload_0
    //   425: getfield 203	com/tencent/tbs/one/impl/loader/ComponentLoader:mManifestConfig	Lcom/tencent/tbs/one/impl/common/ManifestConfig;
    //   428: invokevirtual 524	com/tencent/tbs/one/impl/common/ManifestConfig:getEntryClassName	()Ljava/lang/String;
    //   431: astore 10
    //   433: aload 10
    //   435: invokestatic 369	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   438: ifne +449 -> 887
    //   441: ldc_w 526
    //   444: iconst_3
    //   445: anewarray 4	java/lang/Object
    //   448: dup
    //   449: iconst_0
    //   450: aload 6
    //   452: aastore
    //   453: dup
    //   454: iconst_1
    //   455: aload 7
    //   457: aastore
    //   458: dup
    //   459: iconst_2
    //   460: aload 10
    //   462: aastore
    //   463: invokestatic 229	com/tencent/tbs/one/impl/base/Logging:i	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   466: new 403	java/util/HashMap
    //   469: dup
    //   470: invokespecial 404	java/util/HashMap:<init>	()V
    //   473: astore 6
    //   475: aload 6
    //   477: ldc_w 528
    //   480: aload 8
    //   482: invokeinterface 408 3 0
    //   487: pop
    //   488: aload 4
    //   490: ifnull +26 -> 516
    //   493: aload 4
    //   495: invokevirtual 532	com/tencent/tbs/one/impl/loader/resource/ResourcesContext:getLayoutInflater	()Lcom/tencent/tbs/one/impl/loader/resource/LayoutInflaterImpl;
    //   498: aload 11
    //   500: invokevirtual 537	com/tencent/tbs/one/impl/loader/resource/LayoutInflaterImpl:overrideClassLoader	(Ljava/lang/ClassLoader;)V
    //   503: aload 6
    //   505: ldc_w 539
    //   508: aload 4
    //   510: invokeinterface 408 3 0
    //   515: pop
    //   516: aload 6
    //   518: ldc_w 541
    //   521: aload 11
    //   523: invokeinterface 408 3 0
    //   528: pop
    //   529: aload 6
    //   531: ldc_w 543
    //   534: aload_0
    //   535: getfield 113	com/tencent/tbs/one/impl/loader/ComponentLoader:mInstallationDirectory	Ljava/io/File;
    //   538: invokeinterface 408 3 0
    //   543: pop
    //   544: aload 6
    //   546: ldc_w 545
    //   549: aload_0
    //   550: getfield 113	com/tencent/tbs/one/impl/loader/ComponentLoader:mInstallationDirectory	Ljava/io/File;
    //   553: invokeinterface 408 3 0
    //   558: pop
    //   559: aload 6
    //   561: ldc_w 547
    //   564: aload_0
    //   565: aload 9
    //   567: invokespecial 376	com/tencent/tbs/one/impl/loader/ComponentLoader:getLibrarySearchPath	(Ljava/lang/String;)Ljava/lang/String;
    //   570: invokeinterface 408 3 0
    //   575: pop
    //   576: aload 6
    //   578: ldc_w 549
    //   581: aload_0
    //   582: getfield 85	com/tencent/tbs/one/impl/loader/ComponentLoader:mConfig	Lcom/tencent/tbs/one/impl/common/DEPSConfig$ComponentConfig;
    //   585: invokevirtual 449	com/tencent/tbs/one/impl/common/DEPSConfig$ComponentConfig:getVersionName	()Ljava/lang/String;
    //   588: invokeinterface 408 3 0
    //   593: pop
    //   594: aload 6
    //   596: ldc_w 551
    //   599: iload_2
    //   600: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   603: invokeinterface 408 3 0
    //   608: pop
    //   609: aload 6
    //   611: ldc_w 553
    //   614: aload_0
    //   615: getfield 53	com/tencent/tbs/one/impl/loader/ComponentLoader:mPolicyManager	Lcom/tencent/tbs/one/impl/policy/PolicyManager;
    //   618: invokevirtual 557	com/tencent/tbs/one/impl/policy/PolicyManager:getEventEmitter	()Lcom/tencent/tbs/one/impl/policy/EventEmitterImpl;
    //   621: invokeinterface 408 3 0
    //   626: pop
    //   627: aload 5
    //   629: aload 11
    //   631: aload 10
    //   633: invokevirtual 560	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   636: iconst_1
    //   637: anewarray 249	java/lang/Class
    //   640: dup
    //   641: iconst_0
    //   642: ldc_w 334
    //   645: aastore
    //   646: invokevirtual 564	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   649: iconst_1
    //   650: anewarray 4	java/lang/Object
    //   653: dup
    //   654: iconst_0
    //   655: aload 6
    //   657: aastore
    //   658: invokevirtual 570	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   661: invokevirtual 573	com/tencent/tbs/one/impl/loader/ComponentImpl:setEntryObject	(Ljava/lang/Object;)V
    //   664: aload_0
    //   665: aload 5
    //   667: invokespecial 575	com/tencent/tbs/one/impl/loader/ComponentLoader:finishLoading	(Lcom/tencent/tbs/one/impl/loader/ComponentImpl;)V
    //   670: return
    //   671: ldc_w 577
    //   674: iconst_2
    //   675: anewarray 4	java/lang/Object
    //   678: dup
    //   679: iconst_0
    //   680: aload 6
    //   682: aastore
    //   683: dup
    //   684: iconst_1
    //   685: aload 7
    //   687: aastore
    //   688: invokestatic 229	com/tencent/tbs/one/impl/base/Logging:i	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   691: goto -301 -> 390
    //   694: astore 4
    //   696: aload_0
    //   697: aload 4
    //   699: invokevirtual 489	com/tencent/tbs/one/TBSOneException:getErrorCode	()I
    //   702: aload 4
    //   704: invokevirtual 492	com/tencent/tbs/one/TBSOneException:getMessage	()Ljava/lang/String;
    //   707: aload 4
    //   709: invokevirtual 496	com/tencent/tbs/one/TBSOneException:getCause	()Ljava/lang/Throwable;
    //   712: invokespecial 66	com/tencent/tbs/one/impl/loader/ComponentLoader:fail	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   715: return
    //   716: astore 4
    //   718: aload_0
    //   719: sipush 405
    //   722: new 346	java/lang/StringBuilder
    //   725: dup
    //   726: invokespecial 347	java/lang/StringBuilder:<init>	()V
    //   729: ldc_w 579
    //   732: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   735: aload 10
    //   737: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   740: ldc_w 581
    //   743: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   746: aload 9
    //   748: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   751: ldc_w 583
    //   754: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   757: aload 4
    //   759: invokestatic 589	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   762: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   765: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   768: aconst_null
    //   769: invokespecial 66	com/tencent/tbs/one/impl/loader/ComponentLoader:fail	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   772: return
    //   773: astore 4
    //   775: aload_0
    //   776: sipush 406
    //   779: new 346	java/lang/StringBuilder
    //   782: dup
    //   783: invokespecial 347	java/lang/StringBuilder:<init>	()V
    //   786: ldc_w 591
    //   789: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   792: aload 10
    //   794: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   797: ldc_w 593
    //   800: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   803: aload 9
    //   805: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   808: ldc_w 583
    //   811: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   814: aload 4
    //   816: invokestatic 589	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   819: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   822: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   825: aconst_null
    //   826: invokespecial 66	com/tencent/tbs/one/impl/loader/ComponentLoader:fail	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   829: return
    //   830: astore 4
    //   832: aload_0
    //   833: sipush 407
    //   836: new 346	java/lang/StringBuilder
    //   839: dup
    //   840: invokespecial 347	java/lang/StringBuilder:<init>	()V
    //   843: ldc_w 595
    //   846: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   849: aload 10
    //   851: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   854: ldc_w 581
    //   857: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   860: aload 9
    //   862: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   865: ldc_w 583
    //   868: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   871: aload 4
    //   873: invokestatic 589	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   876: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   879: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   882: aconst_null
    //   883: invokespecial 66	com/tencent/tbs/one/impl/loader/ComponentLoader:fail	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   886: return
    //   887: ldc_w 597
    //   890: iconst_2
    //   891: anewarray 4	java/lang/Object
    //   894: dup
    //   895: iconst_0
    //   896: aload 6
    //   898: aastore
    //   899: dup
    //   900: iconst_1
    //   901: aload 7
    //   903: aastore
    //   904: invokestatic 229	com/tencent/tbs/one/impl/base/Logging:i	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   907: goto -243 -> 664
    //   910: ldc_w 599
    //   913: iconst_2
    //   914: anewarray 4	java/lang/Object
    //   917: dup
    //   918: iconst_0
    //   919: aload 6
    //   921: aastore
    //   922: dup
    //   923: iconst_1
    //   924: aload 7
    //   926: aastore
    //   927: invokestatic 229	com/tencent/tbs/one/impl/base/Logging:i	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   930: goto -266 -> 664
    //   933: ldc_w 601
    //   936: iconst_2
    //   937: anewarray 4	java/lang/Object
    //   940: dup
    //   941: iconst_0
    //   942: aload 6
    //   944: aastore
    //   945: dup
    //   946: iconst_1
    //   947: aload 7
    //   949: aastore
    //   950: invokestatic 229	com/tencent/tbs/one/impl/base/Logging:i	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   953: goto -289 -> 664
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	956	0	this	ComponentLoader
    //   164	48	1	i	int
    //   22	578	2	j	int
    //   162	6	3	k	int
    //   73	98	4	localObject1	Object
    //   215	14	4	localTBSOneException1	TBSOneException
    //   276	233	4	localObject2	Object
    //   694	14	4	localTBSOneException2	TBSOneException
    //   716	42	4	localClassNotFoundException	java.lang.ClassNotFoundException
    //   773	42	4	localNoSuchMethodException	java.lang.NoSuchMethodException
    //   830	42	4	localException	java.lang.Exception
    //   64	602	5	localComponentImpl	ComponentImpl
    //   7	936	6	localObject3	Object
    //   13	935	7	str1	String
    //   174	307	8	localContext	Context
    //   273	588	9	str2	String
    //   431	419	10	str3	String
    //   415	215	11	localClassLoader	ClassLoader
    // Exception table:
    //   from	to	target	type
    //   111	120	215	com/tencent/tbs/one/TBSOneException
    //   407	417	694	com/tencent/tbs/one/TBSOneException
    //   627	664	716	java/lang/ClassNotFoundException
    //   627	664	773	java/lang/NoSuchMethodException
    //   627	664	830	java/lang/Exception
  }
  
  private void onDEPSLoaded(Bundle paramBundle, DEPSConfig paramDEPSConfig)
  {
    setProgress(20);
    this.mPolicyManager.getCallerContext();
    String str1 = this.mPolicyManager.getCategory();
    int i = paramDEPSConfig.getVersionCode();
    String str2 = this.mName;
    Logging.i("[%s] {%s} Finished loading DEPS#%d", new Object[] { str1, str2, Integer.valueOf(i) });
    Object localObject = paramDEPSConfig.getComponentConfig(str2);
    if (localObject == null)
    {
      fail(309, "Failed to get info for component " + str2, null);
      return;
    }
    String[] arrayOfString = ((DEPSConfig.ComponentConfig)localObject).getDependencies();
    int j;
    float f;
    if (arrayOfString != null)
    {
      j = arrayOfString.length;
      i = 0;
      while (i < j)
      {
        String str3 = arrayOfString[i];
        if (paramDEPSConfig.getComponentConfig(str3) == null)
        {
          fail(310, "Failed to get info for dependency " + str3, null);
          return;
        }
        i += 1;
      }
      f = 1.0F / (arrayOfString.length + 1);
      ((DEPSConfig.ComponentConfig)localObject).getVersionCode();
      this.mConfig = ((DEPSConfig.ComponentConfig)localObject);
      this.mLastInstallationProgress = 0;
      if (arrayOfString != null) {
        break label340;
      }
    }
    label340:
    for (paramDEPSConfig = "";; paramDEPSConfig = TextUtils.join(", ", arrayOfString))
    {
      Logging.i("[%s] {%s} Installing component and dependencies [%s]", new Object[] { str1, str2, paramDEPSConfig });
      paramDEPSConfig = new CompletionTask();
      paramDEPSConfig.dependsOn(new ComponentLoader.2(this, paramBundle, (DEPSConfig.ComponentConfig)localObject, f, str1, str2));
      localObject = this.mPolicyManager;
      if (arrayOfString == null) {
        break label352;
      }
      j = arrayOfString.length;
      i = 0;
      while (i < j)
      {
        paramDEPSConfig.dependsOn(new ComponentLoader.3(this, (PolicyManager)localObject, paramBundle, arrayOfString[i], f, str1, str2));
        i += 1;
      }
      f = 1.0F;
      break;
    }
    label352:
    paramBundle = new ThreadPoolTaskRunner(AsyncTask.THREAD_POOL_EXECUTOR);
    paramBundle.setListener(this);
    paramBundle.run(paramDEPSConfig);
  }
  
  private void setInstallationProgress(int paramInt1, int paramInt2, float paramFloat)
  {
    if (!ThreadUtils.runningOnCoreThread())
    {
      ThreadUtils.postOnCoreThread(new ComponentLoader.6(this, paramInt1, paramInt2, paramFloat));
      return;
    }
    int j = Math.min(Math.max(0, paramInt1), 100);
    int k = Math.min(Math.max(0, paramInt2), 100);
    int i = this.mLastInstallationProgress;
    float f = i;
    j = (int)((k - j) * paramFloat + f);
    Logging.d("[%s] {%s} Updating installation progress %d to %d, sub: %d -> %d, weight: %f", new Object[] { this.mPolicyManager.getCategory(), this.mName, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Float.valueOf(paramFloat) });
    this.mLastInstallationProgress = j;
    setProgress(j, 20, 90);
  }
  
  private void setProgress(int paramInt)
  {
    Logging.d("[%s] {%s} Updating progress %d to %d", new Object[] { this.mPolicyManager.getCategory(), this.mName, Integer.valueOf(this.mLastProgress), Integer.valueOf(paramInt) });
    if (paramInt - this.mLastProgress > 2)
    {
      int j = this.mLastProgress;
      this.mLastProgress = paramInt;
      TBSOneCallback[] arrayOfTBSOneCallback1 = (TBSOneCallback[])this.mInstallationCallbacks.toArray(new TBSOneCallback[0]);
      TBSOneCallback[] arrayOfTBSOneCallback2 = (TBSOneCallback[])this.mLoadCallbacks.toArray(new TBSOneCallback[0]);
      int k = arrayOfTBSOneCallback1.length;
      int i = 0;
      while (i < k)
      {
        arrayOfTBSOneCallback1[i].onProgressChanged(j, paramInt);
        i += 1;
      }
      k = arrayOfTBSOneCallback2.length;
      i = 0;
      while (i < k)
      {
        arrayOfTBSOneCallback2[i].onProgressChanged(j, paramInt);
        i += 1;
      }
    }
  }
  
  private void start(Bundle paramBundle)
  {
    String str1 = this.mPolicyManager.getCategory();
    String str2 = this.mName;
    if (this.mIsRunning)
    {
      Logging.i("[%s] {%s} Have started loading component", new Object[] { str1, str2 });
      return;
    }
    Logging.i("[%s] {%s} Loading DEPS", new Object[] { str1, str2 });
    this.mIsRunning = true;
    this.mPolicyManager.loadDEPS(paramBundle, new ComponentLoader.1(this, paramBundle));
  }
  
  public ComponentImpl getComponent()
  {
    return this.mComponent;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public void install(Bundle paramBundle, TBSOneCallback<File> paramTBSOneCallback)
  {
    if (this.mInstallationDirectory != null)
    {
      Logging.i("[%s] {%s} Installed component at %s", new Object[] { this.mPolicyManager.getCategory(), this.mName, this.mInstallationDirectory });
      if (paramTBSOneCallback != null)
      {
        paramTBSOneCallback.onProgressChanged(0, 100);
        paramTBSOneCallback.onCompleted(this.mInstallationDirectory);
      }
      return;
    }
    if (paramTBSOneCallback != null)
    {
      paramTBSOneCallback.onProgressChanged(0, this.mLastProgress);
      this.mInstallationCallbacks.add(paramTBSOneCallback);
    }
    start(paramBundle);
  }
  
  public boolean isLoading()
  {
    return (this.mIsRunning) && (this.mInstallationDirectory == null);
  }
  
  public void load(Bundle paramBundle, TBSOneCallback<TBSOneComponent> paramTBSOneCallback)
  {
    if (this.mComponent != null)
    {
      Logging.i("[%s] {%s} Loaded component %s", new Object[] { this.mPolicyManager.getCategory(), this.mName, this.mComponent });
      if (paramTBSOneCallback != null)
      {
        paramTBSOneCallback.onProgressChanged(0, 100);
        paramTBSOneCallback.onCompleted(this.mComponent);
      }
      return;
    }
    if (paramTBSOneCallback != null)
    {
      paramTBSOneCallback.onProgressChanged(0, this.mLastProgress);
      this.mLoadCallbacks.add(paramTBSOneCallback);
    }
    if (this.mInstallationDirectory != null)
    {
      initializeComponent();
      return;
    }
    start(paramBundle);
  }
  
  public void onError(int paramInt, String paramString, Throwable paramThrowable)
  {
    ThreadUtils.runOnCoreThread(new ComponentLoader.4(this, paramInt, paramString, paramThrowable));
  }
  
  public void onFinished()
  {
    String str = this.mName;
    Logging.i("[%s] {%s} Finished installing component and dependencies", new Object[] { this.mPolicyManager.getCategory(), str });
    ThreadUtils.runOnCoreThread(new ComponentLoader.5(this, str));
  }
  
  public void setProgress(int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = Math.min(Math.max(0, paramInt1), 100);
    float f = paramInt2;
    setProgress((int)(paramInt1 / 100.0F * (paramInt3 - paramInt2) + f));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.loader.ComponentLoader
 * JD-Core Version:    0.7.0.1
 */
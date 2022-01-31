package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.libwebp;
import com.tencent.smtt.utils.AppUtil;
import com.tencent.smtt.utils.TbsCheckUtils;
import com.tencent.smtt.utils.TbsLog;
import java.util.Map;

class TbsWizard
{
  private static final String TAG = "TbsWizard";
  static final String WEBCOREPROXY_CLASSNAME = "com.tencent.tbs.tbsshell.WebCoreProxy";
  private String loadFailureDetails = null;
  private Context mCallerAppContext = null;
  private String[] mDexFileList = null;
  private DexLoader mDexLoader = null;
  private String mDexOptPath = "TbsDexOpt";
  private Context mHostContext = null;
  private String mtbsInstallLocation = null;
  
  public TbsWizard(Context paramContext1, Context paramContext2, String paramString1, String paramString2, String[] paramArrayOfString, String paramString3, TbsInitPerformanceRecorder paramTbsInitPerformanceRecorder)
  {
    TbsLog.i("TbsWizard", "construction start...");
    if ((paramContext1 == null) || ((paramContext2 == null) && (TbsShareManager.getHostCorePathAppDefined() == null)) || (TextUtils.isEmpty(paramString1)) || (paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      throw new Exception("TbsWizard paramter error:-1callerContext:" + paramContext1 + "hostcontext" + paramContext2 + "isEmpty" + TextUtils.isEmpty(paramString1) + "dexfileList" + paramArrayOfString);
    }
    this.mCallerAppContext = paramContext1.getApplicationContext();
    if (paramContext2.getApplicationContext() != null) {}
    for (this.mHostContext = paramContext2.getApplicationContext();; this.mHostContext = paramContext2)
    {
      this.mtbsInstallLocation = paramString1;
      this.mDexFileList = paramArrayOfString;
      this.mDexOptPath = paramString2;
      if (paramTbsInitPerformanceRecorder != null) {
        paramTbsInitPerformanceRecorder.recordPerformanceEvent("load_tbs_dex", (byte)1);
      }
      i = 0;
      while (i < this.mDexFileList.length)
      {
        TbsLog.i("TbsWizard", "#2 mDexFileList[" + i + "]: " + this.mDexFileList[i]);
        i += 1;
      }
    }
    TbsLog.i("TbsWizard", "new DexLoader #2 libraryPath is " + paramString3 + " mCallerAppContext is " + this.mCallerAppContext + " dexOutPutDir is " + paramString2);
    this.mDexLoader = new DexLoader(paramString3, this.mCallerAppContext, this.mDexFileList, paramString2, QbSdk.mSettings);
    System.currentTimeMillis();
    checkTbsValidityIfNecessary(paramContext1);
    if (paramTbsInitPerformanceRecorder != null) {
      paramTbsInitPerformanceRecorder.recordPerformanceEvent("load_tbs_dex", (byte)2);
    }
    libwebp.loadWepLibraryIfNeed(paramContext2, this.mtbsInstallLocation);
    if ("com.nd.android.pandahome2".equals(this.mCallerAppContext.getApplicationInfo().packageName))
    {
      paramContext2 = this.mDexLoader;
      paramString1 = this.mCallerAppContext;
      paramContext2.invokeStaticMethod("com.tencent.tbs.common.beacon.X5CoreBeaconUploader", "getInstance", new Class[] { Context.class }, new Object[] { paramString1 });
    }
    if (QbSdk.mSettings != null) {
      bool1 = false;
    }
    try
    {
      bool2 = TbsPVConfig.getInstance(this.mCallerAppContext).getTbsCoreSandboxModeEnable();
      bool1 = bool2;
    }
    catch (Throwable paramContext2)
    {
      boolean bool2;
      label442:
      break label442;
    }
    int i = 0;
    try
    {
      bool2 = "true".equals(String.valueOf(QbSdk.mSettings.get("use_sandbox")));
      if (bool2) {
        i = 1;
      }
    }
    catch (Throwable paramContext2)
    {
      for (;;)
      {
        paramContext2.printStackTrace();
        continue;
        bool1 = false;
      }
      TbsLog.i("TbsWizard", "construction end...");
      return;
    }
    paramContext2 = QbSdk.mSettings;
    if ((bool1) && (i != 0))
    {
      bool1 = true;
      paramContext2.put("use_sandbox", Boolean.valueOf(bool1));
      paramContext2 = this.mDexLoader;
      paramString1 = QbSdk.mSettings;
      paramContext2.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTbsSettings", new Class[] { Map.class }, new Object[] { paramString1 });
      if (paramTbsInitPerformanceRecorder != null) {
        paramTbsInitPerformanceRecorder.recordPerformanceEvent("init_tbs", (byte)1);
      }
      i = init(paramContext1);
      if (paramTbsInitPerformanceRecorder != null) {
        paramTbsInitPerformanceRecorder.recordPerformanceEvent("init_tbs", (byte)2);
      }
      if (i >= 0) {
        break label631;
      }
      throw new Exception("TbsWizard init error: " + i + "; msg: " + this.loadFailureDetails);
    }
  }
  
  public TbsWizard(Context paramContext1, Context paramContext2, String paramString1, String paramString2, String[] paramArrayOfString, String paramString3, TbsInitPerformanceRecorder paramTbsInitPerformanceRecorder, String paramString4)
  {
    this.mCallerAppContext = paramContext1.getApplicationContext();
    if (paramContext2.getApplicationContext() != null) {}
    for (this.mHostContext = paramContext2.getApplicationContext();; this.mHostContext = paramContext2)
    {
      this.mtbsInstallLocation = paramString1;
      this.mDexFileList = paramArrayOfString;
      this.mDexOptPath = paramString2;
      int i = 0;
      while (i < this.mDexFileList.length)
      {
        TbsLog.i("TbsWizard", "#1 mDexFileList[" + i + "]: " + this.mDexFileList[i]);
        i += 1;
      }
    }
    TbsLog.i("TbsWizard", "new DexLoader #1 libraryPath is " + paramString3 + " mCallerAppContext is " + this.mCallerAppContext + " dexOutPutDir is " + paramString2);
    this.mDexLoader = new DexLoader(paramString3, this.mCallerAppContext, this.mDexFileList, paramString2, QbSdk.mSettings);
    TbsLog.i("TbsWizard", "initTesRuntimeEnvironmentAndNotLoadSo callerContext is " + paramContext1 + " mHostContext is " + this.mHostContext + " mDexLoader is " + this.mDexLoader + " mtbsInstallLocation is " + this.mtbsInstallLocation + " mDexOptPath is " + this.mDexOptPath);
    paramContext2 = this.mDexLoader;
    paramString1 = Integer.TYPE;
    paramString2 = this.mHostContext;
    paramArrayOfString = this.mDexLoader;
    paramString3 = this.mtbsInstallLocation;
    paramTbsInitPerformanceRecorder = this.mDexOptPath;
    paramString4 = QbSdk.getTbsCoreVersionString();
    paramContext2.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironmentAndNotLoadSo", new Class[] { Context.class, Context.class, DexLoader.class, String.class, String.class, String.class, paramString1, String.class }, new Object[] { paramContext1, paramString2, paramArrayOfString, paramString3, paramTbsInitPerformanceRecorder, "4.3.0.1203", Integer.valueOf(43752), paramString4 });
  }
  
  private int init(Context paramContext)
  {
    Object localObject1 = this.mDexLoader;
    Object localObject2 = AppUtil.mImei;
    Object localObject3 = AppUtil.mImsi;
    Object localObject4 = AppUtil.mCpu;
    String str1 = AppUtil.mMac;
    ((DexLoader)localObject1).invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "putInfo", new Class[] { Context.class, String.class, String.class, String.class, String.class }, new Object[] { paramContext, localObject2, localObject3, localObject4, str1 });
    String str2;
    String str3;
    int i;
    if ((this.mHostContext == null) && (TbsShareManager.getHostCorePathAppDefined() != null))
    {
      localObject1 = this.mDexLoader;
      localObject2 = Integer.TYPE;
      localObject3 = this.mHostContext;
      localObject4 = this.mDexLoader;
      str1 = this.mtbsInstallLocation;
      str2 = this.mDexOptPath;
      str3 = QbSdk.getTbsCoreVersionString();
      String str4 = TbsShareManager.getHostCorePathAppDefined();
      localObject1 = ((DexLoader)localObject1).invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[] { Context.class, Context.class, DexLoader.class, String.class, String.class, String.class, localObject2, String.class, String.class }, new Object[] { paramContext, localObject3, localObject4, str1, str2, "4.3.0.1203", Integer.valueOf(43752), str3, str4 });
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        setSdkVersionNameInTbsShell();
        setSdkVersionInTbsShell();
        localObject1 = this.mDexLoader;
        localObject2 = this.mHostContext;
        localObject3 = this.mDexLoader;
        localObject4 = this.mtbsInstallLocation;
        str1 = this.mDexOptPath;
        localObject2 = ((DexLoader)localObject1).invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[] { Context.class, Context.class, DexLoader.class, String.class, String.class }, new Object[] { paramContext, localObject2, localObject3, localObject4, str1 });
      }
      if (localObject2 != null) {
        break label712;
      }
      i = -3;
    }
    for (;;)
    {
      if (i >= 0) {
        break label770;
      }
      paramContext = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "getLoadFailureDetails", new Class[0], new Object[0]);
      if ((paramContext instanceof Throwable))
      {
        localObject1 = (Throwable)paramContext;
        this.loadFailureDetails = ("#" + ((Throwable)localObject1).getMessage() + "; cause: " + ((Throwable)localObject1).getCause() + "; th: " + localObject1);
      }
      if ((paramContext instanceof String)) {
        this.loadFailureDetails = ((String)paramContext);
      }
      return i;
      TbsLog.i("TbsWizard", "initTesRuntimeEnvironment callerContext is " + paramContext + " mHostContext is " + this.mHostContext + " mDexLoader is " + this.mDexLoader + " mtbsInstallLocation is " + this.mtbsInstallLocation + " mDexOptPath is " + this.mDexOptPath);
      localObject1 = this.mDexLoader;
      localObject2 = Integer.TYPE;
      localObject3 = this.mHostContext;
      localObject4 = this.mDexLoader;
      str1 = this.mtbsInstallLocation;
      str2 = this.mDexOptPath;
      str3 = QbSdk.getTbsCoreVersionString();
      localObject1 = ((DexLoader)localObject1).invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[] { Context.class, Context.class, DexLoader.class, String.class, String.class, String.class, localObject2, String.class }, new Object[] { paramContext, localObject3, localObject4, str1, str2, "4.3.0.1203", Integer.valueOf(43752), str3 });
      break;
      label712:
      if ((localObject2 instanceof Integer))
      {
        i = ((Integer)localObject2).intValue();
      }
      else if ((localObject2 instanceof Throwable))
      {
        TbsCoreLoadStat.getInstance().setLoadErrorCode(this.mCallerAppContext, 328, (Throwable)localObject2);
        i = -5;
      }
      else
      {
        i = -4;
      }
    }
    label770:
    this.loadFailureDetails = null;
    return i;
  }
  
  private void setSdkVersionInTbsShell()
  {
    this.mDexLoader.setStaticField("com.tencent.tbs.tbsshell.TBSShell", "VERSION", Integer.valueOf(43752));
  }
  
  private void setSdkVersionNameInTbsShell()
  {
    this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "setTesSdkVersionName", new Class[] { String.class }, new Object[] { "4.3.0.1203" });
  }
  
  void checkTbsValidityIfNecessary(Context paramContext)
  {
    Object localObject = QbSdk.mSettings;
    if (localObject != null)
    {
      localObject = ((Map)localObject).get("check_tbs_validity");
      if (!(localObject instanceof Boolean)) {}
    }
    for (boolean bool = ((Boolean)localObject).booleanValue();; bool = true)
    {
      if (bool) {
        TbsCheckUtils.checkTbsValidity(paramContext);
      }
      return;
    }
  }
  
  public void continueInit(Context paramContext1, Context paramContext2, String paramString1, String paramString2, String[] paramArrayOfString, String paramString3, TbsInitPerformanceRecorder paramTbsInitPerformanceRecorder)
  {
    this.mCallerAppContext = paramContext1.getApplicationContext();
    if (this.mHostContext.getApplicationContext() != null) {
      this.mHostContext = this.mHostContext.getApplicationContext();
    }
    this.mtbsInstallLocation = paramString1;
    this.mDexFileList = paramArrayOfString;
    this.mDexOptPath = paramString2;
    libwebp.loadWepLibraryIfNeed(paramContext2, this.mtbsInstallLocation);
    if (QbSdk.mSettings != null)
    {
      paramContext2 = this.mDexLoader;
      paramString1 = QbSdk.mSettings;
      paramContext2.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTbsSettings", new Class[] { Map.class }, new Object[] { paramString1 });
    }
    int i = init(paramContext1);
    if (i < 0) {
      throw new Exception("continueInit init error: " + i + "; msg: " + this.loadFailureDetails);
    }
  }
  
  public Object createGamePlayer(Context paramContext)
  {
    Object localObject = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createGamePlayer", new Class[] { Context.class }, new Object[] { paramContext });
    paramContext = localObject;
    if (localObject == null) {
      paramContext = null;
    }
    return paramContext;
  }
  
  public Object createGamePlayerClientExtensionHost(Object paramObject)
  {
    Object localObject = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createGamePlayerClientExtensionHost", new Class[] { Object.class }, new Object[] { paramObject });
    paramObject = localObject;
    if (localObject == null) {
      paramObject = null;
    }
    return paramObject;
  }
  
  public Object createGamePlayerClientHost(Object paramObject)
  {
    Object localObject = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createGamePlayerClientHost", new Class[] { Object.class }, new Object[] { paramObject });
    paramObject = localObject;
    if (localObject == null) {
      paramObject = null;
    }
    return paramObject;
  }
  
  public Object createGamePlayerServiceHost(Object paramObject)
  {
    Object localObject = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createGamePlayerServiceHost", new Class[] { Object.class }, new Object[] { paramObject });
    paramObject = localObject;
    if (localObject == null) {
      paramObject = null;
    }
    return paramObject;
  }
  
  public DexLoader dexLoader()
  {
    return this.mDexLoader;
  }
  
  public String getCrashExtraMessage()
  {
    String str = null;
    Object localObject2 = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "invokeStaticMethod", new Class[] { Boolean.TYPE, String.class, String.class, [Ljava.lang.Class.class, [Ljava.lang.Object.class }, new Object[] { Boolean.valueOf(true), "com.tencent.smtt.util.CrashTracker", "getCrashExtraInfo", null, new Object[0] });
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.mDexLoader.invokeStaticMethod("com.tencent.smtt.util.CrashTracker", "getCrashExtraInfo", null, new Object[0]);
    }
    if (localObject1 != null)
    {
      str = String.valueOf(localObject1);
      str = str + " ReaderPackName=" + TbsReaderView.gReaderPackName + " ReaderPackVersion=" + TbsReaderView.gReaderPackVersion;
    }
    localObject1 = str;
    if (str == null) {
      localObject1 = "X5 core get nothing...";
    }
    return localObject1;
  }
  
  public boolean installLocalQbApk(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
  {
    paramContext = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "installLocalQbApk", new Class[] { Context.class, String.class, String.class, Bundle.class }, new Object[] { paramContext, paramString1, paramString2, paramBundle });
    if (paramContext == null) {
      return false;
    }
    return ((Boolean)paramContext).booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsWizard
 * JD-Core Version:    0.7.0.1
 */
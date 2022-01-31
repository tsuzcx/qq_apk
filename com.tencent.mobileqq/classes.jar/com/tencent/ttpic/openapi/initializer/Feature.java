package com.tencent.ttpic.openapi.initializer;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.AEOpenRenderConfig;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.baseutils.io.FileUtils.AssetFileComparator;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.initializer.so.SoDependencyUtil;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public abstract class Feature
  implements Destroyable, Initializable
{
  private static final String TAG = "AEKitFeature";
  private Object initLock = new Object();
  protected boolean isInited = false;
  protected boolean isSoFilesLoaded = false;
  private String pendingErrorMessage = "";
  private String resourceDirOverrideFeatureManager;
  private String soDirOverrideFeatureManager;
  
  private boolean checkAssetsFileExist(ModelInfo paramModelInfo)
  {
    if (AEModule.getContext() == null) {}
    for (;;)
    {
      return true;
      Object localObject = trimEnd(paramModelInfo.getAssetsDir());
      AssetManager localAssetManager = AEModule.getContext().getAssets();
      try
      {
        localObject = localAssetManager.list((String)localObject);
        int j = localObject.length;
        int i = 0;
        for (;;)
        {
          if (i >= j) {
            break label83;
          }
          boolean bool = localObject[i].equals(paramModelInfo.fileName);
          if (bool) {
            break;
          }
          i += 1;
        }
        return false;
      }
      catch (IOException paramModelInfo)
      {
        paramModelInfo.printStackTrace();
        setPendingErrorMessage(paramModelInfo);
        return false;
      }
    }
  }
  
  private boolean containsLib(String[] paramArrayOfString, String paramString)
  {
    boolean bool2 = false;
    int j = paramArrayOfString.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramArrayOfString[i].equals(paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private boolean copyAssetsModelsToLocalPath(List<ModelInfo> paramList)
  {
    return copyModelsToLocalPath(getFinalResourcesDir(), paramList);
  }
  
  private boolean copyModelsToLocalPath(String paramString, List<ModelInfo> paramList)
  {
    paramList = paramList.iterator();
    boolean bool1 = true;
    ModelInfo localModelInfo;
    String str;
    while (paramList.hasNext())
    {
      localModelInfo = (ModelInfo)paramList.next();
      if ((!isExternalResources()) && (localModelInfo.isMustUseSDCardPath()))
      {
        if (AEModule.getContext() == null) {
          return false;
        }
        str = paramString + File.separator + localModelInfo.fileName;
        File localFile = new File(str);
        if ((!localFile.exists()) || (localFile.isDirectory()) || (!FileUtils.SIMPLE_ASSET_MD5_COMPARATOR.equals(AEModule.getContext(), localModelInfo.getFullAssetsPathNoPrefix(), localFile))) {
          break label236;
        }
      }
    }
    label236:
    for (int i = 0;; i = 1)
    {
      if (i != 0) {
        LogUtils.i("AEKitFeature", "copy resource: " + str);
      }
      for (boolean bool2 = FileUtils.copyAssets(AEModule.getContext(), localModelInfo.getFullAssetsPathNoPrefix(), str);; bool2 = true)
      {
        AEOpenRenderConfig.checkStrictMode(bool2, "copy res file failed: " + localModelInfo.getFullAssetsPathNoPrefix());
        if ((bool1) && (bool2)) {}
        for (bool1 = true;; bool1 = false) {
          break;
        }
        return bool1;
      }
    }
  }
  
  private String getDefaultCopyAssetsDir()
  {
    try
    {
      Object localObject = AEModule.getContext();
      localObject = ((Context)localObject).getExternalFilesDir(null).getPath() + File.separator + "Tencent" + File.separator + "aekit";
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      setPendingErrorMessage(localException);
    }
    return null;
  }
  
  protected static String getFullLibname(String paramString)
  {
    return "lib" + paramString + ".so";
  }
  
  private boolean hasSoFiles()
  {
    return getSharedLibraries() != null;
  }
  
  private boolean isVersionOK(SharedLibraryInfo paramSharedLibraryInfo)
  {
    if (!FeatureManager.isEnableResourceCheck()) {}
    String str1;
    String str2;
    do
    {
      do
      {
        return true;
      } while ((!isExternalSoLoad()) || (TextUtils.isEmpty(paramSharedLibraryInfo.sha1)));
      str1 = FileUtils.getSHA1(new File(getFinalSoDir(), paramSharedLibraryInfo.getFullLibName()).getPath());
      str2 = paramSharedLibraryInfo.sha1;
      AEOpenRenderConfig.checkStrictMode(str1.equals(str2), "so sha1 check failed: " + paramSharedLibraryInfo.getFullLibName());
    } while (str1.equals(str2));
    return false;
  }
  
  private boolean systemLoadLibrarySafely(String paramString)
  {
    try
    {
      System.loadLibrary(paramString);
      return true;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      setPendingErrorMessage(paramString);
      return false;
    }
    catch (Error paramString)
    {
      label7:
      break label7;
    }
  }
  
  private boolean systemLoadSafely(String paramString, SharedLibraryInfo paramSharedLibraryInfo)
  {
    try
    {
      paramString = new File(paramString, paramSharedLibraryInfo.getFullLibName());
      if ((FeatureManager.isEnableResourceCheck()) && (!isVersionOK(paramSharedLibraryInfo))) {
        return false;
      }
      System.load(paramString.getPath());
      return true;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      setPendingErrorMessage(paramString);
      return false;
    }
    catch (Error paramString)
    {
      label39:
      break label39;
    }
  }
  
  private String trimEnd(String paramString)
  {
    String str = paramString;
    if (paramString.endsWith(File.separator)) {
      str = paramString.substring(0, paramString.length() - 1);
    }
    return str;
  }
  
  protected boolean checkAllResourcesFilesValid()
  {
    Object localObject = getModelInfos();
    boolean bool3;
    if ((localObject == null) || (((List)localObject).size() == 0))
    {
      bool3 = true;
      return bool3;
    }
    localObject = getModelInfos().iterator();
    boolean bool2 = true;
    ModelInfo localModelInfo;
    for (;;)
    {
      bool3 = bool2;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localModelInfo = (ModelInfo)((Iterator)localObject).next();
      if (!isModelFileInAssets(localModelInfo)) {
        break label110;
      }
      bool3 = checkAssetsFileExist(localModelInfo);
      AEOpenRenderConfig.checkStrictMode(bool3, "file not found: " + localModelInfo);
      bool2 &= bool3;
    }
    label110:
    File localFile = new File(getFinalResourcesDir(), localModelInfo.fileName);
    AEOpenRenderConfig.checkStrictMode(localFile.exists(), "file " + localModelInfo + " not found in " + getFinalResourcesDir());
    boolean bool1;
    if (!localFile.exists()) {
      bool1 = false;
    }
    for (;;)
    {
      bool2 = bool1 & bool2;
      break;
      if ((localModelInfo.getFileSizeInBytes() > 0) && (localFile.length() != localModelInfo.getFileSizeInBytes()))
      {
        AEOpenRenderConfig.checkStrictMode(localFile.exists(), "file " + localModelInfo + " size error: " + localFile.length() + " != " + localModelInfo.getFileSizeInBytes() + "(expected)");
        bool1 = false;
      }
      else
      {
        bool1 = true;
      }
    }
  }
  
  protected boolean checkAllSoFilesExists()
  {
    boolean bool2 = false;
    boolean bool1;
    if ((getSharedLibraries() == null) || (getSharedLibraries().size() == 0))
    {
      bool1 = true;
      return bool1;
    }
    label110:
    Object localObject2;
    if ((TextUtils.isEmpty(FeatureManager.getSoDir())) && (TextUtils.isEmpty(getSoDirOverrideFeatureManager())))
    {
      if (AEModule.getContext() != null) {}
      for (bool1 = true;; bool1 = false)
      {
        AEOpenRenderConfig.checkStrictMode(bool1, "AEModule context is null");
        bool1 = bool2;
        if (AEModule.getContext() == null) {
          break;
        }
        localObject1 = new File(AEModule.getContext().getApplicationInfo().nativeLibraryDir).list();
        if ((localObject1 != null) && (localObject1.length != 0)) {
          break label110;
        }
        AEOpenRenderConfig.checkStrictMode(false, "so load failed: no libs in apk");
        return false;
      }
      localObject2 = getSharedLibraries().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        SharedLibraryInfo localSharedLibraryInfo = (SharedLibraryInfo)((Iterator)localObject2).next();
        if (!containsLib((String[])localObject1, getFullLibname(localSharedLibraryInfo.fileName)))
        {
          AEOpenRenderConfig.checkStrictMode(false, "so load failed: " + localSharedLibraryInfo + " not found in apk");
          return false;
        }
      }
      return true;
    }
    Object localObject1 = getSharedLibraries().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (SharedLibraryInfo)((Iterator)localObject1).next();
      if (!new File(getFinalSoDir(), getFullLibname(((SharedLibraryInfo)localObject2).fileName)).exists())
      {
        AEOpenRenderConfig.checkStrictMode(false, "so load failed: " + localObject2 + " not found in " + getFinalSoDir());
        return false;
      }
    }
    return true;
  }
  
  public boolean destroy()
  {
    if (!destroyImpl()) {}
    for (boolean bool = true;; bool = false)
    {
      this.isInited = bool;
      return true;
    }
  }
  
  protected abstract boolean destroyImpl();
  
  public String getFinalResourcesDir()
  {
    if ((TextUtils.isEmpty(FeatureManager.getResourceDir())) && (TextUtils.isEmpty(getResourceDirOverrideFeatureManager())))
    {
      File localFile = new File(getDefaultCopyAssetsDir(), getName());
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      return localFile.getPath();
    }
    if (!TextUtils.isEmpty(getResourceDirOverrideFeatureManager())) {
      return getResourceDirOverrideFeatureManager();
    }
    return FeatureManager.getResourceDir();
  }
  
  public String getFinalSoDir()
  {
    if (!isExternalSoLoad()) {
      return null;
    }
    if (!TextUtils.isEmpty(getSoDirOverrideFeatureManager())) {
      return getSoDirOverrideFeatureManager();
    }
    return FeatureManager.getSoDir();
  }
  
  protected String getModelFinalPath(ModelInfo paramModelInfo)
  {
    if (isModelFileInAssets(paramModelInfo)) {
      return paramModelInfo.getFullAssetsPathWithPrefix();
    }
    return new File(getFinalResourcesDir(), paramModelInfo.getFileName()).getPath();
  }
  
  public abstract List<ModelInfo> getModelInfos();
  
  public abstract String getName();
  
  public String getPendingErrorMessage()
  {
    return this.pendingErrorMessage;
  }
  
  public String getResourceDirOverrideFeatureManager()
  {
    return this.resourceDirOverrideFeatureManager;
  }
  
  public abstract List<SharedLibraryInfo> getSharedLibraries();
  
  public String getSoDirOverrideFeatureManager()
  {
    return this.soDirOverrideFeatureManager;
  }
  
  public boolean hasError()
  {
    return !TextUtils.isEmpty(this.pendingErrorMessage);
  }
  
  public boolean init()
  {
    if (!this.isInited) {}
    synchronized (this.initLock)
    {
      boolean bool3 = this.isInited;
      if (!bool3) {}
      try
      {
        setPendingErrorMessage(null);
        boolean bool2 = true & copyAssetsModelsToLocalPath(getModelInfos());
        boolean bool1 = bool2;
        if (FeatureManager.isEnableResourceCheck()) {
          bool1 = bool2 & checkAllResourcesFilesValid();
        }
        this.isInited = (bool1 & initImpl());
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        for (;;)
        {
          AEOpenRenderConfig.checkStrictMode(false, localUnsatisfiedLinkError.toString());
          setPendingErrorMessage(localUnsatisfiedLinkError);
          this.isInited = false;
        }
      }
      LogUtils.i("AEKitFeature", "AEKitFeature:" + getName() + " init result = " + this.isInited);
      return this.isInited;
    }
  }
  
  protected abstract boolean initImpl();
  
  public boolean isAllSoVersionOk()
  {
    if (CollectionUtils.isEmpty(getSharedLibraries())) {
      return true;
    }
    Iterator localIterator = getSharedLibraries().iterator();
    while (localIterator.hasNext()) {
      if (!isVersionOK((SharedLibraryInfo)localIterator.next())) {
        return false;
      }
    }
    return true;
  }
  
  public boolean isExternalResources()
  {
    return (!TextUtils.isEmpty(FeatureManager.getResourceDir())) || (!TextUtils.isEmpty(getResourceDirOverrideFeatureManager()));
  }
  
  public boolean isExternalSoLoad()
  {
    return (!TextUtils.isEmpty(FeatureManager.getSoDir())) || (!TextUtils.isEmpty(getSoDirOverrideFeatureManager()));
  }
  
  public boolean isFunctionReady()
  {
    return this.isInited;
  }
  
  protected boolean isModelFileInAssets(ModelInfo paramModelInfo)
  {
    return (!isExternalResources()) && (!paramModelInfo.isMustUseSDCardPath());
  }
  
  public boolean isModelReadyInDirectory(String paramString)
  {
    if ((getModelInfos() == null) || (getModelInfos().size() == 0)) {
      return true;
    }
    Iterator localIterator = getModelInfos().iterator();
    while (localIterator.hasNext()) {
      if (!new File(paramString, ((ModelInfo)localIterator.next()).fileName).exists()) {
        return false;
      }
    }
    return true;
  }
  
  public boolean isResourceReady()
  {
    return (checkAllSoFilesExists()) && (checkAllResourcesFilesValid());
  }
  
  public boolean isResourceReady(String paramString1, String paramString2)
  {
    return (isSoReadyInDirectory(paramString1)) && (isModelReadyInDirectory(paramString2));
  }
  
  public boolean isSoFilesLoaded()
  {
    return this.isSoFilesLoaded;
  }
  
  public boolean isSoReadyInDirectory(String paramString)
  {
    if ((getSharedLibraries() == null) || (getSharedLibraries().size() == 0)) {
      return true;
    }
    Iterator localIterator = getSharedLibraries().iterator();
    while (localIterator.hasNext()) {
      if (!new File(paramString, getFullLibname(((SharedLibraryInfo)localIterator.next()).fileName)).exists()) {
        return false;
      }
    }
    return true;
  }
  
  protected boolean loadAllSoFiles()
  {
    if (!checkAllSoFilesExists()) {
      return false;
    }
    this.isSoFilesLoaded = true;
    Iterator localIterator = getSharedLibraries().iterator();
    while (localIterator.hasNext())
    {
      SharedLibraryInfo localSharedLibraryInfo = (SharedLibraryInfo)localIterator.next();
      boolean bool = loadSoFile(localSharedLibraryInfo);
      AEOpenRenderConfig.checkStrictMode(bool, "so load failed: " + localSharedLibraryInfo);
      if (!bool)
      {
        LogUtils.i("AEKitFeature", "so load failed: " + localSharedLibraryInfo);
        this.isSoFilesLoaded = false;
      }
    }
    return this.isSoFilesLoaded;
  }
  
  protected boolean loadSoFile(SharedLibraryInfo paramSharedLibraryInfo)
  {
    if (!hasSoFiles()) {
      return true;
    }
    if (!isExternalSoLoad()) {
      return systemLoadLibrarySafely(paramSharedLibraryInfo.fileName);
    }
    String str = FileUtils.genSeperateFileDir(FeatureManager.getSoDir());
    if (!TextUtils.isEmpty(getSoDirOverrideFeatureManager())) {
      str = FileUtils.genSeperateFileDir(getSoDirOverrideFeatureManager());
    }
    for (;;)
    {
      Object localObject = SoDependencyUtil.getDependencies(str, paramSharedLibraryInfo.getFullLibName());
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          if ((new File(str, (String)((Iterator)localObject).next()).exists()) && (!systemLoadSafely(str, new SharedLibraryInfo(paramSharedLibraryInfo.fileName)))) {
            return false;
          }
        }
      }
      return systemLoadSafely(str, paramSharedLibraryInfo);
    }
  }
  
  public boolean reloadModel()
  {
    return true;
  }
  
  protected void setPendingErrorMessage(Throwable paramThrowable)
  {
    if (paramThrowable == null)
    {
      this.pendingErrorMessage = "";
      return;
    }
    this.pendingErrorMessage = Log.getStackTraceString(paramThrowable);
  }
  
  public void setResourceDirOverrideFeatureManager(String paramString)
  {
    this.resourceDirOverrideFeatureManager = paramString;
  }
  
  public void setSoDirOverrideFeatureManager(String paramString)
  {
    this.soDirOverrideFeatureManager = paramString;
  }
  
  public String toString()
  {
    return "Initializer(" + getName() + ", init=" + this.isInited + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.initializer.Feature
 * JD-Core Version:    0.7.0.1
 */
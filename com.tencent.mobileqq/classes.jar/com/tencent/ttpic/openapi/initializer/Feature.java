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
  protected volatile boolean isInited = false;
  protected boolean isSoFilesLoaded = false;
  private String pendingErrorMessage = "";
  private String resourceDirOverrideFeatureManager;
  private String soDirOverrideFeatureManager;
  
  private boolean checkAssetsFileExist(ModelInfo paramModelInfo)
  {
    if (AEModule.getContext() == null) {
      return true;
    }
    Object localObject = trimEnd(paramModelInfo.getAssetsDir());
    AssetManager localAssetManager = AEModule.getContext().getAssets();
    try
    {
      localObject = localAssetManager.list((String)localObject);
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        boolean bool = localObject[i].equals(paramModelInfo.fileName);
        if (bool) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    catch (IOException paramModelInfo)
    {
      paramModelInfo.printStackTrace();
      setPendingErrorMessage(paramModelInfo);
    }
  }
  
  private boolean containsLib(String[] paramArrayOfString, String paramString)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (paramArrayOfString[i].equals(paramString)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private boolean copyModelsToLocalPath(String paramString, List<ModelInfo> paramList)
  {
    paramList = paramList.iterator();
    for (boolean bool1 = true;; bool1 = false)
    {
      ModelInfo localModelInfo;
      do
      {
        if (!paramList.hasNext()) {
          break;
        }
        localModelInfo = (ModelInfo)paramList.next();
      } while ((isExternalResources()) || (!localModelInfo.isMustUseSDCardPath()));
      if (AEModule.getContext() == null) {
        return false;
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(File.separator);
      ((StringBuilder)localObject1).append(localModelInfo.fileName);
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject2 = new File((String)localObject1);
      int i;
      if ((((File)localObject2).exists()) && (!((File)localObject2).isDirectory()) && (FileUtils.SIMPLE_ASSET_MD5_COMPARATOR.equals(AEModule.getContext(), localModelInfo.getFullAssetsPathNoPrefix(), (File)localObject2))) {
        i = 0;
      } else {
        i = 1;
      }
      boolean bool2;
      if (i != 0)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("copy resource: ");
        ((StringBuilder)localObject2).append((String)localObject1);
        LogUtils.i("AEKitFeature", ((StringBuilder)localObject2).toString());
        bool2 = FileUtils.copyAssets(AEModule.getContext(), localModelInfo.getFullAssetsPathNoPrefix(), (String)localObject1);
      }
      else
      {
        bool2 = true;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("copy res file failed: ");
      ((StringBuilder)localObject1).append(localModelInfo.getFullAssetsPathNoPrefix());
      AEOpenRenderConfig.checkStrictMode(bool2, ((StringBuilder)localObject1).toString());
      if ((bool1) && (bool2)) {
        break;
      }
    }
    return bool1;
  }
  
  private String getDefaultCopyAssetsDir()
  {
    try
    {
      Object localObject = AEModule.getContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((Context)localObject).getExternalFilesDir(null).getPath());
      localStringBuilder.append(File.separator);
      localStringBuilder.append("Tencent");
      localStringBuilder.append(File.separator);
      localStringBuilder.append("aekit");
      localObject = localStringBuilder.toString();
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("lib");
    localStringBuilder.append(paramString);
    localStringBuilder.append(".so");
    return localStringBuilder.toString();
  }
  
  private boolean hasSoFiles()
  {
    return getSharedLibraries() != null;
  }
  
  private boolean isVersionOK(SharedLibraryInfo paramSharedLibraryInfo)
  {
    if (!FeatureManager.isEnableResourceCheck()) {
      return true;
    }
    if (!isExternalSoLoad()) {
      return true;
    }
    if (TextUtils.isEmpty(paramSharedLibraryInfo.sha1)) {
      return true;
    }
    String str1 = FileUtils.getSHA1(new File(getFinalSoDir(), paramSharedLibraryInfo.getFullLibName()).getPath());
    String str2 = paramSharedLibraryInfo.sha1;
    boolean bool = str1.equals(str2);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("so sha1 check failed: ");
    localStringBuilder.append(paramSharedLibraryInfo.getFullLibName());
    AEOpenRenderConfig.checkStrictMode(bool, localStringBuilder.toString());
    return str1.equals(str2);
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
    Object localObject1 = getModelInfos();
    if (localObject1 != null)
    {
      if (((List)localObject1).size() == 0) {
        return true;
      }
      localObject1 = getModelInfos().iterator();
      boolean bool2 = true;
      while (((Iterator)localObject1).hasNext())
      {
        ModelInfo localModelInfo = (ModelInfo)((Iterator)localObject1).next();
        boolean bool3;
        Object localObject2;
        if (isModelFileInAssets(localModelInfo))
        {
          bool3 = checkAssetsFileExist(localModelInfo);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("file not found: ");
          ((StringBuilder)localObject2).append(localModelInfo);
          AEOpenRenderConfig.checkStrictMode(bool3, ((StringBuilder)localObject2).toString());
          bool2 &= bool3;
        }
        else
        {
          localObject2 = new File(getFinalResourcesDir(), localModelInfo.fileName);
          bool3 = ((File)localObject2).exists();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("file ");
          localStringBuilder.append(localModelInfo);
          localStringBuilder.append(" not found in ");
          localStringBuilder.append(getFinalResourcesDir());
          AEOpenRenderConfig.checkStrictMode(bool3, localStringBuilder.toString());
          bool3 = ((File)localObject2).exists();
          boolean bool1 = false;
          if (bool3) {
            if ((localModelInfo.getFileSizeInBytes() > 0) && (((File)localObject2).length() != localModelInfo.getFileSizeInBytes()))
            {
              bool3 = ((File)localObject2).exists();
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("file ");
              localStringBuilder.append(localModelInfo);
              localStringBuilder.append(" size error: ");
              localStringBuilder.append(((File)localObject2).length());
              localStringBuilder.append(" != ");
              localStringBuilder.append(localModelInfo.getFileSizeInBytes());
              localStringBuilder.append("(expected)");
              AEOpenRenderConfig.checkStrictMode(bool3, localStringBuilder.toString());
            }
            else
            {
              bool1 = true;
            }
          }
          bool2 &= bool1;
        }
      }
      return bool2;
    }
    return true;
  }
  
  protected boolean checkAllSoFilesExists()
  {
    if (getSharedLibraries() != null)
    {
      if (getSharedLibraries().size() == 0) {
        return true;
      }
      SharedLibraryInfo localSharedLibraryInfo;
      if ((TextUtils.isEmpty(FeatureManager.getSoDir())) && (TextUtils.isEmpty(getSoDirOverrideFeatureManager())))
      {
        boolean bool;
        if (AEModule.getContext() != null) {
          bool = true;
        } else {
          bool = false;
        }
        AEOpenRenderConfig.checkStrictMode(bool, "AEModule context is null");
        if (AEModule.getContext() == null)
        {
          LogUtils.e("AEKitFeature", "[checkAllSoFilesExists] so load failed: AEModule context is null");
          return false;
        }
        localObject = new File(AEModule.getContext().getApplicationInfo().nativeLibraryDir).list();
        if ((localObject != null) && (localObject.length != 0))
        {
          Iterator localIterator = getSharedLibraries().iterator();
          while (localIterator.hasNext())
          {
            localSharedLibraryInfo = (SharedLibraryInfo)localIterator.next();
            if (!containsLib((String[])localObject, getFullLibname(localSharedLibraryInfo.fileName)))
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("so load failed: ");
              ((StringBuilder)localObject).append(localSharedLibraryInfo);
              ((StringBuilder)localObject).append(" not found in apk");
              AEOpenRenderConfig.checkStrictMode(false, ((StringBuilder)localObject).toString());
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("[checkAllSoFilesExists] so load failed: ");
              ((StringBuilder)localObject).append(localSharedLibraryInfo);
              ((StringBuilder)localObject).append(" not found in apk");
              LogUtils.e("AEKitFeature", ((StringBuilder)localObject).toString());
              return false;
            }
          }
          return true;
        }
        AEOpenRenderConfig.checkStrictMode(false, "so load failed: no libs in apk");
        LogUtils.e("AEKitFeature", "[checkAllSoFilesExists] so load failed: no libs in apk");
        return false;
      }
      Object localObject = getSharedLibraries().iterator();
      while (((Iterator)localObject).hasNext())
      {
        localSharedLibraryInfo = (SharedLibraryInfo)((Iterator)localObject).next();
        if (!new File(getFinalSoDir(), getFullLibname(localSharedLibraryInfo.fileName)).exists())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("so load failed: ");
          ((StringBuilder)localObject).append(localSharedLibraryInfo);
          ((StringBuilder)localObject).append(" not found in ");
          ((StringBuilder)localObject).append(getFinalSoDir());
          AEOpenRenderConfig.checkStrictMode(false, ((StringBuilder)localObject).toString());
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[checkAllSoFilesExists] so load failed: ");
          ((StringBuilder)localObject).append(localSharedLibraryInfo);
          ((StringBuilder)localObject).append(" not found in ");
          ((StringBuilder)localObject).append(getFinalSoDir());
          LogUtils.e("AEKitFeature", ((StringBuilder)localObject).toString());
          return false;
        }
      }
    }
    return true;
  }
  
  public boolean copyAssetsModelsToLocalPath(List<ModelInfo> paramList)
  {
    return copyModelsToLocalPath(getFinalResourcesDir(), paramList);
  }
  
  public boolean destroy()
  {
    this.isInited = (destroyImpl() ^ true);
    return true;
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
    return TextUtils.isEmpty(this.pendingErrorMessage) ^ true;
  }
  
  public boolean init()
  {
    if (!this.isInited) {
      synchronized (this.initLock)
      {
        boolean bool3 = this.isInited;
        if (!bool3)
        {
          try
          {
            setPendingErrorMessage(null);
            boolean bool2 = copyAssetsModelsToLocalPath(getModelInfos()) & true;
            boolean bool1 = bool2;
            if (FeatureManager.isEnableResourceCheck()) {
              bool1 = bool2 & checkAllResourcesFilesValid();
            }
            this.isInited = (bool1 & initImpl());
          }
          catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
          {
            AEOpenRenderConfig.checkStrictMode(false, localUnsatisfiedLinkError.toString());
            setPendingErrorMessage(localUnsatisfiedLinkError);
            this.isInited = false;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("AEKitFeature:");
          localStringBuilder.append(getName());
          localStringBuilder.append(" init result = ");
          localStringBuilder.append(this.isInited);
          LogUtils.i("AEKitFeature", localStringBuilder.toString());
        }
      }
    }
    return this.isInited;
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
    if (getModelInfos() != null)
    {
      if (getModelInfos().size() == 0) {
        return true;
      }
      Iterator localIterator = getModelInfos().iterator();
      while (localIterator.hasNext()) {
        if (!new File(paramString, ((ModelInfo)localIterator.next()).fileName).exists()) {
          return false;
        }
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
    if (getSharedLibraries() != null)
    {
      if (getSharedLibraries().size() == 0) {
        return true;
      }
      Iterator localIterator = getSharedLibraries().iterator();
      while (localIterator.hasNext()) {
        if (!new File(paramString, getFullLibname(((SharedLibraryInfo)localIterator.next()).fileName)).exists()) {
          return false;
        }
      }
    }
    return true;
  }
  
  protected boolean loadAllSoFiles()
  {
    Object localObject1;
    if ((FeatureManager.isEnableResourceCheck()) && (!checkAllSoFilesExists()))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("checkAllSoFilesExists : ");
      ((StringBuilder)localObject1).append(checkAllSoFilesExists());
      LogUtils.e("AEKitFeature", ((StringBuilder)localObject1).toString());
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("isEnableResourceCheck : ");
      ((StringBuilder)localObject1).append(FeatureManager.isEnableResourceCheck());
      LogUtils.e("AEKitFeature", ((StringBuilder)localObject1).toString());
      return false;
    }
    this.isSoFilesLoaded = true;
    Object localObject2 = getSharedLibraries().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (SharedLibraryInfo)((Iterator)localObject2).next();
      boolean bool = loadSoFile((SharedLibraryInfo)localObject1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("so load failed: ");
      localStringBuilder.append(localObject1);
      AEOpenRenderConfig.checkStrictMode(bool, localStringBuilder.toString());
      if ((!bool) && (FeatureManager.isEnableSoLoadCheck()))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("so load failed: ");
        ((StringBuilder)localObject2).append(localObject1);
        LogUtils.i("AEKitFeature", ((StringBuilder)localObject2).toString());
        this.isSoFilesLoaded = false;
        break;
      }
      if (bool)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("load so success:");
        localStringBuilder.append(localObject1);
        LogUtils.i("AEKitFeature", localStringBuilder.toString());
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
  
  protected boolean systemLoadLibrarySafely(String paramString)
  {
    try
    {
      System.loadLibrary(paramString);
      return true;
    }
    catch (Error localError) {}catch (Exception localException) {}
    localException.printStackTrace();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" systemLoadLibrarySafely failed:");
    localStringBuilder.append(localException.toString());
    LogUtils.e("AEKitFeature", localStringBuilder.toString());
    setPendingErrorMessage(localException);
    return false;
  }
  
  protected boolean systemLoadSafely(String paramString, SharedLibraryInfo paramSharedLibraryInfo)
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
    catch (Error paramString) {}catch (Exception paramString) {}
    paramString.printStackTrace();
    setPendingErrorMessage(paramString);
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Initializer(");
    localStringBuilder.append(getName());
    localStringBuilder.append(", init=");
    localStringBuilder.append(this.isInited);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.initializer.Feature
 * JD-Core Version:    0.7.0.1
 */
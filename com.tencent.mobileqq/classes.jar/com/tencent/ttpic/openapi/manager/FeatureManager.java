package com.tencent.ttpic.openapi.manager;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.initializer.LightSdkInitializer;
import com.tencent.ttpic.openapi.initializer.PtuAlgoInitializer;
import com.tencent.ttpic.openapi.initializer.PtuToolsInitializer;
import com.tencent.ttpic.openapi.initializer.YTCommonInitializer;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.io.File;

public class FeatureManager
{
  private static final String AEKIT_VERSION_FILE = "aekit_meta.txt";
  private static final String TAG = "FeatureManager";
  private static boolean enableResourceCheck = false;
  private static boolean enableSoLoadCheck = true;
  private static String resourceDir;
  private static String soDir;
  
  public static void createNoMedia()
  {
    try
    {
      Object localObject1 = AEModule.getContext();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(FileUtils.genSeperateFileDir(((Context)localObject1).getExternalFilesDir(null).getPath()));
      ((StringBuilder)localObject2).append("Tencent");
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append("aekit");
      localObject1 = ((StringBuilder)localObject2).toString();
      localObject2 = new File((String)localObject1);
      if ((!((File)localObject2).exists()) && (!((File)localObject2).mkdirs()))
      {
        localObject2 = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("FeatureManager create dir fail : ");
        localStringBuilder.append((String)localObject1);
        LogUtils.e((String)localObject2, localStringBuilder.toString());
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append(".nomedia");
      localObject1 = new File(((StringBuilder)localObject2).toString());
      if (!((File)localObject1).exists())
      {
        ((File)localObject1).createNewFile();
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static void enableResourceCheck(boolean paramBoolean)
  {
    enableResourceCheck = paramBoolean;
  }
  
  public static void enableSoLoadCheck(boolean paramBoolean)
  {
    enableSoLoadCheck = paramBoolean;
  }
  
  public static boolean ensureMaterialSoLoaded(VideoMaterial paramVideoMaterial)
  {
    boolean bool = true;
    if (paramVideoMaterial == null) {
      return true;
    }
    if (!FeatureManager.Features.LIGHT_SDK.isFunctionReady()) {
      bool = FeatureManager.Features.LIGHT_SDK.init();
    }
    return bool;
  }
  
  public static String getResourceDir()
  {
    return resourceDir;
  }
  
  public static String getSoDir()
  {
    return soDir;
  }
  
  public static boolean isBasicFeaturesFunctionReady()
  {
    return (FeatureManager.Features.YT_COMMON.isFunctionReady()) && (FeatureManager.Features.PTU_TOOLS.isFunctionReady()) && (FeatureManager.Features.PTU_ALGO.isFunctionReady()) && (FeatureManager.Features.LIGHT_SDK.isFunctionReady());
  }
  
  public static boolean isBasicFeaturesReadyInDir(String paramString)
  {
    boolean bool1 = FeatureManager.Features.YT_COMMON.isSoReadyInDirectory(paramString);
    boolean bool2 = FeatureManager.Features.PTU_ALGO.isSoReadyInDirectory(paramString);
    boolean bool3 = FeatureManager.Features.PTU_TOOLS.isSoReadyInDirectory(paramString);
    return FeatureManager.Features.LIGHT_SDK.isSoReadyInDirectory(paramString) & bool1 & bool2 & bool3;
  }
  
  public static boolean isEnableResourceCheck()
  {
    return enableResourceCheck;
  }
  
  public static boolean isEnableSoLoadCheck()
  {
    return enableSoLoadCheck;
  }
  
  public static boolean loadBasicFeatures()
  {
    return loadBasicFeatures(true);
  }
  
  public static boolean loadBasicFeatures(boolean paramBoolean)
  {
    if (!AEModule.isAeKitSupportVersion()) {
      return false;
    }
    boolean bool = true;
    if (paramBoolean) {
      bool = true & FeatureManager.Features.YT_COMMON.init();
    }
    return FeatureManager.Features.PTU_TOOLS.init() & bool & FeatureManager.Features.PTU_ALGO.init() & FeatureManager.Features.LIGHT_SDK.init();
  }
  
  public static void setModelDir(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      resourceDir = null;
      return;
    }
    resourceDir = FileUtils.genSeperateFileDir(paramString);
  }
  
  public static void setSoDir(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      soDir = null;
      return;
    }
    soDir = FileUtils.genSeperateFileDir(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.manager.FeatureManager
 * JD-Core Version:    0.7.0.1
 */
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
  private static final String TAG = FeatureManager.class.getSimpleName();
  private static boolean enableResourceCheck;
  private static boolean enableSoLoadCheck = true;
  private static String resourceDir;
  private static String soDir;
  
  public static void createNoMedia()
  {
    try
    {
      Object localObject = AEModule.getContext();
      localObject = FileUtils.genSeperateFileDir(((Context)localObject).getExternalFilesDir(null).getPath()) + "Tencent" + File.separator + "aekit";
      File localFile = new File((String)localObject);
      if ((!localFile.exists()) && (!localFile.mkdirs())) {
        LogUtils.e(TAG, "FeatureManager create dir fail : " + (String)localObject);
      }
      localObject = new File((String)localObject + File.separator + ".nomedia");
      if (!((File)localObject).exists()) {
        ((File)localObject).createNewFile();
      }
      return;
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
    if (paramVideoMaterial == null) {}
    while (FeatureManager.Features.LIGHT_SDK.isFunctionReady()) {
      return true;
    }
    return FeatureManager.Features.LIGHT_SDK.init();
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
    return FeatureManager.Features.YT_COMMON.isSoReadyInDirectory(paramString) & FeatureManager.Features.PTU_ALGO.isSoReadyInDirectory(paramString) & FeatureManager.Features.PTU_TOOLS.isSoReadyInDirectory(paramString) & FeatureManager.Features.LIGHT_SDK.isSoReadyInDirectory(paramString);
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
    return bool & FeatureManager.Features.PTU_TOOLS.init() & FeatureManager.Features.PTU_ALGO.init() & FeatureManager.Features.LIGHT_SDK.init();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.manager.FeatureManager
 * JD-Core Version:    0.7.0.1
 */
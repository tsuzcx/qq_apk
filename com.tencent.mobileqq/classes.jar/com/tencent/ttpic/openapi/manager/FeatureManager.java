package com.tencent.ttpic.openapi.manager;

import android.text.TextUtils;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.api.standard.ai.AIManager;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.openapi.PTFaceDetector;
import com.tencent.ttpic.openapi.initializer.AnimojiInitializer;
import com.tencent.ttpic.openapi.initializer.FaceDetectInitializer;
import com.tencent.ttpic.openapi.initializer.FaceKitInitializer;
import com.tencent.ttpic.openapi.initializer.FilamentInitializer;
import com.tencent.ttpic.openapi.initializer.GamePlayInitializer;
import com.tencent.ttpic.openapi.initializer.GenderDetectorInitializer;
import com.tencent.ttpic.openapi.initializer.MaskImagesInitializer;
import com.tencent.ttpic.openapi.initializer.PagInitializer;
import com.tencent.ttpic.openapi.initializer.ParticleSystemInitializer;
import com.tencent.ttpic.openapi.initializer.PtuAlgoInitializer;
import com.tencent.ttpic.openapi.initializer.PtuToolsInitializer;
import com.tencent.ttpic.openapi.initializer.RapidNetSDKInitializer;
import com.tencent.ttpic.openapi.initializer.Voice2TextInitializer;
import com.tencent.ttpic.openapi.initializer.VoiceChangerInitializer;
import com.tencent.ttpic.openapi.initializer.YTCommonInitializer;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;

public class FeatureManager
{
  private static final String AEKIT_VERSION_FILE = "aekit_meta.txt";
  private static final String TAG = FeatureManager.class.getSimpleName();
  private static boolean enableResourceCheck;
  private static String resourceDir;
  private static String soDir;
  
  public static void enableResourceCheck(boolean paramBoolean)
  {
    enableResourceCheck = paramBoolean;
  }
  
  public static boolean ensureMaterialSoLoaded(VideoMaterial paramVideoMaterial)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (paramVideoMaterial == null) {
      bool2 = bool1;
    }
    do
    {
      do
      {
        return bool2;
        bool1 = bool2;
        if (VideoMaterialUtil.is3DMaterial(paramVideoMaterial))
        {
          bool1 = bool2;
          if (!FeatureManager.Features.GAMEPLAY.isFunctionReady()) {
            bool1 = true & FeatureManager.Features.GAMEPLAY.init();
          }
        }
        bool2 = bool1;
        if (VideoMaterialUtil.isFilamentMaterial(paramVideoMaterial))
        {
          bool2 = bool1;
          if (!FeatureManager.Features.FILAMENT.isFunctionReady()) {
            bool2 = bool1 & FeatureManager.Features.FILAMENT.init();
          }
        }
        bool1 = bool2;
        if (VideoMaterialUtil.isAnimojiMaterial(paramVideoMaterial))
        {
          bool1 = bool2;
          if (!FeatureManager.Features.ANIMOJI.isFunctionReady()) {
            bool1 = bool2 & FeatureManager.Features.ANIMOJI.init();
          }
        }
        bool2 = bool1;
        if (VideoMaterialUtil.needVoiceChange(paramVideoMaterial))
        {
          bool2 = bool1;
          if (!FeatureManager.Features.VOICE_CHANGDER.isFunctionReady()) {
            bool2 = bool1 & FeatureManager.Features.VOICE_CHANGDER.init();
          }
        }
        bool1 = bool2;
        if (VideoMaterialUtil.isAudio2textMaterial(paramVideoMaterial))
        {
          bool1 = bool2;
          if (!FeatureManager.Features.VOICE_TO_TEXT.isFunctionReady()) {
            bool1 = bool2 & FeatureManager.Features.VOICE_TO_TEXT.init();
          }
        }
        bool2 = bool1;
        if (VideoMaterialUtil.isParticleMaterial(paramVideoMaterial))
        {
          bool2 = bool1;
          if (!FeatureManager.Features.PARTICLE_SYSTEM.isFunctionReady()) {
            bool2 = bool1 & FeatureManager.Features.PARTICLE_SYSTEM.init();
          }
        }
        bool1 = bool2;
        if (VideoMaterialUtil.isGenderDetect(paramVideoMaterial))
        {
          bool1 = bool2;
          if (!FeatureManager.Features.GENDER_DETECTOR.isFunctionReady()) {
            bool1 = bool2 & FeatureManager.Features.GENDER_DETECTOR.init();
          }
        }
        bool2 = bool1;
        if (VideoMaterialUtil.is3DCosMaterial(paramVideoMaterial))
        {
          bool2 = bool1;
          if (!FeatureManager.Features.FACE_KIT.isFunctionReady()) {
            bool2 = bool1 & FeatureManager.Features.FACE_KIT.init();
          }
        }
        bool1 = bool2;
        if (VideoMaterialUtil.isRapidNetMaterial(paramVideoMaterial))
        {
          bool1 = bool2;
          if (!FeatureManager.Features.RAPID_NET.isFunctionReady()) {
            bool1 = bool2 & FeatureManager.Features.RAPID_NET.init();
          }
        }
        bool2 = bool1;
      } while (!VideoMaterialUtil.isPagMaterial(paramVideoMaterial));
      bool2 = bool1;
    } while (FeatureManager.Features.PAG.isFunctionReady());
    return bool1 & FeatureManager.Features.PAG.init();
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
    return (FeatureManager.Features.YT_COMMON.isFunctionReady()) && (FeatureManager.Features.FACE_DETECT.isFunctionReady()) && (FeatureManager.Features.PTU_TOOLS.isFunctionReady()) && (FeatureManager.Features.PTU_ALGO.isFunctionReady()) && (FeatureManager.Features.MASK_IMAGES.isFunctionReady());
  }
  
  public static boolean isBasicFeaturesReadyInDir(String paramString)
  {
    return FeatureManager.Features.YT_COMMON.isSoReadyInDirectory(paramString) & FeatureManager.Features.PTU_ALGO.isSoReadyInDirectory(paramString) & FeatureManager.Features.PTU_TOOLS.isSoReadyInDirectory(paramString) & FeatureManager.Features.FACE_DETECT.isSoReadyInDirectory(paramString) & FeatureManager.Features.MASK_IMAGES.isSoReadyInDirectory(paramString);
  }
  
  public static boolean isEnableResourceCheck()
  {
    return enableResourceCheck;
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
    boolean bool1 = true;
    if (paramBoolean) {
      bool1 = true & FeatureManager.Features.YT_COMMON.init();
    }
    boolean bool2 = bool1 & FeatureManager.Features.PTU_TOOLS.init() & FeatureManager.Features.PTU_ALGO.init();
    bool1 = bool2;
    if (bool2) {
      bool1 = bool2 & FeatureManager.Features.MASK_IMAGES.init();
    }
    return bool1 & AIManager.installDetector(PTFaceDetector.class) & FeatureManager.Features.MASK_IMAGES.init();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.manager.FeatureManager
 * JD-Core Version:    0.7.0.1
 */
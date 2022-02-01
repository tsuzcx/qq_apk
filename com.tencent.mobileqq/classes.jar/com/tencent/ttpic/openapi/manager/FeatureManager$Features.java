package com.tencent.ttpic.openapi.manager;

import com.tencent.ttpic.openapi.initializer.Ace3DEngineInitializer;
import com.tencent.ttpic.openapi.initializer.AgeDetectorInitailizer;
import com.tencent.ttpic.openapi.initializer.Face3DLibInitializer;
import com.tencent.ttpic.openapi.initializer.FaceDetectInitializer;
import com.tencent.ttpic.openapi.initializer.GpuParticleInitializer;
import com.tencent.ttpic.openapi.initializer.ImageAlgoInitializer;
import com.tencent.ttpic.openapi.initializer.LightSdkInitializer;
import com.tencent.ttpic.openapi.initializer.MaskImagesInitializer;
import com.tencent.ttpic.openapi.initializer.MediaInitializer;
import com.tencent.ttpic.openapi.initializer.PagInitializer;
import com.tencent.ttpic.openapi.initializer.ParticleSystemInitializer;
import com.tencent.ttpic.openapi.initializer.PtuAlgoInitializer;
import com.tencent.ttpic.openapi.initializer.PtuToolsInitializer;
import com.tencent.ttpic.openapi.initializer.TNNCatInitializer;
import com.tencent.ttpic.openapi.initializer.TNNGenderDetectInitializer;
import com.tencent.ttpic.openapi.initializer.TNNGenderSwitchInitializer;
import com.tencent.ttpic.openapi.initializer.TNNGestureInitializer;
import com.tencent.ttpic.openapi.initializer.TNNHumanSegCpuInitializer;
import com.tencent.ttpic.openapi.initializer.TNNHumanSegGpuInitializer;
import com.tencent.ttpic.openapi.initializer.TNNRGBDepthInitializer;
import com.tencent.ttpic.openapi.initializer.TNNSegCpuInitializer;
import com.tencent.ttpic.openapi.initializer.TNNSegGpuInitializer;
import com.tencent.ttpic.openapi.initializer.TNNStyleChildInitializer;
import com.tencent.ttpic.openapi.initializer.TNNTongueDetectIntializer;
import com.tencent.ttpic.openapi.initializer.Voice2TextInitializer;
import com.tencent.ttpic.openapi.initializer.YTCommonInitializer;

public class FeatureManager$Features
{
  public static final Ace3DEngineInitializer ACE_3D_ENGINE;
  public static final AgeDetectorInitailizer AGE_DETECT;
  public static final Face3DLibInitializer FACE_3D_LIB;
  public static final FaceDetectInitializer FACE_DETECT;
  public static final GpuParticleInitializer GPU_PARTICLE;
  public static final ImageAlgoInitializer IMAGE_ALGO = new ImageAlgoInitializer();
  public static final LightSdkInitializer LIGHT_SDK = new LightSdkInitializer();
  public static final MaskImagesInitializer MASK_IMAGES;
  public static final MediaInitializer MEDIA;
  public static final PagInitializer PAG;
  public static final ParticleSystemInitializer PARTICLE_SYSTEM;
  public static final PtuAlgoInitializer PTU_ALGO;
  public static final PtuToolsInitializer PTU_TOOLS;
  public static final TNNCatInitializer RAPID_NET_CAT;
  public static final TNNGenderDetectInitializer RAPID_NET_GENDER_DETECT;
  public static final TNNGenderSwitchInitializer RAPID_NET_GENDER_SWITCH;
  public static final TNNGestureInitializer RAPID_NET_GESTURE;
  public static final TNNHumanSegCpuInitializer RAPID_NET_HUMAN_SEG_CPU;
  public static final TNNHumanSegCpuInitializer RAPID_NET_HUMAN_SEG_CPU_IMAGE;
  public static final TNNHumanSegGpuInitializer RAPID_NET_HUMAN_SEG_GPU;
  public static final TNNHumanSegGpuInitializer RAPID_NET_HUMAN_SEG_GPU_IMAGE;
  public static final TNNRGBDepthInitializer RAPID_NET_RGB_DEPTH;
  public static final TNNSegCpuInitializer RAPID_NET_SEG_CPU;
  public static final TNNSegGpuInitializer RAPID_NET_SEG_GPU;
  public static final TNNStyleChildInitializer TNN_STYLE_CHILD_INITIALIZER;
  public static final TNNTongueDetectIntializer TNN_TONGUE_DETECT;
  public static final Voice2TextInitializer VOICE_TO_TEXT;
  public static final YTCommonInitializer YT_COMMON = new YTCommonInitializer();
  
  static
  {
    FACE_DETECT = new FaceDetectInitializer();
    PTU_TOOLS = new PtuToolsInitializer();
    PTU_ALGO = new PtuAlgoInitializer();
    MASK_IMAGES = new MaskImagesInitializer();
    ACE_3D_ENGINE = new Ace3DEngineInitializer();
    GPU_PARTICLE = new GpuParticleInitializer();
    VOICE_TO_TEXT = new Voice2TextInitializer();
    PARTICLE_SYSTEM = new ParticleSystemInitializer();
    AGE_DETECT = new AgeDetectorInitailizer();
    FACE_3D_LIB = new Face3DLibInitializer();
    PAG = new PagInitializer();
    RAPID_NET_SEG_CPU = new TNNSegCpuInitializer();
    RAPID_NET_SEG_GPU = new TNNSegGpuInitializer();
    RAPID_NET_RGB_DEPTH = new TNNRGBDepthInitializer();
    RAPID_NET_GENDER_SWITCH = new TNNGenderSwitchInitializer();
    TNN_TONGUE_DETECT = new TNNTongueDetectIntializer();
    RAPID_NET_GESTURE = new TNNGestureInitializer();
    RAPID_NET_HUMAN_SEG_CPU = new TNNHumanSegCpuInitializer();
    RAPID_NET_HUMAN_SEG_GPU = new TNNHumanSegGpuInitializer();
    RAPID_NET_HUMAN_SEG_CPU_IMAGE = new TNNHumanSegCpuInitializer();
    RAPID_NET_HUMAN_SEG_GPU_IMAGE = new TNNHumanSegGpuInitializer();
    RAPID_NET_GENDER_DETECT = new TNNGenderDetectInitializer();
    TNN_STYLE_CHILD_INITIALIZER = new TNNStyleChildInitializer();
    RAPID_NET_CAT = new TNNCatInitializer();
    MEDIA = new MediaInitializer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.manager.FeatureManager.Features
 * JD-Core Version:    0.7.0.1
 */
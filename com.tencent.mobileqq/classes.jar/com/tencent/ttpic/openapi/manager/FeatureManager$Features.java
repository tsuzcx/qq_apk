package com.tencent.ttpic.openapi.manager;

import com.tencent.ttpic.openapi.initializer.AgeDetectorInitailizer;
import com.tencent.ttpic.openapi.initializer.AnimojiInitializer;
import com.tencent.ttpic.openapi.initializer.FaceDetectInitializer;
import com.tencent.ttpic.openapi.initializer.FaceKitInitializer;
import com.tencent.ttpic.openapi.initializer.FilamentInitializer;
import com.tencent.ttpic.openapi.initializer.GamePlayInitializer;
import com.tencent.ttpic.openapi.initializer.GenderDetectorInitializer;
import com.tencent.ttpic.openapi.initializer.GpuParticleInitializer;
import com.tencent.ttpic.openapi.initializer.ImageAlgoInitializer;
import com.tencent.ttpic.openapi.initializer.MaskImagesInitializer;
import com.tencent.ttpic.openapi.initializer.MediaInitializer;
import com.tencent.ttpic.openapi.initializer.PagInitializer;
import com.tencent.ttpic.openapi.initializer.ParticleSystemInitializer;
import com.tencent.ttpic.openapi.initializer.PtuAlgoInitializer;
import com.tencent.ttpic.openapi.initializer.PtuToolsInitializer;
import com.tencent.ttpic.openapi.initializer.RapidNetSDKInitializer;
import com.tencent.ttpic.openapi.initializer.Voice2TextInitializer;
import com.tencent.ttpic.openapi.initializer.VoiceChangerInitializer;
import com.tencent.ttpic.openapi.initializer.YTCommonInitializer;

public class FeatureManager$Features
{
  public static final AgeDetectorInitailizer AGE_DETECT;
  public static final AnimojiInitializer ANIMOJI;
  public static final FaceDetectInitializer FACE_DETECT;
  public static final FaceKitInitializer FACE_KIT;
  public static final FilamentInitializer FILAMENT;
  public static final GamePlayInitializer GAMEPLAY;
  public static final GenderDetectorInitializer GENDER_DETECTOR;
  public static final GpuParticleInitializer GPU_PARTICLE;
  public static final ImageAlgoInitializer IMAGE_ALGO = new ImageAlgoInitializer();
  public static final MaskImagesInitializer MASK_IMAGES;
  public static final MediaInitializer MEDIA;
  public static final PagInitializer PAG;
  public static final ParticleSystemInitializer PARTICLE_SYSTEM;
  public static final PtuAlgoInitializer PTU_ALGO;
  public static final PtuToolsInitializer PTU_TOOLS;
  public static final RapidNetSDKInitializer RAPID_NET;
  public static final VoiceChangerInitializer VOICE_CHANGDER;
  public static final Voice2TextInitializer VOICE_TO_TEXT;
  public static final YTCommonInitializer YT_COMMON = new YTCommonInitializer();
  
  static
  {
    FACE_DETECT = new FaceDetectInitializer();
    PTU_TOOLS = new PtuToolsInitializer();
    PTU_ALGO = new PtuAlgoInitializer();
    MASK_IMAGES = new MaskImagesInitializer();
    GAMEPLAY = new GamePlayInitializer();
    FILAMENT = new FilamentInitializer();
    GPU_PARTICLE = new GpuParticleInitializer();
    VOICE_CHANGDER = new VoiceChangerInitializer();
    VOICE_TO_TEXT = new Voice2TextInitializer();
    ANIMOJI = new AnimojiInitializer();
    PARTICLE_SYSTEM = new ParticleSystemInitializer();
    GENDER_DETECTOR = new GenderDetectorInitializer();
    AGE_DETECT = new AgeDetectorInitailizer();
    FACE_KIT = new FaceKitInitializer();
    PAG = new PagInitializer();
    RAPID_NET = new RapidNetSDKInitializer();
    MEDIA = new MediaInitializer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.manager.FeatureManager.Features
 * JD-Core Version:    0.7.0.1
 */
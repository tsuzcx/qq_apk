package com.tencent.ttpic.openapi.initializer;

import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.ttpic.util.youtu.YTFaceDetectorBase;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FaceDetectInitializer
  extends Feature
{
  private static final ModelInfo[] COMMON_MODEL = { new ModelInfo(true, "facedetect/detector", "net1_18.rpnmodel"), new ModelInfo(true, "facedetect/detector", "net1_18_bin.rpnproto"), new ModelInfo(true, "facedetect/detector", "net2_36.rpnmodel"), new ModelInfo(true, "facedetect/detector", "net2_36_bin.rpnproto"), new ModelInfo(true, "facedetect/poseest", "meshBasis.bin"), new ModelInfo(true, "facedetect/poseest", "rotBasis.bin") };
  private static final String TAG = FaceDetectInitializer.class.getSimpleName();
  private static final ModelInfo[] VIDEO_FACE_DET_MODEL = { new ModelInfo(true, "facedetect/align", "align.stb"), new ModelInfo(true, "facedetect/align", "align.rpdm"), new ModelInfo(true, "facedetect/align", "align_bin.rpdc"), new ModelInfo(true, "facedetect/align", "eye.rpdm"), new ModelInfo(true, "facedetect/align", "eye_bin.rpdc"), new ModelInfo(true, "facedetect/align", "eyebrow.rpdm"), new ModelInfo(true, "facedetect/align", "eyebrow_bin.rpdc"), new ModelInfo(true, "facedetect/align", "mouth.rpdm"), new ModelInfo(true, "facedetect/align", "mouth_bin.rpdc"), new ModelInfo(true, "facedetect/align", "refine1.rmd"), new ModelInfo(true, "facedetect/align", "refine2.rmd") };
  private static final SharedLibraryInfo[] sharedLibraries4Video = { new SharedLibraryInfo("c++_shared"), new SharedLibraryInfo("opencv_world"), new SharedLibraryInfo("YTFaceTrackPro"), new SharedLibraryInfo("CameraFaceJNI") };
  private boolean initPicDetect = false;
  private volatile boolean isCameraFaceTrackInited = false;
  private volatile boolean isCommonInited = false;
  private volatile boolean isPictureFaceTrackInited = false;
  
  private int initFaceDetect()
  {
    String str = getFinalResourcesDir();
    printMD5s(str);
    LogUtils.i(TAG, "initCommon, modelDir = " + str);
    int i = initCommon(str);
    LogUtils.i(TAG, "[FaceDetector] [Global] initCommon, ret = " + i);
    if (i != 0)
    {
      LogUtils.e(TAG, "[FaceDetector] [Global] initCommon failed, ret = " + i);
      return i;
    }
    if (!this.initPicDetect)
    {
      i = initCameraFaceTrack(str);
      LogUtils.i(TAG, "[FaceDetector] [Global] initCameraFaceTrack, result = " + i);
    }
    for (;;)
    {
      YTFaceDetectorBase.INSTANCE.nativeSetRefine(false);
      return i;
      i = initPictureFaceTrack(str);
      LogUtils.i(TAG, "[FaceDetector] [Global] initPictureFaceTrack, result = " + i);
    }
  }
  
  private void printMD5s(String paramString)
  {
    int j = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    ModelInfo[] arrayOfModelInfo = COMMON_MODEL;
    int k = arrayOfModelInfo.length;
    int i = 0;
    ModelInfo localModelInfo;
    String str;
    while (i < k)
    {
      localModelInfo = arrayOfModelInfo[i];
      str = FileUtils.getMD5(FileUtils.genSeperateFileDir(paramString) + File.separator + localModelInfo.fileName, "aekit");
      localStringBuilder.append(" " + localModelInfo.fileName + " = " + str + ",\n");
      i += 1;
    }
    arrayOfModelInfo = VIDEO_FACE_DET_MODEL;
    k = arrayOfModelInfo.length;
    i = j;
    while (i < k)
    {
      localModelInfo = arrayOfModelInfo[i];
      str = FileUtils.getMD5(FileUtils.genSeperateFileDir(paramString) + File.separator + localModelInfo.fileName, "aekit");
      localStringBuilder.append(" " + localModelInfo.fileName + " = " + str + ",\n");
      i += 1;
    }
    LogUtils.i(TAG, "printMD5s : [" + localStringBuilder + "]");
  }
  
  protected boolean destroyImpl()
  {
    this.isCommonInited = false;
    this.isCameraFaceTrackInited = false;
    this.isPictureFaceTrackInited = false;
    YTFaceDetectorBase.getInstance().destroy();
    return true;
  }
  
  public List<ModelInfo> getModelInfos()
  {
    ArrayList localArrayList = new ArrayList();
    Collections.addAll(localArrayList, COMMON_MODEL);
    Collections.addAll(localArrayList, VIDEO_FACE_DET_MODEL);
    return localArrayList;
  }
  
  public String getName()
  {
    return "FaceDetect";
  }
  
  public List<SharedLibraryInfo> getSharedLibraries()
  {
    ArrayList localArrayList = new ArrayList();
    Collections.addAll(localArrayList, sharedLibraries4Video);
    return localArrayList;
  }
  
  public int initCameraFaceTrack(String paramString)
  {
    if (this.isCameraFaceTrackInited)
    {
      LogUtils.e(TAG, "[FaceDetector] [Global] initCameraFaceTrack has inited");
      return 0;
    }
    int i = YTFaceDetectorBase.INSTANCE.nativeInitCameraFaceTrack(FileUtils.genSeperateFileDir(paramString));
    LogUtils.i(TAG, "nativeInitCameraFaceTrack, ret = " + i);
    if (i != 0)
    {
      LogUtils.e(TAG, "[FaceDetector] [Global] nativeInitCameraFaceTrack failed, ret = " + -1002);
      return -1002;
    }
    this.isCameraFaceTrackInited = true;
    return i;
  }
  
  public int initCommon(String paramString)
  {
    if (this.isCommonInited)
    {
      LogUtils.i(TAG, "[FaceDetector] [Global] initCommon has inited");
      return 0;
    }
    if ((!FeatureManager.Features.YT_COMMON.isFunctionReady()) && (!FeatureManager.Features.YT_COMMON.init())) {
      return 2;
    }
    int i = YTFaceDetectorBase.INSTANCE.nativeInitCommon(paramString + File.separator);
    LogUtils.i(TAG, "nativeInitCommon, ret = " + i);
    if (i != 0)
    {
      LogUtils.e(TAG, "nativeInitCommon failed, ret = " + -1001);
      LogUtils.e(TAG, "[FaceDetector] [Global] nativeInitCommon failed, ret = " + -1001);
      return -1001;
    }
    this.isCommonInited = true;
    return i;
  }
  
  protected boolean initImpl()
  {
    if (!loadAllSoFiles()) {}
    for (;;)
    {
      return false;
      if (initFaceDetect() == 0) {}
      for (int i = 1; i != 0; i = 0) {
        return true;
      }
    }
  }
  
  public int initPictureFaceTrack(String paramString)
  {
    if (this.isPictureFaceTrackInited)
    {
      LogUtils.e(TAG, "[FaceDetector] [Global] initPictureFaceTrack has inited");
      return 0;
    }
    int i = YTFaceDetectorBase.INSTANCE.nativeInitPictureFaceTrack(FileUtils.genSeperateFileDir(paramString));
    LogUtils.i(TAG, "nativeInitPictureFaceTrack, ret = " + i);
    if (i != 0)
    {
      LogUtils.e(TAG, "[FaceDetector] [Global] initPicFaceDetectModel failed");
      return -1003;
    }
    this.isPictureFaceTrackInited = true;
    return i;
  }
  
  public boolean isCameraFaceDetReady()
  {
    return this.isCameraFaceTrackInited;
  }
  
  public boolean isPicFaceDetReady()
  {
    return this.isPictureFaceTrackInited;
  }
  
  public void setInitPicDetect(boolean paramBoolean)
  {
    this.initPicDetect = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.initializer.FaceDetectInitializer
 * JD-Core Version:    0.7.0.1
 */
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
  private static final String TAG = "FaceDetectInitializer";
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
    Object localObject = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initCommon, modelDir = ");
    localStringBuilder.append(str);
    LogUtils.i((String)localObject, localStringBuilder.toString());
    int i = initCommon(str);
    localObject = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("[FaceDetector] [Global] initCommon, ret = ");
    localStringBuilder.append(i);
    LogUtils.i((String)localObject, localStringBuilder.toString());
    if (i != 0)
    {
      str = TAG;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[FaceDetector] [Global] initCommon failed, ret = ");
      ((StringBuilder)localObject).append(i);
      LogUtils.e(str, ((StringBuilder)localObject).toString());
      return i;
    }
    if (!this.initPicDetect)
    {
      i = initCameraFaceTrack(str);
      str = TAG;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[FaceDetector] [Global] initCameraFaceTrack, result = ");
      ((StringBuilder)localObject).append(i);
      LogUtils.i(str, ((StringBuilder)localObject).toString());
    }
    else
    {
      i = initPictureFaceTrack(str);
      str = TAG;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[FaceDetector] [Global] initPictureFaceTrack, result = ");
      ((StringBuilder)localObject).append(i);
      LogUtils.i(str, ((StringBuilder)localObject).toString());
    }
    YTFaceDetectorBase.INSTANCE.nativeSetRefine(false);
    return i;
  }
  
  private void printMD5s(String paramString)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    Object localObject1 = COMMON_MODEL;
    int k = localObject1.length;
    int j = 0;
    int i = 0;
    Object localObject2;
    Object localObject3;
    StringBuilder localStringBuilder2;
    while (i < k)
    {
      localObject2 = localObject1[i];
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(FileUtils.genSeperateFileDir(paramString));
      ((StringBuilder)localObject3).append(File.separator);
      ((StringBuilder)localObject3).append(localObject2.fileName);
      localObject3 = FileUtils.getMD5(((StringBuilder)localObject3).toString(), "aekit");
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(" ");
      localStringBuilder2.append(localObject2.fileName);
      localStringBuilder2.append(" = ");
      localStringBuilder2.append((String)localObject3);
      localStringBuilder2.append(",\n");
      localStringBuilder1.append(localStringBuilder2.toString());
      i += 1;
    }
    localObject1 = VIDEO_FACE_DET_MODEL;
    k = localObject1.length;
    i = j;
    while (i < k)
    {
      localObject2 = localObject1[i];
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(FileUtils.genSeperateFileDir(paramString));
      ((StringBuilder)localObject3).append(File.separator);
      ((StringBuilder)localObject3).append(localObject2.fileName);
      localObject3 = FileUtils.getMD5(((StringBuilder)localObject3).toString(), "aekit");
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(" ");
      localStringBuilder2.append(localObject2.fileName);
      localStringBuilder2.append(" = ");
      localStringBuilder2.append((String)localObject3);
      localStringBuilder2.append(",\n");
      localStringBuilder1.append(localStringBuilder2.toString());
      i += 1;
    }
    paramString = TAG;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("printMD5s : [");
    ((StringBuilder)localObject1).append(localStringBuilder1);
    ((StringBuilder)localObject1).append("]");
    LogUtils.i(paramString, ((StringBuilder)localObject1).toString());
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
    paramString = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("nativeInitCameraFaceTrack, ret = ");
    localStringBuilder.append(i);
    LogUtils.i(paramString, localStringBuilder.toString());
    if (i != 0)
    {
      paramString = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[FaceDetector] [Global] nativeInitCameraFaceTrack failed, ret = ");
      localStringBuilder.append(-1002);
      LogUtils.e(paramString, localStringBuilder.toString());
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
    Object localObject = YTFaceDetectorBase.INSTANCE;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(File.separator);
    int i = ((YTFaceDetectorBase)localObject).nativeInitCommon(localStringBuilder.toString());
    paramString = TAG;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("nativeInitCommon, ret = ");
    ((StringBuilder)localObject).append(i);
    LogUtils.i(paramString, ((StringBuilder)localObject).toString());
    if (i != 0)
    {
      paramString = TAG;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("nativeInitCommon failed, ret = ");
      ((StringBuilder)localObject).append(-1001);
      LogUtils.e(paramString, ((StringBuilder)localObject).toString());
      paramString = TAG;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[FaceDetector] [Global] nativeInitCommon failed, ret = ");
      ((StringBuilder)localObject).append(-1001);
      LogUtils.e(paramString, ((StringBuilder)localObject).toString());
      return -1001;
    }
    this.isCommonInited = true;
    return i;
  }
  
  protected boolean initImpl()
  {
    if (!loadAllSoFiles()) {
      return false;
    }
    int i;
    if (initFaceDetect() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    return i != 0;
  }
  
  public int initPictureFaceTrack(String paramString)
  {
    if (this.isPictureFaceTrackInited)
    {
      LogUtils.e(TAG, "[FaceDetector] [Global] initPictureFaceTrack has inited");
      return 0;
    }
    int i = YTFaceDetectorBase.INSTANCE.nativeInitPictureFaceTrack(FileUtils.genSeperateFileDir(paramString));
    paramString = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("nativeInitPictureFaceTrack, ret = ");
    localStringBuilder.append(i);
    LogUtils.i(paramString, localStringBuilder.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.initializer.FaceDetectInitializer
 * JD-Core Version:    0.7.0.1
 */
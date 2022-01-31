package com.tencent.ttpic.openapi.util;

import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.initializer.Initializable;
import com.tencent.ttpic.openapi.initializer.PtuToolsInitializer;
import com.tencent.ttpic.openapi.initializer.YTCommonInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FilterUtils
{
  private static final String TAG = "FilterUtils";
  private static boolean loadLibSuccessed = false;
  
  public static void checkLibraryInitForPitu(boolean paramBoolean)
  {
    Object localObject = new PtuToolsInitializer();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject);
    localArrayList.add(localObject);
    localArrayList.add(localObject);
    localArrayList.add(localObject);
    localArrayList.add(localObject);
    localObject = localArrayList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((Initializable)((Iterator)localObject).next()).init();
    }
  }
  
  public static void checkWeseeLibraryInit(boolean paramBoolean)
  {
    LogUtils.d("FilterUtils", "[checkLibraryInit] + BEGIN");
    long l = System.currentTimeMillis();
    if (!loadLibSuccessed) {
      LogUtils.d("FilterUtils", "[checkLibraryInit] invoke System.load lib so files");
    }
    try
    {
      System.loadLibrary("pitu_tools");
      System.loadLibrary("pitu_device");
      System.loadLibrary("YTCommon");
      System.loadLibrary("image_filter_common");
      System.loadLibrary("image_filter_gpu");
      System.loadLibrary("image_filter_cpu");
      System.loadLibrary("algo_rithm_jni");
      System.loadLibrary("ParticleSystem");
      System.loadLibrary("nnpack");
      System.loadLibrary("YTFaceTrackPro");
      System.loadLibrary("CameraFaceJNI");
      if (paramBoolean)
      {
        System.loadLibrary("YTFacePicTrack");
        System.loadLibrary("PictureFaceJNI");
      }
      loadLibSuccessed = true;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        LogUtils.e(localUnsatisfiedLinkError);
        loadLibSuccessed = false;
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;)
      {
        loadLibSuccessed = false;
        LogUtils.e(localRuntimeException);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        loadLibSuccessed = false;
        LogUtils.e(localException);
      }
    }
    if ((loadLibSuccessed) && (!FeatureManager.Features.YT_COMMON.init())) {
      LogUtils.e("FilterUtils", "鉴权失败");
    }
    LogUtils.d("FilterUtils", "[checkLibraryInit] + END, loadLibSuccessed = " + loadLibSuccessed + ", time cost = " + (System.currentTimeMillis() - l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.util.FilterUtils
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.filter;

import com.tencent.aelight.camera.download.api.IAEKitForQQ;
import com.tencent.aelight.camera.util.api.ICaptureUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;

public class QQFilterRenderManagerHolder
{
  public static int a;
  private static QQFilterRenderManager a;
  public static int b;
  private static QQFilterRenderManager b;
  public static int c = 2;
  
  static
  {
    ((IAEKitForQQ)QRoute.api(IAEKitForQQ.class)).init();
    ((ICaptureUtil)QRoute.api(ICaptureUtil.class)).loadEffectSo();
    jdField_a_of_type_Int = 0;
    jdField_b_of_type_Int = 1;
  }
  
  public static QQFilterRenderManager a()
  {
    return new QQFilterRenderManager(new int[] { 70, 80, 90, 184 });
  }
  
  public static QQFilterRenderManager a(int paramInt)
  {
    if (paramInt == c) {
      return jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager;
    }
    return null;
  }
  
  public static void a(QQFilterRenderManager paramQQFilterRenderManager)
  {
    jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = paramQQFilterRenderManager;
  }
  
  public static QQFilterRenderManager b()
  {
    try
    {
      if ((jdField_b_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null) && (jdField_b_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.isSurfaceDestroyed())) {
        jdField_b_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = null;
      }
      if (jdField_b_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager == null) {
        jdField_b_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = a();
      }
      QQFilterRenderManager localQQFilterRenderManager = jdField_b_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager;
      return localQQFilterRenderManager;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filter.QQFilterRenderManagerHolder
 * JD-Core Version:    0.7.0.1
 */
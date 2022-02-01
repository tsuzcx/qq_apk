package dov.com.qq.im;

import com.tencent.mobileqq.richmedia.capture.util.CaptureUtil;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import dov.com.qq.im.ae.AEKitForQQ;

public class QQFilterRenderManagerHolder
{
  public static int a;
  private static QQFilterRenderManager a;
  public static int b;
  private static QQFilterRenderManager b;
  public static int c = 2;
  private static int d;
  
  static
  {
    AEKitForQQ.a();
    CaptureUtil.b();
    jdField_a_of_type_Int = 0;
    jdField_b_of_type_Int = 1;
  }
  
  public static int a()
  {
    return d;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.QQFilterRenderManagerHolder
 * JD-Core Version:    0.7.0.1
 */
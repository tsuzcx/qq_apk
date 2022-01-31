package dov.com.qq.im;

import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;

public class QQFilterRenderManagerHolder
{
  public static int a;
  private static QQFilterRenderManager a;
  public static int b = 1;
  public static int c = 2;
  private static int d;
  
  static
  {
    jdField_a_of_type_Int = 0;
  }
  
  public static int a()
  {
    return d;
  }
  
  public static QQFilterRenderManager a()
  {
    return new QQFilterRenderManager(new int[] { 70, 80 });
  }
  
  public static QQFilterRenderManager a(int paramInt)
  {
    if (paramInt == c) {
      return jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager;
    }
    return EffectsCameraCaptureView.a();
  }
  
  public static void a(QQFilterRenderManager paramQQFilterRenderManager)
  {
    jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = paramQQFilterRenderManager;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.QQFilterRenderManagerHolder
 * JD-Core Version:    0.7.0.1
 */
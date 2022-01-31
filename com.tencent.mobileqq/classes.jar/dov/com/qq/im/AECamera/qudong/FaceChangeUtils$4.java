package dov.com.qq.im.AECamera.qudong;

import com.tencent.ttpic.openapi.filter.SimpleGLThread;

public final class FaceChangeUtils$4
  implements Runnable
{
  public FaceChangeUtils$4(Runnable paramRunnable, SimpleGLThread paramSimpleGLThread) {}
  
  public void run()
  {
    try
    {
      this.jdField_a_of_type_JavaLangRunnable.run();
      return;
    }
    finally
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterSimpleGLThread.destroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.AECamera.qudong.FaceChangeUtils.4
 * JD-Core Version:    0.7.0.1
 */
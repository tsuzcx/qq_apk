package dov.com.qq.im.ae.play;

import com.tencent.ttpic.openapi.filter.SimpleGLThread;

final class FaceChangeUtils$4
  implements Runnable
{
  FaceChangeUtils$4(Runnable paramRunnable, SimpleGLThread paramSimpleGLThread) {}
  
  public void run()
  {
    try
    {
      this.val$runnable.run();
      return;
    }
    finally
    {
      this.val$glThread.destroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.play.FaceChangeUtils.4
 * JD-Core Version:    0.7.0.1
 */
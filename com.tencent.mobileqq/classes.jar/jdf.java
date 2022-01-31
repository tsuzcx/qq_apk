import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.qphone.base.util.QLog;

public class jdf
  implements Runnable
{
  public jdf(VideoController paramVideoController) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(VideoController.a, 2, "connectingRunnable");
    }
    if (!this.a.a().f())
    {
      this.a.a(this.a.a().c, 0);
      this.a.b(216);
      this.a.c(this.a.a().c, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jdf
 * JD-Core Version:    0.7.0.1
 */
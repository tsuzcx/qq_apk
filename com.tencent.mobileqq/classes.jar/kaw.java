import com.tencent.av.ui.VideoControlUI;
import com.tencent.qphone.base.util.QLog;

public class kaw
  implements Runnable
{
  public kaw(VideoControlUI paramVideoControlUI) {}
  
  public void run()
  {
    if (this.a.i)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(this.a.c, 1, "HideToolbarRunnable");
      }
      this.a.i(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kaw
 * JD-Core Version:    0.7.0.1
 */
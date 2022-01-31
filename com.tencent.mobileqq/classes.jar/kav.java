import android.os.Build;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.av.utils.QQAnimationListener;
import com.tencent.qphone.base.util.QLog;

public class kav
  extends QQAnimationListener
{
  public kav(VideoControlUI paramVideoControlUI) {}
  
  public void a()
  {
    this.a.t();
  }
  
  public void b() {}
  
  public void c() {}
  
  public void d()
  {
    if (!this.a.i) {
      this.a.i(0);
    }
    if ("GT-I9100G".equals(Build.MODEL))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a.c, 2, "Model is 9100G, don't do animation");
      }
      return;
    }
    this.a.ab();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kav
 * JD-Core Version:    0.7.0.1
 */
import android.os.Build;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.qphone.base.util.QLog;

public class mly
  extends mvo
{
  public mly(VideoControlUI paramVideoControlUI) {}
  
  public void a()
  {
    this.a.m();
  }
  
  public void b() {}
  
  public void c() {}
  
  public void d()
  {
    if (!this.a.i) {
      this.a.e(0);
    }
    if ("GT-I9100G".equals(Build.MODEL))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a.d, 2, "Model is 9100G, don't do animation");
      }
      return;
    }
    this.a.F();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mly
 * JD-Core Version:    0.7.0.1
 */
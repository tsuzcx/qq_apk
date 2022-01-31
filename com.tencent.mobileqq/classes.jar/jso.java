import com.tencent.av.ui.BaseInviteFloatBarUICtr;
import com.tencent.qphone.base.util.QLog;

public class jso
  implements Runnable
{
  public jso(BaseInviteFloatBarUICtr paramBaseInviteFloatBarUICtr) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.a, 2, "timeout~ mPeerUin:" + this.a.c);
    }
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jso
 * JD-Core Version:    0.7.0.1
 */
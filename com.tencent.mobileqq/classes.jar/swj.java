import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.webprocess.WebProcessManager.WebProcessStartListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class swj
  implements WebProcessManager.WebProcessStartListener
{
  private WeakReference a;
  
  public swj(PreloadProcHitSession paramPreloadProcHitSession)
  {
    this.a = new WeakReference(paramPreloadProcHitSession);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      PreloadProcHitSession localPreloadProcHitSession = (PreloadProcHitSession)this.a.get();
      if (localPreloadProcHitSession != null) {
        localPreloadProcHitSession.a();
      }
      if (QLog.isColorLevel()) {
        QLog.d("FriendProfileCardActivity", 2, "check friend's profile and preload web-process!");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     swj
 * JD-Core Version:    0.7.0.1
 */
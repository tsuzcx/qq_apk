import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.ui.ControlUIObserver.CPreEventInfo;
import com.tencent.av.ui.redbag.GuideTip2;
import com.tencent.qphone.base.util.QLog;

public class khi
  extends ControlUIObserver
{
  public khi(GuideTip2 paramGuideTip2) {}
  
  protected void b(ControlUIObserver.CPreEventInfo paramCPreEventInfo)
  {
    if (paramCPreEventInfo.b) {
      return;
    }
    paramCPreEventInfo.b = this.a.a(false, 2);
    if (paramCPreEventInfo.b) {
      paramCPreEventInfo.a = "AVRegbagResultUI";
    }
    QLog.w(this.a.i, 1, "onAVActivityPreBackPressed, BlockSystemBack[" + paramCPreEventInfo.b + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     khi
 * JD-Core Version:    0.7.0.1
 */
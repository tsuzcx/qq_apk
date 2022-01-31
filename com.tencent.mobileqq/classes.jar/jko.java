import com.tencent.av.VideoController;
import com.tencent.av.gaudio.GaInviteLockActivity;
import com.tencent.av.ui.QavPanel.SlideAcceptListener;
import com.tencent.mobileqq.statistics.ReportController;

public class jko
  implements QavPanel.SlideAcceptListener
{
  public jko(GaInviteLockActivity paramGaInviteLockActivity) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if ((!this.a.a.e) && (!this.a.a.l())) {
        break label62;
      }
      this.a.f();
    }
    for (;;)
    {
      ReportController.b(null, "CliOper", "", "", "0X800420E", "0X800420E", 0, 0, "", "", "", "");
      return;
      label62:
      this.a.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jko
 * JD-Core Version:    0.7.0.1
 */
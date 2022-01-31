import android.content.Intent;
import com.tencent.av.ui.QavPanel.SlideAcceptListener;
import com.tencent.av.ui.VideoInviteLock;
import com.tencent.mobileqq.statistics.ReportController;

public class kbs
  implements QavPanel.SlideAcceptListener
{
  public kbs(VideoInviteLock paramVideoInviteLock) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.a.getIntent().getBooleanExtra("isDoubleVideoMeeting", false)) {
        ReportController.b(null, "CliOper", "", "", "0X80051FE", "0X80051FE", 0, 0, Integer.toString(this.a.c), Integer.toString(this.a.h), Integer.toString(this.a.i), "");
      }
      for (;;)
      {
        this.a.d = true;
        VideoInviteLock.a(this.a);
        return;
        if (this.a.b) {
          ReportController.b(null, "CliOper", "", "", "0X8004201", "0X8004201", 0, 0, Integer.toString(this.a.c), Integer.toString(this.a.h), Integer.toString(this.a.i), "");
        } else {
          ReportController.b(null, "CliOper", "", "", "0X8004205", "0X8004205", 0, 0, Integer.toString(this.a.c), Integer.toString(this.a.h), Integer.toString(this.a.i), "");
        }
      }
    }
    if (this.a.b)
    {
      ReportController.b(null, "CliOper", "", "", "0X800439E", "0X800439E", 0, 0, Integer.toString(this.a.c), Integer.toString(this.a.h), Integer.toString(this.a.i), "");
      return;
    }
    ReportController.b(null, "CliOper", "", "", "0X80043FD", "0X80043FD", 0, 0, Integer.toString(this.a.c), Integer.toString(this.a.h), Integer.toString(this.a.i), "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kbs
 * JD-Core Version:    0.7.0.1
 */
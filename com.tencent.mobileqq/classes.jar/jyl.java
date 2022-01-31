import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.ui.MultiVideoCtrlLayerUI4Discussion;
import com.tencent.av.ui.QavInOutAnimation.QavOutAnimationListener;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.ArrayList;

public class jyl
  implements QavInOutAnimation.QavOutAnimationListener
{
  public jyl(MultiVideoCtrlLayerUI4Discussion paramMultiVideoCtrlLayerUI4Discussion) {}
  
  public void a()
  {
    this.a.l = true;
    this.a.ah();
  }
  
  public void b()
  {
    SessionInfo localSessionInfo = this.a.a.a();
    if (localSessionInfo != null)
    {
      AVLog.d(this.a.c, " TYPE_NOTIFY_CAMERA_CLOSE 2: " + localSessionInfo.f + "|" + localSessionInfo.d);
      if (localSessionInfo.f) {
        this.a.jdField_b_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(106) });
      }
    }
    MultiVideoCtrlLayerUI4Discussion.a(this.a);
    this.a.i(true);
    if (this.a.a.e)
    {
      this.a.a.a(this.a.a.c, this.a.a.a, 100);
      ReportController.b(null, "CliOper", "", "", "0X8004CF2", "0X8004CF2", 0, 0, "", "", "", "");
      if (((this.a.e != 90) && (this.a.e != 270)) || (this.a.a.a().a() == -1) || (((VideoViewInfo)this.a.a.a().c.get(0)).a != 1)) {
        break label304;
      }
      ReportController.b(null, "CliOper", "", "", "0X8004CFB", "0X8004CFB", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.a.l = false;
      return;
      this.a.a.a(this.a.d, this.a.jdField_b_of_type_Long, 101);
      break;
      label304:
      if (((this.a.e == 90) || (this.a.e == 270)) && (this.a.a.a().a() != -1) && (((VideoViewInfo)this.a.a.a().c.get(0)).a == 2)) {
        ReportController.b(null, "CliOper", "", "", "0X8004CFC", "0X8004CFC", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jyl
 * JD-Core Version:    0.7.0.1
 */
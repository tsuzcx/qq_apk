import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.ui.MultiVideoCtrlLayerUI4NewGroupChat;
import com.tencent.av.ui.QavInOutAnimation.QavOutAnimationListener;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.ArrayList;

public class jxh
  implements QavInOutAnimation.QavOutAnimationListener
{
  public jxh(MultiVideoCtrlLayerUI4NewGroupChat paramMultiVideoCtrlLayerUI4NewGroupChat) {}
  
  public void a()
  {
    this.a.l = true;
    this.a.ah();
  }
  
  public void b()
  {
    ReportController.b(null, "CliOper", "", "", "0X800592D", "0X800592D", 0, 0, "", "", "", "");
    if (((this.a.e == 90) || (this.a.e == 270)) && (this.a.a.a().a() != -1) && (((VideoViewInfo)this.a.a.a().c.get(0)).a == 1))
    {
      ReportController.b(null, "CliOper", "", "", "0X800594D", "0X800594D", 0, 0, "", "", "", "");
      SessionInfo localSessionInfo = this.a.a.a();
      if (localSessionInfo != null)
      {
        AVLog.d(this.a.c, " TYPE_NOTIFY_CAMERA_CLOSE: " + localSessionInfo.f + "|" + localSessionInfo.d);
        if (localSessionInfo.f) {
          this.a.jdField_b_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(106) });
        }
      }
      MultiVideoCtrlLayerUI4NewGroupChat.b(this.a);
      MultiVideoCtrlLayerUI4NewGroupChat.a(this.a, true);
      if (!this.a.a.e) {
        break label371;
      }
      this.a.a.a(this.a.a.c, this.a.a.a, 100);
    }
    for (;;)
    {
      this.a.l = false;
      return;
      if (((this.a.e != 90) && (this.a.e != 270)) || (this.a.a.a().a() == -1) || (((VideoViewInfo)this.a.a.a().c.get(0)).a != 2)) {
        break;
      }
      ReportController.b(null, "CliOper", "", "", "0X800594E", "0X800594E", 0, 0, "", "", "", "");
      break;
      label371:
      this.a.a.a(this.a.d, this.a.jdField_b_of_type_Long, 101);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jxh
 * JD-Core Version:    0.7.0.1
 */
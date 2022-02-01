import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.ui.DoubleVideoMeetingCtrlUI;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class mcv
  implements View.OnClickListener
{
  public mcv(DoubleVideoMeetingCtrlUI paramDoubleVideoMeetingCtrlUI) {}
  
  public void onClick(View paramView)
  {
    QLog.d(this.a.d, 1, "onClick R.id.qav_btn_accept_video");
    this.a.e();
    this.a.a.a().aq = true;
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mcv
 * JD-Core Version:    0.7.0.1
 */
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.ui.DoubleVideoMeetingCtrlUI;
import com.tencent.qphone.base.util.QLog;

public class mfm
  implements View.OnClickListener
{
  public mfm(DoubleVideoMeetingCtrlUI paramDoubleVideoMeetingCtrlUI) {}
  
  public void onClick(View paramView)
  {
    QLog.d(this.a.d, 1, "onClick R.id.qav_btn_accept_video");
    this.a.e();
    this.a.a.a().ap = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mfm
 * JD-Core Version:    0.7.0.1
 */
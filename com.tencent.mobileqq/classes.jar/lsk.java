import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.ui.DoubleVideoMeetingCtrlUI;
import com.tencent.qphone.base.util.QLog;

public class lsk
  implements View.OnClickListener
{
  public lsk(DoubleVideoMeetingCtrlUI paramDoubleVideoMeetingCtrlUI) {}
  
  public void onClick(View paramView)
  {
    QLog.d(this.a.c, 1, "onClick R.id.qav_btn_accept_video");
    this.a.p();
    this.a.a.a().ao = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lsk
 * JD-Core Version:    0.7.0.1
 */
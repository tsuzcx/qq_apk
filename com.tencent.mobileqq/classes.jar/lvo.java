import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.redpacket.ui.RedPacketGameView;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class lvo
  implements View.OnClickListener
{
  public lvo(RedPacketGameView paramRedPacketGameView, long paramLong) {}
  
  public void onClick(View paramView)
  {
    AVActivity localAVActivity = this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameView.a();
    if (localAVActivity != null)
    {
      localAVActivity.a.j(this.jdField_a_of_type_Long);
      ((VideoAppInterface)localAVActivity.getAppRuntime()).a(new Object[] { Integer.valueOf(105), Boolean.valueOf(true), Long.valueOf(this.jdField_a_of_type_Long) });
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     lvo
 * JD-Core Version:    0.7.0.1
 */
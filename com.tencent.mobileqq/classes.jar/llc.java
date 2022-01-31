import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.redpacket.ui.RedPacketGameView;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoControlUI;

public class llc
  implements View.OnClickListener
{
  public llc(RedPacketGameView paramRedPacketGameView, long paramLong) {}
  
  public void onClick(View paramView)
  {
    paramView = this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameView.a();
    if (paramView != null)
    {
      paramView.a.i(this.jdField_a_of_type_Long);
      ((VideoAppInterface)paramView.getAppRuntime()).a(new Object[] { Integer.valueOf(105), Boolean.valueOf(true), Long.valueOf(this.jdField_a_of_type_Long) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     llc
 * JD-Core Version:    0.7.0.1
 */
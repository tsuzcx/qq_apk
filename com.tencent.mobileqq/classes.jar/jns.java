import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.redpacket.ui.RedPacketGameView;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoControlUI;

public class jns
  implements View.OnClickListener
{
  public jns(RedPacketGameView paramRedPacketGameView, AVActivity paramAVActivity) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentAvUiAVActivity.a.v();
    ((VideoAppInterface)this.jdField_a_of_type_ComTencentAvUiAVActivity.getAppRuntime()).a(new Object[] { Integer.valueOf(105), Boolean.valueOf(true) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jns
 * JD-Core Version:    0.7.0.1
 */
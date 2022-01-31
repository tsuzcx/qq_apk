import android.view.View;
import com.tencent.av.redpacket.ui.RedPacketRollNumberView;
import com.tencent.av.redpacket.ui.RedPacketRollTextView;

public class jnu
  implements Runnable
{
  public jnu(RedPacketRollNumberView paramRedPacketRollNumberView) {}
  
  public void run()
  {
    RedPacketRollNumberView.a(this.a, this.a.getChildCount());
    int i = 0;
    while (i < RedPacketRollNumberView.a(this.a))
    {
      View localView = this.a.getChildAt(i);
      if ((localView != null) && ((localView instanceof RedPacketRollTextView))) {
        ((RedPacketRollTextView)localView).b();
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jnu
 * JD-Core Version:    0.7.0.1
 */
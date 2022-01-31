import android.graphics.Typeface;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ViewSwitcher.ViewFactory;
import com.tencent.av.redpacket.ui.RedPacketRollTextView;
import com.tencent.mobileqq.portal.StrokeTextView;

public class lxx
  implements ViewSwitcher.ViewFactory
{
  public lxx(RedPacketRollTextView paramRedPacketRollTextView, boolean paramBoolean) {}
  
  public View makeView()
  {
    localStrokeTextView = new StrokeTextView(RedPacketRollTextView.a(this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketRollTextView));
    try
    {
      localStrokeTextView.setLayoutParams(new FrameLayout.LayoutParams(aepi.a(42.0F, this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketRollTextView.getResources()), -1));
      localStrokeTextView.setTextSize(0, RedPacketRollTextView.a(this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketRollTextView));
      localStrokeTextView.setIncludeFontPadding(false);
      if (this.jdField_a_of_type_Boolean) {}
      for (String str = "0";; str = "")
      {
        localStrokeTextView.setText(str);
        localStrokeTextView.setStrokeEnable(true);
        localStrokeTextView.setStrokeColor(-1);
        localStrokeTextView.setStrokeSize(aepi.a(6.0F, this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketRollTextView.getResources()));
        localStrokeTextView.setInnerTextColor(-2094274);
        localStrokeTextView.setTypeface(Typeface.defaultFromStyle(1));
        localStrokeTextView.setGravity(17);
        return localStrokeTextView;
      }
      return localStrokeTextView;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lxx
 * JD-Core Version:    0.7.0.1
 */
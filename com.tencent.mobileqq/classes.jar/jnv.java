import android.graphics.Typeface;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ViewSwitcher.ViewFactory;
import com.tencent.av.redpacket.ui.RedPacketRollTextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.portal.StrokeTextView;

public class jnv
  implements ViewSwitcher.ViewFactory
{
  public jnv(RedPacketRollTextView paramRedPacketRollTextView, boolean paramBoolean) {}
  
  public View makeView()
  {
    localStrokeTextView = new StrokeTextView(RedPacketRollTextView.a(this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketRollTextView));
    try
    {
      localStrokeTextView.setLayoutParams(new FrameLayout.LayoutParams(AIOUtils.a(42.0F, this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketRollTextView.getResources()), -1));
      localStrokeTextView.setTextSize(0, RedPacketRollTextView.a(this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketRollTextView));
      localStrokeTextView.setIncludeFontPadding(false);
      if (this.jdField_a_of_type_Boolean) {}
      for (String str = "0";; str = "")
      {
        localStrokeTextView.setText(str);
        localStrokeTextView.setStrokeEnable(true);
        localStrokeTextView.setStrokeColor(-1);
        localStrokeTextView.setStrokeSize(AIOUtils.a(6.0F, this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketRollTextView.getResources()));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jnv
 * JD-Core Version:    0.7.0.1
 */
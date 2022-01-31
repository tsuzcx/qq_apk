import android.widget.RelativeLayout;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.mobileqq.vipav.VipFullScreenVideoView;

public class jrs
  implements Runnable
{
  public jrs(AVActivity paramAVActivity) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView != null)
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView.isPlaying()) {
        this.a.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView.stopPlayback();
      }
      if ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) && ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI))) {
        ((DoubleVideoCtrlUI)this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI).b(false);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView.setVisibility(8);
      RelativeLayout localRelativeLayout = (RelativeLayout)this.a.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView.getParent();
      if (localRelativeLayout != null) {
        localRelativeLayout.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jrs
 * JD-Core Version:    0.7.0.1
 */
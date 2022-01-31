import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.AlphaAnimation;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyChannelPanelFragment;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyStaticGridView;

public class oio
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public oio(ReadInJoyChannelPanelFragment paramReadInJoyChannelPanelFragment, ReadInJoyStaticGridView paramReadInJoyStaticGridView, View paramView) {}
  
  public void onGlobalLayout()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyStaticGridView.getHeight() > 0) {
      if (this.jdField_a_of_type_AndroidViewView.getVisibility() == 8) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
    }
    while (this.jdField_a_of_type_AndroidViewView.getVisibility() != 0) {
      return;
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 0.0F);
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setDuration(400L);
    localAlphaAnimation.setAnimationListener(new oip(this));
    this.jdField_a_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oio
 * JD-Core Version:    0.7.0.1
 */
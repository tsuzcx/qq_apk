import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyNaviController;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNavigationGridview;

public class lbl
  implements Runnable
{
  public lbl(ReadInJoyNaviController paramReadInJoyNaviController, ChannelCoverInfo paramChannelCoverInfo) {}
  
  public void run()
  {
    Object localObject = ReadInJoyNaviController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyNaviController).a();
    ReadInJoyNaviController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyNaviController, 1000L);
    if ((localObject != null) && (ReadInJoyNaviController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyNaviController)))
    {
      ReadInJoyNaviController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyNaviController, false);
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -((View)localObject).getHeight());
      localTranslateAnimation.setDuration(300L);
      localTranslateAnimation.setAnimationListener(new lbm(this));
      ((View)localObject).startAnimation(localTranslateAnimation);
      if (ReadInJoyNaviController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyNaviController) != null)
      {
        localObject = new RotateAnimation(180.0F, 0.0F, 1, 0.5F, 1, 0.5F);
        ((Animation)localObject).setDuration(200L);
        ((Animation)localObject).setFillEnabled(true);
        ((Animation)localObject).setFillAfter(true);
        ReadInJoyNaviController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyNaviController).startAnimation((Animation)localObject);
      }
      ReadInJoyNaviController.a(1, ReadInJoyNaviController.a(1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lbl
 * JD-Core Version:    0.7.0.1
 */
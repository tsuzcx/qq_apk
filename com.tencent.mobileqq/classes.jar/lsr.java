import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.pubaccount.readinjoy.presenter.ReadInJoyHeaderPresenter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyView;
import java.util.ArrayList;

public class lsr
  implements Animation.AnimationListener
{
  public lsr(ReadInJoyHeaderPresenter paramReadInJoyHeaderPresenter, ReadInJoyView paramReadInJoyView, ArrayList paramArrayList1, ArrayList paramArrayList2, int paramInt, Object paramObject) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView.a().post(new lss(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lsr
 * JD-Core Version:    0.7.0.1
 */
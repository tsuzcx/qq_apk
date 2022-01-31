import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCell;
import java.util.ArrayList;

public class ltk
  implements Animation.AnimationListener
{
  public ltk(FeedItemCell paramFeedItemCell, ArrayList paramArrayList1, ArrayList paramArrayList2, int paramInt, Object paramObject) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    try
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildFeedItemCell.a().post(new ltl(this));
      return;
    }
    catch (Exception paramAnimation)
    {
      paramAnimation.printStackTrace();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ltk
 * JD-Core Version:    0.7.0.1
 */
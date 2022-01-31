import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.daily.DailyTipsFoldUtils.1;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.qphone.base.util.QLog;

public class oem
  implements ValueAnimator.AnimatorUpdateListener
{
  public oem(DailyTipsFoldUtils.1 param1, View paramView, int paramInt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.jdField_a_of_type_AndroidViewView.setAlpha(1.0F - f);
    int i = (int)(this.jdField_a_of_type_Int * f);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDailyDailyTipsFoldUtils$1.a.smoothScrollToPositionFromTop(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDailyDailyTipsFoldUtils$1.a.getHeaderViewsCount(), -i, 0);
    if (QLog.isColorLevel()) {
      QLog.d("DailyTipsFoldUtils", 2, "percent = " + f + ", scrollHeight = " + i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oem
 * JD-Core Version:    0.7.0.1
 */
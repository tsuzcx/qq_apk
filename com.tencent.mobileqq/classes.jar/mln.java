import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewPropertyAnimator;
import com.tencent.biz.pubaccount.readinjoy.view.appinpush.DropDownAppInPushNotification;

public class mln
  implements View.OnTouchListener
{
  private float jdField_a_of_type_Float;
  private final int jdField_a_of_type_Int = ViewConfiguration.getTapTimeout();
  private long jdField_a_of_type_Long;
  private float jdField_b_of_type_Float;
  private final int jdField_b_of_type_Int = ViewConfiguration.getTouchSlop();
  private float c;
  private float d;
  
  public mln(DropDownAppInPushNotification paramDropDownAppInPushNotification) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
    case 2: 
      do
      {
        return true;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAppinpushDropDownAppInPushNotification.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAppinpushDropDownAppInPushNotification.jdField_a_of_type_JavaLangRunnable);
        this.jdField_a_of_type_Float = paramMotionEvent.getY();
        this.jdField_b_of_type_Float = paramMotionEvent.getX();
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        return true;
        f1 = paramMotionEvent.getY() - this.jdField_a_of_type_Float;
      } while (DropDownAppInPushNotification.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAppinpushDropDownAppInPushNotification).getY() + f1 >= 0.0F);
      DropDownAppInPushNotification.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAppinpushDropDownAppInPushNotification).animate().yBy(f1).setDuration(0L).start();
      return true;
    }
    this.c = paramMotionEvent.getX();
    this.d = paramMotionEvent.getY();
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    float f1 = this.d - this.jdField_a_of_type_Float;
    float f2 = this.c - this.jdField_b_of_type_Float;
    if ((f1 * f1 + f2 * f2 <= this.jdField_b_of_type_Int * this.jdField_b_of_type_Int) && (l1 - l2 <= this.jdField_a_of_type_Int))
    {
      paramView.performClick();
      return true;
    }
    if (-DropDownAppInPushNotification.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAppinpushDropDownAppInPushNotification).getY() < DropDownAppInPushNotification.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAppinpushDropDownAppInPushNotification).getHeight() / 2)
    {
      DropDownAppInPushNotification.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAppinpushDropDownAppInPushNotification).animate().y(0.0F).setDuration(200L).start();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAppinpushDropDownAppInPushNotification.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAppinpushDropDownAppInPushNotification.jdField_a_of_type_JavaLangRunnable, 3000L);
      return true;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAppinpushDropDownAppInPushNotification.a(true, true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mln
 * JD-Core Version:    0.7.0.1
 */
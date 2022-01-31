import android.app.Activity;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.subscript.SubscriptRecommendAdapter;
import com.tencent.biz.pubaccount.subscript.SubscriptRecommendAdapter.RecommendItem;

public class mtj
  implements View.OnTouchListener
{
  public mtj(SubscriptRecommendAdapter.RecommendItem paramRecommendItem, SubscriptRecommendAdapter paramSubscriptRecommendAdapter, boolean paramBoolean) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    case 2: 
    default: 
      return false;
    case 0: 
      this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter$RecommendItem.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter$RecommendItem.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter.a.getResources().getColor(2131493607));
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter$RecommendItem.c.setBackgroundResource(2130840906);
        return false;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter$RecommendItem.c.setBackgroundResource(2130840907);
      return false;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter$RecommendItem.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter$RecommendItem.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter.a.getResources().getColor(2131493605));
    this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter$RecommendItem.c.setBackgroundResource(2130840915);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mtj
 * JD-Core Version:    0.7.0.1
 */
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCellTypeSmallSocial;

public class lup
  implements View.OnTouchListener
{
  public lup(FeedItemCellTypeSmallSocial paramFeedItemCellTypeSmallSocial, LinearLayout paramLinearLayout) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setDuplicateParentStateEnabled(false);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lup
 * JD-Core Version:    0.7.0.1
 */
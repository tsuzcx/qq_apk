import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCellTypeBigSocial;

public class lto
  implements View.OnTouchListener
{
  public lto(FeedItemCellTypeBigSocial paramFeedItemCellTypeBigSocial, LinearLayout paramLinearLayout) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setDuplicateParentStateEnabled(true);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lto
 * JD-Core Version:    0.7.0.1
 */
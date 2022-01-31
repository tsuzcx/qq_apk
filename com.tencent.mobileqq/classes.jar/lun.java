import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCellTypeSmallSocial;

public class lun
  implements View.OnTouchListener
{
  public lun(FeedItemCellTypeSmallSocial paramFeedItemCellTypeSmallSocial, RelativeLayout paramRelativeLayout) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setDuplicateParentStateEnabled(false);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lun
 * JD-Core Version:    0.7.0.1
 */
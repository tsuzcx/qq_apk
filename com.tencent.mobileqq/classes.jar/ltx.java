import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCellTypeGalleryBiu;

public class ltx
  implements View.OnTouchListener
{
  public ltx(FeedItemCellTypeGalleryBiu paramFeedItemCellTypeGalleryBiu, LinearLayout paramLinearLayout1, LinearLayout paramLinearLayout2) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setDuplicateParentStateEnabled(true);
      this.b.setDuplicateParentStateEnabled(true);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ltx
 * JD-Core Version:    0.7.0.1
 */
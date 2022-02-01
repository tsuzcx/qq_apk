import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;

class qkx
  implements View.OnTouchListener
{
  qkx(qkv paramqkv, RelativeLayout paramRelativeLayout) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setDuplicateParentStateEnabled(false);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qkx
 * JD-Core Version:    0.7.0.1
 */
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.biz.qqstory.view.widget.StoryAddDescribeGuideDialog;

public class ovx
  implements View.OnTouchListener
{
  public ovx(StoryAddDescribeGuideDialog paramStoryAddDescribeGuideDialog) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    StoryAddDescribeGuideDialog.a(this.a);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ovx
 * JD-Core Version:    0.7.0.1
 */
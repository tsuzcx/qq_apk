import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.troop.widget.FollowImageTextView;

public class spe
  implements View.OnTouchListener
{
  public spe(DiscussionInfoCardActivity paramDiscussionInfoCardActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent != null) && (this.a.a != null))
    {
      paramView = this.a.a;
      if (paramMotionEvent.getAction() != 0) {
        break label39;
      }
    }
    label39:
    for (float f = 0.5F;; f = 1.0F)
    {
      paramView.setAlpha(f);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     spe
 * JD-Core Version:    0.7.0.1
 */
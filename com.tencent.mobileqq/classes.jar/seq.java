import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.ChatSettingForTroop;

public class seq
  implements View.OnTouchListener
{
  public seq(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent != null)
    {
      paramView = this.a.a[15];
      if (paramView != null) {
        if (paramMotionEvent.getAction() != 0) {
          break label36;
        }
      }
    }
    label36:
    for (float f = 0.5F;; f = 1.0F)
    {
      paramView.setAlpha(f);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     seq
 * JD-Core Version:    0.7.0.1
 */
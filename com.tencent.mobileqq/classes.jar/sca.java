import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.ChatSettingForTroop;

public class sca
  implements View.OnTouchListener
{
  public sca(ChatSettingForTroop paramChatSettingForTroop, ImageView paramImageView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i;
    if (paramMotionEvent.getAction() == 0)
    {
      i = 1;
      paramView = this.jdField_a_of_type_AndroidWidgetImageView;
      if (i == 0) {
        break label36;
      }
    }
    label36:
    for (float f = 0.5F;; f = 1.0F)
    {
      paramView.setAlpha(f);
      return false;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sca
 * JD-Core Version:    0.7.0.1
 */
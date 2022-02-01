import android.app.Activity;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.PopupWindow.OnDismissListener;

class oey
  implements PopupWindow.OnDismissListener
{
  oey(oex paramoex) {}
  
  public void onDismiss()
  {
    WindowManager.LayoutParams localLayoutParams = ((Activity)this.a.a).getWindow().getAttributes();
    localLayoutParams.alpha = 1.0F;
    ((Activity)this.a.a).getWindow().setAttributes(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oey
 * JD-Core Version:    0.7.0.1
 */
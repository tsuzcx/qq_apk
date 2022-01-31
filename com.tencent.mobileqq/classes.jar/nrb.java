import android.app.Activity;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.PopupWindow.OnDismissListener;

class nrb
  implements PopupWindow.OnDismissListener
{
  nrb(nra paramnra) {}
  
  public void onDismiss()
  {
    WindowManager.LayoutParams localLayoutParams = ((Activity)this.a.a).getWindow().getAttributes();
    localLayoutParams.alpha = 1.0F;
    ((Activity)this.a.a).getWindow().setAttributes(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nrb
 * JD-Core Version:    0.7.0.1
 */
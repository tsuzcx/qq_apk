import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.util.VersionUtils;
import com.tencent.widget.PatchedButton;

public class rsj
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public rsj(BaseChatPie paramBaseChatPie) {}
  
  public void onGlobalLayout()
  {
    int i = ((View)this.a.a.getParent()).getHeight() - this.a.a.getBottom();
    this.a.e.setPadding(0, 0, 0, i);
    if (i > 0)
    {
      if (VersionUtils.g()) {
        this.a.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
      }
    }
    else {
      return;
    }
    this.a.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rsj
 * JD-Core Version:    0.7.0.1
 */
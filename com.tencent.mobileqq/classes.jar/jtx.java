import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.av.ui.EffectSettingBtn;

public class jtx
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public jtx(EffectSettingBtn paramEffectSettingBtn) {}
  
  @TargetApi(16)
  public void onGlobalLayout()
  {
    ViewTreeObserver localViewTreeObserver = this.a.a.getViewTreeObserver();
    if (Build.VERSION.SDK_INT >= 16) {
      localViewTreeObserver.removeOnGlobalLayoutListener(this);
    }
    for (;;)
    {
      this.a.b = true;
      return;
      localViewTreeObserver.removeGlobalOnLayoutListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jtx
 * JD-Core Version:    0.7.0.1
 */
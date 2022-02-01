import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.av.ui.virtual.QavVirtualMenuView;

public class mrg
  implements View.OnTouchListener
{
  public mrg(QavVirtualMenuView paramQavVirtualMenuView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    EffectSettingUi.a(QavVirtualMenuView.a(this.a), -1051L);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mrg
 * JD-Core Version:    0.7.0.1
 */
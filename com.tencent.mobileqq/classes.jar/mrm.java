import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.av.ui.virtual.QavVirtualMenuView;

public class mrm
  implements View.OnTouchListener
{
  public mrm(QavVirtualMenuView paramQavVirtualMenuView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    EffectSettingUi.a(QavVirtualMenuView.a(this.a), -1051L);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mrm
 * JD-Core Version:    0.7.0.1
 */
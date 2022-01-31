import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.qphone.base.util.QLog;

public class jwb
  implements View.OnTouchListener
{
  public jwb(EffectSettingUi paramEffectSettingUi) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    EffectSettingUi.a(this.a.a);
    QLog.w("EffectSettingUi", 1, "m_qav_effect_bottom, onTouchEvent[" + paramMotionEvent.getAction() + "]");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jwb
 * JD-Core Version:    0.7.0.1
 */
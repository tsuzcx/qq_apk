import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.qphone.base.util.QLog;

public class jum
  implements View.OnTouchListener
{
  public jum(EffectSettingUi paramEffectSettingUi) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    EffectSettingUi.a(this.a.a);
    QLog.w("EffectSettingUi", 1, "m_qav_effect_bottom, onTouchEvent[" + paramMotionEvent.getAction() + "]");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jum
 * JD-Core Version:    0.7.0.1
 */
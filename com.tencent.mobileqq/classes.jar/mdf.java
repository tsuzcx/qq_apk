import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.qphone.base.util.QLog;

public class mdf
  implements View.OnTouchListener
{
  public mdf(EffectSettingUi paramEffectSettingUi) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    EffectSettingUi.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, -1008L);
    QLog.w(this.a.jdField_a_of_type_JavaLangString, 1, "m_qav_effect_bottom, onTouchEvent[" + paramMotionEvent.getAction() + "]");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mdf
 * JD-Core Version:    0.7.0.1
 */
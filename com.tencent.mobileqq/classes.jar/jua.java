import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.EffectSettingBtn;
import com.tencent.av.utils.UITools;
import com.tencent.qphone.base.util.QLog;

public class jua
  implements ViewTreeObserver.OnPreDrawListener
{
  public jua(EffectSettingBtn paramEffectSettingBtn, TextView paramTextView) {}
  
  public boolean onPreDraw()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.getViewTreeObserver().removeOnPreDrawListener(this);
    this.jdField_a_of_type_ComTencentAvUiEffectSettingBtn.a.a().a().ax = true;
    UITools.a(this.jdField_a_of_type_ComTencentAvUiEffectSettingBtn.a);
    QLog.d("qav_face_guide", 1, "onPreDraw");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jua
 * JD-Core Version:    0.7.0.1
 */
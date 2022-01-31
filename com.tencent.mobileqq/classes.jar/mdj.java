import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.HorizontalScrollView;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.qphone.base.util.QLog;

public class mdj
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public mdj(EffectSettingUi paramEffectSettingUi, ViewTreeObserver paramViewTreeObserver, HorizontalScrollView paramHorizontalScrollView) {}
  
  @TargetApi(16)
  public void onGlobalLayout()
  {
    if (Build.VERSION.SDK_INT >= 16) {
      this.jdField_a_of_type_AndroidViewViewTreeObserver.removeOnGlobalLayoutListener(this);
    }
    for (;;)
    {
      QLog.w("EffectSettingUi", 1, "onGlobalLayout");
      this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setTag(new Object());
      this.jdField_a_of_type_ComTencentAvUiEffectSettingUi.c();
      return;
      this.jdField_a_of_type_AndroidViewViewTreeObserver.removeGlobalOnLayoutListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mdj
 * JD-Core Version:    0.7.0.1
 */
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.av.ui.guide.GuideHelper;
import java.lang.ref.WeakReference;

public class lsr
  implements View.OnClickListener
{
  public lsr(EffectSettingUi paramEffectSettingUi) {}
  
  public void onClick(View paramView)
  {
    EffectSettingUi.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, -1007L);
    this.a.b(-1007L, true);
    lqz.b();
    if (this.a.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      paramView = (AVActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get();
      paramView.a.a(-1007L, paramView, 99, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lsr
 * JD-Core Version:    0.7.0.1
 */
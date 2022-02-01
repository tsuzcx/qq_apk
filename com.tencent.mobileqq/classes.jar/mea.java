import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.av.ui.guide.GuideHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

public class mea
  implements View.OnClickListener
{
  public mea(EffectSettingUi paramEffectSettingUi) {}
  
  public void onClick(View paramView)
  {
    EffectSettingUi.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, -1007L);
    this.a.c(-1007L, true);
    mcd.b();
    if (this.a.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      AVActivity localAVActivity = (AVActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get();
      localAVActivity.a.a(-1007L, localAVActivity, 99, 0);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mea
 * JD-Core Version:    0.7.0.1
 */
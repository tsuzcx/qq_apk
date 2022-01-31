import android.widget.Button;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.av.ui.EffectToolbar;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Map;

public class lst
  implements lwk
{
  public lst(EffectToolbar paramEffectToolbar) {}
  
  public void a(long paramLong)
  {
    EffectSettingUi.a(this.a.mApp, paramLong);
  }
  
  public void a(long paramLong, lxf paramlxf)
  {
    EffectSettingUi.a(this.a.mApp, paramLong);
    Object localObject1 = VideoController.a();
    Object localObject2 = ((VideoController)localObject1).a(((AVActivity)this.a.mActivity.get()).getApplicationContext());
    if (localObject2 != null)
    {
      if (AudioHelper.e()) {
        QLog.w("EffectToolbar", 1, "onEffectClick, clearState, seq[" + paramLong + "], info[" + paramlxf + "]");
      }
      ((lfg)localObject2).a(paramLong);
    }
    if (paramlxf.jdField_a_of_type_JavaLangString.equals("0"))
    {
      EffectToolbar.access$000(this.a, paramLong, null);
      this.a.mEarbackBtn.setVisibility(4);
      this.a.mApp.a().a().S = 0;
      this.a.mApp.a().A();
    }
    while (!paramlxf.jdField_a_of_type_Boolean) {
      return;
    }
    Object localObject3 = PtvTemplateManager.jdField_a_of_type_JavaLangString + paramlxf.jdField_c_of_type_JavaLangString;
    localObject2 = paramlxf.jdField_a_of_type_JavaLangString;
    boolean bool = this.a.isEffectBtnEnable();
    if (QLog.isColorLevel()) {
      QLog.w("EffectToolbar", 1, "onEffectClick, path[" + (String)localObject3 + "], bSuc[" + bool + "], seq[" + paramLong + "]");
    }
    EffectToolbar.access$000(this.a, paramLong, paramlxf.jdField_a_of_type_JavaLangString);
    awqp.b((String)localObject2);
    localObject3 = ((VideoController)localObject1).a();
    int i = ((kvq)localObject3).K;
    int j = ((kvq)localObject3).C;
    paramLong = ((VideoController)localObject1).f();
    localObject1 = (PendantItem)this.a.mPtvTemplateInfoMap.get(localObject2);
    QLog.i("EffectToolbar", 2, "onEffectClick voiceid : " + paramlxf.jdField_c_of_type_Int);
    this.a.mApp.a().a().S = paramlxf.jdField_c_of_type_Int;
    this.a.mApp.a().A();
    if (paramlxf.jdField_c_of_type_Int > 0)
    {
      this.a.mEarbackBtn.setVisibility(0);
      EffectToolbar.access$100(this.a);
    }
    for (;;)
    {
      kyb.b();
      lqz.a(j, i, paramLong, (String)localObject2, ((PendantItem)localObject1).getCategory());
      return;
      this.a.mEarbackBtn.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lst
 * JD-Core Version:    0.7.0.1
 */
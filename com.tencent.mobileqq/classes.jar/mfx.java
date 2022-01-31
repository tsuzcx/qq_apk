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

public class mfx
  implements mjp
{
  public mfx(EffectToolbar paramEffectToolbar) {}
  
  public void a(long paramLong)
  {
    EffectSettingUi.a(this.a.mApp, paramLong);
  }
  
  public void a(long paramLong, mkj parammkj)
  {
    EffectSettingUi.a(this.a.mApp, paramLong);
    Object localObject1 = VideoController.a();
    Object localObject2 = ((VideoController)localObject1).a(((AVActivity)this.a.mActivity.get()).getApplicationContext());
    if (localObject2 != null)
    {
      if (AudioHelper.e()) {
        QLog.w("EffectToolbar", 1, "onEffectClick, clearState, seq[" + paramLong + "], info[" + parammkj + "]");
      }
      ((lrz)localObject2).a(paramLong);
    }
    if (parammkj.jdField_a_of_type_JavaLangString.equals("0"))
    {
      EffectToolbar.access$000(this.a, paramLong, null);
      this.a.mEarbackBtn.setVisibility(4);
      this.a.mApp.a().a().U = 0;
      this.a.mApp.a().A();
    }
    while (!parammkj.jdField_a_of_type_Boolean) {
      return;
    }
    Object localObject3 = PtvTemplateManager.jdField_a_of_type_JavaLangString + parammkj.jdField_c_of_type_JavaLangString;
    localObject2 = parammkj.jdField_a_of_type_JavaLangString;
    boolean bool = this.a.isEffectBtnEnable();
    if (QLog.isColorLevel()) {
      QLog.w("EffectToolbar", 1, "onEffectClick, path[" + (String)localObject3 + "], bSuc[" + bool + "], seq[" + paramLong + "]");
    }
    EffectToolbar.access$000(this.a, paramLong, parammkj.jdField_a_of_type_JavaLangString);
    azqk.b((String)localObject2);
    localObject3 = ((VideoController)localObject1).a();
    int i = ((lid)localObject3).M;
    int j = ((lid)localObject3).E;
    paramLong = ((VideoController)localObject1).f();
    localObject1 = (PendantItem)this.a.mPtvTemplateInfoMap.get(localObject2);
    QLog.i("EffectToolbar", 2, "onEffectClick voiceid : " + parammkj.jdField_c_of_type_Int);
    this.a.mApp.a().a().U = parammkj.jdField_c_of_type_Int;
    this.a.mApp.a().A();
    if (parammkj.jdField_c_of_type_Int > 0)
    {
      this.a.mEarbackBtn.setVisibility(0);
      EffectToolbar.access$100(this.a);
    }
    for (;;)
    {
      lkp.b();
      meb.a(j, i, paramLong, (String)localObject2, ((PendantItem)localObject1).getCategory());
      return;
      this.a.mEarbackBtn.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mfx
 * JD-Core Version:    0.7.0.1
 */
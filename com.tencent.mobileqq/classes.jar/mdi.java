import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.av.ui.EffectSettingUi.2.1;
import com.tencent.av.ui.EffectSettingUi.2.2;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class mdi
  implements mph
{
  public mdi(EffectSettingUi paramEffectSettingUi) {}
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("EffectSettingUi", 4, "onGetConfig, enable[" + paramBoolean + "]");
    }
    if (paramBoolean)
    {
      Object localObject = this.a.jdField_a_of_type_JavaLangRefWeakReference;
      if (localObject != null)
      {
        localObject = (AVActivity)((WeakReference)localObject).get();
        if (localObject != null) {
          ((AVActivity)localObject).runOnUiThread(new EffectSettingUi.2.1(this));
        }
      }
      return;
    }
    this.a.jdField_a_of_type_Mph = null;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    long l = AudioHelper.b();
    if (QLog.isDevelopLevel()) {
      QLog.w("EffectSettingUi", 1, "onStatusChanged, seq[" + l + "]");
    }
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(new EffectSettingUi.2.2(this, l, paramBoolean3, paramBoolean1, paramBoolean2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mdi
 * JD-Core Version:    0.7.0.1
 */
import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.av.ui.redbag.AVRedBagMgr.Event;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class juh
  implements AVRedBagMgr.Event
{
  public juh(EffectSettingUi paramEffectSettingUi) {}
  
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
          ((AVActivity)localObject).runOnUiThread(new jui(this));
        }
      }
      return;
    }
    this.a.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagMgr$Event = null;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("EffectSettingUi", 4, "onStatusChanged");
    }
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(new juj(this, paramBoolean3, paramBoolean1, paramBoolean2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     juh
 * JD-Core Version:    0.7.0.1
 */
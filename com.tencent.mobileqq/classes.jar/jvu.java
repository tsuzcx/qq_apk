import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.opengl.effects.EffectController;
import com.tencent.av.ui.AVEffectReport;
import com.tencent.av.ui.EffectSettingBtn;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class jvu
  implements View.OnClickListener
{
  public jvu(EffectSettingUi paramEffectSettingUi) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    paramView = paramView.getTag(2131362549);
    if ((paramView != null) && ((paramView instanceof Boolean))) {}
    for (boolean bool1 = ((Boolean)paramView).booleanValue();; bool1 = false)
    {
      int j = this.a.jdField_a_of_type_Int;
      boolean bool2 = this.a.a(i, bool1);
      if (QLog.isDevelopLevel()) {
        QLog.d("EffectSettingUi", 4, "toolbar btn onClick, id[" + j + "->" + i + "], bFromPerformClick[" + bool1 + "], showSuc[" + bool2 + "]");
      }
      if ((bool2) && (j != i)) {
        this.a.a(Integer.valueOf(6105), Integer.valueOf(i));
      }
      if (bool2)
      {
        paramView = VideoController.a().a((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get());
        if (paramView != null)
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("EffectSettingUi", 1, "onShow clear state");
          }
          paramView.d(i);
        }
      }
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(165), Integer.valueOf(1) });
      if (j != i)
      {
        if (i != 1) {
          break label306;
        }
        AVEffectReport.b((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().F, this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().d, this.a.a(), bool2);
        if (QLog.isDevelopLevel()) {
          QLog.d("EffectSettingUi", 4, "[red dot] click qav_effect");
        }
      }
      label306:
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                if (i != 2) {
                  break;
                }
                AVEffectReport.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.a.a(), bool2);
                if (this.a.jdField_a_of_type_ComTencentAvUiEffectSettingBtn != null) {
                  this.a.jdField_a_of_type_ComTencentAvUiEffectSettingBtn.a();
                }
              } while (!QLog.isDevelopLevel());
              QLog.d("EffectSettingUi", 4, "[red dot] click qav_face");
              return;
              if (i != 4) {
                break;
              }
              AVEffectReport.a((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().F, this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().d, this.a.a(), bool2);
            } while (!QLog.isDevelopLevel());
            QLog.d("EffectSettingUi", 4, "[red dot] click qav_beauty");
            return;
            if (i != 3) {
              break;
            }
            AVEffectReport.a(this.a.a(), bool2);
          } while (!QLog.isDevelopLevel());
          QLog.d("EffectSettingUi", 4, "[red dot] click qav_doodle");
          return;
        } while (i != 5);
        AVEffectReport.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().F, this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().d, this.a.a(), bool2);
      } while (!QLog.isDevelopLevel());
      QLog.d("EffectSettingUi", 4, "[red dot] click qav_voice_change");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jvu
 * JD-Core Version:    0.7.0.1
 */
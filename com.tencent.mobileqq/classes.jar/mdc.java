import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.av.ui.funchat.filter.EffectFilterPanel;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class mdc
  implements View.OnClickListener
{
  public mdc(EffectSettingUi paramEffectSettingUi) {}
  
  public void onClick(View paramView)
  {
    long l = AudioHelper.b();
    int k = paramView.getId();
    paramView = paramView.getTag(2131376847);
    if ((paramView != null) && ((paramView instanceof Boolean))) {}
    for (boolean bool = ((Boolean)paramView).booleanValue();; bool = false)
    {
      int m = this.a.jdField_a_of_type_Int;
      bool = this.a.a(l, k, bool);
      int i;
      int j;
      if (k == 4)
      {
        i = 1;
        j = i;
        if (i != 0)
        {
          paramView = ((AVActivity)this.a.getContext()).a;
          if ((paramView != null) && ((paramView == null) || (paramView.getVisibility() != 8))) {
            break label321;
          }
          j = 1;
        }
        label109:
        if ((bool) && ((m != k) || (j != 0))) {
          this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(6105), Integer.valueOf(k), Long.valueOf(l) });
        }
        if (bool)
        {
          paramView = VideoController.a().a((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get());
          if (paramView != null)
          {
            if (QLog.isDevelopLevel()) {
              QLog.d("EffectSettingUi", 1, "onShow clear state");
            }
            paramView.b(k);
          }
        }
        this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(165), Integer.valueOf(1) });
        if (m != k)
        {
          if (k != 1) {
            break label326;
          }
          mbm.b((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().E, this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().d, this.a.a(), bool);
        }
      }
      label321:
      label326:
      label372:
      do
      {
        do
        {
          return;
          i = 0;
          break;
          j = 0;
          break label109;
          if (k != 2) {
            break label372;
          }
          mbm.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.a.a(), bool);
        } while (this.a.jdField_a_of_type_Mcz == null);
        this.a.jdField_a_of_type_Mcz.a();
        return;
        if (k == 4)
        {
          mbm.a((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().E, this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().d, this.a.a(), bool);
          return;
        }
        if (k == 3)
        {
          mbm.a(this.a.a(), bool);
          return;
        }
      } while (k != 5);
      mqw.f();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mdc
 * JD-Core Version:    0.7.0.1
 */
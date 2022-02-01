import android.os.Handler;
import android.widget.ImageView;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.filter.FilterItem;
import com.tencent.av.ui.funchat.filter.EffectFilterPanel;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class mnv
  implements moa
{
  moa jdField_a_of_type_Moa;
  
  public mnv(EffectFilterPanel paramEffectFilterPanel, moa parammoa)
  {
    a(parammoa);
  }
  
  public void a(long paramLong, int paramInt, String paramString)
  {
    if (AudioHelper.f()) {
      QLog.w("EffectFilterPanel", 1, "OnItemSelected, id[" + paramInt + "], name[" + paramString + "], seq[" + paramLong + "], Visibility[" + EffectFilterPanel.a(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel).getVisibility() + "], mlistener[" + this.jdField_a_of_type_Moa + "]");
    }
    if (EffectFilterPanel.a(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel).getVisibility() == 0)
    {
      EffectFilterPanel.a(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel).removeCallbacks(EffectFilterPanel.a(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel));
      EffectFilterPanel.a(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel).clearAnimation();
      EffectFilterPanel.a(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel).setVisibility(8);
    }
    paramString = (FilterItem)EffectFilterPanel.a(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel).a(paramString);
    EffectFilterPanel.a(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel).a(paramLong, paramString);
    if (paramString != null)
    {
      if (!paramString.isUsable()) {
        EffectFilterPanel.a(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel).a(paramLong, paramString);
      }
      bdks.c(paramString.getId());
      if ((paramString.getId() != null) && (paramString.getId().compareToIgnoreCase("MANHUA") == 0)) {
        EffectFilterPanel.a(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel).a().f(51, paramString.getId());
      }
    }
    else
    {
      return;
    }
    EffectFilterPanel.a(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel).a().f(0, paramString.getId());
  }
  
  public void a(moa parammoa)
  {
    this.jdField_a_of_type_Moa = parammoa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mnv
 * JD-Core Version:    0.7.0.1
 */
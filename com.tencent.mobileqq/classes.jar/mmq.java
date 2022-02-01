import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.av.ui.VoiceChangeToolbar;

public class mmq
  implements mht
{
  public mmq(VoiceChangeToolbar paramVoiceChangeToolbar) {}
  
  public void a(long paramLong)
  {
    EffectSettingUi.a(this.a.mApp, paramLong);
  }
  
  public void a(long paramLong, min parammin)
  {
    lbd.g(VoiceChangeToolbar.TAG, "onEffectClick| voiceType=" + parammin.jdField_a_of_type_JavaLangString);
    lfe locallfe = this.a.mApp.a().a();
    int i = Integer.parseInt(parammin.jdField_a_of_type_JavaLangString);
    if (i == 0) {
      ltm.a().b(64);
    }
    while (i == 0)
    {
      locallfe.v = null;
      locallfe.U = i;
      locallfe.V = 0;
      parammin = this.a.getAVActivity();
      if ((parammin != null) && (parammin.a != null)) {
        parammin.a.i(paramLong, 8);
      }
      this.a.mApp.a().z();
      mmo.a(locallfe, i);
      EffectSettingUi.a(this.a.mApp, paramLong);
      if (locallfe.d == 4) {
        bdks.e(String.valueOf(i));
      }
      return;
      ltm.a().a(64);
    }
    if ((parammin.jdField_a_of_type_JavaLangObject instanceof mmn)) {}
    for (locallfe.v = ((mmn)parammin.jdField_a_of_type_JavaLangObject).b;; locallfe.v = parammin.b)
    {
      msa.a(parammin.jdField_a_of_type_JavaLangString);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mmq
 * JD-Core Version:    0.7.0.1
 */
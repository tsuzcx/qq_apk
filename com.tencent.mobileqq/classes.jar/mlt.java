import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.av.ui.VoiceChangeToolbar;

public class mlt
  implements mhc
{
  public mlt(VoiceChangeToolbar paramVoiceChangeToolbar) {}
  
  public void a(long paramLong)
  {
    EffectSettingUi.a(this.a.mApp, paramLong);
  }
  
  public void a(long paramLong, mhw parammhw)
  {
    lcl.d(VoiceChangeToolbar.TAG, "onEffectClick| voiceType=" + parammhw.jdField_a_of_type_JavaLangString);
    lgf locallgf = this.a.mApp.a().a();
    int i = Integer.parseInt(parammhw.jdField_a_of_type_JavaLangString);
    if (i == 0) {
      ltr.a().b(64);
    }
    while (i == 0)
    {
      locallgf.v = null;
      locallgf.T = i;
      locallgf.U = 0;
      parammhw = this.a.getAVActivity();
      if ((parammhw != null) && (parammhw.a != null)) {
        parammhw.a.f(paramLong, 8);
      }
      this.a.mApp.a().A();
      mlr.a(locallgf, i);
      EffectSettingUi.a(this.a.mApp, paramLong);
      if (locallgf.d == 4) {
        axqo.e(String.valueOf(i));
      }
      return;
      ltr.a().a(64);
    }
    if ((parammhw.jdField_a_of_type_JavaLangObject instanceof mlq)) {}
    for (locallgf.v = ((mlq)parammhw.jdField_a_of_type_JavaLangObject).b;; locallgf.v = parammhw.b)
    {
      mqz.a(parammhw.jdField_a_of_type_JavaLangString);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mlt
 * JD-Core Version:    0.7.0.1
 */
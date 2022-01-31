import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.av.ui.VoiceChangeToolbar;

public class mlq
  implements mgx
{
  public mlq(VoiceChangeToolbar paramVoiceChangeToolbar) {}
  
  public void a(long paramLong)
  {
    EffectSettingUi.a(this.a.mApp, paramLong);
  }
  
  public void a(long paramLong, mhr parammhr)
  {
    lcg.d(VoiceChangeToolbar.TAG, "onEffectClick| voiceType=" + parammhr.jdField_a_of_type_JavaLangString);
    lga locallga = this.a.mApp.a().a();
    int i = Integer.parseInt(parammhr.jdField_a_of_type_JavaLangString);
    if (i == 0) {
      ltm.a().b(64);
    }
    while (i == 0)
    {
      locallga.v = null;
      locallga.T = i;
      locallga.U = 0;
      parammhr = this.a.getAVActivity();
      if ((parammhr != null) && (parammhr.a != null)) {
        parammhr.a.f(paramLong, 8);
      }
      this.a.mApp.a().A();
      mlo.a(locallga, i);
      EffectSettingUi.a(this.a.mApp, paramLong);
      if (locallga.d == 4) {
        axqq.e(String.valueOf(i));
      }
      return;
      ltm.a().a(64);
    }
    if ((parammhr.jdField_a_of_type_JavaLangObject instanceof mln)) {}
    for (locallga.v = ((mln)parammhr.jdField_a_of_type_JavaLangObject).b;; locallga.v = parammhr.b)
    {
      mqw.a(parammhr.jdField_a_of_type_JavaLangString);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mlq
 * JD-Core Version:    0.7.0.1
 */
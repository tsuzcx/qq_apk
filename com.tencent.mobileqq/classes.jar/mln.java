import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.av.ui.VoiceChangeToolbar;

public class mln
  implements mgs
{
  public mln(VoiceChangeToolbar paramVoiceChangeToolbar) {}
  
  public void a(long paramLong)
  {
    EffectSettingUi.a(this.a.mApp, paramLong);
  }
  
  public void a(long paramLong, mhm parammhm)
  {
    lbc.d(VoiceChangeToolbar.TAG, "onEffectClick| voiceType=" + parammhm.jdField_a_of_type_JavaLangString);
    ley localley = this.a.mApp.a().a();
    int i = Integer.parseInt(parammhm.jdField_a_of_type_JavaLangString);
    if (i == 0) {
      lsv.a().b(64);
    }
    while (i == 0)
    {
      localley.v = null;
      localley.U = i;
      localley.V = 0;
      parammhm = this.a.getAVActivity();
      if ((parammhm != null) && (parammhm.a != null)) {
        parammhm.a.f(paramLong, 8);
      }
      this.a.mApp.a().A();
      mll.a(localley, i);
      EffectSettingUi.a(this.a.mApp, paramLong);
      if (localley.d == 4) {
        bcsl.e(String.valueOf(i));
      }
      return;
      lsv.a().a(64);
    }
    if ((parammhm.jdField_a_of_type_JavaLangObject instanceof mlk)) {}
    for (localley.v = ((mlk)parammhm.jdField_a_of_type_JavaLangObject).b;; localley.v = parammhm.b)
    {
      mqw.a(parammhm.jdField_a_of_type_JavaLangString);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mln
 * JD-Core Version:    0.7.0.1
 */
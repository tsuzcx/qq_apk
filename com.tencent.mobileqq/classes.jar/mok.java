import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.av.ui.VoiceChangeToolbar;

public class mok
  implements mjp
{
  public mok(VoiceChangeToolbar paramVoiceChangeToolbar) {}
  
  public void a(long paramLong)
  {
    EffectSettingUi.a(this.a.mApp, paramLong);
  }
  
  public void a(long paramLong, mkj parammkj)
  {
    lek.d(VoiceChangeToolbar.TAG, "onEffectClick| voiceType=" + parammkj.jdField_a_of_type_JavaLangString);
    lid locallid = this.a.mApp.a().a();
    int i = Integer.parseInt(parammkj.jdField_a_of_type_JavaLangString);
    if (i == 0) {
      lvt.a().b(64);
    }
    while (i == 0)
    {
      locallid.v = null;
      locallid.T = i;
      locallid.U = 0;
      parammkj = this.a.getAVActivity();
      if ((parammkj != null) && (parammkj.a != null)) {
        parammkj.a.f(paramLong, 8);
      }
      this.a.mApp.a().A();
      moi.a(locallid, i);
      EffectSettingUi.a(this.a.mApp, paramLong);
      if (locallid.d == 4) {
        azqk.e(String.valueOf(i));
      }
      return;
      lvt.a().a(64);
    }
    if ((parammkj.jdField_a_of_type_JavaLangObject instanceof moh)) {}
    for (locallid.v = ((moh)parammkj.jdField_a_of_type_JavaLangObject).b;; locallid.v = parammkj.b)
    {
      mtq.a(parammkj.jdField_a_of_type_JavaLangString);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mok
 * JD-Core Version:    0.7.0.1
 */
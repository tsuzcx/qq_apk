import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.av.ui.VoiceChangeToolbar;

public class mmk
  implements mho
{
  public mmk(VoiceChangeToolbar paramVoiceChangeToolbar) {}
  
  public void a(long paramLong)
  {
    EffectSettingUi.a(this.a.mApp, paramLong);
  }
  
  public void a(long paramLong, mii parammii)
  {
    lbj.d(VoiceChangeToolbar.TAG, "onEffectClick| voiceType=" + parammii.jdField_a_of_type_JavaLangString);
    lff locallff = this.a.mApp.a().a();
    int i = Integer.parseInt(parammii.jdField_a_of_type_JavaLangString);
    if (i == 0) {
      ltr.a().b(64);
    }
    while (i == 0)
    {
      locallff.v = null;
      locallff.U = i;
      locallff.V = 0;
      parammii = this.a.getAVActivity();
      if ((parammii != null) && (parammii.a != null)) {
        parammii.a.i(paramLong, 8);
      }
      this.a.mApp.a().A();
      mmi.a(locallff, i);
      EffectSettingUi.a(this.a.mApp, paramLong);
      if (locallff.d == 4) {
        bdld.e(String.valueOf(i));
      }
      return;
      ltr.a().a(64);
    }
    if ((parammii.jdField_a_of_type_JavaLangObject instanceof mmh)) {}
    for (locallff.v = ((mmh)parammii.jdField_a_of_type_JavaLangObject).b;; locallff.v = parammii.b)
    {
      mru.a(parammii.jdField_a_of_type_JavaLangString);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mmk
 * JD-Core Version:    0.7.0.1
 */
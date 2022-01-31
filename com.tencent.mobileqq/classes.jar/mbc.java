import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.av.ui.VoiceChangeToolbar;

public class mbc
  implements lwk
{
  public mbc(VoiceChangeToolbar paramVoiceChangeToolbar) {}
  
  public void a(long paramLong)
  {
    EffectSettingUi.a(this.a.mApp, paramLong);
  }
  
  public void a(long paramLong, lxf paramlxf)
  {
    krx.d(VoiceChangeToolbar.TAG, "onEffectClick| voiceType=" + paramlxf.jdField_a_of_type_JavaLangString);
    kvq localkvq = this.a.mApp.a().a();
    int i = Integer.parseInt(paramlxf.jdField_a_of_type_JavaLangString);
    if (i == 0) {
      lja.a().b(64);
    }
    while (i == 0)
    {
      localkvq.u = null;
      localkvq.R = i;
      localkvq.S = 0;
      paramlxf = this.a.getAVActivity();
      if ((paramlxf != null) && (paramlxf.a != null)) {
        paramlxf.a.f(paramLong, 8);
      }
      this.a.mApp.a().A();
      mba.a(localkvq, i);
      EffectSettingUi.a(this.a.mApp, paramLong);
      if (localkvq.d == 4) {
        awqp.e(String.valueOf(i));
      }
      return;
      lja.a().a(64);
    }
    if ((paramlxf.jdField_a_of_type_JavaLangObject instanceof maz)) {}
    for (localkvq.u = ((maz)paramlxf.jdField_a_of_type_JavaLangObject).b;; localkvq.u = paramlxf.b)
    {
      mga.a(paramlxf.jdField_a_of_type_JavaLangString);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mbc
 * JD-Core Version:    0.7.0.1
 */
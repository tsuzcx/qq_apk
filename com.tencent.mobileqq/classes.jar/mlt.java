import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.av.ui.VoiceChangeToolbar;

public class mlt
  implements mgx
{
  public mlt(VoiceChangeToolbar paramVoiceChangeToolbar) {}
  
  public void a(long paramLong)
  {
    EffectSettingUi.a(this.a.mApp, paramLong);
  }
  
  public void a(long paramLong, mhr parammhr)
  {
    lba.g(VoiceChangeToolbar.TAG, "onEffectClick| voiceType=" + parammhr.jdField_a_of_type_JavaLangString);
    lez locallez = this.a.mApp.a().a();
    int i = Integer.parseInt(parammhr.jdField_a_of_type_JavaLangString);
    if (i == 0) {
      lsz.a().b(64);
    }
    while (i == 0)
    {
      locallez.v = null;
      locallez.U = i;
      locallez.V = 0;
      parammhr = this.a.getAVActivity();
      if ((parammhr != null) && (parammhr.a != null)) {
        parammhr.a.i(paramLong, 8);
      }
      this.a.mApp.a().z();
      mlr.a(locallez, i);
      EffectSettingUi.a(this.a.mApp, paramLong);
      if (locallez.d == 4) {
        bcdx.e(String.valueOf(i));
      }
      return;
      lsz.a().a(64);
    }
    if ((parammhr.jdField_a_of_type_JavaLangObject instanceof mlq)) {}
    for (locallez.v = ((mlq)parammhr.jdField_a_of_type_JavaLangObject).b;; locallez.v = parammhr.b)
    {
      mrd.a(parammhr.jdField_a_of_type_JavaLangString);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mlt
 * JD-Core Version:    0.7.0.1
 */
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.av.ui.funchat.zimu.ZimuToolbar;
import com.tencent.qphone.base.util.QLog;

public class mpa
  implements mho
{
  public mpa(ZimuToolbar paramZimuToolbar) {}
  
  public void a(long paramLong)
  {
    EffectSettingUi.a(ZimuToolbar.access$400(this.a), paramLong);
  }
  
  public void a(long paramLong, mii parammii)
  {
    EffectSettingUi.a(ZimuToolbar.access$000(this.a), paramLong);
    QLog.w("ZimuToolbar", 1, "onEffectClick, 自己点击了字幕, id[" + parammii.a + "], seq[" + paramLong + "]");
    ZimuToolbar.access$100(this.a, paramLong, parammii.a);
    if ((!TextUtils.isEmpty(parammii.a)) && (!"0".equalsIgnoreCase(parammii.a)))
    {
      liy.a("0X80085CD", parammii.a);
      if (liw.a(parammii.a))
      {
        parammii = ZimuToolbar.access$200(this.a).a().a().d;
        String str = ZimuToolbar.access$300(this.a).getCurrentAccountUin();
        liy.a("0X8009191", str, parammii);
        liy.a("0X8009192", str, parammii);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mpa
 * JD-Core Version:    0.7.0.1
 */
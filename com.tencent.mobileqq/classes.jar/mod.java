import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.av.ui.funchat.zimu.ZimuToolbar;
import com.tencent.qphone.base.util.QLog;

public class mod
  implements mgs
{
  public mod(ZimuToolbar paramZimuToolbar) {}
  
  public void a(long paramLong)
  {
    EffectSettingUi.a(ZimuToolbar.access$400(this.a), paramLong);
  }
  
  public void a(long paramLong, mhm parammhm)
  {
    EffectSettingUi.a(ZimuToolbar.access$000(this.a), paramLong);
    QLog.w("ZimuToolbar", 1, "onEffectClick, 自己点击了字幕, id[" + parammhm.a + "], seq[" + paramLong + "]");
    ZimuToolbar.access$100(this.a, paramLong, parammhm.a);
    if ((!TextUtils.isEmpty(parammhm.a)) && (!"0".equalsIgnoreCase(parammhm.a)))
    {
      liq.a("0X80085CD", parammhm.a);
      if (lio.a(parammhm.a))
      {
        parammhm = ZimuToolbar.access$200(this.a).a().a().d;
        String str = ZimuToolbar.access$300(this.a).getCurrentAccountUin();
        liq.a("0X8009191", str, parammhm);
        liq.a("0X8009192", str, parammhm);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mod
 * JD-Core Version:    0.7.0.1
 */
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.av.ui.funchat.zimu.ZimuToolbar;
import com.tencent.qphone.base.util.QLog;

public class moh
  implements mhc
{
  public moh(ZimuToolbar paramZimuToolbar) {}
  
  public void a(long paramLong)
  {
    EffectSettingUi.a(ZimuToolbar.access$400(this.a), paramLong);
  }
  
  public void a(long paramLong, mhw parammhw)
  {
    EffectSettingUi.a(ZimuToolbar.access$000(this.a), paramLong);
    QLog.w("ZimuToolbar", 1, "onEffectClick, 自己点击了字幕, id[" + parammhw.a + "], seq[" + paramLong + "]");
    ZimuToolbar.access$100(this.a, paramLong, parammhw.a);
    if ((!TextUtils.isEmpty(parammhw.a)) && (!"0".equalsIgnoreCase(parammhw.a)))
    {
      ljv.a("0X80085CD", parammhw.a);
      if (ljt.a(parammhw.a))
      {
        parammhw = ZimuToolbar.access$200(this.a).a().a().d;
        String str = ZimuToolbar.access$300(this.a).getCurrentAccountUin();
        ljv.a("0X8009191", str, parammhw);
        ljv.a("0X8009192", str, parammhw);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     moh
 * JD-Core Version:    0.7.0.1
 */
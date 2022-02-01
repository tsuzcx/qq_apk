import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.av.ui.funchat.zimu.ZimuToolbar;
import com.tencent.qphone.base.util.QLog;

public class mpg
  implements mht
{
  public mpg(ZimuToolbar paramZimuToolbar) {}
  
  public void a(long paramLong)
  {
    EffectSettingUi.a(ZimuToolbar.access$400(this.a), paramLong);
  }
  
  public void a(long paramLong, min parammin)
  {
    EffectSettingUi.a(ZimuToolbar.access$000(this.a), paramLong);
    QLog.w("ZimuToolbar", 1, "onEffectClick, 自己点击了字幕, id[" + parammin.a + "], seq[" + paramLong + "]");
    ZimuToolbar.access$100(this.a, paramLong, parammin.a);
    if ((!TextUtils.isEmpty(parammin.a)) && (!"0".equalsIgnoreCase(parammin.a)))
    {
      lje.a("0X80085CD", parammin.a);
      if (ljc.a(parammin.a))
      {
        parammin = ZimuToolbar.access$200(this.a).a().a().d;
        String str = ZimuToolbar.access$300(this.a).getCurrentAccountUin();
        lje.a("0X8009191", str, parammin);
        lje.a("0X8009192", str, parammin);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mpg
 * JD-Core Version:    0.7.0.1
 */
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.av.ui.funchat.zimu.ZimuToolbar;
import com.tencent.qphone.base.util.QLog;

public class moj
  implements mgx
{
  public moj(ZimuToolbar paramZimuToolbar) {}
  
  public void a(long paramLong)
  {
    EffectSettingUi.a(ZimuToolbar.access$400(this.a), paramLong);
  }
  
  public void a(long paramLong, mhr parammhr)
  {
    EffectSettingUi.a(ZimuToolbar.access$000(this.a), paramLong);
    QLog.w("ZimuToolbar", 1, "onEffectClick, 自己点击了字幕, id[" + parammhr.a + "], seq[" + paramLong + "]");
    ZimuToolbar.access$100(this.a, paramLong, parammhr.a);
    if ((!TextUtils.isEmpty(parammhr.a)) && (!"0".equalsIgnoreCase(parammhr.a)))
    {
      lis.a("0X80085CD", parammhr.a);
      if (liq.a(parammhr.a))
      {
        parammhr = ZimuToolbar.access$200(this.a).a().a().d;
        String str = ZimuToolbar.access$300(this.a).getCurrentAccountUin();
        lis.a("0X8009191", str, parammhr);
        lis.a("0X8009192", str, parammhr);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     moj
 * JD-Core Version:    0.7.0.1
 */
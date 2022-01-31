import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.av.ui.funchat.zimu.ZimuToolbar;
import com.tencent.qphone.base.util.QLog;

public class mqy
  implements mjp
{
  public mqy(ZimuToolbar paramZimuToolbar) {}
  
  public void a(long paramLong)
  {
    EffectSettingUi.a(ZimuToolbar.access$400(this.a), paramLong);
  }
  
  public void a(long paramLong, mkj parammkj)
  {
    EffectSettingUi.a(ZimuToolbar.access$000(this.a), paramLong);
    QLog.w("ZimuToolbar", 1, "onEffectClick, 自己点击了字幕, id[" + parammkj.a + "], seq[" + paramLong + "]");
    ZimuToolbar.access$100(this.a, paramLong, parammkj.a);
    if ((!TextUtils.isEmpty(parammkj.a)) && (!"0".equalsIgnoreCase(parammkj.a)))
    {
      llt.a("0X80085CD", parammkj.a);
      if (llr.a(parammkj.a))
      {
        parammkj = ZimuToolbar.access$200(this.a).a().a().d;
        String str = ZimuToolbar.access$300(this.a).getCurrentAccountUin();
        llt.a("0X8009191", str, parammkj);
        llt.a("0X8009192", str, parammkj);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mqy
 * JD-Core Version:    0.7.0.1
 */
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.av.ui.funchat.zimu.ZimuToolbar;
import com.tencent.qphone.base.util.QLog;

public class mdi
  implements lwk
{
  public mdi(ZimuToolbar paramZimuToolbar) {}
  
  public void a(long paramLong)
  {
    EffectSettingUi.a(ZimuToolbar.access$400(this.a), paramLong);
  }
  
  public void a(long paramLong, lxf paramlxf)
  {
    EffectSettingUi.a(ZimuToolbar.access$000(this.a), paramLong);
    QLog.w("ZimuToolbar", 1, "onEffectClick, 自己点击了字幕, id[" + paramlxf.a + "], seq[" + paramLong + "]");
    ZimuToolbar.access$100(this.a, paramLong, paramlxf.a);
    if ((!TextUtils.isEmpty(paramlxf.a)) && (!"0".equalsIgnoreCase(paramlxf.a)))
    {
      kzf.a("0X80085CD", paramlxf.a);
      if (kzd.a(paramlxf.a))
      {
        paramlxf = ZimuToolbar.access$200(this.a).a().a().d;
        String str = ZimuToolbar.access$300(this.a).getCurrentAccountUin();
        kzf.a("0X8009191", str, paramlxf);
        kzf.a("0X8009192", str, paramlxf);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mdi
 * JD-Core Version:    0.7.0.1
 */
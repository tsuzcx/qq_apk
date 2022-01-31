import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.zimu.ARZimuUtil;
import com.tencent.av.business.manager.zimu.EffectZimuManager.DataReport;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.av.ui.QAVPtvTemplateAdapter.IEffectCallback;
import com.tencent.av.ui.QavListItemBase.ItemInfo;
import com.tencent.av.ui.funchat.zimu.ZimuToolbar;

public class kea
  implements QAVPtvTemplateAdapter.IEffectCallback
{
  public kea(ZimuToolbar paramZimuToolbar) {}
  
  public void a()
  {
    EffectSettingUi.a(ZimuToolbar.access$300(this.a));
  }
  
  public void a(QavListItemBase.ItemInfo paramItemInfo)
  {
    ZimuToolbar.access$000(this.a, paramItemInfo.a);
    if ((!TextUtils.isEmpty(paramItemInfo.a)) && (!"0".equalsIgnoreCase(paramItemInfo.a)))
    {
      EffectZimuManager.DataReport.a("0X80085CD", paramItemInfo.a);
      if (ARZimuUtil.a(paramItemInfo.a))
      {
        paramItemInfo = ZimuToolbar.access$100(this.a).a().a().c;
        String str = ZimuToolbar.access$200(this.a).getCurrentAccountUin();
        EffectZimuManager.DataReport.a("0X8009191", str, paramItemInfo);
        EffectZimuManager.DataReport.a("0X8009192", str, paramItemInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kea
 * JD-Core Version:    0.7.0.1
 */
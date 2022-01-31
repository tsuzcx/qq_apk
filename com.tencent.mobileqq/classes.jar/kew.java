import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.av.ui.QAVPtvTemplateAdapter.IEffectCallback;
import com.tencent.av.ui.QavListItemBase.ItemInfo;
import com.tencent.av.ui.VoiceChangeDataReport;
import com.tencent.av.ui.VoiceChangeToolbar;
import com.tencent.mobileqq.statistics.MultiVideoRichActionReportCollection;

public class kew
  implements QAVPtvTemplateAdapter.IEffectCallback
{
  public kew(VoiceChangeToolbar paramVoiceChangeToolbar) {}
  
  public void a()
  {
    EffectSettingUi.a(this.a.mApp);
  }
  
  public void a(QavListItemBase.ItemInfo paramItemInfo)
  {
    AVLog.d(VoiceChangeToolbar.TAG, "onEffectClick| voiceType=" + paramItemInfo.a);
    int i = Integer.parseInt(paramItemInfo.a);
    this.a.mApp.a().a().S = i;
    this.a.mApp.a().a().T = 0;
    this.a.mApp.a().K();
    VoiceChangeDataReport.a(this.a.mApp.a().a(), i);
    EffectSettingUi.a(this.a.mApp);
    if (this.a.mApp.a().a().d == 4) {
      MultiVideoRichActionReportCollection.e(String.valueOf(i));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     kew
 * JD-Core Version:    0.7.0.1
 */
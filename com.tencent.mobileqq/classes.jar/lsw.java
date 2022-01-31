import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.magicface.FaceItem;
import com.tencent.av.business.manager.voiceRecog.VoiceRecogTips;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.av.ui.FaceToolbar;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class lsw
  implements lwk
{
  public lsw(FaceToolbar paramFaceToolbar) {}
  
  public void a(long paramLong)
  {
    EffectSettingUi.a(this.a.mApp, paramLong);
  }
  
  public void a(long paramLong, lxf paramlxf)
  {
    int j = 1;
    if (AudioHelper.e()) {
      QLog.w(FaceToolbar.TAG, 1, "onEffectClick, seq[" + paramLong + "], id[" + paramlxf.a + "]");
    }
    EffectSettingUi.a(this.a.mApp, paramLong);
    Object localObject = this.a.mApp.a();
    if (this.a.checkDimmStatus(paramlxf)) {
      return;
    }
    localObject = ((VideoController)localObject).a(this.a.mApp.a().a().d) + "";
    VoiceRecogTips.a(this.a.mApp, paramlxf);
    if (paramlxf.a.equals("0"))
    {
      this.a.notifyEvent(Integer.valueOf(6101), null, Boolean.valueOf(true));
      kxl.a(2, (String)localObject);
      kxl.a(2);
      return;
    }
    AudioHelper.a(paramlxf.a, false);
    new lrz(paramLong, paramlxf.a, true, 1).a(this.a.mApp);
    FaceItem localFaceItem = (FaceItem)this.a.mFaceManager.a(paramlxf.a);
    int i = j;
    if (localFaceItem != null)
    {
      if (!localFaceItem.getType().equalsIgnoreCase("face")) {
        break label278;
      }
      i = j;
    }
    for (;;)
    {
      kxl.a(paramlxf.a, i, (String)localObject);
      kxl.a(paramlxf.a, i);
      return;
      label278:
      if (localFaceItem.getType().equalsIgnoreCase("pendant"))
      {
        i = 2;
      }
      else if (localFaceItem.getType().equalsIgnoreCase("voicesticker"))
      {
        i = 3;
      }
      else
      {
        i = j;
        if (localFaceItem.getType().equalsIgnoreCase("creativecop")) {
          i = 4;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lsw
 * JD-Core Version:    0.7.0.1
 */
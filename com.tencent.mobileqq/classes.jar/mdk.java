import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.magicface.FaceItem;
import com.tencent.av.business.manager.voiceRecog.VoiceRecogTips;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.av.ui.FaceToolbar;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class mdk
  implements mgx
{
  public mdk(FaceToolbar paramFaceToolbar) {}
  
  public void a(long paramLong)
  {
    EffectSettingUi.a(this.a.mApp, paramLong);
  }
  
  public void a(long paramLong, mhr parammhr)
  {
    int j = 1;
    if (AudioHelper.e()) {
      QLog.w(FaceToolbar.TAG, 1, "onEffectClick, seq[" + paramLong + "], id[" + parammhr.a + "]");
    }
    EffectSettingUi.a(this.a.mApp, paramLong);
    Object localObject = this.a.mApp.a();
    if (this.a.checkDimmStatus(parammhr)) {}
    do
    {
      return;
      localObject = ((VideoController)localObject).a(this.a.mApp.a().a().d) + "";
      VoiceRecogTips.a(this.a.mApp, parammhr);
      if (!parammhr.a.equals("0")) {
        break;
      }
      this.a.notifyEvent(Integer.valueOf(6101), null, Boolean.valueOf(true));
      lhu.a(2, (String)localObject);
      lhu.a(2);
    } while (!this.a.mApp.a(13));
    ((lig)this.a.mApp.a(13)).a(paramLong, "onEffectClick2");
    return;
    AudioHelper.a(parammhr.a, false);
    new mck(paramLong, parammhr.a, true, 1).a(this.a.mApp);
    FaceItem localFaceItem = (FaceItem)this.a.mFaceManager.a(parammhr.a);
    int i = j;
    if (localFaceItem != null)
    {
      if (!localFaceItem.getType().equalsIgnoreCase("face")) {
        break label314;
      }
      i = j;
    }
    for (;;)
    {
      lhu.a(parammhr.a, i, (String)localObject);
      lhu.a(parammhr.a, i);
      return;
      label314:
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
 * Qualified Name:     mdk
 * JD-Core Version:    0.7.0.1
 */
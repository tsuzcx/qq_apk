import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.magicface.FaceItem;
import com.tencent.av.business.manager.voiceRecog.VoiceRecogTips;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.av.ui.FaceToolbar;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class mef
  implements mht
{
  public mef(FaceToolbar paramFaceToolbar) {}
  
  public void a(long paramLong)
  {
    EffectSettingUi.a(this.a.mApp, paramLong);
  }
  
  public void a(long paramLong, min parammin)
  {
    boolean bool = false;
    int j = 1;
    if (AudioHelper.f()) {
      QLog.w(FaceToolbar.TAG, 1, "onEffectClick, seq[" + paramLong + "], id[" + parammin.jdField_a_of_type_JavaLangString + "]");
    }
    EffectSettingUi.a(this.a.mApp, paramLong);
    Object localObject = this.a.mApp.a();
    if (this.a.checkDimmStatus(parammin)) {}
    do
    {
      return;
      localObject = ((VideoController)localObject).a(this.a.mApp.a().a().d) + "";
      VoiceRecogTips.a(this.a.mApp, parammin);
      if (!parammin.jdField_a_of_type_JavaLangString.equals("0")) {
        break;
      }
      this.a.notifyEvent(Integer.valueOf(6101), null, Boolean.valueOf(true));
      lhg.a(2, (String)localObject);
      lhg.a(2);
    } while (!this.a.mApp.a(13));
    ((lhs)this.a.mApp.a(13)).a(paramLong, "onEffectClick2");
    return;
    AudioHelper.a(parammin.jdField_a_of_type_JavaLangString, false);
    if ((parammin.jdField_a_of_type_Int == 1) && (!mdc.c) && (mdc.b == 4) && (TextUtils.equals(mdc.d, parammin.jdField_a_of_type_JavaLangString)) && (this.a.mAdapterPendant.a() != parammin)) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i(FaceToolbar.TAG, 2, "onEffectClick_Check, type[" + parammin.jdField_a_of_type_Int + "], sLastSenderFlag[" + mdc.c + "], sLastItemId[" + mdc.d + "], sLastFrom[" + mdc.b + "], id[" + parammin.jdField_a_of_type_JavaLangString + "], isSender[" + bool + "], click[" + this.a.mAdapterPendant.a() + "], info[" + parammin + "]");
      }
      new mdc(paramLong, parammin.jdField_a_of_type_JavaLangString, bool, 1).a(this.a.mApp);
      FaceItem localFaceItem = (FaceItem)this.a.mFaceManager.a(parammin.jdField_a_of_type_JavaLangString);
      int i = j;
      if (localFaceItem != null)
      {
        if (!localFaceItem.getType().equalsIgnoreCase("face")) {
          break label488;
        }
        i = j;
      }
      for (;;)
      {
        lhg.a(parammin.jdField_a_of_type_JavaLangString, i, (String)localObject);
        lhg.a(parammin.jdField_a_of_type_JavaLangString, i);
        return;
        label488:
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
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mef
 * JD-Core Version:    0.7.0.1
 */
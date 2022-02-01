import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.magicface.FaceItem;
import com.tencent.av.business.manager.voiceRecog.VoiceRecogTips;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.av.ui.FaceToolbar;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class mea
  implements mho
{
  public mea(FaceToolbar paramFaceToolbar) {}
  
  public void a(long paramLong)
  {
    EffectSettingUi.a(this.a.mApp, paramLong);
  }
  
  public void a(long paramLong, mii parammii)
  {
    boolean bool = false;
    int j = 1;
    if (AudioHelper.f()) {
      QLog.w(FaceToolbar.TAG, 1, "onEffectClick, seq[" + paramLong + "], id[" + parammii.jdField_a_of_type_JavaLangString + "]");
    }
    EffectSettingUi.a(this.a.mApp, paramLong);
    Object localObject = this.a.mApp.a();
    if (this.a.checkDimmStatus(parammii)) {}
    do
    {
      return;
      localObject = ((VideoController)localObject).a(this.a.mApp.a().a().d) + "";
      VoiceRecogTips.a(this.a.mApp, parammii);
      if (!parammii.jdField_a_of_type_JavaLangString.equals("0")) {
        break;
      }
      this.a.notifyEvent(Integer.valueOf(6101), null, Boolean.valueOf(true));
      lha.a(2, (String)localObject);
      lha.a(2);
    } while (!this.a.mApp.a(13));
    ((lhm)this.a.mApp.a(13)).a(paramLong, "onEffectClick2");
    return;
    AudioHelper.a(parammii.jdField_a_of_type_JavaLangString, false);
    if ((parammii.jdField_a_of_type_Int == 1) && (!mcy.c) && (mcy.b == 4) && (TextUtils.equals(mcy.d, parammii.jdField_a_of_type_JavaLangString)) && (this.a.mAdapterPendant.a() != parammii)) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i(FaceToolbar.TAG, 2, "onEffectClick_Check, type[" + parammii.jdField_a_of_type_Int + "], sLastSenderFlag[" + mcy.c + "], sLastItemId[" + mcy.d + "], sLastFrom[" + mcy.b + "], id[" + parammii.jdField_a_of_type_JavaLangString + "], isSender[" + bool + "], click[" + this.a.mAdapterPendant.a() + "], info[" + parammii + "]");
      }
      new mcy(paramLong, parammii.jdField_a_of_type_JavaLangString, bool, 1).a(this.a.mApp);
      FaceItem localFaceItem = (FaceItem)this.a.mFaceManager.a(parammii.jdField_a_of_type_JavaLangString);
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
        lha.a(parammii.jdField_a_of_type_JavaLangString, i, (String)localObject);
        lha.a(parammii.jdField_a_of_type_JavaLangString, i);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mea
 * JD-Core Version:    0.7.0.1
 */
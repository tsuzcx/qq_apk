package dov.com.qq.im;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.tribe.fragment.TribeEffectsCameraCaptureFragment;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import dov.com.qq.im.ae.AEPituCameraUnit;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.music.QimMusicPlayer;
import dov.com.qq.im.setting.CaptureEntranceParams;
import dov.com.qq.im.setting.ICameraEntrance;
import dov.com.qq.im.setting.IQIMCameraContainer;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;

public class QIMTribeEffectsCameraCaptureUnit
  extends AEPituCameraUnit
{
  public static int a;
  
  static
  {
    jdField_a_of_type_Int = 60000;
  }
  
  public QIMTribeEffectsCameraCaptureUnit(IQIMCameraContainer paramIQIMCameraContainer, ICameraEntrance paramICameraEntrance)
  {
    super(paramIQIMCameraContainer, paramICameraEntrance);
    this.jdField_a_of_type_DovComQqImSettingCaptureEntranceParams = new CaptureEntranceParams(10012, 105, 11);
    this.d = 9;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    Activity localActivity = this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a();
    if ((localActivity == null) || (localActivity.isFinishing())) {}
    do
    {
      return;
      if (paramInt1 != TribeEffectsCameraCaptureFragment.jdField_a_of_type_Int) {
        break label85;
      }
      if (paramInt2 != -1) {
        break;
      }
    } while (paramIntent == null);
    Intent localIntent = new Intent();
    localIntent.putExtra("result", paramIntent.getStringExtra("result"));
    localActivity.setResult(-1, localIntent);
    localActivity.finish();
    return;
    label85:
    if ((paramInt1 == 10012) && (paramInt2 == -1))
    {
      PublishParam localPublishParam = (PublishParam)paramIntent.getParcelableExtra(PublishParam.a);
      localIntent = new Intent();
      localIntent.putExtra("thumbPath", localPublishParam.c);
      localIntent.putExtra("videoPath", localPublishParam.j);
      localIntent.putExtra("fakeVid", localPublishParam.b);
      localIntent.putExtra("videoDoodleDescription", localPublishParam.f);
      paramInt1 = paramIntent.getIntExtra("theme_id", -1);
      paramIntent = paramIntent.getStringExtra("theme_name");
      localIntent.putExtra("theme_id", paramInt1);
      localIntent.putExtra("theme_name", paramIntent);
      paramIntent = (QimMusicPlayer)QIMManager.a().c(8);
      if (paramIntent != null) {
        paramIntent.c();
      }
      paramIntent = localActivity.getIntent().getExtras().getString("options");
      localIntent.setClass(localActivity, TroopBarPublishActivity.class);
      localIntent.putExtra("options", paramIntent);
      localActivity.startActivityForResult(localIntent, TribeEffectsCameraCaptureFragment.jdField_a_of_type_Int);
      return;
    }
    SLog.d("QIMTribeEffectsCameraCaptureUnit", "onActivityResult, requestCode=%d, resultCode=%d, data=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.QIMTribeEffectsCameraCaptureUnit
 * JD-Core Version:    0.7.0.1
 */
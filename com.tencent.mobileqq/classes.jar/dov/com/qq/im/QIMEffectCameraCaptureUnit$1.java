package dov.com.qq.im;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoActivity;
import java.util.List;

class QIMEffectCameraCaptureUnit$1
  implements Runnable
{
  QIMEffectCameraCaptureUnit$1(QIMEffectCameraCaptureUnit paramQIMEffectCameraCaptureUnit, Activity paramActivity, int paramInt, Intent paramIntent) {}
  
  public void run()
  {
    Object localObject = ((ActivityManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("activity")).getRunningTasks(1);
    if ((localObject == null) || (((List)localObject).isEmpty())) {
      if (QLog.isColorLevel()) {
        QLog.d("QIMEffectCameraCaptureUnit", 1, new Object[] { "activity canceled, runningTaskInfos: ", localObject });
      }
    }
    do
    {
      do
      {
        return;
        localObject = ((ActivityManager.RunningTaskInfo)((List)localObject).get(0)).topActivity.getClassName();
        if (QLog.isColorLevel()) {
          QLog.d("QIMEffectCameraCaptureUnit", 2, new Object[] { "activity canceled, need to close, topActivity:", localObject });
        }
      } while ((!((String)localObject).equals(QIMCameraCaptureActivity.class.getName())) && (!((String)localObject).equals(EditVideoActivity.class.getName())));
      this.jdField_a_of_type_AndroidAppActivity.setResult(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidContentIntent);
      this.jdField_a_of_type_AndroidAppActivity.finish();
    } while (!QLog.isColorLevel());
    QLog.d("QIMEffectCameraCaptureUnit", 1, "activity canceled, close ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.QIMEffectCameraCaptureUnit.1
 * JD-Core Version:    0.7.0.1
 */
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.biz.qqstory.takevideo.DanceMachineUploadVideoFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForDanceMachine;
import com.tencent.qphone.base.util.QLog;

public class oaw
  extends MessageObserver
{
  public oaw(DanceMachineUploadVideoFragment paramDanceMachineUploadVideoFragment) {}
  
  public void a(MessageForDanceMachine paramMessageForDanceMachine)
  {
    super.a(paramMessageForDanceMachine);
    if (!DanceMachineUploadVideoFragment.a(this.a)) {
      if (QLog.isColorLevel()) {
        QLog.d("UploadDanceMachineVideo", 2, "do not need callback");
      }
    }
    do
    {
      return;
      DanceMachineUploadVideoFragment.a(this.a, false);
      if (paramMessageForDanceMachine != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("UploadDanceMachineVideo", 2, "mfd is null");
    return;
    if (QLog.isColorLevel()) {
      QLog.d("UploadDanceMachineVideo", 2, "uuid : " + paramMessageForDanceMachine.uuid + "  md5 : " + paramMessageForDanceMachine.md5 + " thumbFilePath : " + paramMessageForDanceMachine.mThumbFilePath);
    }
    if (paramMessageForDanceMachine.errorCode == 0)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("upload_result", true);
      localIntent.putExtra("upload_video_uuid", paramMessageForDanceMachine.uuid);
      localIntent.putExtra("upload_video_md5", paramMessageForDanceMachine.md5);
      localIntent.putExtra("upload_video_thumb", paramMessageForDanceMachine.mThumbFilePath);
      localIntent.putExtra("share_method", DanceMachineUploadVideoFragment.a(this.a));
      localIntent.putExtra("current_nickname", this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname());
      localIntent.putExtra("current_uin", this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
      if (DanceMachineUploadVideoFragment.a(this.a) != -1L) {
        localIntent.putExtra("upload_time_cost", SystemClock.elapsedRealtime() - DanceMachineUploadVideoFragment.a(this.a));
      }
      paramMessageForDanceMachine = this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
      BaseActivity localBaseActivity = this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
      paramMessageForDanceMachine.setResult(-1, localIntent);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
      return;
      this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setResult(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oaw
 * JD-Core Version:    0.7.0.1
 */
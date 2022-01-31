import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.GAudioMembersCtrlActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class med
  extends BroadcastReceiver
{
  public med(GAudioMembersCtrlActivity paramGAudioMembersCtrlActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ((TextUtils.isEmpty(paramIntent.getPackage())) || (!paramIntent.getPackage().equals(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName()))) {
      if (QLog.isColorLevel()) {
        QLog.d("GAudioMembersCtrlActivity", 2, "receive broadcast from wrong package:" + paramIntent.getPackage() + ",action:" + paramContext);
      }
    }
    int i;
    long l;
    do
    {
      do
      {
        return;
      } while (!paramContext.equals("tencent.av.v2q.StopVideoChat"));
      i = paramIntent.getIntExtra("stopReason3rd", -1);
      l = paramIntent.getLongExtra("groupId", -1L);
    } while ((i != 1) || (this.a.jdField_a_of_type_Long != l));
    if (QLog.isColorLevel()) {
      QLog.d("GAudioMembersCtrlActivity", 2, "ACTION_STOP_VIDEO_CHAT");
    }
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     med
 * JD-Core Version:    0.7.0.1
 */
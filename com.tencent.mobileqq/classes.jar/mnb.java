import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.qphone.base.util.QLog;

public class mnb
  extends BroadcastReceiver
{
  public mnb(VideoInviteActivity paramVideoInviteActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "onReceive action = " + str);
    }
    if ("tencent.video.q2v.ACTION_ON_UPDATE_FRIEND_INFO".equals(str)) {
      this.a.h();
    }
    do
    {
      return;
      if ("tencent.video.q2v.sdk.onRequestVideo".equals(str))
      {
        QLog.d(this.a.jdField_a_of_type_JavaLangString, 1, "onReceive action = " + str);
        this.a.e();
        return;
      }
      if ("android.intent.action.USER_PRESENT".equals(str))
      {
        this.a.a("ACTION_USER_PRESENT");
        return;
      }
    } while (this.a.jdField_a_of_type_Mnh == null);
    this.a.jdField_a_of_type_Mnh.a(paramContext, str, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mnb
 * JD-Core Version:    0.7.0.1
 */
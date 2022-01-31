import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.qphone.base.util.QLog;

public class kbi
  extends BroadcastReceiver
{
  public kbi(VideoInviteActivity paramVideoInviteActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteActivity", 2, "onReceive action = " + paramContext);
    }
    if (paramContext.equals("tencent.video.q2v.ACTION_ON_UPDATE_FRIEND_INFO")) {
      this.a.h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kbi
 * JD-Core Version:    0.7.0.1
 */
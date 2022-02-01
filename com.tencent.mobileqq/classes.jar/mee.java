import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.FaceToolbar;
import com.tencent.av.ui.FaceToolbar.1.1;

public class mee
  extends BroadcastReceiver
{
  public mee(FaceToolbar paramFaceToolbar) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (this.a.mApp == null) {
      return;
    }
    if (paramIntent.getAction().equalsIgnoreCase("tencent.video.q2v.ptusoDownloadRet")) {}
    for (int i = 0;; i = 1)
    {
      this.a.mApp.a().postDelayed(new FaceToolbar.1.1(this, i), 2000L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mee
 * JD-Core Version:    0.7.0.1
 */
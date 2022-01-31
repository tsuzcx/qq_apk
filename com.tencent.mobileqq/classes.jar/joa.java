import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.smallscreen.SmallScreenDialogActivity;
import com.tencent.av.smallscreen.SmallScreenUtils;

public class joa
  extends BroadcastReceiver
{
  public joa(SmallScreenDialogActivity paramSmallScreenDialogActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent.getAction().equals("tencent.video.v2q.SmallScreenState")) && (SmallScreenUtils.c(paramContext))) {
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     joa
 * JD-Core Version:    0.7.0.1
 */
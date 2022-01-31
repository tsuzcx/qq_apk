import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.video.GdtVideoCommonView;

public class qne
  extends BroadcastReceiver
{
  private qne(GdtVideoCommonView paramGdtVideoCommonView) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i;
    if (("android.intent.action.HEADSET_PLUG".equals(paramIntent.getAction())) && (paramIntent.hasExtra("state")))
    {
      i = paramIntent.getIntExtra("state", 0);
      if (i != 1) {
        break label42;
      }
      GdtLog.a("GdtVideoCommonView", "ACTION_HEADSET_PLUG HEADSET on");
    }
    label42:
    do
    {
      do
      {
        return;
      } while (i != 0);
      GdtLog.a("GdtVideoCommonView", "ACTION_HEADSET_PLUG HEADSET off " + GdtVideoCommonView.e(this.a));
    } while (!GdtVideoCommonView.e(this.a));
    GdtVideoCommonView.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     qne
 * JD-Core Version:    0.7.0.1
 */
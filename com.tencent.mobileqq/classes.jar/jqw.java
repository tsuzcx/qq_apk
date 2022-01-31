import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.ui.AVLoadingDialogActivity;

public class jqw
  extends BroadcastReceiver
{
  public jqw(AVLoadingDialogActivity paramAVLoadingDialogActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH")) {
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jqw
 * JD-Core Version:    0.7.0.1
 */
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.ui.AVLoadingDialogActivity;

public class jqh
  extends BroadcastReceiver
{
  public jqh(AVLoadingDialogActivity paramAVLoadingDialogActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH")) {
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jqh
 * JD-Core Version:    0.7.0.1
 */
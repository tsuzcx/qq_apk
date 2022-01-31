import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.kandianreport.TaskException;

public class orx
  extends BroadcastReceiver
{
  public orx(KandianMergeManager paramKandianMergeManager) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    TaskException.reportCrash(paramIntent.getBooleanExtra("isNativeCrashed", false), paramIntent.getStringExtra("crashType"), paramIntent.getStringExtra("crashAddress"), paramIntent.getStringExtra("crashStack"), paramIntent.getIntExtra("native_SICODE", 0), paramIntent.getLongExtra("crashTime", 0L));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     orx
 * JD-Core Version:    0.7.0.1
 */
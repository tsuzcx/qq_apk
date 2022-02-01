import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.kandianreport.TaskException;

public class plw
  extends BroadcastReceiver
{
  public plw(KandianMergeManager paramKandianMergeManager) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    TaskException.reportCrash(paramIntent.getBooleanExtra("isNativeCrashed", false), paramIntent.getStringExtra("crashType"), paramIntent.getStringExtra("crashAddress"), paramIntent.getStringExtra("crashStack"), paramIntent.getIntExtra("native_SICODE", 0), paramIntent.getLongExtra("crashTime", 0L));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     plw
 * JD-Core Version:    0.7.0.1
 */
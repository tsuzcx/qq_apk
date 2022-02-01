package cooperation.plugin;

import android.content.Intent;
import android.os.AsyncTask;
import com.tencent.mobileqq.pluginsdk.IStatisticsUploader;
import mqq.app.MobileQQ;

class PluginCrashReceiver$UploadLaunchInfo
  extends AsyncTask<String, String, String>
{
  public Intent a;
  private IStatisticsUploader b;
  
  protected String a(String... paramVarArgs)
  {
    try
    {
      this.b.uploadStartupSpeedInfo(MobileQQ.getContext(), this.a);
      label16:
      return null;
    }
    catch (Throwable paramVarArgs)
    {
      break label16;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.plugin.PluginCrashReceiver.UploadLaunchInfo
 * JD-Core Version:    0.7.0.1
 */
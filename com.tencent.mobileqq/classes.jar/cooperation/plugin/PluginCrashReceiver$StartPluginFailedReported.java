package cooperation.plugin;

import android.content.Intent;
import android.os.AsyncTask;
import com.tencent.mobileqq.pluginsdk.IStatisticsUploader;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import java.io.File;
import mqq.app.MobileQQ;

class PluginCrashReceiver$StartPluginFailedReported
  extends AsyncTask<String, String, String>
{
  private String a;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  private IStatisticsUploader g;
  
  public PluginCrashReceiver$StartPluginFailedReported(Intent paramIntent)
  {
    this.a = paramIntent.getStringExtra("pluginsdk_selfuin");
    this.b = paramIntent.getStringExtra("pluginsdk_pluginName");
    this.c = paramIntent.getStringExtra("pluginsdk_pluginLocation");
    this.d = paramIntent.getStringExtra("pluginsdk_pluginpath");
    this.e = paramIntent.getStringExtra("pluginsdk_launchActivity");
    this.f = paramIntent.getStringExtra("pluginsdk_extraInfo");
    paramIntent = paramIntent.getStringExtra("clsUploader");
    if (paramIntent != null) {}
    try
    {
      this.g = ((IStatisticsUploader)Class.forName(paramIntent).newInstance());
      return;
    }
    catch (Exception paramIntent)
    {
      label90:
      break label90;
    }
    this.g = null;
  }
  
  protected String a(String... paramVarArgs)
  {
    if (this.g != null)
    {
      paramVarArgs = this.f;
      if (paramVarArgs == null) {}
    }
    try
    {
      if ((!paramVarArgs.contains("Resources$NotFoundException")) && (!this.f.contains("ResourcesNotFoundException")) && (!this.f.contains("ClassNotFoundException")) && (!this.f.contains("GetPackageInfoFailException"))) {
        break label163;
      }
      paramVarArgs = PluginStatic.encodeFile(this.d);
      if (this.d == null) {
        break label204;
      }
      l = new File(this.d).length();
    }
    catch (Throwable paramVarArgs)
    {
      for (;;)
      {
        StringBuilder localStringBuilder;
        continue;
        long l = 0L;
      }
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("ApkMd5:");
    localStringBuilder.append(paramVarArgs);
    localStringBuilder.append("__FileSize:");
    localStringBuilder.append(l);
    localStringBuilder.append("__");
    localStringBuilder.append(this.f);
    this.f = localStringBuilder.toString();
    label163:
    this.g.uploadStartupFailure(MobileQQ.getContext(), this.a, this.b, this.c, this.e, this.f);
    return null;
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.plugin.PluginCrashReceiver.StartPluginFailedReported
 * JD-Core Version:    0.7.0.1
 */
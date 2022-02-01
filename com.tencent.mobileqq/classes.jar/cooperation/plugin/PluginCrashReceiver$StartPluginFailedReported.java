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
  private IStatisticsUploader jdField_a_of_type_ComTencentMobileqqPluginsdkIStatisticsUploader;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  
  public PluginCrashReceiver$StartPluginFailedReported(Intent paramIntent)
  {
    this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("pluginsdk_selfuin");
    this.b = paramIntent.getStringExtra("pluginsdk_pluginName");
    this.c = paramIntent.getStringExtra("pluginsdk_pluginLocation");
    this.d = paramIntent.getStringExtra("pluginsdk_pluginpath");
    this.e = paramIntent.getStringExtra("pluginsdk_launchActivity");
    this.f = paramIntent.getStringExtra("pluginsdk_extraInfo");
    paramIntent = paramIntent.getStringExtra("clsUploader");
    if (paramIntent != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqPluginsdkIStatisticsUploader = ((IStatisticsUploader)Class.forName(paramIntent).newInstance());
      return;
    }
    catch (Exception paramIntent)
    {
      label90:
      break label90;
    }
    this.jdField_a_of_type_ComTencentMobileqqPluginsdkIStatisticsUploader = null;
  }
  
  protected String a(String... paramVarArgs)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPluginsdkIStatisticsUploader != null)
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
    this.jdField_a_of_type_ComTencentMobileqqPluginsdkIStatisticsUploader.uploadStartupFailure(MobileQQ.getContext(), this.jdField_a_of_type_JavaLangString, this.b, this.c, this.e, this.f);
    return null;
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.plugin.PluginCrashReceiver.StartPluginFailedReported
 * JD-Core Version:    0.7.0.1
 */
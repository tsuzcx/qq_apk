package com.tencent.rmonitor.base.reporter.pluginreport;

import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.meta.UserMeta;
import com.tencent.rmonitor.base.plugin.monitor.PluginController;
import com.tencent.rmonitor.base.reporter.ReporterMachine;
import com.tencent.rmonitor.base.reporter.data.ReportData;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.util.AppInfo;
import com.tencent.rmonitor.common.util.FileUtil;
import java.io.File;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

public class CommonReporter
  implements IPluginReport
{
  private final int a;
  @Nullable
  private Object b;
  
  public CommonReporter(int paramInt)
  {
    this.a = paramInt;
  }
  
  @NotNull
  public String a(String paramString)
  {
    File localFile = new File(paramString);
    String str = paramString;
    if (localFile.exists())
    {
      str = paramString;
      if (localFile.isDirectory())
      {
        str = localFile.getParent();
        long l = System.currentTimeMillis();
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("out_");
        ((StringBuilder)localObject).append(l);
        ((StringBuilder)localObject).append(".zip");
        localObject = ((StringBuilder)localObject).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("/");
        localStringBuilder.append((String)localObject);
        str = localStringBuilder.toString();
        FileUtil.b(paramString, str, false);
        FileUtil.a(localFile);
      }
    }
    return str;
  }
  
  public void a(@Nullable Object paramObject)
  {
    this.b = paramObject;
  }
  
  public boolean b(Object paramObject)
  {
    if (paramObject == null)
    {
      Logger.b.e(new String[] { "CommonReporter", "report, filePath is null, plugin = ", String.valueOf(this.a) });
      return false;
    }
    if (!PluginController.b.d(this.a))
    {
      Logger.b.e(new String[] { "CommonReporter", "report, not hit sampling, plugin = ", String.valueOf(this.a) });
      return false;
    }
    try
    {
      paramObject = a((String)paramObject);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("processname", AppInfo.a(BaseInfo.app));
      localJSONObject.put("fileObj", paramObject);
      localJSONObject.put("plugin", this.a);
      if (this.b != null) {
        localJSONObject.put("extra_data", this.b);
      }
      paramObject = new ReportData(0, "testcase", true, 1L, 1L, localJSONObject, false, true, BaseInfo.userMeta.uin);
      ReporterMachine.a.a(paramObject);
      return true;
    }
    catch (Exception paramObject) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.reporter.pluginreport.CommonReporter
 * JD-Core Version:    0.7.0.1
 */
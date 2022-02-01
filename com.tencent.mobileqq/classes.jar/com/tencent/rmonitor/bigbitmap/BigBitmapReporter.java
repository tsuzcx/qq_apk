package com.tencent.rmonitor.bigbitmap;

import android.app.Application;
import android.hardware.display.DisplayManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.reporter.pluginreport.CommonReporter;
import com.tencent.rmonitor.base.reporter.pluginreport.IPluginReport;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.util.AndroidVersion;
import org.json.JSONObject;

public class BigBitmapReporter
{
  private final IPluginReport a = new CommonReporter(152);
  
  public BigBitmapReporter()
  {
    this.a.a(a());
  }
  
  private JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    Object localObject;
    if (AndroidVersion.b())
    {
      localObject = (DisplayManager)BaseInfo.app.getSystemService("display");
      if (localObject != null) {
        ((DisplayManager)localObject).getDisplay(0).getRealMetrics(localDisplayMetrics);
      }
    }
    else
    {
      localObject = (WindowManager)BaseInfo.app.getSystemService("window");
      if (localObject != null) {
        ((WindowManager)localObject).getDefaultDisplay().getMetrics(localDisplayMetrics);
      }
    }
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(localDisplayMetrics.widthPixels);
      ((StringBuilder)localObject).append("*");
      ((StringBuilder)localObject).append(localDisplayMetrics.heightPixels);
      localJSONObject.put("resolution", ((StringBuilder)localObject).toString());
      localJSONObject.put("ppi", localDisplayMetrics.densityDpi);
      localJSONObject.put("threshold", BigBitmapConfigHelper.a());
      return localJSONObject;
    }
    catch (Exception localException)
    {
      Logger.b.e(new String[] { "BigBitmapReporter", "getExtraData error: ", localException.getMessage() });
    }
    return localJSONObject;
  }
  
  public void a(String paramString)
  {
    this.a.b(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.bigbitmap.BigBitmapReporter
 * JD-Core Version:    0.7.0.1
 */
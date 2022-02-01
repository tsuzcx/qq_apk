package com.tencent.tfm.metrics;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.tfm.metrics.api.DimensionProvider;
import com.tencent.tfm.metrics.utils.AppInfo;
import java.util.Arrays;
import java.util.List;

public class DefaultDimensionProvider
  implements DimensionProvider
{
  public static final String APP_VERSION = "app_version";
  public static final String CHANNEL = "channel";
  public static final String MODEL = "model";
  public static final String NETWORK_TYPE = "network_type";
  public static final String OS = "os";
  public static final String PLATFORM = "platform";
  public static final String PROCESS_NAME = "process_name";
  public static final String SDK_VERSION = "sdk_version";
  private Context context;
  
  public DefaultDimensionProvider(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public List<String> getDimensionKeys()
  {
    return Arrays.asList(new String[] { "app_version", "process_name", "os", "platform", "channel", "model", "network_type", "sdk_version" });
  }
  
  public String getDimensionValue(String paramString)
  {
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 1993196123: 
      if (paramString.equals("process_name")) {
        i = 1;
      }
      break;
    case 1874684019: 
      if (paramString.equals("platform")) {
        i = 3;
      }
      break;
    case 738950403: 
      if (paramString.equals("channel")) {
        i = 4;
      }
      break;
    case 104069929: 
      if (paramString.equals("model")) {
        i = 5;
      }
      break;
    case 3556: 
      if (paramString.equals("os")) {
        i = 2;
      }
      break;
    case -19457365: 
      if (paramString.equals("network_type")) {
        i = 6;
      }
      break;
    case -376724013: 
      if (paramString.equals("sdk_version")) {
        i = 7;
      }
      break;
    case -901870406: 
      if (paramString.equals("app_version")) {
        i = 0;
      }
      break;
    }
    int i = -1;
    switch (i)
    {
    default: 
      return "";
    case 7: 
      return "1.0.1-alpha";
    case 6: 
      return AppInfo.getNetWorkType();
    case 5: 
      return Build.MODEL;
    case 4: 
      return AppInfo.getChannel();
    case 3: 
      return "Android";
    case 2: 
      paramString = new StringBuilder();
      paramString.append(Build.VERSION.SDK_INT);
      paramString.append("");
      return paramString.toString();
    case 1: 
      return AppInfo.getCurrentProcess(this.context);
    }
    return AppInfo.getAppVersion(this.context);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tfm.metrics.DefaultDimensionProvider
 * JD-Core Version:    0.7.0.1
 */
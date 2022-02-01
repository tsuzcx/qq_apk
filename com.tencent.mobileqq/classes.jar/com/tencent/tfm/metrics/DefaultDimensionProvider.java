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
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return "";
        if (paramString.equals("app_version"))
        {
          i = 0;
          continue;
          if (paramString.equals("process_name"))
          {
            i = 1;
            continue;
            if (paramString.equals("os"))
            {
              i = 2;
              continue;
              if (paramString.equals("platform"))
              {
                i = 3;
                continue;
                if (paramString.equals("channel"))
                {
                  i = 4;
                  continue;
                  if (paramString.equals("model"))
                  {
                    i = 5;
                    continue;
                    if (paramString.equals("network_type"))
                    {
                      i = 6;
                      continue;
                      if (paramString.equals("sdk_version")) {
                        i = 7;
                      }
                    }
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    return AppInfo.getAppVersion(this.context);
    return AppInfo.getCurrentProcess(this.context);
    return Build.VERSION.SDK_INT + "";
    return "Android";
    return AppInfo.getChannel();
    return Build.MODEL;
    return AppInfo.getNetWorkType();
    return "1.0.1-alpha";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tfm.metrics.DefaultDimensionProvider
 * JD-Core Version:    0.7.0.1
 */
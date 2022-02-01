package oicq.wlogin_sdk.report.event;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import oicq.wlogin_sdk.report.c;
import oicq.wlogin_sdk.tools.util;

public class EventSaver
{
  public static final String EVENT_ITEM_SPLIT = ";";
  public static final String WLOGIN_SP_EVENT = "WLOGIN_EVENT";
  
  public static void saveEvent(b paramb)
  {
    c.b(paramb);
  }
  
  public void realClearEvent(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return;
    }
    try
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_EVENT", 4).edit();
      paramContext.putString(paramString, "");
      paramContext.commit();
      paramContext = new StringBuilder();
      paramContext.append(util.LOG_TAG_EVENT_REPORT);
      paramContext.append("realClearEvent eventType=");
      paramContext.append(paramString);
      util.LOGI(paramContext.toString(), "");
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public String realReadEvent(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return "";
    }
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(util.LOG_TAG_EVENT_REPORT);
      localStringBuilder.append("realReadEvent eventType=");
      localStringBuilder.append(paramString);
      util.LOGI(localStringBuilder.toString(), "");
      paramContext = paramContext.getSharedPreferences("WLOGIN_EVENT", 4).getString(paramString, "");
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public void realSaveItem(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext != null) {
      try
      {
        if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
        {
          SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("WLOGIN_EVENT", 4);
          String str = localSharedPreferences.getString(paramString1, "");
          paramContext = paramString2;
          if (!TextUtils.isEmpty(str))
          {
            paramContext = new StringBuilder();
            paramContext.append(str);
            paramContext.append(";");
            paramContext.append(paramString2);
            paramContext = paramContext.toString();
          }
          paramString2 = localSharedPreferences.edit();
          paramString2.putString(paramString1, paramContext);
          paramString2.commit();
          paramString2 = new StringBuilder();
          paramString2.append(util.LOG_TAG_EVENT_REPORT);
          paramString2.append("realSaveItem eventType=");
          paramString2.append(paramString1);
          paramString2.append(",eventDetail=");
          paramString2.append(paramContext);
          util.LOGI(paramString2.toString(), "");
          return;
        }
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     oicq.wlogin_sdk.report.event.EventSaver
 * JD-Core Version:    0.7.0.1
 */
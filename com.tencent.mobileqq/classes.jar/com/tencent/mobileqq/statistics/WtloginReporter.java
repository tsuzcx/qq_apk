package com.tencent.mobileqq.statistics;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.PrivacyPolicyHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import oicq.wlogin_sdk.report.event.EventSaver;

public class WtloginReporter
{
  public static void a(Context paramContext, EventSaver paramEventSaver, String paramString1, String paramString2)
  {
    if (!PrivacyPolicyHelper.a())
    {
      QLog.i("WtloginReporter", 1, "reportSaveEvent user no allow");
      return;
    }
    Object localObject = paramEventSaver.realReadEvent(paramContext, paramString1);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      QLog.i("WtloginReporter", 1, "reportSaveEvent eventValue is null");
      return;
    }
    paramEventSaver.realClearEvent(paramContext, paramString1);
    paramEventSaver = null;
    try
    {
      localObject = ((String)localObject).split(";");
      paramEventSaver = (EventSaver)localObject;
    }
    catch (Exception localException)
    {
      QLog.i("WtloginReporter", 1, "reportSaveEvent", localException);
    }
    if (paramEventSaver == null)
    {
      QLog.i("WtloginReporter", 1, "reportSaveEvent eventItems is null");
      return;
    }
    paramContext = StatisticCollector.getInstance(paramContext);
    int j = paramEventSaver.length;
    int i = 0;
    while (i < j)
    {
      CharSequence localCharSequence = paramEventSaver[i];
      if (!TextUtils.isEmpty(localCharSequence))
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("detail", localCharSequence);
        paramContext.collectPerformance(paramString2, paramString1, true, 0L, 0L, localHashMap, "");
      }
      i += 1;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    ThreadManagerV2.executeOnFileThread(new WtloginReporter.1(paramQQAppInterface.getCurrentAccountUin()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.WtloginReporter
 * JD-Core Version:    0.7.0.1
 */
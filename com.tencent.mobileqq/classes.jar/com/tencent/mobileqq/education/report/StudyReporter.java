package com.tencent.mobileqq.education.report;

import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.mobileqq.statistics.QQUserAction;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class StudyReporter
{
  static {}
  
  private static void a()
  {
    UserAction.registerTunnel(new TunnelInfo("0DOU0D24SC4TTEJY"));
    QLog.i("StudyReporter", 2, "init study report tunnel");
  }
  
  public static void a(String paramString, Map<String, String> paramMap)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("report: report event[");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("]");
    QLog.d("StudyReporter", 1, ((StringBuilder)localObject).toString());
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("StudyReporter", 1, "report: error! report event is empty.");
      return;
    }
    localObject = new HashMap();
    MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("StudyReporter", 1, "report: error! report qq is empty.");
      return;
    }
    ((HashMap)localObject).putAll(paramMap);
    a(paramString, true, -1L, -1L, (Map)localObject, true, true);
  }
  
  public static void a(String paramString, boolean paramBoolean1, long paramLong1, long paramLong2, Map<String, String> paramMap, boolean paramBoolean2, boolean paramBoolean3)
  {
    HashMap localHashMap = new HashMap();
    if (paramMap != null) {
      localHashMap.putAll(paramMap);
    }
    localHashMap.put("channelid", "android");
    paramMap = new StringBuilder();
    paramMap.append("-----[");
    paramMap.append(paramString);
    paramMap.append("]");
    QLog.d("StudyReporter", 2, paramMap.toString());
    QQUserAction.a("0DOU0D24SC4TTEJY", paramString, paramBoolean1, paramLong1, paramLong2, localHashMap, paramBoolean2, paramBoolean3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.education.report.StudyReporter
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.studyroom.utils;

import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.mobileqq.statistics.QQUserAction;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class StudyRoomNewReporter
{
  static {}
  
  public static void a()
  {
    UserAction.registerTunnel(new TunnelInfo("0AND08QT664PZRTU"));
    QLog.i("StudyRoomNewReporter", 2, "init studyroom report tunnel");
  }
  
  public static void a(String paramString, boolean paramBoolean1, long paramLong1, long paramLong2, Map<String, String> paramMap, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramMap == null) {
      paramMap = new HashMap();
    }
    paramMap.put("channelid", "android");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("-----[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    QLog.d("StudyRoomNewReporter", 2, localStringBuilder.toString());
    QQUserAction.a("0AND08QT664PZRTU", paramString, paramBoolean1, paramLong1, paramLong2, paramMap, paramBoolean2, paramBoolean3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.utils.StudyRoomNewReporter
 * JD-Core Version:    0.7.0.1
 */
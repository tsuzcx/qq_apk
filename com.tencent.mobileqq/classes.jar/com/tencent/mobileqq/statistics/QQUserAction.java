package com.tencent.mobileqq.statistics;

import com.tencent.beacon.event.UserAction;
import java.util.HashMap;
import java.util.Map;

public class QQUserAction
{
  public static boolean a(String paramString1, String paramString2, boolean paramBoolean1, long paramLong1, long paramLong2, Map<String, String> paramMap, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramMap == null) {
      paramMap = new HashMap();
    }
    paramMap.put("q_consume_time", String.valueOf(paramLong1));
    paramMap.put("q_length", String.valueOf(paramLong2));
    return UserAction.onUserActionToTunnel(paramString1, paramString2, paramBoolean1, paramLong1, paramLong2, paramMap, paramBoolean2, paramBoolean3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.QQUserAction
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.open.agent.util;

import com.tencent.mobileqq.forward.ForwardStatisticsReporter;
import com.tencent.open.model.AccountInfo;
import java.util.HashMap;

public class AuthBeaconReporter
  implements IAuthBeaconReporter
{
  public void a(String paramString)
  {
    ForwardStatisticsReporter.a(paramString);
  }
  
  public void a(String paramString, long paramLong)
  {
    ForwardStatisticsReporter.a(paramString, paramLong);
  }
  
  public void a(String paramString, AccountInfo paramAccountInfo)
  {
    ForwardStatisticsReporter.a(paramString, paramAccountInfo);
  }
  
  public void a(String paramString, AccountInfo paramAccountInfo, HashMap<String, String> paramHashMap, boolean paramBoolean)
  {
    if (paramAccountInfo == null) {
      paramAccountInfo = "";
    } else {
      paramAccountInfo = paramAccountInfo.a;
    }
    ForwardStatisticsReporter.a(paramString, paramAccountInfo, paramHashMap, paramBoolean);
  }
  
  public void a(String paramString, AccountInfo paramAccountInfo, boolean paramBoolean)
  {
    ForwardStatisticsReporter.a(paramString, paramAccountInfo, paramBoolean);
  }
  
  public void a(String paramString1, String paramString2, long paramLong, HashMap<String, String> paramHashMap, boolean paramBoolean)
  {
    ForwardStatisticsReporter.a(paramString1, paramString2, paramLong, paramHashMap, paramBoolean);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    ForwardStatisticsReporter.a(paramString1, paramString2, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.util.AuthBeaconReporter
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.flashshow.report.datong;

import com.tencent.mobileqq.flashshow.report.FSNativeSessionManager;
import com.tencent.qqlive.module.videoreport.PageParams;
import java.util.HashMap;
import java.util.Map;

public class FSDTParamBuilder
{
  public PageParams a(Map<String, Object> paramMap)
  {
    HashMap localHashMap = new HashMap();
    if ((paramMap != null) && (paramMap.size() > 0)) {
      localHashMap.putAll(paramMap);
    }
    localHashMap.put("dt_appkey", "00000QG6YX3X0LZH");
    localHashMap.put("ks_session_id", FSNativeSessionManager.a().b());
    return new PageParams(localHashMap);
  }
  
  public Map<String, Object> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("dt_appkey", "00000QG6YX3X0LZH");
    localHashMap.put("ks_session_id", FSNativeSessionManager.a().b());
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.report.datong.FSDTParamBuilder
 * JD-Core Version:    0.7.0.1
 */
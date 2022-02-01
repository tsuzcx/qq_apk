package com.tencent.mobileqq.winkreport.datong;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import java.util.HashMap;
import java.util.Map;

public class WinkDTParamBuilder
{
  private static final String TAG = "WinkDTParamBuilder";
  
  public static Map<String, Object> buildElementParams()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("dt_appkey", "00000QG6YX3X0LZH");
    localHashMap.put("xsj_session_id", WinkNativeSessionManager.g().getSessionId());
    return localHashMap;
  }
  
  public PageParams buildPageParams()
  {
    return buildPageParams(null, false);
  }
  
  public PageParams buildPageParams(Map<String, Object> paramMap)
  {
    return buildPageParams(paramMap, false);
  }
  
  public PageParams buildPageParams(Map<String, Object> paramMap, String paramString)
  {
    HashMap localHashMap = new HashMap();
    if ((paramMap != null) && (paramMap.size() > 0)) {
      localHashMap.putAll(paramMap);
    }
    paramMap = new StringBuilder();
    paramMap.append("[buildPageParams] cameraSessionId: ");
    paramMap.append(paramString);
    QLog.i("WinkDTParamBuilder", 1, paramMap.toString());
    localHashMap.put("dt_appkey", "00000QG6YX3X0LZH");
    localHashMap.put("xsj_session_id", WinkNativeSessionManager.g().getSessionId());
    localHashMap.put("xsj_camera_session_id", paramString);
    localHashMap.put("xsj_paitongkuan_type", WinkDatongCurrentParams.get("xsj_paitongkuan_type"));
    localHashMap.put("xsj_paitongkuan_id", WinkDatongCurrentParams.get("xsj_paitongkuan_id"));
    WinkDatongCurrentParams.put("xsj_session_id", WinkNativeSessionManager.g().getSessionId());
    WinkDatongCurrentParams.put("xsj_camera_session_id", paramString);
    return new PageParams(localHashMap);
  }
  
  public PageParams buildPageParams(Map<String, Object> paramMap, boolean paramBoolean)
  {
    return buildPageParams(paramMap, WinkNativeSessionManager.g().getCameraSessionId(paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder
 * JD-Core Version:    0.7.0.1
 */
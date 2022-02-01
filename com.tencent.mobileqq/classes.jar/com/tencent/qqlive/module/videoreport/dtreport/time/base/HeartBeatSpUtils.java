package com.tencent.qqlive.module.videoreport.dtreport.time.base;

import android.text.TextUtils;
import com.tencent.qqlive.module.videoreport.utils.JsonUtils;
import com.tencent.qqlive.module.videoreport.utils.ReportUtils;
import com.tencent.qqlive.module.videoreport.utils.SPUtils;
import java.util.Map;

public class HeartBeatSpUtils
{
  public static void clearLastHeartBeat(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    SPUtils.put(ReportUtils.getContext(), paramString, "");
  }
  
  public static Map<String, Object> getLastHeartBeat(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = (String)SPUtils.get(ReportUtils.getContext(), paramString, "");
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return JsonUtils.getMapForJson(paramString);
  }
  
  public static void saveLastHeartBeat(String paramString, Map<String, Object> paramMap)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramMap = JsonUtils.getJsonFromMap(paramMap);
    SPUtils.put(ReportUtils.getContext(), paramString, paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.time.base.HeartBeatSpUtils
 * JD-Core Version:    0.7.0.1
 */
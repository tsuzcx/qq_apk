package com.tencent.qqlive.module.videoreport.dtreport.stdevent;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

abstract class BaseEventParamsBuilder<T>
  implements IEventParamsBuilder
{
  Map<String, String> mEventParams = new HashMap();
  
  boolean checkSingleParam(StringBuilder paramStringBuilder, String paramString, Object paramObject)
  {
    if (paramObject == null) {}
    for (paramObject = null; TextUtils.isEmpty(paramObject); paramObject = paramObject.toString())
    {
      paramStringBuilder.append("[").append(paramString).append("] 是必填项，请修改\n");
      return false;
    }
    return true;
  }
  
  abstract BaseEventParamsBuilder.CheckResult checkValidity();
  
  void putSingleParam(Map<String, String> paramMap, String paramString, Object paramObject)
  {
    if (paramObject == null) {}
    for (paramObject = null;; paramObject = paramObject.toString())
    {
      paramMap.put(paramString, paramObject);
      return;
    }
  }
  
  T self()
  {
    return this;
  }
  
  public T setCustomParams(Map<String, String> paramMap)
  {
    if (paramMap != null) {
      this.mEventParams.putAll(paramMap);
    }
    return self();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.stdevent.BaseEventParamsBuilder
 * JD-Core Version:    0.7.0.1
 */
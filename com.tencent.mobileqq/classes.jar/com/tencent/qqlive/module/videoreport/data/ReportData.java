package com.tencent.qqlive.module.videoreport.data;

import android.support.annotation.Nullable;
import java.util.Collections;
import java.util.Map;

public class ReportData
{
  private String mId;
  private Map<String, ?> mParams;
  
  public String getId()
  {
    return this.mId;
  }
  
  @Nullable
  public Map<String, Object> getParams()
  {
    Map localMap = this.mParams;
    if (localMap == null) {
      return null;
    }
    return Collections.unmodifiableMap(localMap);
  }
  
  public void setId(String paramString)
  {
    this.mId = paramString;
  }
  
  public void setParams(Map<String, ?> paramMap)
  {
    this.mParams = paramMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.data.ReportData
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.weseevideo.model;

import com.tencent.weseevideo.common.utils.GsonUtils;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseMediaModel
  implements Serializable, Cloneable
{
  private final HashMap<String, String> extraParams = new HashMap(0);
  
  public void clearExtraParams()
  {
    this.extraParams.clear();
  }
  
  protected Object clone()
  {
    return super.clone();
  }
  
  public Map<String, String> getExtraParams()
  {
    return this.extraParams;
  }
  
  public String getParam(String paramString)
  {
    return (String)this.extraParams.get(paramString);
  }
  
  public void putParam(String paramString1, String paramString2)
  {
    this.extraParams.put(paramString1, paramString2);
  }
  
  public void setExtraParams(Map<String, String> paramMap)
  {
    this.extraParams.clear();
    if (paramMap != null) {
      this.extraParams.putAll(paramMap);
    }
  }
  
  public String toString()
  {
    return GsonUtils.obj2Json(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weseevideo.model.BaseMediaModel
 * JD-Core Version:    0.7.0.1
 */
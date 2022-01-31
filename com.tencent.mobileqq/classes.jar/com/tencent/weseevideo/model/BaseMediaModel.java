package com.tencent.weseevideo.model;

import com.tencent.weseevideo.common.utils.GsonUtils;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseMediaModel
  implements Cloneable
{
  protected Map<String, Serializable> extraParams = new HashMap(0);
  
  public Map<String, Serializable> getExtraParams()
  {
    return this.extraParams;
  }
  
  public Serializable getParam(String paramString)
  {
    return (Serializable)this.extraParams.get(paramString);
  }
  
  public void putParam(String paramString, Serializable paramSerializable)
  {
    if (this.extraParams == null) {
      this.extraParams = new HashMap();
    }
    this.extraParams.put(paramString, paramSerializable);
  }
  
  public void setExtraParams(Map<String, Serializable> paramMap)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.weseevideo.model.BaseMediaModel
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.flashshow.bean;

import java.io.Serializable;
import java.util.HashMap;

public class FSSchemeBean
  implements Serializable
{
  private static final long serialVersionUID = 322069543369932762L;
  private String mAction;
  private HashMap<String, String> mAttrs;
  private HashMap<String, byte[]> mByteAttrs;
  private long mEnterTime;
  
  public HashMap<String, String> getAttrs()
  {
    return this.mAttrs;
  }
  
  public HashMap<String, byte[]> getByteAttrs()
  {
    return this.mByteAttrs;
  }
  
  public long getEnterTime()
  {
    return this.mEnterTime;
  }
  
  public String getSchemeAction()
  {
    return this.mAction;
  }
  
  public FSSchemeBean setAttrs(HashMap<String, String> paramHashMap)
  {
    this.mAttrs = paramHashMap;
    return this;
  }
  
  public FSSchemeBean setByteAttrs(HashMap<String, byte[]> paramHashMap)
  {
    this.mByteAttrs = paramHashMap;
    return this;
  }
  
  public void setEnterTime(long paramLong)
  {
    this.mEnterTime = paramLong;
  }
  
  public FSSchemeBean setSchemeAction(String paramString)
  {
    this.mAction = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.bean.FSSchemeBean
 * JD-Core Version:    0.7.0.1
 */
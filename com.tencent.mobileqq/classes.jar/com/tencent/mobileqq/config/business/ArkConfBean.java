package com.tencent.mobileqq.config.business;

import com.tencent.qphone.base.util.QLog;

public class ArkConfBean
{
  protected String a = "";
  
  public ArkConfBean() {}
  
  public ArkConfBean(String paramString)
  {
    if (paramString != null) {
      this.a = paramString;
    }
  }
  
  public ArkConfBean.ArkAIDictConfBean a()
  {
    if ((this instanceof ArkConfBean.ArkAIDictConfBean)) {
      return (ArkConfBean.ArkAIDictConfBean)this;
    }
    QLog.e("ArkConfBean", 1, "this object is not a ArkAIDictConfBean object");
    return null;
  }
  
  public ArkConfBean.ArkAIKeyWordConfBean a()
  {
    if ((this instanceof ArkConfBean.ArkAIKeyWordConfBean)) {
      return (ArkConfBean.ArkAIKeyWordConfBean)this;
    }
    QLog.e("ArkConfBean", 1, "this object is not a ArkAIKeyWordConfBean object");
    return null;
  }
  
  public ArkConfBean.ArkMsgAIDisableConfBean a()
  {
    if ((this instanceof ArkConfBean.ArkMsgAIDisableConfBean)) {
      return (ArkConfBean.ArkMsgAIDisableConfBean)this;
    }
    QLog.e("ArkConfBean", 1, "this object is not a ArkMsgAIDisableConfBean object");
    return null;
  }
  
  public ArkConfBean.ArkPlatformConfigBean a()
  {
    if ((this instanceof ArkConfBean.ArkPlatformConfigBean)) {
      return (ArkConfBean.ArkPlatformConfigBean)this;
    }
    QLog.e("ArkConfBean", 1, "this object is not a ArkPlatformConfigBean object");
    return null;
  }
  
  public String a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.ArkConfBean
 * JD-Core Version:    0.7.0.1
 */
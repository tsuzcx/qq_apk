package com.tencent.mobileqq.config.business.sigtopic;

import java.util.ArrayList;

public class SigTopicConfBean
{
  private SigTopicConfBean.SigTopicConfig a;
  private String b;
  
  public SigTopicConfBean()
  {
    this.b = "";
    this.a = new SigTopicConfBean.SigTopicConfig();
  }
  
  public SigTopicConfBean(String paramString, SigTopicConfBean.SigTopicConfig paramSigTopicConfig)
  {
    this.b = paramString;
    this.a = paramSigTopicConfig;
  }
  
  public SigTopicConfBean.SigTopicConfig a()
  {
    return this.a;
  }
  
  public boolean b()
  {
    SigTopicConfBean.SigTopicConfig localSigTopicConfig = this.a;
    return (localSigTopicConfig == null) || (localSigTopicConfig.b == null) || (this.a.b.size() <= 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.sigtopic.SigTopicConfBean
 * JD-Core Version:    0.7.0.1
 */
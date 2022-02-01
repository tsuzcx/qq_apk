package com.tencent.mobileqq.teamwork.api.impl;

import com.tencent.mobileqq.teamwork.api.IDocDrawerConfig;
import com.tencent.mobileqq.teamwork.config.TencentDocDrawerConfigBean;
import com.tencent.mobileqq.teamwork.config.TencentDocDrawerConfigProcessor;

public class DocDrawerConfigImpl
  implements IDocDrawerConfig
{
  public String getAndroidDrawerIconURL()
  {
    return TencentDocDrawerConfigProcessor.a().b();
  }
  
  public String getAndroidDrawerJumpURL()
  {
    return TencentDocDrawerConfigProcessor.a().a();
  }
  
  public String getAndroidDrawerText()
  {
    return TencentDocDrawerConfigProcessor.a().c();
  }
  
  public Boolean getIsShowInDrawer()
  {
    return TencentDocDrawerConfigProcessor.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.impl.DocDrawerConfigImpl
 * JD-Core Version:    0.7.0.1
 */
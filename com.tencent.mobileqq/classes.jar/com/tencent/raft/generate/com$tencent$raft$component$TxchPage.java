package com.tencent.raft.generate;

import com.tencent.raft.component.TxchPage;
import com.tencent.raft.raftframework.service.api.IServiceEntry;
import com.tencent.raft.raftframework.service.api.ServiceWrapper;

public class com$tencent$raft$component$TxchPage
  implements IServiceEntry
{
  public ServiceWrapper createService()
  {
    return new ServiceWrapper(new TxchPage(getProductID(), getOpenID(), getNickname(), getAvatarURL()), "Prototype");
  }
  
  public String getAvatarURL()
  {
    return "https://txc.qq.com/static/desktop/img/products/def-product-logo.png";
  }
  
  public String getKey()
  {
    return "com.tencent.raft.component.TxchPage";
  }
  
  public String getNickname()
  {
    return "tucao_test";
  }
  
  public String getOpenID()
  {
    return "tucao_123";
  }
  
  public int getPriority()
  {
    return 1;
  }
  
  public String getProductID()
  {
    return "36028";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.raft.generate.com.tencent.raft.component.TxchPage
 * JD-Core Version:    0.7.0.1
 */
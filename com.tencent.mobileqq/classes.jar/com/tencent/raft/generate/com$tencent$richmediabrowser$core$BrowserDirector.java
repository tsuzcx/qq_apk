package com.tencent.raft.generate;

import com.tencent.raft.raftframework.service.api.IServiceEntry;
import com.tencent.raft.raftframework.service.api.ServiceWrapper;
import com.tencent.richmediabrowser.core.BrowserDirector;

public class com$tencent$richmediabrowser$core$BrowserDirector
  implements IServiceEntry
{
  public ServiceWrapper createService()
  {
    return new ServiceWrapper(new BrowserDirector(), "Prototype");
  }
  
  public String getKey()
  {
    return "com.tencent.richmediabrowser.core.BrowserDirector";
  }
  
  public int getPriority()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.raft.generate.com.tencent.richmediabrowser.core.BrowserDirector
 * JD-Core Version:    0.7.0.1
 */
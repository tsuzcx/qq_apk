package com.tencent.raft.generate;

import com.tencent.raft.raftframework.service.api.IServiceEntry;
import com.tencent.raft.raftframework.service.api.ServiceWrapper;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;

public class com$tencent$richmediabrowser$model$RichMediaBrowserInfo
  implements IServiceEntry
{
  public ServiceWrapper createService()
  {
    return new ServiceWrapper(new RichMediaBrowserInfo(), "Prototype");
  }
  
  public String getKey()
  {
    return "com.tencent.richmediabrowser.model.RichMediaBrowserInfo";
  }
  
  public int getPriority()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.raft.generate.com.tencent.richmediabrowser.model.RichMediaBrowserInfo
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.raft.generate;

import android.app.Activity;
import com.tencent.raft.raftframework.service.api.IServiceEntry;
import com.tencent.raft.raftframework.service.api.ServiceWrapper;
import com.tencent.richmediabrowser.core.MainBrowserBuilder;

public class com$tencent$richmediabrowser$core$MainBrowserBuilder
  implements IServiceEntry
{
  public ServiceWrapper createService()
  {
    return new ServiceWrapper(new MainBrowserBuilder(getActivity()), "Prototype");
  }
  
  public Activity getActivity()
  {
    return (Activity)null;
  }
  
  public String getKey()
  {
    return "com.tencent.richmediabrowser.core.MainBrowserBuilder";
  }
  
  public int getPriority()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.raft.generate.com.tencent.richmediabrowser.core.MainBrowserBuilder
 * JD-Core Version:    0.7.0.1
 */
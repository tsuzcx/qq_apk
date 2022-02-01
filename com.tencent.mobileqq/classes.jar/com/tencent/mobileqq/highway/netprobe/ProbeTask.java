package com.tencent.mobileqq.highway.netprobe;

import java.lang.ref.WeakReference;
import java.util.HashMap;

public class ProbeTask
{
  public ProbeCallback cb;
  WeakReference<WeakNetLearner> learner;
  public ProbeRequest req;
  public ProbeResponse resp;
  
  public ProbeTask(ProbeRequest paramProbeRequest)
  {
    this(paramProbeRequest, null);
  }
  
  public ProbeTask(ProbeRequest paramProbeRequest, ProbeCallback paramProbeCallback)
  {
    this.req = paramProbeRequest;
    this.cb = paramProbeCallback;
    this.resp = new ProbeResponse(paramProbeRequest.trigglePoint, paramProbeCallback);
  }
  
  public void collectResult()
  {
    this.resp.success = true;
    for (ProbeItem localProbeItem = this.req.root; localProbeItem != null; localProbeItem = localProbeItem.getSuccessor())
    {
      this.resp.mProbeItemResults.put(localProbeItem, localProbeItem.mResult);
      if (!localProbeItem.mResult.success)
      {
        ProbeResponse localProbeResponse = this.resp;
        localProbeResponse.success = false;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localProbeItem.getProbeName());
        localStringBuilder.append(":");
        localStringBuilder.append(localProbeItem.mResult.errDesc);
        localProbeResponse.errDesc = localStringBuilder.toString();
        return;
      }
    }
  }
  
  public String getKey()
  {
    return this.req.toString();
  }
  
  public void onTaskFinish()
  {
    ProbeCallback localProbeCallback = this.cb;
    if (localProbeCallback != null)
    {
      ProbeResponse localProbeResponse = this.resp;
      if (localProbeResponse != null) {
        localProbeCallback.onProbeFinish(localProbeResponse);
      }
    }
    if (this.learner.get() != null) {
      ((WeakNetLearner)this.learner.get()).onTaskFinish(this);
    }
  }
  
  public void startProbe()
  {
    try
    {
      if (this.req.root != null)
      {
        this.req.root.probe(this.req, this.cb);
        collectResult();
      }
      else
      {
        throw new Exception("at lease one probe item need！");
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      ProbeResponse localProbeResponse = this.resp;
      localProbeResponse.success = false;
      localProbeResponse.errDesc = localThrowable.toString();
      onTaskFinish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.highway.netprobe.ProbeTask
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.highway.netprobe;

public abstract class ProbeItem
  implements Comparable<ProbeItem>
{
  public ProbeCallback cb;
  protected ProbeRequest mRequest;
  public ProbeItem.ProbeResult mResult;
  int priority = 5;
  protected ProbeItem successor = null;
  
  public ProbeItem() {}
  
  public ProbeItem(int paramInt)
  {
    this.priority = paramInt;
  }
  
  public int compareTo(ProbeItem paramProbeItem)
  {
    return this.priority - paramProbeItem.priority;
  }
  
  public abstract void doProbe();
  
  public abstract String getProbeName();
  
  public ProbeItem.ProbeResult getProbeResult(ProbeRequest paramProbeRequest, ProbeCallback paramProbeCallback)
  {
    return new ProbeItem.ProbeResult(getProbeName(), paramProbeCallback);
  }
  
  public ProbeItem getSuccessor()
  {
    return this.successor;
  }
  
  public void probe(ProbeRequest paramProbeRequest, ProbeCallback paramProbeCallback)
  {
    this.mRequest = paramProbeRequest;
    this.cb = paramProbeCallback;
    this.mResult = getProbeResult(paramProbeRequest, paramProbeCallback);
    doProbe();
    transferReqToNext(this.mResult.success);
  }
  
  public void setSuccessor(ProbeItem paramProbeItem)
  {
    this.successor = paramProbeItem;
  }
  
  public void transferReqToNext(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.successor != null)) {
      this.successor.probe(this.mRequest, this.cb);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.netprobe.ProbeItem
 * JD-Core Version:    0.7.0.1
 */
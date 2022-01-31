package com.tencent.mobileqq.highway.netprobe;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class ProbeResponse
{
  public ProbeCallback cb;
  public String errDesc;
  public HashMap<ProbeItem, ProbeItem.ProbeResult> mProbeItemResults;
  public long startTime = System.currentTimeMillis();
  public boolean success;
  public int triggePoint;
  
  public ProbeResponse(int paramInt, ProbeCallback paramProbeCallback)
  {
    this.cb = paramProbeCallback;
    this.success = false;
    this.errDesc = "";
    this.triggePoint = paramInt;
    this.mProbeItemResults = new HashMap();
  }
  
  public String getResult()
  {
    String str = "---ProbeTask Strat " + new Timestamp(this.startTime).toString() + " from " + this.triggePoint + "---\n";
    Iterator localIterator = this.mProbeItemResults.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (ProbeItem)localIterator.next();
      localObject = (ProbeItem.ProbeResult)this.mProbeItemResults.get(localObject);
      str = str + ((ProbeItem.ProbeResult)localObject).getRdmReportMsg();
    }
    return str + "----ProbeTask End----\n";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.netprobe.ProbeResponse
 * JD-Core Version:    0.7.0.1
 */
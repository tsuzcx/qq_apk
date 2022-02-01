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
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("---ProbeTask Strat ");
    ((StringBuilder)localObject1).append(new Timestamp(this.startTime).toString());
    ((StringBuilder)localObject1).append(" from ");
    ((StringBuilder)localObject1).append(this.triggePoint);
    ((StringBuilder)localObject1).append("---\n");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = this.mProbeItemResults.keySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (ProbeItem)((Iterator)localObject2).next();
      localObject3 = (ProbeItem.ProbeResult)this.mProbeItemResults.get(localObject3);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(((ProbeItem.ProbeResult)localObject3).getRdmReportMsg());
      localObject1 = localStringBuilder.toString();
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("----ProbeTask End----\n");
    return ((StringBuilder)localObject2).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.highway.netprobe.ProbeResponse
 * JD-Core Version:    0.7.0.1
 */
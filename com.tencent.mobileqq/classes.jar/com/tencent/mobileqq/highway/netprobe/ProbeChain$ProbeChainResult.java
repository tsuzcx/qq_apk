package com.tencent.mobileqq.highway.netprobe;

import java.util.ArrayList;

public class ProbeChain$ProbeChainResult
  extends ProbeItem.ProbeResult
{
  public ArrayList<ProbeItem.ProbeResult> subResults = new ArrayList();
  
  public ProbeChain$ProbeChainResult(String paramString, ProbeCallback paramProbeCallback)
  {
    super(paramString, paramProbeCallback);
  }
  
  public String getRdmReportMsg()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("<");
    ((StringBuilder)localObject1).append(this.probeName);
    ((StringBuilder)localObject1).append(" start >");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("<");
    ((StringBuilder)localObject2).append(this.probeName);
    ((StringBuilder)localObject2).append(" end >");
    localObject2 = ((StringBuilder)localObject2).toString();
    int j = this.subResults.size();
    int i = 0;
    while (i < j)
    {
      localObject3 = (ProbeItem.ProbeResult)this.subResults.get(i);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(((ProbeItem.ProbeResult)localObject3).getRdmReportMsg());
      localObject1 = localStringBuilder.toString();
      i += 1;
    }
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append((String)localObject2);
    return ((StringBuilder)localObject3).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.highway.netprobe.ProbeChain.ProbeChainResult
 * JD-Core Version:    0.7.0.1
 */
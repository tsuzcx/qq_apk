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
    String str1 = "<" + this.probeName + " start >";
    String str2 = "<" + this.probeName + " end >";
    int j = this.subResults.size();
    int i = 0;
    while (i < j)
    {
      ProbeItem.ProbeResult localProbeResult = (ProbeItem.ProbeResult)this.subResults.get(i);
      str1 = str1 + localProbeResult.getRdmReportMsg();
      i += 1;
    }
    return str1 + str2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.netprobe.ProbeChain.ProbeChainResult
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.highway.netprobe;

public class ProbeItem$ProbeResult
{
  public ProbeCallback cb;
  public int errCode;
  public String errDesc;
  public Object extra;
  public String probeName;
  protected StringBuilder result = new StringBuilder();
  public boolean success = false;
  
  public ProbeItem$ProbeResult(String paramString, ProbeCallback paramProbeCallback)
  {
    this.cb = paramProbeCallback;
    this.probeName = paramString;
    this.errCode = 0;
  }
  
  public ProbeResult appendResult(String paramString)
  {
    this.result.append(paramString);
    if (this.cb != null) {
      this.cb.onProbeProgress(paramString);
    }
    return this;
  }
  
  public String getRdmReportMsg()
  {
    String str1 = "<" + this.probeName + " start>";
    String str2 = "<" + this.probeName + " end>";
    return str1 + "succ:" + this.success + ",result:" + this.result.toString() + ",errDesc:" + this.errDesc + str2;
  }
  
  public String getResult()
  {
    return this.result.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.netprobe.ProbeItem.ProbeResult
 * JD-Core Version:    0.7.0.1
 */
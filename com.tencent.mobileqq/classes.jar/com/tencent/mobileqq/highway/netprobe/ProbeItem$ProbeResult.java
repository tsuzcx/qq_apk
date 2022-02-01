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
    ProbeCallback localProbeCallback = this.cb;
    if (localProbeCallback != null) {
      localProbeCallback.onProbeProgress(paramString);
    }
    return this;
  }
  
  public String getRdmReportMsg()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("<");
    ((StringBuilder)localObject1).append(this.probeName);
    ((StringBuilder)localObject1).append(" start>");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("<");
    ((StringBuilder)localObject2).append(this.probeName);
    ((StringBuilder)localObject2).append(" end>");
    localObject2 = ((StringBuilder)localObject2).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append("succ:");
    localStringBuilder.append(this.success);
    localStringBuilder.append(",result:");
    localStringBuilder.append(this.result.toString());
    localStringBuilder.append(",errDesc:");
    localStringBuilder.append(this.errDesc);
    localStringBuilder.append((String)localObject2);
    return localStringBuilder.toString();
  }
  
  public String getResult()
  {
    return this.result.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.highway.netprobe.ProbeItem.ProbeResult
 * JD-Core Version:    0.7.0.1
 */
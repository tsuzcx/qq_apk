package com.tencent.mobileqq.highway.netprobe;

public abstract interface ProbeCallback
{
  public abstract void onProbeFinish(ProbeResponse paramProbeResponse);
  
  public abstract void onProbeProgress(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.highway.netprobe.ProbeCallback
 * JD-Core Version:    0.7.0.1
 */
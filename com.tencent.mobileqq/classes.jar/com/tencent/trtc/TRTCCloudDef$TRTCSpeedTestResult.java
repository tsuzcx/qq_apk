package com.tencent.trtc;

public class TRTCCloudDef$TRTCSpeedTestResult
{
  public float downLostRate;
  public String ip;
  public int quality;
  public int rtt;
  public float upLostRate;
  
  public String toString()
  {
    return String.format("ip: %s, quality: %d, upLostRate: %.2f%%, downLostRate: %.2f%%, rtt: %d", new Object[] { this.ip, Integer.valueOf(this.quality), Float.valueOf(this.upLostRate * 100.0F), Float.valueOf(this.downLostRate * 100.0F), Integer.valueOf(this.rtt) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trtc.TRTCCloudDef.TRTCSpeedTestResult
 * JD-Core Version:    0.7.0.1
 */
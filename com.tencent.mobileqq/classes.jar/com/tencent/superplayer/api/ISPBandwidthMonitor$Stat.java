package com.tencent.superplayer.api;

public class ISPBandwidthMonitor$Stat
{
  public long httpBandwidth;
  public long p2pBandwidth;
  public long pcdnBandwidth;
  
  public static Stat diff(Stat paramStat1, Stat paramStat2)
  {
    Stat localStat = new Stat();
    paramStat2.httpBandwidth -= paramStat1.httpBandwidth;
    paramStat2.pcdnBandwidth -= paramStat1.pcdnBandwidth;
    paramStat2.p2pBandwidth -= paramStat1.p2pBandwidth;
    return localStat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.superplayer.api.ISPBandwidthMonitor.Stat
 * JD-Core Version:    0.7.0.1
 */
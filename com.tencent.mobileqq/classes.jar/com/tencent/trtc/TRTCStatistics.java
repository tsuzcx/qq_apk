package com.tencent.trtc;

import java.util.ArrayList;

public class TRTCStatistics
{
  public int appCpu;
  public int downLoss;
  public ArrayList<TRTCStatistics.TRTCLocalStatistics> localArray;
  public long receiveBytes;
  public ArrayList<TRTCStatistics.TRTCRemoteStatistics> remoteArray;
  public int rtt;
  public long sendBytes;
  public int systemCpu;
  public int upLoss;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trtc.TRTCStatistics
 * JD-Core Version:    0.7.0.1
 */
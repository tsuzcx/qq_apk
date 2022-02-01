package com.tencent.mobileqq.shortvideo.dancemachine;

import java.util.ArrayList;

public class BoyDataReport
{
  public ArrayList<BoyDataReport.BoyItem> mBoyData = new ArrayList();
  public long mGameDuration;
  public long mGameTotalScore;
  public boolean mHasReported = false;
  
  public void clear()
  {
    this.mBoyData.clear();
    this.mGameDuration = 0L;
    this.mGameTotalScore = 0L;
    this.mHasReported = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.BoyDataReport
 * JD-Core Version:    0.7.0.1
 */
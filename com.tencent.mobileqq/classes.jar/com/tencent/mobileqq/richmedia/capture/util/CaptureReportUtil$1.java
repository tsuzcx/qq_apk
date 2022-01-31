package com.tencent.mobileqq.richmedia.capture.util;

import auts;
import autu;
import com.tencent.mobileqq.shortvideo.dancemachine.BoyDataReport;
import com.tencent.mobileqq.shortvideo.dancemachine.BoyDataReport.BoyItem;
import java.util.ArrayList;
import java.util.Iterator;

public final class CaptureReportUtil$1
  implements Runnable
{
  public CaptureReportUtil$1(BoyDataReport paramBoyDataReport) {}
  
  public void run()
  {
    auts.a(this.a.mGameTotalScore, this.a.mGameDuration);
    Iterator localIterator = this.a.mBoyData.iterator();
    while (localIterator.hasNext())
    {
      BoyDataReport.BoyItem localBoyItem = (BoyDataReport.BoyItem)localIterator.next();
      if (localBoyItem.mEnd) {
        auts.a(localBoyItem.mId, "" + localBoyItem.mScore, auts.a(localBoyItem.status));
      }
    }
    autu.a().a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.util.CaptureReportUtil.1
 * JD-Core Version:    0.7.0.1
 */
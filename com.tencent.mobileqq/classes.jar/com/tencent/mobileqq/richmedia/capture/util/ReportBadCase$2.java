package com.tencent.mobileqq.richmedia.capture.util;

import bbgq;
import bhmi;
import com.tencent.mobileqq.shortvideo.dancemachine.BadcaseReportUtils.BadDataFrame;
import java.util.ArrayList;

public final class ReportBadCase$2
  implements Runnable
{
  public void run()
  {
    for (;;)
    {
      int i;
      synchronized ()
      {
        int j = bbgq.a().size();
        if (j > 0)
        {
          i = 0;
          if (i < j)
          {
            BadcaseReportUtils.BadDataFrame localBadDataFrame = (BadcaseReportUtils.BadDataFrame)bbgq.a().get(i);
            if ((!localBadDataFrame.mZipSuccess) || (localBadDataFrame.zipPath == null) || ("".equals(localBadDataFrame.zipPath))) {
              break label96;
            }
            bhmi.d(localBadDataFrame.zipPath);
            break label96;
          }
        }
        bbgq.a().clear();
        bbgq.a();
        return;
      }
      label96:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.util.ReportBadCase.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.richmedia.capture.util;

import babj;
import com.tencent.mobileqq.shortvideo.dancemachine.BadcaseReportUtils.BadDataFrame;
import com.tencent.mobileqq.utils.FileUtils;
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
        int j = babj.a().size();
        if (j > 0)
        {
          i = 0;
          if (i < j)
          {
            BadcaseReportUtils.BadDataFrame localBadDataFrame = (BadcaseReportUtils.BadDataFrame)babj.a().get(i);
            if ((!localBadDataFrame.mZipSuccess) || (localBadDataFrame.zipPath == null) || ("".equals(localBadDataFrame.zipPath))) {
              break label96;
            }
            FileUtils.deleteFile(localBadDataFrame.zipPath);
            break label96;
          }
        }
        babj.a().clear();
        babj.a();
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
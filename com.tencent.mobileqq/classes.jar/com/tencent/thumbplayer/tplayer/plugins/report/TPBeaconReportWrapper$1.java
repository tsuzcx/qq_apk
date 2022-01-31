package com.tencent.thumbplayer.tplayer.plugins.report;

import com.tencent.thumbplayer.utils.TPLogUtil;
import com.tencent.tvkbeacon.upload.InitHandleListener;

final class TPBeaconReportWrapper$1
  implements InitHandleListener
{
  public void onInitEnd()
  {
    TPLogUtil.i("TPBeaconReportWrapper", "init: onInitEnd");
  }
  
  public void onStrategyQuerySuccess()
  {
    TPLogUtil.i("TPBeaconReportWrapper", "init: onStrategyQuerySuccess");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.tplayer.plugins.report.TPBeaconReportWrapper.1
 * JD-Core Version:    0.7.0.1
 */
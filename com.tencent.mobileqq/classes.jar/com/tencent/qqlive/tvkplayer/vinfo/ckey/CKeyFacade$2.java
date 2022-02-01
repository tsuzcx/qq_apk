package com.tencent.qqlive.tvkplayer.vinfo.ckey;

import android.os.SystemClock;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.comm.VsGuidUtil;

class CKeyFacade$2
  implements Runnable
{
  CKeyFacade$2(CKeyFacade paramCKeyFacade) {}
  
  public void run()
  {
    CKeyFacade.access$202(VsGuidUtil.getInstance(CKeyFacade.access$000()).loadVsGuid());
    CKeyFacade.access$600();
    CKeyFacade.access$502(CKeyBeaconReport.getQIMEI());
    for (;;)
    {
      SystemClock.sleep(60000L);
      VsGuidUtil.getInstance(CKeyFacade.access$000()).updateVsGuid();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.ckey.CKeyFacade.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.qqlive.tvkplayer;

import com.tencent.qqlive.tvkplayer.vinfo.ckey.BeaconInterface;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.comm.BeaconAdapter;
import java.util.Map;
import java.util.Properties;

final class TVideoMgr$1
  implements BeaconInterface
{
  public String getQIMEI()
  {
    return BeaconAdapter.getQIMEI();
  }
  
  public Properties getRequiredReportValue()
  {
    return null;
  }
  
  public boolean trackCustomKVEvent(String paramString, Map<String, String> paramMap)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.TVideoMgr.1
 * JD-Core Version:    0.7.0.1
 */
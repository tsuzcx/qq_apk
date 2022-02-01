package com.tencent.superplayer.report;

import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import com.tencent.superplayer.utils.ThreadUtil;
import com.tencent.thumbplayer.tplayer.plugins.report.BeaconAdapter;
import java.util.HashMap;
import java.util.Map;

public class SPBeaconReporter
{
  private static final String APP_KEY = "00000U7O8S3BLETM";
  private static final String TAG = ".SPBeaconReporter";
  
  public static void init()
  {
    BeaconAdapter.registerTunnel("00000U7O8S3BLETM", SuperPlayerSDKMgr.getSDKVersion(), "superPlayer");
  }
  
  public static void report(String paramString, Map<String, String> paramMap)
  {
    ThreadUtil.runOnSubThread(new SPBeaconReporter.1(paramString, new HashMap(paramMap)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.report.SPBeaconReporter
 * JD-Core Version:    0.7.0.1
 */
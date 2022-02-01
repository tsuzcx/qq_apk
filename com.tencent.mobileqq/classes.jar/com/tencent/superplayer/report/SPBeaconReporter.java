package com.tencent.superplayer.report;

import android.os.Handler;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import com.tencent.superplayer.utils.ThreadUtil;
import com.tencent.thumbplayer.core.downloadproxy.apiinner.TPListenerManager;
import com.tencent.thumbplayer.tplayer.plugins.report.BeaconAdapter;
import java.util.HashMap;
import java.util.Map;

public class SPBeaconReporter
{
  public static final String APP_KEY = "00000U7O8S3BLETM";
  private static final String TAG = ".SPBeaconReporter";
  
  public static void init()
  {
    BeaconAdapter.registerTunnel("00000U7O8S3BLETM", SuperPlayerSDKMgr.getSDKVersion(), "superPlayer");
    TPListenerManager.getInstance().setDownloadListener(new SPBeaconReporter.1());
  }
  
  public static void report(String paramString, Map<String, String> paramMap)
  {
    paramMap = new HashMap(paramMap);
    ThreadUtil.getSubThreadHandler().post(new SPBeaconReporter.2(paramString, paramMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.superplayer.report.SPBeaconReporter
 * JD-Core Version:    0.7.0.1
 */
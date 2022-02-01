package com.tencent.thumbplayer.tplayer.plugins.report;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.util.HashMap;
import java.util.Map;

public class TPBeaconReportWrapper
{
  private static final String APP_KEY = "00000GODBG3702Y1";
  private static final String EVENT_KEY_BUFFERING = "second_buffering";
  private static final String EVENT_KEY_FIRST_LOAD = "first_load";
  private static final String EVENT_KEY_FIRST_RENDERING = "first_rendering";
  private static final String EVENT_KEY_GET_CDN_URL = "get_cdn_url";
  private static final String EVENT_KEY_INIT_PLAYER = "init_player";
  private static final String EVENT_KEY_LIVE_FIRST_LOAD = "live_loading";
  private static final String EVENT_KEY_LIVE_PERIOD = "live_period";
  private static final String EVENT_KEY_LIVE_PLAY_ERROR = "live_error";
  private static final String EVENT_KEY_LOAD_SUBTITLE = "load_subtitle";
  private static final String EVENT_KEY_PLAY_DONE = "play_done";
  private static final String EVENT_KEY_REDIRECT = "302_redirect";
  private static final String EVENT_KEY_USER_SEEK = "user_seek";
  private static final String TAG = "TPBeaconReportWrapper";
  
  private static String getEventId(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 5: 
      return "init_player";
    case 15: 
      return "get_cdn_url";
    case 30: 
      return "first_load";
    case 32: 
      return "first_rendering";
    case 33: 
      return "load_subtitle";
    case 34: 
      return "302_redirect";
    case 35: 
      return "second_buffering";
    case 40: 
      return "user_seek";
    case 50: 
      return "play_done";
    case 205: 
      return "live_loading";
    case 263: 
      return "live_period";
    }
    return "live_error";
  }
  
  public static void init(Context paramContext)
  {
    TPLogUtil.i("TPBeaconReportWrapper", "Beacon sdk init.");
    BeaconAdapter.setLogAble(false, false);
    BeaconAdapter.registerTunnel("00000GODBG3702Y1", "", "");
  }
  
  public static void reportEvent(ITPReportProperties paramITPReportProperties)
  {
    HashMap localHashMap = new HashMap();
    paramITPReportProperties.propertiesToMap(localHashMap);
    if (localHashMap.containsKey("step"))
    {
      paramITPReportProperties = (String)localHashMap.get("step");
      if (paramITPReportProperties != null)
      {
        paramITPReportProperties = getEventId(Integer.parseInt(paramITPReportProperties));
        if (!TextUtils.isEmpty(paramITPReportProperties))
        {
          TPLogUtil.i("TPBeaconReportWrapper", "reportEvent: eventId = " + paramITPReportProperties);
          BeaconAdapter.onUserActionToTunnel("00000GODBG3702Y1", paramITPReportProperties, true, -1L, -1L, localHashMap, true, true);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.tplayer.plugins.report.TPBeaconReportWrapper
 * JD-Core Version:    0.7.0.1
 */
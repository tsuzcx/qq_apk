package com.tencent.thumbplayer.tplayer.plugins.report;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import com.tencent.thumbplayer.config.TPPlayerConfig;
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
    if (paramInt != 5)
    {
      if (paramInt != 15)
      {
        if (paramInt != 30)
        {
          if (paramInt != 40)
          {
            if (paramInt != 50)
            {
              if (paramInt != 150)
              {
                if (paramInt != 205)
                {
                  if (paramInt != 263)
                  {
                    switch (paramInt)
                    {
                    default: 
                      return "";
                    case 35: 
                      return "second_buffering";
                    case 34: 
                      return "302_redirect";
                    case 33: 
                      return "load_subtitle";
                    }
                    return "first_rendering";
                  }
                  return "live_period";
                }
                return "live_loading";
              }
              return "live_error";
            }
            return "play_done";
          }
          return "user_seek";
        }
        return "first_load";
      }
      return "get_cdn_url";
    }
    return "init_player";
  }
  
  public static void init(Context paramContext)
  {
    TPLogUtil.i("TPBeaconReportWrapper", "Beacon sdk init.");
    if ((!TextUtils.isEmpty(TPPlayerConfig.beacon_policy_host)) && (!TextUtils.isEmpty(TPPlayerConfig.beacon_log_host))) {
      UserAction.setReportDomain(TPPlayerConfig.beacon_policy_host, TPPlayerConfig.beacon_log_host);
    }
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
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("reportEvent: eventId = ");
          localStringBuilder.append(paramITPReportProperties);
          TPLogUtil.i("TPBeaconReportWrapper", localStringBuilder.toString());
          trackCustomKVEvent(paramITPReportProperties, "00000GODBG3702Y1", localHashMap);
        }
      }
    }
  }
  
  public static void trackCustomKVEvent(String paramString, ITPReportProperties paramITPReportProperties)
  {
    HashMap localHashMap = new HashMap();
    paramITPReportProperties.propertiesToMap(localHashMap);
    trackCustomKVEvent(paramString, "00000GODBG3702Y1", localHashMap);
  }
  
  public static void trackCustomKVEvent(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    BeaconAdapter.onUserActionToTunnel(paramString2, paramString1, true, -1L, -1L, paramMap, true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.tplayer.plugins.report.TPBeaconReportWrapper
 * JD-Core Version:    0.7.0.1
 */
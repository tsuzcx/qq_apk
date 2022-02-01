package com.tencent.thumbplayer.tplayer.plugins.report;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.Map;

class TPReportManager$EventHandler
  extends Handler
{
  private static final int MSG_302_REDIRECT = 2001;
  private static final int MSG_APP_BACKGROUND = 2100;
  private static final int MSG_APP_FOREGROUND = 2101;
  private static final int MSG_BUFFERING_END = 1014;
  private static final int MSG_BUFFERING_START = 1013;
  private static final int MSG_CDN_UPDATE = 1018;
  private static final int MSG_CREATE_DONE = 1000;
  private static final int MSG_CREATE_START = 999;
  private static final int MSG_DOWNLOAD_UPDATE = 1017;
  private static final int MSG_EARLY_ERROR = 2003;
  private static final int MSG_FIRSTCLIP_OPEN = 1022;
  private static final int MSG_FIRST_PACKET = 1019;
  private static final int MSG_GET_CDN = 2000;
  private static final int MSG_HLS_PRIVATE_TAG = 1016;
  private static final int MSG_LIVE_PERIOD_REPORT = 3000;
  private static final int MSG_LOAD_SUBTITLE = 2002;
  private static final int MSG_PLAYER_ERROR = 1006;
  private static final int MSG_PLAYER_PAUSE = 1004;
  private static final int MSG_PLAYER_RELEASE = 1010;
  private static final int MSG_PLAYER_RESET = 1011;
  private static final int MSG_PLAYER_STOP = 1005;
  private static final int MSG_PLAY_COMPLETE = 1009;
  private static final int MSG_PREPARE_DONE = 1002;
  private static final int MSG_PROTOCOL_UPDATE = 1023;
  private static final int MSG_RENDERING_START = 1012;
  private static final int MSG_REPORT_LAST_EVENT = 4000;
  private static final int MSG_SEEK_COMPLETE = 1008;
  private static final int MSG_SELECT_TRACK = 2004;
  private static final int MSG_SELECT_TRACK_DONE = 2005;
  private static final int MSG_SET_PLAY_SPEED = 1015;
  private static final int MSG_SIGNAL_STRENGTH_REGISTER = 4001;
  private static final int MSG_SIGNAL_STRENGTH_UNREGISTER = 4002;
  private static final int MSG_START_PLAY = 1003;
  private static final int MSG_START_PREPARE = 1001;
  private static final int MSG_START_SEEK = 1007;
  private static final int MSG_SWITCH_DEF = 1020;
  private static final int MSG_SWITCH_DEF_END = 1021;
  
  TPReportManager$EventHandler(TPReportManager paramTPReportManager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Map localMap;
    if ((paramMessage.obj instanceof Map)) {
      localMap = (Map)paramMessage.obj;
    } else {
      localMap = null;
    }
    int i = paramMessage.what;
    if (i != 2100)
    {
      if (i != 2101)
      {
        if (i != 3000) {
          switch (i)
          {
          default: 
            switch (i)
            {
            default: 
              switch (i)
              {
              default: 
                return;
              case 4002: 
                TPReportManager.access$3700(this.this$0);
                return;
              case 4001: 
                TPReportManager.access$3600(this.this$0);
                return;
              }
              TPReportManager.access$3400(this.this$0);
              return;
            case 2005: 
              TPReportManager.access$2400(this.this$0, localMap);
              return;
            case 2004: 
              TPReportManager.access$2300(this.this$0, localMap);
              return;
            case 2003: 
              TPReportManager.access$2500(this.this$0, localMap);
              return;
            case 2002: 
              TPReportManager.access$2200(this.this$0, localMap);
              return;
            case 2001: 
              TPReportManager.access$2100(this.this$0, localMap);
              return;
            }
            TPReportManager.access$2000(this.this$0, localMap);
            return;
          case 1023: 
            TPReportManager.access$3500(this.this$0, localMap);
            return;
          case 1022: 
            TPReportManager.access$2700(this.this$0, localMap);
            return;
          case 1021: 
            TPReportManager.access$2900(this.this$0, localMap);
            return;
          case 1020: 
            TPReportManager.access$2800(this.this$0, localMap);
            return;
          case 1019: 
            TPReportManager.access$2600(this.this$0, localMap);
            return;
          case 1018: 
            TPReportManager.access$1900(this.this$0, localMap);
            return;
          case 1017: 
            TPReportManager.access$1800(this.this$0, localMap);
            return;
          case 1016: 
            if (!(paramMessage.obj instanceof String)) {
              break;
            }
            TPReportManager.access$3100(this.this$0, (String)paramMessage.obj);
            return;
          case 1015: 
            TPReportManager.access$1700(this.this$0, localMap);
            return;
          case 1014: 
            TPReportManager.access$1600(this.this$0, localMap);
            return;
          case 1013: 
            TPReportManager.access$1500(this.this$0, localMap);
            return;
          case 1012: 
            TPReportManager.access$600(this.this$0, localMap);
            return;
          case 1011: 
            TPReportManager.access$1400(this.this$0, localMap);
            return;
          case 1010: 
            TPReportManager.access$1300(this.this$0, localMap);
            return;
          case 1009: 
            TPReportManager.access$1200(this.this$0, localMap);
            return;
          case 1008: 
            TPReportManager.access$1100(this.this$0, localMap);
            return;
          case 1007: 
            TPReportManager.access$1000(this.this$0, localMap);
            return;
          case 1006: 
            TPReportManager.access$900(this.this$0, localMap);
            return;
          case 1005: 
            TPReportManager.access$800(this.this$0, localMap);
            return;
          case 1004: 
            TPReportManager.access$700(this.this$0, localMap);
            return;
          case 1003: 
            TPReportManager.access$500(this.this$0, localMap);
            return;
          case 1002: 
            TPReportManager.access$400(this.this$0, localMap);
            return;
          case 1001: 
            TPReportManager.access$300(this.this$0, localMap);
            return;
          case 1000: 
            TPReportManager.access$200(this.this$0, localMap);
            return;
          case 999: 
            TPReportManager.access$100(this.this$0, localMap);
            return;
          }
        } else {
          TPReportManager.access$3000(this.this$0);
        }
      }
      else {
        TPReportManager.access$3300(this.this$0);
      }
    }
    else {
      TPReportManager.access$3200(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.tplayer.plugins.report.TPReportManager.EventHandler
 * JD-Core Version:    0.7.0.1
 */
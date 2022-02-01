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
  private static final int MSG_RENDERING_START = 1012;
  private static final int MSG_REPORT_LAST_EVENT = 4000;
  private static final int MSG_SEEK_COMPLETE = 1008;
  private static final int MSG_SET_PLAY_SPEED = 1015;
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
    Map localMap = null;
    if ((paramMessage.obj instanceof Map)) {
      localMap = (Map)paramMessage.obj;
    }
    switch (paramMessage.what)
    {
    default: 
    case 999: 
    case 1000: 
    case 1001: 
    case 1002: 
    case 1003: 
    case 1012: 
    case 1004: 
    case 1005: 
    case 1006: 
    case 1007: 
    case 1008: 
    case 1009: 
    case 1010: 
    case 1011: 
    case 1013: 
    case 1014: 
    case 1015: 
    case 1017: 
    case 1018: 
    case 2000: 
    case 2001: 
    case 2002: 
    case 2003: 
    case 1019: 
    case 1022: 
    case 1020: 
    case 1021: 
    case 3000: 
    case 1016: 
      do
      {
        return;
        TPReportManager.access$100(this.this$0, localMap);
        return;
        TPReportManager.access$200(this.this$0, localMap);
        return;
        TPReportManager.access$300(this.this$0, localMap);
        return;
        TPReportManager.access$400(this.this$0, localMap);
        return;
        TPReportManager.access$500(this.this$0, localMap);
        return;
        TPReportManager.access$600(this.this$0, localMap);
        return;
        TPReportManager.access$700(this.this$0, localMap);
        return;
        TPReportManager.access$800(this.this$0, localMap);
        return;
        TPReportManager.access$900(this.this$0, localMap);
        return;
        TPReportManager.access$1000(this.this$0, localMap);
        return;
        TPReportManager.access$1100(this.this$0, localMap);
        return;
        TPReportManager.access$1200(this.this$0, localMap);
        return;
        TPReportManager.access$1300(this.this$0, localMap);
        return;
        TPReportManager.access$1400(this.this$0, localMap);
        return;
        TPReportManager.access$1500(this.this$0, localMap);
        return;
        TPReportManager.access$1600(this.this$0, localMap);
        return;
        TPReportManager.access$1700(this.this$0, localMap);
        return;
        TPReportManager.access$1800(this.this$0, localMap);
        return;
        TPReportManager.access$1900(this.this$0, localMap);
        return;
        TPReportManager.access$2000(this.this$0, localMap);
        return;
        TPReportManager.access$2100(this.this$0, localMap);
        return;
        TPReportManager.access$2200(this.this$0, localMap);
        return;
        TPReportManager.access$2300(this.this$0, localMap);
        return;
        TPReportManager.access$2400(this.this$0, localMap);
        return;
        TPReportManager.access$2500(this.this$0, localMap);
        return;
        TPReportManager.access$2600(this.this$0, localMap);
        return;
        TPReportManager.access$2700(this.this$0, localMap);
        return;
        TPReportManager.access$2800(this.this$0);
        return;
      } while (!(paramMessage.obj instanceof String));
      TPReportManager.access$2900(this.this$0, (String)paramMessage.obj);
      return;
    case 2100: 
      TPReportManager.access$3000(this.this$0);
      return;
    case 2101: 
      TPReportManager.access$3100(this.this$0);
      return;
    }
    TPReportManager.access$3200(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.tplayer.plugins.report.TPReportManager.EventHandler
 * JD-Core Version:    0.7.0.1
 */
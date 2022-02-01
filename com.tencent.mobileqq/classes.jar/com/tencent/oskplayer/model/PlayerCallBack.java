package com.tencent.oskplayer.model;

import java.util.List;
import java.util.Map;

public abstract class PlayerCallBack
{
  public static int EVENT_CONTROLLER_HIDE;
  public static int EVENT_CONTROLLER_SHOWN;
  public static int EVENT_MAX = eventId;
  public static int EVENT_MIN;
  public static int EVENT_PLAY_COMPLETE;
  public static int EVENT_PLAY_ERROR;
  public static int EVENT_PLAY_EXIT;
  public static int EVENT_PLAY_PAUSE;
  public static int EVENT_PLAY_POSITION_OUT_OF_BOUND;
  public static int EVENT_PLAY_PREPARE;
  public static int EVENT_PLAY_PREPARE_TIMEOUT;
  public static int EVENT_PLAY_RESUME;
  public static int EVENT_PLAY_START;
  public static int EVENT_PLAY_STOP;
  public static int EVENT_SEEK_BAR_ON_SEEK;
  public static int EVENT_SEEK_BAR_START_SEEK;
  public static int EVENT_SEEK_BAR_STOP_SEEK;
  private static int eventId;
  
  static
  {
    int i = eventId;
    eventId = i + 1;
    EVENT_MIN = i;
    i = eventId;
    eventId = i + 1;
    EVENT_PLAY_PREPARE = i;
    i = eventId;
    eventId = i + 1;
    EVENT_PLAY_START = i;
    i = eventId;
    eventId = i + 1;
    EVENT_PLAY_STOP = i;
    i = eventId;
    eventId = i + 1;
    EVENT_PLAY_COMPLETE = i;
    i = eventId;
    eventId = i + 1;
    EVENT_PLAY_PAUSE = i;
    i = eventId;
    eventId = i + 1;
    EVENT_PLAY_RESUME = i;
    i = eventId;
    eventId = i + 1;
    EVENT_PLAY_ERROR = i;
    i = eventId;
    eventId = i + 1;
    EVENT_PLAY_EXIT = i;
    i = eventId;
    eventId = i + 1;
    EVENT_PLAY_POSITION_OUT_OF_BOUND = i;
    i = eventId;
    eventId = i + 1;
    EVENT_PLAY_PREPARE_TIMEOUT = i;
    i = eventId;
    eventId = i + 1;
    EVENT_SEEK_BAR_START_SEEK = i;
    i = eventId;
    eventId = i + 1;
    EVENT_SEEK_BAR_ON_SEEK = i;
    i = eventId;
    eventId = i + 1;
    EVENT_SEEK_BAR_STOP_SEEK = i;
    i = eventId;
    eventId = i + 1;
    EVENT_CONTROLLER_SHOWN = i;
    i = eventId;
    eventId = i + 1;
    EVENT_CONTROLLER_HIDE = i;
  }
  
  public abstract void onCacheRead(PlayerCallBack paramPlayerCallBack, long paramLong1, long paramLong2);
  
  public abstract void onHttpDownloadError(PlayerCallBack paramPlayerCallBack, String paramString1, String paramString2, int paramInt1, String paramString3, Map<String, List<String>> paramMap, int paramInt2, long paramLong1, long paramLong2);
  
  public abstract void onMediaEvent(PlayerCallBack paramPlayerCallBack, int paramInt, String paramString, VideoInfo paramVideoInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.model.PlayerCallBack
 * JD-Core Version:    0.7.0.1
 */
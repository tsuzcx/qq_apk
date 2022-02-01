package com.tencent.thumbplayer.api.connection;

import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.MapConnectionAction;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.MapConnectionConfig;

public class TPPlayerConnectionConstant
{
  @TPNativeKeyMap.MapConnectionAction(-1)
  public static final int ACTION_NONE = -1;
  @TPNativeKeyMap.MapConnectionAction(1)
  public static final int ACTION_OBTAIN_SYNC_CLOCK = 1;
  @TPNativeKeyMap.MapConnectionAction(0)
  public static final int ACTION_PROVIDE_SYNC_CLOCK = 0;
  @TPNativeKeyMap.MapConnectionConfig(0)
  public static final int CFG_LONG_SYNC_CLOCK_OFFSET_MS = 0;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.api.connection.TPPlayerConnectionConstant
 * JD-Core Version:    0.7.0.1
 */
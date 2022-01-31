package com.tencent.superplayer.player;

abstract interface ISPlayerState
{
  public static final int CGIED = 2;
  public static final int CGIING = 1;
  public static final int COMPLETE = 7;
  public static final int ERROR = 9;
  public static final int IDLE = 0;
  public static final int PAUSED = 6;
  public static final int PREPARED = 4;
  public static final int PREPARING = 3;
  public static final int RELEASED = 10;
  public static final int STARTED = 5;
  public static final int STOPPED = 8;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.player.ISPlayerState
 * JD-Core Version:    0.7.0.1
 */
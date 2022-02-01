package com.tencent.trpcprotocol.ilive.roomAccess.roomAccess.nano;

public abstract interface RoomAccess
{
  public static final int Pause = 3;
  public static final int Reply_BlackHit = 1002;
  public static final int Reply_GetAvErr = 1006;
  public static final int Reply_KickOut = 1004;
  public static final int Reply_LowVersion = 1003;
  public static final int Reply_OK = 0;
  public static final int Reply_ParamError = 1001;
  public static final int Reply_UnknownRoom = 1005;
  public static final int Restart = 5;
  public static final int Resume = 6;
  public static final int Start = 1;
  public static final int Stop = 2;
  public static final int Stuck = 4;
  public static final int Unknown = 0;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.roomAccess.roomAccess.nano.RoomAccess
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.upload.utils;

public final class Const$FailureCode
{
  public static final int CONNECTION_FAILED = 0;
  public static final int FORCE_CHANGEROUTE = 6;
  public static final int HANDSHAKE_FAILED = 1;
  public static final int SERVER_CLOSED = 5;
  public static final int SOCKET_FAILED = 4;
  public static final int TIMEOUT_FAILED = 3;
  public static final int UNPACKET_FAILED = 2;
  
  public static String print(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5)
            {
              if (paramInt != 6) {
                return "unknown";
              }
              return "forceChangeRoute";
            }
            return "serverClosed";
          }
          return "socketFailed";
        }
        return "unpacketFailed";
      }
      return "handshakeFailed";
    }
    return "connectionFailed";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.upload.utils.Const.FailureCode
 * JD-Core Version:    0.7.0.1
 */
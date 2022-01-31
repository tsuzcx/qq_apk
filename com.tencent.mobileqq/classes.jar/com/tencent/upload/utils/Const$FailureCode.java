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
    switch (paramInt)
    {
    case 3: 
    default: 
      return "unknown";
    case 0: 
      return "connectionFailed";
    case 1: 
      return "handshakeFailed";
    case 2: 
      return "unpacketFailed";
    case 4: 
      return "socketFailed";
    case 5: 
      return "serverClosed";
    }
    return "forceChangeRoute";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.utils.Const.FailureCode
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.upload.utils;

public class PduHeader$OFFSET
{
  public static int CHECKSUM;
  public static int CMD;
  public static int KEY;
  public static int LEN = 19;
  public static int RESERVERD;
  public static int RESPONSE_FLAG;
  public static int RESPONSE_INFO;
  public static int SEQ;
  public static int VERSION = 0;
  
  static
  {
    CMD = 1;
    CHECKSUM = 5;
    SEQ = 7;
    KEY = 11;
    RESPONSE_FLAG = 15;
    RESPONSE_INFO = 16;
    RESERVERD = 18;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.upload.utils.PduHeader.OFFSET
 * JD-Core Version:    0.7.0.1
 */
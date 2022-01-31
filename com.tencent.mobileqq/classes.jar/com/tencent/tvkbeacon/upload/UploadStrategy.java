package com.tencent.tvkbeacon.upload;

public class UploadStrategy
{
  public static boolean DEFAULT_BEACON_ID_ENABLE = true;
  public static boolean DEFAULT_CC_ENABLE;
  public static int DEFAULT_COMMON_DELAY;
  public static int DEFAULT_COM_NUM_DB;
  public static int DEFAULT_COM_NUM_UPLOAD;
  public static boolean DEFAULT_COM_POLL_UP;
  public static boolean DEFAULT_PAGE_PATH_ENABLE = true;
  public static int DEFAULT_REAL_NUM_UPLOAD;
  public static int DEFAULT_REAL_TIME_DELAY;
  public static boolean DEFAULT_SENSOR_ENABLE;
  public static boolean IS_COLLECT_IMEI;
  public static boolean IS_COLLECT_MAC;
  public static boolean IS_STOP_BACKGROUND_TASK;
  
  static
  {
    DEFAULT_CC_ENABLE = true;
    DEFAULT_SENSOR_ENABLE = true;
    DEFAULT_COM_POLL_UP = true;
    DEFAULT_REAL_NUM_UPLOAD = 12;
    DEFAULT_REAL_TIME_DELAY = 60;
    DEFAULT_COM_NUM_DB = 12;
    DEFAULT_COMMON_DELAY = 60;
    DEFAULT_COM_NUM_UPLOAD = 20;
    IS_COLLECT_MAC = true;
    IS_COLLECT_IMEI = true;
    IS_STOP_BACKGROUND_TASK = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.upload.UploadStrategy
 * JD-Core Version:    0.7.0.1
 */
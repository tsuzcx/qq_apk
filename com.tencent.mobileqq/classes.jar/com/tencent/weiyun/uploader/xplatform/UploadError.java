package com.tencent.weiyun.uploader.xplatform;

public class UploadError
{
  public static final int BUSI_CHANNEL_CHECK_ERR = 10009;
  public static final int BUSI_CHANNEL_EMPTY = 10007;
  public static final int BUSI_CHANNEL_ERROR = 10008;
  public static final int BUSI_CHANNEL_RSP_EMPTY = 10030;
  public static final int BUSI_EMPTY_RESULT = 10005;
  public static final int BUSI_GETDATA_EMPTY = 10006;
  public static final int BUSI_HANDLE_NO_MATCH = 10003;
  public static final int BUSI_SELECT_ERROR = 10001;
  public static final int BUSI_SELECT_TIMEOUT = 10002;
  public static final int BUSI_SEND_NO_FINISH = 10004;
  public static final int BUSI_TASK_MISS_WARNING = 10010;
  public static final int CURL_FAILED_TO_CONNECT_HOST = 20007;
  public static final int CURL_FAILURE_WITH_RECEIVING = 20056;
  public static final int CURL_FAILURE_WITH_TIMEOUT = 20028;
  
  public static boolean isBusinessError(int paramInt)
  {
    return paramInt > 10000;
  }
  
  public static boolean isCurlError(int paramInt)
  {
    return (paramInt <= 20100) && (paramInt > 20000);
  }
  
  public static boolean isServerError(int paramInt)
  {
    return paramInt < 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weiyun.uploader.xplatform.UploadError
 * JD-Core Version:    0.7.0.1
 */
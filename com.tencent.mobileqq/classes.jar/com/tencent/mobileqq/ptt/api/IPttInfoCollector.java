package com.tencent.mobileqq.ptt.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface IPttInfoCollector
  extends QRouteApi
{
  public static final int CHANGE_VOICE = 4;
  public static final int PTT_DISCUSSION = 2;
  public static final int PTT_DOWNLOAD_TYPE_CHATHISTORY = 5;
  public static final int PTT_DOWNLOAD_TYPE_LOCK_WINDOW = 7;
  public static final int PTT_DOWNLOAD_TYPE_NORMAL = 1;
  public static final int PTT_DOWNLOAD_TYPE_OPENAPI_NORMAL = 3;
  public static final int PTT_DOWNLOAD_TYPE_OPENAPI_REDOWN = 4;
  public static final int PTT_DOWNLOAD_TYPE_PRE_DOWNLOADER = 6;
  public static final int PTT_DOWNLOAD_TYPE_REDOWN = 2;
  public static final int PTT_FRIENDS = 1;
  public static final int PTT_GROUP = 3;
  public static final int PTT_OTHER = 4;
  public static final int PTT_PV_DOWNLOAD = 2;
  public static final int PTT_PV_PLAY = 1;
  public static final int PTT_PV_PRODUCT_D0 = 3;
  public static final int PTT_PV_PRODUCT_F2 = 4;
  public static final int RECORD_CHANGE_VOICE = 3;
  public static final int RECORD_OFFLINE = 2;
  public static final int RECORD_STREAM = 1;
  public static final long sCostUntilPrepare = 0L;
  
  public abstract long getsCostUntilPrepare();
  
  public abstract void noteOneFrameProcessed();
  
  public abstract void putPttSendCostRecorder(String paramString, Long paramLong);
  
  public abstract void reportGcAndMemoryUse(int paramInt1, int paramInt2);
  
  public abstract void reportPTTPV(AppRuntime paramAppRuntime, int paramInt1, boolean paramBoolean, int paramInt2);
  
  public abstract void reportPttSendCost(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt, long paramLong);
  
  public abstract void reportPttUploadType(boolean paramBoolean, long paramLong1, long paramLong2, long paramLong3);
  
  public abstract void reportSoundProcessCost(long paramLong1, int paramInt1, long paramLong2, int paramInt2);
  
  public abstract void setsCostUntilPrepare(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.api.IPttInfoCollector
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.ptt;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;

@QAPI(process={"all"})
public abstract interface IQQRecorderUtils
  extends QRouteApi
{
  public static final int ABNORMAL_NO_DATA = 0;
  public static final int ABNORMAL_NO_VOLUME = 1;
  public static final String ABNORMAL_RECORD_URL = "https://kf.qq.com/touch/sappfaq/210331qMJbAf210331RZBBba.html";
  public static final int AUDIO_FORMAT = 2;
  public static final int CHANNEL_CONFIG = 2;
  public static final int VOLUME_STATE_INIT = 0;
  public static final int VOLUME_STATE_LOW = 1;
  public static final int VOLUME_STATE_NORMAL = 2;
  
  public abstract int bytesInMillisecond(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract int bytesInSecond(int paramInt);
  
  public abstract int bytesInSecond(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract boolean checkExternalStorageForRecord();
  
  public abstract boolean checkIntenalStorageForRecord(int paramInt);
  
  public abstract IQQRecorder createQQRecorder(Context paramContext);
  
  public abstract int dsToIs(double paramDouble);
  
  public abstract int getFilePlayTime(String paramString);
  
  public abstract String getLastRecorderPath();
  
  public abstract double getMillisecond(int paramInt1, int paramInt2, int paramInt3, long paramLong);
  
  public abstract int getPttRecordTime(double paramDouble);
  
  public abstract int getPttShowTime(int paramInt);
  
  public abstract RecordParams.RecorderParam getRecorderParam();
  
  public abstract int msToSec(double paramDouble);
  
  public abstract void setLastRecorderPath(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.IQQRecorderUtils
 * JD-Core Version:    0.7.0.1
 */
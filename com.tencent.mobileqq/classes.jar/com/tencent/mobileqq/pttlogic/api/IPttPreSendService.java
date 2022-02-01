package com.tencent.mobileqq.pttlogic.api;

import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import mqq.app.api.IRuntimeService;

@Service(process={"all"})
public abstract interface IPttPreSendService
  extends IRuntimeService
{
  public static final int FLOW_LIMIT_WIFI = 10000000;
  public static final int FLOW_LIMIT_XG = 100000;
  public static final int FLOW_MIN_AVAILABLE_WIFI = 10000;
  public static final int FLOW_MIN_AVAILABLE_XG = 4000;
  public static final long FLOW_REFRESH_TIME = 86399999L;
  
  public abstract void cleanUp();
  
  public abstract void doOnCancelSend();
  
  public abstract void doOnPreSendEnd(String paramString);
  
  public abstract boolean doOnRealSend(BaseSessionInfo paramBaseSessionInfo, int paramInt);
  
  public abstract void doPreSendIfIcan(BaseSessionInfo paramBaseSessionInfo, RecordParams.RecorderParam paramRecorderParam);
  
  public abstract void handleSliceData(byte[] paramArrayOfByte, int paramInt);
  
  public abstract void init();
  
  public abstract void startPreSendIfNeed(String paramString1, RecordParams.RecorderParam paramRecorderParam, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pttlogic.api.IPttPreSendService
 * JD-Core Version:    0.7.0.1
 */
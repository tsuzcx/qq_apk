package com.tencent.mobileqq.richmediabrowser.api;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.net.URL;
import mqq.os.MqqHandler;

@QAPI(process={"all"})
public abstract interface IShortVideoDepend
  extends QRouteApi
{
  public abstract String getLocalShortVideoPath();
  
  public abstract String getShortVideoSavePath(MessageRecord paramMessageRecord, String paramString);
  
  public abstract URL getThumbUrl(String paramString);
  
  public abstract Runnable getVideoFileSaveRunnable(String paramString1, MqqHandler paramMqqHandler, String paramString2, boolean paramBoolean);
  
  public abstract int getVideoSaveFailCode();
  
  public abstract int getVideoSaveSuccessCode();
  
  public abstract boolean isAEPituTakeSameOpen();
  
  public abstract void reportVideoPlayEvent(int paramInt1, String paramString, int paramInt2, int paramInt3, long paramLong1, long paramLong2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.api.IShortVideoDepend
 * JD-Core Version:    0.7.0.1
 */
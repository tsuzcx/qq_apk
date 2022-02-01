package com.tencent.mobileqq.pttlogic.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.Map;

@QAPI(process={"all"})
public abstract interface IPttBuffer
  extends QRouteApi
{
  public abstract boolean appendBuffer(String paramString, byte[] paramArrayOfByte, int paramInt);
  
  public abstract void cancelBufferTask(String paramString);
  
  public abstract boolean createBufferTask(String paramString);
  
  public abstract boolean flush(String paramString);
  
  public abstract Map getTaskMap();
  
  public abstract void setMaxBufferSize(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.pttlogic.api.IPttBuffer
 * JD-Core Version:    0.7.0.1
 */
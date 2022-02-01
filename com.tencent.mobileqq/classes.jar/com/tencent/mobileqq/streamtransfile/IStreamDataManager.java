package com.tencent.mobileqq.streamtransfile;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.Map.Entry;

@QAPI(process={"all"})
public abstract interface IStreamDataManager
  extends QRouteApi
{
  public abstract Map.Entry<String, StreamFileInfo> getStreamFileInfoEntryByMsg(long paramLong1, long paramLong2);
  
  public abstract boolean removeStreamTaskToMemoryPool(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.streamtransfile.IStreamDataManager
 * JD-Core Version:    0.7.0.1
 */
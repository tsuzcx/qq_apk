package com.tencent.mobileqq.winkpublish.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;

@QAPI(process={"all"})
public abstract interface IDataManager<T>
  extends QRouteApi
{
  public abstract T getData(long paramLong, String paramString);
  
  public abstract List<T> getDatas(long paramLong);
  
  public abstract T getLastData(long paramLong);
  
  public abstract String getLastMissionId(long paramLong);
  
  public abstract List<String> getMissionIds(long paramLong);
  
  public abstract void putMissionId(long paramLong, String paramString);
  
  public abstract void removeMissionId(long paramLong, String paramString);
  
  public abstract void removeMissionIdAndData(long paramLong, String paramString);
  
  public abstract void updateToastStatus(long paramLong, String paramString, int paramInt);
  
  public abstract void updateUploadStatus(long paramLong, String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.api.IDataManager
 * JD-Core Version:    0.7.0.1
 */
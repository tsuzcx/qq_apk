package com.tencent.mobileqq.winkpublish;

import com.tencent.mobileqq.qcircle.api.db.util.SmartParcelable;
import com.tencent.mobileqq.winkpublish.model.PublishQueueTaskInfo;
import java.util.List;

public abstract interface IQueueTask
  extends SmartParcelable
{
  public abstract boolean cancel();
  
  public abstract void clear();
  
  public abstract String getCacheKey();
  
  public abstract String getClientKey();
  
  public abstract int getExactType();
  
  public abstract PublishQueueTaskInfo getInfo();
  
  public abstract long getLeaveSize();
  
  public abstract int getManualRetryNum();
  
  public abstract String getMissionId();
  
  public abstract String getPhotoSource();
  
  public abstract List<String> getPhotoSources();
  
  public abstract int getResultCode();
  
  public abstract String getResultMsg();
  
  public abstract int getRetryNum();
  
  public abstract int getState();
  
  public abstract long getTaskId();
  
  public abstract long getTime();
  
  public abstract long getTimeStamp();
  
  public abstract long getUploadTime();
  
  public abstract void increaseManualRetryNum();
  
  public abstract void increaseRetryNum();
  
  public abstract boolean isNeedRetryByQueue();
  
  public abstract boolean isNullTask();
  
  public abstract boolean isQunTask();
  
  public abstract boolean isVideoTask();
  
  public abstract boolean needShowCloseBt();
  
  public abstract void notifyComplete(boolean paramBoolean);
  
  public abstract void onRemove();
  
  public abstract void onRestore();
  
  public abstract void onResume();
  
  public abstract void resetDataSize();
  
  public abstract void setResultCode(int paramInt);
  
  public abstract void setResultMsg(String paramString);
  
  public abstract void setState(int paramInt);
  
  public abstract void setTime(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.IQueueTask
 * JD-Core Version:    0.7.0.1
 */
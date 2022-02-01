package cooperation.qqcircle.report.outbox;

import com.tencent.mobileqq.qcircle.api.db.util.SmartParcelable;

public abstract interface IQueueTask
  extends SmartParcelable
{
  public abstract void clear();
  
  public abstract String getCacheKey();
  
  public abstract long getResultCode();
  
  public abstract String getResultMsg();
  
  public abstract int getRetryNum();
  
  public abstract int getState();
  
  public abstract long getTaskId();
  
  public abstract long getTime();
  
  public abstract boolean isNullTask();
  
  public abstract void onRemove();
  
  public abstract void onRestore();
  
  public abstract void onResume();
  
  public abstract void setResultCode(long paramLong);
  
  public abstract void setResultMsg(String paramString);
  
  public abstract void setState(int paramInt);
  
  public abstract void setTime(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqcircle.report.outbox.IQueueTask
 * JD-Core Version:    0.7.0.1
 */
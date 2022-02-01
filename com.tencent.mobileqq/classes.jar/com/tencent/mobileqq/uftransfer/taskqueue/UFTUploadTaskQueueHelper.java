package com.tencent.mobileqq.uftransfer.taskqueue;

import android.text.TextUtils;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import java.util.HashSet;
import java.util.Observable;
import java.util.Set;

public class UFTUploadTaskQueueHelper
  extends Observable
{
  private static UFTUploadTaskQueueHelper a;
  private Set<String> b = new HashSet();
  
  public static UFTUploadTaskQueueHelper a()
  {
    if (a == null) {
      a = new UFTUploadTaskQueueHelper();
    }
    return a;
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.b.add(paramString);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addUploadingFilePath:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" Size:");
      localStringBuilder.append(this.b.size());
      UFTLog.b("[UFTTransfer] UFTUploadTaskQueueHelper", 1, localStringBuilder.toString());
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.b.remove(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("remUploadingFilePath:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" Size:");
      localStringBuilder.append(this.b.size());
      localStringBuilder.append(" queueId:");
      localStringBuilder.append(paramInt);
      UFTLog.b("[UFTTransfer] UFTUploadTaskQueueHelper", 1, localStringBuilder.toString());
      setChanged();
      notifyObservers(new Object[] { paramString, Integer.valueOf(paramInt) });
    }
  }
  
  public boolean b(String paramString)
  {
    return this.b.contains(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.taskqueue.UFTUploadTaskQueueHelper
 * JD-Core Version:    0.7.0.1
 */
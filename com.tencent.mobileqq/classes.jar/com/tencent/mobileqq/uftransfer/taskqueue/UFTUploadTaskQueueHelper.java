package com.tencent.mobileqq.uftransfer.taskqueue;

import android.text.TextUtils;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import java.util.HashSet;
import java.util.Observable;
import java.util.Set;

public class UFTUploadTaskQueueHelper
  extends Observable
{
  private static UFTUploadTaskQueueHelper jdField_a_of_type_ComTencentMobileqqUftransferTaskqueueUFTUploadTaskQueueHelper;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  
  public static UFTUploadTaskQueueHelper a()
  {
    if (jdField_a_of_type_ComTencentMobileqqUftransferTaskqueueUFTUploadTaskQueueHelper == null) {
      jdField_a_of_type_ComTencentMobileqqUftransferTaskqueueUFTUploadTaskQueueHelper = new UFTUploadTaskQueueHelper();
    }
    return jdField_a_of_type_ComTencentMobileqqUftransferTaskqueueUFTUploadTaskQueueHelper;
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_JavaUtilSet.add(paramString);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addUploadingFilePath:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" Size:");
      localStringBuilder.append(this.jdField_a_of_type_JavaUtilSet.size());
      UFTLog.b("[UFTTransfer] UFTUploadTaskQueueHelper", 1, localStringBuilder.toString());
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilSet.remove(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("remUploadingFilePath:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" Size:");
      localStringBuilder.append(this.jdField_a_of_type_JavaUtilSet.size());
      localStringBuilder.append(" queueId:");
      localStringBuilder.append(paramInt);
      UFTLog.b("[UFTTransfer] UFTUploadTaskQueueHelper", 1, localStringBuilder.toString());
      setChanged();
      notifyObservers(new Object[] { paramString, Integer.valueOf(paramInt) });
    }
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_a_of_type_JavaUtilSet.contains(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.taskqueue.UFTUploadTaskQueueHelper
 * JD-Core Version:    0.7.0.1
 */
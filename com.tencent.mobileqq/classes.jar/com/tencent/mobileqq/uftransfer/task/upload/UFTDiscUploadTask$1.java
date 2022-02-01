package com.tencent.mobileqq.uftransfer.task.upload;

import android.text.TextUtils;
import com.tencent.mobileqq.uftransfer.depend.UFTDependFeatureApi;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import com.tencent.mobileqq.uftransfer.utility.UFTTransferUtility;

class UFTDiscUploadTask$1
  implements Runnable
{
  UFTDiscUploadTask$1(UFTDiscUploadTask paramUFTDiscUploadTask) {}
  
  public void run()
  {
    if (UFTDiscUploadTask.a(this.this$0)) {
      return;
    }
    this.this$0.a.a(UFTDiscUploadTask.a(this.this$0), 1, null);
    String str = this.this$0.a();
    StringBuilder localStringBuilder;
    if (!UFTDependFeatureApi.a())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("TId[");
      localStringBuilder.append(this.this$0.a());
      localStringBuilder.append("] send local file[");
      localStringBuilder.append(str);
      localStringBuilder.append("] no network");
      UFTLog.d("[UFTTransfer] UFTDiscUploadTask", 1, localStringBuilder.toString());
      this.this$0.a(9004, "NoNetWork", null);
      return;
    }
    if (TextUtils.isEmpty(str))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("TId[");
      localStringBuilder.append(this.this$0.a());
      localStringBuilder.append("] send local file[");
      localStringBuilder.append(str);
      localStringBuilder.append("] strFilePath is null");
      UFTLog.d("[UFTTransfer] UFTDiscUploadTask", 1, localStringBuilder.toString());
      this.this$0.a(9005, "strFilePath is null", null);
      return;
    }
    if (!UFTTransferUtility.a(str))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("TId[");
      localStringBuilder.append(this.this$0.a());
      localStringBuilder.append("] send local file[");
      localStringBuilder.append(str);
      localStringBuilder.append("] strFilePath is not exist");
      UFTLog.d("[UFTTransfer] UFTDiscUploadTask", 1, localStringBuilder.toString());
      this.this$0.a(9042, "fileNotExists", null);
      return;
    }
    if (UFTTransferUtility.a(str) == 0L)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("TId[");
      localStringBuilder.append(this.this$0.a());
      localStringBuilder.append("] send local file[");
      localStringBuilder.append(str);
      localStringBuilder.append("] strFilePath is empty file");
      UFTLog.d("[UFTTransfer] UFTDiscUploadTask", 1, localStringBuilder.toString());
      this.this$0.a(9071, "fileExistsEmpty", null);
      return;
    }
    this.this$0.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTDiscUploadTask.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.uftransfer.task.upload;

import android.text.TextUtils;
import com.tencent.mobileqq.uftransfer.depend.UFTDependFeatureApi;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import com.tencent.mobileqq.uftransfer.utility.UFTTransferUtility;

class UFTC2CUploadTask$1
  implements Runnable
{
  UFTC2CUploadTask$1(UFTC2CUploadTask paramUFTC2CUploadTask) {}
  
  public void run()
  {
    if (UFTC2CUploadTask.a(this.this$0)) {
      return;
    }
    this.this$0.a.a(UFTC2CUploadTask.a(this.this$0), 1, null);
    Object localObject = this.this$0.a();
    StringBuilder localStringBuilder;
    if (!UFTDependFeatureApi.a())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("TId[");
      localStringBuilder.append(this.this$0.a());
      localStringBuilder.append("] send local file[");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("] no network");
      UFTLog.d("[UFTTransfer] UFTC2CUploadTask", 1, localStringBuilder.toString());
      localObject = this.this$0;
      ((UFTC2CUploadTask)localObject).a(9004, ((UFTC2CUploadTask)localObject).a(1, "NoNetWork"));
      return;
    }
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("TId[");
      localStringBuilder.append(this.this$0.a());
      localStringBuilder.append("] send local file[");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("] strFilePath is null");
      UFTLog.d("[UFTTransfer] UFTC2CUploadTask", 1, localStringBuilder.toString());
      localObject = this.this$0;
      ((UFTC2CUploadTask)localObject).a(9005, ((UFTC2CUploadTask)localObject).a(1, "strFilePath is null"));
      return;
    }
    if (!UFTTransferUtility.a((String)localObject))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("TId[");
      localStringBuilder.append(this.this$0.a());
      localStringBuilder.append("] send local file[");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("] strFilePath is not exist");
      UFTLog.d("[UFTTransfer] UFTC2CUploadTask", 1, localStringBuilder.toString());
      localObject = this.this$0;
      ((UFTC2CUploadTask)localObject).a(9042, ((UFTC2CUploadTask)localObject).a(1, "fileNotExists"));
      return;
    }
    if (UFTTransferUtility.a((String)localObject) == 0L)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("TId[");
      localStringBuilder.append(this.this$0.a());
      localStringBuilder.append("] send local file[");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("] strFilePath is empty file");
      UFTLog.d("[UFTTransfer] UFTC2CUploadTask", 1, localStringBuilder.toString());
      localObject = this.this$0;
      ((UFTC2CUploadTask)localObject).a(9071, ((UFTC2CUploadTask)localObject).a(1, "fileExistsEmpty"));
      return;
    }
    this.this$0.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTC2CUploadTask.1
 * JD-Core Version:    0.7.0.1
 */
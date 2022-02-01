package com.tencent.mobileqq.uftransfer.task.upload;

import android.text.TextUtils;
import com.tencent.mobileqq.uftransfer.depend.UFTDependFeatureApi;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import java.io.File;

class UFTTroopUploadTask$1
  implements Runnable
{
  UFTTroopUploadTask$1(UFTTroopUploadTask paramUFTTroopUploadTask) {}
  
  public void run()
  {
    if (UFTTroopUploadTask.a(this.this$0)) {
      return;
    }
    this.this$0.a.a(UFTTroopUploadTask.a(this.this$0), 1, null);
    if (!UFTDependFeatureApi.a())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TId[");
      ((StringBuilder)localObject).append(this.this$0.a());
      ((StringBuilder)localObject).append("] send local file. no network");
      UFTLog.d("[UFTTransfer] UFTTroopUploadTask", 1, ((StringBuilder)localObject).toString());
      localObject = this.this$0.a(1, "NoNetWork");
      ((UFTTroopUploadTask.UFTToopUploadTaskCompParam)localObject).a(9, 901, 1, 7);
      this.this$0.a(106, (UFTTroopUploadTask.UFTToopUploadTaskCompParam)localObject);
      return;
    }
    if (TextUtils.isEmpty(this.this$0.a()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TId[");
      ((StringBuilder)localObject).append(this.this$0.a());
      ((StringBuilder)localObject).append("] send local file. file path is null");
      UFTLog.d("[UFTTransfer] UFTTroopUploadTask", 1, ((StringBuilder)localObject).toString());
      this.this$0.a(1, "strFilePath is null").a(10, 1001, 1, 3);
      localObject = this.this$0;
      ((UFTTroopUploadTask)localObject).a(201, ((UFTTroopUploadTask)localObject).a(1, "strFilePath is null"));
      return;
    }
    Object localObject = new File(this.this$0.a());
    if ((((File)localObject).exists()) && (((File)localObject).length() > 4294967296L))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TId[");
      ((StringBuilder)localObject).append(this.this$0.a());
      ((StringBuilder)localObject).append("] send local file. file size > 4G");
      UFTLog.d("[UFTTransfer] UFTTroopUploadTask", 1, ((StringBuilder)localObject).toString());
      this.this$0.a(1, "file size > 4G").a(5, 502, 1, 1);
      localObject = this.this$0;
      ((UFTTroopUploadTask)localObject).a(205, ((UFTTroopUploadTask)localObject).a(1, "file size > 4G"));
      return;
    }
    this.this$0.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTTroopUploadTask.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.uftransfer.task.upload;

import android.os.Bundle;
import com.tencent.mobileqq.uftransfer.api.IUFTUploadSendMsgCallback;

class UFTDiscUploadTask$5
  implements IUFTUploadSendMsgCallback
{
  UFTDiscUploadTask$5(UFTDiscUploadTask paramUFTDiscUploadTask) {}
  
  public void a(boolean paramBoolean, long paramLong, Bundle paramBundle)
  {
    if (!UFTDiscUploadTask.j(this.a))
    {
      long l = 0L;
      if (paramBoolean)
      {
        if (paramLong != 0L)
        {
          paramBundle = new StringBuilder();
          paramBundle.append("send msg return error.retCode:");
          paramBundle.append(paramLong);
          paramBundle = paramBundle.toString();
        }
        else
        {
          paramBundle = "";
          paramLong = l;
        }
      }
      else
      {
        l = 90460L;
        paramBundle = new StringBuilder();
        paramBundle.append("send msg return fail.retCode:");
        paramBundle.append(paramLong);
        paramBundle = paramBundle.toString();
        paramLong = l;
      }
      this.a.b((int)paramLong, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTDiscUploadTask.5
 * JD-Core Version:    0.7.0.1
 */
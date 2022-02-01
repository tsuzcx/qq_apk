package com.tencent.mobileqq.uftransfer.task.upload;

import android.os.Bundle;
import com.tencent.mobileqq.uftransfer.api.IUFTUploadSendMsgCallback;

class UFTTroopUploadTask$5
  implements IUFTUploadSendMsgCallback
{
  UFTTroopUploadTask$5(UFTTroopUploadTask paramUFTTroopUploadTask) {}
  
  public void a(boolean paramBoolean, long paramLong, Bundle paramBundle)
  {
    if (!UFTTroopUploadTask.l(this.a))
    {
      if (paramBoolean)
      {
        if (paramLong != 0L)
        {
          paramBundle = new StringBuilder();
          paramBundle.append("send msg return error:");
          paramBundle.append(paramLong);
          paramBundle = paramBundle.toString();
        }
        else
        {
          paramBundle = "";
          paramLong = 0L;
        }
      }
      else
      {
        long l = paramLong;
        if (paramLong == 0L) {
          l = -1L;
        }
        paramBundle = "send msg return fail";
        paramLong = l;
      }
      this.a.a((int)paramLong, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTTroopUploadTask.5
 * JD-Core Version:    0.7.0.1
 */
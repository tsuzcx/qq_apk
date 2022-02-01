package com.tencent.mobileqq.uftransfer.task.upload;

import android.os.Bundle;
import com.tencent.mobileqq.uftransfer.api.IUFTUploadSendMsgCallback;

class UFTC2CUploadTask$6
  implements IUFTUploadSendMsgCallback
{
  UFTC2CUploadTask$6(UFTC2CUploadTask paramUFTC2CUploadTask) {}
  
  public void a(boolean paramBoolean, long paramLong, Bundle paramBundle)
  {
    if (!UFTC2CUploadTask.h(this.a))
    {
      long l = 58L;
      Object localObject;
      if (paramBoolean)
      {
        if (58L == paramLong)
        {
          localObject = "ServerMasking";
        }
        else
        {
          localObject = "";
          l = 0L;
        }
      }
      else
      {
        l = 90460L;
        if (paramLong == -100001L) {
          l = 9043L;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("send msg return fail.retCode:");
        ((StringBuilder)localObject).append(paramLong);
        localObject = ((StringBuilder)localObject).toString();
      }
      int i;
      if (paramBundle != null)
      {
        i = paramBundle.getInt("seq");
        paramLong = paramBundle.getLong("uniSeq");
      }
      else
      {
        paramLong = 0L;
        i = 0;
      }
      this.a.a((int)l, (String)localObject, i, paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTC2CUploadTask.6
 * JD-Core Version:    0.7.0.1
 */
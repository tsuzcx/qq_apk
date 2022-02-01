package com.tencent.mobileqq.uftransfer.api.impl;

import android.os.Bundle;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import com.tencent.mobileqq.uftransfer.guild.UFTGuildUploadController;
import com.tencent.mobileqq.uftransfer.manager.controller.UFTC2CUploadController;
import com.tencent.mobileqq.uftransfer.manager.controller.UFTDiscUploadController;
import com.tencent.mobileqq.uftransfer.manager.controller.UFTTroopUploadController;

class UFTTransferServiceImpl$6
  implements Runnable
{
  UFTTransferServiceImpl$6(UFTTransferServiceImpl paramUFTTransferServiceImpl, UFTTransferKey paramUFTTransferKey, Bundle paramBundle) {}
  
  public void run()
  {
    int i = this.a.c();
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i == 10) {
            UFTTransferServiceImpl.access$600(this.this$0).a(this.a, this.b);
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("stop fail. trans type error:");
          localStringBuilder.append(this.a.c());
          UFTLog.d("[UFTTransfer] UFTTransferService", 1, localStringBuilder.toString());
          return;
        }
        if (this.a.d())
        {
          UFTTransferServiceImpl.access$400(this.this$0).a(this.a, this.b);
          return;
        }
        UFTTransferServiceImpl.access$100(this.this$0).a(this.a, this.b);
        return;
      }
      if (this.a.d())
      {
        UFTTransferServiceImpl.access$500(this.this$0).a(this.a, this.b);
        return;
      }
      UFTTransferServiceImpl.access$200(this.this$0).a(this.a, this.b);
      return;
    }
    if (this.a.d())
    {
      UFTTransferServiceImpl.access$300(this.this$0).a(this.a, this.b);
      return;
    }
    UFTTransferServiceImpl.access$000(this.this$0).a(this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.api.impl.UFTTransferServiceImpl.6
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.guild.message.base;

import android.os.Bundle;
import com.tencent.mobileqq.utils.SendMessageHandler.SendMessageRunnable;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

class BaseGuildMessageHandler$1
  extends SendMessageHandler.SendMessageRunnable
{
  BaseGuildMessageHandler$1(BaseGuildMessageHandler paramBaseGuildMessageHandler, BaseGuildMessageHandler.RequestBuilder paramRequestBuilder, long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    ToServiceMsg localToServiceMsg = this.a.a();
    if (localToServiceMsg == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("prepareRetryRunnable cmd=");
      localStringBuilder.append(localToServiceMsg.getServiceCmd());
      localStringBuilder.append(",reqSeq=");
      localStringBuilder.append(this.b);
      localStringBuilder.append(" timeout: ");
      localStringBuilder.append(this.g);
      localStringBuilder.append(" retryIndex:");
      localStringBuilder.append(this.m);
      QLog.d("BaseGuildMessageHandler", 2, localStringBuilder.toString());
    }
    localToServiceMsg.extraData.putLong("timeOut", this.g);
    localToServiceMsg.extraData.putLong("startTime", this.c);
    localToServiceMsg.extraData.putInt("retryIndex", this.m);
    localToServiceMsg.setTimeout(this.g);
    this.this$0.sendRequest(localToServiceMsg, this.b, this.d, this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.base.BaseGuildMessageHandler.1
 * JD-Core Version:    0.7.0.1
 */
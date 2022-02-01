package com.tencent.tfm.metrics;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.tfm.metrics.utils.AppInfo;

class NetworkStateReceiver$NetworkUpdateHandler
  extends Handler
{
  public void handleMessage(Message paramMessage)
  {
    AppInfo.updateNetWorkType((Context)paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tfm.metrics.NetworkStateReceiver.NetworkUpdateHandler
 * JD-Core Version:    0.7.0.1
 */
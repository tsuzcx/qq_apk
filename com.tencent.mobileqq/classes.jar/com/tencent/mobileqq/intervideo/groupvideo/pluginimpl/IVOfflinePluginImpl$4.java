package com.tencent.mobileqq.intervideo.groupvideo.pluginimpl;

import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import mzc;

class IVOfflinePluginImpl$4
  implements mzc
{
  IVOfflinePluginImpl$4(IVOfflinePluginImpl paramIVOfflinePluginImpl, long paramLong) {}
  
  public void loaded(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(IVOfflinePluginImpl.access$000(this.this$0), 2, "transToLocalUrl loadMode:" + paramInt + ", time:" + (System.currentTimeMillis() - this.val$startTime));
    }
    Message localMessage = IVOfflinePluginImpl.access$100(this.this$0).obtainMessage();
    localMessage.arg1 = 1;
    localMessage.arg2 = paramInt;
    localMessage.obj = paramString;
    IVOfflinePluginImpl.access$100(this.this$0).sendMessage(localMessage);
    if (IVOfflinePluginImpl.access$700(this.this$0) > 0L) {
      IVOfflinePluginImpl.access$702(this.this$0, 0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.pluginimpl.IVOfflinePluginImpl.4
 * JD-Core Version:    0.7.0.1
 */
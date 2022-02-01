package com.tencent.mobileqq.intervideo.groupvideo.pluginimpl;

import android.os.Handler;
import android.os.Message;
import com.tencent.biz.common.offline.AsyncCallBack;
import com.tencent.qphone.base.util.QLog;

class IVOfflinePluginImpl$4
  implements AsyncCallBack
{
  IVOfflinePluginImpl$4(IVOfflinePluginImpl paramIVOfflinePluginImpl, long paramLong) {}
  
  public void loaded(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = IVOfflinePluginImpl.access$000(this.this$0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("transToLocalUrl loadMode:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", time:");
      localStringBuilder.append(System.currentTimeMillis() - this.val$startTime);
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = IVOfflinePluginImpl.access$100(this.this$0).obtainMessage();
    ((Message)localObject).arg1 = 1;
    ((Message)localObject).arg2 = paramInt;
    ((Message)localObject).obj = paramString;
    IVOfflinePluginImpl.access$100(this.this$0).sendMessage((Message)localObject);
    if (IVOfflinePluginImpl.access$700(this.this$0) > 0L) {
      IVOfflinePluginImpl.access$702(this.this$0, 0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.pluginimpl.IVOfflinePluginImpl.4
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.intervideo.groupvideo.pluginimpl;

import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.qphone.base.util.QLog;

class IVOfflinePluginImpl$3
  implements AsyncBack
{
  IVOfflinePluginImpl$3(IVOfflinePluginImpl paramIVOfflinePluginImpl) {}
  
  public void loaded(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      String str = IVOfflinePluginImpl.access$000(this.this$0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkOfflineUpNotCallback, param = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" code = ");
      localStringBuilder.append(paramInt);
      QLog.i(str, 2, localStringBuilder.toString());
    }
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.pluginimpl.IVOfflinePluginImpl.3
 * JD-Core Version:    0.7.0.1
 */
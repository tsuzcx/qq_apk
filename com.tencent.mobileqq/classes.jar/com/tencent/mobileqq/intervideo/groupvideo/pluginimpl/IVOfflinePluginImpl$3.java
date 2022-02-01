package com.tencent.mobileqq.intervideo.groupvideo.pluginimpl;

import com.tencent.qphone.base.util.QLog;
import nmg;

class IVOfflinePluginImpl$3
  implements nmg
{
  IVOfflinePluginImpl$3(IVOfflinePluginImpl paramIVOfflinePluginImpl) {}
  
  public void loaded(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i(IVOfflinePluginImpl.access$000(this.this$0), 2, "checkOfflineUpNotCallback, param = " + paramString + " code = " + paramInt);
    }
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.pluginimpl.IVOfflinePluginImpl.3
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.qphone.base.util.QLog;

class BubbleUiPlugin$2
  extends Client.onRemoteRespObserver
{
  BubbleUiPlugin$2(BubbleUiPlugin paramBubbleUiPlugin) {}
  
  public void onBindedToClient()
  {
    if (this.this$0.isHomePageWatingBind)
    {
      this.this$0.reportBubbleSetting();
      if (QLog.isColorLevel()) {
        QLog.i("BubbleUiPlugin", 2, "onResume -> onBindedToClient:loadurl");
      }
      this.this$0.isHomePageWatingBind = false;
    }
  }
  
  public void onDisconnectWithService() {}
  
  public void onPushMsg(Bundle paramBundle) {}
  
  public void onResponse(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.BubbleUiPlugin.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.core.manager.VoIPManager;

class VoIPJsPlugin$4
  implements Runnable
{
  VoIPJsPlugin$4(VoIPJsPlugin paramVoIPJsPlugin) {}
  
  public void run()
  {
    VoIPManager.getInstance().exitRoom();
    VoIPManager.getInstance().setEventListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.VoIPJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */
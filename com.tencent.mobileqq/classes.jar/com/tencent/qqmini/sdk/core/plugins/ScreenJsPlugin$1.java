package com.tencent.qqmini.sdk.core.plugins;

class ScreenJsPlugin$1
  implements Runnable
{
  ScreenJsPlugin$1(ScreenJsPlugin paramScreenJsPlugin) {}
  
  public void run()
  {
    ScreenJsPlugin.ScreenShotListenManager localScreenShotListenManager = ScreenJsPlugin.ScreenShotListenManager.newInstance(this.this$0.mContext);
    localScreenShotListenManager.setListener(new ScreenJsPlugin.1.1(this));
    localScreenShotListenManager.startListen();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.ScreenJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */
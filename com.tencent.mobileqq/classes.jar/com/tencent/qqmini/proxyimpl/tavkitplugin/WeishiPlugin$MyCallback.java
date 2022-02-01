package com.tencent.qqmini.proxyimpl.tavkitplugin;

import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tavcut.TAVCut.Callback;

class WeishiPlugin$MyCallback
  implements TAVCut.Callback
{
  private WeishiPlugin$MyCallback(WeishiPlugin paramWeishiPlugin) {}
  
  public void onDone(int paramInt)
  {
    Logger.d("WS_WeishiPlugin", "onDone() called with: retCode = [" + paramInt + "]");
    if (paramInt == 0)
    {
      WeishiPlugin.a(this.a, true);
      if (WeishiPlugin.a(this.a) != null) {
        this.a.dispatchEvent(WeishiPlugin.a(this.a));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.WeishiPlugin.MyCallback
 * JD-Core Version:    0.7.0.1
 */
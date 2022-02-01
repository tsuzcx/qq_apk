package com.tencent.qqmini.proxyimpl.tavkitplugin;

import com.tencent.qcircle.tavcut.TAVCut.Callback;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.tav.decoder.logger.Logger;

class WeishiPlugin$MyCallback
  implements TAVCut.Callback
{
  private WeishiPlugin$MyCallback(WeishiPlugin paramWeishiPlugin) {}
  
  public void onDone(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onDone() called with: retCode = [");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("]");
    Logger.d("WS_WeishiPlugin", ((StringBuilder)localObject).toString());
    if (paramInt == 0)
    {
      WeishiPlugin.a(this.a, true);
      if (WeishiPlugin.a(this.a) != null)
      {
        localObject = this.a;
        ((WeishiPlugin)localObject).dispatchEvent(WeishiPlugin.a((WeishiPlugin)localObject));
      }
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("tavcut.init fail, retCode = ");
      ((StringBuilder)localObject).append(paramInt);
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDone: msg = ");
      localStringBuilder.append((String)localObject);
      Logger.e("WS_WeishiPlugin", localStringBuilder.toString());
      if (WeishiPlugin.a(this.a) != null) {
        WeishiPlugin.a(this.a).fail((String)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.WeishiPlugin.MyCallback
 * JD-Core Version:    0.7.0.1
 */
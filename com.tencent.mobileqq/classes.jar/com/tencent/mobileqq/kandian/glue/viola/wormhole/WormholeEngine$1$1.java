package com.tencent.mobileqq.kandian.glue.viola.wormhole;

import com.tencent.common.wormhole.WormholeManager;
import com.tencent.hippy.qq.app.HippyQQEngine.HippyQQEngineListener;
import com.tencent.hippy.qq.app.HippyQQPreloadEngine;
import com.tencent.qphone.base.util.QLog;

class WormholeEngine$1$1
  implements HippyQQEngine.HippyQQEngineListener
{
  WormholeEngine$1$1(WormholeEngine.1 param1) {}
  
  public void onError(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WormholeEngine initHippyInContainer error,code:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",msg:");
    localStringBuilder.append(paramString);
    QLog.e("WormholeEngine", 1, localStringBuilder.toString());
  }
  
  public void onSuccess()
  {
    QLog.d("WormholeEngine", 1, "WormholeEngine initHippyInContainer success");
    WormholeManager.a().a(this.a.a.getHippyEngine());
    WormholeManager.a().a(new WormholeEngine.1.1.1(this));
    WormholeEngine.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.wormhole.WormholeEngine.1.1
 * JD-Core Version:    0.7.0.1
 */
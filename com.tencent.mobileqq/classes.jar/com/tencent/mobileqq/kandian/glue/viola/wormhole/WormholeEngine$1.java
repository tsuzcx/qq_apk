package com.tencent.mobileqq.kandian.glue.viola.wormhole;

import android.widget.FrameLayout;
import com.tencent.hippy.qq.app.HippyQQEngine.HippyQQEngineListener;
import com.tencent.hippy.qq.app.HippyQQPreloadEngine;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

final class WormholeEngine$1
  implements HippyQQEngine.HippyQQEngineListener
{
  WormholeEngine$1(HippyQQPreloadEngine paramHippyQQPreloadEngine) {}
  
  public void onError(int paramInt, String paramString)
  {
    WormholeEngine.b().set(false);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WormholeEngine init onError statusCode:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" msg:");
    localStringBuilder.append(paramString);
    QLog.e("WormholeEngine", 1, localStringBuilder.toString());
    this.a.destroyEngineImmediately();
  }
  
  public void onSuccess()
  {
    WormholeEngine.b().set(false);
    QLog.d("WormholeEngine", 1, "WormholeEngine init success");
    FrameLayout localFrameLayout = new FrameLayout(QBaseActivity.sTopActivity);
    this.a.initHippyInContainer(localFrameLayout, new JSONObject(), false, new WormholeEngine.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.wormhole.WormholeEngine.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.kandian.glue.viola.wormhole;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.hippy.qq.app.HippyQQPreloadEngine;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class WormholeEngine
{
  private static boolean a = false;
  private static AtomicBoolean b = new AtomicBoolean(false);
  
  public static void a()
  {
    if (a) {
      return;
    }
    if (b.getAndSet(true)) {
      return;
    }
    if (!c())
    {
      QLog.d("WormholeEngine", 1, "WormholeEngine return by not supportWormhole");
      b.set(false);
      return;
    }
    HippyQQPreloadEngine localHippyQQPreloadEngine = new HippyQQPreloadEngine(null, QBaseActivity.sTopActivity, "TKDADwormhole", "");
    localHippyQQPreloadEngine.setInitData(new JSONObject(), new JSONObject());
    localHippyQQPreloadEngine.preloadHippy(new WormholeEngine.1(localHippyQQPreloadEngine), false, 0);
  }
  
  private static boolean c()
  {
    Object localObject = Aladdin.getConfig(482);
    boolean bool = false;
    if (((AladdinConfig)localObject).getIntegerFromString("wormhole_switch", 0) == 1) {
      bool = true;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("isSupportWormhole :");
    ((StringBuilder)localObject).append(bool);
    QLog.d("WormholeEngine", 1, ((StringBuilder)localObject).toString());
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.wormhole.WormholeEngine
 * JD-Core Version:    0.7.0.1
 */
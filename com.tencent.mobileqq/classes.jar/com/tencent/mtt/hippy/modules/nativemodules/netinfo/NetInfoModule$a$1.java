package com.tencent.mtt.hippy.modules.nativemodules.netinfo;

import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.HippyModuleManager;
import com.tencent.mtt.hippy.modules.javascriptmodules.EventDispatcher;
import com.tencent.mtt.hippy.utils.LogUtils;

class NetInfoModule$a$1
  implements Runnable
{
  NetInfoModule$a$1(NetInfoModule.a parama) {}
  
  public void run()
  {
    Object localObject = NetInfoModule.a(this.a.a);
    if (!((String)localObject).equalsIgnoreCase(NetInfoModule.a.a(this.a))) {
      try
      {
        NetInfoModule.a.a(this.a, (String)localObject);
        localObject = new HippyMap();
        ((HippyMap)localObject).pushString("network_info", NetInfoModule.a.a(this.a));
        ((EventDispatcher)NetInfoModule.b(this.a.a).getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveNativeEvent("networkStatusDidChange", localObject);
        return;
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onReceive: ");
        localStringBuilder.append(localThrowable.getMessage());
        LogUtils.d("ConnectivityReceiver", localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.nativemodules.netinfo.NetInfoModule.a.1
 * JD-Core Version:    0.7.0.1
 */
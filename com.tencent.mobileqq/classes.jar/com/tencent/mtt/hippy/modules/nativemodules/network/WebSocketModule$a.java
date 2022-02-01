package com.tencent.mtt.hippy.modules.nativemodules.network;

import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.b.d.a;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.HippyModuleManager;
import com.tencent.mtt.hippy.modules.javascriptmodules.EventDispatcher;

class WebSocketModule$a
  implements d.a
{
  private int a;
  private HippyEngineContext b;
  private WebSocketModule c;
  private boolean d;
  
  public WebSocketModule$a(int paramInt, HippyEngineContext paramHippyEngineContext, WebSocketModule paramWebSocketModule)
  {
    this.a = paramInt;
    this.b = paramHippyEngineContext;
    this.c = paramWebSocketModule;
    this.d = false;
  }
  
  private void a(String paramString, HippyMap paramHippyMap)
  {
    if (this.d) {
      return;
    }
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushInt("id", this.a);
    localHippyMap.pushString("type", paramString);
    localHippyMap.pushObject("data", paramHippyMap);
    ((EventDispatcher)this.b.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveNativeEvent("hippyWebsocketEvents", localHippyMap);
  }
  
  public void a(int paramInt, String paramString)
  {
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushInt("code", paramInt);
    localHippyMap.pushString("reason", paramString);
    a("onClose", localHippyMap);
    this.c.a(this.a);
    this.d = true;
  }
  
  public void a(Exception paramException)
  {
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushString("reason", paramException.getMessage());
    a("onError", localHippyMap);
  }
  
  public void a(byte[] paramArrayOfByte) {}
  
  public void b()
  {
    a("onOpen", null);
  }
  
  public void b(String paramString)
  {
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushString("data", paramString);
    localHippyMap.pushString("type", "text");
    a("onMessage", localHippyMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.nativemodules.network.WebSocketModule.a
 * JD-Core Version:    0.7.0.1
 */
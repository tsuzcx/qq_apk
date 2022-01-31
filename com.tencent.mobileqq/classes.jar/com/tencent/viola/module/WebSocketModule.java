package com.tencent.viola.module;

import android.os.Looper;
import com.tencent.viola.adapter.VWebSocketAdapter;
import com.tencent.viola.adapter.WebSocketCloseCodes;
import com.tencent.viola.annotation.JSMethod;
import com.tencent.viola.commons.Destroyable;
import com.tencent.viola.core.ViolaEnvironment;
import com.tencent.viola.utils.ViolaLogUtils;
import java.lang.reflect.Constructor;

public class WebSocketModule
  extends BaseModule
  implements Destroyable
{
  private static final String KEY_CODE = "code";
  private static final String KEY_DATA = "data";
  private static final String KEY_REASON = "reason";
  private static final String KEY_WAS_CLEAN = "wasClean";
  public static final String MODULE_NAME = "webSocket";
  private static final String TAG = "WebSocketModule";
  private WebSocketModule.WebSocketEventListener eventListener;
  private VWebSocketAdapter webSocketAdapter;
  
  private VWebSocketAdapter newInstance()
  {
    if (ViolaEnvironment.isDebugable()) {
      try
      {
        Object localObject = Class.forName("rjy");
        if (localObject != null)
        {
          localObject = (VWebSocketAdapter)((Class)localObject).getConstructor(new Class[0]).newInstance(new Object[0]);
          return localObject;
        }
      }
      catch (Exception localException)
      {
        ViolaLogUtils.d("WebSocketModule", "webSocket adapter newInstance error " + localException.getMessage());
      }
    }
    return null;
  }
  
  private boolean reportErrorIfNoAdapter()
  {
    if (this.webSocketAdapter == null)
    {
      if (this.eventListener != null) {
        this.eventListener.onError("No implementation found for IWebSocketAdapter");
      }
      return true;
    }
    return false;
  }
  
  @JSMethod(uiThread=false)
  public void WebSocket(String paramString1, String paramString2)
  {
    if (this.webSocketAdapter != null) {}
    this.webSocketAdapter = newInstance();
    if (!reportErrorIfNoAdapter())
    {
      this.eventListener = new WebSocketModule.WebSocketEventListener(this, null);
      this.webSocketAdapter.connect(paramString1, paramString2, this.eventListener);
    }
  }
  
  @JSMethod(uiThread=false)
  public void close(String paramString1, String paramString2)
  {
    int j;
    int i;
    if (!reportErrorIfNoAdapter())
    {
      j = WebSocketCloseCodes.CLOSE_NORMAL.getCode();
      i = j;
      if (paramString1 == null) {}
    }
    try
    {
      i = Integer.parseInt(paramString1);
      this.webSocketAdapter.close(i, paramString2);
      return;
    }
    catch (NumberFormatException paramString1)
    {
      for (;;)
      {
        i = j;
      }
    }
  }
  
  public void destroy()
  {
    WebSocketModule.1 local1 = new WebSocketModule.1(this);
    if (Looper.myLooper() == Looper.getMainLooper()) {
      return;
    }
    local1.run();
  }
  
  @JSMethod(uiThread=false)
  public void onclose(String paramString)
  {
    if (this.eventListener != null) {
      WebSocketModule.WebSocketEventListener.access$302(this.eventListener, paramString);
    }
  }
  
  @JSMethod(uiThread=false)
  public void onerror(String paramString)
  {
    if (this.eventListener != null) {
      WebSocketModule.WebSocketEventListener.access$402(this.eventListener, paramString);
    }
  }
  
  @JSMethod(uiThread=false)
  public void onmessage(String paramString)
  {
    if (this.eventListener != null) {
      WebSocketModule.WebSocketEventListener.access$202(this.eventListener, paramString);
    }
  }
  
  @JSMethod(uiThread=false)
  public void onopen(String paramString)
  {
    if (this.eventListener != null) {
      WebSocketModule.WebSocketEventListener.access$102(this.eventListener, paramString);
    }
  }
  
  @JSMethod(uiThread=false)
  public void send(String paramString)
  {
    if (!reportErrorIfNoAdapter()) {
      this.webSocketAdapter.send(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.module.WebSocketModule
 * JD-Core Version:    0.7.0.1
 */
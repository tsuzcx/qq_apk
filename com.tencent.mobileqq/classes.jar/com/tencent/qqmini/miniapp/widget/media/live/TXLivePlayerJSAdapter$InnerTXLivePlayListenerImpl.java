package com.tencent.qqmini.miniapp.widget.media.live;

import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TXLivePlayerJSAdapter$InnerTXLivePlayListenerImpl
  implements InvocationHandler
{
  public TXLivePlayerJSAdapter$InnerTXLivePlayListenerImpl(TXLivePlayerJSAdapter paramTXLivePlayerJSAdapter) {}
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    paramObject = new StringBuilder();
    paramObject.append("InnerTXLivePlayListenerImpl invoke:");
    paramObject.append(paramMethod.getName());
    QMLog.e("TXLivePlayerJSAdapter", paramObject.toString());
    if (Object.class.equals(paramMethod.getDeclaringClass())) {
      try
      {
        paramObject = paramMethod.invoke(this, paramArrayOfObject);
        return paramObject;
      }
      catch (Throwable paramObject)
      {
        paramObject.printStackTrace();
      }
    } else if ("onPlayEvent".equals(paramMethod.getName())) {
      TXLivePlayerJSAdapter.access$000(this.this$0, paramArrayOfObject);
    } else if ("onNetStatus".equals(paramMethod.getName())) {
      TXLivePlayerJSAdapter.access$100(this.this$0, paramArrayOfObject);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.media.live.TXLivePlayerJSAdapter.InnerTXLivePlayListenerImpl
 * JD-Core Version:    0.7.0.1
 */
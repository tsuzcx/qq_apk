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
    QMLog.e("TXLivePlayerJSAdapter", "InnerTXLivePlayListenerImpl invoke:" + paramMethod.getName());
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
    }
    for (;;)
    {
      return null;
      if ("onPlayEvent".equals(paramMethod.getName())) {
        TXLivePlayerJSAdapter.access$000(this.this$0, paramArrayOfObject);
      } else if ("onNetStatus".equals(paramMethod.getName())) {
        TXLivePlayerJSAdapter.access$100(this.this$0, paramArrayOfObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.media.live.TXLivePlayerJSAdapter.InnerTXLivePlayListenerImpl
 * JD-Core Version:    0.7.0.1
 */
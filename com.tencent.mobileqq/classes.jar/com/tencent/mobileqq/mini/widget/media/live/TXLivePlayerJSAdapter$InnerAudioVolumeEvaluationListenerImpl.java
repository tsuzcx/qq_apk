package com.tencent.mobileqq.mini.widget.media.live;

import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TXLivePlayerJSAdapter$InnerAudioVolumeEvaluationListenerImpl
  implements InvocationHandler
{
  public TXLivePlayerJSAdapter$InnerAudioVolumeEvaluationListenerImpl(TXLivePlayerJSAdapter paramTXLivePlayerJSAdapter) {}
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    QLog.e("TXLivePlayerJSAdapter", 1, "InnerAudioVolumeEvaluationListenerImpl invoke:" + paramMethod.getName());
    if (Object.class.equals(paramMethod.getDeclaringClass())) {
      try
      {
        paramObject = paramMethod.invoke(this, paramArrayOfObject);
        return paramObject;
      }
      catch (Throwable paramObject)
      {
        paramObject.printStackTrace();
        return null;
      }
    }
    if (("onAudioVolumeEvaluationNotify".equals(paramMethod.getName())) && (paramArrayOfObject.length == 1) && ((paramArrayOfObject[0] instanceof Integer)))
    {
      int i = ((Integer)paramArrayOfObject[0]).intValue();
      if (TXLivePlayerJSAdapter.access$400(this.this$0) != null) {
        TXLivePlayerJSAdapter.access$400(this.this$0).onAudioVolumeEvaluationNotify(i);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.live.TXLivePlayerJSAdapter.InnerAudioVolumeEvaluationListenerImpl
 * JD-Core Version:    0.7.0.1
 */
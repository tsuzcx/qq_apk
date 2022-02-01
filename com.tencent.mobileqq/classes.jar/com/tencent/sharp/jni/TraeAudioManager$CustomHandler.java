package com.tencent.sharp.jni;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashMap<Ljava.lang.String;Ljava.lang.Object;>;

public class TraeAudioManager$CustomHandler
  extends Handler
{
  public TraeAudioManager$CustomHandler(TraeAudioManager paramTraeAudioManager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private void b(int paramInt, HashMap<String, Object> paramHashMap)
  {
    Object localObject1;
    Object localObject2;
    if (paramInt != 32774)
    {
      switch (paramInt)
      {
      default: 
        return;
      case 32871: 
        localObject1 = this.a.a.h();
        paramHashMap = (String)paramHashMap.get("PARAM_DEVICE_NAME");
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("handleMessage MSG_AUTO_DEVICE_PLUG_OUT, connectedDevice[");
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("], plugOutDevice[");
          ((StringBuilder)localObject2).append(paramHashMap);
          ((StringBuilder)localObject2).append("]");
          QLog.i("TraeAudioManager", 2, ((StringBuilder)localObject2).toString());
        }
        if ((!((String)localObject1).equals(paramHashMap)) && (!((String)localObject1).equals("DEVICE_NONE")))
        {
          TraeAudioManager.a(this.a);
          return;
        }
        paramHashMap = this.a;
        if (TraeAudioManager.a(paramHashMap, paramHashMap.k, null) == 0) {
          break;
        }
        paramHashMap = this.a;
        TraeAudioManager.a(paramHashMap, paramHashMap.a.e(null), null);
        return;
      case 32870: 
        paramHashMap = (String)paramHashMap.get("PARAM_DEVICE_NAME");
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("handleMessage MSG_AUTO_DEVICE_PLUG_IN, plugInDevice[");
          ((StringBuilder)localObject1).append(paramHashMap);
          ((StringBuilder)localObject1).append("]");
          QLog.i("TraeAudioManager", 2, ((StringBuilder)localObject1).toString());
        }
        if (TraeAudioManager.a(this.a, paramHashMap, null) == 0) {
          break;
        }
        paramHashMap = this.a;
        TraeAudioManager.a(paramHashMap, paramHashMap.a.e(null), null);
        return;
      }
    }
    else
    {
      localObject2 = this.a.a.e(null);
      String str = this.a.a.h();
      localObject1 = (String)paramHashMap.get("PARAM_CONNECT_DEVICE_WHEN_START_SERVICE");
      paramHashMap = (HashMap<String, Object>)localObject2;
      if (localObject1 != null)
      {
        paramHashMap = (HashMap<String, Object>)localObject2;
        if (this.a.a.d((String)localObject1)) {
          paramHashMap = (HashMap<String, Object>)localObject1;
        }
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("handleMessage, msg[");
        ((StringBuilder)localObject2).append(paramInt);
        ((StringBuilder)localObject2).append("], tryConnectDevice[");
        ((StringBuilder)localObject2).append(paramHashMap);
        ((StringBuilder)localObject2).append("], connectedDevice[");
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append("], connectDeviceWhenStartService[");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("]");
        QLog.i("TraeAudioManager", 2, ((StringBuilder)localObject2).toString());
      }
      if (!paramHashMap.equals(str))
      {
        TraeAudioManager.a(this.a, paramHashMap, null);
        return;
      }
      TraeAudioManager.a(this.a);
    }
  }
  
  public int a(int paramInt, HashMap<String, Object> paramHashMap)
  {
    if (sendMessage(Message.obtain(this, paramInt, paramHashMap))) {
      return 0;
    }
    return -1;
  }
  
  public void handleMessage(Message paramMessage)
  {
    try
    {
      HashMap localHashMap = (HashMap)paramMessage.obj;
      if (paramMessage.what == 32769)
      {
        TraeAudioManager.a(this.a, localHashMap);
        return;
      }
      if (!TraeAudioManager.d(this.a))
      {
        if (QLog.isColorLevel()) {
          QLog.e("TraeAudioManager", 2, "handleMessage, service off");
        }
        TraeAudioManager.a(this.a, localHashMap, 1);
        return;
      }
      switch (paramMessage.what)
      {
      case 32774: 
      default: 
        b(paramMessage.what, localHashMap);
        return;
      case 32780: 
        TraeAudioManager.g(this.a);
        return;
      case 32779: 
        TraeAudioManager.g(this.a, localHashMap);
        return;
      case 32778: 
        paramMessage = (Integer)localHashMap.get("PARAM_STREAM_TYPE");
        if (paramMessage == null) {
          return;
        }
        this.a.i = paramMessage.intValue();
        TraeAudioManager.a(this.a, paramMessage.intValue());
        return;
      case 32777: 
        TraeAudioManager.f(this.a);
        return;
      case 32776: 
        TraeAudioManager.f(this.a, localHashMap);
        return;
      case 32775: 
        TraeAudioManager.e(this.a, localHashMap);
        return;
      case 32773: 
        TraeAudioManager.d(this.a, localHashMap);
        return;
      case 32772: 
        TraeAudioManager.c(this.a, localHashMap);
        return;
      case 32771: 
        TraeAudioManager.b(this.a, localHashMap);
        return;
      }
      TraeAudioManager.e(this.a);
      return;
    }
    catch (Exception paramMessage)
    {
      label250:
      break label250;
    }
    QLog.e("TraeAudioManager", 1, "handleMessage, illegal param");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.sharp.jni.TraeAudioManager.CustomHandler
 * JD-Core Version:    0.7.0.1
 */
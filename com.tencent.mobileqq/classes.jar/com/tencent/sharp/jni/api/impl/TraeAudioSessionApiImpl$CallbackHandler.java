package com.tencent.sharp.jni.api.impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.av.utils.SeqUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.callback.ITraeAudioCallback;
import java.util.HashMap;

public class TraeAudioSessionApiImpl$CallbackHandler
  extends Handler
{
  public TraeAudioSessionApiImpl$CallbackHandler(TraeAudioSessionApiImpl paramTraeAudioSessionApiImpl, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private int a(HashMap<String, Object> paramHashMap, String paramString, int paramInt)
  {
    paramHashMap = paramHashMap.get(paramString);
    int i = paramInt;
    if (paramHashMap != null)
    {
      i = paramInt;
      if ((paramHashMap instanceof Integer)) {
        i = ((Integer)paramHashMap).intValue();
      }
    }
    return i;
  }
  
  private long a(HashMap<String, Object> paramHashMap, String paramString, long paramLong)
  {
    paramHashMap = paramHashMap.get(paramString);
    long l = paramLong;
    if (paramHashMap != null)
    {
      l = paramLong;
      if ((paramHashMap instanceof Long)) {
        l = ((Long)paramHashMap).longValue();
      }
    }
    return l;
  }
  
  private void a(HashMap<String, Object> paramHashMap)
  {
    boolean bool = false;
    int i = 0;
    int j = a(paramHashMap, "EXTRA_RES_ERROR_CODE", 0);
    long l = a(paramHashMap, "KEY_SESSION_ID", -9223372036854775808L);
    Object localObject = (String)paramHashMap.get("KEY_OPERATION");
    if (l != TraeAudioSessionApiImpl.access$100(this.a))
    {
      if (QLog.isColorLevel())
      {
        paramHashMap = new StringBuilder();
        paramHashMap.append("sessionId different, mSessionId[");
        paramHashMap.append(TraeAudioSessionApiImpl.access$100(this.a));
        paramHashMap.append("], sessionId[");
        paramHashMap.append(l);
        paramHashMap.append("]");
        QLog.d("TraeAudioSessionApiImpl", 2, paramHashMap.toString());
      }
      return;
    }
    if ("OPERATION_GET_DEVICE_LIST".equals(localObject))
    {
      localObject = (String[])paramHashMap.get("EXTRA_DATA_VISIBLE_DEVICE_LIST");
      String str1 = (String)paramHashMap.get("EXTRA_DATA_CONNECTED_DEVICE");
      String str2 = (String)paramHashMap.get("EXTRA_DATA_PREV_CONNECTED_DEVICE");
      paramHashMap = (String)paramHashMap.get("EXTRA_DATA_BLUETOOTH_NAME");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("OPERATION_GET_DEVICE_LIST, errCode[");
        localStringBuilder1.append(j);
        localStringBuilder1.append("], connectedDevice[");
        localStringBuilder1.append(str1);
        localStringBuilder1.append("], preConnectedDevice[");
        localStringBuilder1.append(str2);
        localStringBuilder1.append("], bluetoothName[");
        localStringBuilder1.append(paramHashMap);
        localStringBuilder1.append("]");
        QLog.w("TraeAudioSessionApiImpl", 2, localStringBuilder1.toString());
        if (localObject != null)
        {
          int k = localObject.length;
          while (i < k)
          {
            localStringBuilder1 = localObject[i];
            StringBuilder localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("device[");
            localStringBuilder2.append(localStringBuilder1);
            localStringBuilder2.append("]");
            QLog.w("TraeAudioSessionApiImpl", 2, localStringBuilder2.toString());
            i += 1;
          }
        }
      }
      if (TraeAudioSessionApiImpl.access$000(this.a) != null) {
        TraeAudioSessionApiImpl.access$000(this.a).a(j, (String[])localObject, str1, str2, paramHashMap);
      }
    }
    else if ("OPERATION_CONNECT_DEVICE".equals(localObject))
    {
      paramHashMap = (String)paramHashMap.get("EXTRA_CONNECT_DEVICE_NAME");
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("OPERATION_CONNECT_DEVICE, errCode[");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append("] deviceName[");
        ((StringBuilder)localObject).append(paramHashMap);
        ((StringBuilder)localObject).append("]");
        QLog.w("TraeAudioSessionApiImpl", 2, ((StringBuilder)localObject).toString());
      }
      if (TraeAudioSessionApiImpl.access$000(this.a) != null)
      {
        localObject = TraeAudioSessionApiImpl.access$000(this.a);
        if (j == 0) {
          bool = true;
        }
        ((ITraeAudioCallback)localObject).a(j, paramHashMap, bool);
      }
    }
    else if ("OPERATION_GET_CONNECTED_DEVICE".equals(localObject))
    {
      paramHashMap = (String)paramHashMap.get("EXTRA_DATA_CONNECTED_DEVICE_NAME");
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("OPERATION_GET_CONNECTED_DEVICE, errCode[");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append("], deviceName[");
        ((StringBuilder)localObject).append(paramHashMap);
        ((StringBuilder)localObject).append("]");
        QLog.w("TraeAudioSessionApiImpl", 2, ((StringBuilder)localObject).toString());
      }
      if (TraeAudioSessionApiImpl.access$000(this.a) != null) {
        TraeAudioSessionApiImpl.access$000(this.a).a(j, paramHashMap);
      }
    }
    else if ("OPERATION_GET_STREAM_TYPE".equals(localObject))
    {
      i = a(paramHashMap, "EXTRA_DATA_STREAM_TYPE", -1);
      if (QLog.isColorLevel())
      {
        paramHashMap = new StringBuilder();
        paramHashMap.append("OPERATION_GET_STREAM_TYPE, errCode[");
        paramHashMap.append(j);
        paramHashMap.append("], streamType[");
        paramHashMap.append(i);
        paramHashMap.append("]");
        QLog.w("TraeAudioSessionApiImpl", 2, paramHashMap.toString());
      }
      if (TraeAudioSessionApiImpl.access$000(this.a) != null) {
        TraeAudioSessionApiImpl.access$000(this.a).a(j, i);
      }
    }
    else if ("OPERATION_VOICE_CALL_PRE_PROCESS".equals(localObject))
    {
      if (QLog.isColorLevel())
      {
        paramHashMap = new StringBuilder();
        paramHashMap.append("OPERATION_VOICE_CALL_PRE_PROCESS, errCode[");
        paramHashMap.append(j);
        paramHashMap.append("]");
        QLog.w("TraeAudioSessionApiImpl", 2, paramHashMap.toString());
      }
      if (TraeAudioSessionApiImpl.access$000(this.a) != null) {
        TraeAudioSessionApiImpl.access$000(this.a).a(j);
      }
    }
    else
    {
      paramHashMap = new StringBuilder();
      paramHashMap.append("unknown operation[");
      paramHashMap.append((String)localObject);
      paramHashMap.append("]");
      QLog.e("TraeAudioSessionApiImpl", 1, paramHashMap.toString());
    }
  }
  
  private boolean a(HashMap<String, Object> paramHashMap, String paramString, boolean paramBoolean)
  {
    paramHashMap = paramHashMap.get(paramString);
    boolean bool = paramBoolean;
    if (paramHashMap != null)
    {
      bool = paramBoolean;
      if ((paramHashMap instanceof Boolean)) {
        bool = ((Boolean)paramHashMap).booleanValue();
      }
    }
    return bool;
  }
  
  public void a(int paramInt, HashMap<String, Object> paramHashMap)
  {
    sendMessage(Message.obtain(this, paramInt, paramHashMap));
  }
  
  public void handleMessage(Message paramMessage)
  {
    try
    {
      Object localObject2 = (HashMap)paramMessage.obj;
      if (localObject2 == null)
      {
        QLog.e("TraeAudioSessionApiImpl", 1, "handleMessage, empty params");
        return;
      }
      long l = SeqUtil.a((HashMap)localObject2);
      int j = paramMessage.what;
      int i = 0;
      Object localObject1;
      boolean bool;
      switch (j)
      {
      default: 
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("unknown message type[");
        ((StringBuilder)localObject1).append(paramMessage.what);
        ((StringBuilder)localObject1).append("]");
        QLog.w("TraeAudioSessionApiImpl", 1, ((StringBuilder)localObject1).toString());
        return;
      case 6: 
        a((HashMap)localObject2);
        return;
      case 5: 
        i = a((HashMap)localObject2, "EXTRA_DATA_STREAM_TYPE", -1);
        if (QLog.isColorLevel())
        {
          paramMessage = new StringBuilder();
          paramMessage.append("handleMessage.onStreamTypeUpdate, streamType[");
          paramMessage.append(i);
          paramMessage.append("], seq[");
          paramMessage.append(l);
          paramMessage.append("]");
          QLog.w("TraeAudioSessionApiImpl", 2, paramMessage.toString());
        }
        if (TraeAudioSessionApiImpl.access$000(this.a) != null)
        {
          TraeAudioSessionApiImpl.access$000(this.a).a(l, i);
          return;
        }
        break;
      case 4: 
        paramMessage = (String[])((HashMap)localObject2).get("EXTRA_DATA_VISIBLE_DEVICE_LIST");
        localObject1 = (String)((HashMap)localObject2).get("EXTRA_DATA_CONNECTED_DEVICE");
        String str = (String)((HashMap)localObject2).get("EXTRA_DATA_PREV_CONNECTED_DEVICE");
        localObject2 = (String)((HashMap)localObject2).get("EXTRA_DATA_BLUETOOTH_NAME");
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("handleMessage.onDeviceListUpdate, connectedDevice[");
          localStringBuilder1.append((String)localObject1);
          localStringBuilder1.append("], preConnectedDevice[");
          localStringBuilder1.append(str);
          localStringBuilder1.append("], bluetoothName");
          localStringBuilder1.append((String)localObject2);
          localStringBuilder1.append("]");
          QLog.w("TraeAudioSessionApiImpl", 2, localStringBuilder1.toString());
          if (paramMessage != null)
          {
            j = paramMessage.length;
            while (i < j)
            {
              localStringBuilder1 = paramMessage[i];
              StringBuilder localStringBuilder2 = new StringBuilder();
              localStringBuilder2.append("device[");
              localStringBuilder2.append(localStringBuilder1);
              localStringBuilder2.append("]");
              QLog.w("TraeAudioSessionApiImpl", 2, localStringBuilder2.toString());
              i += 1;
            }
          }
        }
        if (TraeAudioSessionApiImpl.access$000(this.a) != null)
        {
          TraeAudioSessionApiImpl.access$000(this.a).a(l, paramMessage, (String)localObject1, str, (String)localObject2);
          return;
        }
        break;
      case 3: 
        paramMessage = (String)((HashMap)localObject2).get("EXTRA_CONNECT_DEVICE_NAME");
        bool = a((HashMap)localObject2, "EXTRA_DATA_CHANGEABLE_STATE", true);
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("handleMessage.(onBeginConnectDevice & onDeviceChangeableUpdate), deviceName[");
          ((StringBuilder)localObject1).append(paramMessage);
          ((StringBuilder)localObject1).append("], isChangeable[ ");
          ((StringBuilder)localObject1).append(bool);
          ((StringBuilder)localObject1).append("], seq[");
          ((StringBuilder)localObject1).append(l);
          ((StringBuilder)localObject1).append("]");
          QLog.w("TraeAudioSessionApiImpl", 2, ((StringBuilder)localObject1).toString());
        }
        if (TraeAudioSessionApiImpl.access$000(this.a) != null)
        {
          TraeAudioSessionApiImpl.access$000(this.a).a(paramMessage);
          TraeAudioSessionApiImpl.access$000(this.a).a(bool);
          return;
        }
        break;
      case 2: 
        bool = a((HashMap)localObject2, "EXTRA_DATA_SERVICE_STATE", false);
        if (QLog.isColorLevel())
        {
          paramMessage = new StringBuilder();
          paramMessage.append("handleMessage.onServiceStateUpdate, isServiceOn[");
          paramMessage.append(bool);
          paramMessage.append("], seq[");
          paramMessage.append(l);
          paramMessage.append("]");
          QLog.w("TraeAudioSessionApiImpl", 2, paramMessage.toString());
        }
        if (TraeAudioSessionApiImpl.access$000(this.a) != null)
        {
          TraeAudioSessionApiImpl.access$000(this.a).a(l, bool);
          return;
        }
        break;
      case 1: 
        if (QLog.isColorLevel())
        {
          paramMessage = new StringBuilder();
          paramMessage.append("handleMessage.onRingCompletion, seq[");
          paramMessage.append(l);
          paramMessage.append("]");
          QLog.w("TraeAudioSessionApiImpl", 2, paramMessage.toString());
        }
        if (TraeAudioSessionApiImpl.access$000(this.a) != null) {
          TraeAudioSessionApiImpl.access$000(this.a).a(l);
        }
        break;
      }
      return;
    }
    catch (Exception paramMessage)
    {
      label766:
      break label766;
    }
    QLog.e("TraeAudioSessionApiImpl", 1, "handleMessage, illegal param");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.sharp.jni.api.impl.TraeAudioSessionApiImpl.CallbackHandler
 * JD-Core Version:    0.7.0.1
 */
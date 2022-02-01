package com.tencent.mobileqq.msf.sdk;

import android.net.NetworkInfo;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.telephony.TelephonyManager;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class a$a
  extends HandlerThread
  implements Handler.Callback
{
  public a$a(String paramString)
  {
    super(paramString);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    int j;
    Object localObject1;
    label437:
    label450:
    label498:
    boolean bool;
    switch (i)
    {
    default: 
    case 1: 
    case 2: 
    case 3: 
      label551:
      do
      {
        do
        {
          do
          {
            for (;;)
            {
              return false;
              try
              {
                paramMessage = (INetInfoHandler)paramMessage.obj;
                if (paramMessage != null) {
                  if (!a.a.contains(paramMessage))
                  {
                    a.a.add(paramMessage);
                    QLog.d(a.i(), 1, "register netInfo " + paramMessage + ", total=" + a.a.size());
                    return false;
                  }
                }
              }
              catch (Exception paramMessage)
              {
                QLog.d(a.i(), 1, "failed to handle msg " + i);
                return false;
              }
            }
            QLog.w(a.i(), 1, "register netInfo " + paramMessage + " duplication, total=" + a.a.size());
            return false;
            paramMessage = (INetEventHandler)paramMessage.obj;
          } while (paramMessage == null);
          if (!a.b.contains(paramMessage))
          {
            a.b.add(paramMessage);
            QLog.d(a.i(), 1, "register netEvent " + paramMessage + ", total=" + a.b.size());
            return false;
          }
          QLog.w(a.i(), 1, "register netEvent " + paramMessage + " duplication, total=" + a.b.size());
          return false;
          j = a.j();
          if (j != -1) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d(a.i(), 2, "no change in connectivity");
        return false;
        if (a.f())
        {
          a.k();
          paramMessage = a.a.iterator();
        }
        for (;;)
        {
          if (!paramMessage.hasNext()) {
            break label498;
          }
          localObject1 = (INetInfoHandler)paramMessage.next();
          if (localObject1 != null)
          {
            if ((j == 0) || (j == 6))
            {
              ((INetInfoHandler)localObject1).onNetNone2Mobile(a.j);
              continue;
              if (!a.e()) {
                break;
              }
              a.l();
              break;
            }
            if (j != 1) {
              break label1273;
            }
            ((INetInfoHandler)localObject1).onNetWifi2Mobile(a.j);
            continue;
            ((INetInfoHandler)localObject1).onNetNone2Wifi(a.l);
            continue;
            if (j == 3) {
              ((INetInfoHandler)localObject1).onNetMobile2Wifi(a.l);
            } else if (j == 4) {
              ((INetInfoHandler)localObject1).onNetMobile2None();
            } else if (j == 5) {
              ((INetInfoHandler)localObject1).onNetWifi2None();
            }
          }
        }
        paramMessage = a.b.iterator();
        while (paramMessage.hasNext())
        {
          localObject1 = (INetEventHandler)paramMessage.next();
          if (localObject1 != null)
          {
            if ((j == 4) || (j == 5)) {
              break label1287;
            }
            if (j != 11) {
              break label1267;
            }
            break label1287;
            ((INetEventHandler)localObject1).onNetChangeEvent(bool);
          }
        }
      } while (!a.f());
      if ((a.f != null) && (a.f.isAvailable()))
      {
        j = a.f.getType();
        switch (j)
        {
        case 1: 
        case 6: 
        case 7: 
        case 8: 
        case 9: 
        case 13: 
          a.i = -1;
          QLog.d(a.i(), 1, "Unexcepted Mobile Type:" + j);
          return false;
        case 0: 
        case 2: 
        case 3: 
        case 4: 
        case 5: 
        case 10: 
        case 11: 
        case 12: 
        case 14: 
        case 15: 
          label672:
          paramMessage = (TelephonyManager)BaseApplication.getContext().getSystemService("phone");
          j = g.b(paramMessage);
          switch (j)
          {
          }
          break;
        }
      }
      break;
    }
    for (;;)
    {
      a.i = g.a(paramMessage, j);
      QLog.d(a.i(), 1, "Unexcepted networkType:" + j + " ,mobileInfo:" + a.i);
      return false;
      a.i = 4;
      return false;
      a.i = 3;
      return false;
      a.i = 2;
      return false;
      a.i = 1;
      return false;
      a.i = 0;
      return false;
      paramMessage = (INetInfoHandler)paramMessage.obj;
      Object localObject2;
      if (paramMessage != null)
      {
        localObject1 = a.a.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (INetInfoHandler)((Iterator)localObject1).next();
          if (localObject2 == paramMessage)
          {
            QLog.i(a.i(), 1, "unRegister netInfo " + localObject2);
            ((Iterator)localObject1).remove();
          }
        }
      }
      QLog.d(a.i(), 1, "unRegister netInfo remain=" + a.a.size());
      if (!a.m()) {
        break;
      }
      paramMessage = a.a.iterator();
      while (paramMessage.hasNext())
      {
        localObject1 = (INetInfoHandler)paramMessage.next();
        QLog.i(a.i(), 1, "netInfo " + localObject1);
      }
      paramMessage = (INetEventHandler)paramMessage.obj;
      if (paramMessage != null)
      {
        localObject1 = a.b.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (INetEventHandler)((Iterator)localObject1).next();
          if (localObject2 == paramMessage)
          {
            QLog.i(a.i(), 1, "unRegister netEvent " + localObject2);
            ((Iterator)localObject1).remove();
          }
        }
      }
      QLog.d(a.i(), 1, "unRegister netEvent remain=" + a.b.size());
      if (!a.m()) {
        break;
      }
      paramMessage = a.b.iterator();
      while (paramMessage.hasNext())
      {
        localObject1 = (INetEventHandler)paramMessage.next();
        QLog.i(a.i(), 1, "netEvent " + localObject1);
      }
      label1267:
      bool = true;
      break label551;
      label1273:
      if (j == 2) {
        break label437;
      }
      if (j != 7) {
        break label450;
      }
      break label437;
      label1287:
      bool = false;
      break label551;
      break label672;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.a.a
 * JD-Core Version:    0.7.0.1
 */
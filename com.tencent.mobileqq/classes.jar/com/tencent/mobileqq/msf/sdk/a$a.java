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
    if (i != 1) {
      if (i != 2) {
        if (i != 3) {
          if (i != 4) {
            if (i != 5) {
              return false;
            }
          }
        }
      }
    }
    for (;;)
    {
      int j;
      boolean bool;
      try
      {
        paramMessage = (INetEventHandler)paramMessage.obj;
        StringBuilder localStringBuilder;
        if (paramMessage != null)
        {
          localObject1 = a.b.iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (INetEventHandler)((Iterator)localObject1).next();
            if (localObject2 != paramMessage) {
              continue;
            }
            localObject3 = a.i();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("unRegister netEvent ");
            localStringBuilder.append(localObject2);
            QLog.i((String)localObject3, 1, localStringBuilder.toString());
            ((Iterator)localObject1).remove();
            continue;
          }
        }
        paramMessage = a.i();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("unRegister netEvent remain=");
        ((StringBuilder)localObject1).append(a.b.size());
        QLog.d(paramMessage, 1, ((StringBuilder)localObject1).toString());
        if (!a.m()) {
          continue;
        }
        paramMessage = a.b.iterator();
        if (!paramMessage.hasNext()) {
          continue;
        }
        localObject1 = (INetEventHandler)paramMessage.next();
        localObject2 = a.i();
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("netEvent ");
        ((StringBuilder)localObject3).append(localObject1);
        QLog.i((String)localObject2, 1, ((StringBuilder)localObject3).toString());
        continue;
        paramMessage = (INetInfoHandler)paramMessage.obj;
        if (paramMessage != null)
        {
          localObject1 = a.a.iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (INetInfoHandler)((Iterator)localObject1).next();
            if (localObject2 != paramMessage) {
              continue;
            }
            localObject3 = a.i();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("unRegister netInfo ");
            localStringBuilder.append(localObject2);
            QLog.i((String)localObject3, 1, localStringBuilder.toString());
            ((Iterator)localObject1).remove();
            continue;
          }
        }
        paramMessage = a.i();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("unRegister netInfo remain=");
        ((StringBuilder)localObject1).append(a.a.size());
        QLog.d(paramMessage, 1, ((StringBuilder)localObject1).toString());
        if (!a.m()) {
          continue;
        }
        paramMessage = a.a.iterator();
        if (!paramMessage.hasNext()) {
          continue;
        }
        localObject1 = (INetInfoHandler)paramMessage.next();
        localObject2 = a.i();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("netInfo ");
        ((StringBuilder)localObject3).append(localObject1);
        QLog.i((String)localObject2, 1, ((StringBuilder)localObject3).toString());
        continue;
        j = a.j();
        if (j == -1)
        {
          if (!QLog.isColorLevel()) {
            break label1462;
          }
          QLog.d(a.i(), 2, "no change in connectivity");
          return false;
        }
        if (a.f()) {
          a.k();
        } else if (a.e()) {
          a.l();
        }
        paramMessage = a.a.iterator();
        if (paramMessage.hasNext())
        {
          localObject1 = (INetInfoHandler)paramMessage.next();
          if (localObject1 == null) {
            continue;
          }
          if ((j != 0) && (j != 6))
          {
            if (j != 1) {
              break label1464;
            }
            ((INetInfoHandler)localObject1).onNetWifi2Mobile(a.j);
            continue;
            if (j == 3)
            {
              ((INetInfoHandler)localObject1).onNetMobile2Wifi(a.l);
              continue;
            }
            if (j == 4)
            {
              ((INetInfoHandler)localObject1).onNetMobile2None();
              continue;
            }
            if (j != 5) {
              continue;
            }
            ((INetInfoHandler)localObject1).onNetWifi2None();
            continue;
            ((INetInfoHandler)localObject1).onNetNone2Wifi(a.l);
            continue;
          }
          ((INetInfoHandler)localObject1).onNetNone2Mobile(a.j);
          continue;
        }
        paramMessage = a.b.iterator();
        if (paramMessage.hasNext())
        {
          localObject1 = (INetEventHandler)paramMessage.next();
          if (localObject1 == null) {
            continue;
          }
          if ((j == 4) || (j == 5)) {
            break label1484;
          }
          if (j != 11) {
            break label1478;
          }
          break label1484;
          ((INetEventHandler)localObject1).onNetChangeEvent(bool);
          continue;
        }
        if (!a.f()) {
          continue;
        }
        if ((a.f != null) && (a.f.isAvailable()))
        {
          j = a.f.getType();
          if ((j == 0) || (j == 2) || (j == 3) || (j == 4) || (j == 5) || (j == 14) || (j == 15)) {}
        }
        switch (j)
        {
        case 10: 
          a.i = -1;
          paramMessage = a.i();
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("Unexcepted Mobile Type:");
          ((StringBuilder)localObject1).append(j);
          QLog.d(paramMessage, 1, ((StringBuilder)localObject1).toString());
          return false;
        case 11: 
        case 12: 
          paramMessage = (TelephonyManager)BaseApplication.getContext().getSystemService("phone");
          j = g.b(paramMessage);
          int k;
          switch (j)
          {
          case 20: 
            k = g.a(paramMessage, j);
            continue;
            a.i = 4;
            return false;
          case 13: 
          case 18: 
          case 19: 
            a.i = 3;
            return false;
          case 3: 
          case 5: 
          case 6: 
          case 8: 
          case 9: 
          case 10: 
          case 12: 
          case 14: 
          case 15: 
          case 17: 
            a.i = 2;
            return false;
          case 0: 
          case 1: 
          case 2: 
          case 4: 
          case 7: 
          case 11: 
          case 16: 
            a.i = 1;
            return false;
            a.i = k;
            paramMessage = a.i();
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("Unexcepted networkType:");
            ((StringBuilder)localObject1).append(j);
            ((StringBuilder)localObject1).append(" ,mobileInfo:");
            ((StringBuilder)localObject1).append(a.i);
            QLog.d(paramMessage, 1, ((StringBuilder)localObject1).toString());
            return false;
            a.i = 0;
            return false;
          }
        }
      }
      catch (Exception paramMessage)
      {
        Object localObject1;
        Object localObject2;
        continue;
      }
      paramMessage = (INetEventHandler)paramMessage.obj;
      if (paramMessage != null)
      {
        bool = a.b.contains(paramMessage);
        if (!bool)
        {
          a.b.add(paramMessage);
          localObject1 = a.i();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("register netEvent ");
          ((StringBuilder)localObject2).append(paramMessage);
          ((StringBuilder)localObject2).append(", total=");
          ((StringBuilder)localObject2).append(a.b.size());
          QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
          return false;
        }
        localObject1 = a.i();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("register netEvent ");
        ((StringBuilder)localObject2).append(paramMessage);
        ((StringBuilder)localObject2).append(" duplication, total=");
        ((StringBuilder)localObject2).append(a.b.size());
        QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
        return false;
        paramMessage = (INetInfoHandler)paramMessage.obj;
        if (paramMessage != null)
        {
          bool = a.a.contains(paramMessage);
          if (!bool)
          {
            a.a.add(paramMessage);
            localObject1 = a.i();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("register netInfo ");
            ((StringBuilder)localObject2).append(paramMessage);
            ((StringBuilder)localObject2).append(", total=");
            ((StringBuilder)localObject2).append(a.a.size());
            QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
            return false;
          }
          localObject1 = a.i();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("register netInfo ");
          ((StringBuilder)localObject2).append(paramMessage);
          ((StringBuilder)localObject2).append(" duplication, total=");
          ((StringBuilder)localObject2).append(a.a.size());
          QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
          return false;
          paramMessage = a.i();
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("failed to handle msg ");
          ((StringBuilder)localObject1).append(i);
          QLog.d(paramMessage, 1, ((StringBuilder)localObject1).toString());
        }
      }
      return false;
      label1462:
      return false;
      label1464:
      if (j != 2) {
        if (j == 7)
        {
          continue;
          label1478:
          bool = true;
          continue;
          label1484:
          bool = false;
          continue;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.a.a
 * JD-Core Version:    0.7.0.1
 */
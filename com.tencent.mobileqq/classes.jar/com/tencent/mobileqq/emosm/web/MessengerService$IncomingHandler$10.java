package com.tencent.mobileqq.emosm.web;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class MessengerService$IncomingHandler$10
  implements Runnable
{
  MessengerService$IncomingHandler$10(MessengerService.IncomingHandler paramIncomingHandler, QQAppInterface paramQQAppInterface, int paramInt, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  public void run()
  {
    ILebaHelperService localILebaHelperService = (ILebaHelperService)this.a.getRuntimeService(ILebaHelperService.class, "");
    int j = 1;
    Object localObject2;
    if (localILebaHelperService != null)
    {
      localObject2 = localILebaHelperService.getLebaMgrList();
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (!((List)localObject2).isEmpty()) {}
      }
      else
      {
        localILebaHelperService.reloadLebaItems(this.a);
        localObject1 = localILebaHelperService.getLebaMgrList();
      }
    }
    else
    {
      QLog.d("IPC_LEBA_ITEM_GET", 1, "lebaHelperService == null");
      localObject1 = null;
    }
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (LebaViewItem)((Iterator)localObject1).next();
        if ((localObject2 != null) && (((LebaViewItem)localObject2).b != null) && (((LebaViewItem)localObject2).b.uiResId == this.b))
        {
          i = ((LebaViewItem)localObject2).f;
          break label155;
        }
      }
    }
    int i = -1;
    label155:
    Object localObject1 = new Bundle();
    if (i == -1) {
      ((Bundle)localObject1).putInt("ret", 1);
    } else {
      ((Bundle)localObject1).putInt("ret", 0);
    }
    if (i == 0) {
      i = j;
    } else {
      i = 0;
    }
    ((Bundle)localObject1).putInt("type", i);
    this.c.putBundle("response", (Bundle)localObject1);
    this.d.a(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler.10
 * JD-Core Version:    0.7.0.1
 */
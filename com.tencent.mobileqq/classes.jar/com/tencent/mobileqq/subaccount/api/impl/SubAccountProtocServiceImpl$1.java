package com.tencent.mobileqq.subaccount.api.impl;

import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.subaccount.SubAccountControllUtil;
import com.tencent.mobileqq.subaccount.api.ISubAccountConfigApi;
import com.tencent.mobileqq.subaccount.api.ISubAccountServlet;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

class SubAccountProtocServiceImpl$1
  extends SubAccountBindObserver
{
  SubAccountProtocServiceImpl$1(SubAccountProtocServiceImpl paramSubAccountProtocServiceImpl) {}
  
  protected void a(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("SubAccountProtocManager.onGetBindSubAccount() isSucc=");
      ((StringBuilder)localObject2).append(paramBoolean);
      ((StringBuilder)localObject2).append(" data.mSubUin=");
      if (paramSubAccountBackProtocData == null) {
        ??? = "data is null";
      } else {
        ??? = paramSubAccountBackProtocData.c;
      }
      ((StringBuilder)localObject2).append((String)???);
      QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject2).toString());
    }
    if ((!SubAccountProtocServiceImpl.access$400(this.a)) && (ThreadManager.getSubThreadHandler() != null)) {
      ThreadManager.getSubThreadHandler().postDelayed(SubAccountProtocServiceImpl.access$500(this.a), 100L);
    }
    if (paramSubAccountBackProtocData != null)
    {
      if (paramSubAccountBackProtocData.a()) {
        SubAccountControllUtil.a(SubAccountProtocServiceImpl.access$600(this.a), paramSubAccountBackProtocData.a(), 2);
      }
      if (paramSubAccountBackProtocData.b())
      {
        ??? = paramSubAccountBackProtocData.b();
        if (??? != null)
        {
          ??? = ((ArrayList)???).iterator();
          while (((Iterator)???).hasNext())
          {
            localObject2 = (String)((Iterator)???).next();
            SubAccountControllUtil.c(SubAccountProtocServiceImpl.access$600(this.a), (String)localObject2);
          }
        }
      }
      paramSubAccountBackProtocData.a();
    }
    synchronized (SubAccountProtocServiceImpl.access$700())
    {
      SubAccountProtocServiceImpl.access$802(this.a, false);
      SubAccountProtocServiceImpl.access$402(this.a, true);
      if ((paramSubAccountBackProtocData != null) && (paramSubAccountBackProtocData.b))
      {
        SubAccountControllUtil.a(SubAccountProtocServiceImpl.access$600(this.a), paramSubAccountBackProtocData.c, false);
        if (!((ISubAccountConfigApi)QRoute.api(ISubAccountConfigApi.class)).getIsHideSubAccountTroopMsg()) {
          ((ISubAccountServlet)QRoute.api(ISubAccountServlet.class)).fetchOneTroopNewMsg(SubAccountProtocServiceImpl.access$600(this.a), paramSubAccountBackProtocData.c);
        }
      }
      return;
    }
    for (;;)
    {
      throw paramSubAccountBackProtocData;
    }
  }
  
  protected void b(boolean paramBoolean, SubAccountBackProtocData arg2)
  {
    synchronized ()
    {
      SubAccountProtocServiceImpl.access$102(this.a, false);
      return;
    }
  }
  
  protected void c(boolean paramBoolean, SubAccountBackProtocData arg2)
  {
    synchronized ()
    {
      SubAccountProtocServiceImpl.access$302(this.a, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.subaccount.api.impl.SubAccountProtocServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */
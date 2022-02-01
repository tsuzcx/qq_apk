package com.tencent.mobileqq.enterpriseqq;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.crmqq.structmsg.StructMsg.ButtonInfo;
import com.tencent.crmqq.structmsg.StructMsg.GetCRMMenuResponse;
import com.tencent.crmqq.structmsg.StructMsg.RetInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.EnterpriseQQHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EnterpriseQQManager
{
  private static EnterpriseQQManager c;
  private static byte[] d = new byte[0];
  private static byte[] e = new byte[0];
  protected Runnable a = new EnterpriseQQManager.1(this);
  protected SosoInterfaceOnLocationListener b = new EnterpriseQQManager.2(this, 4, true, true, 0L, false, false, "EnterpriseQQManager");
  private ArrayList<EnterpriseQQManager.EventRequest> f = null;
  private double g = 0.0D;
  private double h = 0.0D;
  private long i = 0L;
  private long j = 1800000L;
  private QQAppInterface k = null;
  private Context l = null;
  private EnterPriseQQCache m = null;
  
  private EnterpriseQQManager(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null) {
      b(paramQQAppInterface);
    }
  }
  
  public static EnterpriseQQManager a(QQAppInterface paramQQAppInterface)
  {
    if (c == null) {
      synchronized (d)
      {
        if (c == null) {
          c = new EnterpriseQQManager(paramQQAppInterface);
        }
      }
    }
    return c;
  }
  
  private static void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, StructMsg.ButtonInfo paramButtonInfo)
  {
    paramButtonInfo = new StringBuilder(paramButtonInfo.url.get());
    if (paramButtonInfo.indexOf("?") < 0) {
      paramButtonInfo.append("?");
    } else if (paramButtonInfo.indexOf("?") < paramButtonInfo.length() - 1) {
      if (paramButtonInfo.indexOf("&") < 0) {
        paramButtonInfo.append("&");
      } else if (paramButtonInfo.lastIndexOf("&") < paramButtonInfo.length() - 1) {
        paramButtonInfo.append("&");
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("uin=");
    ((StringBuilder)localObject).append(paramQQAppInterface.getCurrentAccountUin());
    paramButtonInfo.append(((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("&puin=");
    ((StringBuilder)localObject).append(paramString);
    paramButtonInfo.append(((StringBuilder)localObject).toString());
    localObject = new Bundle();
    ((Bundle)localObject).putString("url", paramButtonInfo.toString());
    ((Bundle)localObject).putString("uin", paramQQAppInterface.getCurrentAccountUin());
    ((Bundle)localObject).putString("puin", paramString);
    ((Bundle)localObject).putString("assignBackText", paramContext.getResources().getString(2131887625));
    if (paramString.equalsIgnoreCase("2632129500")) {
      ((Bundle)localObject).putBoolean("hide_operation_bar", true);
    }
    paramContext = new ActivityURIRequest(paramContext, "/pubaccount/browser");
    paramContext.extra().putAll((Bundle)localObject);
    QRoute.startUri(paramContext, null);
  }
  
  public List<StructMsg.ButtonInfo> a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = this.m;
    if (paramQQAppInterface != null) {
      return paramQQAppInterface.a(paramString);
    }
    return null;
  }
  
  public void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, boolean paramBoolean, double paramDouble1, double paramDouble2)
  {
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramString1)))
    {
      paramContext = (EnterpriseQQHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.ENTERPRISEQQ_HANDLER);
      if (paramContext != null) {
        paramContext.a(paramString1, paramString2, 1, paramBoolean, paramDouble1, paramDouble2);
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, StructMsg.GetCRMMenuResponse paramGetCRMMenuResponse)
  {
    if (paramQQAppInterface != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      if (this.m == null) {
        this.m = new EnterPriseQQCache();
      }
      long l1 = System.currentTimeMillis();
      if ((this.m.b(paramString) != paramInt) && (paramGetCRMMenuResponse != null))
      {
        List localList = paramGetCRMMenuResponse.button_info.get();
        paramGetCRMMenuResponse = new EnterpriseQQMenuEntity(paramString, paramGetCRMMenuResponse, paramInt, l1);
        paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
        EnterpriseQQMenuEntity localEnterpriseQQMenuEntity = (EnterpriseQQMenuEntity)paramQQAppInterface.find(EnterpriseQQMenuEntity.class, paramString);
        if (localEnterpriseQQMenuEntity != null)
        {
          localEnterpriseQQMenuEntity.data = ((byte[])paramGetCRMMenuResponse.data.clone());
          localEnterpriseQQMenuEntity.savedDateTime = paramGetCRMMenuResponse.savedDateTime;
          localEnterpriseQQMenuEntity.seqno = paramGetCRMMenuResponse.seqno;
          paramQQAppInterface.update(localEnterpriseQQMenuEntity);
        }
        else
        {
          paramQQAppInterface.persist(paramGetCRMMenuResponse);
        }
        this.m.a(paramString, localList, paramInt, l1);
        return;
      }
      if (paramGetCRMMenuResponse != null)
      {
        paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
        paramGetCRMMenuResponse = (EnterpriseQQMenuEntity)paramQQAppInterface.find(EnterpriseQQMenuEntity.class, paramString);
        if (paramGetCRMMenuResponse != null)
        {
          paramGetCRMMenuResponse.savedDateTime = l1;
          paramQQAppInterface.update(paramGetCRMMenuResponse);
        }
        this.m.a(paramString, l1);
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramString)))
    {
      long l1 = 0L;
      EnterPriseQQCache localEnterPriseQQCache = this.m;
      if (localEnterPriseQQCache != null) {
        l1 = localEnterPriseQQCache.c(paramString);
      }
      if ((paramBoolean) || ((!paramBoolean) && (System.currentTimeMillis() - l1 > 43200000L)))
      {
        paramQQAppInterface = (EnterpriseQQHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.ENTERPRISEQQ_HANDLER);
        if (paramQQAppInterface != null) {
          paramQQAppInterface.a(paramString);
        }
      }
    }
  }
  
  public void a(String arg1, Context paramContext, QQAppInterface paramQQAppInterface, String paramString2, StructMsg.ButtonInfo paramButtonInfo)
  {
    if (paramButtonInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("EnterpriseQQManager", 2, "buttoninfo is null.");
      }
      return;
    }
    int n = paramButtonInfo.type.get();
    if (n != 1)
    {
      if (n != 2)
      {
        if (n != 3) {
          return;
        }
        n = paramButtonInfo.event_id.get();
        if (n == 1) {
          return;
        }
        if (n == 2) {
          return;
        }
        if (n == 3) {
          return;
        }
        return;
      }
      a(paramContext, paramQQAppInterface, paramString2, paramButtonInfo);
      return;
    }
    if (paramButtonInfo.is_need_lbs.get())
    {
      if (System.currentTimeMillis() - this.i < this.j)
      {
        double d1 = this.g;
        if (d1 != 0.0D)
        {
          double d2 = this.h;
          if (d2 != 0.0D)
          {
            a(paramContext, paramQQAppInterface, paramString2, ???, true, d1, d2);
            return;
          }
        }
      }
      this.k = paramQQAppInterface;
      this.l = paramContext;
      paramContext = new EnterpriseQQManager.EventRequest(this);
      paramContext.a = paramString2;
      paramContext.b = ???;
      synchronized (e)
      {
        this.f.add(paramContext);
        ThreadManager.post(this.a, 8, null, true);
        return;
      }
    }
    a(paramContext, paramQQAppInterface, paramString2, ???, false, 0.0D, 0.0D);
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    if (this.m == null) {
      this.m = new EnterPriseQQCache();
    }
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager().query(EnterpriseQQMenuEntity.class);
      if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0)) {
        paramQQAppInterface = paramQQAppInterface.iterator();
      }
    }
    for (;;)
    {
      EnterpriseQQMenuEntity localEnterpriseQQMenuEntity;
      StructMsg.GetCRMMenuResponse localGetCRMMenuResponse;
      if (paramQQAppInterface.hasNext())
      {
        localEnterpriseQQMenuEntity = (EnterpriseQQMenuEntity)paramQQAppInterface.next();
        if (localEnterpriseQQMenuEntity == null) {
          continue;
        }
        localGetCRMMenuResponse = new StructMsg.GetCRMMenuResponse();
      }
      try
      {
        localGetCRMMenuResponse.mergeFrom(localEnterpriseQQMenuEntity.data);
        label96:
        if (!localGetCRMMenuResponse.ret_info.has()) {
          continue;
        }
        this.m.a(localEnterpriseQQMenuEntity.uin, localGetCRMMenuResponse.button_info.get(), localEnterpriseQQMenuEntity.seqno, localEnterpriseQQMenuEntity.savedDateTime);
        continue;
        return;
      }
      catch (Exception localException)
      {
        break label96;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.enterpriseqq.EnterpriseQQManager
 * JD-Core Version:    0.7.0.1
 */
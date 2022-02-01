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
  private static EnterpriseQQManager jdField_a_of_type_ComTencentMobileqqEnterpriseqqEnterpriseQQManager;
  private static byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private static byte[] jdField_b_of_type_ArrayOfByte = new byte[0];
  private double jdField_a_of_type_Double = 0.0D;
  private long jdField_a_of_type_Long = 0L;
  private Context jdField_a_of_type_AndroidContentContext = null;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  private EnterPriseQQCache jdField_a_of_type_ComTencentMobileqqEnterpriseqqEnterPriseQQCache = null;
  protected SosoInterfaceOnLocationListener a;
  protected Runnable a;
  private ArrayList<EnterpriseQQManager.EventRequest> jdField_a_of_type_JavaUtilArrayList = null;
  private double jdField_b_of_type_Double = 0.0D;
  private long jdField_b_of_type_Long = 1800000L;
  
  private EnterpriseQQManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangRunnable = new EnterpriseQQManager.1(this);
    this.jdField_a_of_type_ComTencentMobileqqSosoLocationSosoInterfaceOnLocationListener = new EnterpriseQQManager.2(this, 4, true, true, 0L, false, false, "EnterpriseQQManager");
    if (paramQQAppInterface != null) {
      a(paramQQAppInterface);
    }
  }
  
  public static EnterpriseQQManager a(QQAppInterface paramQQAppInterface)
  {
    if (jdField_a_of_type_ComTencentMobileqqEnterpriseqqEnterpriseQQManager == null) {
      synchronized (jdField_a_of_type_ArrayOfByte)
      {
        if (jdField_a_of_type_ComTencentMobileqqEnterpriseqqEnterpriseQQManager == null) {
          jdField_a_of_type_ComTencentMobileqqEnterpriseqqEnterpriseQQManager = new EnterpriseQQManager(paramQQAppInterface);
        }
      }
    }
    return jdField_a_of_type_ComTencentMobileqqEnterpriseqqEnterpriseQQManager;
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
    ((Bundle)localObject).putString("assignBackText", paramContext.getResources().getString(2131690706));
    if (paramString.equalsIgnoreCase("2632129500")) {
      ((Bundle)localObject).putBoolean("hide_operation_bar", true);
    }
    paramContext = new ActivityURIRequest(paramContext, "/pubaccount/browser");
    paramContext.extra().putAll((Bundle)localObject);
    QRoute.startUri(paramContext, null);
  }
  
  public List<StructMsg.ButtonInfo> a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqEnterpriseqqEnterPriseQQCache;
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
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEnterpriseqqEnterPriseQQCache == null) {
      this.jdField_a_of_type_ComTencentMobileqqEnterpriseqqEnterPriseQQCache = new EnterPriseQQCache();
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
        label95:
        if (!localGetCRMMenuResponse.ret_info.has()) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqEnterpriseqqEnterPriseQQCache.a(localEnterpriseQQMenuEntity.uin, localGetCRMMenuResponse.button_info.get(), localEnterpriseQQMenuEntity.seqno, localEnterpriseQQMenuEntity.savedDateTime);
        continue;
        return;
      }
      catch (Exception localException)
      {
        break label95;
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
      if (this.jdField_a_of_type_ComTencentMobileqqEnterpriseqqEnterPriseQQCache == null) {
        this.jdField_a_of_type_ComTencentMobileqqEnterpriseqqEnterPriseQQCache = new EnterPriseQQCache();
      }
      long l = System.currentTimeMillis();
      if ((this.jdField_a_of_type_ComTencentMobileqqEnterpriseqqEnterPriseQQCache.a(paramString) != paramInt) && (paramGetCRMMenuResponse != null))
      {
        List localList = paramGetCRMMenuResponse.button_info.get();
        paramGetCRMMenuResponse = new EnterpriseQQMenuEntity(paramString, paramGetCRMMenuResponse, paramInt, l);
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
        this.jdField_a_of_type_ComTencentMobileqqEnterpriseqqEnterPriseQQCache.a(paramString, localList, paramInt, l);
        return;
      }
      if (paramGetCRMMenuResponse != null)
      {
        paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
        paramGetCRMMenuResponse = (EnterpriseQQMenuEntity)paramQQAppInterface.find(EnterpriseQQMenuEntity.class, paramString);
        if (paramGetCRMMenuResponse != null)
        {
          paramGetCRMMenuResponse.savedDateTime = l;
          paramQQAppInterface.update(paramGetCRMMenuResponse);
        }
        this.jdField_a_of_type_ComTencentMobileqqEnterpriseqqEnterPriseQQCache.a(paramString, l);
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramString)))
    {
      long l = 0L;
      EnterPriseQQCache localEnterPriseQQCache = this.jdField_a_of_type_ComTencentMobileqqEnterpriseqqEnterPriseQQCache;
      if (localEnterPriseQQCache != null) {
        l = localEnterPriseQQCache.a(paramString);
      }
      if ((paramBoolean) || ((!paramBoolean) && (System.currentTimeMillis() - l > 43200000L)))
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
    int i = paramButtonInfo.type.get();
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        i = paramButtonInfo.event_id.get();
        if (i == 1) {
          return;
        }
        if (i == 2) {
          return;
        }
        if (i == 3) {
          return;
        }
        return;
      }
      a(paramContext, paramQQAppInterface, paramString2, paramButtonInfo);
      return;
    }
    if (paramButtonInfo.is_need_lbs.get())
    {
      if (System.currentTimeMillis() - this.jdField_a_of_type_Long < this.jdField_b_of_type_Long)
      {
        double d1 = this.jdField_a_of_type_Double;
        if (d1 != 0.0D)
        {
          double d2 = this.jdField_b_of_type_Double;
          if (d2 != 0.0D)
          {
            a(paramContext, paramQQAppInterface, paramString2, ???, true, d1, d2);
            return;
          }
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      this.jdField_a_of_type_AndroidContentContext = paramContext;
      paramContext = new EnterpriseQQManager.EventRequest(this);
      paramContext.a = paramString2;
      paramContext.b = ???;
      synchronized (jdField_b_of_type_ArrayOfByte)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramContext);
        ThreadManager.post(this.jdField_a_of_type_JavaLangRunnable, 8, null, true);
        return;
      }
    }
    a(paramContext, paramQQAppInterface, paramString2, ???, false, 0.0D, 0.0D);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.enterpriseqq.EnterpriseQQManager
 * JD-Core Version:    0.7.0.1
 */
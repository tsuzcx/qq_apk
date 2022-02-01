package com.tencent.mobileqq.troop.selecttroopmember;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberListHandler;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TroopMemberDataProvider
{
  protected static int a = 300000;
  protected static double b = 10.0D;
  private static int c = 1000;
  protected double a;
  protected Context a;
  Handler jdField_a_of_type_AndroidOsHandler = new TroopMemberDataProvider.1(this);
  protected QQAppInterface a;
  private TroopObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver = new TroopMemberDataProvider.2(this);
  protected TroopMemberDataProvider.DataNotifyCallBack a;
  protected String a;
  protected ArrayList<TroopMemberInfo> a;
  protected boolean a;
  protected int b = 0;
  
  public TroopMemberDataProvider(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, boolean paramBoolean, TroopMemberDataProvider.DataNotifyCallBack paramDataNotifyCallBack)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Double = 0.0D;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberTroopMemberDataProvider$DataNotifyCallBack = paramDataNotifyCallBack;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
  }
  
  private void a(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      Object localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramString);
      if (localObject != null) {
        localObject = ((TroopInfo)localObject).troopcode;
      } else {
        localObject = "0";
      }
      if ((localObject != null) && (((String)localObject).length() > 0))
      {
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
        {
          paramString = this.jdField_a_of_type_AndroidContentContext;
          QQToast.a(paramString, paramString.getString(2131692183), 0).a();
          return;
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("get troop members from server, troopUin: ");
          localStringBuilder.append(paramString);
          localStringBuilder.append(" troopCode: ");
          localStringBuilder.append((String)localObject);
          QLog.d("TroopMemberDataProvider", 2, localStringBuilder.toString());
        }
        ((ITroopMemberListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_LIST_HANDLER)).a(true, paramString, (String)localObject, true, 7, System.currentTimeMillis(), 0);
      }
    }
  }
  
  private void a(String paramString, List<TroopMemberInfo> paramList)
  {
    if (paramList == null) {}
    try
    {
      paramList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      localObject = paramList.query(TroopMemberInfo.class, false, "troopuin=? ", new String[] { paramString }, null, null, null, null);
      paramList.close();
      if (!QLog.isColorLevel()) {
        break label401;
      }
      paramList = new StringBuilder();
      paramList.append("getTroopMemberFromDB, troopMemberInfoList==null, queryDB, troopUin=");
      paramList.append(paramString);
      paramList.append(",");
      if (localObject == null) {
        i = 0;
      } else {
        i = ((List)localObject).size();
      }
      paramList.append(i);
      QLog.d("TroopMemberDataProvider", 2, paramList.toString());
    }
    finally
    {
      for (;;)
      {
        Object localObject;
        int j;
        int k;
        StringBuilder localStringBuilder;
        for (;;)
        {
          throw paramString;
        }
        continue;
        int i = 1;
        continue;
        i = 0;
      }
    }
    localObject = paramList;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getTroopMemberFromDB, troopuin=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(",");
      if (paramList == null) {
        i = 0;
      } else {
        i = paramList.size();
      }
      ((StringBuilder)localObject).append(i);
      QLog.d("TroopMemberDataProvider", 2, ((StringBuilder)localObject).toString());
      localObject = paramList;
    }
    if (localObject == null)
    {
      paramString = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
      return;
    }
    j = ((List)localObject).size();
    this.b = (j - 1);
    if (j > 0)
    {
      k = j / c;
      if (j % c == 0)
      {
        i = 0;
        paramList = new AtomicInteger(k + i);
        if (!QLog.isColorLevel()) {
          break label409;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("parallel process mJobCount: ");
        localStringBuilder.append(paramList.get());
        QLog.d("TroopMemberDataProvider", 2, localStringBuilder.toString());
        break label409;
        while (i < j)
        {
          ThreadManager.post(new TroopMemberDataProvider.4(this, paramString, (List)localObject, i, Math.min(c + i - 1, j), paramList), 8, null, false);
          i += c;
        }
      }
    }
    else
    {
      paramString = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
      return;
    }
  }
  
  private void c()
  {
    ITroopMemberListHandler localITroopMemberListHandler = (ITroopMemberListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_LIST_HANDLER);
    if (localITroopMemberListHandler != null) {}
    try
    {
      localITroopMemberListHandler.a(Long.parseLong(this.jdField_a_of_type_JavaLangString), 0L, 6, null, 0, 0);
      return;
    }
    catch (Exception localException) {}
  }
  
  public ArrayList<TroopMemberInfo> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("last_update_time");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localObject = ((Context)localObject).getSharedPreferences(localStringBuilder.toString(), 4);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_last_update_time");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    long l1 = ((SharedPreferences)localObject).getLong(localStringBuilder.toString(), 0L);
    long l2 = System.currentTimeMillis();
    long l3 = Math.abs(l2 - l1);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getTroopMembers, lastUpdateTime=");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append(", curTime=");
      ((StringBuilder)localObject).append(l2);
      ((StringBuilder)localObject).append(", diff=");
      ((StringBuilder)localObject).append(l3);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(hashCode());
      QLog.d("TroopMemberDataProvider", 2, ((StringBuilder)localObject).toString());
    }
    localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_a_of_type_JavaLangString);
    if (localObject != null)
    {
      this.b = (((TroopInfo)localObject).wMemberNum - 1);
      if (this.b > 0)
      {
        this.jdField_a_of_type_Double = 0.0D;
        localObject = this.jdField_a_of_type_AndroidOsHandler;
        ((Handler)localObject).sendMessage(((Handler)localObject).obtainMessage(3));
      }
    }
    if ((!this.jdField_a_of_type_Boolean) && ((l1 == 0L) || ((l1 > 0L) && (l3 > jdField_a_of_type_Int))))
    {
      a(this.jdField_a_of_type_JavaLangString);
      return;
    }
    localObject = new TroopMemberDataProvider.3(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.execute((Runnable)localObject);
  }
  
  public void b()
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localQQAppInterface != null) {
      localQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.selecttroopmember.TroopMemberDataProvider
 * JD-Core Version:    0.7.0.1
 */
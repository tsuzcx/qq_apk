package com.tencent.mobileqq.troop.selecttroopmember;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.handler.TroopMemberInfoHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TroopMemberDataProvider
{
  protected static int a;
  protected static double b;
  private static int c = 1000;
  protected double a;
  protected Context a;
  Handler jdField_a_of_type_AndroidOsHandler = new TroopMemberDataProvider.1(this);
  protected QQAppInterface a;
  private TroopBusinessObserver jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver = new TroopMemberDataProvider.3(this);
  private TroopObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver = new TroopMemberDataProvider.2(this);
  protected TroopMemberDataProvider.DataNotifyCallBack a;
  protected String a;
  protected ArrayList<TroopMemberInfo> a;
  protected boolean a;
  protected int b;
  
  static
  {
    jdField_b_of_type_Double = 10.0D;
    jdField_a_of_type_Int = 300000;
  }
  
  public TroopMemberDataProvider(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, boolean paramBoolean, TroopMemberDataProvider.DataNotifyCallBack paramDataNotifyCallBack)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Double = 0.0D;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberTroopMemberDataProvider$DataNotifyCallBack = paramDataNotifyCallBack;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
  }
  
  private void a(String paramString)
  {
    String str;
    if ((paramString != null) && (paramString.length() > 0))
    {
      TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramString);
      str = "0";
      if (localTroopInfo != null) {
        str = localTroopInfo.troopcode;
      }
      if ((str != null) && (str.length() > 0))
      {
        if (NetworkUtil.d(BaseApplication.getContext())) {
          break label83;
        }
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131692257), 0).a();
      }
    }
    return;
    label83:
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberDataProvider", 2, "get troop members from server, troopUin: " + paramString + " troopCode: " + str);
    }
    ((TroopMemberInfoHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_INFO_HANDLER)).a(true, paramString, str, true, 7, System.currentTimeMillis(), 0);
  }
  
  private void a(String paramString, List<TroopMemberInfo> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      try
      {
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
        paramList = ((EntityManager)localObject).query(TroopMemberInfo.class, false, "troopuin=? ", new String[] { paramString }, null, null, null, null);
        ((EntityManager)localObject).close();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder().append("getTroopMemberFromDB, troopMemberInfoList==null, queryDB, troopUin=").append(paramString).append(",");
          if (paramList == null)
          {
            i = 0;
            QLog.d("TroopMemberDataProvider", 2, i);
            break label361;
            if (paramList == null)
            {
              paramString = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
              this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
            }
          }
          else
          {
            i = paramList.size();
            continue;
            if (!QLog.isColorLevel()) {
              break label364;
            }
            localObject = new StringBuilder().append("getTroopMemberFromDB, troopuin=").append(paramString).append(",");
            if (paramList == null)
            {
              i = 0;
              QLog.d("TroopMemberDataProvider", 2, i);
              break label364;
            }
            i = paramList.size();
            continue;
          }
          int j = paramList.size();
          this.jdField_b_of_type_Int = (j - 1);
          if (j > 0)
          {
            int k = j / c;
            if (j % c != 0) {
              break label372;
            }
            i = 0;
            localObject = new AtomicInteger(i + k);
            if (!QLog.isColorLevel()) {
              break label367;
            }
            QLog.d("TroopMemberDataProvider", 2, "parallel process mJobCount: " + ((AtomicInteger)localObject).get());
            break label367;
            if (i < j)
            {
              ThreadManager.post(new TroopMemberDataProvider.5(this, paramString, paramList, i, Math.min(c + i - 1, j), (AtomicInteger)localObject), 8, null, false);
              i += c;
              continue;
            }
            continue;
          }
          paramString = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
          this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
          continue;
        }
        continue;
      }
      finally {}
      label361:
      label364:
      continue;
      label367:
      int i = 0;
      continue;
      label372:
      i = 1;
    }
  }
  
  private void c()
  {
    TroopHandler localTroopHandler = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    if (localTroopHandler != null) {}
    try
    {
      localTroopHandler.a(Long.parseLong(this.jdField_a_of_type_JavaLangString), 0L, 6, null, 0, 0);
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
    long l1 = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("last_update_time" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 4).getLong("key_last_update_time" + this.jdField_a_of_type_JavaLangString, 0L);
    long l2 = System.currentTimeMillis();
    long l3 = Math.abs(l2 - l1);
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberDataProvider", 2, "getTroopMembers, lastUpdateTime=" + l1 + ", curTime=" + l2 + ", diff=" + l3 + ", " + hashCode());
    }
    Object localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_a_of_type_JavaLangString);
    if (localObject != null)
    {
      this.jdField_b_of_type_Int = (((TroopInfo)localObject).wMemberNum - 1);
      if (this.jdField_b_of_type_Int > 0)
      {
        this.jdField_a_of_type_Double = 0.0D;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3));
      }
    }
    if ((!this.jdField_a_of_type_Boolean) && ((l1 == 0L) || ((l1 > 0L) && (l3 > jdField_a_of_type_Int))))
    {
      a(this.jdField_a_of_type_JavaLangString);
      return;
    }
    localObject = new TroopMemberDataProvider.4(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.execute((Runnable)localObject);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.selecttroopmember.TroopMemberDataProvider
 * JD-Core Version:    0.7.0.1
 */
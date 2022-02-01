package com.tencent.qqconnect.wtlogin;

import com.tencent.common.app.business.BaseOpenSDKAppInterface;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.open.agent.entity.AuthMemoryCache;
import com.tencent.open.agent.entity.QQLiteBridgeParam;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

public abstract class AbstractOpenSdkAppInterface
  extends BaseOpenSDKAppInterface
{
  private AuthMemoryCache jdField_a_of_type_ComTencentOpenAgentEntityAuthMemoryCache = new AuthMemoryCache();
  private List<IEventListener> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public AbstractOpenSdkAppInterface(MobileQQ paramMobileQQ, String paramString)
  {
    super(paramMobileQQ, paramString);
  }
  
  public static AbstractOpenSdkAppInterface a()
  {
    return (AbstractOpenSdkAppInterface)MobileQQ.sMobileQQ.peekAppRuntime();
  }
  
  public AuthMemoryCache a()
  {
    return this.jdField_a_of_type_ComTencentOpenAgentEntityAuthMemoryCache;
  }
  
  public abstract Object a(QQLiteBridgeParam paramQQLiteBridgeParam);
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(int paramInt, Object paramObject)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((IEventListener)localIterator.next()).a(paramInt, paramObject);
    }
  }
  
  public void a(IEventListener paramIEventListener)
  {
    if (paramIEventListener != null) {
      this.jdField_a_of_type_JavaUtilList.add(paramIEventListener);
    }
  }
  
  public BaseApplication getApp()
  {
    return this.app;
  }
  
  public int getAppid()
  {
    return 0;
  }
  
  public String getCurrentAccountUin()
  {
    return null;
  }
  
  public EntityManagerFactory getEntityManagerFactory(String paramString)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqconnect.wtlogin.AbstractOpenSdkAppInterface
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.webview.swift.component;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.PreloadCookie;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SwiftPreloadCookieManager
{
  public AppInterface a;
  public EntityManager a;
  
  public SwiftPreloadCookieManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    paramAppInterface = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getEntityManagerFactory();
    if (paramAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramAppInterface.createEntityManager();
    }
  }
  
  public List a(String paramString)
  {
    ArrayList localArrayList = null;
    int i = 0;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(PreloadCookie.class, false, "cookieKey=?", new String[] { paramString }, null, null, "hitCount DESC", "10");
    if (QLog.isColorLevel()) {
      if (localObject != null) {
        break label140;
      }
    }
    for (;;)
    {
      QLog.i("SwiftPreloadCookieManager", 2, String.format("now select records for cookieKey: %s, size: %d", new Object[] { paramString, Integer.valueOf(i) }));
      paramString = localArrayList;
      if (localObject == null) {
        break;
      }
      paramString = localArrayList;
      if (((List)localObject).size() <= 0) {
        break;
      }
      localArrayList = new ArrayList();
      localObject = ((List)localObject).iterator();
      for (;;)
      {
        paramString = localArrayList;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localArrayList.add(((PreloadCookie)((Iterator)localObject).next()).host);
      }
      label140:
      i = ((List)localObject).size();
    }
    return paramString;
  }
  
  public void a(String paramString1, String paramString2)
  {
    PreloadCookie localPreloadCookie = (PreloadCookie)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(PreloadCookie.class, new String[] { paramString1, paramString2 });
    if (localPreloadCookie != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SwiftPreloadCookieManager", 2, String.format("update host: %s, cookieKey: %s , hitCount: %d ", new Object[] { paramString1, paramString2, Long.valueOf(localPreloadCookie.hitCount + 1L) }));
      }
      localPreloadCookie.hitCount += 1L;
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(localPreloadCookie);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("SwiftPreloadCookieManager", 2, String.format("insert host: %s, cookieKey: %s", new Object[] { paramString1, paramString2 }));
    }
    localPreloadCookie = new PreloadCookie();
    localPreloadCookie.host = paramString1;
    localPreloadCookie.cookieKey = paramString2;
    localPreloadCookie.hitCount = 1L;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(localPreloadCookie);
  }
  
  public void b(String paramString1, String paramString2)
  {
    PreloadCookie localPreloadCookie = (PreloadCookie)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(PreloadCookie.class, new String[] { paramString1, paramString2 });
    if (localPreloadCookie != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SwiftPreloadCookieManager", 2, "delete host: " + paramString1 + ", type: " + paramString2);
      }
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localPreloadCookie);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftPreloadCookieManager
 * JD-Core Version:    0.7.0.1
 */
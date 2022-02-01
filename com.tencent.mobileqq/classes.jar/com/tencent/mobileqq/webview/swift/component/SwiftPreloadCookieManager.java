package com.tencent.mobileqq.webview.swift.component;

import com.tencent.mobileqq.data.PreloadCookie;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class SwiftPreloadCookieManager
{
  public EntityManager a;
  public AppRuntime a;
  
  public SwiftPreloadCookieManager(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    paramAppRuntime = this.jdField_a_of_type_MqqAppAppRuntime.getEntityManagerFactory();
    if (paramAppRuntime != null) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramAppRuntime.createEntityManager();
    }
  }
  
  public List<String> a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null)
    {
      QLog.i("SwiftPreloadCookieManager", 1, "getTopDomain mEM empty");
      return null;
    }
    try
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
      int i = 0;
      localObject = ((EntityManager)localObject).query(PreloadCookie.class, false, "cookieKey=?", new String[] { paramString }, null, null, "hitCount DESC", "10");
      if (QLog.isColorLevel())
      {
        if (localObject != null) {
          i = ((List)localObject).size();
        }
        QLog.i("SwiftPreloadCookieManager", 2, String.format("now select records for cookieKey: %s, size: %d", new Object[] { paramString, Integer.valueOf(i) }));
      }
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        paramString = new ArrayList();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          paramString.add(((PreloadCookie)((Iterator)localObject).next()).host);
        }
        return paramString;
      }
      return null;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null)
    {
      QLog.i("SwiftPreloadCookieManager", 1, "getTopDomain mEM empty");
      return;
    }
    try
    {
      PreloadCookie localPreloadCookie = (PreloadCookie)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(PreloadCookie.class, new String[] { paramString1, paramString2 });
      if (localPreloadCookie != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("SwiftPreloadCookieManager", 2, String.format("update host: %s, cookieKey: %s , hitCount: %d ", new Object[] { paramString1, paramString2, Long.valueOf(localPreloadCookie.hitCount + 1L) }));
        }
        localPreloadCookie.hitCount += 1L;
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.update(localPreloadCookie);
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("SwiftPreloadCookieManager", 2, String.format("insert host: %s, cookieKey: %s", new Object[] { paramString1, paramString2 }));
        }
        localPreloadCookie = new PreloadCookie();
        localPreloadCookie.host = paramString1;
        localPreloadCookie.cookieKey = paramString2;
        localPreloadCookie.hitCount = 1L;
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.persist(localPreloadCookie);
      }
      return;
    }
    finally {}
  }
  
  public void b(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null)
    {
      QLog.i("SwiftPreloadCookieManager", 1, "getTopDomain mEM empty");
      return;
    }
    try
    {
      PreloadCookie localPreloadCookie = (PreloadCookie)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(PreloadCookie.class, new String[] { paramString1, paramString2 });
      if (localPreloadCookie != null)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("delete host: ");
          localStringBuilder.append(paramString1);
          localStringBuilder.append(", type: ");
          localStringBuilder.append(paramString2);
          QLog.i("SwiftPreloadCookieManager", 2, localStringBuilder.toString());
        }
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove(localPreloadCookie);
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftPreloadCookieManager
 * JD-Core Version:    0.7.0.1
 */
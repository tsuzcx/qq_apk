package com.tencent.mobileqq.troop.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.troop.data.TroopAioTopADInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class TroopAioADManager
  extends Observable
  implements Manager
{
  protected QQAppInterface a;
  protected EntityManager b;
  protected ConcurrentHashMap<String, TroopAioTopADInfo> c;
  
  public TroopAioADManager(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    this.b = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    if (this.c == null) {
      try
      {
        if (this.c == null) {
          this.c = new ConcurrentHashMap();
        }
        return;
      }
      finally {}
    }
  }
  
  public TroopAioTopADInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (TroopAioTopADInfo)this.c.get(paramString);
  }
  
  public void a()
  {
    setChanged();
    notifyObservers(Integer.valueOf(123321));
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopAioADManager", 4, "notify TroopChatPie");
    }
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.c.remove(paramString);
    paramString = (TroopAioTopADInfo)this.b.find(TroopAioTopADInfo.class, paramString);
    if (paramString != null) {
      this.b.remove(paramString);
    }
  }
  
  public void onDestroy()
  {
    Object localObject = this.b;
    if ((localObject != null) && (((EntityManager)localObject).isOpen())) {
      this.b.close();
    }
    localObject = this.c;
    if (localObject != null) {
      ((ConcurrentHashMap)localObject).clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopAioADManager
 * JD-Core Version:    0.7.0.1
 */
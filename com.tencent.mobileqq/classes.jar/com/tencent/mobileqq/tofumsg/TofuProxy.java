package com.tencent.mobileqq.tofumsg;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.CopyOnWriteArrayList;

public class TofuProxy
{
  public static TofuProxy a()
  {
    return TofuProxy.SHolder.a();
  }
  
  private static void b() {}
  
  @NonNull
  public CopyOnWriteArrayList<TofuLimitMsg> a(@NonNull QQAppInterface paramQQAppInterface, @NonNull String paramString)
  {
    try
    {
      b();
      CopyOnWriteArrayList localCopyOnWriteArrayList = new CopyOnWriteArrayList();
      try
      {
        paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager().query(TofuLimitMsg.class, new TofuLimitMsg().getTableName(), false, "friendUin=?", new String[] { paramString }, null, null, null, null);
        if (paramQQAppInterface != null) {
          localCopyOnWriteArrayList.addAll(paramQQAppInterface);
        }
      }
      catch (Throwable paramQQAppInterface)
      {
        QLog.e("TofuNew.TofuProxy", 1, paramQQAppInterface, new Object[0]);
      }
      return localCopyOnWriteArrayList;
    }
    finally {}
  }
  
  public void a(@NonNull QQAppInterface paramQQAppInterface, @NonNull TofuLimitMsg paramTofuLimitMsg)
  {
    try
    {
      b();
      try
      {
        paramQQAppInterface.getEntityManagerFactory().createEntityManager().persistOrReplace(paramTofuLimitMsg);
      }
      catch (Throwable paramQQAppInterface)
      {
        QLog.e("TofuNew.TofuProxy", 1, paramQQAppInterface, new Object[0]);
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tofumsg.TofuProxy
 * JD-Core Version:    0.7.0.1
 */
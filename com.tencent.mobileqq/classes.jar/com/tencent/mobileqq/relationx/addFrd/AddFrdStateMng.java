package com.tencent.mobileqq.relationx.addFrd;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

public class AddFrdStateMng
{
  private static final String g = "AddFrdStateMng";
  final ConcurrentHashMap<String, Long> a = new ConcurrentHashMap(5);
  SharedPreferences b = null;
  public boolean c = false;
  boolean d = false;
  volatile boolean e = false;
  WeakReference<QQAppInterface> f;
  
  private void b()
  {
    if ((this.d) && (!this.e))
    {
      this.e = true;
      ThreadManager.excute(new AddFrdStateMng.1(this), 16, null, false);
    }
  }
  
  private void c()
  {
    if (!this.d)
    {
      if (QLog.isColorLevel()) {
        QLog.i(g, 2, "save cache no change");
      }
      return;
    }
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(g, 2, "save cache pref is null");
      }
      return;
    }
    try
    {
      this.d = false;
      Object localObject1 = new ArrayList(this.a.size());
      Object localObject2 = this.a.entrySet().iterator();
      Map.Entry localEntry;
      while (((Iterator)localObject2).hasNext())
      {
        localEntry = (Map.Entry)((Iterator)localObject2).next();
        if ((localEntry != null) && (localEntry.getValue() != null) && (((Long)localEntry.getValue()).longValue() != 0L)) {
          ((ArrayList)localObject1).add(localEntry);
        }
      }
      if (((ArrayList)localObject1).size() > 100) {
        Collections.sort((List)localObject1, new AddFrdStateMng.2(this));
      }
      localObject2 = new StringBuilder(200);
      localObject1 = ((ArrayList)localObject1).iterator();
      int i = 0;
      int j;
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localEntry = (Map.Entry)((Iterator)localObject1).next();
        if (((StringBuilder)localObject2).length() > 0) {
          ((StringBuilder)localObject2).append(",");
        }
        ((StringBuilder)localObject2).append((String)localEntry.getKey());
        ((StringBuilder)localObject2).append("|");
        ((StringBuilder)localObject2).append(localEntry.getValue());
        j = i + 1;
        i = j;
      } while (j < 100);
      localSharedPreferences.edit().putString("add_frd_state_list", ((StringBuilder)localObject2).toString()).apply();
      if (QLog.isColorLevel())
      {
        QLog.i(g, 2, String.format("saveCache %s", new Object[] { ((StringBuilder)localObject2).toString() }));
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public int a(String paramString, QQAppInterface paramQQAppInterface)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      long l1 = System.currentTimeMillis();
      try
      {
        localObject2 = (Long)this.a.get(paramString);
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        localObject2 = null;
      }
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = Long.valueOf(0L);
      }
      long l2 = ((Long)localObject1).longValue();
      int i = 2;
      Object localObject2 = localObject1;
      if (l2 != 0L)
      {
        localObject2 = localObject1;
        if (Math.abs(l1 - ((Long)localObject1).longValue()) >= 604800000L)
        {
          if (QLog.isColorLevel()) {
            QLog.i(g, 2, String.format("getAddFrdState long time ago [time:%s, cur: %s, du: %s]", new Object[] { localObject1, Long.valueOf(l1), Long.valueOf(Math.abs(l1 - ((Long)localObject1).longValue())) }));
          }
          localObject2 = Long.valueOf(0L);
          b(paramString);
        }
      }
      if (((Long)localObject2).longValue() == 0L) {
        i = 3;
      }
      int j = i;
      if (paramQQAppInterface != null)
      {
        localObject1 = paramQQAppInterface.getCurrentAccountUin();
        if ((localObject1 != null) && (((String)localObject1).equals(paramString))) {
          return 0;
        }
        j = i;
        if (((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).n(paramString))
        {
          b(paramString);
          j = 1;
        }
      }
      return j;
    }
    return 0;
  }
  
  public SharedPreferences a()
  {
    if (this.b == null)
    {
      Object localObject = this.f;
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = (QQAppInterface)((WeakReference)localObject).get();
      }
      if (localObject != null)
      {
        String str = ((QQAppInterface)localObject).getCurrentAccountUin();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("add_frd_state_");
        localStringBuilder.append(str);
        str = localStringBuilder.toString();
        this.b = ((QQAppInterface)localObject).getApplication().getSharedPreferences(str, 0);
      }
      else if (QLog.isColorLevel())
      {
        QLog.i(g, 2, "getPref app is null");
      }
    }
    return this.b;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    for (;;)
    {
      try
      {
        boolean bool = this.c;
        if (bool) {
          continue;
        }
        if (paramQQAppInterface == null) {}
      }
      finally
      {
        int i;
        continue;
        throw paramQQAppInterface;
        continue;
        i += 1;
        continue;
      }
      try
      {
        this.f = new WeakReference(paramQQAppInterface);
        paramQQAppInterface = a();
        if (paramQQAppInterface == null) {
          paramQQAppInterface = null;
        } else {
          paramQQAppInterface = paramQQAppInterface.getString("add_frd_state_list", "");
        }
        if ((paramQQAppInterface != null) && (paramQQAppInterface.length() > 0))
        {
          String[] arrayOfString = paramQQAppInterface.split(",");
          if (arrayOfString.length > 0)
          {
            int j = arrayOfString.length;
            i = 0;
            if (i < j)
            {
              String str2 = arrayOfString[i];
              if ((str2 == null) || (str2.length() < 3)) {
                continue;
              }
              int k = str2.indexOf("|");
              if (k <= 0) {
                continue;
              }
              int m = str2.length();
              if (k >= m - 1) {
                continue;
              }
              long l;
              Object localObject;
              try
              {
                String str1 = str2.substring(0, k);
                l = Long.parseLong(str2.substring(k + 1));
              }
              catch (Throwable localThrowable)
              {
                localThrowable.printStackTrace();
                l = 0L;
                localObject = null;
              }
              if ((localObject == null) || (localObject.length() <= 0)) {
                continue;
              }
              this.a.put(localObject, Long.valueOf(l));
              continue;
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.i(g, 2, String.format("init [%s, %s]", new Object[] { paramQQAppInterface, this.a.toString() }));
        }
      }
      catch (Throwable paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
      }
    }
    this.c = true;
  }
  
  public void a(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return;
      }
      long l = System.currentTimeMillis();
      try
      {
        this.a.put(paramString, Long.valueOf(l));
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
      this.d = true;
      b();
      if (QLog.isColorLevel()) {
        QLog.i(g, 2, String.format("markSendAddFrd uin:%s, time:%s", new Object[] { paramString, Long.valueOf(l) }));
      }
    }
  }
  
  public void b(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return;
      }
      Object localObject = null;
      try
      {
        Long localLong = (Long)this.a.remove(paramString);
        localObject = localLong;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
      if (localObject != null) {
        this.d = true;
      }
      b();
      if (QLog.isColorLevel()) {
        QLog.i(g, 2, String.format("removeFromCache uin:%s, change: %s", new Object[] { paramString, Boolean.valueOf(this.d) }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.addFrd.AddFrdStateMng
 * JD-Core Version:    0.7.0.1
 */
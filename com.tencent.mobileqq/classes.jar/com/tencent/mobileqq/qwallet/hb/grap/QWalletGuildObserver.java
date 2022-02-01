package com.tencent.mobileqq.qwallet.hb.grap;

import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.GuildUserAvatar;
import com.tencent.mobileqq.qqguildsdk.data.MemberNickNameInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qwallet.ipc.impl.QWalletIPCModule;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QWalletGuildObserver
  extends GPServiceObserver
{
  private static QWalletGuildObserver a;
  private static final byte[] b = new byte[1];
  private static final byte[] c = new byte[1];
  private static final byte[] d = new byte[1];
  private final Map<Integer, ArrayList<String>> e = new HashMap();
  private final Map<Integer, QWalletGuildObserver.GetNickNameModule> f = new HashMap();
  private final Map<Integer, QWalletGuildObserver.GetNickNameModule> g = new HashMap();
  
  public static QWalletGuildObserver c()
  {
    if (a == null) {
      try
      {
        if (a == null)
        {
          a = new QWalletGuildObserver();
          try
          {
            ((IGPSService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IGPSService.class, "")).addObserver(a);
          }
          catch (Exception localException)
          {
            QLog.e("QWalletGuildObserver", 1, localException, new Object[0]);
          }
        }
      }
      finally {}
    }
    return a;
  }
  
  public void a(int paramInt, ArrayList<String> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() != 0)) {
      synchronized (b)
      {
        this.e.put(Integer.valueOf(paramInt), paramArrayList);
        return;
      }
    }
  }
  
  public void a(int paramInt, ArrayList<String> paramArrayList, String paramString)
  {
    if ((paramArrayList != null) && (paramArrayList.size() != 0) && (!TextUtils.isEmpty(paramString))) {
      synchronized (c)
      {
        this.f.put(Integer.valueOf(paramInt), new QWalletGuildObserver.GetNickNameModule(paramArrayList, paramString));
        return;
      }
    }
  }
  
  protected void a(List<GuildUserAvatar> paramList)
  {
    if ((this.e.size() != 0) && (paramList != null)) {
      if (paramList.size() == 0) {
        return;
      }
    }
    for (;;)
    {
      int j;
      try
      {
        synchronized (b)
        {
          super.a(paramList);
          Iterator localIterator = this.e.entrySet().iterator();
          if (localIterator.hasNext())
          {
            Object localObject = (Map.Entry)localIterator.next();
            ArrayList localArrayList = (ArrayList)((Map.Entry)localObject).getValue();
            if (localArrayList == null) {
              continue;
            }
            if (localArrayList.size() != 0) {
              break label268;
            }
            continue;
            j = i;
            if (k < paramList.size())
            {
              GuildUserAvatar localGuildUserAvatar = (GuildUserAvatar)paramList.get(k);
              m = i;
              if (localGuildUserAvatar == null) {
                break label301;
              }
              if (!TextUtils.isEmpty(localGuildUserAvatar.a())) {
                break label276;
              }
              m = i;
              break label301;
              j = i;
              if (m >= localArrayList.size()) {
                break label291;
              }
              if (!localGuildUserAvatar.a().equals(localArrayList.get(m))) {
                break label282;
              }
              j = 1;
              break label291;
            }
            if (j == 0) {
              continue;
            }
            i = ((Integer)((Map.Entry)localObject).getKey()).intValue();
            localObject = (BaseQQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
            QWalletIPCModule.a().a(localArrayList, (BaseQQAppInterface)localObject, i);
            localIterator.remove();
          }
        }
      }
      catch (Exception paramList)
      {
        QLog.e("QWalletGuildObserver", 1, paramList, new Object[0]);
        return;
      }
      throw paramList;
      return;
      label268:
      int k = 0;
      int i = 0;
      continue;
      label276:
      int m = 0;
      continue;
      label282:
      m += 1;
      continue;
      label291:
      m = j;
      if (j == 0)
      {
        label301:
        k += 1;
        i = m;
      }
    }
  }
  
  public void b(int paramInt, ArrayList<String> paramArrayList, String paramString)
  {
    if ((paramArrayList != null) && (paramArrayList.size() != 0) && (!TextUtils.isEmpty(paramString))) {
      synchronized (d)
      {
        this.g.put(Integer.valueOf(paramInt), new QWalletGuildObserver.GetNickNameModule(paramArrayList, paramString));
        return;
      }
    }
  }
  
  protected void b(List<MemberNickNameInfo> paramList)
  {
    if ((this.f.size() != 0) && (paramList != null)) {
      if (paramList.size() == 0) {
        return;
      }
    }
    for (;;)
    {
      int j;
      synchronized (c)
      {
        super.b(paramList);
        try
        {
          Iterator localIterator = this.f.entrySet().iterator();
          if (localIterator.hasNext())
          {
            Object localObject1 = (Map.Entry)localIterator.next();
            Object localObject2 = (QWalletGuildObserver.GetNickNameModule)((Map.Entry)localObject1).getValue();
            ArrayList localArrayList = ((QWalletGuildObserver.GetNickNameModule)localObject2).b;
            localObject2 = ((QWalletGuildObserver.GetNickNameModule)localObject2).a;
            if (localArrayList.size() != 0) {
              break label276;
            }
            continue;
            j = i;
            if (k < paramList.size())
            {
              MemberNickNameInfo localMemberNickNameInfo = (MemberNickNameInfo)paramList.get(k);
              m = i;
              if (localMemberNickNameInfo == null) {
                break label309;
              }
              if (!TextUtils.isEmpty(localMemberNickNameInfo.a())) {
                break label284;
              }
              m = i;
              break label309;
              j = i;
              if (m >= localArrayList.size()) {
                break label299;
              }
              if (!localMemberNickNameInfo.a().equals(localArrayList.get(m))) {
                break label290;
              }
              j = 1;
              break label299;
            }
            if (j == 0) {
              continue;
            }
            i = ((Integer)((Map.Entry)localObject1).getKey()).intValue();
            localObject1 = (BaseQQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
            QWalletIPCModule.a().a(localArrayList, (String)localObject2, (BaseQQAppInterface)localObject1, i);
            localIterator.remove();
            continue;
          }
          paramList = finally;
        }
        catch (Exception paramList)
        {
          QLog.e("QWalletGuildObserver", 1, paramList, new Object[0]);
          return;
        }
      }
      return;
      label276:
      int k = 0;
      int i = 0;
      continue;
      label284:
      int m = 0;
      continue;
      label290:
      m += 1;
      continue;
      label299:
      m = j;
      if (j == 0)
      {
        label309:
        k += 1;
        i = m;
      }
    }
  }
  
  protected void c(String paramString, List<MemberNickNameInfo> paramList)
  {
    if ((this.g.size() != 0) && (paramList != null)) {
      if (paramList.size() == 0) {
        return;
      }
    }
    for (;;)
    {
      int j;
      try
      {
        synchronized (d)
        {
          super.c(paramString, paramList);
          paramString = this.g.entrySet().iterator();
          if (paramString.hasNext())
          {
            Object localObject1 = (Map.Entry)paramString.next();
            Object localObject2 = (QWalletGuildObserver.GetNickNameModule)((Map.Entry)localObject1).getValue();
            ArrayList localArrayList = ((QWalletGuildObserver.GetNickNameModule)localObject2).b;
            localObject2 = ((QWalletGuildObserver.GetNickNameModule)localObject2).a;
            if (localArrayList.size() != 0) {
              break label280;
            }
            continue;
            j = i;
            if (k < paramList.size())
            {
              MemberNickNameInfo localMemberNickNameInfo = (MemberNickNameInfo)paramList.get(k);
              m = i;
              if (localMemberNickNameInfo == null) {
                break label315;
              }
              if (!TextUtils.isEmpty(localMemberNickNameInfo.a())) {
                break label288;
              }
              m = i;
              break label315;
              j = i;
              if (m >= localArrayList.size()) {
                break label303;
              }
              if (!localMemberNickNameInfo.a().equals(localArrayList.get(m))) {
                break label294;
              }
              j = 1;
              break label303;
            }
            if (j == 0) {
              continue;
            }
            i = ((Integer)((Map.Entry)localObject1).getKey()).intValue();
            localObject1 = (BaseQQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
            QWalletIPCModule.a().a(localArrayList, (String)localObject2, (BaseQQAppInterface)localObject1, i);
            paramString.remove();
          }
        }
      }
      catch (Exception paramString)
      {
        QLog.e("QWalletGuildObserver", 1, paramString, new Object[0]);
        return;
      }
      throw paramString;
      return;
      label280:
      int k = 0;
      int i = 0;
      continue;
      label288:
      int m = 0;
      continue;
      label294:
      m += 1;
      continue;
      label303:
      m = j;
      if (j == 0)
      {
        label315:
        k += 1;
        i = m;
      }
    }
  }
  
  public void d()
  {
    synchronized (b)
    {
      this.e.clear();
      synchronized (d)
      {
        this.g.clear();
        synchronized (c)
        {
          this.f.clear();
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.QWalletGuildObserver
 * JD-Core Version:    0.7.0.1
 */
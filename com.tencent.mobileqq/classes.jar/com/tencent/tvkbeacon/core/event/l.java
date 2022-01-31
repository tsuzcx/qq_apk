package com.tencent.tvkbeacon.core.event;

import android.content.Context;
import com.tencent.tvkbeacon.core.a.a.b;
import com.tencent.tvkbeacon.core.c.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class l
{
  public static int a(Context paramContext, String paramString)
  {
    c.b("[db] start", new Object[0]);
    if (paramContext == null)
    {
      c.d("[db] context is null.", new Object[0]);
      return -1;
    }
    return b.b(paramContext, paramString, new int[] { 1, 2, 3, 4 });
  }
  
  public static int a(Context paramContext, String paramString, Long[] paramArrayOfLong)
  {
    c.b("[db] start", new Object[0]);
    if (paramContext == null)
    {
      c.d("[db] have null args!", new Object[0]);
      return -1;
    }
    c.b("[db] end", new Object[0]);
    return b.a(paramContext, paramString, paramArrayOfLong);
  }
  
  public static List<RDBean> a(Context paramContext, String paramString, int paramInt)
  {
    c.b("[db] start", new Object[0]);
    if (paramContext == null) {
      c.d("[db] have null args!", new Object[0]);
    }
    List localList;
    do
    {
      return null;
      localList = b.a(paramContext, paramString, new int[] { 1, 2, 3, 4 }, paramInt);
    } while ((localList == null) || (localList.size() <= 0));
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = localList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      com.tencent.tvkbeacon.core.a.a.a locala = (com.tencent.tvkbeacon.core.a.a.a)((Iterator)localObject1).next();
      try
      {
        Object localObject2 = com.tencent.tvkbeacon.core.c.a.a(locala.e);
        if ((localObject2 != null) && (RDBean.class.isInstance(localObject2)))
        {
          localObject2 = (RDBean)RDBean.class.cast(localObject2);
          ((RDBean)localObject2).setCid(locala.a);
          localArrayList.add(localObject2);
          ((Iterator)localObject1).remove();
        }
      }
      catch (Throwable localThrowable)
      {
        c.a(localThrowable);
        c.d("[db] query have error!", new Object[0]);
      }
    }
    if (localList.size() > 0)
    {
      c.c("[db] there are error data ,should be remove " + localList.size(), new Object[0]);
      localObject1 = new Long[localList.size()];
      paramInt = 0;
      while (paramInt < localList.size())
      {
        localObject1[paramInt] = Long.valueOf(((com.tencent.tvkbeacon.core.a.a.a)localList.get(paramInt)).a);
        paramInt += 1;
      }
      b.a(paramContext, paramString, (Long[])localObject1);
    }
    c.b("[db] end", new Object[0]);
    return localArrayList;
  }
  
  public static Long[] a(Context paramContext, String paramString, List<RDBean> paramList)
  {
    c.b("[db] start", new Object[0]);
    if ((paramContext == null) || (paramList == null))
    {
      c.d("[db] have null args!", new Object[0]);
      return null;
    }
    int m = paramList.size();
    if (m == 0)
    {
      c.d("[db] insert list size(0) return.", new Object[0]);
      return null;
    }
    Long[] arrayOfLong = new Long[m];
    ArrayList localArrayList = new ArrayList();
    int k = 0;
    if (k < m)
    {
      RDBean localRDBean = (RDBean)paramList.get(k);
      if (localRDBean == null) {
        c.c("[db] bean is null!", new Object[0]);
      }
      for (;;)
      {
        k += 1;
        break;
        int j;
        if (localRDBean.getTP().equals("UA"))
        {
          i = 1;
          j = 3;
        }
        for (;;)
        {
          try
          {
            localArrayList.add(new com.tencent.tvkbeacon.core.a.a.a(i, j, localRDBean.getTM(), com.tencent.tvkbeacon.core.c.a.a(localRDBean)));
          }
          catch (Throwable localThrowable)
          {
            c.d("[db] bean: %s add to analyticsList error!", new Object[] { localRDBean.getEN() });
            c.a(localThrowable);
          }
          break;
          if (localRDBean.getTP().equals("IP"))
          {
            i = 2;
            j = 0;
          }
          else if (localRDBean.getTP().equals("DN"))
          {
            i = 3;
            j = 0;
          }
          else
          {
            if (!localRDBean.getTP().equals("HO")) {
              break label253;
            }
            i = 4;
            j = 0;
          }
        }
        label253:
        c.c("[db] bean's type is error!", new Object[0]);
      }
    }
    if (!b.a(paramContext, paramString, localArrayList))
    {
      c.b("[db] AnalyticsDAO.insert beans fail!", new Object[0]);
      return null;
    }
    c.b("[db] AnalyticsDAO.insert beans success!", new Object[0]);
    paramContext = localArrayList.iterator();
    int i = 0;
    while (paramContext.hasNext())
    {
      paramString = (com.tencent.tvkbeacon.core.a.a.a)paramContext.next();
      if (i < m) {
        arrayOfLong[i] = Long.valueOf(paramString.a);
      }
      i += 1;
    }
    return arrayOfLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.core.event.l
 * JD-Core Version:    0.7.0.1
 */
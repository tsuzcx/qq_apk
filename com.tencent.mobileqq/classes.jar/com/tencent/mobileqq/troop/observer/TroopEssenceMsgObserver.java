package com.tencent.mobileqq.troop.observer;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.essence.data.TroopCardEssenceMsg;
import java.util.ArrayList;
import java.util.List;

public class TroopEssenceMsgObserver
  implements BusinessObserver
{
  private static int a;
  public static final int b;
  public static final int c;
  public static final int d;
  public static final int e;
  public static final int f;
  public static final int g;
  
  static
  {
    int i = a;
    a = i + 1;
    b = i;
    i = a;
    a = i + 1;
    c = i;
    i = a;
    a = i + 1;
    d = i;
    i = a;
    a = i + 1;
    e = i;
    i = a;
    a = i + 1;
    f = i;
    i = a;
    a = i + 1;
    g = i;
  }
  
  private void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != b) {
      return;
    }
    if ((paramObject != null) && ((paramObject instanceof Object[])))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length == 4)
      {
        a(paramBoolean, paramObject[0], paramObject[1], ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue());
        return;
      }
      a(false, null, null, -1, 0);
      return;
    }
    a(false, null, null, -1, 0);
  }
  
  private void b(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != c) {
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length == 4)
      {
        a(paramBoolean, ((Long)paramObject[0]).longValue(), paramObject[1], paramObject[2], ((Integer)paramObject[3]).intValue());
        return;
      }
      a(false, 0L, null, null, -1);
      return;
    }
    a(false, 0L, null, null, -1);
  }
  
  private void c(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != d) {
      return;
    }
    if (paramObject != null)
    {
      Object[] arrayOfObject = (Object[])paramObject;
      if (arrayOfObject.length == 4)
      {
        paramObject = null;
        if ((arrayOfObject[0] instanceof String)) {
          paramObject = (String)arrayOfObject[0];
        }
        if ((arrayOfObject[1] instanceof Integer)) {
          paramInt = ((Integer)arrayOfObject[1]).intValue();
        } else {
          paramInt = 0;
        }
        Object localObject = new ArrayList();
        if ((arrayOfObject[2] instanceof List)) {
          localObject = (List)arrayOfObject[2];
        }
        int i;
        if ((arrayOfObject[3] instanceof Integer)) {
          i = ((Integer)arrayOfObject[3]).intValue();
        } else {
          i = 0;
        }
        a(paramBoolean, paramObject, paramInt, (List)localObject, i);
        return;
      }
      a(false, null, 0, null, 0);
      return;
    }
    a(false, null, 0, null, 0);
  }
  
  private void d(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != e) {
      return;
    }
    Object localObject = null;
    boolean bool = false;
    if (paramObject != null)
    {
      Object[] arrayOfObject = (Object[])paramObject;
      if (arrayOfObject.length == 2)
      {
        paramObject = localObject;
        if ((arrayOfObject[0] instanceof String)) {
          paramObject = (String)arrayOfObject[0];
        }
        if ((arrayOfObject[1] instanceof Boolean)) {
          bool = ((Boolean)arrayOfObject[1]).booleanValue();
        }
        a(paramBoolean, paramObject, bool);
      }
    }
    else
    {
      a(paramBoolean, null, false);
    }
  }
  
  private void e(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != f) {
      return;
    }
    TroopInfo localTroopInfo = null;
    if (paramObject != null)
    {
      Object[] arrayOfObject = (Object[])paramObject;
      if (arrayOfObject.length == 2)
      {
        if ((arrayOfObject[0] instanceof String)) {
          paramObject = (String)arrayOfObject[0];
        } else {
          paramObject = null;
        }
        if ((arrayOfObject[1] instanceof TroopInfo)) {
          localTroopInfo = (TroopInfo)arrayOfObject[1];
        }
        a(paramBoolean, paramObject, localTroopInfo);
      }
    }
    else
    {
      a(paramBoolean, null, null);
    }
  }
  
  private void f(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != g) {
      return;
    }
    if ((paramObject instanceof Long)) {
      a(((Long)paramObject).longValue());
    }
  }
  
  protected void a(long paramLong) {}
  
  protected void a(boolean paramBoolean, long paramLong, Object paramObject1, Object paramObject2, int paramInt) {}
  
  protected void a(boolean paramBoolean, Object paramObject1, Object paramObject2, int paramInt1, int paramInt2) {}
  
  protected void a(boolean paramBoolean, String paramString, int paramInt1, List<TroopCardEssenceMsg> paramList, int paramInt2) {}
  
  protected void a(boolean paramBoolean, String paramString, TroopInfo paramTroopInfo) {}
  
  protected void a(boolean paramBoolean1, String paramString, boolean paramBoolean2) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    a(paramInt, paramBoolean, paramObject);
    b(paramInt, paramBoolean, paramObject);
    c(paramInt, paramBoolean, paramObject);
    d(paramInt, paramBoolean, paramObject);
    e(paramInt, paramBoolean, paramObject);
    f(paramInt, paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.observer.TroopEssenceMsgObserver
 * JD-Core Version:    0.7.0.1
 */
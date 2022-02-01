package com.tencent.mobileqq.troop.observer;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.troop.api.essence.data.TroopCardEssenceMsg;
import com.tencent.mobileqq.troop.utils.TroopApiConstants;
import java.util.ArrayList;
import java.util.List;

public class TroopApiObserver
  implements BusinessObserver
{
  private void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopApiConstants.a) {
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
    if (paramInt != TroopApiConstants.b) {
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
    Object localObject = null;
    if (paramInt != TroopApiConstants.c) {
      return;
    }
    Object[] arrayOfObject;
    if (paramObject != null)
    {
      arrayOfObject = (Object[])paramObject;
      if (arrayOfObject.length == 4)
      {
        paramObject = localObject;
        if ((arrayOfObject[0] instanceof String)) {
          paramObject = (String)arrayOfObject[0];
        }
        if (!(arrayOfObject[1] instanceof Integer)) {
          break label161;
        }
      }
    }
    label161:
    for (paramInt = ((Integer)arrayOfObject[1]).intValue();; paramInt = 0)
    {
      localObject = new ArrayList();
      if ((arrayOfObject[2] instanceof List)) {
        localObject = (List)arrayOfObject[2];
      }
      if ((arrayOfObject[3] instanceof Integer)) {}
      for (int i = ((Integer)arrayOfObject[3]).intValue();; i = 0)
      {
        a(paramBoolean, paramObject, paramInt, (List)localObject, i);
        return;
        a(false, null, 0, null, 0);
        return;
        a(false, null, 0, null, 0);
        return;
      }
    }
  }
  
  private void d(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopApiConstants.d) {}
    Object[] arrayOfObject;
    do
    {
      return;
      if (paramObject == null) {
        break;
      }
      arrayOfObject = (Object[])paramObject;
    } while (arrayOfObject.length != 2);
    if ((arrayOfObject[0] instanceof String)) {}
    for (paramObject = (String)arrayOfObject[0];; paramObject = null)
    {
      if ((arrayOfObject[1] instanceof Boolean)) {}
      for (boolean bool = ((Boolean)arrayOfObject[1]).booleanValue();; bool = false)
      {
        a(paramBoolean, paramObject, bool);
        return;
        a(paramBoolean, null, false);
        return;
      }
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong, Object paramObject1, Object paramObject2, int paramInt) {}
  
  protected void a(boolean paramBoolean, Object paramObject1, Object paramObject2, int paramInt1, int paramInt2) {}
  
  protected void a(boolean paramBoolean, String paramString, int paramInt1, List<TroopCardEssenceMsg> paramList, int paramInt2) {}
  
  protected void a(boolean paramBoolean1, String paramString, boolean paramBoolean2) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    a(paramInt, paramBoolean, paramObject);
    b(paramInt, paramBoolean, paramObject);
    c(paramInt, paramBoolean, paramObject);
    d(paramInt, paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.observer.TroopApiObserver
 * JD-Core Version:    0.7.0.1
 */
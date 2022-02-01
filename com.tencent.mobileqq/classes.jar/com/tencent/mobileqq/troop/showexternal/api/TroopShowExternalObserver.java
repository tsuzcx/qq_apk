package com.tencent.mobileqq.troop.showexternal.api;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.troop.data.ShowExternalTroop;
import java.util.List;

public class TroopShowExternalObserver
  implements BusinessObserver
{
  public static final int a;
  public static final int b;
  public static final int c;
  private static int d;
  
  static
  {
    int i = d;
    d = i + 1;
    a = i;
    i = d;
    d = i + 1;
    b = i;
    i = d;
    d = i + 1;
    c = i;
  }
  
  private void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != b) {
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      a(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue());
    }
  }
  
  private void b(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != c) {
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      a(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue());
    }
  }
  
  private void c(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != a) {
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      paramInt = ((Integer)paramObject[0]).intValue();
      List localList = (List)paramObject[1];
      if (paramObject.length >= 3)
      {
        a(paramBoolean, paramInt, localList, (List)paramObject[2]);
        return;
      }
      a(paramBoolean, paramInt, localList, null);
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt, List<ShowExternalTroop> paramList, List<String> paramList1) {}
  
  protected void a(boolean paramBoolean, String paramString, int paramInt1, int paramInt2) {}
  
  protected void a(boolean paramBoolean, String paramString, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    a(paramInt, paramBoolean, paramObject);
    b(paramInt, paramBoolean, paramObject);
    c(paramInt, paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.showexternal.api.TroopShowExternalObserver
 * JD-Core Version:    0.7.0.1
 */
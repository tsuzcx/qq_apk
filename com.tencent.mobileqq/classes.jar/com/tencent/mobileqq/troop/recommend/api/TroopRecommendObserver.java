package com.tencent.mobileqq.troop.recommend.api;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.troop.recommend.data.RecommendTroopItem;
import java.util.ArrayList;

public class TroopRecommendObserver
  implements BusinessObserver
{
  public static final int a;
  public static final int b;
  public static final int c;
  public static final int d;
  public static final int e;
  private static int f;
  
  static
  {
    int i = f;
    f = i + 1;
    a = i;
    i = f;
    f = i + 1;
    b = i;
    i = f;
    f = i + 1;
    c = i;
    i = f;
    f = i + 1;
    d = i;
    i = f;
    f = i + 1;
    e = i;
  }
  
  private void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != c) {
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      long l = ((Long)paramObject[0]).longValue();
      paramInt = ((Integer)paramObject[1]).intValue();
      int i = ((Integer)paramObject[2]).intValue();
      paramObject = (ArrayList)paramObject[3];
      boolean bool;
      if (i == 1) {
        bool = true;
      } else {
        bool = false;
      }
      a(paramBoolean, l, paramInt, bool, paramObject);
    }
  }
  
  private void b(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != b) {
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      paramInt = ((Integer)paramObject[0]).intValue();
      String str = (String)paramObject[1];
      int i = ((Integer)paramObject[2]).intValue();
      int j = ((Integer)paramObject[3]).intValue();
      ArrayList localArrayList = (ArrayList)paramObject[4];
      boolean bool2 = ((Boolean)paramObject[5]).booleanValue();
      boolean bool1;
      if (j == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      a(paramBoolean, paramInt, str, i, bool1, localArrayList, bool2);
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
      int i = ((Integer)paramObject[1]).intValue();
      int j = ((Integer)paramObject[2]).intValue();
      ArrayList localArrayList = (ArrayList)paramObject[3];
      boolean bool2 = ((Boolean)paramObject[4]).booleanValue();
      boolean bool1;
      if (j == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      a(paramBoolean, paramInt, i, bool1, localArrayList, bool2);
    }
  }
  
  private void d(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != d) {
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length >= 5) {
        a(paramBoolean, (String)paramObject[0], paramObject[1], (byte[])paramObject[2], ((Boolean)paramObject[3]).booleanValue(), (String)paramObject[4]);
      }
    }
  }
  
  private void e(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != e) {
      return;
    }
    if ((paramObject instanceof Object[])) {
      a(paramBoolean, ((Object[])(Object[])paramObject)[0]);
    }
  }
  
  protected void a(boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2, ArrayList<RecommendTroopItem> paramArrayList, boolean paramBoolean3) {}
  
  protected void a(boolean paramBoolean1, int paramInt1, String paramString, int paramInt2, boolean paramBoolean2, ArrayList<RecommendTroopItem> paramArrayList, boolean paramBoolean3) {}
  
  protected void a(boolean paramBoolean1, long paramLong, int paramInt, boolean paramBoolean2, ArrayList<RecommendTroopItem> paramArrayList) {}
  
  protected void a(boolean paramBoolean, Object paramObject) {}
  
  protected void a(boolean paramBoolean1, String paramString1, Object paramObject, byte[] paramArrayOfByte, boolean paramBoolean2, String paramString2) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    a(paramInt, paramBoolean, paramObject);
    b(paramInt, paramBoolean, paramObject);
    c(paramInt, paramBoolean, paramObject);
    d(paramInt, paramBoolean, paramObject);
    e(paramInt, paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.recommend.api.TroopRecommendObserver
 * JD-Core Version:    0.7.0.1
 */
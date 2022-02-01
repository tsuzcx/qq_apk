package com.tencent.mobileqq.troop.robot.api;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.troop.robot.TroopRobotData;
import com.tencent.mobileqq.troop.robot.TroopRobotInfo;
import java.util.ArrayList;

public class TroopRobotObserver
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
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length >= 2) {
        a(paramBoolean, (String)paramObject[0], ((Boolean)paramObject[1]).booleanValue());
      }
    }
  }
  
  private void b(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != d) {
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length >= 4)
      {
        paramInt = ((Integer)paramObject[3]).intValue();
        if (paramInt == 0)
        {
          b(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue());
          return;
        }
        if (paramInt == 1) {
          a(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue());
        }
      }
    }
  }
  
  private void c(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != c) {
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length >= 3) {
        a(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Long)paramObject[1]).longValue(), (TroopRobotData)paramObject[2]);
      }
    }
  }
  
  private void d(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != e) {
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length >= 3) {
        a(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Long)paramObject[1]).longValue(), (ArrayList)paramObject[2]);
      }
    }
  }
  
  private void e(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != f) {
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      Object localObject = (Object[])paramObject;
      if (localObject.length >= 4)
      {
        paramObject = (Boolean)localObject[0];
        String str1 = (String)localObject[1];
        String str2 = (String)localObject[2];
        localObject = (String)localObject[3];
        if (paramObject.booleanValue())
        {
          b(str1, str2, (String)localObject);
          return;
        }
        a(str1, str2, (String)localObject);
      }
    }
  }
  
  private void f(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != g) {
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length >= 2)
      {
        a(paramBoolean, ((Long)paramObject[0]).longValue(), (ArrayList)paramObject[1]);
        return;
      }
      a(false, 0L, null);
      return;
    }
    a(false, 0L, null);
  }
  
  protected void a(String paramString1, String paramString2, String paramString3) {}
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong1, long paramLong2) {}
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, TroopRobotData paramTroopRobotData) {}
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, ArrayList<TroopRobotInfo> paramArrayList) {}
  
  protected void a(boolean paramBoolean, long paramLong, ArrayList<String> paramArrayList) {}
  
  protected void a(boolean paramBoolean1, String paramString, boolean paramBoolean2) {}
  
  protected void b(String paramString1, String paramString2, String paramString3) {}
  
  protected void b(boolean paramBoolean, int paramInt, long paramLong1, long paramLong2) {}
  
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
 * Qualified Name:     com.tencent.mobileqq.troop.robot.api.TroopRobotObserver
 * JD-Core Version:    0.7.0.1
 */
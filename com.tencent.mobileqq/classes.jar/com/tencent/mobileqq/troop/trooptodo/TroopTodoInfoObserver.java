package com.tencent.mobileqq.troop.trooptodo;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0xf8e.oidb_0xf8e.InfoValue;
import tencent.im.oidb.cmd0xf8e.oidb_0xf8e.UserNode;

public class TroopTodoInfoObserver
  implements BusinessObserver
{
  private static int a;
  public static final int b;
  public static final int c;
  
  static
  {
    int i = a;
    a = i + 1;
    b = i;
    i = a;
    a = i + 1;
    c = i;
  }
  
  private void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != b) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onUpdateTodoInfoDetail] invoke, type = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", isSuccess = ");
    localStringBuilder.append(paramBoolean);
    QLog.i("TroopTodoInfoObserver-TodoInfo", 2, localStringBuilder.toString());
    localStringBuilder = null;
    paramInt = -1;
    int i;
    if ((paramBoolean) && ((paramObject instanceof Object[])))
    {
      Object[] arrayOfObject = (Object[])paramObject;
      if (arrayOfObject.length <= 3)
      {
        if ((arrayOfObject[2] instanceof Integer)) {
          i = ((Integer)arrayOfObject[2]).intValue();
        } else {
          i = 0;
        }
        if ((arrayOfObject[1] instanceof Integer)) {
          paramInt = ((Integer)arrayOfObject[1]).intValue();
        }
        paramObject = localStringBuilder;
        if ((arrayOfObject[0] instanceof oidb_0xf8e.InfoValue)) {
          paramObject = (oidb_0xf8e.InfoValue)arrayOfObject[0];
        }
        a(0, paramObject, paramInt, i);
      }
    }
    else if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length <= 2)
      {
        if ((paramObject[1] instanceof Integer)) {
          i = ((Integer)paramObject[1]).intValue();
        } else {
          i = 0;
        }
        if ((paramObject[0] instanceof Integer)) {
          paramInt = ((Integer)paramObject[0]).intValue();
        }
        a(paramInt, null, 0, i);
      }
    }
  }
  
  private void b(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != c) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onUpdateTodoInfoList] invoke, type = ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(", isSuccess = ");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.i("TroopTodoInfoObserver-TodoInfo", 2, ((StringBuilder)localObject).toString());
    long l = 0L;
    int i;
    if ((paramBoolean) && ((paramObject instanceof Object[])))
    {
      localObject = new ArrayList();
      paramObject = (Object[])paramObject;
      if (paramObject.length <= 4)
      {
        if ((paramObject[3] instanceof Long)) {
          l = ((Long)paramObject[3]).longValue();
        }
        if ((paramObject[2] instanceof Integer)) {
          paramInt = ((Integer)paramObject[2]).intValue();
        } else {
          paramInt = 0;
        }
        if ((paramObject[1] instanceof Integer)) {
          i = ((Integer)paramObject[1]).intValue();
        } else {
          i = -1;
        }
        if ((paramObject[0] instanceof List)) {
          ((List)localObject).addAll((List)paramObject[0]);
        }
        a(0, (List)localObject, i, paramInt, l);
      }
    }
    else if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length <= 3)
      {
        if ((paramObject[2] instanceof Long)) {
          l = ((Long)paramObject[2]).longValue();
        }
        if ((paramObject[1] instanceof Integer)) {
          paramInt = ((Integer)paramObject[1]).intValue();
        } else {
          paramInt = 0;
        }
        if ((paramObject[0] instanceof Integer)) {
          i = ((Integer)paramObject[0]).intValue();
        } else {
          i = -1;
        }
        a(i, null, 0, paramInt, l);
      }
    }
  }
  
  public void a(int paramInt1, List<oidb_0xf8e.UserNode> paramList, int paramInt2, int paramInt3, long paramLong) {}
  
  public void a(int paramInt1, oidb_0xf8e.InfoValue paramInfoValue, int paramInt2, int paramInt3) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    a(paramInt, paramBoolean, paramObject);
    b(paramInt, paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.trooptodo.TroopTodoInfoObserver
 * JD-Core Version:    0.7.0.1
 */
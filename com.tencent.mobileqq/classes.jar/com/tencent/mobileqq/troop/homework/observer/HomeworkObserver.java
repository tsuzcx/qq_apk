package com.tencent.mobileqq.troop.homework.observer;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.troop.homework.HomeworkInfo;
import tencent.im.troop.homework.ReqSend1V1Msg;
import tencent.im.troop.homework.RspSend1V1Msg;

public class HomeworkObserver
  implements BusinessObserver
{
  private static int a;
  public static final int b;
  public static final int c;
  public static final int d;
  public static final int e;
  public static final int f;
  
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
  }
  
  private void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != c) {
      return;
    }
    long l1 = -1L;
    boolean bool = paramObject instanceof Object[];
    int i = 0;
    long l2 = l1;
    paramInt = i;
    if (bool)
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length > 0) {
        l1 = ((Long)paramObject[0]).longValue();
      }
      l2 = l1;
      paramInt = i;
      if (paramObject.length > 1)
      {
        paramInt = ((Integer)paramObject[1]).intValue();
        l2 = l1;
      }
    }
    a(paramBoolean, l2, paramInt);
  }
  
  private void b(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != b) {
      return;
    }
    paramObject = (Object[])paramObject;
    a(paramBoolean, (String)paramObject[0], (String)paramObject[1], ((Integer)paramObject[2]).intValue(), (String)paramObject[3], (String)paramObject[4]);
  }
  
  private void c(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != d) {
      return;
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      localObject1 = localObject2;
      if (paramObject.length > 0) {
        localObject1 = (HomeworkInfo)paramObject[0];
      }
    }
    a(paramBoolean, (HomeworkInfo)localObject1);
  }
  
  private void d(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != e) {
      return;
    }
    int i = 0;
    paramInt = i;
    if (paramObject != null)
    {
      paramInt = i;
      if ((paramObject instanceof Integer)) {
        paramInt = ((Integer)paramObject).intValue();
      }
    }
    a(paramBoolean, paramInt);
  }
  
  private void e(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != f) {
      return;
    }
    paramObject = (Object[])paramObject;
    a(paramBoolean, (homework.RspSend1V1Msg)paramObject[0], (homework.ReqSend1V1Msg)paramObject[1]);
  }
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void a(boolean paramBoolean, long paramLong, int paramInt) {}
  
  public void a(boolean paramBoolean, HomeworkInfo paramHomeworkInfo) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4) {}
  
  protected void a(boolean paramBoolean, homework.RspSend1V1Msg paramRspSend1V1Msg, homework.ReqSend1V1Msg paramReqSend1V1Msg) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    a(paramInt, paramBoolean, paramObject);
    b(paramInt, paramBoolean, paramObject);
    c(paramInt, paramBoolean, paramObject);
    d(paramInt, paramBoolean, paramObject);
    e(paramInt, paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.observer.HomeworkObserver
 * JD-Core Version:    0.7.0.1
 */
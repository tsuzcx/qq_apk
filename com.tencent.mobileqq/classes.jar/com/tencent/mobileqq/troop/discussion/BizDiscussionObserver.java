package com.tencent.mobileqq.troop.discussion;

import com.tencent.qphone.base.util.QLog;

public class BizDiscussionObserver
  implements IDiscussionObserver
{
  private void a(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      String str = (String)paramObject[0];
      boolean bool2 = ((Boolean)paramObject[1]).booleanValue();
      int i = ((Integer)paramObject[2]).intValue();
      int j = ((Integer)paramObject[3]).intValue();
      boolean bool1;
      if (paramObject.length >= 5) {
        bool1 = ((Boolean)paramObject[4]).booleanValue();
      } else {
        bool1 = false;
      }
      a(paramBoolean, str, bool2, i, j, bool1);
    }
  }
  
  protected void a(boolean paramBoolean, Long paramLong) {}
  
  protected void a(boolean paramBoolean, Long paramLong1, Long paramLong2) {}
  
  protected void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, int paramInt1, int paramInt2, boolean paramBoolean3) {}
  
  protected void b(boolean paramBoolean, Long paramLong) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Discussion DiscussObserver onUpdate type");
      localStringBuilder.append(paramInt);
      QLog.d("Discussion", 2, localStringBuilder.toString());
    }
    switch (paramInt)
    {
    default: 
      return;
    case 1018: 
      a(paramBoolean, paramObject);
      return;
    case 1017: 
      b(paramBoolean, (Long)paramObject);
      return;
    case 1016: 
      a(paramBoolean, (Long)paramObject);
      return;
    }
    paramObject = (long[])paramObject;
    a(paramBoolean, Long.valueOf(paramObject[0]), Long.valueOf(paramObject[1]));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.discussion.BizDiscussionObserver
 * JD-Core Version:    0.7.0.1
 */
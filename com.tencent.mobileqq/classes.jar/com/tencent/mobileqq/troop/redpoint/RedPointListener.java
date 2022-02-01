package com.tencent.mobileqq.troop.redpoint;

import android.view.View;
import java.util.HashSet;

public class RedPointListener
  implements BaseRedPointListener
{
  private void a(Object paramObject)
  {
    if (paramObject != null)
    {
      paramObject = (Object[])paramObject;
      if ((paramObject.length == 4) && ((paramObject[0] instanceof String)) && ((paramObject[1] instanceof String)) && ((paramObject[2] instanceof RedPointInfo)) && ((paramObject[3] instanceof HashSet))) {
        a((String)paramObject[0], (String)paramObject[1], (RedPointInfo)paramObject[2], (HashSet)paramObject[3]);
      }
    }
  }
  
  private void b(Object paramObject)
  {
    if (paramObject != null)
    {
      paramObject = (Object[])paramObject;
      if ((paramObject.length == 3) && ((paramObject[0] instanceof String)) && ((paramObject[1] instanceof String)) && ((paramObject[2] instanceof View))) {
        a((String)paramObject[0], (String)paramObject[1], (View)paramObject[2]);
      }
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return;
      }
      b(paramObject);
      return;
    }
    a(paramObject);
  }
  
  protected void a(String paramString1, String paramString2, View paramView) {}
  
  protected void a(String paramString1, String paramString2, RedPointInfo paramRedPointInfo, HashSet<Integer> paramHashSet) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.redpoint.RedPointListener
 * JD-Core Version:    0.7.0.1
 */
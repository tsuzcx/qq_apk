package com.tencent.mobileqq.friends.intimate;

import com.tencent.mobileqq.activity.contact.troop.TroopList;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.IntimateInfo;
import java.util.ArrayList;
import java.util.HashMap;

public class IntimateInfoObserver
  implements BusinessObserver
{
  protected void a(boolean paramBoolean, int paramInt, ArrayList<TroopList> paramArrayList) {}
  
  protected void a(boolean paramBoolean, long paramLong) {}
  
  protected void a(boolean paramBoolean, long paramLong, ArrayList<Long> paramArrayList) {}
  
  protected void a(boolean paramBoolean, String paramString) {}
  
  protected void a(boolean paramBoolean, String paramString, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void a(boolean paramBoolean, String paramString, IntimateInfo paramIntimateInfo) {}
  
  protected void a(boolean paramBoolean1, String paramString, boolean paramBoolean2) {}
  
  protected void a(boolean paramBoolean, HashMap<Long, IntimateInfo> paramHashMap, Object paramObject) {}
  
  protected void a(boolean paramBoolean, Object[] paramArrayOfObject) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
    case 8: 
      if ((paramObject instanceof Object[]))
      {
        paramObject = (Object[])paramObject;
        a(paramBoolean, ((Integer)paramObject[0]).intValue(), (ArrayList)paramObject[1]);
        return;
      }
      break;
    case 7: 
      if ((paramObject instanceof Object[]))
      {
        paramObject = (Object[])paramObject;
        if (paramObject.length >= 2)
        {
          a(paramBoolean, (HashMap)paramObject[0], paramObject[1]);
          return;
        }
      }
      break;
    case 6: 
      if ((paramObject instanceof Object[]))
      {
        paramObject = (Object[])paramObject;
        if (paramObject.length >= 1)
        {
          a(paramBoolean, ((Long)paramObject[0]).longValue());
          return;
        }
      }
      break;
    case 5: 
      if ((paramObject instanceof Object[]))
      {
        paramObject = (Object[])paramObject;
        if (paramObject.length >= 2)
        {
          a(paramBoolean, ((Long)paramObject[0]).longValue(), (ArrayList)paramObject[1]);
          return;
        }
      }
      break;
    case 4: 
      if ((paramBoolean) && ((paramObject instanceof Object[])))
      {
        a(paramBoolean, (Object[])paramObject);
        return;
      }
      a(false, null);
      return;
    case 3: 
      if ((paramObject instanceof Object[]))
      {
        paramObject = (Object[])paramObject;
        a(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue());
        return;
      }
      a(false, "", -1, -1, -1);
      return;
    case 2: 
      if ((paramObject instanceof Object[]))
      {
        a(paramBoolean, (String)((Object[])(Object[])paramObject)[0]);
        return;
      }
      a(false, "");
      return;
    case 1: 
      if ((paramObject instanceof Object[]))
      {
        paramObject = (Object[])paramObject;
        a(paramBoolean, (String)paramObject[0], ((Boolean)paramObject[1]).booleanValue());
        return;
      }
      a(paramBoolean, "", false);
      return;
    case 0: 
      if ((paramObject instanceof Object[]))
      {
        paramObject = (Object[])paramObject;
        a(paramBoolean, (String)paramObject[0], (IntimateInfo)paramObject[1]);
        return;
      }
      a(false, "", null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.friends.intimate.IntimateInfoObserver
 * JD-Core Version:    0.7.0.1
 */
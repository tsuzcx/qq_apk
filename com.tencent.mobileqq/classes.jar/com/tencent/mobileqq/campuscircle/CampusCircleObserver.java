package com.tencent.mobileqq.campuscircle;

import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.Card;
import java.util.List;

public class CampusCircleObserver
  implements BusinessObserver
{
  public void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2, CampusCircleManager.CampusTopicReq paramCampusTopicReq) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, List paramList) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle, Card paramCard) {}
  
  public void a(boolean paramBoolean, Card paramCard) {}
  
  public void a(boolean paramBoolean, List paramList1, List paramList2, List paramList3, List paramList4) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      paramObject = (Object[])paramObject;
      a(paramBoolean, (List)paramObject[0], (List)paramObject[1], (List)paramObject[2], (List)paramObject[3]);
      return;
    case 2: 
      paramObject = (Object[])paramObject;
      if ((paramObject != null) && (paramObject.length >= 4))
      {
        a(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1], (String)paramObject[2], (CampusCircleManager.CampusTopicReq)paramObject[3]);
        return;
      }
      a(false, 1, "", "", null);
      return;
    case 3: 
      paramObject = (Object[])paramObject;
      a(paramBoolean, (Bundle)paramObject[0], (Card)paramObject[1]);
      return;
    case 4: 
      a(paramBoolean, (Card)paramObject);
      return;
    }
    paramObject = (Object[])paramObject;
    a(paramBoolean, ((Long)paramObject[0]).longValue(), (String)paramObject[1], (List)paramObject[2]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.campuscircle.CampusCircleObserver
 * JD-Core Version:    0.7.0.1
 */
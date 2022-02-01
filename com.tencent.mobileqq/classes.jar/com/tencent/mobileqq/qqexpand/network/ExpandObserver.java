package com.tencent.mobileqq.qqexpand.network;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.qqexpand.bean.feed.StrangerInfo;
import com.tencent.mobileqq.qqexpand.bean.match.MatchFeedInfo;
import com.tencent.mobileqq.qqexpand.bean.match.MatchInfo;
import com.tencent.mobileqq.qqexpand.bean.match.TagInfo;
import java.util.ArrayList;
import java.util.List;

public class ExpandObserver
  implements BusinessObserver
{
  protected void a(int paramInt) {}
  
  protected void a(boolean paramBoolean) {}
  
  protected void a(boolean paramBoolean, int paramInt) {}
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2, MatchInfo paramMatchInfo, int paramInt3) {}
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2, MatchInfo paramMatchInfo, String paramString) {}
  
  protected void a(boolean paramBoolean, int paramInt, MatchInfo paramMatchInfo) {}
  
  protected void a(boolean paramBoolean, int paramInt, MatchInfo paramMatchInfo, String paramString) {}
  
  protected void a(boolean paramBoolean1, long paramLong, String paramString, boolean paramBoolean2, byte[] paramArrayOfByte, boolean paramBoolean3, boolean paramBoolean4, int paramInt, List<StrangerInfo> paramList, MatchFeedInfo paramMatchFeedInfo) {}
  
  protected void a(boolean paramBoolean, Card paramCard) {}
  
  protected void a(boolean paramBoolean, Card paramCard, int paramInt) {}
  
  protected void a(boolean paramBoolean, StrangerInfo paramStrangerInfo, int paramInt) {}
  
  protected void a(boolean paramBoolean, MatchInfo paramMatchInfo) {}
  
  protected void a(boolean paramBoolean, Object paramObject) {}
  
  protected void a(boolean paramBoolean, Object paramObject, int paramInt) {}
  
  protected void a(boolean paramBoolean, String paramString) {}
  
  protected void a(boolean paramBoolean1, String paramString, int paramInt, boolean paramBoolean2) {}
  
  protected void a(boolean paramBoolean1, ArrayList<TagInfo> paramArrayList, boolean paramBoolean2, int paramInt, ArrayList<String> paramArrayList1, boolean paramBoolean3) {}
  
  protected void a(boolean paramBoolean, List<Long> paramList1, int paramInt, List<Long> paramList2) {}
  
  protected void b(boolean paramBoolean) {}
  
  protected void b(boolean paramBoolean, Object paramObject) {}
  
  protected void c(boolean paramBoolean) {}
  
  protected void c(boolean paramBoolean, Object paramObject) {}
  
  protected void d(boolean paramBoolean) {}
  
  protected void d(boolean paramBoolean, Object paramObject) {}
  
  protected void e(boolean paramBoolean) {}
  
  protected void f(boolean paramBoolean) {}
  
  protected void g(boolean paramBoolean) {}
  
  protected void h(boolean paramBoolean) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    int i = -1;
    switch (paramInt)
    {
    case 4: 
    case 24: 
    case 25: 
    case 27: 
    case 29: 
    default: 
    case 34: 
      c(paramBoolean);
      return;
    case 33: 
      a(paramBoolean, paramObject, 33);
      return;
    case 32: 
      a(paramBoolean, paramObject, 32);
      return;
    case 31: 
      b(paramBoolean, paramObject);
      return;
    case 30: 
      a(paramBoolean, paramObject);
      return;
    case 28: 
      h(paramBoolean);
      return;
    case 26: 
      if ((paramObject instanceof Object[]))
      {
        paramObject = (Object[])paramObject;
        if (paramObject.length == 3)
        {
          a(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), ((Boolean)paramObject[2]).booleanValue());
          return;
        }
      }
      break;
    case 23: 
      if ((paramObject instanceof Object[]))
      {
        paramObject = (Object[])paramObject;
        if (paramObject.length > 0)
        {
          a(paramBoolean, (String)paramObject[0]);
          return;
        }
      }
      break;
    case 22: 
      d(paramBoolean, paramObject);
      return;
    case 21: 
      c(paramBoolean, paramObject);
      return;
    case 20: 
      paramInt = i;
      if (paramObject != null)
      {
        paramInt = i;
        if ((paramObject instanceof Object[]))
        {
          paramObject = (Object[])paramObject;
          paramInt = i;
          if (paramObject != null)
          {
            paramInt = i;
            if (paramObject.length > 0) {
              paramInt = ((Integer)paramObject[0]).intValue();
            }
          }
        }
      }
      a(paramBoolean, paramInt);
      return;
    case 19: 
      if ((paramObject instanceof Object[]))
      {
        paramObject = (Object[])paramObject;
        ArrayList localArrayList = (ArrayList)paramObject[0];
        List localList = (List)paramObject[2];
        a(paramBoolean, localArrayList, ((Integer)paramObject[1]).intValue(), localList);
        return;
      }
      break;
    case 18: 
      b(paramBoolean);
      return;
    case 17: 
      a(((Integer)paramObject).intValue());
      return;
    case 16: 
      if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof Object[])))
      {
        paramObject = (Object[])paramObject;
        if ((paramObject != null) && (paramObject.length == 1))
        {
          a(paramBoolean, (MatchInfo)paramObject[0]);
          return;
        }
        a(false, null);
        return;
      }
      a(false, null);
      return;
    case 15: 
      if (paramBoolean)
      {
        if ((paramObject != null) && ((paramObject instanceof Object[])))
        {
          paramObject = (Object[])paramObject;
          if ((paramObject != null) && (paramObject.length == 4))
          {
            a(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Integer)paramObject[2]).intValue(), (MatchInfo)paramObject[1], (String)paramObject[3]);
            return;
          }
          a(false, -1, -1, null, null);
          return;
        }
        a(false, -1, -1, null, null);
        return;
      }
      a(false, -1, -1, null, null);
      return;
    case 14: 
      d(paramBoolean);
      return;
    case 13: 
      if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof Object[])))
      {
        paramObject = (Object[])paramObject;
        if ((paramObject != null) && (paramObject.length == 5))
        {
          a(true, (ArrayList)paramObject[0], ((Boolean)paramObject[1]).booleanValue(), ((Integer)paramObject[2]).intValue(), (ArrayList)paramObject[3], ((Boolean)paramObject[4]).booleanValue());
          return;
        }
        a(false, null, true, 0, null, false);
        return;
      }
      a(false, null, true, 0, null, false);
      return;
    case 12: 
      g(paramBoolean);
      return;
    case 11: 
      if (paramBoolean)
      {
        if ((paramObject != null) && ((paramObject instanceof Object[])))
        {
          paramObject = (Object[])paramObject;
          if ((paramObject != null) && (paramObject.length == 4))
          {
            a(paramBoolean, ((Integer)paramObject[0]).intValue(), (MatchInfo)paramObject[1], (String)paramObject[3]);
            return;
          }
          a(false, -1, null, null);
          return;
        }
        a(false, -1, null, null);
        return;
      }
      a(false, -1, null, null);
      return;
    case 9: 
      paramObject = (Object[])paramObject;
      a(paramBoolean, (StrangerInfo)paramObject[0], ((Integer)paramObject[1]).intValue());
      return;
    case 8: 
      f(((Boolean)paramObject).booleanValue());
      return;
    case 7: 
      if ((paramObject instanceof Object[]))
      {
        paramObject = (Object[])paramObject;
        if ((paramObject != null) && (paramObject.length == 2))
        {
          a(paramBoolean, ((Integer)paramObject[0]).intValue(), (MatchInfo)paramObject[1]);
          return;
        }
        a(false, -1, null);
        return;
      }
      a(paramBoolean, -1, null);
      return;
    case 6: 
      if ((paramObject instanceof Object[]))
      {
        paramObject = (Object[])paramObject;
        if (paramObject.length == 4)
        {
          a(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Integer)paramObject[1]).intValue(), (MatchInfo)paramObject[2], ((Integer)paramObject[3]).intValue());
          return;
        }
        a(paramBoolean, -1, -1, null, -1);
        return;
      }
      a(paramBoolean, -1, -1, null, -1);
      return;
    case 5: 
      a(((Boolean)paramObject).booleanValue());
      return;
    case 3: 
      paramObject = (Object[])paramObject;
      a(paramBoolean, (Card)paramObject[0]);
      a(paramBoolean, (Card)paramObject[0], ((Integer)paramObject[1]).intValue());
      return;
    case 2: 
      if ((paramObject != null) && ((paramObject instanceof Object[])))
      {
        paramObject = (Object[])paramObject;
        if ((paramBoolean) && (paramObject.length == 9))
        {
          a(true, ((Long)paramObject[0]).longValue(), (String)paramObject[1], ((Boolean)paramObject[2]).booleanValue(), (byte[])paramObject[3], ((Boolean)paramObject[4]).booleanValue(), ((Boolean)paramObject[5]).booleanValue(), ((Integer)paramObject[6]).intValue(), (List)paramObject[7], (MatchFeedInfo)paramObject[8]);
          return;
        }
        if ((!paramBoolean) && (paramObject.length == 2))
        {
          a(false, ((Long)paramObject[0]).longValue(), (String)paramObject[1], false, null, false, false, 0, null, null);
          return;
        }
      }
      break;
    case 1: 
      e(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.network.ExpandObserver
 * JD-Core Version:    0.7.0.1
 */
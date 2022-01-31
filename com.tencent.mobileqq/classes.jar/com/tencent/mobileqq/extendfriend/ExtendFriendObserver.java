package com.tencent.mobileqq.extendfriend;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.Card;
import com.tencent.pb.extendfriend.ExtendFriendSquareInfo.RspBody;
import java.util.List;

public class ExtendFriendObserver
  implements BusinessObserver
{
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, Card paramCard) {}
  
  public void a(boolean paramBoolean, ExtendFriendSquareInfo.RspBody paramRspBody) {}
  
  public void a(boolean paramBoolean1, List paramList, boolean paramBoolean2, long paramLong, boolean paramBoolean3) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      a(paramBoolean);
      return;
    case 2: 
      if ((paramObject == null) || (!(paramObject instanceof ExtendFriendSquareInfo.RspBody))) {
        break;
      }
    }
    for (paramObject = (ExtendFriendSquareInfo.RspBody)paramObject;; paramObject = null)
    {
      a(paramBoolean, paramObject);
      return;
      a(paramBoolean, (Card)paramObject);
      return;
      if ((paramObject == null) || (!(paramObject instanceof Object[]))) {
        break;
      }
      paramObject = (Object[])paramObject;
      a(paramBoolean, (List)paramObject[0], ((Boolean)paramObject[1]).booleanValue(), ((Long)paramObject[2]).longValue(), ((Boolean)paramObject[3]).booleanValue());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.ExtendFriendObserver
 * JD-Core Version:    0.7.0.1
 */
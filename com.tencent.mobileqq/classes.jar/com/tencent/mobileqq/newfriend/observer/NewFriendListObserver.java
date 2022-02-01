package com.tencent.mobileqq.newfriend.observer;

import android.os.Bundle;
import com.tencent.mobileqq.friend.observer.IFriendObserver;

public class NewFriendListObserver
  implements IFriendObserver
{
  protected void a(String paramString) {}
  
  protected void a(String paramString, boolean paramBoolean) {}
  
  protected void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void a(boolean paramBoolean, Bundle paramBundle) {}
  
  protected void a(boolean paramBoolean, Object paramObject) {}
  
  protected void a(boolean paramBoolean, String paramString) {}
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, byte paramByte) {}
  
  public void a(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if ((paramBoolean) && (paramArrayOfObject != null) && (paramArrayOfObject.length == 1)) {
      b((String)paramArrayOfObject[0]);
    }
  }
  
  public void b(String paramString) {}
  
  protected void b(boolean paramBoolean) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == 27)
    {
      if (!(paramObject instanceof Object[])) {
        return;
      }
      paramObject = (Object[])paramObject;
      a(paramBoolean, (String)paramObject[0], (String)paramObject[1], ((Byte)paramObject[2]).byteValue());
      return;
    }
    if (paramInt == 3)
    {
      a((String)paramObject, paramBoolean);
      return;
    }
    if (paramInt == 62)
    {
      if ((paramBoolean) && ((paramObject instanceof String))) {
        a((String)paramObject);
      }
    }
    else if (paramInt == 121)
    {
      if (!(paramObject instanceof Object[])) {
        return;
      }
      paramObject = (Object[])paramObject;
      if (paramObject.length > 1) {
        a(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Integer)paramObject[1]).intValue());
      }
    }
    else
    {
      if (paramInt == 15)
      {
        a(paramBoolean, paramObject);
        return;
      }
      if (paramInt == 106)
      {
        a(paramBoolean);
        return;
      }
      if (paramInt == 105)
      {
        b(paramBoolean);
        return;
      }
      if (paramInt == 91)
      {
        a(paramBoolean, (String)paramObject);
        return;
      }
      if (paramInt == 90)
      {
        if ((paramObject instanceof Bundle))
        {
          a(paramBoolean, (Bundle)paramObject);
          return;
        }
        a(paramBoolean, null);
        return;
      }
      if (paramInt == 129)
      {
        if (!(paramObject instanceof Object[])) {
          return;
        }
        paramObject = (Object[])paramObject;
        if (paramObject.length > 2) {
          a(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue());
        }
      }
      else if (paramInt == 130)
      {
        if (!(paramObject instanceof Object[])) {
          return;
        }
        a(paramBoolean, (Object[])paramObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.observer.NewFriendListObserver
 * JD-Core Version:    0.7.0.1
 */
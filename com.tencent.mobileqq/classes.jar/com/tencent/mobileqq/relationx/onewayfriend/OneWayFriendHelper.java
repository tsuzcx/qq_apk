package com.tencent.mobileqq.relationx.onewayfriend;

import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

public class OneWayFriendHelper
{
  private QQAppInterface a;
  private int b;
  private String c;
  private OneWayFriendHelper.OneWayFriendListener d;
  private OneWayFriendObserver e = new OneWayFriendHelper.1(this);
  
  public OneWayFriendHelper(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OneWayFriendHelper", 0, String.format("OneWayFriendHelper app=%s curType=%s friendUin=%s", new Object[] { paramQQAppInterface, Integer.valueOf(paramInt), paramString }));
    }
    this.a = paramQQAppInterface;
    this.b = paramInt;
    this.c = paramString;
    this.a.addObserver(this.e);
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OneWayFriendHelper", 0, String.format("notifyOneWayFriend friendUin=%s oneWayFriend=%s", new Object[] { paramString, Boolean.valueOf(paramBoolean) }));
    }
    OneWayFriendHelper.OneWayFriendListener localOneWayFriendListener = this.d;
    if (localOneWayFriendListener != null) {
      localOneWayFriendListener.a(paramString, paramBoolean);
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    paramQQAppInterface = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    return (paramInt == 0) && (!paramQQAppInterface.n(paramString));
  }
  
  public void a()
  {
    if (a(this.a, this.b, this.c))
    {
      OneWayFriendHandler localOneWayFriendHandler = (OneWayFriendHandler)this.a.getBusinessHandler(BusinessHandlerFactory.ONE_WAY_FRIEND_HANDLER);
      if (localOneWayFriendHandler != null) {
        localOneWayFriendHandler.a(Long.parseLong(this.c));
      }
    }
    else
    {
      a(this.c, false);
    }
  }
  
  public void a(OneWayFriendHelper.OneWayFriendListener paramOneWayFriendListener)
  {
    this.d = paramOneWayFriendListener;
  }
  
  public void b()
  {
    this.d = null;
    this.a.removeObserver(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.onewayfriend.OneWayFriendHelper
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.troop.api.troopmemberlist.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.relationx.addFrd.AddFrdStateMng;
import com.tencent.mobileqq.troop.api.troopmemberlist.IAddFrdStateMngProxy;

public class AddFrdStateMngProxy
  implements IAddFrdStateMngProxy
{
  private AddFrdStateMng a;
  
  public AddFrdStateMngProxy(QQAppInterface paramQQAppInterface)
  {
    this.a = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a();
  }
  
  public int a(String paramString, AppInterface paramAppInterface)
  {
    return this.a.a(paramString, (QQAppInterface)paramAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.troopmemberlist.impl.AddFrdStateMngProxy
 * JD-Core Version:    0.7.0.1
 */
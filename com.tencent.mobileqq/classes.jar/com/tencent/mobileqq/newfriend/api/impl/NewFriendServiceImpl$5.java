package com.tencent.mobileqq.newfriend.api.impl;

import com.tencent.mobileqq.newfriend.interfaces.INewFriendListener;
import com.tencent.mobileqq.phonecontact.listener.IPhoneContactListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;

class NewFriendServiceImpl$5
  implements IPhoneContactListener
{
  NewFriendServiceImpl$5(NewFriendServiceImpl paramNewFriendServiceImpl) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onBindStateChanged = ");
      localStringBuilder.append(paramInt);
      QLog.d("NEW_FRD.NewFriendServiceImpl", 2, localStringBuilder.toString());
    }
    this.a.getUnreadMessageCountAsync();
  }
  
  public void a(long paramLong) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRecommendCountChanged = ");
      localStringBuilder.append(paramInt);
      QLog.d("NEW_FRD.NewFriendServiceImpl", 2, localStringBuilder.toString());
    }
    this.a.getUnreadMessageCountAsync();
  }
  
  public void b(int paramInt) {}
  
  public void c(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("onUpdateContactList = ");
      ((StringBuilder)???).append(paramInt);
      QLog.d("NEW_FRD.NewFriendServiceImpl", 2, ((StringBuilder)???).toString());
    }
    if ((paramInt & 0x1) != 0) {
      synchronized (NewFriendServiceImpl.access$100(this.a))
      {
        Iterator localIterator = NewFriendServiceImpl.access$100(this.a).iterator();
        while (localIterator.hasNext()) {
          ((INewFriendListener)localIterator.next()).b();
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.api.impl.NewFriendServiceImpl.5
 * JD-Core Version:    0.7.0.1
 */
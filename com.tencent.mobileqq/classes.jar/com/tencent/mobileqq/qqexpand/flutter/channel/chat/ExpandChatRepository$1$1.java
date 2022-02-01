package com.tencent.mobileqq.qqexpand.flutter.channel.chat;

import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class ExpandChatRepository$1$1
  implements Runnable
{
  ExpandChatRepository$1$1(ExpandChatRepository.1 param1, int paramInt, List paramList1, List paramList2) {}
  
  public void run()
  {
    Object localObject3;
    Object localObject4;
    if (!ExpandChatRepository.a(this.d.a).contains(Integer.valueOf(this.a)))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onGetExtendFriendOnlineState not mine req:");
        ((StringBuilder)localObject1).append(this.a);
        QLog.d("expand.chat.ExpandChatRepository", 1, ((StringBuilder)localObject1).toString());
      }
      localObject1 = new HashSet(ExpandChatRepository.b(this.d.a));
      localObject2 = new ArrayList();
      localObject3 = this.b.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (Long)((Iterator)localObject3).next();
        if (!((Set)localObject1).contains(localObject4)) {
          ((List)localObject2).add(localObject4);
        }
      }
      ExpandChatRepository.b(this.d.a).addAll((Collection)localObject2);
    }
    else
    {
      ExpandChatRepository.b(this.d.a).clear();
      ExpandChatRepository.b(this.d.a).addAll(this.b);
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onGetExtendFriendOnlineState cached list size=");
    ((StringBuilder)localObject1).append(ExpandChatRepository.b(this.d.a).size());
    QLog.i("expand.chat.ExpandChatRepository", 1, ((StringBuilder)localObject1).toString());
    localObject1 = new ArrayList();
    Object localObject2 = this.c.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject4 = (Long)((Iterator)localObject2).next();
      localObject3 = new OnlineStateInfo();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localObject4);
      localStringBuilder.append("");
      ((OnlineStateInfo)localObject3).uin = localStringBuilder.toString();
      ((OnlineStateInfo)localObject3).online = this.b.contains(localObject4);
      ((List)localObject1).add(localObject3);
      if ((((OnlineStateInfo)localObject3).online) && (QLog.isColorLevel()))
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("notifyOnlineState  ");
        ((StringBuilder)localObject4).append(MsfSdkUtils.getShortUin(((OnlineStateInfo)localObject3).uin));
        QLog.d("expand.chat.ExpandChatRepository", 1, ((StringBuilder)localObject4).toString());
      }
    }
    ExpandChatRepository.a(this.d.a, (List)localObject1, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.channel.chat.ExpandChatRepository.1.1
 * JD-Core Version:    0.7.0.1
 */
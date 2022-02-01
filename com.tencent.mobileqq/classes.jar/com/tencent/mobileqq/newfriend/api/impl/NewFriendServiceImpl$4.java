package com.tencent.mobileqq.newfriend.api.impl;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.newfriend.msg.FriendSystemMessage;
import com.tencent.mobileqq.newfriend.msg.NewFriendMessage;
import com.tencent.mobileqq.newfriend.observer.NewFriendListObserver;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import java.util.ArrayList;
import java.util.Iterator;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

class NewFriendServiceImpl$4
  extends NewFriendListObserver
{
  NewFriendServiceImpl$4(NewFriendServiceImpl paramNewFriendServiceImpl) {}
  
  protected void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject1 = this.a.getMixedNewFriendDatas();
    if (!((ArrayList)localObject1).isEmpty())
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (NewFriendMessage)((Iterator)localObject1).next();
        if ((localObject2 instanceof FriendSystemMessage))
        {
          localObject2 = (FriendSystemMessage)localObject2;
          int i = ((FriendSystemMessage)localObject2).a.structMsg.msg.sub_type.get();
          String str = ((FriendSystemMessage)localObject2).a.senderuin;
          if ((i == 13) && (paramString.equals(str)))
          {
            ((Iterator)localObject1).remove();
            ((IMessageFacade)this.a.mApp.getRuntimeService(IMessageFacade.class, "")).removeMsgByUniseq(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0, ((FriendSystemMessage)localObject2).a.uniseq, false);
          }
        }
      }
      NewFriendServiceImpl.access$000(this.a).sendEmptyMessage(2);
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (NewFriendServiceImpl.access$000(this.a) != null)) {
      NewFriendServiceImpl.access$000(this.a).sendEmptyMessage(2);
    }
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (NewFriendServiceImpl.access$000(this.a) != null)) {
      NewFriendServiceImpl.access$000(this.a).sendEmptyMessage(2);
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (NewFriendServiceImpl.access$000(this.a) != null)) {
      NewFriendServiceImpl.access$000(this.a).sendEmptyMessage(2);
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    this.a.mApp.runOnUiThread(new NewFriendServiceImpl.4.1(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.api.impl.NewFriendServiceImpl.4
 * JD-Core Version:    0.7.0.1
 */
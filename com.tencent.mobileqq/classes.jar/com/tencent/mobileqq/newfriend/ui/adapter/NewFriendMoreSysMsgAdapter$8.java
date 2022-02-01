package com.tencent.mobileqq.newfriend.ui.adapter;

import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.newfriend.msg.FriendSystemMessage;
import com.tencent.mobileqq.newfriend.msg.NewFriendMessage;
import com.tencent.mobileqq.newfriend.observer.NewFriendListObserver;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

class NewFriendMoreSysMsgAdapter$8
  extends NewFriendListObserver
{
  NewFriendMoreSysMsgAdapter$8(NewFriendMoreSysMsgAdapter paramNewFriendMoreSysMsgAdapter) {}
  
  protected void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ArrayList localArrayList = (ArrayList)NewFriendMoreSysMsgAdapter.l(this.a).clone();
    if (!localArrayList.isEmpty())
    {
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (NewFriendMessage)localIterator.next();
        if ((localObject instanceof FriendSystemMessage))
        {
          localObject = (FriendSystemMessage)localObject;
          int i = ((FriendSystemMessage)localObject).a.structMsg.msg.sub_type.get();
          localObject = ((FriendSystemMessage)localObject).a.senderuin;
          if ((i == 13) && (paramString.equals(localObject))) {
            localIterator.remove();
          }
        }
      }
      NewFriendMoreSysMsgAdapter.a(this.a, localArrayList);
      this.a.notifyDataSetChanged();
    }
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.a.notifyDataSetChanged();
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onSuspiciousGetUnreadNum ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.i("NewFriendMoreSysMsgAdapter", 2, ((StringBuilder)localObject).toString());
    }
    if ((NewFriendMoreSysMsgAdapter.m(this.a) != null) && (NewFriendMoreSysMsgAdapter.m(this.a).getVisibility() == 0))
    {
      if ((paramBoolean) && (paramInt2 > 0))
      {
        localObject = NewFriendMoreSysMsgAdapter.m(this.a);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramInt2);
        localStringBuilder.append("");
        ((TextView)localObject).setText(localStringBuilder.toString());
        return;
      }
      NewFriendMoreSysMsgAdapter.m(this.a).setText("");
    }
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if (paramBoolean) {
      this.a.notifyDataSetChanged();
    }
  }
  
  public void b(String paramString)
  {
    NewFriendMoreSysMsgAdapter.k(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.adapter.NewFriendMoreSysMsgAdapter.8
 * JD-Core Version:    0.7.0.1
 */
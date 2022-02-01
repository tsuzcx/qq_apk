package com.tencent.mobileqq.newfriend.ui.adapter;

import com.tencent.mobileqq.activity.contact.connections.TabLayoutStatus;
import com.tencent.mobileqq.newfriend.api.impl.NewFriendServiceImpl;
import com.tencent.mobileqq.newfriend.msg.MayKnowMessage;
import com.tencent.mobileqq.newfriend.msg.NewFriendMessage;
import com.tencent.mobileqq.newfriend.msg.NewFriendTabInfoMessage;
import com.tencent.mobileqq.newfriend.ui.builder.MayKnowRecommendBuilder;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendTabInfoBuilder;
import com.tencent.mobileqq.newfriend.ui.view.SystemMsgListView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

class SystemMsgListAdapter$1$1
  implements Runnable
{
  SystemMsgListAdapter$1$1(SystemMsgListAdapter.1 param1, ArrayList paramArrayList) {}
  
  public void run()
  {
    SystemMsgListAdapter.b(this.b.this$0).clear();
    SystemMsgListAdapter.c(this.b.this$0).clear();
    Iterator localIterator = this.a.iterator();
    boolean bool1 = false;
    int i = 0;
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (NewFriendMessage)localIterator.next();
      int j;
      boolean bool2;
      if ((localObject instanceof MayKnowMessage))
      {
        localObject = new MayKnowRecommendBuilder(SystemMsgListAdapter.d(this.b.this$0), SystemMsgListAdapter.e(this.b.this$0), this.b.this$0, (NewFriendMessage)localObject, SystemMsgListAdapter.f(this.b.this$0));
        ((MayKnowRecommendBuilder)localObject).a(i);
        j = i + 1;
        bool2 = bool1;
      }
      else if ((localObject instanceof NewFriendTabInfoMessage))
      {
        localObject = new NewFriendTabInfoBuilder(SystemMsgListAdapter.d(this.b.this$0), SystemMsgListAdapter.e(this.b.this$0), this.b.this$0, (NewFriendMessage)localObject);
        bool2 = true;
        j = i;
      }
      else
      {
        localObject = SystemMsgListAdapter.a(this.b.this$0, (NewFriendMessage)localObject, this.b.a);
        j = i;
        bool2 = bool1;
      }
      bool1 = bool2;
      i = j;
      if (localObject != null)
      {
        SystemMsgListAdapter.c(this.b.this$0).add(localObject);
        bool1 = bool2;
        i = j;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("hasMayKnowData = ");
      ((StringBuilder)localObject).append(bool1);
      ((StringBuilder)localObject).append("mCurrentTabLayoutStatus =");
      ((StringBuilder)localObject).append(SystemMsgListAdapter.g(this.b.this$0));
      ((StringBuilder)localObject).append("， recommendPos =");
      ((StringBuilder)localObject).append(i);
      QLog.d("SystemMsgListAdapter", 2, ((StringBuilder)localObject).toString());
    }
    if (bool1)
    {
      SystemMsgListAdapter.g(this.b.this$0).b();
      SystemMsgListAdapter.a(this.b.this$0, i, this.b.a);
    }
    else
    {
      SystemMsgListAdapter.g(this.b.this$0).c();
    }
    this.b.this$0.e.j();
    this.b.this$0.notifyDataSetChanged();
    if (SystemMsgListAdapter.h(this.b.this$0))
    {
      if ((SystemMsgListAdapter.f(this.b.this$0) == 2) && (SystemMsgListAdapter.a(this.b.this$0).getUnreadSystemMessageCount() == 0) && (SystemMsgListAdapter.a(this.b.this$0).getAllUnreadMessageCount() > 0) && (SystemMsgListAdapter.a(this.b.this$0).getRceommendShowCount() >= 3))
      {
        i = SystemMsgListAdapter.a(this.b.this$0).getRecommendSubTitleIndex();
        this.b.this$0.e.setSelection(i);
      }
      SystemMsgListAdapter.a(this.b.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListAdapter.1.1
 * JD-Core Version:    0.7.0.1
 */
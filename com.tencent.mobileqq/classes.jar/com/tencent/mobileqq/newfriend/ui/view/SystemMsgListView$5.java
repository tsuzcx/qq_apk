package com.tencent.mobileqq.newfriend.ui.view;

import android.os.Bundle;
import com.tencent.mobileqq.activity.contact.connections.TabLayoutStatus;
import com.tencent.mobileqq.newfriend.observer.NewFriendListObserver;
import com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListAdapter;
import com.tencent.qphone.base.util.QLog;

class SystemMsgListView$5
  extends NewFriendListObserver
{
  SystemMsgListView$5(SystemMsgListView paramSystemMsgListView) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGetConnectionsPerson ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.i("Q.newfriendSystemMsgListView", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean)
    {
      localObject = SystemMsgListView.a(this.a).o();
      if ((localObject != null) && (((TabLayoutStatus)localObject).a()) && (((TabLayoutStatus)localObject).a == paramInt2) && (!SystemMsgListView.a(this.a, paramInt2, paramInt3))) {
        SystemMsgListView.a(this.a).a(0L);
      }
    }
    else if (paramInt1 == 1205)
    {
      SystemMsgListView.a(this.a).a(0L);
    }
  }
  
  protected void a(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onGetMayKnowRecommend ");
      paramBundle.append(paramBoolean);
      QLog.i("Q.newfriendSystemMsgListView", 2, paramBundle.toString());
    }
    if (paramBoolean) {
      SystemMsgListView.a(this.a).c();
    }
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if (paramBoolean) {
      SystemMsgListView.a(this.a).c();
    }
  }
  
  public void b(String paramString)
  {
    if (SystemMsgListView.a(this.a) != null) {
      SystemMsgListView.a(this.a).c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.view.SystemMsgListView.5
 * JD-Core Version:    0.7.0.1
 */
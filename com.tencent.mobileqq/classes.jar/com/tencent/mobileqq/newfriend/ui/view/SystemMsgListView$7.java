package com.tencent.mobileqq.newfriend.ui.view;

import android.app.Activity;
import com.tencent.mobileqq.newfriend.observer.NewFriendVerificationObserver;
import com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListAdapter;

class SystemMsgListView$7
  extends NewFriendVerificationObserver
{
  SystemMsgListView$7(SystemMsgListView paramSystemMsgListView) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, boolean paramBoolean4)
  {
    if (((Activity)SystemMsgListView.b(this.a)).isFinishing()) {
      return;
    }
    if ((paramBoolean1) && (SystemMsgListView.a(this.a) != null)) {
      SystemMsgListView.a(this.a).c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.view.SystemMsgListView.7
 * JD-Core Version:    0.7.0.1
 */
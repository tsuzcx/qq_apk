package com.tencent.mobileqq.newfriend.ui.adapter;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.newfriend.api.impl.NewFriendServiceImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class SystemMsgListAdapter$1
  implements Runnable
{
  SystemMsgListAdapter$1(SystemMsgListAdapter paramSystemMsgListAdapter, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("MSG_FRESH_DATA refreshDataInner tabId = ");
      ((StringBuilder)localObject).append(this.a);
      QLog.e("SystemMsgListAdapter", 2, ((StringBuilder)localObject).toString());
    }
    SystemMsgListAdapter.a(this.this$0).loadNewFriendMsg(true, this.a);
    Object localObject = SystemMsgListAdapter.a(this.this$0).getMixedNewFriendDatas();
    SystemMsgListAdapter.a(this.this$0).runOnUiThread(new SystemMsgListAdapter.1.1(this, (ArrayList)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListAdapter.1
 * JD-Core Version:    0.7.0.1
 */
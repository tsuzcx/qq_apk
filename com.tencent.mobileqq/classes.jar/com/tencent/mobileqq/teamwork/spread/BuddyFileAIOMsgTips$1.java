package com.tencent.mobileqq.teamwork.spread;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class BuddyFileAIOMsgTips$1
  implements Runnable
{
  BuddyFileAIOMsgTips$1(BuddyFileAIOMsgTips paramBuddyFileAIOMsgTips, BaseTimAIOTipsProcessor.ListResult paramListResult) {}
  
  public void run()
  {
    Object localObject = this.this$0.a.getFileManagerProxy().a(this.this$0.b);
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      ThreadManager.post(new BuddyFileAIOMsgTips.1.1(this, (List)localObject), 8, null, true);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("current AIO has not File,peerType[");
      ((StringBuilder)localObject).append(this.this$0.c);
      ((StringBuilder)localObject).append("]");
      QLog.i("BuddyFileAIOMsgTips", 1, ((StringBuilder)localObject).toString());
    }
    this.a.a(new ArrayList());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.spread.BuddyFileAIOMsgTips.1
 * JD-Core Version:    0.7.0.1
 */
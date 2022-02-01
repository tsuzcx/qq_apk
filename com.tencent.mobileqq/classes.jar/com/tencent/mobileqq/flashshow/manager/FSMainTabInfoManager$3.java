package com.tencent.mobileqq.flashshow.manager;

import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class FSMainTabInfoManager$3
  implements Runnable
{
  FSMainTabInfoManager$3(FSMainTabInfoManager paramFSMainTabInfoManager, int paramInt, List paramList) {}
  
  public void run()
  {
    FSMainTabInfoManager.a(this.this$0).put("new", Integer.valueOf(this.a));
    FSMainTabInfoManager.b(this.this$0).put("new", this.b);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b.size());
    localStringBuilder.append(",jumpTabType:");
    localStringBuilder.append(this.a);
    QLog.d("FSMainTabInfoManager", 1, new Object[] { "initNewTabInfo done,size:", localStringBuilder.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.manager.FSMainTabInfoManager.3
 * JD-Core Version:    0.7.0.1
 */
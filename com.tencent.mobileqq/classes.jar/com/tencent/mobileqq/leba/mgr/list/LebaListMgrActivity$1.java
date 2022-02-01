package com.tencent.mobileqq.leba.mgr.list;

import com.tencent.mobileqq.leba.core.LebaShowListManager;
import java.util.List;
import mqq.app.AppRuntime;

class LebaListMgrActivity$1
  implements Runnable
{
  LebaListMgrActivity$1(LebaListMgrActivity paramLebaListMgrActivity) {}
  
  public void run()
  {
    Object localObject = this.this$0.getAppRuntime();
    LebaShowListManager.a().b((AppRuntime)localObject);
    localObject = LebaShowListManager.a().a();
    this.this$0.runOnUiThread(new LebaListMgrActivity.1.1(this, (List)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.mgr.list.LebaListMgrActivity.1
 * JD-Core Version:    0.7.0.1
 */
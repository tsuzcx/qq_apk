package com.tencent.mobileqq.teamworkforgroup;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;

class GroupTeamWorkListActivity$3
  implements Runnable
{
  GroupTeamWorkListActivity$3(GroupTeamWorkListActivity paramGroupTeamWorkListActivity) {}
  
  public void run()
  {
    IWebProcessManagerService localIWebProcessManagerService = (IWebProcessManagerService)this.this$0.app.getRuntimeService(IWebProcessManagerService.class, "");
    if ((localIWebProcessManagerService != null) && (localIWebProcessManagerService.isNeedPreloadWebProcess())) {
      localIWebProcessManagerService.startWebProcess(101, new GroupTeamWorkListActivity.3.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkListActivity.3
 * JD-Core Version:    0.7.0.1
 */
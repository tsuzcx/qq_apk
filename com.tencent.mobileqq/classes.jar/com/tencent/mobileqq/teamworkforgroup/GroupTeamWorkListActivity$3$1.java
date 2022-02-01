package com.tencent.mobileqq.teamworkforgroup;

import com.tencent.mobileqq.webview.util.WebProcessStartListener;
import com.tencent.qphone.base.util.QLog;

class GroupTeamWorkListActivity$3$1
  implements WebProcessStartListener
{
  GroupTeamWorkListActivity$3$1(GroupTeamWorkListActivity.3 param3) {}
  
  public void onResult(boolean paramBoolean)
  {
    if ((paramBoolean) && (QLog.isColorLevel())) {
      QLog.i("Tag_webView", 1, "Web_qqbrowser_web TeamWorkList preloadWebProcess success! ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkListActivity.3.1
 * JD-Core Version:    0.7.0.1
 */
package cooperation.qzone.contentbox;

import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.data.RecentUser;

class QZoneMsgFragment$3
  implements Runnable
{
  QZoneMsgFragment$3(QZoneMsgFragment paramQZoneMsgFragment) {}
  
  public void run()
  {
    RecentUser localRecentUser = new RecentUser("2290230341", 1008);
    RecentUtil.a(this.this$0.app, localRecentUser, true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.contentbox.QZoneMsgFragment.3
 * JD-Core Version:    0.7.0.1
 */
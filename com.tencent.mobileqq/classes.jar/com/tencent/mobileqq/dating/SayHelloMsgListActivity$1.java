package com.tencent.mobileqq.dating;

import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentSayHelloListItem;
import com.tencent.mobileqq.nearby.NearbyRelevantObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

class SayHelloMsgListActivity$1
  extends NearbyRelevantObserver
{
  SayHelloMsgListActivity$1(SayHelloMsgListActivity paramSayHelloMsgListActivity) {}
  
  public void a(boolean paramBoolean, List<Object> paramList)
  {
    if (paramBoolean)
    {
      localObject = paramList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        FansEntity localFansEntity = (FansEntity)((Iterator)localObject).next();
        RecentBaseData localRecentBaseData = (RecentBaseData)this.a.mMsgItemCache.get(String.valueOf(localFansEntity.uin));
        if ((localRecentBaseData != null) && ((localRecentBaseData instanceof RecentSayHelloListItem))) {
          ((RecentSayHelloListItem)localRecentBaseData).a(localFansEntity);
        }
      }
      ReportController.b(this.a.app, "dc00899", "grp_lbs", "", "c2c_tmp", "exp_hi_list", 0, 0, "", "", "", "");
    }
    Object localObject = this.a.mRefreshHandler;
    int i = 0;
    if (localObject != null)
    {
      this.a.mRefreshHandler.removeMessages(0);
      this.a.mRefreshHandler.sendEmptyMessage(0);
    }
    if (QLog.isDevelopLevel())
    {
      if (paramList != null) {
        i = paramList.size();
      }
      paramList = new StringBuilder();
      paramList.append("get tags, size is ");
      paramList.append(i);
      QLog.d("Q.msg_box", 4, paramList.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.SayHelloMsgListActivity.1
 * JD-Core Version:    0.7.0.1
 */
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
  
  public void a(boolean paramBoolean, List<FansEntity> paramList)
  {
    int i = 0;
    if (paramBoolean)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        FansEntity localFansEntity = (FansEntity)localIterator.next();
        RecentBaseData localRecentBaseData = (RecentBaseData)this.a.jdField_a_of_type_JavaUtilMap.get(String.valueOf(localFansEntity.uin));
        if ((localRecentBaseData != null) && ((localRecentBaseData instanceof RecentSayHelloListItem))) {
          ((RecentSayHelloListItem)localRecentBaseData).a(localFansEntity);
        }
      }
      ReportController.b(this.a.app, "dc00899", "grp_lbs", "", "c2c_tmp", "exp_hi_list", 0, 0, "", "", "", "");
    }
    if (this.a.jdField_a_of_type_MqqOsMqqHandler != null)
    {
      this.a.jdField_a_of_type_MqqOsMqqHandler.removeMessages(0);
      this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(0);
    }
    if (QLog.isDevelopLevel()) {
      if (paramList != null) {
        break label187;
      }
    }
    for (;;)
    {
      QLog.d("Q.msg_box", 4, "get tags, size is " + i);
      return;
      label187:
      i = paramList.size();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.SayHelloMsgListActivity.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.flashshow.personal.widget;

import com.tencent.mobileqq.flashshow.api.data.DataBuilder;
import com.tencent.mobileqq.flashshow.report.dc.FSLpReportDc11001;
import com.tencent.mobileqq.flashshow.widgets.common.FSFollowView.FSFollowReportListener;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StUser;

class FSPersonalInfoWidget$1
  implements FSFollowView.FSFollowReportListener
{
  FSPersonalInfoWidget$1(FSPersonalInfoWidget paramFSPersonalInfoWidget) {}
  
  public void a(int paramInt)
  {
    if (FSPersonalInfoWidget.a(this.a) == null)
    {
      QLog.i("FSPersonalInfoWidget", 1, "mStUser is null");
      return;
    }
    FSLpReportDc11001.a(new DataBuilder(this.a.getReportBean()).setActionType(11).setSubActionType(3).setThrActionType(1).setToUin(FSPersonalInfoWidget.a(this.a).id.get()));
  }
  
  public void b(int paramInt)
  {
    if (FSPersonalInfoWidget.a(this.a) == null)
    {
      QLog.i("FSPersonalInfoWidget", 1, "mStUser is null");
      return;
    }
    FSLpReportDc11001.a(new DataBuilder(this.a.getReportBean()).setActionType(11).setSubActionType(3).setThrActionType(2).setToUin(FSPersonalInfoWidget.a(this.a).id.get()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.personal.widget.FSPersonalInfoWidget.1
 * JD-Core Version:    0.7.0.1
 */
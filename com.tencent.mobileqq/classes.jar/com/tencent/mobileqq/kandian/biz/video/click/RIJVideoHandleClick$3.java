package com.tencent.mobileqq.kandian.biz.video.click;

import android.app.Activity;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager.Builder;
import com.tencent.mobileqq.kandian.glue.video.report.RIJVideoReportManager;
import com.tencent.mobileqq.kandian.repo.account.IUserLevelCallBack;
import com.tencent.mobileqq.kandian.repo.account.UserLevelInfo;
import com.tencent.mobileqq.kandian.repo.biu.BiuBehaviour;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;

class RIJVideoHandleClick$3
  implements IUserLevelCallBack
{
  RIJVideoHandleClick$3(RIJVideoHandleClick paramRIJVideoHandleClick, AbsBaseArticleInfo paramAbsBaseArticleInfo) {}
  
  public void a(UserLevelInfo paramUserLevelInfo)
  {
    boolean bool;
    if (BiuBehaviour.b() == 1) {
      bool = true;
    } else {
      bool = false;
    }
    RIJVideoReportManager.a(true, bool, this.a, (Activity)RIJVideoHandleClick.b(this.b).a().A(), RIJVideoHandleClick.b(this.b).a().B(), RIJVideoHandleClick.b(this.b).a().y(), RIJVideoHandleClick.b(this.b).a().z());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.click.RIJVideoHandleClick.3
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.kandian.biz.video.click;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager.Builder;
import com.tencent.mobileqq.kandian.biz.framework.handlers.VideoHandler;
import com.tencent.mobileqq.kandian.glue.video.report.RIJVideoReportManager;
import com.tencent.mobileqq.kandian.repo.account.IUserLevelCallBack;
import com.tencent.mobileqq.kandian.repo.account.UserLevelInfo;
import com.tencent.mobileqq.kandian.repo.biu.BiuBehaviour;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;

class RIJVideoHandleClick$6$1
  implements IUserLevelCallBack
{
  RIJVideoHandleClick$6$1(RIJVideoHandleClick.6 param6, AbsBaseArticleInfo paramAbsBaseArticleInfo, View paramView) {}
  
  public void a(UserLevelInfo paramUserLevelInfo)
  {
    boolean bool;
    if (BiuBehaviour.a() == 1) {
      bool = true;
    } else {
      bool = false;
    }
    RIJVideoReportManager.a(false, bool, this.a, (Activity)RIJVideoHandleClick.b(this.c.a).a().A(), RIJVideoHandleClick.b(this.c.a).a().B(), RIJVideoHandleClick.b(this.c.a).a().y(), RIJVideoHandleClick.b(this.c.a).a().z());
    VideoHandler.b(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.click.RIJVideoHandleClick.6.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness;

import android.app.Activity;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqgamepub.mvp.view.buisness.IQQGameWebFeedView;
import com.tencent.mobileqq.qqgamepub.web.QQGameReportLogic;
import com.tencent.mobileqq.qroute.QRoute;

class QQGameWebPresenter$3
  implements Runnable
{
  QQGameWebPresenter$3(QQGameWebPresenter paramQQGameWebPresenter, Activity paramActivity) {}
  
  public void run()
  {
    if (this.this$0.c())
    {
      this.this$0.y().a(false, 0);
      ((IQQGameHelper)QRoute.api(IQQGameHelper.class)).enterAIO(this.a, true);
      this.this$0.r().c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameWebPresenter.3
 * JD-Core Version:    0.7.0.1
 */
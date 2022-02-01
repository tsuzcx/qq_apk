package com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness;

import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqgamepub.mvp.view.buisness.IQQGameHippyView;
import com.tencent.mobileqq.qqgamepub.web.QQGameReportLogic;
import com.tencent.mobileqq.qroute.QRoute;
import java.lang.ref.WeakReference;

class QQGameHippyPresenter$2
  implements Runnable
{
  QQGameHippyPresenter$2(QQGameHippyPresenter paramQQGameHippyPresenter) {}
  
  public void run()
  {
    if (!this.this$0.c()) {
      return;
    }
    ((IQQGameHippyView)QQGameHippyPresenter.b(this.this$0).get()).a(false, 0);
    ((IQQGameHelper)QRoute.api(IQQGameHelper.class)).enterAIO(this.this$0.r(), true);
    this.this$0.w().c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameHippyPresenter.2
 * JD-Core Version:    0.7.0.1
 */
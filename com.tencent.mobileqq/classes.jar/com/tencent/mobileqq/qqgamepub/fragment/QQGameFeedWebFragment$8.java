package com.tencent.mobileqq.qqgamepub.fragment;

import com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil;
import com.tencent.mobileqq.qqgamepub.mvp.model.bean.QQGameWebFeedModel;
import com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameWebPresenter;
import com.tencent.mobileqq.qqgamepub.web.delegate.QQGameWebViewDelegate;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.util.URLUtil;

class QQGameFeedWebFragment$8
  implements Runnable
{
  QQGameFeedWebFragment$8(QQGameFeedWebFragment paramQQGameFeedWebFragment) {}
  
  public void run()
  {
    String str = ((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).getFeedWebUrl();
    if (!URLUtil.e(str)) {
      return;
    }
    str = ((QQGameWebFeedModel)this.this$0.i().b()).a(str, this.this$0.g());
    this.this$0.b.a(str, this.this$0.j());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.fragment.QQGameFeedWebFragment.8
 * JD-Core Version:    0.7.0.1
 */
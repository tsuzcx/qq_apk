package com.tencent.mobileqq.qqgamepub.fragment;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqgamepub.data.GmpEnterInfoRsp;
import com.tencent.mobileqq.qroute.QRoute;

class QQGameFeedWebFragment$18
  implements Runnable
{
  QQGameFeedWebFragment$18(QQGameFeedWebFragment paramQQGameFeedWebFragment, GmpEnterInfoRsp paramGmpEnterInfoRsp) {}
  
  public void run()
  {
    if ((QQGameFeedWebFragment.a(this.this$0) != null) && (!QQGameFeedWebFragment.a(this.this$0).isFinishing()) && (this.this$0.isAdded())) {
      ((IQQGameHelper)QRoute.api(IQQGameHelper.class)).showGameEnterCacheInfo(this.this$0.a, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.fragment.QQGameFeedWebFragment.18
 * JD-Core Version:    0.7.0.1
 */
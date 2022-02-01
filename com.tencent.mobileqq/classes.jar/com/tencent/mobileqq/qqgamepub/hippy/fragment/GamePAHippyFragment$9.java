package com.tencent.mobileqq.qqgamepub.hippy.fragment;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqgamepub.data.GmpEnterInfoRsp;
import com.tencent.mobileqq.qroute.QRoute;

class GamePAHippyFragment$9
  implements Runnable
{
  GamePAHippyFragment$9(GamePAHippyFragment paramGamePAHippyFragment, GmpEnterInfoRsp paramGmpEnterInfoRsp) {}
  
  public void run()
  {
    if ((this.this$0.getQBaseActivity() != null) && (!this.this$0.getQBaseActivity().isFinishing()) && (this.this$0.isAdded())) {
      ((IQQGameHelper)QRoute.api(IQQGameHelper.class)).showGameEnterCacheInfo(GamePAHippyFragment.g(this.this$0), this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.hippy.fragment.GamePAHippyFragment.9
 * JD-Core Version:    0.7.0.1
 */
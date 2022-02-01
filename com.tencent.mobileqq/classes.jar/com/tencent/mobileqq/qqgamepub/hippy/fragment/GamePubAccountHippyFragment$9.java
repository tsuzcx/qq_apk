package com.tencent.mobileqq.qqgamepub.hippy.fragment;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqgamepub.data.GmpEnterInfoRsp;
import com.tencent.mobileqq.qroute.QRoute;

class GamePubAccountHippyFragment$9
  implements Runnable
{
  GamePubAccountHippyFragment$9(GamePubAccountHippyFragment paramGamePubAccountHippyFragment, GmpEnterInfoRsp paramGmpEnterInfoRsp) {}
  
  public void run()
  {
    if ((this.this$0.getQBaseActivity() != null) && (!this.this$0.getQBaseActivity().isFinishing()) && (this.this$0.isAdded())) {
      ((IQQGameHelper)QRoute.api(IQQGameHelper.class)).showGameEnterCacheInfo(GamePubAccountHippyFragment.a(this.this$0), this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.hippy.fragment.GamePubAccountHippyFragment.9
 * JD-Core Version:    0.7.0.1
 */
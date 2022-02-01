package com.tencent.mobileqq.qqgamepub.hippy.fragment;

import com.tencent.mobileqq.apollo.game.api.ICmGameHelper;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqgamepub.utils.GameCenterUtils;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.HashMap;
import java.util.Map;

class GamePubAccountHippyFragment$12
  implements Runnable
{
  GamePubAccountHippyFragment$12(GamePubAccountHippyFragment paramGamePubAccountHippyFragment) {}
  
  public void run()
  {
    GamePubAccountHippyFragment.a(this.this$0, false, 0);
    ((IQQGameHelper)QRoute.api(IQQGameHelper.class)).enterAIO(this.this$0.getQBaseActivity(), true);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(24), this.this$0.a());
    localHashMap.put(Integer.valueOf(4), "20");
    GameCenterUtils.a(((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface(), "769", "205036", "", "76901", "1", "160", localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.hippy.fragment.GamePubAccountHippyFragment.12
 * JD-Core Version:    0.7.0.1
 */
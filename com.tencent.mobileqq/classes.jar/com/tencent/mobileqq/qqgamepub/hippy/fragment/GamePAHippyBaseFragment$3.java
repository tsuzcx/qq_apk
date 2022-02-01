package com.tencent.mobileqq.qqgamepub.hippy.fragment;

import com.tencent.mobileqq.qqgamepub.api.IQQGameFlutterApi;
import com.tencent.mobileqq.qroute.QRoute;

class GamePAHippyBaseFragment$3
  implements Runnable
{
  GamePAHippyBaseFragment$3(GamePAHippyBaseFragment paramGamePAHippyBaseFragment) {}
  
  public void run()
  {
    ((IQQGameFlutterApi)QRoute.api(IQQGameFlutterApi.class)).preloadFlutter();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.hippy.fragment.GamePAHippyBaseFragment.3
 * JD-Core Version:    0.7.0.1
 */
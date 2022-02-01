package com.tencent.mobileqq.gamecenter.hippy;

import android.support.v4.app.FragmentActivity;
import com.tencent.mtt.hippy.HippyEngine.BackPressHandler;
import com.tencent.qphone.base.util.QLog;

class GamePAHippyBaseFragment$2
  implements HippyEngine.BackPressHandler
{
  GamePAHippyBaseFragment$2(GamePAHippyBaseFragment paramGamePAHippyBaseFragment) {}
  
  public void handleBackPress()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GamePAHippyBaseFragment", 1, "do Back Event,to finish");
    }
    FragmentActivity localFragmentActivity = this.a.getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.hippy.GamePAHippyBaseFragment.2
 * JD-Core Version:    0.7.0.1
 */
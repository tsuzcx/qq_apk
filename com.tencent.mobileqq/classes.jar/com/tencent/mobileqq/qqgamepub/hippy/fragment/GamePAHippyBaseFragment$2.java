package com.tencent.mobileqq.qqgamepub.hippy.fragment;

import android.app.Activity;
import com.tencent.mtt.hippy.HippyEngine.BackPressHandler;
import com.tencent.qphone.base.util.QLog;

class GamePAHippyBaseFragment$2
  implements HippyEngine.BackPressHandler
{
  GamePAHippyBaseFragment$2(GamePAHippyBaseFragment paramGamePAHippyBaseFragment, Activity paramActivity) {}
  
  public void handleBackPress()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GamePAHippyBaseFragment", 1, "do Back Event,to finish");
    }
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.hippy.fragment.GamePAHippyBaseFragment.2
 * JD-Core Version:    0.7.0.1
 */
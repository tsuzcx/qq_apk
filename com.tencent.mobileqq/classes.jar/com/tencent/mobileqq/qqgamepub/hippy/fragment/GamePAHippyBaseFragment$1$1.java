package com.tencent.mobileqq.qqgamepub.hippy.fragment;

import android.text.TextUtils;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.utils.IArkPubicEventWrap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class GamePAHippyBaseFragment$1$1
  implements Runnable
{
  GamePAHippyBaseFragment$1$1(GamePAHippyBaseFragment.1 param1, ArrayList paramArrayList) {}
  
  public void run()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      QQGameMsgInfo localQQGameMsgInfo = (QQGameMsgInfo)localIterator.next();
      if (!TextUtils.isEmpty(localQQGameMsgInfo.arkAppName))
      {
        ((IArkPubicEventWrap)QRoute.api(IArkPubicEventWrap.class)).addNotify(localQQGameMsgInfo.arkAppName);
        this.jdField_a_of_type_ComTencentMobileqqQqgamepubHippyFragmentGamePAHippyBaseFragment$1.a.b.add(localQQGameMsgInfo.arkAppName);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubHippyFragmentGamePAHippyBaseFragment$1.a.c(this.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.hippy.fragment.GamePAHippyBaseFragment.1.1
 * JD-Core Version:    0.7.0.1
 */
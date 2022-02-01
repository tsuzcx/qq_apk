package com.tencent.mobileqq.qqgamepub.fragment;

import com.tencent.mobileqq.qipc.QIPCClientHelper;
import java.util.ArrayList;

class QQGameFeedWebFragment$MessageQGameReceiver$1
  implements Runnable
{
  QQGameFeedWebFragment$MessageQGameReceiver$1(QQGameFeedWebFragment.MessageQGameReceiver paramMessageQGameReceiver, ArrayList paramArrayList) {}
  
  public void run()
  {
    try
    {
      QQGameFeedWebFragment.a(this.jdField_a_of_type_ComTencentMobileqqQqgamepubFragmentQQGameFeedWebFragment$MessageQGameReceiver.a, this.jdField_a_of_type_JavaUtilArrayList);
      QIPCClientHelper.getInstance().callServer("QQGameIPCModule", "clearUnreadMsg", null);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.fragment.QQGameFeedWebFragment.MessageQGameReceiver.1
 * JD-Core Version:    0.7.0.1
 */
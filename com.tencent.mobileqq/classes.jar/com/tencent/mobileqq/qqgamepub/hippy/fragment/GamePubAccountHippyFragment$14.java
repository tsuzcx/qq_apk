package com.tencent.mobileqq.qqgamepub.hippy.fragment;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.qqgamepub.hippy.view.GamePubAccountHeadView;
import com.tencent.mobileqq.qqgamepub.utils.UIUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

class GamePubAccountHippyFragment$14
  implements Runnable
{
  GamePubAccountHippyFragment$14(GamePubAccountHippyFragment paramGamePubAccountHippyFragment) {}
  
  public void run()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 3;
    localMessage.arg1 = -1;
    localMessage.arg2 = ((int)UIUtils.a(GamePubAccountHippyFragment.a(this.this$0).getHeight(), MobileQQ.sMobileQQ.getResources()));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("#### height:");
    localStringBuilder.append(localMessage.arg2);
    QLog.d("QQGamePub_GamePubAccountHippyFragment", 2, localStringBuilder.toString());
    GamePubAccountHippyFragment.a(this.this$0).sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.hippy.fragment.GamePubAccountHippyFragment.14
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.gamecenter.hippy;

import android.os.Handler;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.gamecenter.hippy.view.GamePubAccountHeadView;
import com.tencent.qphone.base.util.QLog;

class GamePubAccountHippyFragment$14
  implements Runnable
{
  GamePubAccountHippyFragment$14(GamePubAccountHippyFragment paramGamePubAccountHippyFragment) {}
  
  public void run()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 3;
    localMessage.arg1 = -1;
    localMessage.arg2 = ((int)AIOUtils.a(GamePubAccountHippyFragment.a(this.this$0).getHeight(), BaseApplicationImpl.getApplication().getResources()));
    QLog.d("GamePubAccountHippyFragment", 2, "#### height:" + localMessage.arg2);
    GamePubAccountHippyFragment.a(this.this$0).sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.hippy.GamePubAccountHippyFragment.14
 * JD-Core Version:    0.7.0.1
 */
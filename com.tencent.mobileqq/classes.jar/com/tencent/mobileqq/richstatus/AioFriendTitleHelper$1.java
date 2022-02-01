package com.tencent.mobileqq.richstatus;

import android.support.v4.app.FragmentActivity;
import bamd;
import baoy;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;

public class AioFriendTitleHelper$1
  implements Runnable
{
  public AioFriendTitleHelper$1(bamd parambamd) {}
  
  public void run()
  {
    RichStatus localRichStatus = ((baoy)bamd.a(this.this$0).app.getManager(15)).a(bamd.a(this.this$0).sessionInfo.curFriendUin, true);
    bamd.a(this.this$0).mActivity.runOnUiThread(new AioFriendTitleHelper.1.1(this, localRichStatus));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.AioFriendTitleHelper.1
 * JD-Core Version:    0.7.0.1
 */
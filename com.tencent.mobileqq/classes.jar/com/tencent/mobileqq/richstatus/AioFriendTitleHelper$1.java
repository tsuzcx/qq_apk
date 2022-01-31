package com.tencent.mobileqq.richstatus;

import android.support.v4.app.FragmentActivity;
import avbz;
import avev;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

public class AioFriendTitleHelper$1
  implements Runnable
{
  public AioFriendTitleHelper$1(avbz paramavbz) {}
  
  public void run()
  {
    RichStatus localRichStatus = ((avev)avbz.a(this.this$0).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(15)).a(avbz.a(this.this$0).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, true);
    avbz.a(this.this$0).jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new AioFriendTitleHelper.1.1(this, localRichStatus));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.AioFriendTitleHelper.1
 * JD-Core Version:    0.7.0.1
 */
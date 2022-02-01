package com.tencent.mobileqq.fragment;

import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;

class MsgBackupSettingFragment$4
  implements Runnable
{
  MsgBackupSettingFragment$4(MsgBackupSettingFragment paramMsgBackupSettingFragment, int paramInt, SessionInfo paramSessionInfo) {}
  
  public void run()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_Int)
    {
      ChatActivityFacade.b(this.this$0.getBaseActivity().app, this.this$0.getBaseActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, String.valueOf(i));
      try
      {
        Thread.sleep(20L);
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.MsgBackupSettingFragment.4
 * JD-Core Version:    0.7.0.1
 */
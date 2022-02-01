package com.tencent.mobileqq.fragment;

import adrm;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;

class MsgBackupSettingFragment$4
  implements Runnable
{
  MsgBackupSettingFragment$4(MsgBackupSettingFragment paramMsgBackupSettingFragment, int paramInt, SessionInfo paramSessionInfo) {}
  
  public void run()
  {
    int i = 0;
    for (;;)
    {
      if (i < this.jdField_a_of_type_Int)
      {
        adrm.b(this.this$0.getActivity().app, this.this$0.getActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, String.valueOf(i));
        try
        {
          Thread.sleep(20L);
          i += 1;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            localInterruptedException.printStackTrace();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.MsgBackupSettingFragment.4
 * JD-Core Version:    0.7.0.1
 */
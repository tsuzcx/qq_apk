package com.tencent.mobileqq.confess;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;

class ConfessMsgListFragment$2
  implements Runnable
{
  ConfessMsgListFragment$2(ConfessMsgListFragment paramConfessMsgListFragment) {}
  
  public void run()
  {
    this.this$0.a.getMessageFacade().setBoxReaded(AppConstants.CONFESS_UIN, 1032);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessMsgListFragment.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.receipt;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManager;
import java.lang.ref.WeakReference;

class ReceiptMessageReadMemberListContainerFragment$ListProcessHandler
  extends Handler
{
  private WeakReference<ReceiptMessageReadMemberListContainerFragment> a;
  
  private ReceiptMessageReadMemberListContainerFragment$ListProcessHandler(ReceiptMessageReadMemberListContainerFragment paramReceiptMessageReadMemberListContainerFragment)
  {
    this.a = new WeakReference(paramReceiptMessageReadMemberListContainerFragment);
  }
  
  public void handleMessage(Message paramMessage)
  {
    ReceiptMessageReadMemberListContainerFragment localReceiptMessageReadMemberListContainerFragment = (ReceiptMessageReadMemberListContainerFragment)this.a.get();
    if (localReceiptMessageReadMemberListContainerFragment != null)
    {
      if (!localReceiptMessageReadMemberListContainerFragment.isAdded()) {
        return;
      }
      int i = paramMessage.what;
      if (i != -1)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              if (i != 4)
              {
                if (i != 5) {
                  return;
                }
                ThreadManager.post(new ReceiptMessageReadMemberListContainerFragment.ListProcessHandler.2(this, localReceiptMessageReadMemberListContainerFragment), 8, null, true);
                return;
              }
              ThreadManager.post(new ReceiptMessageReadMemberListContainerFragment.ListProcessHandler.1(this, localReceiptMessageReadMemberListContainerFragment), 8, null, true);
              return;
            }
            ReceiptMessageReadMemberListContainerFragment.a(localReceiptMessageReadMemberListContainerFragment, ((Long)paramMessage.obj).longValue());
            return;
          }
          if (this.a.get() != null)
          {
            if (ReceiptMessageReadMemberListContainerFragment.a(localReceiptMessageReadMemberListContainerFragment)) {
              ReceiptMessageReadMemberListContainerFragment.o(localReceiptMessageReadMemberListContainerFragment);
            } else {
              sendEmptyMessage(5);
            }
            ReceiptMessageReadMemberListContainerFragment.p(localReceiptMessageReadMemberListContainerFragment);
          }
        }
        else
        {
          ReceiptMessageReadMemberListContainerFragment.n(localReceiptMessageReadMemberListContainerFragment);
        }
      }
      else
      {
        localReceiptMessageReadMemberListContainerFragment.stopTitleProgress();
        ReceiptMessageReadMemberListContainerFragment.s(localReceiptMessageReadMemberListContainerFragment);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptMessageReadMemberListContainerFragment.ListProcessHandler
 * JD-Core Version:    0.7.0.1
 */
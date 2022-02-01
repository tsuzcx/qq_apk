package com.tencent.mobileqq.receipt;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.PttItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.widget.QQToast;
import java.lang.ref.WeakReference;

class ReceiptMessageDetailFragment$DetailHandler
  extends Handler
{
  private WeakReference<ReceiptMessageDetailFragment> a;
  
  ReceiptMessageDetailFragment$DetailHandler(ReceiptMessageDetailFragment paramReceiptMessageDetailFragment)
  {
    this.a = new WeakReference(paramReceiptMessageDetailFragment);
  }
  
  public void handleMessage(Message paramMessage)
  {
    ReceiptMessageDetailFragment localReceiptMessageDetailFragment = (ReceiptMessageDetailFragment)this.a.get();
    if (localReceiptMessageDetailFragment != null)
    {
      if (!localReceiptMessageDetailFragment.isAdded()) {
        return;
      }
      int i = paramMessage.what;
      if (i != 10)
      {
        if (i != 11)
        {
          if (i != 20)
          {
            switch (i)
            {
            default: 
              break;
            case 7: 
              ReceiptMessageDetailFragment.k(localReceiptMessageDetailFragment);
              break;
            case 6: 
              i = PttItemBuilder.a(ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment), ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment));
              localReceiptMessageDetailFragment.a(ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment), ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment), i, false);
              break;
            case 5: 
              QQToast.a(ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment).getApp(), 1, 2131698575, 0).a(localReceiptMessageDetailFragment);
              break;
            case 4: 
              ReceiptMessageDetailFragment.h(localReceiptMessageDetailFragment);
              break;
            case 3: 
              if (!(paramMessage.obj instanceof MessageForPtt)) {
                return;
              }
              ReceiptMessageDetailFragment.c(localReceiptMessageDetailFragment, 3);
              ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment, (MessageForPtt)paramMessage.obj);
              ReceiptMessageDetailFragment.h(localReceiptMessageDetailFragment);
              break;
            case 2: 
              if (!(paramMessage.obj instanceof MessageForPic)) {
                return;
              }
              ReceiptMessageDetailFragment.c(localReceiptMessageDetailFragment, 2);
              ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment, (MessageForPic)paramMessage.obj);
              break;
            case 1: 
              if (!(paramMessage.obj instanceof MessageForText)) {
                return;
              }
              ReceiptMessageDetailFragment.c(localReceiptMessageDetailFragment, 1);
              ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment, (MessageForText)paramMessage.obj);
              i = 1;
              break;
            }
            ReceiptMessageDetailFragment.i(localReceiptMessageDetailFragment);
          }
          else
          {
            ReceiptMessageDetailFragment.j(localReceiptMessageDetailFragment);
          }
        }
        else {
          ReceiptMessageDetailFragment.l(localReceiptMessageDetailFragment);
        }
      }
      else {
        ThreadManager.post(new ReceiptMessageDetailFragment.DetailHandler.1(this, localReceiptMessageDetailFragment), 8, null, false);
      }
      i = 0;
      if (i != 0)
      {
        localReceiptMessageDetailFragment.stopTitleProgress();
        ReceiptMessageDetailFragment.m(localReceiptMessageDetailFragment);
        if ((ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment).a == 0) && (!ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment))) {
          if (ReceiptMessageDetailFragment.b(localReceiptMessageDetailFragment)) {
            ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment, 1, true);
          } else {
            ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment, 0, true);
          }
        }
        if (ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment)) {
          ReceiptMessageDetailFragment.h(localReceiptMessageDetailFragment);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptMessageDetailFragment.DetailHandler
 * JD-Core Version:    0.7.0.1
 */
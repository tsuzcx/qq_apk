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
              ReceiptMessageDetailFragment.A(localReceiptMessageDetailFragment);
              break;
            case 6: 
              i = PttItemBuilder.a(ReceiptMessageDetailFragment.j(localReceiptMessageDetailFragment), ReceiptMessageDetailFragment.v(localReceiptMessageDetailFragment));
              localReceiptMessageDetailFragment.a(ReceiptMessageDetailFragment.z(localReceiptMessageDetailFragment), ReceiptMessageDetailFragment.v(localReceiptMessageDetailFragment), i, false);
              break;
            case 5: 
              QQToast.makeText(ReceiptMessageDetailFragment.j(localReceiptMessageDetailFragment).getApp(), 1, 2131896522, 0).showByQueue(localReceiptMessageDetailFragment);
              break;
            case 4: 
              ReceiptMessageDetailFragment.w(localReceiptMessageDetailFragment);
              break;
            case 3: 
              if (!(paramMessage.obj instanceof MessageForPtt)) {
                return;
              }
              ReceiptMessageDetailFragment.c(localReceiptMessageDetailFragment, 3);
              ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment, (MessageForPtt)paramMessage.obj);
              ReceiptMessageDetailFragment.w(localReceiptMessageDetailFragment);
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
            ReceiptMessageDetailFragment.x(localReceiptMessageDetailFragment);
          }
          else
          {
            ReceiptMessageDetailFragment.y(localReceiptMessageDetailFragment);
          }
        }
        else {
          ReceiptMessageDetailFragment.B(localReceiptMessageDetailFragment);
        }
      }
      else {
        ThreadManager.post(new ReceiptMessageDetailFragment.DetailHandler.1(this, localReceiptMessageDetailFragment), 8, null, false);
      }
      i = 0;
      if (i != 0)
      {
        localReceiptMessageDetailFragment.stopTitleProgress();
        ReceiptMessageDetailFragment.C(localReceiptMessageDetailFragment);
        if ((ReceiptMessageDetailFragment.c(localReceiptMessageDetailFragment).a == 0) && (!ReceiptMessageDetailFragment.D(localReceiptMessageDetailFragment))) {
          if (ReceiptMessageDetailFragment.E(localReceiptMessageDetailFragment)) {
            ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment, 1, true);
          } else {
            ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment, 0, true);
          }
        }
        if (ReceiptMessageDetailFragment.D(localReceiptMessageDetailFragment)) {
          ReceiptMessageDetailFragment.w(localReceiptMessageDetailFragment);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptMessageDetailFragment.DetailHandler
 * JD-Core Version:    0.7.0.1
 */
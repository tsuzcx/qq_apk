package com.tencent.mobileqq.receipt;

import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.pic.DownCallBack;
import com.tencent.mobileqq.pic.DownCallBack.DownResult;
import java.lang.ref.WeakReference;

class ReceiptMessageDetailFragment$PttDownloadCallBack
  implements DownCallBack
{
  private WeakReference<ReceiptMessageDetailFragment> a;
  
  ReceiptMessageDetailFragment$PttDownloadCallBack(ReceiptMessageDetailFragment paramReceiptMessageDetailFragment)
  {
    this.a = new WeakReference(paramReceiptMessageDetailFragment);
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void a(DownCallBack.DownResult paramDownResult)
  {
    ReceiptMessageDetailFragment localReceiptMessageDetailFragment = (ReceiptMessageDetailFragment)this.a.get();
    if (localReceiptMessageDetailFragment == null) {
      return;
    }
    switch (paramDownResult.a)
    {
    default: 
      return;
    case -1: 
      ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment).getMultiMessageProxy().a(ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment), null);
      ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment).sendEmptyMessage(7);
      return;
    }
    ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment).getMultiMessageProxy().a(ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment), null);
    ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment).sendEmptyMessage(6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptMessageDetailFragment.PttDownloadCallBack
 * JD-Core Version:    0.7.0.1
 */
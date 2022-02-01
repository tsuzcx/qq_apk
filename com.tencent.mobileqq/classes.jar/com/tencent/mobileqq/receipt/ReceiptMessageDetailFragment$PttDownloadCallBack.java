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
    int i = paramDownResult.a;
    if (i != -1)
    {
      if (i != 0) {
        return;
      }
      ReceiptMessageDetailFragment.j(localReceiptMessageDetailFragment).getMultiMessageProxy().a(ReceiptMessageDetailFragment.v(localReceiptMessageDetailFragment), null);
      ReceiptMessageDetailFragment.r(localReceiptMessageDetailFragment).sendEmptyMessage(6);
      return;
    }
    ReceiptMessageDetailFragment.j(localReceiptMessageDetailFragment).getMultiMessageProxy().a(ReceiptMessageDetailFragment.v(localReceiptMessageDetailFragment), null);
    ReceiptMessageDetailFragment.r(localReceiptMessageDetailFragment).sendEmptyMessage(7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptMessageDetailFragment.PttDownloadCallBack
 * JD-Core Version:    0.7.0.1
 */
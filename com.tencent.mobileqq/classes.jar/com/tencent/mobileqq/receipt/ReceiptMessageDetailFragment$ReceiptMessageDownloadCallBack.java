package com.tencent.mobileqq.receipt;

import android.os.Handler;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.DownCallBack;
import com.tencent.mobileqq.pic.DownCallBack.DownResult;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;

class ReceiptMessageDetailFragment$ReceiptMessageDownloadCallBack
  implements DownCallBack
{
  private WeakReference<ReceiptMessageDetailFragment> a;
  private int b;
  
  ReceiptMessageDetailFragment$ReceiptMessageDownloadCallBack(ReceiptMessageDetailFragment paramReceiptMessageDetailFragment)
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
    Object localObject;
    if ((paramDownResult.b == 0) && (paramDownResult.f != null))
    {
      MessageRecord localMessageRecord = ReceiptMessageDetailFragment.j(localReceiptMessageDetailFragment).getMessageFacade().a(ReceiptMessageDetailFragment.c(localReceiptMessageDetailFragment).b, ReceiptMessageDetailFragment.c(localReceiptMessageDetailFragment).a, ReceiptMessageDetailFragment.u(localReceiptMessageDetailFragment));
      localObject = localMessageRecord;
      if (localMessageRecord == null)
      {
        localObject = new MessageForStructing();
        ((MessageRecord)localObject).senderuin = "0";
        ((MessageRecord)localObject).uniseq = ReceiptMessageDetailFragment.u(localReceiptMessageDetailFragment);
      }
      paramDownResult = ReceiptMessageDetailFragment.j(localReceiptMessageDetailFragment).getProxyManager().b().a(paramDownResult.f, null, (MessageRecord)localObject, null);
      if ((paramDownResult != null) && (!paramDownResult.isEmpty()))
      {
        ReceiptMessageDetailFragment.r(localReceiptMessageDetailFragment).sendEmptyMessage(10);
        return;
      }
      ReceiptMessageDetailFragment.r(localReceiptMessageDetailFragment).sendEmptyMessage(11);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ReceiptMessageDownloadCallBack onDownload, download msg fail with code: ");
      ((StringBuilder)localObject).append(paramDownResult.b);
      QLog.d("ReceiptMessageDetailFragment", 2, ((StringBuilder)localObject).toString());
    }
    int i = this.b + 1;
    this.b = i;
    if (i <= 3)
    {
      ReceiptMessageDetailFragment.r(localReceiptMessageDetailFragment).sendEmptyMessage(0);
      return;
    }
    ReceiptMessageDetailFragment.r(localReceiptMessageDetailFragment).sendEmptyMessage(11);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptMessageDetailFragment.ReceiptMessageDownloadCallBack
 * JD-Core Version:    0.7.0.1
 */
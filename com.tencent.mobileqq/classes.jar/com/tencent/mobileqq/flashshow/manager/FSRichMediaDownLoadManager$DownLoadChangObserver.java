package com.tencent.mobileqq.flashshow.manager;

import com.tencent.biz.qcircleshadow.lib.HostStaticInvokeHelper.NetworkChangedObserver;
import com.tencent.biz.qcircleshadow.lib.variation.HostFileUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostHttpUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetReq;
import java.lang.ref.WeakReference;

public class FSRichMediaDownLoadManager$DownLoadChangObserver
  implements HostStaticInvokeHelper.NetworkChangedObserver
{
  private WeakReference<FSRichMediaDownLoadManager.DownLoadParams> a;
  private WeakReference<HttpNetReq> b;
  
  public FSRichMediaDownLoadManager$DownLoadChangObserver(FSRichMediaDownLoadManager.DownLoadParams paramDownLoadParams, HttpNetReq paramHttpNetReq)
  {
    this.a = new WeakReference(paramDownLoadParams);
    this.b = new WeakReference(paramHttpNetReq);
  }
  
  public void onNetworkChanged()
  {
    if (HostNetworkUtils.isNetworkAvailable()) {
      return;
    }
    Object localObject = this.a;
    if ((localObject != null) && (((WeakReference)localObject).get() != null))
    {
      localObject = (FSRichMediaDownLoadManager.DownLoadParams)this.a.get();
      if ((localObject != null) && (FSRichMediaDownLoadManager.DownLoadParams.a((FSRichMediaDownLoadManager.DownLoadParams)localObject) != null))
      {
        FSRichMediaDownLoadManager.DownLoadParams.a((FSRichMediaDownLoadManager.DownLoadParams)localObject).a(false);
        HostFileUtils.delete(((FSRichMediaDownLoadManager.DownLoadParams)localObject).c(), true);
      }
    }
    localObject = this.b;
    if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
      HostHttpUtils.cancel((NetReq)this.b.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.manager.FSRichMediaDownLoadManager.DownLoadChangObserver
 * JD-Core Version:    0.7.0.1
 */
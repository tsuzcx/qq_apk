package com.tencent.qqmini.proxyimpl;

import alof;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.model.InnerShareData;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.io.File;

class ShareProxyImpl$7
  implements ThreadExcutor.IThreadListener
{
  ShareProxyImpl$7(ShareProxyImpl paramShareProxyImpl, String paramString, InnerShareData paramInnerShareData, MiniAppInfo paramMiniAppInfo) {}
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    String str = alof.bd + this.val$fileName;
    if (new File(str).exists())
    {
      ShareProxyImpl.access$100(this.this$0, this.val$shareData.a, this.val$shareData.summary, this.val$miniAppInfo.name, str, this.val$shareData.shareTarget);
      return;
    }
    QLog.e("ShareProxyImpl", 4, "shareLocalPicMessage: realPicFile is not exist:" + str);
  }
  
  public void onPreRun() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ShareProxyImpl.7
 * JD-Core Version:    0.7.0.1
 */
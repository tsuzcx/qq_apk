package com.tencent.qqmini.proxyimpl;

import ajed;
import bdng;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.io.File;

class ShareProxyImpl$7
  implements ThreadExcutor.IThreadListener
{
  ShareProxyImpl$7(ShareProxyImpl paramShareProxyImpl, String paramString, bdng parambdng) {}
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    String str = ajed.ba + this.val$fileName;
    if (new File(str).exists())
    {
      ShareProxyImpl.access$100(this.this$0, this.val$shareData.jdField_a_of_type_AndroidAppActivity, this.val$shareData.jdField_a_of_type_JavaLangString, this.val$shareData.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.name, str, this.val$shareData.b);
      return;
    }
    QLog.e("ShareProxyImpl", 4, "shareLocalPicMessage: realPicFile is not exist:" + str);
  }
  
  public void onPreRun() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ShareProxyImpl.7
 * JD-Core Version:    0.7.0.1
 */
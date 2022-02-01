package com.tencent.mobileqq.uniformdownload.core;

import android.os.Bundle;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.uniformdownload.data.DownloadInstContextMgr;
import com.tencent.mobileqq.uniformdownload.util.IUniformDownloaderListener;
import com.tencent.mobileqq.uniformdownload.util.UniformDownloadUtil;
import com.tencent.qphone.base.util.QLog;

class UniformDownloadMgr$7
  implements IUniformDownloaderListener
{
  UniformDownloadMgr$7(UniformDownloadMgr paramUniformDownloadMgr) {}
  
  public void a(int paramInt, Bundle paramBundle) {}
  
  public void a(int paramInt, String paramString, Bundle paramBundle)
  {
    UniformDownloadMgr.b(this.a).e();
  }
  
  public void a(String paramString, long paramLong, Bundle paramBundle)
  {
    paramBundle.getInt("_CB_SID");
    Object localObject = paramBundle.getString("_CB_URL");
    paramBundle = paramBundle.getBundle("_CB_USERDATA");
    UniformDownloadMgr.b(this.a).b((String)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[UniformDL] >>>insertFM and install. PH:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" SZ:");
    ((StringBuilder)localObject).append(paramLong);
    QLog.i("UniformDownloadMgr_Impl", 1, ((StringBuilder)localObject).toString());
    if (UniformDownloadMgr.c(this.a) == null) {
      QQFileManagerUtil.s(paramString);
    }
    if (paramBundle != null) {
      UniformDownloadUtil.a(paramString, paramBundle.getString("big_brother_source_key"));
    }
    UniformDownloadMgr.b(this.a).e();
  }
  
  public void b(int paramInt, Bundle paramBundle) {}
  
  public void c(int paramInt, Bundle paramBundle) {}
  
  public void d(int paramInt, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.core.UniformDownloadMgr.7
 * JD-Core Version:    0.7.0.1
 */
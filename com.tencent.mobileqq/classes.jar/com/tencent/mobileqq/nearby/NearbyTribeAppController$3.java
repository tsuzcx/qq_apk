package com.tencent.mobileqq.nearby;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.uniformdownload.util.IUniformDownloaderListener;
import com.tencent.qphone.base.util.QLog;

class NearbyTribeAppController$3
  implements IUniformDownloaderListener
{
  NearbyTribeAppController$3(NearbyTribeAppController paramNearbyTribeAppController) {}
  
  public void a(int paramInt, Bundle paramBundle) {}
  
  public void a(int paramInt, String paramString, Bundle paramBundle)
  {
    paramString = NearbyTribeAppController.a(this.a);
    paramBundle = new StringBuilder();
    paramBundle.append("onDownloadFailed,errCode=");
    paramBundle.append(paramInt);
    QLog.d(paramString, 2, paramBundle.toString());
  }
  
  public void a(String paramString, long paramLong, Bundle paramBundle)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramBundle = NearbyTribeAppController.a(this.a);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDownloadSucess,filePath:");
      localStringBuilder.append(paramString);
      QLog.d(paramBundle, 2, localStringBuilder.toString());
    }
  }
  
  public void b(int paramInt, Bundle paramBundle) {}
  
  public void c(int paramInt, Bundle paramBundle) {}
  
  public void d(int paramInt, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyTribeAppController.3
 * JD-Core Version:    0.7.0.1
 */
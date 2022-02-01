package com.tencent.mobileqq.fragment;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.uniformdownload.util.IUniformDownloaderListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class NearbyHybridFragment$10
  implements IUniformDownloaderListener
{
  public void a(int paramInt, Bundle paramBundle) {}
  
  public void a(int paramInt, String paramString, Bundle paramBundle) {}
  
  public void a(String paramString, long paramLong, Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDownloadSucess() called with: filePath = [");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], fileSize = [");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("], extData = [");
    localStringBuilder.append(paramBundle);
    localStringBuilder.append("]");
    QLog.i("nearby.NearbyHybridFragment", 2, localStringBuilder.toString());
    paramBundle = BaseApplicationImpl.getContext().getSharedPreferences("now_down_apk", 4);
    paramBundle.edit().putInt("state", 1);
    paramBundle.edit().putString("filePath", paramString);
  }
  
  public void b(int paramInt, Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDownloadProgress() called with: progress = [");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], extData = [");
    localStringBuilder.append(paramBundle);
    localStringBuilder.append("]");
    QLog.i("nearby.NearbyHybridFragment", 2, localStringBuilder.toString());
  }
  
  public void c(int paramInt, Bundle paramBundle) {}
  
  public void d(int paramInt, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.NearbyHybridFragment.10
 * JD-Core Version:    0.7.0.1
 */
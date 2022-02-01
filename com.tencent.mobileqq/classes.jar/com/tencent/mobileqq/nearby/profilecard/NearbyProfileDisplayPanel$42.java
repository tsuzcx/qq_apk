package com.tencent.mobileqq.nearby.profilecard;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.uniformdownload.util.IUniformDownloaderListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class NearbyProfileDisplayPanel$42
  implements IUniformDownloaderListener
{
  NearbyProfileDisplayPanel$42(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel, String paramString) {}
  
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
    QLog.i("NearbyProfileDisplayPanel", 1, localStringBuilder.toString());
    paramBundle = BaseApplicationImpl.getContext().getSharedPreferences(this.jdField_a_of_type_JavaLangString, 4);
    paramBundle.edit().putInt("state", 1);
    paramBundle.edit().putString("filePath", paramString);
  }
  
  public void b(int paramInt, Bundle paramBundle) {}
  
  public void c(int paramInt, Bundle paramBundle) {}
  
  public void d(int paramInt, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.42
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.intervideo.audioroom.pluginimpl;

import android.os.Bundle;

class QQBaseAbilityInterfaceImpl$1
  implements com.tencent.intervideo.nowproxy.customized_interface.DownloadCallback
{
  QQBaseAbilityInterfaceImpl$1(QQBaseAbilityInterfaceImpl paramQQBaseAbilityInterfaceImpl, String paramString, com.tencent.qqinterface.DownloadCallback paramDownloadCallback) {}
  
  public void onDownloadCancel() {}
  
  public void onDownloadError(int paramInt1, int paramInt2, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("errCode", paramInt1);
    localBundle.putInt("httpCode", paramInt2);
    localBundle.putString("errMsg", paramString);
    this.jdField_a_of_type_ComTencentQqinterfaceDownloadCallback.onResult(localBundle);
  }
  
  public void onDownloadSuccess(String paramString)
  {
    paramString = new Bundle();
    paramString.putInt("errCode", 0);
    paramString.putString("errMsg", "Download Success");
    paramString.putString("filePath", this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentQqinterfaceDownloadCallback.onResult(paramString);
  }
  
  public void onProgress(int paramInt1, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("downloadSize", paramInt1);
    localBundle.putLong("totalSize", paramInt2);
    if (paramInt2 == 0) {
      localBundle.putInt("percent", 0);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentQqinterfaceDownloadCallback.onProgress(localBundle);
      return;
      localBundle.putInt("percent", paramInt1 / paramInt2 * 100);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.audioroom.pluginimpl.QQBaseAbilityInterfaceImpl.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.mobileqq.qwallet.preload.IPreloadService.DownloadCallback;
import com.tencent.mobileqq.qwallet.preload.ResourceInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class QWalletCommonJsPlugin$QWVideoJsPlugin$1
  implements IPreloadService.DownloadCallback
{
  QWalletCommonJsPlugin$QWVideoJsPlugin$1(QWalletCommonJsPlugin.QWVideoJsPlugin paramQWVideoJsPlugin, String paramString) {}
  
  public void onDownloadResFinished(String paramString1, int paramInt, String paramString2, ResourceInfo paramResourceInfo)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDownloadVideoFinished,id:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",path:");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", resInfo:");
      localStringBuilder.append(paramResourceInfo);
      QLog.i("QWalletCommonJsPlugin", 2, localStringBuilder.toString());
    }
    if (paramResourceInfo != null)
    {
      if (paramResourceInfo.type != 5) {
        return;
      }
      paramString1 = new JSONObject();
      if (paramInt == 0) {
        paramInt = 0;
      } else if (paramInt == -4) {
        paramInt = -2;
      } else {
        paramInt = -1;
      }
      try
      {
        paramString1.put("resultCode", paramInt);
      }
      catch (JSONException paramString2)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QWalletCommonJsPlugin", 2, paramString2, new Object[0]);
        }
      }
      QWalletCommonJsPlugin.QWVideoJsPlugin.access$1000(this.this$1, "downloadVideo", this.val$vid, paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QWalletCommonJsPlugin.QWVideoJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */
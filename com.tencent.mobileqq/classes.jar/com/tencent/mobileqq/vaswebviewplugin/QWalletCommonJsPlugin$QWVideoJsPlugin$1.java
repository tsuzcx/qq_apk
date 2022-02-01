package com.tencent.mobileqq.vaswebviewplugin;

import akwx;
import com.tencent.mobileqq.activity.qwallet.preload.ResourceInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class QWalletCommonJsPlugin$QWVideoJsPlugin$1
  implements akwx
{
  QWalletCommonJsPlugin$QWVideoJsPlugin$1(QWalletCommonJsPlugin.QWVideoJsPlugin paramQWVideoJsPlugin, String paramString) {}
  
  public void onDownloadResFinished(String paramString1, int paramInt, String paramString2, ResourceInfo paramResourceInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QWalletCommonJsPlugin", 2, "onDownloadVideoFinished,id:" + paramString1 + ",path:" + paramString2 + ", resInfo:" + paramResourceInfo);
    }
    if ((paramResourceInfo == null) || (paramResourceInfo.type != 5)) {
      return;
    }
    paramString1 = new JSONObject();
    if (paramInt == 0) {
      paramInt = 0;
    }
    try
    {
      for (;;)
      {
        paramString1.put("resultCode", paramInt);
        QWalletCommonJsPlugin.QWVideoJsPlugin.access$1000(this.this$1, "downloadVideo", this.val$vid, paramString1);
        return;
        if (paramInt == -4) {
          paramInt = -2;
        } else {
          paramInt = -1;
        }
      }
    }
    catch (JSONException paramString2)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QWalletCommonJsPlugin", 2, paramString2, new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QWalletCommonJsPlugin.QWVideoJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */
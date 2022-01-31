package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.mobileqq.activity.qwallet.QWalletSkinHandler.SkinListener;
import org.json.JSONObject;

class QWalletCommonJsPlugin$2
  implements QWalletSkinHandler.SkinListener
{
  QWalletCommonJsPlugin$2(QWalletCommonJsPlugin paramQWalletCommonJsPlugin, JSONObject paramJSONObject) {}
  
  public void onResult(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        this.val$resObj.put("result_code", 0);
        QWalletCommonJsPlugin.access$000(this.this$0, this.val$resObj.toString());
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      this.val$resObj.put("result_code", 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QWalletCommonJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */
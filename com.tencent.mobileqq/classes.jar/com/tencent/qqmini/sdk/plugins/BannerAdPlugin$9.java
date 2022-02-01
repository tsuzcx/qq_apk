package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.utils.BannerAdPosInfo;
import org.json.JSONException;
import org.json.JSONObject;

class BannerAdPlugin$9
  implements Runnable
{
  BannerAdPlugin$9(BannerAdPlugin paramBannerAdPlugin, int paramInt1, int paramInt2, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    boolean bool = this.this$0.updateBannerAdPosition(this.jdField_a_of_type_Int, this.b);
    if ((bool) && (this.jdField_a_of_type_Int == 3)) {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("state", "resize");
        localJSONObject.put("width", this.b);
        localJSONObject.put("height", BannerAdPosInfo.getHeight(this.b));
        BannerAdPlugin.access$600(this.this$0, this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent, localJSONObject, "onBannerAdStateChange");
      }
      catch (JSONException localJSONException)
      {
        QMLog.e("BannerAdPlugin", "updateBannerAd informJs error", localJSONException);
      }
    }
    if (QMLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateBannerAd ");
      localStringBuilder.append(bool);
      localStringBuilder.append(", resizeValue = ");
      localStringBuilder.append(this.b);
      QMLog.i("BannerAdPlugin", localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.BannerAdPlugin.9
 * JD-Core Version:    0.7.0.1
 */
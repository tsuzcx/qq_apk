package com.tencent.mobileqq.kandian.base.video.plugin;

import com.tencent.mobileqq.kandian.base.video.VideoDeviceInfoHelper;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import org.json.JSONObject;

class VideoPluginInstall$SDKInstallListener$1
  implements Runnable
{
  VideoPluginInstall$SDKInstallListener$1(VideoPluginInstall.SDKInstallListener paramSDKInstallListener, boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("version", "8.7.0");
      if (!this.jdField_a_of_type_Boolean) {
        localJSONObject.put("error_code", this.jdField_a_of_type_Int);
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    String str1;
    if (this.jdField_a_of_type_Boolean) {
      str1 = "";
    } else {
      str1 = String.valueOf(this.jdField_a_of_type_Int);
    }
    String str2;
    if (this.jdField_a_of_type_Boolean) {
      str2 = "1";
    } else {
      str2 = "0";
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X8009753", "0X8009753", 0, 0, str2, VideoDeviceInfoHelper.a(), str1, localJSONObject.toString(), false);
    if (!this.jdField_a_of_type_Boolean) {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X8009752", "0X8009752", 0, 0, str2, VideoDeviceInfoHelper.a(), str1, localJSONObject.toString(), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.plugin.VideoPluginInstall.SDKInstallListener.1
 * JD-Core Version:    0.7.0.1
 */
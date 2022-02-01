package com.tencent.mobileqq.identification;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYtSDKKitFrameworkEventListener;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYtSDKKitNetResponseParser;
import java.util.HashMap;
import org.json.JSONObject;

class IdentificationPoseReflect$5
  implements YtSDKKitFramework.IYtSDKKitFrameworkEventListener
{
  IdentificationPoseReflect$5(IdentificationPoseReflect paramIdentificationPoseReflect) {}
  
  public void onFrameworkEvent(HashMap<String, Object> paramHashMap)
  {
    IdentificationPoseReflect.a(this.a, new IdentificationPoseReflect.5.1(this, paramHashMap));
  }
  
  public void onNetworkRequestEvent(String paramString1, String paramString2, HashMap<String, String> paramHashMap, YtSDKKitFramework.IYtSDKKitNetResponseParser paramIYtSDKKitNetResponseParser)
  {
    paramHashMap = YtSDKKit.a().a(5);
    if (paramHashMap == null) {
      QLog.e("qq_Identification.Model", 1, "post face data error : config is empty");
    }
    do
    {
      return;
      paramHashMap = paramHashMap.optString("result_api_url", "");
      if (TextUtils.isEmpty(paramHashMap))
      {
        QLog.e("qq_Identification.Model", 1, "post face data error : config url is empty");
        return;
      }
    } while (!paramHashMap.equals(paramString1));
    QLog.d("qq_Identification.Model", 1, "start upload face data");
    if (this.a.jdField_a_of_type_ComTencentMobileqqIdentificationBaseRequestHelper == null) {
      this.a.jdField_a_of_type_ComTencentMobileqqIdentificationBaseRequestHelper = new ActReflectRequestHelper(IdentificationPoseReflect.a(this.a), paramString2, this.a.jdField_a_of_type_ComTencentMobileqqIdentificationRequestHelper$RequestListener);
    }
    for (;;)
    {
      IdentificationPoseReflect.a(this.a, new IdentificationPoseReflect.5.2(this));
      if (!NetworkUtil.g(BaseApplicationImpl.getApplication())) {
        break;
      }
      ((ActReflectRequestHelper)this.a.jdField_a_of_type_ComTencentMobileqqIdentificationBaseRequestHelper).b();
      return;
      ((ActReflectRequestHelper)this.a.jdField_a_of_type_ComTencentMobileqqIdentificationBaseRequestHelper).a(paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.identification.IdentificationPoseReflect.5
 * JD-Core Version:    0.7.0.1
 */
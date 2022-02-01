package com.tencent.mobileqq.identification;

import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYtSDKKitFrameworkEventListener;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYtSDKKitNetResponseParser;
import java.util.HashMap;
import org.json.JSONObject;

public class IdentificationPoseReflect$QYtSDKEventListener
  implements YtSDKKitFramework.IYtSDKKitFrameworkEventListener
{
  protected IdentificationPoseReflect$QYtSDKEventListener(IdentificationPoseReflect paramIdentificationPoseReflect) {}
  
  protected boolean a()
  {
    return NetworkUtil.isNetworkAvailable(BaseApplication.getContext());
  }
  
  public void onFrameworkEvent(HashMap<String, Object> paramHashMap)
  {
    this.a.a(new IdentificationPoseReflect.QYtSDKEventListener.1(this, paramHashMap));
  }
  
  public void onNetworkRequestEvent(String paramString1, String paramString2, HashMap<String, String> paramHashMap, YtSDKKitFramework.IYtSDKKitNetResponseParser paramIYtSDKKitNetResponseParser)
  {
    paramHashMap = YtSDKKit.a().a(5);
    if (paramHashMap == null)
    {
      QLog.e("qq_Identification.Model", 1, "post face data error : config is empty");
      return;
    }
    paramHashMap = paramHashMap.optString("result_api_url", "");
    if (TextUtils.isEmpty(paramHashMap))
    {
      QLog.e("qq_Identification.Model", 1, "post face data error : config url is empty");
      return;
    }
    if (!paramHashMap.equals(paramString1))
    {
      QLog.e("qq_Identification.Model", 1, "actionUrl not equals url");
      return;
    }
    if (!a())
    {
      QLog.e("qq_Identification.Model", 1, "network not available");
      paramString1 = new HashMap();
      paramString1.put("process_action", "failed");
      paramString1.put("message", HardCodeUtil.a(2131903673));
      this.a.b.handleEvent(paramString1);
      return;
    }
    this.a.a(new IdentificationPoseReflect.QYtSDKEventListener.2(this));
    QLog.d("qq_Identification.Model", 1, "start upload face data");
    if (this.a.a == null)
    {
      paramString1 = this.a;
      paramString1.a = new ActReflectRequestHelper(IdentificationPoseReflect.a(paramString1), paramString2, this.a.b);
    }
    paramString1 = (ActReflectRequestHelper)this.a.a;
    paramString1.a(paramString2);
    paramString1.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.identification.IdentificationPoseReflect.QYtSDKEventListener
 * JD-Core Version:    0.7.0.1
 */
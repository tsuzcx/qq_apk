package com.tencent.mobileqq.mini.out.webPlugins;

import android.text.TextUtils;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.UiThreadUtil;
import org.json.JSONObject;

class MiniAppPlugin$3
  implements MiniAppCmdInterface
{
  MiniAppPlugin$3(MiniAppPlugin paramMiniAppPlugin, String paramString) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    long l = paramJSONObject.optLong("retCode");
    if ((paramBoolean) && (l == 0L))
    {
      paramJSONObject = (MiniAppInfo)paramJSONObject.opt("appInfo");
      if ((paramJSONObject != null) && (!TextUtils.isEmpty(paramJSONObject.appId)))
      {
        UiThreadUtil.a(new MiniAppPlugin.3.1(this, paramJSONObject));
        return;
      }
      QLog.e("MiniAppPlugin", 2, "requestMiniApp invalid appInfo");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("requestMiniApp failed, retCode=");
    localStringBuilder.append(l);
    localStringBuilder.append(",errMsg=");
    localStringBuilder.append(paramJSONObject.optString("errMsg"));
    QLog.e("MiniAppPlugin", 2, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.webPlugins.MiniAppPlugin.3
 * JD-Core Version:    0.7.0.1
 */
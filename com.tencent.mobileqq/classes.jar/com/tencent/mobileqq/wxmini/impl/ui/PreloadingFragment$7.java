package com.tencent.mobileqq.wxmini.impl.ui;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.luggage.wxaapi.WxaApi;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.wxmini.api.data.WeixinMiniAppInfo;
import com.tencent.mobileqq.wxmini.impl.WxMiniSDKImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.json.JSONObject;

class PreloadingFragment$7
  implements MiniAppCmdInterface
{
  PreloadingFragment$7(PreloadingFragment paramPreloadingFragment, Context paramContext, int paramInt, String paramString) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      paramJSONObject = PreloadingFragment.a(this.d, paramJSONObject);
      if ((paramJSONObject != null) && (!TextUtils.isEmpty(paramJSONObject.a)))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("launchWeixinMiniAppByMiniCode appid:");
        localStringBuilder.append(paramJSONObject.a);
        localStringBuilder.append("  name:");
        localStringBuilder.append(paramJSONObject.b);
        QLog.i("wxmini.PreloadingFragment", 1, localStringBuilder.toString());
        WxMiniSDKImpl.a.c().launchWxaApp(this.a, paramJSONObject.a, 0, null, new PreloadingFragment.7.1(this));
        return;
      }
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("launchWeixinMiniAppByMiniCode link:");
      paramJSONObject.append(this.c);
      paramJSONObject.append("  appid is empty.");
      QLog.i("wxmini.PreloadingFragment", 1, paramJSONObject.toString());
      ThreadManager.getUIHandler().post(new PreloadingFragment.7.2(this));
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getWeixinSDKAppInfo fail.");
    localStringBuilder.append(paramJSONObject.toString());
    QLog.i("wxmini.PreloadingFragment", 1, localStringBuilder.toString());
    ThreadManager.getUIHandler().post(new PreloadingFragment.7.3(this, paramJSONObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.wxmini.impl.ui.PreloadingFragment.7
 * JD-Core Version:    0.7.0.1
 */
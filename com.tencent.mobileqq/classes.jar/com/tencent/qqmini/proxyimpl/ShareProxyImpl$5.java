package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Handler;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.util.ImageUtil;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.InnerShareData;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import eipc.EIPCClient;
import org.json.JSONObject;

class ShareProxyImpl$5
  implements MiniAppCmdInterface
{
  ShareProxyImpl$5(ShareProxyImpl paramShareProxyImpl, Activity paramActivity, InnerShareData paramInnerShareData, MiniAppInfo paramMiniAppInfo, int paramInt, String paramString) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    boolean bool = false;
    QLog.d("AppBrandRuntime", 1, "startShareToWeChat. isSuc:" + paramBoolean);
    if ((paramBoolean) && (paramJSONObject != null))
    {
      String str = paramJSONObject.optString("jump_url");
      if (paramJSONObject.optBoolean("needShareCallBack", false)) {
        QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_share_suc", null, null);
      }
      try
      {
        paramJSONObject = URLDrawable.URLDrawableOptions.obtain();
        if (this.jdField_a_of_type_AndroidAppActivity != null) {
          paramJSONObject.mFailedDrawable = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130848781);
        }
        paramJSONObject = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelInnerShareData.sharePicPath, paramJSONObject);
        paramJSONObject.setURLDrawableListener(new ShareProxyImpl.5.1(this, str));
        if (paramJSONObject.getStatus() == 1)
        {
          paramJSONObject = ImageUtil.drawableToBitmap(paramJSONObject.getCurrDrawable());
          ShareProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplShareProxyImpl, this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.name, ShareProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplShareProxyImpl, paramJSONObject), str);
          return;
        }
        if (paramJSONObject.getStatus() == 1) {
          return;
        }
        paramJSONObject.startDownload();
        return;
      }
      catch (Exception paramJSONObject)
      {
        QLog.e("AppBrandRuntime", 1, "startShareToWeChat. get an exception when handling URLbmp:" + paramJSONObject);
        ShareProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplShareProxyImpl, this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.name, str);
        return;
      }
    }
    else
    {
      long l = -1L;
      if (paramJSONObject != null)
      {
        paramBoolean = paramJSONObject.optBoolean("needShareCallBack", false);
        l = paramJSONObject.optLong("retCode");
        paramJSONObject = paramJSONObject.optString("errMsg");
      }
      for (;;)
      {
        if (!paramBoolean) {
          QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_share_suc", null, null);
        }
        if (this.jdField_a_of_type_AndroidAppActivity == null)
        {
          QLog.e("ShareProxyImpl", 1, "startShareToWe activity is null?!!");
          return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new ShareProxyImpl.5.2(this, l, paramJSONObject));
        return;
        paramJSONObject = null;
        paramBoolean = bool;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ShareProxyImpl.5
 * JD-Core Version:    0.7.0.1
 */
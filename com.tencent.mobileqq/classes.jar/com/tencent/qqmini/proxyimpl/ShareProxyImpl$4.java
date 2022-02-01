package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
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

class ShareProxyImpl$4
  implements MiniAppCmdInterface
{
  ShareProxyImpl$4(ShareProxyImpl paramShareProxyImpl, Activity paramActivity, InnerShareData paramInnerShareData, MiniAppInfo paramMiniAppInfo, int paramInt, String paramString) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("startShareToWeChat. isSuc:");
    ((StringBuilder)localObject1).append(paramBoolean);
    QLog.d("AppBrandRuntime", 1, ((StringBuilder)localObject1).toString());
    boolean bool = false;
    if ((paramBoolean) && (paramJSONObject != null))
    {
      localObject1 = paramJSONObject.optString("jump_url");
      if (paramJSONObject.optBoolean("needShareCallBack", false)) {
        QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_share_suc", null, null);
      }
      try
      {
        paramJSONObject = URLDrawable.URLDrawableOptions.obtain();
        if (this.a != null) {
          paramJSONObject.mFailedDrawable = this.a.getResources().getDrawable(2130850326);
        }
        paramJSONObject = URLDrawable.getDrawable(this.b.sharePicPath, paramJSONObject);
        paramJSONObject.setURLDrawableListener(new ShareProxyImpl.4.1(this, (String)localObject1));
        Bitmap localBitmap;
        int i;
        String str1;
        String str2;
        if (paramJSONObject.getStatus() == 1)
        {
          localBitmap = ImageUtil.drawableToBitmap(paramJSONObject.getCurrDrawable());
          paramJSONObject = this.f;
          localObject2 = this.c;
          i = this.d;
          str1 = this.e;
          str2 = this.c.name;
          localBitmap = ShareProxyImpl.a(this.f, localBitmap);
        }
        try
        {
          ShareProxyImpl.a(paramJSONObject, (MiniAppInfo)localObject2, i, str1, str2, localBitmap, (String)localObject1);
          return;
        }
        catch (Exception paramJSONObject) {}
        if (paramJSONObject.getStatus() == 1) {
          return;
        }
        paramJSONObject.startDownload();
        return;
      }
      catch (Exception paramJSONObject) {}
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("startShareToWeChat. get an exception when handling URLbmp:");
      ((StringBuilder)localObject2).append(paramJSONObject);
      QLog.e("AppBrandRuntime", 1, ((StringBuilder)localObject2).toString());
      paramJSONObject = this.f;
      localObject2 = this.c;
      ShareProxyImpl.a(paramJSONObject, (MiniAppInfo)localObject2, this.a, this.d, this.e, ((MiniAppInfo)localObject2).name, (String)localObject1);
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
      else
      {
        paramJSONObject = null;
        paramBoolean = bool;
      }
      if (!paramBoolean) {
        QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_share_suc", null, null);
      }
      if (this.a == null)
      {
        QLog.e("ShareProxyImpl", 1, "startShareToWe activity is null?!!");
        return;
      }
      ThreadManagerV2.getUIHandlerV2().post(new ShareProxyImpl.4.2(this, l, paramJSONObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ShareProxyImpl.4
 * JD-Core Version:    0.7.0.1
 */
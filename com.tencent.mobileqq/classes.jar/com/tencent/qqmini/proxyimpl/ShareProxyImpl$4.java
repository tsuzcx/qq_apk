package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Handler;
import besj;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.util.ImageUtil;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import eipc.EIPCClient;
import java.io.ByteArrayOutputStream;
import org.json.JSONObject;

class ShareProxyImpl$4
  implements MiniAppCmdInterface
{
  ShareProxyImpl$4(ShareProxyImpl paramShareProxyImpl, Activity paramActivity, besj parambesj, int paramInt, String paramString, MiniAppInfo paramMiniAppInfo) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    QLog.d("AppBrandRuntime", 1, "startShareToWeChat. isSuc:" + paramBoolean);
    String str;
    if ((paramBoolean) && (paramJSONObject != null))
    {
      str = paramJSONObject.optString("jump_url");
      if (paramJSONObject.optBoolean("needShareCallBack", false)) {
        QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_share_suc", null, null);
      }
      try
      {
        paramJSONObject = URLDrawable.URLDrawableOptions.obtain();
        if (this.val$activity != null) {
          paramJSONObject.mFailedDrawable = this.val$activity.getResources().getDrawable(2130847472);
        }
        Bitmap localBitmap = ImageUtil.drawableToBitmap(URLDrawable.getDrawable(this.val$shareData.b, paramJSONObject).getCurrDrawable());
        paramJSONObject = localBitmap;
        if (localBitmap != null)
        {
          paramJSONObject = new ByteArrayOutputStream();
          localBitmap.compress(Bitmap.CompressFormat.JPEG, 85, paramJSONObject);
          paramJSONObject = paramJSONObject.toByteArray();
          QLog.d("AppBrandRuntime", 1, "startShareToWeChat. ImageUtil.drawableToBitmap, out.toByteArray().length original:" + paramJSONObject.length);
          int i = 0;
          while ((i < 10) && (paramJSONObject.length > 32768))
          {
            paramJSONObject = new Matrix();
            paramJSONObject.setScale(0.7F, 0.7F);
            localBitmap = Bitmap.createBitmap(localBitmap, 0, 0, localBitmap.getWidth(), localBitmap.getHeight(), paramJSONObject, true);
            paramJSONObject = new ByteArrayOutputStream();
            localBitmap.compress(Bitmap.CompressFormat.JPEG, 85, paramJSONObject);
            paramJSONObject = paramJSONObject.toByteArray();
            QLog.d("AppBrandRuntime", 1, "startShareToWeChat. ImageUtil.drawableToBitmap, out.toByteArray().length compressTo:" + paramJSONObject.length);
            i += 1;
          }
          QLog.d("AppBrandRuntime", 1, "startShareToWeChat. ImageUtil.drawableToBitmap, out.toByteArray().length done:" + paramJSONObject.length);
          paramJSONObject = BitmapFactory.decodeByteArray(paramJSONObject, 0, paramJSONObject.length);
        }
      }
      catch (Exception paramJSONObject)
      {
        do
        {
          for (;;)
          {
            QLog.e("AppBrandRuntime", 1, "startShareToWeChat. get an exception when handling URLbmp:" + paramJSONObject);
            paramJSONObject = ImageUtil.drawableToBitmap(this.val$activity.getResources().getDrawable(2130847472));
          }
        } while (this.val$shareType != 4);
        WXShareHelper.a().c(String.valueOf(System.currentTimeMillis()), "QQ小程序 · " + this.val$miniAppInfo.name + ": " + this.val$finalDescription, paramJSONObject, "", str);
        return;
      }
      if (this.val$shareType == 3)
      {
        WXShareHelper.a().d(String.valueOf(System.currentTimeMillis()), this.val$finalDescription, paramJSONObject, "QQ小程序 · " + this.val$miniAppInfo.name, str);
        return;
      }
    }
    long l = -1L;
    if (paramJSONObject != null)
    {
      paramBoolean = paramJSONObject.optBoolean("needShareCallBack", false);
      l = paramJSONObject.optLong("retCode");
    }
    for (paramJSONObject = paramJSONObject.optString("errMsg");; paramJSONObject = null)
    {
      if (!paramBoolean) {
        QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_share_suc", null, null);
      }
      if (this.val$activity == null)
      {
        QLog.e("ShareProxyImpl", 1, "startShareToWe activity is null?!!");
        return;
      }
      ThreadManagerV2.getUIHandlerV2().post(new ShareProxyImpl.4.1(this, l, paramJSONObject));
      return;
      paramBoolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ShareProxyImpl.4
 * JD-Core Version:    0.7.0.1
 */
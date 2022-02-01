package com.tencent.mobileqq.mini.appbrand.utils;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.util.ImageUtil;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import java.io.ByteArrayOutputStream;
import org.json.JSONObject;

final class ShareUtils$6
  implements MiniAppCmdInterface
{
  ShareUtils$6(Activity paramActivity, String paramString1, int paramInt, String paramString2, ApkgInfo paramApkgInfo) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("startShareToWeChat. isSuc:");
    ((StringBuilder)localObject1).append(paramBoolean);
    QLog.d("ShareUtils", 1, ((StringBuilder)localObject1).toString());
    boolean bool = false;
    if ((paramBoolean) && (paramJSONObject != null))
    {
      String str = paramJSONObject.optString("jump_url");
      if (paramJSONObject.optBoolean("needShareCallBack", false)) {
        QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_share_suc", null, null);
      }
      Object localObject2;
      try
      {
        paramJSONObject = URLDrawable.URLDrawableOptions.obtain();
        if (this.val$activity != null) {
          paramJSONObject.mFailedDrawable = this.val$activity.getResources().getDrawable(2130848661);
        }
        localObject1 = ImageUtil.drawableToBitmap(URLDrawable.getDrawable(this.val$sharePicUrl, paramJSONObject).getCurrDrawable());
        paramJSONObject = (JSONObject)localObject1;
        if (localObject1 != null)
        {
          paramJSONObject = new ByteArrayOutputStream();
          ((Bitmap)localObject1).compress(Bitmap.CompressFormat.JPEG, 85, paramJSONObject);
          paramJSONObject = paramJSONObject.toByteArray();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("startShareToWeChat. ImageUtil.drawableToBitmap, out.toByteArray().length original:");
          ((StringBuilder)localObject2).append(paramJSONObject.length);
          QLog.d("ShareUtils", 1, ((StringBuilder)localObject2).toString());
          i = 0;
          while ((i < 10) && (paramJSONObject.length > 32768))
          {
            paramJSONObject = new Matrix();
            paramJSONObject.setScale(0.7F, 0.7F);
            localObject1 = Bitmap.createBitmap((Bitmap)localObject1, 0, 0, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight(), paramJSONObject, true);
            paramJSONObject = new ByteArrayOutputStream();
            ((Bitmap)localObject1).compress(Bitmap.CompressFormat.JPEG, 85, paramJSONObject);
            paramJSONObject = paramJSONObject.toByteArray();
            i += 1;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("startShareToWeChat. ImageUtil.drawableToBitmap, out.toByteArray().length compressTo:");
            ((StringBuilder)localObject2).append(paramJSONObject.length);
            QLog.d("ShareUtils", 1, ((StringBuilder)localObject2).toString());
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("startShareToWeChat. ImageUtil.drawableToBitmap, out.toByteArray().length done:");
          ((StringBuilder)localObject1).append(paramJSONObject.length);
          QLog.d("ShareUtils", 1, ((StringBuilder)localObject1).toString());
          paramJSONObject = BitmapFactory.decodeByteArray(paramJSONObject, 0, paramJSONObject.length);
        }
      }
      catch (Exception paramJSONObject)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("startShareToWeChat. get an exception when handling URLbmp:");
        ((StringBuilder)localObject1).append(paramJSONObject);
        QLog.e("ShareUtils", 1, ((StringBuilder)localObject1).toString());
        paramJSONObject = ImageUtil.drawableToBitmap(this.val$activity.getResources().getDrawable(2130848661));
      }
      int i = this.val$shareType;
      if (i == 3)
      {
        localObject1 = WXShareHelper.a();
        l = System.currentTimeMillis();
        localObject2 = this.val$finalDescription;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("QQ小程序 · ");
        localStringBuilder.append(this.val$apkgInfo.apkgName);
        ((WXShareHelper)localObject1).d(String.valueOf(l), (String)localObject2, paramJSONObject, localStringBuilder.toString(), str);
      }
      else if (i == 4)
      {
        localObject1 = WXShareHelper.a();
        l = System.currentTimeMillis();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("QQ小程序 · ");
        ((StringBuilder)localObject2).append(this.val$apkgInfo.apkgName);
        ((StringBuilder)localObject2).append(": ");
        ((StringBuilder)localObject2).append(this.val$finalDescription);
        ((WXShareHelper)localObject1).c(String.valueOf(l), ((StringBuilder)localObject2).toString(), paramJSONObject, "", str);
      }
      paramJSONObject = new Bundle();
      paramJSONObject.putParcelable("MiniAppInfoForQQ", this.val$apkgInfo.appConfig.config);
      paramJSONObject.putParcelable("MiniAppLaunchParamForQQ", this.val$apkgInfo.appConfig.launchParam);
      QIPCClientHelper.getInstance().getClient().callServer("MiniAppTransferModule", "mini_record_wx_share_miniapp_for_qq", paramJSONObject);
      return;
    }
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
    if (this.val$activity == null)
    {
      QLog.e("ShareUtils", 1, "startShareToWe activity is null?!!");
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(new ShareUtils.6.1(this, l, paramJSONObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.utils.ShareUtils.6
 * JD-Core Version:    0.7.0.1
 */
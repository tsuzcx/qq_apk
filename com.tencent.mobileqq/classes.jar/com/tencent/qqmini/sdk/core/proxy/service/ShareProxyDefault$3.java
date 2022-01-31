package com.tencent.qqmini.sdk.core.proxy.service;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import beiw;
import bekr;
import bers;
import berz;
import besl;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import org.json.JSONObject;

class ShareProxyDefault$3
  implements AsyncResult
{
  ShareProxyDefault$3(ShareProxyDefault paramShareProxyDefault, Activity paramActivity, bers parambers, MiniAppInfo paramMiniAppInfo, String paramString, AsyncResult paramAsyncResult, int paramInt) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    besl.a("ShareProxy", "startShareToWeChat. isSuc:" + paramBoolean);
    Object localObject3 = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
    if ((paramBoolean) && (paramJSONObject != null))
    {
      String str = paramJSONObject.optString("jump_url");
      if (paramJSONObject.optBoolean("needShareCallBack", false)) {
        ((MiniAppProxy)localObject3).callServer("MiniMsgIPCServer", "cmd_mini_share_suc", null);
      }
      try
      {
        localObject1 = this.val$activity.getResources().getDrawable(2130847466);
        localObject3 = bekr.a(((MiniAppProxy)localObject3).getDrawable(this.val$activity, this.val$shareData.b, 0, 0, (Drawable)localObject1));
        localObject1 = localObject3;
        if (localObject3 != null)
        {
          localObject1 = new ByteArrayOutputStream();
          ((Bitmap)localObject3).compress(Bitmap.CompressFormat.JPEG, 85, (OutputStream)localObject1);
          localObject1 = ((ByteArrayOutputStream)localObject1).toByteArray();
          besl.a("ShareProxy", "startShareToWeChat. ImageUtil.drawableToBitmap, out.toByteArray().length original:" + localObject1.length);
          int i = 0;
          while ((i < 10) && (localObject1.length > 32768))
          {
            localObject1 = new Matrix();
            ((Matrix)localObject1).setScale(0.7F, 0.7F);
            localObject3 = Bitmap.createBitmap((Bitmap)localObject3, 0, 0, ((Bitmap)localObject3).getWidth(), ((Bitmap)localObject3).getHeight(), (Matrix)localObject1, true);
            localObject1 = new ByteArrayOutputStream();
            ((Bitmap)localObject3).compress(Bitmap.CompressFormat.JPEG, 85, (OutputStream)localObject1);
            localObject1 = ((ByteArrayOutputStream)localObject1).toByteArray();
            besl.a("ShareProxy", "startShareToWeChat. ImageUtil.drawableToBitmap, out.toByteArray().length compressTo:" + localObject1.length);
            i += 1;
          }
          besl.a("ShareProxy", "startShareToWeChat. ImageUtil.drawableToBitmap, out.toByteArray().length done:" + localObject1.length);
          localObject1 = BitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject1;
          besl.d("ShareProxy", "startShareToWeChat. get an exception when handling URLbmp:" + localException);
          localObject2 = bekr.a(this.val$activity.getResources().getDrawable(2130847466));
          continue;
          if (this.val$shareType == 4) {
            this.this$0.shareToWxTimeline(this.val$activity, (berz)localObject3);
          }
        }
      }
      localObject3 = new berz();
      ((berz)localObject3).b = this.val$miniAppInfo.name;
      ((berz)localObject3).c = this.val$finalDescription;
      ((berz)localObject3).jdField_a_of_type_Boolean = false;
      ((berz)localObject3).jdField_a_of_type_JavaLangString = this.val$shareData.b;
      ((berz)localObject3).jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject1);
      ((berz)localObject3).d = str;
      ((berz)localObject3).e = this.val$miniAppInfo.appId;
      ((berz)localObject3).f = this.val$miniAppInfo.name;
      ((berz)localObject3).g = this.val$miniAppInfo.iconUrl;
      ((berz)localObject3).jdField_a_of_type_Bert = new ShareProxyDefault.3.1(this, paramJSONObject);
      if (this.val$shareType == 3)
      {
        this.this$0.shareToWxSession(this.val$activity, (berz)localObject3);
        if (this.val$result != null) {
          this.val$result.onReceiveResult(true, paramJSONObject);
        }
        return;
      }
    }
    long l = -1L;
    if (paramJSONObject != null)
    {
      paramBoolean = paramJSONObject.optBoolean("needShareCallBack", false);
      l = paramJSONObject.optLong("retCode");
    }
    for (Object localObject2 = paramJSONObject.optString("errMsg");; localObject2 = null)
    {
      if (!paramBoolean) {
        ((MiniAppProxy)localObject3).callServer("MiniMsgIPCServer", "cmd_mini_share_suc", null);
      }
      if (this.val$result != null) {
        this.val$result.onReceiveResult(true, paramJSONObject);
      }
      if (this.val$activity == null)
      {
        besl.d("ShareProxy", "startShareToWe activity is null?!!");
        return;
      }
      beiw.c().post(new ShareProxyDefault.3.2(this, l, (String)localObject2));
      return;
      paramBoolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.ShareProxyDefault.3
 * JD-Core Version:    0.7.0.1
 */
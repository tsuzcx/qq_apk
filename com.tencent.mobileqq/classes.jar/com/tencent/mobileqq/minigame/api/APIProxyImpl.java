package com.tencent.mobileqq.minigame.api;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.RequestBody;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.QQFriendsJsPlugin;
import com.tencent.mobileqq.mini.http.MiniOkHttpClientFactory;
import com.tencent.mobileqq.mini.out.activity.PermissionSettingFragment;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.minigame.manager.GameInfoManager;
import com.tencent.mobileqq.triton.sdk.APICallback;
import com.tencent.mobileqq.triton.sdk.APIProxy;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import java.util.Locale;

public class APIProxyImpl
  implements APIProxy
{
  private static final String TAG = "APIProxyImpl";
  private static final String TAG_SUBPACKAGE = "subpackage";
  private ITTEngine mTTEngine;
  
  private void performRequest(long paramLong, String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte, String paramString4, String paramString5, String[] paramArrayOfString)
  {
    APIProxyImpl.1 local1 = new APIProxyImpl.1(this, System.currentTimeMillis(), paramString1, paramLong);
    Request.Builder localBuilder = new Request.Builder().url(paramString1);
    if (paramArrayOfString != null)
    {
      paramString1 = null;
      int i = 0;
      if (i < paramArrayOfString.length)
      {
        if (i % 2 == 0) {
          paramString1 = paramArrayOfString[i];
        }
        for (;;)
        {
          i += 1;
          break;
          localBuilder.addHeader(paramString1, paramArrayOfString[i]);
        }
      }
    }
    if (!TextUtils.isEmpty(paramString4)) {
      localBuilder.addHeader("Referer", paramString4);
    }
    if (!TextUtils.isEmpty(paramString5)) {
      localBuilder.addHeader("Cookie", paramString5);
    }
    if ("GET".equalsIgnoreCase(paramString2)) {
      localBuilder.get();
    }
    for (;;)
    {
      MiniOkHttpClientFactory.getDownloadClient(true).newCall(localBuilder.build()).enqueue(local1);
      return;
      if (paramString3 != null) {
        localBuilder.method(paramString2.toLowerCase(Locale.US), RequestBody.create(MediaType.parse("text/plain"), paramString3));
      } else if (paramArrayOfByte != null) {
        localBuilder.method(paramString2.toLowerCase(Locale.US), RequestBody.create(MediaType.parse("application/octet-stream"), paramArrayOfByte));
      } else {
        localBuilder.method(paramString2.toLowerCase(Locale.US), RequestBody.create(MediaType.parse("text/plain"), ""));
      }
    }
  }
  
  private void reportHttp(long paramLong, int paramInt)
  {
    MiniReportManager.reportEventType(GameInfoManager.g().getMiniAppConfig(), 1027, null, null, null, paramInt, "1", paramLong, null);
  }
  
  public void doAddFriend(Context paramContext, String paramString, APICallback paramAPICallback)
  {
    QQFriendsJsPlugin.doAddFriend(paramContext, GameInfoManager.g().getAppId(), paramString, new APIProxyImpl.2(this, paramAPICallback));
  }
  
  public void gotoPermissionSetting(Activity paramActivity)
  {
    PermissionSettingFragment.launchForResult(paramActivity, GameInfoManager.g().getAppId(), GameInfoManager.g().getAppName(), 5);
  }
  
  public void httpRequestForImage(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String[] paramArrayOfString, boolean paramBoolean)
  {
    if ((paramString2 == null) || ("".equals(paramString2))) {
      return;
    }
    performRequest(paramLong, paramString1, paramString2, paramString3, null, paramString4, paramString5, paramArrayOfString);
  }
  
  public void setTTEngine(ITTEngine paramITTEngine)
  {
    this.mTTEngine = paramITTEngine;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.api.APIProxyImpl
 * JD-Core Version:    0.7.0.1
 */
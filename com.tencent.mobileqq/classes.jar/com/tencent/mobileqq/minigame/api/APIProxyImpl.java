package com.tencent.mobileqq.minigame.api;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.QQFriendsJsPlugin;
import com.tencent.mobileqq.mini.http.MiniOkHttpClientFactory;
import com.tencent.mobileqq.mini.out.activity.PermissionSettingFragment;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.minigame.manager.GameInfoManager;
import com.tencent.mobileqq.minigame.manager.GameRuntimeLoader;
import com.tencent.mobileqq.triton.sdk.APICallback;
import com.tencent.mobileqq.triton.sdk.APIProxy;
import java.util.Locale;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;

public class APIProxyImpl
  implements APIProxy
{
  private final String TAG = toString();
  private GameRuntimeLoader mRuntimeLoader;
  
  public APIProxyImpl(GameRuntimeLoader paramGameRuntimeLoader)
  {
    this.mRuntimeLoader = paramGameRuntimeLoader;
  }
  
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
    MiniReportManager.reportEventType(this.mRuntimeLoader.getGameInfoManager().getMiniAppConfig(), 1027, null, null, null, paramInt, "1", paramLong, null);
  }
  
  public void doAddFriend(Context paramContext, String paramString, APICallback paramAPICallback)
  {
    QQFriendsJsPlugin.doAddFriend(paramContext, this.mRuntimeLoader.getGameInfoManager().getAppId(), paramString, new APIProxyImpl.2(this, paramAPICallback));
  }
  
  public void gotoPermissionSetting(Activity paramActivity)
  {
    PermissionSettingFragment.launchForResult(paramActivity, this.mRuntimeLoader.getGameInfoManager().getAppId(), this.mRuntimeLoader.getGameInfoManager().getAppName(), 5);
  }
  
  public void httpRequestForImage(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String[] paramArrayOfString, boolean paramBoolean)
  {
    if ((paramString2 == null) || ("".equals(paramString2))) {
      return;
    }
    performRequest(paramLong, paramString1, paramString2, paramString3, null, paramString4, paramString5, paramArrayOfString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.api.APIProxyImpl
 * JD-Core Version:    0.7.0.1
 */
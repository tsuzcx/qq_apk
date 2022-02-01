package com.tencent.mobileqq.qrscan;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.olympic.activity.ScanTorchConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qrscan.api.IQRScanAbilityApi;
import mqq.app.AppRuntime;

public class ARLauncher
{
  private AppRuntime a;
  private final Activity b;
  private long c;
  private boolean d;
  private boolean e = true;
  private long f = -1L;
  private String g;
  
  public ARLauncher(Activity paramActivity, AppRuntime paramAppRuntime, String paramString, long paramLong1, boolean paramBoolean1, boolean paramBoolean2, long paramLong2)
  {
    this.b = paramActivity;
    this.a = paramAppRuntime;
    this.c = paramLong1;
    this.d = paramBoolean1;
    this.e = paramBoolean2;
    this.f = paramLong2;
    this.g = paramString;
  }
  
  public void a()
  {
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(this.b, "/base/activity/ScanTorchActivity");
    localActivityURIRequest.setFlags(67174400);
    localActivityURIRequest.extra().putLong("click_time", this.c);
    localActivityURIRequest.extra().putLong("launch_time", System.currentTimeMillis());
    localActivityURIRequest.extra().putBoolean("first_click", this.e);
    localActivityURIRequest.extra().putBoolean("proc_exist", this.d);
    boolean bool = this.b.getSharedPreferences("immerse_ar", 0).getBoolean("software", false);
    localActivityURIRequest.extra().putBoolean("software", bool);
    localActivityURIRequest.extra().putBoolean("log_on", ScanTorchConstants.a);
    Object localObject1 = localActivityURIRequest.extra();
    Object localObject2 = (IQRScanAbilityApi)QRoute.api(IQRScanAbilityApi.class);
    AppRuntime localAppRuntime = this.a;
    ((Bundle)localObject1).putString("CurrentNickname", ((IQRScanAbilityApi)localObject2).getFriendDisplayNameJustCache(localAppRuntime, localAppRuntime.getCurrentAccountUin()));
    localActivityURIRequest.extra().putBoolean("from_qr", true);
    localActivityURIRequest.extra().putInt("key_entrance_type", this.b.getIntent().getIntExtra("key_entrance_type", 0));
    if ((!"Conversation".equals(this.g)) && (!"web-ar".equals(this.g))) {
      bool = false;
    } else {
      bool = true;
    }
    localActivityURIRequest.extra().putBoolean("ar_enabled", bool);
    localActivityURIRequest.extra().putBoolean("hide_album", this.b.getIntent().getBooleanExtra("hide_album", false));
    localActivityURIRequest.extra().putString("from", this.g);
    if ((TextUtils.equals("web-ar", this.g)) && (this.b.getIntent() != null))
    {
      localActivityURIRequest.extra().putLong("click_time", this.b.getIntent().getLongExtra("click_time", this.c));
      localActivityURIRequest.extra().putInt("web_url_switch", this.b.getIntent().getIntExtra("web_url_switch", 0));
      localActivityURIRequest.extra().putBoolean("jump_from_web", this.b.getIntent().getBooleanExtra("jump_from_web", true));
      localActivityURIRequest.extra().putString("icon_text", this.b.getIntent().getStringExtra("icon_text"));
      localActivityURIRequest.extra().putString("icon_url", this.b.getIntent().getStringExtra("icon_url"));
    }
    localActivityURIRequest.extra().putLong("start_time", this.f);
    localObject2 = this.b.getIntent().getBundleExtra("web_invoke_params");
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new Bundle();
    }
    localActivityURIRequest.extra().putBundle("web_invoke_params", (Bundle)localObject1);
    localActivityURIRequest.setOverridePendingTransition(0, 0);
    localActivityURIRequest.setRequestCode(10);
    QRoute.startUri(localActivityURIRequest, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.ARLauncher
 * JD-Core Version:    0.7.0.1
 */
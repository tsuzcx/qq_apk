package com.tencent.mobileqq.qrscan;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IQRScanTempApi;
import mqq.app.AppRuntime;

public class ARLauncher
{
  private long jdField_a_of_type_Long;
  private final Activity jdField_a_of_type_AndroidAppActivity;
  private String jdField_a_of_type_JavaLangString;
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long = -1L;
  private boolean jdField_b_of_type_Boolean = true;
  
  public ARLauncher(Activity paramActivity, AppRuntime paramAppRuntime, String paramString, long paramLong1, boolean paramBoolean1, boolean paramBoolean2, long paramLong2)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_b_of_type_Boolean = paramBoolean2;
    this.jdField_b_of_type_Long = paramLong2;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, ScanTorchActivity.class);
    localIntent.addFlags(67108864);
    localIntent.addFlags(65536);
    localIntent.putExtra("click_time", this.jdField_a_of_type_Long);
    localIntent.putExtra("launch_time", System.currentTimeMillis());
    localIntent.putExtra("first_click", this.jdField_b_of_type_Boolean);
    localIntent.putExtra("proc_exist", this.jdField_a_of_type_Boolean);
    localIntent.putExtra("software", this.jdField_a_of_type_AndroidAppActivity.getSharedPreferences("immerse_ar", 0).getBoolean("software", false));
    localIntent.putExtra("log_on", ScanTorchActivity.jdField_b_of_type_Boolean);
    Object localObject1 = (IQRScanTempApi)QRoute.api(IQRScanTempApi.class);
    Object localObject2 = this.jdField_a_of_type_MqqAppAppRuntime;
    localIntent.putExtra("CurrentNickname", ((IQRScanTempApi)localObject1).getFriendDisplayNameJustCache((AppRuntime)localObject2, ((AppRuntime)localObject2).getCurrentAccountUin()));
    localIntent.putExtra("from_qr", true);
    boolean bool;
    if ((!"Conversation".equals(this.jdField_a_of_type_JavaLangString)) && (!"web-ar".equals(this.jdField_a_of_type_JavaLangString))) {
      bool = false;
    } else {
      bool = true;
    }
    localIntent.putExtra("ar_enabled", bool);
    localIntent.putExtra("hide_album", this.jdField_a_of_type_AndroidAppActivity.getIntent().getBooleanExtra("hide_album", false));
    localIntent.putExtra("from", this.jdField_a_of_type_JavaLangString);
    if ((TextUtils.equals("web-ar", this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_AndroidAppActivity.getIntent() != null))
    {
      localIntent.putExtra("click_time", this.jdField_a_of_type_AndroidAppActivity.getIntent().getLongExtra("click_time", this.jdField_a_of_type_Long));
      localIntent.putExtra("web_url_switch", this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("web_url_switch", 0));
      localIntent.putExtra("jump_from_web", this.jdField_a_of_type_AndroidAppActivity.getIntent().getBooleanExtra("jump_from_web", true));
      localIntent.putExtra("icon_text", this.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("icon_text"));
      localIntent.putExtra("icon_url", this.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("icon_url"));
    }
    localIntent.putExtra("start_time", this.jdField_b_of_type_Long);
    localObject2 = this.jdField_a_of_type_AndroidAppActivity.getIntent().getBundleExtra("web_invoke_params");
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new Bundle();
    }
    localIntent.putExtra("web_invoke_params", (Bundle)localObject1);
    this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(localIntent, 10);
    this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.ARLauncher
 * JD-Core Version:    0.7.0.1
 */
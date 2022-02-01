package com.tencent.mobileqq.qrscan.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IQRDataApi;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URLDecoder;
import mqq.app.AppRuntime;

public class QRJumpActivity
  extends QBaseActivity
{
  protected QQProgressDialog a;
  private AppRuntime b;
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.b = getAppRuntime();
    String str1 = super.getIntent().getStringExtra("url");
    String str4 = super.getIntent().getStringExtra("attr_original_url");
    if (TextUtils.isEmpty(str1))
    {
      finish();
      return false;
    }
    if (isFinishing()) {
      return false;
    }
    this.a = new QQProgressDialog(this, super.getTitleBarHeight());
    this.a.c(2131914194);
    this.a.setOnCancelListener(new QRJumpActivity.1(this));
    this.a.show();
    paramBundle = null;
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject2;
    try
    {
      localObject2 = URLDecoder.decode(str1);
    }
    catch (Exception localException1)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("QRJumpActivity doOnCreate URLDecoder.decode error:");
      ((StringBuilder)localObject2).append(localException1.getMessage());
      QLog.e("IQRScanConst_QRJumpActivity", 1, ((StringBuilder)localObject2).toString());
      localObject2 = null;
    }
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      finish();
      return false;
    }
    Object localObject1 = Uri.parse((String)localObject2);
    if (!((Uri)localObject1).isHierarchical())
    {
      finish();
      return false;
    }
    String str2;
    if (localObject1 == null) {
      str2 = null;
    } else {
      str2 = ((Uri)localObject1).getQueryParameter("auth");
    }
    if (!TextUtils.isEmpty(str4))
    {
      int i;
      if (str4.startsWith("mqqopensdkapi://bizAgent/"))
      {
        localObject1 = "authSig";
        i = 1;
      }
      else
      {
        localObject1 = "authKey";
        i = 0;
      }
      if (i == 0) {
        break label375;
      }
      paramBundle = localObject4;
    }
    for (;;)
    {
      try
      {
        str3 = URLDecoder.decode(str4);
        paramBundle = localObject4;
        Uri localUri = Uri.parse(str3);
        if (str3 == null)
        {
          localObject1 = localObject3;
        }
        else
        {
          paramBundle = localObject4;
          localObject1 = localUri.getQueryParameter((String)localObject1);
        }
        paramBundle = (Bundle)localObject1;
        localObject1 = URLDecoder.decode((String)localObject1);
        paramBundle = (Bundle)localObject1;
      }
      catch (Exception localException2)
      {
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.i("IQRScanConst_QRJumpActivity", 2, String.format("JumpUrl authSig=%s oriUrl=%s", new Object[] { paramBundle, str4 }));
      }
      paramBundle = new QRJumpActivity.2(this, str2, paramBundle, this, (String)localObject2);
      ((IQRDataApi)QRoute.api(IQRDataApi.class)).requestUrlDecode(this.b, (String)localObject2, null, null, paramBundle);
      return true;
      label375:
      String str3 = str4;
    }
  }
  
  protected void doOnDestroy()
  {
    QQProgressDialog localQQProgressDialog = this.a;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.a.dismiss();
    }
    this.a = null;
    super.doOnDestroy();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.activity.QRJumpActivity
 * JD-Core Version:    0.7.0.1
 */
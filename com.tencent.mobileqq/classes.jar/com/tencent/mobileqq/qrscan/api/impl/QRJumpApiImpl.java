package com.tencent.mobileqq.qrscan.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.qrscan.QRActionEntity;
import com.tencent.mobileqq.qrscan.QRResultHandler;
import com.tencent.mobileqq.qrscan.activity.QRJumpActivity;
import com.tencent.mobileqq.qrscan.activity.ScannerActivity;
import com.tencent.mobileqq.qrscan.api.IQRJumpApi;
import mqq.app.AppRuntime;

public class QRJumpApiImpl
  implements IQRJumpApi
{
  public void displayQRCard(AppRuntime paramAppRuntime, Activity paramActivity, String paramString, int paramInt)
  {
    QRResultHandler.a(paramAppRuntime, paramActivity, paramString, paramInt);
  }
  
  public Class<?> getScannerActivityCls()
  {
    return ScannerActivity.class;
  }
  
  public int handleResult(AppRuntime paramAppRuntime, Activity paramActivity, QRActionEntity paramQRActionEntity, String paramString, Bundle paramBundle)
  {
    return QRResultHandler.a(paramAppRuntime, paramActivity, paramQRActionEntity, paramString, paramBundle);
  }
  
  public void startQRJumpActivity(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramContext, QRJumpActivity.class);
    localIntent.putExtra("url", paramString1);
    if (!TextUtils.isEmpty(paramString2)) {
      localIntent.putExtra("attr_original_url", paramString2);
    }
    localIntent.putExtra("fromQrcode", paramBoolean);
    paramContext.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.api.impl.QRJumpApiImpl
 * JD-Core Version:    0.7.0.1
 */
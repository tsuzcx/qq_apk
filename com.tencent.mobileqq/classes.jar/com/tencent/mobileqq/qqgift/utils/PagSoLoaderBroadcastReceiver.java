package com.tencent.mobileqq.qqgift.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.qqgift.mvvm.business.view.QQGiftPAGAnimationViewImpl;
import com.tencent.mobileqq.vas.api.IVasTempApi;
import com.tencent.mobileqq.vas.api.IVasTempApi.Companion;
import com.tencent.qphone.base.util.QLog;

public class PagSoLoaderBroadcastReceiver
  extends BroadcastReceiver
{
  public IntentFilter a()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction(AEResInfo.LIGHT_RES_BASE_PACKAGE.resPrefix);
    return localIntentFilter;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    paramIntent = new StringBuilder();
    paramIntent.append("AECameraBroadcastReceiver onReceive: action = ");
    paramIntent.append(paramContext);
    AEQLog.a("PagSoLoaderBroadcastReceiver", paramIntent.toString());
    paramContext = AEResInfo.getAEResInfoByPrefix(paramContext);
    paramIntent = new StringBuilder();
    paramIntent.append("PagSoLoaderBroadcastReceiver info: ");
    paramIntent.append(paramContext);
    QLog.e("PagSoLoaderBroadcastReceiver", 1, paramIntent.toString());
    paramContext = IVasTempApi.Companion.a();
    QQGiftPAGAnimationViewImpl.a.a(paramContext.initPagSo());
    QQGiftPAGAnimationViewImpl.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.utils.PagSoLoaderBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */
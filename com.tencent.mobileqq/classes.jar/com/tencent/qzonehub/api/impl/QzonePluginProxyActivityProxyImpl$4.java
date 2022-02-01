package com.tencent.qzonehub.api.impl;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hitrate.PreloadProcHitPluginSession;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.qzone.QZoneHelper.StartActivity;
import mqq.os.MqqHandler;

final class QzonePluginProxyActivityProxyImpl$4
  implements QZoneHelper.StartActivity
{
  QzonePluginProxyActivityProxyImpl$4(Intent paramIntent, String paramString, PreloadProcHitPluginSession paramPreloadProcHitPluginSession, int paramInt, boolean paramBoolean, Context paramContext, DialogInterface.OnDismissListener paramOnDismissListener) {}
  
  public void onStart(boolean paramBoolean1, boolean paramBoolean2)
  {
    String str = QzonePluginProxyActivityProxyImpl.getActivityNameToIntent(this.a);
    Class localClass = QzonePluginProxyActivityProxyImpl.PluginProxyActivityClassFactory.a(str);
    this.a.putExtra("userQqResources", 2);
    this.a.putExtra("click_time", System.currentTimeMillis());
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
    localPluginParams.d = "qzone_plugin.apk";
    localPluginParams.g = "QZone";
    localPluginParams.c = this.b;
    localPluginParams.m = this.c;
    localPluginParams.h = str;
    localPluginParams.i = localClass;
    localPluginParams.j = this.a;
    localPluginParams.k = this.d;
    if (this.e)
    {
      localPluginParams.s = 2130772196;
      localPluginParams.t = 2130772196;
    }
    localPluginParams.r = 60000;
    localPluginParams.q = null;
    localPluginParams.p = false;
    ThreadManager.getUIHandler().post(new QzonePluginProxyActivityProxyImpl.4.1(this, str, paramBoolean1, paramBoolean2, localPluginParams));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qzonehub.api.impl.QzonePluginProxyActivityProxyImpl.4
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.qzonehub.api.impl;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qzonehub.api.ITranslucentActivityProxy;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.qzone.QzonePluginProxyActivity;

public class TranslucentActivityProxyImpl
  implements ITranslucentActivityProxy
{
  public SharedPreferences getSharedPreferences(String paramString, int paramInt)
  {
    return SharedPreferencesProxyManager.getInstance().getProxy(paramString, paramInt);
  }
  
  public void startPlugin(Intent paramIntent, Activity paramActivity)
  {
    QQProgressDialog localQQProgressDialog;
    if (!((IPluginManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.MGR_PLUGIN)).isPlugininstalled("qzone_plugin.apk"))
    {
      localQQProgressDialog = new QQProgressDialog(paramActivity, paramActivity.getResources().getDimensionPixelSize(2080505856));
      localQQProgressDialog.a(HardCodeUtil.a(2131912357));
      localQQProgressDialog.setOnDismissListener(new TranslucentActivityProxyImpl.1(this, paramActivity));
    }
    else
    {
      localQQProgressDialog = null;
    }
    String str = QzonePluginProxyActivityProxyImpl.getActivityNameToIntent(paramIntent);
    paramIntent.putExtra("userQqResources", 2);
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
    localPluginParams.d = "qzone_plugin.apk";
    localPluginParams.g = "QZone";
    localPluginParams.c = "";
    localPluginParams.h = str;
    localPluginParams.i = QzonePluginProxyActivity.class;
    localPluginParams.j = paramIntent;
    localPluginParams.k = -1;
    localPluginParams.l = localQQProgressDialog;
    localPluginParams.r = 10000;
    localPluginParams.q = null;
    IPluginManager.a(paramActivity, localPluginParams);
    if (localQQProgressDialog == null) {
      paramActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qzonehub.api.impl.TranslucentActivityProxyImpl
 * JD-Core Version:    0.7.0.1
 */
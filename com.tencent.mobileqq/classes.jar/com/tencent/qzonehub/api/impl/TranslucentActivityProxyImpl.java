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
      localQQProgressDialog.a(HardCodeUtil.a(2131714858));
      localQQProgressDialog.setOnDismissListener(new TranslucentActivityProxyImpl.1(this, paramActivity));
    }
    else
    {
      localQQProgressDialog = null;
    }
    String str = QzonePluginProxyActivityProxyImpl.getActivityNameToIntent(paramIntent);
    paramIntent.putExtra("userQqResources", 2);
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
    localPluginParams.b = "qzone_plugin.apk";
    localPluginParams.e = "QZone";
    localPluginParams.jdField_a_of_type_JavaLangString = "";
    localPluginParams.f = str;
    localPluginParams.jdField_a_of_type_JavaLangClass = QzonePluginProxyActivity.class;
    localPluginParams.jdField_a_of_type_AndroidContentIntent = paramIntent;
    localPluginParams.c = -1;
    localPluginParams.jdField_a_of_type_AndroidAppDialog = localQQProgressDialog;
    localPluginParams.d = 10000;
    localPluginParams.g = null;
    IPluginManager.a(paramActivity, localPluginParams);
    if (localQQProgressDialog == null) {
      paramActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qzonehub.api.impl.TranslucentActivityProxyImpl
 * JD-Core Version:    0.7.0.1
 */
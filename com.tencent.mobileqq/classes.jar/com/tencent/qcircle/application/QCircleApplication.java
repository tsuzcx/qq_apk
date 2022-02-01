package com.tencent.qcircle.application;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostAppSettingUtil;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.richframework.AutoShadowPluginRuntime;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.qcircle.application.initprocess.QCircleInitChain;
import com.tencent.qphone.base.util.QLog;

public class QCircleApplication
  extends Application
{
  public static Application APP;
  public static final String PLUGIN_VERSION_KEY = "version";
  public static final String PLUGIN_VERSION_SP_NAME = "QCirclePluginVersion";
  public static final String SP_FILE_NAME_BUGLY_SDK = "BuglySdkInfos";
  public static final String SP_KEY_SUB_PRODUCT_ID = "9b16ced79b";
  private static final String TAG = "QCircleApplication";
  
  private void initCrashReport()
  {
    SharedPreferences.Editor localEditor = RFApplication.getApplication().getSharedPreferences("BuglySdkInfos", 0).edit();
    localEditor.putString("9b16ced79b", QCirclePluginGlobalInfo.l());
    localEditor.apply();
    savePluginInfo();
  }
  
  public static boolean isRDMVersion()
  {
    return (!TextUtils.isEmpty(HostDataTransUtils.getQUA3())) && (HostDataTransUtils.getQUA3().endsWith("RDM_B")) && (!HostAppSettingUtil.isPublicVersion()) && (!HostAppSettingUtil.isGrayVersion());
  }
  
  public void init(Application paramApplication)
  {
    APP = paramApplication;
    AutoShadowPluginRuntime.a().a(paramApplication);
    initCrashReport();
    new QCircleInitChain().a().b();
  }
  
  public void onCreate()
  {
    super.onCreate();
    init(this);
  }
  
  public void savePluginInfo()
  {
    Object localObject = RFApplication.getApplication().getSharedPreferences("QCirclePluginVersion", 4).edit();
    String str = QCirclePluginGlobalInfo.m();
    ((SharedPreferences.Editor)localObject).putString("version", str);
    ((SharedPreferences.Editor)localObject).apply();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("savePluginInfo:");
    ((StringBuilder)localObject).append(str);
    QLog.d("QCircleApplication", 1, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.application.QCircleApplication
 * JD-Core Version:    0.7.0.1
 */
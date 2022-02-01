package com.tencent.mobileqq.intervideo.huayang;

import Override;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import aunx;
import auoa;
import auob;
import auod;
import auof;
import auoj;
import auok;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import com.tencent.hydevteam.pluginframework.installedplugin.UseDynamicPluginLoaderInstalledPlugin;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.shadow.core.common.InstalledApk;
import com.tencent.shadow.dynamic.host.DynamicRuntime;
import cooperation.qzone.util.ProcessUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class HuayangLoadbackgroudActivity
  extends Activity
{
  public static long a;
  private static BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private static Map<String, InstalledApk> jdField_a_of_type_JavaUtilMap = new HashMap();
  private auod jdField_a_of_type_Auod;
  private auof jdField_a_of_type_Auof = new auob(this);
  private IVPluginInfo jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo;
  private String jdField_a_of_type_JavaLangString;
  private long b;
  
  static
  {
    jdField_a_of_type_AndroidContentBroadcastReceiver = new auoa();
    if (TextUtils.equals(ProcessUtils.getCurProcessName(BaseApplicationImpl.sApplication), BaseApplicationImpl.sApplication.getPackageName() + ":troophomework"))
    {
      IntentFilter localIntentFilter = new IntentFilter("action_iv_plugin_update");
      BaseApplicationImpl.sApplication.registerReceiver(jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
  }
  
  private void a()
  {
    requestWindowFeature(1);
    Window localWindow = getWindow();
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.flags |= 0x20;
    localLayoutParams.flags |= 0x80;
    localLayoutParams.alpha = 0.0F;
    localLayoutParams.width = 2;
    localLayoutParams.height = 2;
    localWindow.setAttributes(localLayoutParams);
  }
  
  public static void a(Context paramContext, String paramString1, IVPluginInfo paramIVPluginInfo, InstalledPlugin paramInstalledPlugin, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, String paramString4, long paramLong)
  {
    Intent localIntent = new Intent(paramContext, HuayangLoadbackgroudActivity.class);
    localIntent.setFlags(268435456);
    localIntent.putExtra("plugin", paramInstalledPlugin);
    localIntent.putExtra("pageUri", paramString3);
    localIntent.putExtra("uin", paramString2);
    localIntent.putExtra("needStart", paramBoolean1);
    localIntent.putExtra("isMainPlugin", paramBoolean2);
    localIntent.putExtra("ivpluginInfo", paramIVPluginInfo);
    localIntent.putExtra("launchpkgname", paramString1);
    localIntent.putExtra("appName", paramString4);
    localIntent.putExtra("key_start_flag", paramLong);
    paramContext.startActivity(localIntent);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void onBackPressed()
  {
    if (aunx.a(this.jdField_a_of_type_JavaLangString)) {
      auoj.a("2691706");
    }
    for (;;)
    {
      finish();
      sendBroadcast(new Intent(aunx.b(this.jdField_a_of_type_JavaLangString)));
      return;
      if (aunx.b(this.jdField_a_of_type_JavaLangString)) {
        auoj.a("2597724");
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    boolean bool1 = getIntent().getBooleanExtra("isPreload", false);
    if ((paramBundle != null) || (bool1)) {
      finish();
    }
    long l;
    do
    {
      return;
      this.b = System.currentTimeMillis();
      a();
      bool1 = getIntent().getBooleanExtra("isMainPlugin", false);
      l = getIntent().getLongExtra("key_start_flag", 0L);
      if (QLog.isColorLevel()) {
        QLog.d("HuayangPluginNewDownloader", 2, "LoadingActivity onCreate：" + this.b + " isMainPlugin:" + bool1);
      }
      if (!bool1) {
        break label156;
      }
      if ((jdField_a_of_type_Long == 0L) || (jdField_a_of_type_Long != l)) {
        break;
      }
      finish();
    } while (!QLog.isColorLevel());
    QLog.d("HuayangPluginLauncher", 2, "不启动下载的新插件");
    return;
    jdField_a_of_type_Long = l;
    label156:
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("launchpkgname");
    paramBundle = getIntent().getStringExtra("appName");
    UseDynamicPluginLoaderInstalledPlugin localUseDynamicPluginLoaderInstalledPlugin = (UseDynamicPluginLoaderInstalledPlugin)getIntent().getSerializableExtra("plugin");
    if ((InstalledApk)jdField_a_of_type_JavaUtilMap.get(paramBundle) == null)
    {
      localObject1 = localUseDynamicPluginLoaderInstalledPlugin.dynamicPluginContainerFile;
      localObject2 = localUseDynamicPluginLoaderInstalledPlugin.dynamicPluginLoaderVersion;
      localObject2 = new File(((File)localObject1).getParentFile(), "plugin_container_odex_" + (String)localObject2);
      ((File)localObject2).mkdirs();
      localObject1 = new InstalledApk(((File)localObject1).getAbsolutePath(), ((File)localObject2).getAbsolutePath(), null);
      DynamicRuntime.loadRuntime((InstalledApk)localObject1);
      DynamicRuntime.saveLastRuntimeInfo(this, (InstalledApk)localObject1);
      jdField_a_of_type_JavaUtilMap.put(paramBundle, localObject1);
    }
    Object localObject1 = getIntent().getExtras();
    ((Bundle)localObject1).setClassLoader(getClass().getClassLoader());
    Object localObject2 = ((Bundle)localObject1).getString("pageUri");
    String str = ((Bundle)localObject1).getString("uin");
    this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo = ((IVPluginInfo)((Bundle)localObject1).getParcelable("ivpluginInfo"));
    boolean bool2 = ((Bundle)localObject1).getBoolean("needStart", false);
    auoj.a = TextUtils.equals(paramBundle, "hy_sixgod");
    auok.a(this, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.c = this.jdField_a_of_type_JavaLangString;
    if (bool1)
    {
      if (aunx.a(this.jdField_a_of_type_JavaLangString)) {
        auoj.a("2691705");
      }
      for (;;)
      {
        this.jdField_a_of_type_Auod = auod.a(this, localUseDynamicPluginLoaderInstalledPlugin);
        this.jdField_a_of_type_Auod.a(this.jdField_a_of_type_Auof);
        this.jdField_a_of_type_Auod.a((String)localObject2, bool2, true, this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo, str, paramBundle);
        return;
        if (aunx.b(this.jdField_a_of_type_JavaLangString)) {
          auoj.a("2597722");
        }
      }
    }
    auod.a(this, localUseDynamicPluginLoaderInstalledPlugin).a((String)localObject2, bool2, false, this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo, str, paramBundle);
    finish();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Auod != null) {
      this.jdField_a_of_type_Auod.b(this.jdField_a_of_type_Auof);
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.HuayangLoadbackgroudActivity
 * JD-Core Version:    0.7.0.1
 */
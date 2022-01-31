package com.tencent.mobileqq.intervideo.huayang;

import adkg;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import com.tencent.hydevteam.pluginframework.pluginloader.DynamicPluginContainerLoader;
import com.tencent.hydevteam.pluginframework.pluginloader.exceptions.PluginContainerLoadException;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.qphone.base.util.QLog;

public class HuayangLoadbackgroudActivity
  extends Activity
{
  private long jdField_a_of_type_Long;
  private IVPluginInfo jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo;
  private HuayangPluginLauncher.HuayangPluginLauncherListener jdField_a_of_type_ComTencentMobileqqIntervideoHuayangHuayangPluginLauncher$HuayangPluginLauncherListener = new adkg(this);
  private HuayangPluginLauncher jdField_a_of_type_ComTencentMobileqqIntervideoHuayangHuayangPluginLauncher;
  private String jdField_a_of_type_JavaLangString;
  
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
  
  public static void a(Context paramContext, String paramString1, IVPluginInfo paramIVPluginInfo, InstalledPlugin paramInstalledPlugin, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, String paramString4)
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
    paramContext.startActivity(localIntent);
  }
  
  public void onBackPressed()
  {
    if (HuayangJsPlugin.a(this.jdField_a_of_type_JavaLangString)) {
      Monitor.a("2691706");
    }
    for (;;)
    {
      finish();
      sendBroadcast(new Intent(HuayangJsPlugin.b(this.jdField_a_of_type_JavaLangString)));
      return;
      if (HuayangJsPlugin.b(this.jdField_a_of_type_JavaLangString)) {
        Monitor.a("2597724");
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getIntent().getBooleanExtra("isPreload", false))
    {
      finish();
      return;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("HuayangPluginNewDownloader", 2, "LoadingActivity onCreate：" + this.jdField_a_of_type_Long);
    }
    a();
    boolean bool1 = getIntent().getBooleanExtra("isMainPlugin", false);
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("launchpkgname");
    paramBundle = (InstalledPlugin)getIntent().getSerializableExtra("plugin");
    Object localObject = new DynamicPluginContainerLoader();
    String str1;
    String str2;
    String str3;
    boolean bool2;
    for (;;)
    {
      try
      {
        ((DynamicPluginContainerLoader)localObject).load(paramBundle);
        localObject = getIntent().getExtras();
        ((Bundle)localObject).setClassLoader(getClass().getClassLoader());
        str1 = ((Bundle)localObject).getString("pageUri");
        str2 = ((Bundle)localObject).getString("uin");
        str3 = ((Bundle)localObject).getString("appName");
        this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo = ((IVPluginInfo)((Bundle)localObject).getParcelable("ivpluginInfo"));
        bool2 = ((Bundle)localObject).getBoolean("needStart", false);
        Monitor.a = TextUtils.equals(str3, "hy_sixgod");
        this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.c = this.jdField_a_of_type_JavaLangString;
        if (!bool1) {
          break;
        }
        if (HuayangJsPlugin.a(this.jdField_a_of_type_JavaLangString))
        {
          Monitor.a("2691705");
          this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangHuayangPluginLauncher = HuayangPluginLauncher.a(this, paramBundle);
          this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangHuayangPluginLauncher.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangHuayangPluginLauncher$HuayangPluginLauncherListener);
          this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangHuayangPluginLauncher.a(str1, bool2, true, this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo, str2, str3);
          return;
        }
      }
      catch (PluginContainerLoadException paramBundle)
      {
        Monitor.a("2490058");
        paramBundle = new Intent(HuayangJsPlugin.a(this.jdField_a_of_type_JavaLangString));
        paramBundle.putExtra("key_state", 7);
        sendBroadcast(paramBundle);
        finish();
        return;
      }
      if (HuayangJsPlugin.b(this.jdField_a_of_type_JavaLangString)) {
        Monitor.a("2597722");
      } else {
        MonitorConfig.a();
      }
    }
    HuayangPluginLauncher.a(this, paramBundle).a(str1, bool2, false, this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo, str2, str3);
    finish();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangHuayangPluginLauncher != null) {
      this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangHuayangPluginLauncher.b(this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangHuayangPluginLauncher$HuayangPluginLauncherListener);
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.HuayangLoadbackgroudActivity
 * JD-Core Version:    0.7.0.1
 */
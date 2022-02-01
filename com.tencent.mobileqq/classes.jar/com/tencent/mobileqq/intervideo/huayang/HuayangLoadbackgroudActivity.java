package com.tencent.mobileqq.intervideo.huayang;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import com.tencent.hydevteam.pluginframework.installedplugin.UseDynamicPluginLoaderInstalledPlugin;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.core.common.InstalledApk;
import com.tencent.shadow.dynamic.host.DynamicRuntime;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class HuayangLoadbackgroudActivity
  extends Activity
{
  public static long a;
  private static Map<String, InstalledApk> f = new HashMap();
  private static BroadcastReceiver g = new HuayangLoadbackgroudActivity.1();
  private IHuayangPluginLauncher b;
  private IVPluginInfo c;
  private long d = 0L;
  private String e;
  private IHuayangPluginLauncher.HuayangPluginLauncherListener h = new HuayangLoadbackgroudActivity.2(this);
  
  static
  {
    ((IHuayangLoadbackgroudActivityUtil)QRoute.api(IHuayangLoadbackgroudActivityUtil.class)).init();
  }
  
  public static BroadcastReceiver a()
  {
    return g;
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
  
  private void b()
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
  
  public void onBackPressed()
  {
    if (((IHuayangJsPlugin)QRoute.api(IHuayangJsPlugin.class)).isODPkg(this.e)) {
      Monitor.a("2691706");
    } else if (((IHuayangJsPlugin)QRoute.api(IHuayangJsPlugin.class)).isHyPkg(this.e)) {
      Monitor.a("2597724");
    }
    finish();
    sendBroadcast(new Intent(((IHuayangJsPlugin)QRoute.api(IHuayangJsPlugin.class)).getBackNotifyAction(this.e)));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    boolean bool1 = getIntent().getBooleanExtra("isPreload", false);
    if ((paramBundle == null) && (!bool1))
    {
      this.d = System.currentTimeMillis();
      b();
      bool1 = getIntent().getBooleanExtra("isMainPlugin", false);
      long l1 = getIntent().getLongExtra("key_start_flag", 0L);
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("LoadingActivity onCreate：");
        paramBundle.append(this.d);
        paramBundle.append(" isMainPlugin:");
        paramBundle.append(bool1);
        QLog.d("IHuayangPluginNewDownloader", 2, paramBundle.toString());
      }
      if (bool1)
      {
        long l2 = a;
        if ((l2 != 0L) && (l2 == l1))
        {
          finish();
          if (QLog.isColorLevel()) {
            QLog.d("IHuayangPluginLauncher", 2, "不启动下载的新插件");
          }
          return;
        }
        a = l1;
      }
      this.e = getIntent().getStringExtra("launchpkgname");
      paramBundle = getIntent().getStringExtra("appName");
      UseDynamicPluginLoaderInstalledPlugin localUseDynamicPluginLoaderInstalledPlugin = (UseDynamicPluginLoaderInstalledPlugin)getIntent().getSerializableExtra("plugin");
      if ((InstalledApk)f.get(paramBundle) == null)
      {
        localObject1 = localUseDynamicPluginLoaderInstalledPlugin.dynamicPluginContainerFile;
        localObject2 = localUseDynamicPluginLoaderInstalledPlugin.dynamicPluginLoaderVersion;
        localObject3 = ((File)localObject1).getParentFile();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("plugin_container_odex_");
        localStringBuilder.append((String)localObject2);
        localObject2 = new File((File)localObject3, localStringBuilder.toString());
        ((File)localObject2).mkdirs();
        localObject1 = new InstalledApk(((File)localObject1).getAbsolutePath(), ((File)localObject2).getAbsolutePath(), null);
        DynamicRuntime.loadRuntime((InstalledApk)localObject1);
        DynamicRuntime.saveLastRuntimeInfo(this, (InstalledApk)localObject1);
        f.put(paramBundle, localObject1);
      }
      Object localObject1 = getIntent().getExtras();
      ((Bundle)localObject1).setClassLoader(getClass().getClassLoader());
      Object localObject2 = ((Bundle)localObject1).getString("pageUri");
      Object localObject3 = ((Bundle)localObject1).getString("uin");
      this.c = ((IVPluginInfo)((Bundle)localObject1).getParcelable("ivpluginInfo"));
      boolean bool2 = ((Bundle)localObject1).getBoolean("needStart", false);
      Monitor.a(TextUtils.equals(paramBundle, "hy_sixgod"));
      MonitorConfig.a(this, paramBundle);
      this.c.c = this.e;
      if (bool1)
      {
        if (((IHuayangJsPlugin)QRoute.api(IHuayangJsPlugin.class)).isODPkg(this.e)) {
          Monitor.a("2691705");
        } else if (((IHuayangJsPlugin)QRoute.api(IHuayangJsPlugin.class)).isHyPkg(this.e)) {
          Monitor.a("2597722");
        }
        this.b = ((IHuayangPluginLauncher)QRoute.api(IHuayangPluginLauncher.class)).getInstance(this, localUseDynamicPluginLoaderInstalledPlugin);
        this.b.addLauncherListener(this.h);
        this.b.launchPlugin((String)localObject2, bool2, true, this.c, (String)localObject3, paramBundle);
        return;
      }
      ((IHuayangPluginLauncher)QRoute.api(IHuayangPluginLauncher.class)).getInstance(this, localUseDynamicPluginLoaderInstalledPlugin).launchPlugin((String)localObject2, bool2, false, this.c, (String)localObject3, paramBundle);
      finish();
      return;
    }
    finish();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    IHuayangPluginLauncher localIHuayangPluginLauncher = this.b;
    if (localIHuayangPluginLauncher != null) {
      localIHuayangPluginLauncher.removeLauncherListener(this.h);
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.HuayangLoadbackgroudActivity
 * JD-Core Version:    0.7.0.1
 */
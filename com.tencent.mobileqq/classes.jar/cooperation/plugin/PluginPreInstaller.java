package cooperation.plugin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.comic.api.IQQComicWebViewApi;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PluginPreInstaller
{
  private static final String[] a = { "qlink_plugin.apk" };
  private static final String[] b = { "qqreaderplugin.apk", "comic_plugin.apk", "Photoplus.apk" };
  private static final String[] c = { "qqhotspot_plugin.apk" };
  private static final String[] d = new String[0];
  private static final String[] e = { "qqreaderplugin.apk", "comic_plugin.apk" };
  private static final SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
  private Context g;
  private IPluginManager h;
  private QQAppInterface i;
  private OnPluginInstallListener j = new PluginPreInstaller.1(this);
  
  public PluginPreInstaller(Context paramContext, IPluginManager paramIPluginManager, QQAppInterface paramQQAppInterface)
  {
    this.g = paramContext;
    this.h = paramIPluginManager;
    this.i = paramQQAppInterface;
    c();
  }
  
  private int a(String paramString)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.g);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("total_retried_times_");
    localStringBuilder.append(paramString);
    return localSharedPreferences.getInt(localStringBuilder.toString(), 0);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isDevelopLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("installPlugin plugin = ");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(", totalTimes = ");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(", todayTimes = ");
      ((StringBuilder)localObject1).append(paramInt2);
      QLog.d("PluginPreInstaller", 4, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = PreferenceManager.getDefaultSharedPreferences(this.g).edit();
    Object localObject2 = new Date();
    localObject2 = f.format((Date)localObject2);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("total_retried_times_");
    localStringBuilder.append(paramString);
    ((SharedPreferences.Editor)localObject1).putInt(localStringBuilder.toString(), paramInt1 + 1);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("today_retried_times_");
    localStringBuilder.append(paramString);
    ((SharedPreferences.Editor)localObject1).putInt(localStringBuilder.toString(), paramInt2 + 1);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("last_retry_day_");
    localStringBuilder.append(paramString);
    ((SharedPreferences.Editor)localObject1).putString(localStringBuilder.toString(), (String)localObject2);
    ((SharedPreferences.Editor)localObject1).commit();
    this.h.a(paramString, this.j, true);
    if ("comic_plugin.apk".equals(paramString)) {
      ((IQQComicWebViewApi)QRoute.api(IQQComicWebViewApi.class)).updateOfflinePkgAsync(1, this.i);
    }
  }
  
  private int b(String paramString)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.g);
    Object localObject = new Date();
    localObject = f.format((Date)localObject);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("last_retry_day_");
    localStringBuilder.append(paramString);
    if (((String)localObject).equals(localSharedPreferences.getString(localStringBuilder.toString(), "")))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("today_retried_times_");
      ((StringBuilder)localObject).append(paramString);
      return localSharedPreferences.getInt(((StringBuilder)localObject).toString(), 0);
    }
    return 0;
  }
  
  private void c()
  {
    if (!PreferenceManager.getDefaultSharedPreferences(this.g).getString("plugin_pre_install_qq_version", "").equals(DeviceInfoUtil.e()))
    {
      SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.g).edit();
      Iterator localIterator = d().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("total_retried_times_");
        localStringBuilder.append(str);
        localEditor.remove(localStringBuilder.toString());
      }
      localEditor.commit();
    }
  }
  
  private List<String> d()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = a;
    int n = localObject1.length;
    int m = 0;
    int k = 0;
    while (k < n)
    {
      localArrayList.add(localObject1[k]);
      k += 1;
    }
    if (NetworkUtil.isWifiEnabled(this.g))
    {
      localObject1 = b;
      n = localObject1.length;
      k = 0;
      while (k < n)
      {
        Object localObject2 = localObject1[k];
        if ((!localObject2.equals("Photoplus.apk")) || (!VersionUtils.d())) {
          localArrayList.add(localObject2);
        }
        k += 1;
      }
    }
    if ((DeviceInfoUtil.U()) || (FileUtils.getAvailableInnernalMemorySize() <= 1.048576E+008F))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("plugins ");
        ((StringBuilder)localObject1).append(Arrays.toString(e));
        ((StringBuilder)localObject1).append("filtered in low end phone");
        QLog.d("PluginPreInstaller", 2, ((StringBuilder)localObject1).toString());
      }
      localObject1 = e;
      n = localObject1.length;
      k = m;
      while (k < n)
      {
        localArrayList.remove(localObject1[k]);
        k += 1;
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    try
    {
      Iterator localIterator = d().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        try
        {
          if (this.h.isPlugininstalled(str)) {
            continue;
          }
          int k = a(str);
          if (k >= 10) {
            continue;
          }
          int m = b(str);
          if (m >= 2) {
            continue;
          }
          a(str, k, m);
        }
        catch (Exception localException) {}
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("preinstall plugin : ");
          localStringBuilder.append(str);
          localStringBuilder.append(" failed.");
          QLog.e("PluginPreInstaller", 2, localStringBuilder.toString(), localException);
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void b()
  {
    try
    {
      if (AppNetConnInfo.isWifiConn())
      {
        if (QLog.isColorLevel()) {
          QLog.e("PluginPreInstaller", 2, "preinstall start,wifi_reinstall_only.");
        }
        String[] arrayOfString = d;
        int m = arrayOfString.length;
        int k = 0;
        while (k < m)
        {
          String str = arrayOfString[k];
          try
          {
            if (!this.h.isPlugininstalled(str))
            {
              a(str, a(str), b(str));
            }
            else if ("QQWifiPlugin.apk".equals(str))
            {
              Object localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("com.tencent.mobileqq.cooperation.plugin.");
              ((StringBuilder)localObject2).append(str);
              localObject2 = new Intent(((StringBuilder)localObject2).toString());
              ((Intent)localObject2).putExtra("plugin", str);
              this.g.sendBroadcast((Intent)localObject2);
            }
          }
          catch (Exception localException)
          {
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("preinstall plugin : ");
              localStringBuilder.append(str);
              localStringBuilder.append(" failed.");
              QLog.e("PluginPreInstaller", 2, localStringBuilder.toString(), localException);
            }
          }
          k += 1;
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.plugin.PluginPreInstaller
 * JD-Core Version:    0.7.0.1
 */
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
  private static final SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyyMMdd");
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "qlink_plugin.apk" };
  private static final String[] b = { "qqreaderplugin.apk", "comic_plugin.apk", "Photoplus.apk" };
  private static final String[] c = { "qqhotspot_plugin.apk" };
  private static final String[] d = new String[0];
  private static final String[] e = { "qqreaderplugin.apk", "comic_plugin.apk" };
  private Context jdField_a_of_type_AndroidContentContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private OnPluginInstallListener jdField_a_of_type_ComTencentMobileqqPluginsdkOnPluginInstallListener = new PluginPreInstaller.1(this);
  private IPluginManager jdField_a_of_type_CooperationPluginIPluginManager;
  
  public PluginPreInstaller(Context paramContext, IPluginManager paramIPluginManager, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_CooperationPluginIPluginManager = paramIPluginManager;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    c();
  }
  
  private int a(String paramString)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_AndroidContentContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("total_retried_times_");
    localStringBuilder.append(paramString);
    return localSharedPreferences.getInt(localStringBuilder.toString(), 0);
  }
  
  private List<String> a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = jdField_a_of_type_ArrayOfJavaLangString;
    int k = localObject1.length;
    int j = 0;
    int i = 0;
    while (i < k)
    {
      localArrayList.add(localObject1[i]);
      i += 1;
    }
    if (NetworkUtil.isWifiEnabled(this.jdField_a_of_type_AndroidContentContext))
    {
      localObject1 = b;
      k = localObject1.length;
      i = 0;
      while (i < k)
      {
        Object localObject2 = localObject1[i];
        if ((!localObject2.equals("Photoplus.apk")) || (!VersionUtils.d())) {
          localArrayList.add(localObject2);
        }
        i += 1;
      }
    }
    if ((DeviceInfoUtil.h()) || (FileUtils.getAvailableInnernalMemorySize() <= 1.048576E+008F))
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
      k = localObject1.length;
      i = j;
      while (i < k)
      {
        localArrayList.remove(localObject1[i]);
        i += 1;
      }
    }
    return localArrayList;
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
    Object localObject1 = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_AndroidContentContext).edit();
    Object localObject2 = new Date();
    localObject2 = jdField_a_of_type_JavaTextSimpleDateFormat.format((Date)localObject2);
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
    this.jdField_a_of_type_CooperationPluginIPluginManager.a(paramString, this.jdField_a_of_type_ComTencentMobileqqPluginsdkOnPluginInstallListener, true);
    if ("comic_plugin.apk".equals(paramString)) {
      ((IQQComicWebViewApi)QRoute.api(IQQComicWebViewApi.class)).updateOfflinePkgAsync(1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  private int b(String paramString)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_AndroidContentContext);
    Object localObject = new Date();
    localObject = jdField_a_of_type_JavaTextSimpleDateFormat.format((Date)localObject);
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
    if (!PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_AndroidContentContext).getString("plugin_pre_install_qq_version", "").equals(DeviceInfoUtil.c()))
    {
      SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_AndroidContentContext).edit();
      Iterator localIterator = a().iterator();
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
  
  public void a()
  {
    try
    {
      Iterator localIterator = a().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        try
        {
          if (this.jdField_a_of_type_CooperationPluginIPluginManager.isPlugininstalled(str)) {
            continue;
          }
          int i = a(str);
          if (i >= 10) {
            continue;
          }
          int j = b(str);
          if (j >= 2) {
            continue;
          }
          a(str, i, j);
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
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str = arrayOfString[i];
          try
          {
            if (!this.jdField_a_of_type_CooperationPluginIPluginManager.isPlugininstalled(str))
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
              this.jdField_a_of_type_AndroidContentContext.sendBroadcast((Intent)localObject2);
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
          i += 1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.plugin.PluginPreInstaller
 * JD-Core Version:    0.7.0.1
 */
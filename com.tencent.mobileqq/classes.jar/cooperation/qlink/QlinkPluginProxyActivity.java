package cooperation.qlink;

import ajyc;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import bcpq;
import bgkq;
import bgkz;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.PluginInfo;
import java.util.Iterator;
import java.util.List;

public class QlinkPluginProxyActivity
  extends PluginProxyActivity
{
  public static ClassLoader a(Context paramContext)
  {
    return PluginStatic.getOrCreateClassLoader(paramContext, "qlink_plugin.apk");
  }
  
  public static String a()
  {
    return "qlink_plugin.apk";
  }
  
  static String a(Intent paramIntent)
  {
    return paramIntent.getStringExtra("qlink_plugin_activity_name");
  }
  
  public static void a(Activity paramActivity, String paramString, Intent paramIntent, int paramInt, bcpq parambcpq)
  {
    paramIntent.putExtra("userQqResources", 2);
    bgkz localbgkz = new bgkz(0);
    localbgkz.jdField_b_of_type_JavaLangString = "qlink_plugin.apk";
    localbgkz.d = PluginInfo.c;
    localbgkz.jdField_a_of_type_JavaLangString = paramString;
    localbgkz.e = a(paramIntent);
    localbgkz.jdField_a_of_type_JavaLangClass = QlinkPluginProxyActivity.class;
    localbgkz.jdField_a_of_type_AndroidContentIntent = paramIntent;
    localbgkz.jdField_b_of_type_Int = paramInt;
    localbgkz.jdField_a_of_type_AndroidAppDialog = parambcpq;
    localbgkz.c = 10000;
    localbgkz.f = null;
    bgkq.a(paramActivity, localbgkz);
  }
  
  public static void a(Intent paramIntent, String paramString)
  {
    paramIntent.putExtra("qlink_plugin_activity_name", paramString);
  }
  
  public static boolean a(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.iterator();
    while (paramContext.hasNext()) {
      if ("com.tencent.mobileqq:qlink".compareTo(((ActivityManager.RunningAppProcessInfo)paramContext.next()).processName) == 0) {
        return true;
      }
    }
    return false;
  }
  
  public String getPluginID()
  {
    return "qlink_plugin.apk";
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (!TextUtils.isEmpty(this.mCreateErrorInfo)) {
      if (paramBundle == null) {
        break label68;
      }
    }
    for (;;)
    {
      paramBundle = paramBundle.getString("pluginsdk_launchActivity");
      StringBuffer localStringBuffer = new StringBuffer(ajyc.a(2131709884));
      localStringBuffer.append(paramBundle).append(" ").append(this.mCreateErrorInfo);
      QLog.e("QLinkLog", 1, localStringBuffer.toString());
      return;
      label68:
      paramBundle = getIntent().getExtras();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.qlink.QlinkPluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */
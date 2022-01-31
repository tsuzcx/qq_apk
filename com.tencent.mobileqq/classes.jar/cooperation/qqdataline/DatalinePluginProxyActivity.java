package cooperation.qqdataline;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import bbms;
import bfcz;
import bfdi;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.PluginInfo;
import java.util.Iterator;
import java.util.List;

public class DatalinePluginProxyActivity
  extends PluginProxyActivity
{
  private static Class<? extends PluginProxyActivity> a(Intent paramIntent, String paramString)
  {
    if ((paramString != null) && (paramString.equals("com.qqdataline.activity.LiteWifiphotoActivity"))) {
      paramIntent.setFlags(paramIntent.getFlags() | 0x20000000);
    }
    if ((paramIntent.getFlags() & 0x20000000) != 0) {
      return DatalinePluginProxyActivity.SingleTop.class;
    }
    return DatalinePluginProxyActivity.class;
  }
  
  public static void a(Activity paramActivity, String paramString1, Intent paramIntent, String paramString2, int paramInt, bbms parambbms)
  {
    paramIntent.putExtra("userQqResources", 2);
    bfdi localbfdi = new bfdi(0);
    localbfdi.jdField_b_of_type_JavaLangString = "qqdataline.apk";
    localbfdi.d = PluginInfo.d;
    localbfdi.jdField_a_of_type_JavaLangString = paramString1;
    localbfdi.e = paramString2;
    localbfdi.jdField_a_of_type_JavaLangClass = a(paramIntent, paramString2);
    localbfdi.jdField_a_of_type_AndroidContentIntent = paramIntent;
    localbfdi.jdField_b_of_type_Int = paramInt;
    localbfdi.jdField_a_of_type_AndroidAppDialog = parambbms;
    localbfdi.c = 10000;
    localbfdi.f = null;
    bfcz.a(paramActivity, localbfdi);
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
      if ("com.tencent.mobileqq:dataline".compareTo(((ActivityManager.RunningAppProcessInfo)paramContext.next()).processName) == 0) {
        return true;
      }
    }
    return false;
  }
  
  public String getPluginID()
  {
    return "qqdataline.apk";
  }
  
  public Class<? extends PluginProxyActivity> getProxyActivity(String paramString)
  {
    if (paramString.equals("com.qqdataline.activity.LiteWifiphotoActivity")) {
      return DatalinePluginProxyActivity.SingleTop.class;
    }
    return super.getProxyActivity(paramString);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (!TextUtils.isEmpty(this.mCreateErrorInfo)) {
      if (paramBundle == null) {
        break label65;
      }
    }
    for (;;)
    {
      paramBundle = paramBundle.getString("pluginsdk_launchActivity");
      StringBuffer localStringBuffer = new StringBuffer("[插件Activity启动] ");
      localStringBuffer.append(paramBundle).append(" ").append(this.mCreateErrorInfo);
      QLog.e("qqdataline", 1, localStringBuffer.toString());
      return;
      label65:
      paramBundle = getIntent().getExtras();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qqdataline.DatalinePluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */
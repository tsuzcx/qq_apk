package cooperation.qzone;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import java.lang.reflect.Field;
import mqq.app.AndroidOreoUtils;

public class TranslucentActivity
  extends Activity
{
  public static int getStatusHeight(Activity paramActivity)
  {
    Object localObject1 = new Rect();
    paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject1);
    int j = ((Rect)localObject1).top;
    int i = j;
    if (j == 0) {}
    try
    {
      localObject1 = Class.forName("com.android.internal.R$dimen");
      Object localObject2 = ((Class)localObject1).newInstance();
      i = Integer.parseInt(((Class)localObject1).getField("status_bar_height").get(localObject2).toString());
      i = paramActivity.getResources().getDimensionPixelSize(i);
      return i;
    }
    catch (Exception paramActivity) {}
    return j;
  }
  
  private void startPlugin(Intent paramIntent)
  {
    QQProgressDialog localQQProgressDialog;
    if (!((IPluginManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.MGR_PLUGIN)).isPlugininstalled("qzone_plugin.apk"))
    {
      localQQProgressDialog = new QQProgressDialog(this, getResources().getDimensionPixelSize(2131299166));
      localQQProgressDialog.a(HardCodeUtil.a(2131714928));
      localQQProgressDialog.setOnDismissListener(new TranslucentActivity.1(this));
    }
    for (;;)
    {
      String str = QzonePluginProxyActivity.getActivityNameToIntent(paramIntent);
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
      IPluginManager.a(this, localPluginParams);
      if (localQQProgressDialog == null) {
        finish();
      }
      return;
      localQQProgressDialog = null;
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public SharedPreferences getSharedPreferences(String paramString, int paramInt)
  {
    return SharedPreferencesProxyManager.getInstance().getProxy(paramString, paramInt);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AndroidOreoUtils localAndroidOreoUtils = new AndroidOreoUtils(this);
    if ((Build.VERSION.SDK_INT == 26) && (getApplicationInfo().targetSdkVersion >= 27) && (localAndroidOreoUtils.isTranslucentOrFloating()))
    {
      boolean bool = localAndroidOreoUtils.fixOrientation();
      QLog.i("TranslucentActivity", 1, "onCreate fixOrientation when Oreo, result = " + bool);
    }
    super.onCreate(paramBundle);
    paramBundle = super.getIntent();
    if (!TextUtils.isEmpty(QzonePluginProxyActivity.getActivityNameToIntent(paramBundle)))
    {
      startPlugin(paramBundle);
      return;
    }
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.TranslucentActivity
 * JD-Core Version:    0.7.0.1
 */
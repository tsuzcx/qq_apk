package cooperation.qzone;

import Override;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import anzj;
import bjbs;
import bmgk;
import bmgt;
import bmwh;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AndroidOreoUtils;

public class TranslucentActivity
  extends Activity
{
  private void a(Intent paramIntent)
  {
    bjbs localbjbs;
    if (!((bmgk)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(27)).isPlugininstalled("qzone_plugin.apk"))
    {
      localbjbs = new bjbs(this, getResources().getDimensionPixelSize(2131299011));
      localbjbs.a(anzj.a(2131713854));
      localbjbs.setOnDismissListener(new bmwh(this));
    }
    for (;;)
    {
      String str = QzonePluginProxyActivity.a(paramIntent);
      paramIntent.putExtra("userQqResources", 2);
      bmgt localbmgt = new bmgt(0);
      localbmgt.jdField_b_of_type_JavaLangString = "qzone_plugin.apk";
      localbmgt.d = "QZone";
      localbmgt.jdField_a_of_type_JavaLangString = "";
      localbmgt.e = str;
      localbmgt.jdField_a_of_type_JavaLangClass = QzonePluginProxyActivity.class;
      localbmgt.jdField_a_of_type_AndroidContentIntent = paramIntent;
      localbmgt.jdField_b_of_type_Int = -1;
      localbmgt.jdField_a_of_type_AndroidAppDialog = localbjbs;
      localbmgt.c = 10000;
      localbmgt.f = null;
      bmgk.a(this, localbmgt);
      if (localbjbs == null) {
        finish();
      }
      return;
      localbjbs = null;
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
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
    if (!TextUtils.isEmpty(QzonePluginProxyActivity.a(paramBundle)))
    {
      a(paramBundle);
      return;
    }
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.TranslucentActivity
 * JD-Core Version:    0.7.0.1
 */
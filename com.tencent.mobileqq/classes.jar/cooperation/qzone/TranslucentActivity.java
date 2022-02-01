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
import anni;
import biau;
import blfh;
import blfq;
import blvf;
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
    biau localbiau;
    if (!((blfh)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(27)).isPlugininstalled("qzone_plugin.apk"))
    {
      localbiau = new biau(this, getResources().getDimensionPixelSize(2131298998));
      localbiau.a(anni.a(2131713745));
      localbiau.setOnDismissListener(new blvf(this));
    }
    for (;;)
    {
      String str = QzonePluginProxyActivity.a(paramIntent);
      paramIntent.putExtra("userQqResources", 2);
      blfq localblfq = new blfq(0);
      localblfq.jdField_b_of_type_JavaLangString = "qzone_plugin.apk";
      localblfq.d = "QZone";
      localblfq.jdField_a_of_type_JavaLangString = "";
      localblfq.e = str;
      localblfq.jdField_a_of_type_JavaLangClass = QzonePluginProxyActivity.class;
      localblfq.jdField_a_of_type_AndroidContentIntent = paramIntent;
      localblfq.jdField_b_of_type_Int = -1;
      localblfq.jdField_a_of_type_AndroidAppDialog = localbiau;
      localblfq.c = 10000;
      localblfq.f = null;
      blfh.a(this, localblfq);
      if (localbiau == null) {
        finish();
      }
      return;
      localbiau = null;
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
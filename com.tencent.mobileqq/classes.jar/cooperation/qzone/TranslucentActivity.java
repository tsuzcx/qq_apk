package cooperation.qzone;

import alpo;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import bepp;
import bimg;
import bimp;
import bjcs;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AndroidOreoUtils;

public class TranslucentActivity
  extends Activity
{
  private void a(Intent paramIntent)
  {
    bepp localbepp;
    if (!((bimg)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(27)).isPlugininstalled("qzone_plugin.apk"))
    {
      localbepp = new bepp(this, getResources().getDimensionPixelSize(2131298914));
      localbepp.a(alpo.a(2131715452));
      localbepp.setOnDismissListener(new bjcs(this));
    }
    for (;;)
    {
      String str = QzonePluginProxyActivity.a(paramIntent);
      paramIntent.putExtra("userQqResources", 2);
      bimp localbimp = new bimp(0);
      localbimp.jdField_b_of_type_JavaLangString = "qzone_plugin.apk";
      localbimp.d = "QZone";
      localbimp.jdField_a_of_type_JavaLangString = "";
      localbimp.e = str;
      localbimp.jdField_a_of_type_JavaLangClass = QzonePluginProxyActivity.class;
      localbimp.jdField_a_of_type_AndroidContentIntent = paramIntent;
      localbimp.jdField_b_of_type_Int = -1;
      localbimp.jdField_a_of_type_AndroidAppDialog = localbepp;
      localbimp.c = 10000;
      localbimp.f = null;
      bimg.a(this, localbimp);
      if (localbepp == null) {
        finish();
      }
      return;
      localbepp = null;
    }
  }
  
  public SharedPreferences getSharedPreferences(String paramString, int paramInt)
  {
    return SharedPreferencesProxyManager.getInstance().getProxy(paramString, paramInt);
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
    if (!TextUtils.isEmpty(QzonePluginProxyActivity.a(paramBundle))) {
      a(paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.TranslucentActivity
 * JD-Core Version:    0.7.0.1
 */
package cooperation.qzone;

import alud;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import bety;
import biqn;
import biqw;
import bjgz;
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
    bety localbety;
    if (!((biqn)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(27)).isPlugininstalled("qzone_plugin.apk"))
    {
      localbety = new bety(this, getResources().getDimensionPixelSize(2131298914));
      localbety.a(alud.a(2131715464));
      localbety.setOnDismissListener(new bjgz(this));
    }
    for (;;)
    {
      String str = QzonePluginProxyActivity.a(paramIntent);
      paramIntent.putExtra("userQqResources", 2);
      biqw localbiqw = new biqw(0);
      localbiqw.jdField_b_of_type_JavaLangString = "qzone_plugin.apk";
      localbiqw.d = "QZone";
      localbiqw.jdField_a_of_type_JavaLangString = "";
      localbiqw.e = str;
      localbiqw.jdField_a_of_type_JavaLangClass = QzonePluginProxyActivity.class;
      localbiqw.jdField_a_of_type_AndroidContentIntent = paramIntent;
      localbiqw.jdField_b_of_type_Int = -1;
      localbiqw.jdField_a_of_type_AndroidAppDialog = localbety;
      localbiqw.c = 10000;
      localbiqw.f = null;
      biqn.a(this, localbiqw);
      if (localbety == null) {
        finish();
      }
      return;
      localbety = null;
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
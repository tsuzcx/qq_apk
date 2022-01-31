package cooperation.qzone;

import ajyc;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import bcpq;
import bgkq;
import bgkz;
import bhau;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;

public class TranslucentActivity
  extends Activity
{
  private void a(Intent paramIntent)
  {
    bcpq localbcpq;
    if (!((bgkq)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(27)).isPlugininstalled("qzone_plugin.apk"))
    {
      localbcpq = new bcpq(this, getResources().getDimensionPixelSize(2131298865));
      localbcpq.a(ajyc.a(2131715069));
      localbcpq.setOnDismissListener(new bhau(this));
    }
    for (;;)
    {
      String str = QzonePluginProxyActivity.a(paramIntent);
      paramIntent.putExtra("userQqResources", 2);
      bgkz localbgkz = new bgkz(0);
      localbgkz.jdField_b_of_type_JavaLangString = "qzone_plugin.apk";
      localbgkz.d = "QZone";
      localbgkz.jdField_a_of_type_JavaLangString = "";
      localbgkz.e = str;
      localbgkz.jdField_a_of_type_JavaLangClass = QzonePluginProxyActivity.class;
      localbgkz.jdField_a_of_type_AndroidContentIntent = paramIntent;
      localbgkz.jdField_b_of_type_Int = -1;
      localbgkz.jdField_a_of_type_AndroidAppDialog = localbcpq;
      localbgkz.c = 10000;
      localbgkz.f = null;
      bgkq.a(this, localbgkz);
      if (localbcpq == null) {
        finish();
      }
      return;
      localbcpq = null;
    }
  }
  
  public SharedPreferences getSharedPreferences(String paramString, int paramInt)
  {
    return SharedPreferencesProxyManager.getInstance().getProxy(paramString, paramInt);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = super.getIntent();
    if (!TextUtils.isEmpty(QzonePluginProxyActivity.a(paramBundle))) {
      a(paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.TranslucentActivity
 * JD-Core Version:    0.7.0.1
 */
package cooperation.qzone;

import ajya;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import bcqf;
import bglh;
import bglq;
import bhbl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;

public class TranslucentActivity
  extends Activity
{
  private void a(Intent paramIntent)
  {
    bcqf localbcqf;
    if (!((bglh)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(27)).isPlugininstalled("qzone_plugin.apk"))
    {
      localbcqf = new bcqf(this, getResources().getDimensionPixelSize(2131298865));
      localbcqf.a(ajya.a(2131715080));
      localbcqf.setOnDismissListener(new bhbl(this));
    }
    for (;;)
    {
      String str = QzonePluginProxyActivity.a(paramIntent);
      paramIntent.putExtra("userQqResources", 2);
      bglq localbglq = new bglq(0);
      localbglq.jdField_b_of_type_JavaLangString = "qzone_plugin.apk";
      localbglq.d = "QZone";
      localbglq.jdField_a_of_type_JavaLangString = "";
      localbglq.e = str;
      localbglq.jdField_a_of_type_JavaLangClass = QzonePluginProxyActivity.class;
      localbglq.jdField_a_of_type_AndroidContentIntent = paramIntent;
      localbglq.jdField_b_of_type_Int = -1;
      localbglq.jdField_a_of_type_AndroidAppDialog = localbcqf;
      localbglq.c = 10000;
      localbglq.f = null;
      bglh.a(this, localbglq);
      if (localbcqf == null) {
        finish();
      }
      return;
      localbcqf = null;
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
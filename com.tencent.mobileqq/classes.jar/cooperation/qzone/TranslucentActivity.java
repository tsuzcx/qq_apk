package cooperation.qzone;

import ajjy;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import bbms;
import bfcz;
import bfdi;
import bfsn;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;

public class TranslucentActivity
  extends Activity
{
  private void a(Intent paramIntent)
  {
    bbms localbbms;
    if (!((bfcz)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(27)).isPlugininstalled("qzone_plugin.apk"))
    {
      localbbms = new bbms(this, getResources().getDimensionPixelSize(2131167766));
      localbbms.a(ajjy.a(2131649280));
      localbbms.setOnDismissListener(new bfsn(this));
    }
    for (;;)
    {
      String str = QzonePluginProxyActivity.a(paramIntent);
      paramIntent.putExtra("userQqResources", 2);
      bfdi localbfdi = new bfdi(0);
      localbfdi.jdField_b_of_type_JavaLangString = "qzone_plugin.apk";
      localbfdi.d = "QZone";
      localbfdi.jdField_a_of_type_JavaLangString = "";
      localbfdi.e = str;
      localbfdi.jdField_a_of_type_JavaLangClass = QzonePluginProxyActivity.class;
      localbfdi.jdField_a_of_type_AndroidContentIntent = paramIntent;
      localbfdi.jdField_b_of_type_Int = -1;
      localbfdi.jdField_a_of_type_AndroidAppDialog = localbbms;
      localbfdi.c = 10000;
      localbfdi.f = null;
      bfcz.a(this, localbfdi);
      if (localbbms == null) {
        finish();
      }
      return;
      localbbms = null;
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
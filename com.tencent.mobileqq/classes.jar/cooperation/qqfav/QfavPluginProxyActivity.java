package cooperation.qqfav;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.qqfav.widget.QfavLoadingDialog;

public class QfavPluginProxyActivity
  extends PluginProxyActivity
{
  private static Class a(Intent paramIntent)
  {
    String str = a(paramIntent);
    if ("com.qqfav.FavoriteIpcDelegate".equals(str)) {
      return QfavPluginProxyActivity.ForResult.class;
    }
    if (str != null)
    {
      if (str.equals("com.qqfav.file.activity.QfavFileBrowserActivity")) {
        return QfavPluginProxyActivity.ScreenOrientationProxy.class;
      }
      if ((str.equals("com.qqfav.activity.AddPhotosFavActivity")) || (str.equals("com.qqfav.activity.AddLocationFavActivity")) || (str.equals("com.qqfav.FavoriteIpcDelegate"))) {
        paramIntent.setFlags(paramIntent.getFlags() | 0x20000000);
      }
    }
    if ((paramIntent.getFlags() & 0x20000000) != 0) {
      return QfavPluginProxyActivity.SingleTop.class;
    }
    if ((str != null) && ((str.equals("com.qqfav.activity.AddPhotosFavActivity")) || (str.equals("com.qqfav.activity.AddLocationFavActivity")) || (str.equals("com.qqfav.FavoriteIpcDelegate")) || (str.equals("com.qqfav.edit.EditPhotosActivity"))))
    {
      paramIntent.setFlags(paramIntent.getFlags() | 0x20000000);
      return QfavPluginProxyActivity.SingleTop.class;
    }
    return QfavPluginProxyActivity.class;
  }
  
  private static String a(Intent paramIntent)
  {
    switch (paramIntent.getIntExtra("nOperation", -1))
    {
    case 4: 
    case 5: 
    default: 
      paramIntent = paramIntent.getComponent();
      if (paramIntent == null) {
        return null;
      }
      break;
    case 0: 
    case 1: 
    case 3: 
    case 6: 
    case 7: 
    case 8: 
      return "com.qqfav.FavoriteIpcDelegate";
    case 2: 
      return "com.qqfav.activity.FavoritesListActivity";
    }
    return paramIntent.getClassName();
  }
  
  public static boolean a(Activity paramActivity, String paramString, Intent paramIntent, int paramInt)
  {
    QfavPluginProxyService.a();
    if ((paramIntent.getBooleanExtra("bShowProgress", false)) && (!QfavHelper.a(paramActivity))) {}
    for (QfavLoadingDialog localQfavLoadingDialog = new QfavLoadingDialog(paramActivity);; localQfavLoadingDialog = null)
    {
      String str = a(paramIntent);
      paramIntent.putExtra("useSkinEngine", false);
      paramIntent.putExtra("userQqResources", 1);
      IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
      localPluginParams.jdField_b_of_type_JavaLangString = "qqfav.apk";
      localPluginParams.d = "qqfav.apk";
      localPluginParams.jdField_a_of_type_JavaLangString = paramString;
      localPluginParams.e = str;
      localPluginParams.jdField_a_of_type_JavaLangClass = a(paramIntent);
      localPluginParams.jdField_a_of_type_AndroidContentIntent = paramIntent;
      localPluginParams.jdField_b_of_type_Int = paramInt;
      localPluginParams.jdField_a_of_type_AndroidAppDialog = localQfavLoadingDialog;
      localPluginParams.c = 30000;
      localPluginParams.f = null;
      localPluginParams.jdField_a_of_type_Boolean = false;
      IPluginManager.a(paramActivity, localPluginParams);
      if (QLog.isColorLevel()) {
        QLog.d("qqfav", 2, "QfavPluginProxyActivity: openPluginActivityForResult: " + str);
      }
      return true;
    }
  }
  
  public String getPluginID()
  {
    return "qqfav.apk";
  }
  
  protected Class getProxyActivity(String paramString)
  {
    if (paramString.equals("com.qqfav.activity.ImageDetailActivity")) {
      return QfavPluginProxyActivity.ImageViewer.class;
    }
    if (paramString.matches("com\\.qqfav\\.activity\\..*DetailActivity"))
    {
      if ((this instanceof QfavPluginProxyActivity.DetailProxy)) {
        return QfavPluginProxyActivity.SingleTop.class;
      }
      return QfavPluginProxyActivity.DetailProxy.class;
    }
    if ((paramString.equals("com.qqfav.activity.AddPhotosFavActivity")) || (paramString.equals("com.qqfav.activity.AddLocationFavActivity")) || (paramString.equals("com.qqfav.FavoriteIpcDelegate")) || (paramString.equals("com.qqfav.edit.EditPhotosActivity"))) {
      return QfavPluginProxyActivity.SingleTop.class;
    }
    if (paramString.equals("com.qqfav.file.activity.QfavFileBrowserActivity")) {
      return QfavPluginProxyActivity.ScreenOrientationProxy.class;
    }
    if (paramString.equals("com.qqfav.edit.QfavEditActivity")) {
      return QfavPluginProxyActivity.DetailProxy.class;
    }
    return super.getProxyActivity(paramString);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    getIntent().removeExtra("fling_action_key");
    super.onCreate(paramBundle);
    paramBundle = getIntent().getExtras();
    if ((paramBundle != null) && (paramBundle.getInt("nOperation") == 6)) {
      super.overridePendingTransition(2131034132, 2131034133);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qqfav.QfavPluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */
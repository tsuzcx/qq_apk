package cooperation.qqfav;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import bimg;
import bimp;
import biqv;
import bisz;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.qphone.base.util.QLog;

public class QfavPluginProxyActivity
  extends PluginProxyActivity
{
  private static Class<? extends PluginProxyActivity> a(Intent paramIntent)
  {
    String str = a(paramIntent);
    if ("com.qqfav.FavoriteIpcDelegate".equals(str)) {
      return QfavPluginProxyActivity.ForResult.class;
    }
    if ((str != null) && ((str.equals("com.qqfav.activity.AddPhotosFavActivity")) || (str.equals("com.qqfav.activity.AddLocationFavActivity")) || (str.equals("com.qqfav.FavoriteIpcDelegate")) || (str.equals("com.qqfav.file.activity.QfavFileBrowserActivity")))) {
      paramIntent.setFlags(paramIntent.getFlags() | 0x20000000);
    }
    if ((paramIntent.getFlags() & 0x20000000) != 0) {
      return QfavPluginProxyActivity.SingleTop.class;
    }
    if ((str != null) && ((str.equals("com.qqfav.activity.AddPhotosFavActivity")) || (str.equals("com.qqfav.activity.AddLocationFavActivity")) || (str.equals("com.qqfav.FavoriteIpcDelegate")) || (str.equals("com.qqfav.edit.EditPhotosActivity")) || (str.equals("com.qqfav.file.activity.QfavFileBrowserActivity"))))
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
  
  public static boolean a(Context paramContext, String paramString, Intent paramIntent, int paramInt)
  {
    return a(paramContext, paramString, paramIntent, paramInt, true);
  }
  
  public static boolean a(Context paramContext, String paramString, Intent paramIntent, int paramInt, boolean paramBoolean)
  {
    QfavPluginProxyService.a();
    if ((paramIntent.getBooleanExtra("bShowProgress", false)) && (!biqv.a(paramContext))) {}
    for (bisz localbisz = new bisz(paramContext);; localbisz = null)
    {
      String str = a(paramIntent);
      paramIntent.putExtra("useSkinEngine", true);
      paramIntent.putExtra("userQqResources", 1);
      if ((paramBoolean) || (!(paramContext instanceof Activity))) {
        paramIntent.addFlags(268435456);
      }
      bimp localbimp = new bimp(0);
      localbimp.jdField_b_of_type_JavaLangString = "qqfav.apk";
      localbimp.d = "qqfav.apk";
      localbimp.jdField_a_of_type_JavaLangString = paramString;
      localbimp.e = str;
      localbimp.jdField_a_of_type_JavaLangClass = a(paramIntent);
      localbimp.jdField_a_of_type_AndroidContentIntent = paramIntent;
      localbimp.jdField_b_of_type_Int = paramInt;
      localbimp.jdField_a_of_type_AndroidAppDialog = localbisz;
      localbimp.c = 30000;
      localbimp.f = null;
      localbimp.jdField_b_of_type_Boolean = false;
      bimg.a(paramContext, localbimp);
      QLog.i("qqfav", 2, "QfavPluginProxyActivity: openPluginActivityForResult: " + str);
      return true;
    }
  }
  
  public String getPluginID()
  {
    return "qqfav.apk";
  }
  
  public Class<? extends PluginProxyActivity> getProxyActivity(String paramString)
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
    if ((paramString.equals("com.qqfav.activity.AddPhotosFavActivity")) || (paramString.equals("com.qqfav.activity.AddLocationFavActivity")) || (paramString.equals("com.qqfav.FavoriteIpcDelegate")) || (paramString.equals("com.qqfav.edit.EditPhotosActivity")) || (paramString.equals("com.qqfav.file.activity.QfavFileBrowserActivity"))) {
      return QfavPluginProxyActivity.SingleTop.class;
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
      super.overridePendingTransition(2130771992, 2130771993);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqfav.QfavPluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */
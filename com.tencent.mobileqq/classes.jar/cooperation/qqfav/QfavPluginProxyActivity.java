package cooperation.qqfav;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.qqfav.widget.QfavLoadingDialog;

public class QfavPluginProxyActivity
  extends PluginProxyActivity
{
  private static String a(Intent paramIntent)
  {
    switch (paramIntent.getIntExtra("nOperation", -1))
    {
    case 4: 
    case 5: 
    case 10: 
    default: 
      paramIntent = paramIntent.getComponent();
      if (paramIntent == null) {
        return null;
      }
      break;
    case 9: 
      return "com.qqfav.group.activity.QfavGroupActivity";
    case 2: 
      return "com.qqfav.activity.FavoritesListActivity";
    case 0: 
    case 1: 
    case 3: 
    case 6: 
    case 7: 
    case 8: 
    case 11: 
      return "com.qqfav.FavoriteIpcDelegate";
    }
    return paramIntent.getClassName();
  }
  
  public static boolean a(Context paramContext, String paramString, Intent paramIntent, int paramInt)
  {
    return a(paramContext, paramString, paramIntent, paramInt, false);
  }
  
  public static boolean a(Context paramContext, String paramString, Intent paramIntent, int paramInt, boolean paramBoolean)
  {
    QfavPluginProxyService.c();
    QfavLoadingDialog localQfavLoadingDialog;
    if ((paramIntent.getBooleanExtra("bShowProgress", false)) && (!QfavHelper.b(paramContext))) {
      localQfavLoadingDialog = new QfavLoadingDialog(paramContext);
    } else {
      localQfavLoadingDialog = null;
    }
    String str = a(paramIntent);
    paramIntent.putExtra("useSkinEngine", true);
    paramIntent.putExtra("userQqResources", 1);
    if ((paramBoolean) || (!(paramContext instanceof Activity))) {
      paramIntent.addFlags(268435456);
    }
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
    localPluginParams.d = "qqfav.apk";
    localPluginParams.g = "qqfav.apk";
    localPluginParams.c = paramString;
    localPluginParams.h = str;
    localPluginParams.i = b(paramIntent);
    localPluginParams.j = paramIntent;
    localPluginParams.k = paramInt;
    localPluginParams.l = localQfavLoadingDialog;
    localPluginParams.r = 30000;
    localPluginParams.q = null;
    localPluginParams.p = false;
    IPluginManager.a(paramContext, localPluginParams);
    paramContext = new StringBuilder();
    paramContext.append("QfavPluginProxyActivity: openPluginActivityForResult: ");
    paramContext.append(str);
    QLog.i("qqfav", 2, paramContext.toString());
    return true;
  }
  
  private static Class<? extends PluginProxyActivity> b(Intent paramIntent)
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
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public String getPluginID()
  {
    return "qqfav.apk";
  }
  
  protected Class<? extends PluginProxyActivity> getProxyActivity(String paramString)
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
    if ((!paramString.equals("com.qqfav.activity.AddPhotosFavActivity")) && (!paramString.equals("com.qqfav.activity.AddLocationFavActivity")) && (!paramString.equals("com.qqfav.edit.QfavTitleEditActivity")) && (!paramString.equals("com.qqfav.FavoriteIpcDelegate")) && (!paramString.equals("com.qqfav.edit.EditPhotosActivity")) && (!paramString.equals("com.qqfav.group.activity.QfavGroupActivity")) && (!paramString.equals("com.qqfav.file.activity.QfavFileBrowserActivity")))
    {
      if (paramString.equals("com.qqfav.edit.QfavEditActivity")) {
        return QfavPluginProxyActivity.DetailProxy.class;
      }
      return super.getProxyActivity(paramString);
    }
    return QfavPluginProxyActivity.SingleTop.class;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    getIntent().removeExtra("fling_action_key");
    super.onCreate(paramBundle);
    paramBundle = getIntent().getExtras();
    if ((paramBundle != null) && (paramBundle.getInt("nOperation") == 6)) {
      super.overridePendingTransition(2130772009, 2130772010);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqfav.QfavPluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */
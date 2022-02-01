package cooperation.qzone.video;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.pluginsdk.PluginProxyFragmentActivity;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;

public class QzoneVerticalVideoPluginProxyActivity
  extends PluginProxyFragmentActivity
{
  private static final String LAUNCH_NAME = "com.qzone.commoncode.module.verticalvideo.VerticalVideoLayerActivity";
  private static final String TAG = "QzoneVerticalVideoPluginProxyActivity";
  private static final String[] TRANSLUCENT_NOTITLE_ACTIVITY_LIST = new String[0];
  
  private static boolean isStringInArray(String[] paramArrayOfString, String paramString)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (paramString.equals(paramArrayOfString[i])) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public static void launchPluginActivityForResult(Activity paramActivity, String paramString, Intent paramIntent, int paramInt)
  {
    Class localClass = QzoneVerticalVideoPluginProxyActivity.PluginProxyFactory.getPluginProxyActivityClass("com.qzone.commoncode.module.verticalvideo.VerticalVideoLayerActivity");
    paramIntent.putExtra("userQqResources", 2);
    paramIntent.putExtra("useSkinEngine", false);
    paramIntent.putExtra("param_plugin_gesturelock", false);
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
    localPluginParams.c = paramString;
    localPluginParams.h = "com.qzone.commoncode.module.verticalvideo.VerticalVideoLayerActivity";
    localPluginParams.i = localClass;
    localPluginParams.j = paramIntent;
    localPluginParams.k = paramInt;
    localPluginParams.r = 15000;
    localPluginParams.q = null;
    localPluginParams.p = false;
    localPluginParams.d = "qzone_vertical_video_plugin.apk";
    localPluginParams.g = "QZoneVerticalVideo";
    if (QLog.isColorLevel()) {
      QLog.d("PluginDebug", 2, "加载原始插件");
    }
    IPluginManager.a(paramActivity, localPluginParams);
    if (QLog.isColorLevel()) {
      QLog.d("PluginDebug", 2, "QzoneVerticalVideoPluginProxyActivity.launchPluginActivityForResult");
    }
  }
  
  protected void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(paramContext);
  }
  
  public String getPluginID()
  {
    return "qzone_vertical_video_plugin.apk";
  }
  
  protected int getPluginResType()
  {
    return 2;
  }
  
  protected Class<? extends PluginProxyActivity> getProxyActivity(String paramString)
  {
    return QzoneVerticalVideoPluginProxyActivity.PluginProxyFactory.getPluginProxyActivityClass(paramString);
  }
  
  protected int getThemeResId()
  {
    return 0;
  }
  
  protected void handleCrash(Bundle paramBundle, Throwable paramThrowable)
  {
    super.handleCrash(paramBundle, paramThrowable);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplicationImpl.getContext(), false, 5);
    ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplicationImpl.getContext(), 2, false);
  }
  
  protected void onDestroy()
  {
    ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplicationImpl.getContext(), 2, true);
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.video.QzoneVerticalVideoPluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */
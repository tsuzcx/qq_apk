package cooperation.qzone.video;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.pluginsdk.IPluginActivity;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.qzone.plugin.QZonePluginUtils;

public class QzoneLiveVideoPluginProxyActivity
  extends PluginProxyActivity
{
  public static final String EC_LAUNCH_NAME = "com.qzone.adapter.livevideo.ECLiveVideoActivity";
  public static final String QZONE_LAUNCH_NAME = "com.qzone.adapter.livevideo.QZoneLiveVideoActivity";
  private static final String[] TRANSLUCENT_NOTITLE_ACTIVITY_LIST = { "com.qzone.adapter.livevideo.RewardGiftActivity", "com.qzonex.module.global.FeedActionPanelActivity", "com.qzone.adapter.livevideo.LiveCommonActivity" };
  Object mPermissionCaller = null;
  
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
  
  public static void launchPluginActivityForResult(Activity paramActivity, String paramString1, Intent paramIntent, int paramInt, String paramString2)
  {
    Class localClass = QzoneLiveVideoPluginProxyActivity.PluginProxyFactory.getPluginProxyActivityClass(paramString2);
    paramIntent.putExtra("userQqResources", -1);
    paramIntent.putExtra("useSkinEngine", false);
    paramIntent.putExtra("param_plugin_gesturelock", false);
    Object localObject = QZonePluginUtils.getLoadQZoneLivePluginId();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      paramActivity = new StringBuilder();
      paramActivity.append("启动失败 错误的pluginid=");
      paramActivity.append((String)localObject);
      QLog.e("PluginDebug", 1, paramActivity.toString());
      return;
    }
    if (!((String)localObject).equals("qzone_live_video_plugin_hack.apk"))
    {
      if ("qzone_live_video_plugin.apk".equals(localObject))
      {
        localObject = new IPluginManager.PluginParams(0);
        ((IPluginManager.PluginParams)localObject).c = paramString1;
        ((IPluginManager.PluginParams)localObject).h = paramString2;
        ((IPluginManager.PluginParams)localObject).i = localClass;
        ((IPluginManager.PluginParams)localObject).j = paramIntent;
        ((IPluginManager.PluginParams)localObject).k = paramInt;
        ((IPluginManager.PluginParams)localObject).r = 15000;
        ((IPluginManager.PluginParams)localObject).q = null;
        ((IPluginManager.PluginParams)localObject).p = false;
        ((IPluginManager.PluginParams)localObject).d = "qzone_live_video_plugin.apk";
        ((IPluginManager.PluginParams)localObject).g = "QZoneLiveVideo";
        if (QLog.isColorLevel()) {
          QLog.d("PluginDebug", 2, "加载原始插件");
        }
        IPluginManager.a(paramActivity, (IPluginManager.PluginParams)localObject);
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("PluginDebug", 2, "QzoneLiveVideoPluginProxyActivity.launchPluingActivityForResult");
      }
      return;
    }
    paramActivity = new StringBuilder();
    paramActivity.append("启动失败 错误的pluginid=");
    paramActivity.append((String)localObject);
    QLog.e("PluginDebug", 1, paramActivity.toString());
  }
  
  protected Class<? extends PluginProxyActivity> getProxyActivity(String paramString)
  {
    return QzoneLiveVideoPluginProxyActivity.PluginProxyFactory.getPluginProxyActivityClass(paramString);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplicationImpl.getContext(), false, 5);
    ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplicationImpl.getContext(), 2, false);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.mPluginActivity != null) {
      return this.mPluginActivity.IOnKeyDown(paramInt, paramKeyEvent);
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt)
  {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
  }
  
  public void requestPermissions(Object paramObject, int paramInt, String... paramVarArgs)
  {
    super.requestPermissions(paramObject, paramInt, paramVarArgs);
    this.mPermissionCaller = paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.video.QzoneLiveVideoPluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */
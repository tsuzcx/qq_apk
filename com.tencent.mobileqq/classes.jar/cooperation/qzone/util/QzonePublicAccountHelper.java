package cooperation.qzone.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.event.FollowUpdateEvent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQZoneApiProxy;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.api.QZoneApiProxy;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import mqq.app.AppRuntime;

public class QzonePublicAccountHelper
{
  private static final String ACTION_FOLLOW = "action.qzone_public_account_follow";
  private static final String PERMISSION = "com.tencent.qzone.permission.notify";
  private static final String TAG = "QzonePublicAccountHelper";
  
  public static void broadcastFollowIfNeed(Activity paramActivity, FollowUpdateEvent paramFollowUpdateEvent)
  {
    if (paramActivity != null)
    {
      if (paramActivity.getIntent() == null) {
        return;
      }
      ExtraTypeInfo localExtraTypeInfo = (ExtraTypeInfo)paramActivity.getIntent().getSerializableExtra("key_subscribe_intent_extra_type_info");
      if ((localExtraTypeInfo != null) && (localExtraTypeInfo.sourceType == 9002) && (paramFollowUpdateEvent != null)) {
        broadcastFollowIfNeed(paramActivity, paramFollowUpdateEvent.useId, paramFollowUpdateEvent.followStatus);
      }
    }
  }
  
  public static void broadcastFollowIfNeed(Context paramContext, FollowUpdateEvent paramFollowUpdateEvent)
  {
    if (paramFollowUpdateEvent != null) {
      broadcastFollowIfNeed(paramContext, paramFollowUpdateEvent.useId, paramFollowUpdateEvent.followStatus);
    }
  }
  
  public static void broadcastFollowIfNeed(Context paramContext, String paramString, int paramInt)
  {
    if (paramContext != null)
    {
      if (paramString == null) {
        return;
      }
      Intent localIntent = new Intent("action.qzone_public_account_follow");
      localIntent.putExtra("followed", paramInt);
      localIntent.putExtra("uin", paramString);
      paramContext.sendBroadcast(localIntent, "com.tencent.qzone.permission.notify");
    }
  }
  
  public static boolean isQZonePluginReady(Context paramContext, AppRuntime paramAppRuntime)
  {
    boolean bool2 = QZoneApiProxy.needLoadQZoneEnv();
    boolean bool1 = false;
    if (bool2)
    {
      ClassLoader localClassLoader = QzonePluginProxyActivity.getQZonePluginClassLoaderInUI();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QzonePublicAccountHelper: start to load qzone plugin ");
      if (localClassLoader != null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localStringBuilder.append(bool1);
      QLog.i("QzonePublicAccountHelper", 1, localStringBuilder.toString());
      if (localClassLoader == null)
      {
        QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").post(new QzonePublicAccountHelper.1(paramContext, paramAppRuntime));
        return false;
      }
      bool1 = ((IQZoneApiProxy)QRoute.api(IQZoneApiProxy.class)).needShowMsgFeedList((Activity)paramContext, paramAppRuntime);
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.util.QzonePublicAccountHelper
 * JD-Core Version:    0.7.0.1
 */
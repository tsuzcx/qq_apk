package cooperation.qzone.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.event.FollowUpdateEvent;

public class QzonePublicAccountHelper
{
  private static final String ACTION_FOLLOW = "action.qzone_public_account_follow";
  private static final String PERMISSION = "com.tencent.qzone.permission.notify";
  private static final String TAG = "QzonePublicAccountHelper";
  
  public static void broadcastFollowIfNeed(Activity paramActivity, FollowUpdateEvent paramFollowUpdateEvent)
  {
    if ((paramActivity == null) || (paramActivity.getIntent() == null)) {}
    ExtraTypeInfo localExtraTypeInfo;
    do
    {
      return;
      localExtraTypeInfo = (ExtraTypeInfo)paramActivity.getIntent().getSerializableExtra("key_subscribe_intent_extra_type_info");
    } while ((localExtraTypeInfo == null) || (localExtraTypeInfo.sourceType != 9002) || (paramFollowUpdateEvent == null));
    broadcastFollowIfNeed(paramActivity, paramFollowUpdateEvent.useId, paramFollowUpdateEvent.followStatus);
  }
  
  public static void broadcastFollowIfNeed(Context paramContext, FollowUpdateEvent paramFollowUpdateEvent)
  {
    if (paramFollowUpdateEvent != null) {
      broadcastFollowIfNeed(paramContext, paramFollowUpdateEvent.useId, paramFollowUpdateEvent.followStatus);
    }
  }
  
  public static void broadcastFollowIfNeed(Context paramContext, String paramString, int paramInt)
  {
    if ((paramContext == null) || (paramString == null)) {
      return;
    }
    Intent localIntent = new Intent("action.qzone_public_account_follow");
    localIntent.putExtra("followed", paramInt);
    localIntent.putExtra("uin", paramString);
    paramContext.sendBroadcast(localIntent, "com.tencent.qzone.permission.notify");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.util.QzonePublicAccountHelper
 * JD-Core Version:    0.7.0.1
 */
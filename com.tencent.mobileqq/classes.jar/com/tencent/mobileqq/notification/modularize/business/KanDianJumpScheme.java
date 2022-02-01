package com.tencent.mobileqq.notification.modularize.business;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.biz.common.baseui.api.IReadInJoyLockScreenJumpDelegate;
import com.tencent.mobileqq.kandian.biz.daily.api.IKandianDailyManagerService;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyActivityHelper;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.push.api.IKanDianMergeManager;
import com.tencent.mobileqq.notification.modularize.BaseJumpScheme;
import com.tencent.mobileqq.notification.modularize.PushComponent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/notification/modularize/business/KanDianJumpScheme;", "Lcom/tencent/mobileqq/notification/modularize/BaseJumpScheme;", "()V", "customJumpIntent", "Landroid/app/PendingIntent;", "pushComponent", "Lcom/tencent/mobileqq/notification/modularize/PushComponent;", "generatePendingIntent", "Landroid/content/Intent;", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "messageRecord", "Lcom/tencent/mobileqq/data/MessageRecord;", "context", "Landroid/content/Context;", "nativeJumpIntent", "needCustomJump", "", "processMsg0x210Sub0x135ExtData", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class KanDianJumpScheme
  extends BaseJumpScheme
{
  public static final KanDianJumpScheme.Companion a = new KanDianJumpScheme.Companion(null);
  
  private final Intent a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, Context paramContext, PushComponent paramPushComponent)
  {
    if (((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).isDailySceneType(paramMessageRecord))
    {
      paramQQAppInterface = paramQQAppInterface.getRuntimeService(IKandianDailyManagerService.class);
      Intrinsics.checkExpressionValueIsNotNull(paramQQAppInterface, "app.getRuntimeService(IK…nagerService::class.java)");
      paramQQAppInterface = (IKandianDailyManagerService)paramQQAppInterface;
      paramQQAppInterface = ((IReadInJoyLockScreenJumpDelegate)QRoute.api(IReadInJoyLockScreenJumpDelegate.class)).getJumpDailyFragmentIntent(paramContext, 6, paramQQAppInterface.getAndRemoveLockScreenRedDodInfo());
    }
    else
    {
      paramQQAppInterface = ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).getJumpReadInJoyTabIntent(paramContext, 6);
    }
    paramQQAppInterface.putExtra("is_from_push_component", true);
    paramQQAppInterface.putExtra("push_main_business_id", paramPushComponent.a);
    paramQQAppInterface.putExtra("push_sub_business_id", paramPushComponent.b);
    paramQQAppInterface.putExtra("push_id", paramPushComponent.c);
    paramQQAppInterface.putExtra("push_trigger_info", paramPushComponent.i);
    paramQQAppInterface.addFlags(268435456);
    return paramQQAppInterface;
  }
  
  private final MessageRecord a(QQAppInterface paramQQAppInterface, PushComponent paramPushComponent)
  {
    return ((IKanDianMergeManager)paramQQAppInterface.getRuntimeService(IKanDianMergeManager.class)).createFakeMsgFrom0x135PBBuffer(paramPushComponent.n, paramPushComponent.e);
  }
  
  private final PendingIntent e(PushComponent paramPushComponent)
  {
    Object localObject1 = (Intent)null;
    BaseApplication localBaseApplication = BaseApplication.context;
    Object localObject2;
    if (paramPushComponent.b == 1)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("nativeJumpIntent bytesExtData: ");
      ((StringBuilder)localObject1).append(new String(paramPushComponent.n, Charsets.UTF_8));
      QLog.d("KanDianJumpScheme", 1, ((StringBuilder)localObject1).toString());
      localObject1 = BaseApplicationImpl.getApplication();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "BaseApplicationImpl.getApplication()");
      localObject1 = ((BaseApplicationImpl)localObject1).getRuntime();
      if (localObject1 != null)
      {
        Object localObject3 = (QQAppInterface)localObject1;
        localObject2 = a((QQAppInterface)localObject3, paramPushComponent);
        Intrinsics.checkExpressionValueIsNotNull(localBaseApplication, "context");
        localObject1 = a((QQAppInterface)localObject3, (MessageRecord)localObject2, (Context)localBaseApplication, paramPushComponent);
        IReadInJoyUtils localIReadInJoyUtils = (IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class);
        localObject3 = ((QQAppInterface)localObject3).getMessageFacade();
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "app.messageFacade");
        localIReadInJoyUtils.reportForLockScreenExposure(localObject3, (MessageRecord)localObject2, (Intent)localObject1);
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
      }
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("invalid subBusinessId. pushComponent: ");
      ((StringBuilder)localObject2).append(paramPushComponent);
      QLog.d("KanDianJumpScheme", 1, new Object[] { "nativeJumpIntent: called. ", ((StringBuilder)localObject2).toString() });
    }
    paramPushComponent = PendingIntent.getActivity((Context)localBaseApplication, paramPushComponent.d, (Intent)localObject1, 134217728);
    Intrinsics.checkExpressionValueIsNotNull(paramPushComponent, "PendingIntent.getActivit…tent.FLAG_UPDATE_CURRENT)");
    return paramPushComponent;
  }
  
  @NotNull
  protected PendingIntent a(@NotNull PushComponent paramPushComponent)
  {
    Intrinsics.checkParameterIsNotNull(paramPushComponent, "pushComponent");
    return e(paramPushComponent);
  }
  
  protected boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.notification.modularize.business.KanDianJumpScheme
 * JD-Core Version:    0.7.0.1
 */
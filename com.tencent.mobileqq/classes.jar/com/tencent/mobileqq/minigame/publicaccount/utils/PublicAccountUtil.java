package com.tencent.mobileqq.minigame.publicaccount.utils;

import android.content.Context;
import android.os.Bundle;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver.OnCallback;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.reuse.MiniAppTransferModule;
import com.tencent.mobileqq.qroute.QRoute;
import eipc.EIPCResult;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/minigame/publicaccount/utils/PublicAccountUtil;", "", "()V", "KEY_IS_FOLLOW", "", "KEY_PA_UIN", "KEY_RESULT_CODE", "TAG", "followPA", "", "appInterface", "Lcom/tencent/mobileqq/app/QQAppInterface;", "params", "Landroid/os/Bundle;", "transferModule", "Lcom/tencent/mobileqq/mini/reuse/MiniAppTransferModule;", "callbackId", "", "followPACallBack", "isSuccess", "", "isPAFollow", "qqmini_impl_release"}, k=1, mv={1, 1, 16})
public final class PublicAccountUtil
{
  public static final PublicAccountUtil INSTANCE = new PublicAccountUtil();
  @NotNull
  public static final String KEY_IS_FOLLOW = "pa_is_follow";
  @NotNull
  public static final String KEY_PA_UIN = "pa_uin";
  @NotNull
  public static final String KEY_RESULT_CODE = "pa_result_code";
  private static final String TAG = "PublicAccountUtil";
  
  @JvmStatic
  public static final void followPA(@NotNull QQAppInterface paramQQAppInterface, @NotNull Bundle paramBundle, @NotNull MiniAppTransferModule paramMiniAppTransferModule, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "appInterface");
    Intrinsics.checkParameterIsNotNull(paramBundle, "params");
    Intrinsics.checkParameterIsNotNull(paramMiniAppTransferModule, "transferModule");
    long l = paramBundle.getLong("pa_uin");
    boolean bool = paramBundle.getBoolean("pa_is_follow");
    paramBundle = QRoute.api(IPublicAccountObserver.class);
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "QRoute.api(IPublicAccountObserver::class.java)");
    paramBundle = (IPublicAccountObserver)paramBundle;
    paramBundle.setOnCallback((IPublicAccountObserver.OnCallback)new PublicAccountUtil.followPA.1(paramMiniAppTransferModule, paramInt));
    if (bool)
    {
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).followUin((AppInterface)paramQQAppInterface, (Context)BaseApplicationImpl.getContext(), String.valueOf(l), paramBundle, false, 0, true);
      return;
    }
    ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).unfollowUin((AppInterface)paramQQAppInterface, (Context)BaseApplicationImpl.getContext(), String.valueOf(l), false, paramBundle, true);
  }
  
  private final void followPACallBack(boolean paramBoolean, MiniAppTransferModule paramMiniAppTransferModule, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("pa_result_code", paramBoolean);
    paramMiniAppTransferModule.callbackResult(paramInt, EIPCResult.createResult(0, localBundle));
  }
  
  @JvmStatic
  public static final void isPAFollow(@NotNull QQAppInterface paramQQAppInterface, @NotNull Bundle paramBundle, @NotNull MiniAppTransferModule paramMiniAppTransferModule, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "appInterface");
    Intrinsics.checkParameterIsNotNull(paramBundle, "params");
    Intrinsics.checkParameterIsNotNull(paramMiniAppTransferModule, "transferModule");
    long l = paramBundle.getLong("pa_uin");
    paramQQAppInterface = paramQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
    Intrinsics.checkExpressionValueIsNotNull(paramQQAppInterface, "appInterface.getRuntimeS…ava, ProcessConstant.ALL)");
    ThreadManager.executeOnFileThread((Runnable)new PublicAccountUtil.isPAFollow.1((IPublicAccountDataManager)paramQQAppInterface, l, new Bundle(), paramMiniAppTransferModule, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.utils.PublicAccountUtil
 * JD-Core Version:    0.7.0.1
 */
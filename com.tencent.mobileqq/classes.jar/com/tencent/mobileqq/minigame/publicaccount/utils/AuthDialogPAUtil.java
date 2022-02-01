package com.tencent.mobileqq.minigame.publicaccount.utils;

import NS_COMM.COMM.Entry;
import NS_MINI_INTERFACE.INTERFACE.StExampleDetail;
import NS_MINI_INTERFACE.INTERFACE.StSubscribeMessage;
import android.os.Bundle;
import com.tencent.mobileqq.minigame.publicaccount.config.MiniGamePASubscribeConfBean;
import com.tencent.mobileqq.minigame.publicaccount.config.MiniGamePASubscribeProcessor;
import com.tencent.mobileqq.minigame.publicaccount.config.MiniGamePASubscribeProcessor.Companion;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.SpecialProxy.EventCallback;
import eipc.EIPCClient;
import eipc.EIPCResultCallback;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/minigame/publicaccount/utils/AuthDialogPAUtil;", "", "()V", "TAG", "", "followMiniGamePA", "", "eventCallback", "Lcom/tencent/qqmini/sdk/launcher/core/proxy/SpecialProxy$EventCallback;", "getMiniGamePASubMsg", "", "qqmini_impl_release"}, k=1, mv={1, 1, 16})
public final class AuthDialogPAUtil
{
  public static final AuthDialogPAUtil INSTANCE = new AuthDialogPAUtil();
  private static final String TAG = "AuthDialogPAUtil";
  
  @JvmStatic
  public static final void followMiniGamePA(@Nullable SpecialProxy.EventCallback paramEventCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("pa_uin", Long.parseLong("1983141935"));
    localBundle.putBoolean("pa_is_follow", true);
    paramEventCallback = (EIPCResultCallback)new AuthDialogPAUtil.followMiniGamePA.callback.1(paramEventCallback);
    QIPCClientHelper localQIPCClientHelper = QIPCClientHelper.getInstance();
    Intrinsics.checkExpressionValueIsNotNull(localQIPCClientHelper, "QIPCClientHelper.getInstance()");
    localQIPCClientHelper.getClient().callServer("MiniAppTransferModule", "public_account_follow", localBundle, paramEventCallback);
  }
  
  @JvmStatic
  public static final void getMiniGamePASubMsg(@NotNull SpecialProxy.EventCallback paramEventCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramEventCallback, "eventCallback");
    if (!MiniGamePASubscribeProcessor.Companion.loadConfig().isShowSubscribe())
    {
      paramEventCallback.onResult(false, null);
      QLog.d("AuthDialogPAUtil", 2, "isShowSubscribe false");
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putLong("pa_uin", Long.parseLong("1983141935"));
    paramEventCallback = (EIPCResultCallback)new AuthDialogPAUtil.getMiniGamePASubMsg.callback.1(paramEventCallback);
    QIPCClientHelper localQIPCClientHelper = QIPCClientHelper.getInstance();
    Intrinsics.checkExpressionValueIsNotNull(localQIPCClientHelper, "QIPCClientHelper.getInstance()");
    localQIPCClientHelper.getClient().callServer("MiniAppTransferModule", "public_account_is_follow", localBundle, paramEventCallback);
  }
  
  private final byte[] getMiniGamePASubMsg()
  {
    Object localObject = new INTERFACE.StSubscribeMessage();
    ((INTERFACE.StSubscribeMessage)localObject).authState.set(0);
    INTERFACE.StExampleDetail localStExampleDetail = new INTERFACE.StExampleDetail();
    List localList = (List)new ArrayList();
    COMM.Entry localEntry = new COMM.Entry();
    localEntry.key.set("通知类型");
    localEntry.value.set("官方订阅消息");
    localList.add(localEntry);
    localEntry = new COMM.Entry();
    localEntry.key.set("消息来源");
    localEntry.value.set("QQ小游戏");
    localList.add(localEntry);
    localEntry = new COMM.Entry();
    localEntry.key.set("消息示例");
    localEntry.value.set("QQ小游戏最新消息、每日礼包等福利内容等你查看");
    localList.add(localEntry);
    localStExampleDetail.title.set("订阅QQ小游戏");
    localStExampleDetail.contents.set(localList);
    ((INTERFACE.StSubscribeMessage)localObject).example.set((MessageMicro)localStExampleDetail);
    localObject = ((INTERFACE.StSubscribeMessage)localObject).toByteArray();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "stSubscribeMessage.toByteArray()");
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.utils.AuthDialogPAUtil
 * JD-Core Version:    0.7.0.1
 */
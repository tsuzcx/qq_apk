package com.tencent.mobileqq.minigame.publicaccount.hippy.module;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.hippy.qq.module.QQBaseModule;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.ShortcutUtils;
import eipc.EIPCResultCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@HippyNativeModule(name="MiniGamePANativeModule")
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/minigame/publicaccount/hippy/module/MiniGamePANativeModule;", "Lcom/tencent/hippy/qq/module/QQBaseModule;", "hippyEngineContext", "Lcom/tencent/mtt/hippy/HippyEngineContext;", "(Lcom/tencent/mtt/hippy/HippyEngineContext;)V", "addShortCutFailed", "", "code", "", "msg", "", "promise", "Lcom/tencent/mtt/hippy/modules/Promise;", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/tencent/mtt/hippy/modules/Promise;)V", "addShortcut", "params", "Lcom/tencent/mtt/hippy/common/HippyMap;", "getMiniGameArkModels", "openAIO", "openMiniApp", "Companion", "qqmini_impl_release"}, k=1, mv={1, 1, 16})
public final class MiniGamePANativeModule
  extends QQBaseModule
{
  @NotNull
  public static final String CLASSNAME = "MiniGamePANativeModule";
  public static final MiniGamePANativeModule.Companion Companion = new MiniGamePANativeModule.Companion(null);
  
  public MiniGamePANativeModule(@NotNull HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  private final void addShortCutFailed(Integer paramInteger, String paramString, Promise paramPromise)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("code", paramInteger);
    localJSONObject.put("message", paramString);
    paramPromise.reject(localJSONObject.toString());
  }
  
  @HippyMethod(name="addShortcut")
  public final void addShortcut(@Nullable HippyMap paramHippyMap, @NotNull Promise paramPromise)
  {
    Intrinsics.checkParameterIsNotNull(paramPromise, "promise");
    if (QLog.isColorLevel()) {
      QLog.i("MiniGamePANativeModule", 2, "addShortcut");
    }
    if (paramHippyMap == null)
    {
      addShortCutFailed(Integer.valueOf(-1), "params is null!", paramPromise);
      return;
    }
    Object localObject1 = paramHippyMap.getString("title");
    String str = paramHippyMap.getString("icon");
    paramHippyMap = paramHippyMap.getString("url");
    Object localObject2 = MobileQQ.sMobileQQ;
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "MobileQQ.sMobileQQ");
    localObject2 = ((MobileQQ)localObject2).getBaseContext();
    if (ShortcutUtils.a((Context)localObject2) == 1)
    {
      ShortcutUtils.a(getActivity());
      addShortCutFailed(Integer.valueOf(-1), "no permission to create shortcut", paramPromise);
      return;
    }
    if (QQUtils.a((Context)localObject2, new String[] { localObject1 }))
    {
      paramHippyMap = QQToast.a((Context)getActivity(), 2131692087, 0);
      localObject1 = getActivity();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "activity");
      paramHippyMap.b(((Activity)localObject1).getResources().getDimensionPixelSize(2131299168));
      paramPromise.resolve("");
      return;
    }
    ThreadManagerV2.excute((Runnable)new MiniGamePANativeModule.addShortcut.1(this, (Context)localObject2, paramHippyMap, (String)localObject1, str, paramPromise), 128, null, true);
  }
  
  @HippyMethod(name="getMiniGameArkModels")
  public final void getMiniGameArkModels(@Nullable HippyMap paramHippyMap, @NotNull Promise paramPromise)
  {
    Intrinsics.checkParameterIsNotNull(paramPromise, "promise");
    if (QLog.isColorLevel()) {
      QLog.i("MiniGamePANativeModule", 2, "getMiniGameArkModels");
    }
    QIPCClientHelper.getInstance().callServer("MiniGamePublicAccountIPCModule", "action_get_mini_game_public_account_msg", null, (EIPCResultCallback)new MiniGamePANativeModule.getMiniGameArkModels.1(paramPromise));
  }
  
  @HippyMethod(name="openAIO")
  public final void openAIO()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MiniGamePANativeModule", 2, "openAIO");
    }
    try
    {
      Intent localIntent = new Intent();
      localIntent.setClass((Context)getActivity(), ChatActivity.class);
      AIOUtils.a(localIntent, new int[] { 1 });
      localIntent.putExtra("uin", AppConstants.MINI_GAME_PUBLIC_ACCOUNT_UIN);
      localIntent.putExtra("uintype", 1008);
      localIntent.putExtra("uinname", getActivity().getString(2131694179));
      localIntent.putExtra("aio_msg_source", 0);
      localIntent.putExtra("shouldreport", true);
      getActivity().startActivity(localIntent);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("MiniGamePANativeModule", 1, "jumpMiniGameAIO error", localThrowable);
    }
  }
  
  @HippyMethod(name="openMiniApp")
  public final void openMiniApp(@NotNull HippyMap paramHippyMap)
  {
    Intrinsics.checkParameterIsNotNull(paramHippyMap, "params");
    Object localObject = paramHippyMap.getString("url");
    int i = paramHippyMap.getInt("scene");
    if (QLog.isColorLevel())
    {
      paramHippyMap = new StringBuilder();
      paramHippyMap.append("openMiniApp:");
      paramHippyMap.append((String)localObject);
      paramHippyMap.append(", scene:");
      paramHippyMap.append(i);
      QLog.i("MiniGamePANativeModule", 2, paramHippyMap.toString());
    }
    paramHippyMap = getActivity();
    if (paramHippyMap == null)
    {
      QLog.e("MiniGamePANativeModule", 1, "openMiniApp activity is null");
      return;
    }
    try
    {
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp((Context)paramHippyMap, (String)localObject, i, null);
      return;
    }
    catch (Exception paramHippyMap)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("openMiniApp error: ");
      ((StringBuilder)localObject).append(paramHippyMap.getMessage());
      QLog.e("MiniGamePANativeModule", 1, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.hippy.module.MiniGamePANativeModule
 * JD-Core Version:    0.7.0.1
 */
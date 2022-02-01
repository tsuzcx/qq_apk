package com.tencent.mobileqq.cmshow.engine;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/engine/EngineHelper;", "", "()V", "TAG", "", "uiHandler", "Landroid/os/Handler;", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "debug", "", "action", "Lkotlin/Function0;", "genArgumentParam", "cmd", "reqData", "genArgumentParam$cmshow_impl_release", "isRunOnUiThread", "", "runOnUiThread", "savePixels2File", "path", "pixels", "", "width", "", "height", "byteLength", "savePixels2File$cmshow_impl_release", "toast", "message", "iconType", "wrapResultFailed", "Lorg/json/JSONObject;", "errMsg", "wrapResultFailed$cmshow_impl_release", "wrapResultSuccess", "wrapResultSuccess$cmshow_impl_release", "extractErrCode", "extractErrCode$cmshow_impl_release", "isVariableCmd", "isVariableCmd$cmshow_impl_release", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class EngineHelper
{
  private static final Handler a;
  public static final EngineHelper a;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqCmshowEngineEngineHelper = new EngineHelper();
    jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  private final boolean a()
  {
    Thread localThread = Thread.currentThread();
    Looper localLooper = Looper.getMainLooper();
    Intrinsics.checkExpressionValueIsNotNull(localLooper, "Looper.getMainLooper()");
    return Intrinsics.areEqual(localThread, localLooper.getThread());
  }
  
  public final int a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$extractErrCode");
    try
    {
      int i = new JSONObject(paramString).optInt("errCode", 0);
      return i;
    }
    catch (Throwable paramString) {}
    return 0;
  }
  
  @Nullable
  public final QQAppInterface a()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject != null)
    {
      localObject = ((BaseApplicationImpl)localObject).getRuntime();
      if ((localObject instanceof QQAppInterface)) {
        return (QQAppInterface)localObject;
      }
    }
    return null;
  }
  
  @NotNull
  public final String a(@NotNull String paramString1, @Nullable String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "cmd");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{\"cmd\":\"");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("\", \"params\":");
    localStringBuilder.append(paramString2);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  @NotNull
  public final JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("errCode", 0);
    return localJSONObject;
  }
  
  @NotNull
  public final JSONObject a(@Nullable String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("errCode", 1);
    if (!TextUtils.isEmpty((CharSequence)paramString)) {
      localJSONObject.put("errMsg", paramString);
    }
    return localJSONObject;
  }
  
  public final void a(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "action");
    if (a())
    {
      paramFunction0.invoke();
      return;
    }
    jdField_a_of_type_AndroidOsHandler.post((Runnable)new EngineHelper.runOnUiThread.1(paramFunction0));
  }
  
  public final boolean a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$isVariableCmd");
    return (StringsKt.startsWith$default(paramString, "apollo_", false, 2, null)) && (!StringsKt.endsWith$default(paramString, ".local", false, 2, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.EngineHelper
 * JD-Core Version:    0.7.0.1
 */
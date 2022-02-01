package com.tencent.mobileqq.minigame.publicaccount.hippy;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.hippy.qq.api.IPatchBundleDataHandler;
import com.tencent.hippy.qq.app.HippyQQPreloadEngine;
import com.tencent.hippy.qq.fragment.BaseHippyFragment;
import com.tencent.hippy.qq.fragment.HippyProgressBarWrapper;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.hippy.qq.utils.SerializableMap;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/minigame/publicaccount/hippy/MiniGamePAHippyBaseFragment;", "Lcom/tencent/hippy/qq/fragment/BaseHippyFragment;", "Landroid/os/Handler$Callback;", "()V", "hippyContainer", "Landroid/view/ViewGroup;", "getHippyContainer", "()Landroid/view/ViewGroup;", "setHippyContainer", "(Landroid/view/ViewGroup;)V", "mProgressBarWrapper", "Lcom/tencent/hippy/qq/fragment/HippyProgressBarWrapper;", "mStartTime", "", "getMStartTime", "()J", "setMStartTime", "(J)V", "mTimeoutHandler", "Landroid/os/Handler;", "rootView", "getRootView", "setRootView", "doBussinessInitData", "Lorg/json/JSONObject;", "jsInitData", "getFromValue", "", "getLayoutResId", "", "handleMessage", "", "msg", "Landroid/os/Message;", "initProgressBar", "", "initViews", "initWindowStyleAndAnimation", "activity", "Landroid/app/Activity;", "isNightTheme", "notifyHippyThemeChange", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "onDestroyView", "onLoadHippyError", "statusCode", "onLoadHippySuccess", "reportTimeOut", "setStatusBarImmersive", "Companion", "qqmini_impl_release"}, k=1, mv={1, 1, 16})
public abstract class MiniGamePAHippyBaseFragment
  extends BaseHippyFragment
  implements Handler.Callback
{
  public static final MiniGamePAHippyBaseFragment.Companion Companion = new MiniGamePAHippyBaseFragment.Companion(null);
  @NotNull
  public static final String FROM_DEFAULT = "other";
  @NotNull
  public static final String FROM_MESSAGE = "message";
  @NotNull
  public static final String KEY_FROM = "from";
  @NotNull
  public static final String KEY_PRE_DRAW = "isPredraw";
  @NotNull
  public static final String KEY_THEME = "isNightMode";
  @NotNull
  public static final String KEY_THEME_CHANGE = "themeChange";
  public static final long LOAD_HIPPY_TIME_OUT = 9000L;
  private static final int MSG_TIME_OUT = 1;
  @NotNull
  public static final String TAG = "MiniGamePAHippyBaseFragment";
  @NotNull
  protected ViewGroup hippyContainer;
  private final HippyProgressBarWrapper mProgressBarWrapper = new HippyProgressBarWrapper();
  private long mStartTime;
  private final Handler mTimeoutHandler = new Handler((Handler.Callback)this);
  @NotNull
  protected ViewGroup rootView;
  
  private final String getFromValue()
  {
    if (Intrinsics.areEqual("aio", getParameters().getString("from"))) {
      return "message";
    }
    return "other";
  }
  
  private final void reportTimeOut()
  {
    if (this.mHippyQQEngine == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    Object localObject2 = (Map)localHashMap;
    boolean bool = false;
    ((Map)localObject2).put("ret", Integer.valueOf(0));
    Object localObject1 = getLastStepName();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "lastStepName");
    ((Map)localObject2).put("errMsg", localObject1);
    localObject1 = this.mHippyQQEngine;
    if (localObject1 != null) {
      bool = ((HippyQQPreloadEngine)localObject1).isPreloaded();
    }
    ((Map)localObject2).put("isPreload", Boolean.valueOf(bool));
    localObject1 = getParameters().getString("from");
    if (localObject1 == null) {
      localObject1 = "";
    }
    ((Map)localObject2).put("from", localObject1);
    localObject1 = HippyReporter.getInstance();
    localObject2 = this.mHippyQQEngine;
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "mHippyQQEngine");
    localObject2 = ((HippyQQPreloadEngine)localObject2).getModuleName();
    HippyQQPreloadEngine localHippyQQPreloadEngine = this.mHippyQQEngine;
    Intrinsics.checkExpressionValueIsNotNull(localHippyQQPreloadEngine, "mHippyQQEngine");
    ((HippyReporter)localObject1).reportHippyLoadResult(6, (String)localObject2, localHippyQQPreloadEngine.getModuleVersion(), localHashMap, generateStepCosts());
  }
  
  @Nullable
  protected JSONObject doBussinessInitData(@Nullable JSONObject paramJSONObject)
  {
    for (;;)
    {
      try
      {
        ((IPatchBundleDataHandler)QRoute.api(IPatchBundleDataHandler.class)).checkWrapSSOData(paramJSONObject, getModuleName());
        Object localObject1 = getParameters().getSerializable("js_param_map");
        bool = localObject1 instanceof SerializableMap;
        localObject2 = null;
        if (!bool) {
          localObject1 = null;
        }
        SerializableMap localSerializableMap = (SerializableMap)localObject1;
        IHippyAccessHelper localIHippyAccessHelper = (IHippyAccessHelper)QRoute.api(IHippyAccessHelper.class);
        localObject1 = localObject2;
        if (localSerializableMap != null) {
          localObject1 = localSerializableMap.getMap();
        }
        localObject1 = localIHippyAccessHelper.wrapHashMap(paramJSONObject, (HashMap)localObject1);
        if (this.mHippyQQEngine != null)
        {
          localObject2 = this.mHippyQQEngine;
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "mHippyQQEngine");
          if (((HippyQQPreloadEngine)localObject2).isPredraw())
          {
            bool = true;
            ((JSONObject)localObject1).put("isPredraw", bool);
            ((JSONObject)localObject1).put("isNightMode", isNightTheme());
            ((JSONObject)localObject1).put("from", getFromValue());
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("doBussinessInitData jsonObject=");
              ((StringBuilder)localObject2).append(localObject1);
              QLog.d("MiniGamePAHippyBaseFragment", 2, ((StringBuilder)localObject2).toString());
            }
            if (localObject1 != null) {
              paramJSONObject = (JSONObject)localObject1;
            }
            return paramJSONObject;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("doBussinessInitData:");
        ((StringBuilder)localObject2).append(localThrowable);
        QLog.e("BaseHippyFragment", 1, ((StringBuilder)localObject2).toString());
        return paramJSONObject;
      }
      boolean bool = false;
    }
  }
  
  @NotNull
  protected final ViewGroup getHippyContainer()
  {
    ViewGroup localViewGroup = this.hippyContainer;
    if (localViewGroup == null) {
      Intrinsics.throwUninitializedPropertyAccessException("hippyContainer");
    }
    return localViewGroup;
  }
  
  public abstract int getLayoutResId();
  
  protected final long getMStartTime()
  {
    return this.mStartTime;
  }
  
  @NotNull
  protected final ViewGroup getRootView()
  {
    ViewGroup localViewGroup = this.rootView;
    if (localViewGroup == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootView");
    }
    return localViewGroup;
  }
  
  public boolean handleMessage(@Nullable Message paramMessage)
  {
    if ((paramMessage != null) && (paramMessage.what == 1))
    {
      QLog.d("BaseHippyFragment", 1, "Hippy: load timeout");
      if (!isFragmentDestroyed()) {
        gotoErrorUrl();
      }
      if (this.mHippyQQEngine != null) {
        reportTimeOut();
      }
      return true;
    }
    return false;
  }
  
  public void initProgressBar()
  {
    Object localObject = this.mHippyQQEngine;
    if ((localObject != null) && (!((HippyQQPreloadEngine)localObject).isNeedShowLoading())) {
      return;
    }
    localObject = this.mProgressBarWrapper;
    ViewGroup localViewGroup = this.rootView;
    if (localViewGroup == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootView");
    }
    ((HippyProgressBarWrapper)localObject).initProgressBar(localViewGroup);
    this.mProgressBarWrapper.startProgressBar();
  }
  
  public void initViews()
  {
    Object localObject = this.rootView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootView");
    }
    localObject = ((ViewGroup)localObject).findViewById(2131368190);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "rootView.findViewById(R.id.hippy_container)");
    this.hippyContainer = ((ViewGroup)localObject);
  }
  
  public void initWindowStyleAndAnimation(@Nullable Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    if (paramActivity != null)
    {
      paramActivity = paramActivity.getWindow();
      if (paramActivity != null) {
        paramActivity.setFlags(16777216, 16777216);
      }
    }
  }
  
  protected final boolean isNightTheme()
  {
    return ThemeUtil.isNowThemeIsNight(null, false, null);
  }
  
  protected final void notifyHippyThemeChange(boolean paramBoolean)
  {
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushBoolean("isNightMode", paramBoolean);
    sendHippyNativeEvent("themeChange", localHippyMap);
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setStatusBarImmersive();
    if (QLog.isColorLevel()) {
      QLog.d("MiniGamePAHippyBaseFragment", 2, "MiniGame hippy Fragment init!");
    }
  }
  
  @Nullable
  public View onCreateView(@NotNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramLayoutInflater, "inflater");
    this.mStartTime = SystemClock.elapsedRealtime();
    paramLayoutInflater = getLayoutInflater().inflate(getLayoutResId(), null, false);
    if (paramLayoutInflater != null)
    {
      this.rootView = ((ViewGroup)paramLayoutInflater);
      initViews();
      paramLayoutInflater = this.hippyContainer;
      if (paramLayoutInflater == null) {
        Intrinsics.throwUninitializedPropertyAccessException("hippyContainer");
      }
      loadHippy(paramLayoutInflater);
      setStatusBarImmersive();
      initProgressBar();
      paramLayoutInflater = this.mHippyQQEngine;
      if ((paramLayoutInflater != null) && (!paramLayoutInflater.isPredraw())) {
        this.mTimeoutHandler.sendEmptyMessageDelayed(1, 9000L);
      }
      paramLayoutInflater = this.rootView;
      if (paramLayoutInflater == null) {
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
      }
      return (View)paramLayoutInflater;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
  }
  
  public void onDestroyView()
  {
    this.mTimeoutHandler.removeMessages(1);
    super.onDestroyView();
  }
  
  protected void onLoadHippyError(int paramInt, @Nullable String paramString)
  {
    this.mTimeoutHandler.removeMessages(1);
    this.mProgressBarWrapper.hideProgressBar();
  }
  
  protected void onLoadHippySuccess()
  {
    this.mTimeoutHandler.removeMessages(1);
    this.mProgressBarWrapper.hideProgressBar();
    notifyHippyThemeChange(isNightTheme());
  }
  
  protected final void setHippyContainer(@NotNull ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "<set-?>");
    this.hippyContainer = paramViewGroup;
  }
  
  protected final void setMStartTime(long paramLong)
  {
    this.mStartTime = paramLong;
  }
  
  protected final void setRootView(@NotNull ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "<set-?>");
    this.rootView = paramViewGroup;
  }
  
  public void setStatusBarImmersive()
  {
    QBaseActivity localQBaseActivity = getQBaseActivity();
    if (localQBaseActivity != null)
    {
      if (ImmersiveUtils.isSupporImmersive() == 1) {
        if (localQBaseActivity.mSystemBarComp == null)
        {
          localQBaseActivity.setImmersiveStatus(0);
        }
        else
        {
          localQBaseActivity.mSystemBarComp.setStatusBarDrawable(null);
          localQBaseActivity.mSystemBarComp.setStatusBarColor(0);
          localQBaseActivity.mSystemBarComp.setStatusColor(0);
        }
      }
      LiuHaiUtils.enableNotch((Activity)localQBaseActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.hippy.MiniGamePAHippyBaseFragment
 * JD-Core Version:    0.7.0.1
 */
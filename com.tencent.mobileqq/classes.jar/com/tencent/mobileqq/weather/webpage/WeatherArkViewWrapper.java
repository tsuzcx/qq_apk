package com.tencent.mobileqq.weather.webpage;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.ark.open.ArkAppInfo.Size;
import com.tencent.ark.open.ArkView;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.ark.api.IArkEnvDelegate;
import com.tencent.mobileqq.ark.api.IArkEnvironment;
import com.tencent.mobileqq.ark.temp.api.IArkTempApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.weather.WeatherDCReportHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/weather/webpage/WeatherArkViewWrapper;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleRes", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "arkHeight", "getArkHeight", "()I", "setArkHeight", "(I)V", "arkLoadCallback", "Lcom/tencent/ark/ArkViewImplement$LoadCallback;", "arkView", "Lcom/tencent/ark/open/ArkView;", "getArkView", "()Lcom/tencent/ark/open/ArkView;", "downInArk", "", "hasMakeUpForTheLossDownEvent", "hasMove", "isArkLoaded", "()Z", "setArkLoaded", "(Z)V", "mSlideStartDir", "", "mStartTime", "", "mStartX", "", "mStartY", "scaledTouchSlop", "getScaledTouchSlop", "scaledTouchSlop$delegate", "Lkotlin/Lazy;", "topPadding", "getTopPadding", "topPadding$delegate", "touchEventData", "Landroidx/lifecycle/MutableLiveData;", "Landroid/view/MotionEvent;", "getTouchEventData", "()Landroidx/lifecycle/MutableLiveData;", "viewModel", "Lcom/tencent/mobileqq/weather/webpage/WeatherWebArkViewModel;", "createLoadFailView", "Landroid/view/View;", "dispatchTouchEvent", "event", "initArkView", "", "appName", "", "appView", "appVersion", "appMeta", "initViewModel", "makeUpForLossDownEvent", "isForArk", "onLoadFailed", "onLoadSuccess", "onLoading", "setArkFixScaleDensity", "swipeDirectionJudge", "curX", "curY", "touchInArk", "y", "translateYToArkY", "Companion", "qq-weather-impl_release"}, k=1, mv={1, 1, 16})
public final class WeatherArkViewWrapper
  extends FrameLayout
{
  public static final WeatherArkViewWrapper.Companion a = new WeatherArkViewWrapper.Companion(null);
  @NotNull
  private final ArkView b;
  @NotNull
  private final MutableLiveData<MotionEvent> c = new MutableLiveData();
  private boolean d;
  private WeatherWebArkViewModel e;
  private int f;
  private final Lazy g = LazyKt.lazy((Function0)new WeatherArkViewWrapper.topPadding.2(this));
  private boolean h;
  private float i;
  private float j;
  private long k;
  private byte l;
  private final Lazy m = LazyKt.lazy((Function0)new WeatherArkViewWrapper.scaledTouchSlop.2(this));
  private boolean n;
  private ArkViewImplement.LoadCallback o;
  private boolean p;
  
  static
  {
    QRouteApi localQRouteApi = QRoute.api(IArkEnvironment.class);
    Intrinsics.checkExpressionValueIsNotNull(localQRouteApi, "QRoute.api(IArkEnvironment::class.java)");
    ((IArkEnvironment)localQRouteApi).initMultiProcEnv((IArkEnvDelegate)QRoute.api(IArkEnvDelegate.class));
  }
  
  public WeatherArkViewWrapper(@NotNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WeatherArkViewWrapper(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WeatherArkViewWrapper(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.b = new ArkView(paramContext, null);
    paramContext = getResources();
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "resources");
    paramContext = new ArkAppInfo.Size(paramContext.getDisplayMetrics().widthPixels, -1);
    setArkFixScaleDensity();
    this.b.setSize(paramContext, paramContext, paramContext);
    this.b.setBorderType(0);
    addView((View)this.b);
    setArkHeight(Utils.a(310, getResources()));
  }
  
  private final void a(float paramFloat1, float paramFloat2)
  {
    paramFloat1 = Math.abs(paramFloat1 - this.i);
    paramFloat2 = Math.abs(paramFloat2 - this.j);
    if ((paramFloat1 > getScaledTouchSlop()) || (paramFloat2 > getScaledTouchSlop()))
    {
      byte b1;
      if (paramFloat2 > paramFloat1) {
        b1 = 2;
      } else {
        b1 = 1;
      }
      this.l = b1;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("swipeDirectionJudge: absDx -> ");
      localStringBuilder.append(paramFloat1);
      localStringBuilder.append(", absDy -> ");
      localStringBuilder.append(paramFloat2);
      localStringBuilder.append(", mSlideStartDir -> ");
      localStringBuilder.append(this.l);
      QLog.d("WeatherWebArkWrapper", 2, localStringBuilder.toString());
    }
  }
  
  private final void a(boolean paramBoolean)
  {
    if (!this.n)
    {
      this.n = true;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("dispatchMissingDownEvent isForArk: ");
        ((StringBuilder)localObject).append(paramBoolean);
        QLog.d("WeatherWebArkWrapper", 2, ((StringBuilder)localObject).toString());
      }
      long l1 = this.k;
      Object localObject = MotionEvent.obtain(l1, l1, 0, this.i, this.j, 0);
      if (paramBoolean)
      {
        super.dispatchTouchEvent((MotionEvent)localObject);
      }
      else
      {
        MutableLiveData localMutableLiveData = this.c;
        if (localObject != null) {
          localMutableLiveData.setValue(localObject);
        }
      }
      ((MotionEvent)localObject).recycle();
    }
  }
  
  private final boolean a(float paramFloat)
  {
    int[] arrayOfInt = new int[2];
    getLocationOnScreen(arrayOfInt);
    float f1 = b(paramFloat);
    boolean bool1 = QLog.isColorLevel();
    boolean bool2 = false;
    if (bool1)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("touchInArk: locationX -> ");
      localStringBuilder.append(arrayOfInt[0]);
      localStringBuilder.append(", locationY -> ");
      localStringBuilder.append(arrayOfInt[1]);
      localStringBuilder.append(", scrollY => ");
      localStringBuilder.append(getScrollY());
      localStringBuilder.append(", eventY -> ");
      localStringBuilder.append(paramFloat);
      localStringBuilder.append(", arkHeight-> ");
      localStringBuilder.append(this.f);
      QLog.d("WeatherWebArkWrapper", 2, localStringBuilder.toString());
    }
    bool1 = bool2;
    if (f1 >= arrayOfInt[1])
    {
      bool1 = bool2;
      if (f1 <= arrayOfInt[1] + this.f) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private final float b(float paramFloat)
  {
    float f1 = getScrollY();
    int i1;
    if (this.f > 0) {
      i1 = getTopPadding();
    } else {
      i1 = 0;
    }
    return paramFloat + f1 - i1;
  }
  
  private final void b()
  {
    WeatherWebArkViewModel localWeatherWebArkViewModel = this.e;
    if (localWeatherWebArkViewModel != null) {
      localWeatherWebArkViewModel.a(1);
    }
    WeatherDCReportHelper.a().a(null, "new_ark_callup_success");
  }
  
  private final void c()
  {
    WeatherWebArkViewModel localWeatherWebArkViewModel = this.e;
    if (localWeatherWebArkViewModel != null) {
      localWeatherWebArkViewModel.a(0);
    }
  }
  
  private final void d()
  {
    Object localObject = this.e;
    if (localObject != null) {
      ((WeatherWebArkViewModel)localObject).a(-1);
    }
    setArkHeight(Utils.a(310, getResources()));
    View localView = findViewById(2131450059);
    if (localView == null)
    {
      localObject = e();
    }
    else
    {
      localObject = localView;
      if ((localView.getParent() instanceof ViewGroup))
      {
        localObject = localView.getParent();
        if (localObject != null)
        {
          ((ViewGroup)localObject).removeView(localView);
          localObject = localView;
        }
        else
        {
          throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
        }
      }
    }
    addView((View)localObject);
    WeatherDCReportHelper.a().a(null, "new_ark_callup_fail");
  }
  
  private final View e()
  {
    Object localObject = new FrameLayout.LayoutParams(-1, this.f);
    ((FrameLayout.LayoutParams)localObject).gravity = 1;
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setId(2131450059);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localLinearLayout.setBackgroundColor(-1);
    localObject = new ImageView(getContext());
    ((ImageView)localObject).setImageResource(2130839667);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    int i2 = Utils.a(170.0F, getResources()) - getTopPadding();
    int i1 = i2;
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      i1 = i2 + ImmersiveUtils.getStatusBarHeight(getContext());
    }
    localLayoutParams.topMargin = i1;
    localLayoutParams.gravity = 1;
    localLinearLayout.addView((View)localObject, (ViewGroup.LayoutParams)localLayoutParams);
    localObject = new TextView(getContext());
    ((TextView)localObject).setText(2131917993);
    ((TextView)localObject).setTextSize(1, 15.0F);
    ((TextView)localObject).setTextColor(-16777216);
    localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.topMargin = Utils.a(20.0F, getResources());
    localLayoutParams.gravity = 1;
    localLinearLayout.addView((View)localObject, (ViewGroup.LayoutParams)localLayoutParams);
    return (View)localLinearLayout;
  }
  
  private final int getScaledTouchSlop()
  {
    return ((Number)this.m.getValue()).intValue();
  }
  
  private final int getTopPadding()
  {
    return ((Number)this.g.getValue()).intValue();
  }
  
  public final void a(@NotNull WeatherWebArkViewModel paramWeatherWebArkViewModel)
  {
    Intrinsics.checkParameterIsNotNull(paramWeatherWebArkViewModel, "viewModel");
    this.e = paramWeatherWebArkViewModel;
  }
  
  public final void a(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "appName");
    Intrinsics.checkParameterIsNotNull(paramString2, "appView");
    Intrinsics.checkParameterIsNotNull(paramString3, "appVersion");
    Intrinsics.checkParameterIsNotNull(paramString4, "appMeta");
    Object localObject = QRoute.api(IArkTempApi.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "QRoute.api(IArkTempApi::class.java)");
    localObject = ((IArkTempApi)localObject).getCurrentAppConfig();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initArkView appName: ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", appView: ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", appVersion: ");
      localStringBuilder.append(paramString3);
      localStringBuilder.append(", appMeta: ");
      localStringBuilder.append(paramString4);
      localStringBuilder.append(", appConfig: ");
      localStringBuilder.append((String)localObject);
      QLog.d("WeatherWebArkWrapper", 2, localStringBuilder.toString());
    }
    this.o = ((ArkViewImplement.LoadCallback)new WeatherArkViewWrapper.initArkView.1(this));
    this.b.load(paramString1, paramString2, paramString3, paramString4, (String)localObject, this.o);
  }
  
  public final boolean a()
  {
    return this.p;
  }
  
  public boolean dispatchTouchEvent(@Nullable MotionEvent paramMotionEvent)
  {
    Object localObject;
    if (paramMotionEvent != null) {
      localObject = Integer.valueOf(paramMotionEvent.getAction());
    } else {
      localObject = null;
    }
    int i1 = 0;
    int i2 = 0;
    boolean bool = true;
    if ((localObject != null) && (((Integer)localObject).intValue() == 0))
    {
      this.h = a(paramMotionEvent.getY());
      this.d = false;
      this.n = false;
      this.i = paramMotionEvent.getX();
      this.j = paramMotionEvent.getY();
      this.k = SystemClock.uptimeMillis();
      i2 = i1;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onTouchEvent ACTION_DOWN  downInArk: ");
        ((StringBuilder)localObject).append(this.h);
        QLog.d("WeatherWebArkWrapper", 2, ((StringBuilder)localObject).toString());
        i2 = i1;
      }
    }
    else if ((localObject != null) && (((Integer)localObject).intValue() == 2))
    {
      if (this.l == 0) {
        a(paramMotionEvent.getX(), paramMotionEvent.getY());
      }
      if (this.l == 0) {
        return true;
      }
      this.d = true;
      getParent().requestDisallowInterceptTouchEvent(true);
      if ((this.h) && (this.l == 1))
      {
        a(true);
        i1 = 1;
      }
      else
      {
        a(false);
        localObject = this.c;
        i1 = i2;
        if (paramMotionEvent != null)
        {
          ((MutableLiveData)localObject).setValue(paramMotionEvent);
          i1 = i2;
        }
      }
      i2 = i1;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onTouchEvent ACTION_MOVE mSlideStartDir: ");
        ((StringBuilder)localObject).append(this.l);
        ((StringBuilder)localObject).append(", downInArk: ");
        ((StringBuilder)localObject).append(this.h);
        QLog.d("WeatherWebArkWrapper", 2, ((StringBuilder)localObject).toString());
        i2 = i1;
      }
    }
    else if ((localObject == null) || (((Integer)localObject).intValue() != 1))
    {
      if (localObject == null)
      {
        i2 = i1;
      }
      else
      {
        i2 = i1;
        if (((Integer)localObject).intValue() != 3) {}
      }
    }
    else
    {
      if ((this.h) && ((!this.d) || (this.l == 1)))
      {
        a(true);
        i1 = 1;
      }
      else
      {
        a(false);
        localObject = this.c;
        if (paramMotionEvent != null) {
          ((MutableLiveData)localObject).setValue(paramMotionEvent);
        }
        i1 = 0;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onTouchEvent ACTION_UP mSlideStartDir: ");
        ((StringBuilder)localObject).append(this.l);
        ((StringBuilder)localObject).append(", downInArk: ");
        ((StringBuilder)localObject).append(this.h);
        ((StringBuilder)localObject).append(", hasMove:");
        ((StringBuilder)localObject).append(this.d);
        QLog.d("WeatherWebArkWrapper", 2, ((StringBuilder)localObject).toString());
      }
      this.i = 0.0F;
      this.j = 0.0F;
      this.k = 0L;
      this.l = 0;
      this.h = false;
      this.n = false;
      i2 = i1;
    }
    if (i2 != 0) {
      bool = super.dispatchTouchEvent(paramMotionEvent);
    }
    return bool;
  }
  
  public final int getArkHeight()
  {
    return this.f;
  }
  
  @NotNull
  public final ArkView getArkView()
  {
    return this.b;
  }
  
  @NotNull
  public final MutableLiveData<MotionEvent> getTouchEventData()
  {
    return this.c;
  }
  
  public final void setArkFixScaleDensity()
  {
    float f1 = FontSettingManager.systemMetrics.density;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setArkFixScaleDensity system: ");
    localStringBuilder.append(f1);
    QLog.i("WeatherWebArkWrapper", 1, localStringBuilder.toString());
    if (f1 > 0) {
      this.b.setScaleDensity(f1);
    }
  }
  
  public final void setArkHeight(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("arkHeight set value : ");
      localStringBuilder.append(paramInt);
      QLog.d("WeatherWebArkWrapper", 2, localStringBuilder.toString());
    }
    int i1;
    if (paramInt > 0) {
      i1 = getTopPadding();
    } else {
      i1 = 0;
    }
    setPadding(0, i1, 0, 0);
    this.f = paramInt;
  }
  
  public final void setArkLoaded(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weather.webpage.WeatherArkViewWrapper
 * JD-Core Version:    0.7.0.1
 */
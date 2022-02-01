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
  public static final WeatherArkViewWrapper.Companion a;
  private byte jdField_a_of_type_Byte;
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  @NotNull
  private final MutableLiveData<MotionEvent> jdField_a_of_type_AndroidxLifecycleMutableLiveData = new MutableLiveData();
  private ArkViewImplement.LoadCallback jdField_a_of_type_ComTencentArkArkViewImplement$LoadCallback;
  @NotNull
  private final ArkView jdField_a_of_type_ComTencentArkOpenArkView;
  private WeatherWebArkViewModel jdField_a_of_type_ComTencentMobileqqWeatherWebpageWeatherWebArkViewModel;
  private final Lazy jdField_a_of_type_KotlinLazy = LazyKt.lazy((Function0)new WeatherArkViewWrapper.topPadding.2(this));
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private final Lazy jdField_b_of_type_KotlinLazy = LazyKt.lazy((Function0)new WeatherArkViewWrapper.scaledTouchSlop.2(this));
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqWeatherWebpageWeatherArkViewWrapper$Companion = new WeatherArkViewWrapper.Companion(null);
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
    this.jdField_a_of_type_ComTencentArkOpenArkView = new ArkView(paramContext, null);
    paramContext = getResources();
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "resources");
    paramContext = new ArkAppInfo.Size(paramContext.getDisplayMetrics().widthPixels, -1);
    setArkFixScaleDensity();
    this.jdField_a_of_type_ComTencentArkOpenArkView.setSize(paramContext, paramContext, paramContext);
    this.jdField_a_of_type_ComTencentArkOpenArkView.setBorderType(0);
    addView((View)this.jdField_a_of_type_ComTencentArkOpenArkView);
    setArkHeight(Utils.a(310, getResources()));
  }
  
  private final float a(float paramFloat)
  {
    float f = getScrollY();
    int i;
    if (this.jdField_a_of_type_Int > 0) {
      i = a();
    } else {
      i = 0;
    }
    return paramFloat + f - i;
  }
  
  private final int a()
  {
    return ((Number)this.jdField_a_of_type_KotlinLazy.getValue()).intValue();
  }
  
  private final View a()
  {
    Object localObject = new FrameLayout.LayoutParams(-1, this.jdField_a_of_type_Int);
    ((FrameLayout.LayoutParams)localObject).gravity = 1;
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setId(2131381049);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localLinearLayout.setBackgroundColor(-1);
    localObject = new ImageView(getContext());
    ((ImageView)localObject).setImageResource(2130839477);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    int j = Utils.a(170.0F, getResources()) - a();
    int i = j;
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      i = j + ImmersiveUtils.getStatusBarHeight(getContext());
    }
    localLayoutParams.topMargin = i;
    localLayoutParams.gravity = 1;
    localLinearLayout.addView((View)localObject, (ViewGroup.LayoutParams)localLayoutParams);
    localObject = new TextView(getContext());
    ((TextView)localObject).setText(2131720356);
    ((TextView)localObject).setTextSize(1, 15.0F);
    ((TextView)localObject).setTextColor(-16777216);
    localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.topMargin = Utils.a(20.0F, getResources());
    localLayoutParams.gravity = 1;
    localLinearLayout.addView((View)localObject, (ViewGroup.LayoutParams)localLayoutParams);
    return (View)localLinearLayout;
  }
  
  private final void a()
  {
    WeatherWebArkViewModel localWeatherWebArkViewModel = this.jdField_a_of_type_ComTencentMobileqqWeatherWebpageWeatherWebArkViewModel;
    if (localWeatherWebArkViewModel != null) {
      localWeatherWebArkViewModel.a(1);
    }
    WeatherDCReportHelper.a().a(null, "new_ark_callup_success");
  }
  
  private final void a(float paramFloat1, float paramFloat2)
  {
    paramFloat1 = Math.abs(paramFloat1 - this.jdField_a_of_type_Float);
    paramFloat2 = Math.abs(paramFloat2 - this.jdField_b_of_type_Float);
    if ((paramFloat1 > b()) || (paramFloat2 > b()))
    {
      byte b1;
      if (paramFloat2 > paramFloat1) {
        b1 = 2;
      } else {
        b1 = 1;
      }
      this.jdField_a_of_type_Byte = b1;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("swipeDirectionJudge: absDx -> ");
      localStringBuilder.append(paramFloat1);
      localStringBuilder.append(", absDy -> ");
      localStringBuilder.append(paramFloat2);
      localStringBuilder.append(", mSlideStartDir -> ");
      localStringBuilder.append(this.jdField_a_of_type_Byte);
      QLog.d("WeatherWebArkWrapper", 2, localStringBuilder.toString());
    }
  }
  
  private final void a(boolean paramBoolean)
  {
    if (!this.c)
    {
      this.c = true;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("dispatchMissingDownEvent isForArk: ");
        ((StringBuilder)localObject).append(paramBoolean);
        QLog.d("WeatherWebArkWrapper", 2, ((StringBuilder)localObject).toString());
      }
      long l = this.jdField_a_of_type_Long;
      Object localObject = MotionEvent.obtain(l, l, 0, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, 0);
      if (paramBoolean)
      {
        super.dispatchTouchEvent((MotionEvent)localObject);
      }
      else
      {
        MutableLiveData localMutableLiveData = this.jdField_a_of_type_AndroidxLifecycleMutableLiveData;
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
    float f = a(paramFloat);
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
      localStringBuilder.append(this.jdField_a_of_type_Int);
      QLog.d("WeatherWebArkWrapper", 2, localStringBuilder.toString());
    }
    bool1 = bool2;
    if (f >= arrayOfInt[1])
    {
      bool1 = bool2;
      if (f <= arrayOfInt[1] + this.jdField_a_of_type_Int) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private final int b()
  {
    return ((Number)this.jdField_b_of_type_KotlinLazy.getValue()).intValue();
  }
  
  private final void b()
  {
    WeatherWebArkViewModel localWeatherWebArkViewModel = this.jdField_a_of_type_ComTencentMobileqqWeatherWebpageWeatherWebArkViewModel;
    if (localWeatherWebArkViewModel != null) {
      localWeatherWebArkViewModel.a(0);
    }
  }
  
  private final void c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWeatherWebpageWeatherWebArkViewModel;
    if (localObject != null) {
      ((WeatherWebArkViewModel)localObject).a(-1);
    }
    setArkHeight(Utils.a(310, getResources()));
    View localView = findViewById(2131381049);
    if (localView == null)
    {
      localObject = a();
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
  
  @NotNull
  public final MutableLiveData<MotionEvent> a()
  {
    return this.jdField_a_of_type_AndroidxLifecycleMutableLiveData;
  }
  
  @NotNull
  public final ArkView a()
  {
    return this.jdField_a_of_type_ComTencentArkOpenArkView;
  }
  
  public final void a(@NotNull WeatherWebArkViewModel paramWeatherWebArkViewModel)
  {
    Intrinsics.checkParameterIsNotNull(paramWeatherWebArkViewModel, "viewModel");
    this.jdField_a_of_type_ComTencentMobileqqWeatherWebpageWeatherWebArkViewModel = paramWeatherWebArkViewModel;
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
    this.jdField_a_of_type_ComTencentArkArkViewImplement$LoadCallback = ((ArkViewImplement.LoadCallback)new WeatherArkViewWrapper.initArkView.1(this));
    this.jdField_a_of_type_ComTencentArkOpenArkView.load(paramString1, paramString2, paramString3, paramString4, (String)localObject, this.jdField_a_of_type_ComTencentArkArkViewImplement$LoadCallback);
  }
  
  public final boolean a()
  {
    return this.d;
  }
  
  public boolean dispatchTouchEvent(@Nullable MotionEvent paramMotionEvent)
  {
    Object localObject;
    if (paramMotionEvent != null) {
      localObject = Integer.valueOf(paramMotionEvent.getAction());
    } else {
      localObject = null;
    }
    int i = 0;
    int j = 0;
    boolean bool = true;
    if ((localObject != null) && (((Integer)localObject).intValue() == 0))
    {
      this.jdField_b_of_type_Boolean = a(paramMotionEvent.getY());
      this.jdField_a_of_type_Boolean = false;
      this.c = false;
      this.jdField_a_of_type_Float = paramMotionEvent.getX();
      this.jdField_b_of_type_Float = paramMotionEvent.getY();
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      j = i;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onTouchEvent ACTION_DOWN  downInArk: ");
        ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
        QLog.d("WeatherWebArkWrapper", 2, ((StringBuilder)localObject).toString());
        j = i;
      }
    }
    else if ((localObject != null) && (((Integer)localObject).intValue() == 2))
    {
      if (this.jdField_a_of_type_Byte == 0) {
        a(paramMotionEvent.getX(), paramMotionEvent.getY());
      }
      if (this.jdField_a_of_type_Byte == 0) {
        return true;
      }
      this.jdField_a_of_type_Boolean = true;
      getParent().requestDisallowInterceptTouchEvent(true);
      if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Byte == 1))
      {
        a(true);
        i = 1;
      }
      else
      {
        a(false);
        localObject = this.jdField_a_of_type_AndroidxLifecycleMutableLiveData;
        i = j;
        if (paramMotionEvent != null)
        {
          ((MutableLiveData)localObject).setValue(paramMotionEvent);
          i = j;
        }
      }
      j = i;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onTouchEvent ACTION_MOVE mSlideStartDir: ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Byte);
        ((StringBuilder)localObject).append(", downInArk: ");
        ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
        QLog.d("WeatherWebArkWrapper", 2, ((StringBuilder)localObject).toString());
        j = i;
      }
    }
    else if ((localObject == null) || (((Integer)localObject).intValue() != 1))
    {
      if (localObject == null)
      {
        j = i;
      }
      else
      {
        j = i;
        if (((Integer)localObject).intValue() != 3) {}
      }
    }
    else
    {
      if ((this.jdField_b_of_type_Boolean) && ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Byte == 1)))
      {
        a(true);
        i = 1;
      }
      else
      {
        a(false);
        localObject = this.jdField_a_of_type_AndroidxLifecycleMutableLiveData;
        if (paramMotionEvent != null) {
          ((MutableLiveData)localObject).setValue(paramMotionEvent);
        }
        i = 0;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onTouchEvent ACTION_UP mSlideStartDir: ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Byte);
        ((StringBuilder)localObject).append(", downInArk: ");
        ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
        ((StringBuilder)localObject).append(", hasMove:");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
        QLog.d("WeatherWebArkWrapper", 2, ((StringBuilder)localObject).toString());
      }
      this.jdField_a_of_type_Float = 0.0F;
      this.jdField_b_of_type_Float = 0.0F;
      this.jdField_a_of_type_Long = 0L;
      this.jdField_a_of_type_Byte = 0;
      this.jdField_b_of_type_Boolean = false;
      this.c = false;
      j = i;
    }
    if (j != 0) {
      bool = super.dispatchTouchEvent(paramMotionEvent);
    }
    return bool;
  }
  
  public final void setArkFixScaleDensity()
  {
    float f = FontSettingManager.systemMetrics.density;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setArkFixScaleDensity system: ");
    localStringBuilder.append(f);
    QLog.i("WeatherWebArkWrapper", 1, localStringBuilder.toString());
    if (f > 0) {
      this.jdField_a_of_type_ComTencentArkOpenArkView.setScaleDensity(f);
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
    int i;
    if (paramInt > 0) {
      i = a();
    } else {
      i = 0;
    }
    setPadding(0, i, 0, 0);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public final void setArkLoaded(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.weather.webpage.WeatherArkViewWrapper
 * JD-Core Version:    0.7.0.1
 */
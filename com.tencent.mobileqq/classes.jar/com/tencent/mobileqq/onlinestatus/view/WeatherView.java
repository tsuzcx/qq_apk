package com.tencent.mobileqq.onlinestatus.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.OnlineAutoStatusBean;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.onlinestatus.OnLineStatusBlurBg;
import com.tencent.mobileqq.onlinestatus.OnLineStatusBlurBg.BlurBgItem;
import com.tencent.mobileqq.onlinestatus.OnLineStatusBlurBg.OnLineStatusBlurBgListener;
import com.tencent.mobileqq.onlinestatus.OnlineStatusFriendsPermissionItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker.OnlineStatusPermissionItem;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.config.WeatherUrl;
import com.tencent.mobileqq.onlinestatus.constellation.ConstellationUtilKt;
import com.tencent.mobileqq.onlinestatus.manager.IOnlineStatusDataManager;
import com.tencent.mobileqq.onlinestatus.manager.IOnlineStatusPermissionManager;
import com.tencent.mobileqq.onlinestatus.manager.OnlineStatusDataManager;
import com.tencent.mobileqq.onlinestatus.manager.OnlineStatusPermissionManager;
import com.tencent.mobileqq.onlinestatus.manager.OnlineStatusPermissionManager.ReceiveDataListener;
import com.tencent.mobileqq.onlinestatus.utils.URLDrawableHelper;
import com.tencent.mobileqq.onlinestatus.weather.WeatherObserver;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeImageWrapper;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import mqq.app.AppRuntime;
import mqq.observer.BusinessObserver;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/onlinestatus/view/WeatherView;", "Lcom/tencent/mobileqq/onlinestatus/view/BaseStatusCardView;", "Lcom/tencent/mobileqq/onlinestatus/OnLineStatusBlurBg$OnLineStatusBlurBgListener;", "Lcom/tencent/mobileqq/onlinestatus/manager/OnlineStatusPermissionManager$ReceiveDataListener;", "activity", "Lcom/tencent/mobileqq/app/QBaseActivity;", "onLineStatusBlurBg", "Lcom/tencent/mobileqq/onlinestatus/OnLineStatusBlurBg;", "dismissCallback", "Lcom/tencent/mobileqq/onlinestatus/view/BaseStatusCardView$OnDismissCallback;", "(Lcom/tencent/mobileqq/app/QBaseActivity;Lcom/tencent/mobileqq/onlinestatus/OnLineStatusBlurBg;Lcom/tencent/mobileqq/onlinestatus/view/BaseStatusCardView$OnDismissCallback;)V", "TRANSPARENT", "Landroid/graphics/drawable/Drawable;", "getTRANSPARENT", "()Landroid/graphics/drawable/Drawable;", "getActivity", "()Lcom/tencent/mobileqq/app/QBaseActivity;", "setActivity", "(Lcom/tencent/mobileqq/app/QBaseActivity;)V", "app", "Lmqq/app/AppRuntime;", "appContext", "Lcom/tencent/qphone/base/util/BaseApplication;", "kotlin.jvm.PlatformType", "getAppContext", "()Lcom/tencent/qphone/base/util/BaseApplication;", "setAppContext", "(Lcom/tencent/qphone/base/util/BaseApplication;)V", "contentView", "Landroid/view/View;", "cornerBg", "", "getCornerBg", "()F", "setCornerBg", "(F)V", "defaultWeatherDrawable", "heightBg", "", "getHeightBg", "()I", "setHeightBg", "(I)V", "needSwitchOnlineStatus", "", "nightThemeBg", "getOnLineStatusBlurBg", "()Lcom/tencent/mobileqq/onlinestatus/OnLineStatusBlurBg;", "setOnLineStatusBlurBg", "(Lcom/tencent/mobileqq/onlinestatus/OnLineStatusBlurBg;)V", "permissionItem", "Lcom/tencent/mobileqq/onlinestatus/OnlineStatusPermissionChecker$OnlineStatusPermissionItem;", "viewAddress", "Landroid/widget/TextView;", "viewChangeFriends", "viewDate", "viewMainTitle", "viewSelectFriends", "viewSelectStatus", "Landroid/widget/Button;", "getViewSelectStatus", "()Landroid/widget/Button;", "setViewSelectStatus", "(Landroid/widget/Button;)V", "viewSubTitle", "viewTemperature", "viewWeatherBg", "Landroid/widget/ImageView;", "viewWeatherHint", "viewWeatherIcon", "viewWeatherName", "weatherObserver", "Lcom/tencent/mobileqq/onlinestatus/weather/WeatherObserver;", "weatherRootView", "widthBg", "getWidthBg", "setWidthBg", "beforeDismiss", "", "bindTextView", "hasPartPermission", "bindView", "blurBackground", "blurBgResult", "isSuccess", "bitmap", "Landroid/graphics/Bitmap;", "color", "createView", "initCardRect", "cardRect", "", "initData", "onActivityResult", "requestCode", "responseCode", "data", "Landroid/content/Intent;", "onBackPressed", "onDataReceived", "item", "Lcom/tencent/mobileqq/onlinestatus/OnlineStatusFriendsPermissionItem;", "smartSelectedList", "", "setImageDrawable", "url", "", "view", "corner", "outWidth", "outHeight", "drawable", "show", "showCard", "specialDate", "time", "", "updateButtonAndSpan", "updateButtonText", "change", "qqonlinestatus-impl_release"}, k=1, mv={1, 1, 16})
public final class WeatherView
  extends BaseStatusCardView
  implements OnLineStatusBlurBg.OnLineStatusBlurBgListener, OnlineStatusPermissionManager.ReceiveDataListener
{
  private int jdField_a_of_type_Int;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  @Nullable
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  @NotNull
  private QBaseActivity jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
  @NotNull
  private OnLineStatusBlurBg jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusBlurBg;
  private OnlineStatusPermissionChecker.OnlineStatusPermissionItem jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem;
  private WeatherObserver jdField_a_of_type_ComTencentMobileqqOnlinestatusWeatherWeatherObserver;
  private BaseApplication jdField_a_of_type_ComTencentQphoneBaseUtilBaseApplication;
  private final AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  @NotNull
  private final Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private float jdField_c_of_type_Float;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private final View jdField_d_of_type_AndroidViewView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private final View jdField_e_of_type_AndroidViewView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private TextView f;
  private TextView g;
  private TextView h;
  private TextView i;
  
  public WeatherView(@NotNull QBaseActivity paramQBaseActivity, @NotNull OnLineStatusBlurBg paramOnLineStatusBlurBg, @NotNull BaseStatusCardView.OnDismissCallback paramOnDismissCallback)
  {
    super((Context)paramQBaseActivity, paramOnDismissCallback);
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = paramQBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusBlurBg = paramOnLineStatusBlurBg;
    paramQBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime();
    Intrinsics.checkExpressionValueIsNotNull(paramQBaseActivity, "activity.appRuntime");
    this.jdField_a_of_type_MqqAppAppRuntime = paramQBaseActivity;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentQphoneBaseUtilBaseApplication = BaseApplication.context;
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = ((Drawable)new ColorDrawable(0));
    this.jdField_d_of_type_AndroidViewView = a();
    this.jdField_d_of_type_AndroidViewView.setOnClickListener((View.OnClickListener)new WeatherView.1(this));
    paramQBaseActivity = this.jdField_d_of_type_AndroidViewView.findViewById(2131381053);
    Intrinsics.checkExpressionValueIsNotNull(paramQBaseActivity, "contentView.findViewById(R.id.weather_root)");
    this.jdField_e_of_type_AndroidViewView = paramQBaseActivity;
    this.jdField_e_of_type_AndroidViewView.setOnClickListener((View.OnClickListener)WeatherView.2.a);
    this.jdField_a_of_type_AndroidViewView = this.jdField_d_of_type_AndroidViewView;
    this.jdField_b_of_type_AndroidViewView = this.jdField_e_of_type_AndroidViewView;
    b();
    setContentView(this.jdField_d_of_type_AndroidViewView);
    paramQBaseActivity = this.jdField_a_of_type_ComTencentQphoneBaseUtilBaseApplication;
    Intrinsics.checkExpressionValueIsNotNull(paramQBaseActivity, "appContext");
    paramQBaseActivity = paramQBaseActivity.getResources();
    Intrinsics.checkExpressionValueIsNotNull(paramQBaseActivity, "appContext.resources");
    int j = paramQBaseActivity.getDisplayMetrics().widthPixels;
    paramQBaseActivity = this.jdField_a_of_type_ComTencentQphoneBaseUtilBaseApplication;
    Intrinsics.checkExpressionValueIsNotNull(paramQBaseActivity, "appContext");
    this.jdField_a_of_type_Int = (j - Utils.a(80.0F, paramQBaseActivity.getResources()));
    paramQBaseActivity = this.jdField_a_of_type_ComTencentQphoneBaseUtilBaseApplication;
    Intrinsics.checkExpressionValueIsNotNull(paramQBaseActivity, "appContext");
    this.jdField_b_of_type_Int = Utils.a(211.0F, paramQBaseActivity.getResources());
    this.jdField_c_of_type_Float = (12 * DeviceInfoUtil.a());
    paramQBaseActivity = this.jdField_a_of_type_ComTencentQphoneBaseUtilBaseApplication;
    Intrinsics.checkExpressionValueIsNotNull(paramQBaseActivity, "appContext");
    paramQBaseActivity = BitmapManager.a(paramQBaseActivity.getResources(), 2130841533, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    if (paramQBaseActivity != null)
    {
      paramQBaseActivity = BaseImageUtil.d(paramQBaseActivity, this.jdField_c_of_type_Float, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      paramOnLineStatusBlurBg = this.jdField_a_of_type_ComTencentQphoneBaseUtilBaseApplication;
      Intrinsics.checkExpressionValueIsNotNull(paramOnLineStatusBlurBg, "appContext");
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((Drawable)new BitmapDrawable(paramOnLineStatusBlurBg.getResources(), paramQBaseActivity));
    }
  }
  
  private final void a(String paramString, ImageView paramImageView, int paramInt1, int paramInt2, int paramInt3, Drawable paramDrawable)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = paramDrawable;
    localURLDrawableOptions.mFailedDrawable = paramDrawable;
    localURLDrawableOptions.mRequestWidth = paramInt2;
    localURLDrawableOptions.mRequestHeight = paramInt3;
    paramDrawable = (CharSequence)paramString;
    if ((paramDrawable != null) && (paramDrawable.length() != 0)) {
      paramInt2 = 0;
    } else {
      paramInt2 = 1;
    }
    if (paramInt2 != 0)
    {
      if (paramImageView != null) {
        paramImageView.setImageDrawable(localURLDrawableOptions.mFailedDrawable);
      }
      return;
    }
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    if (paramInt1 > 0)
    {
      Intrinsics.checkExpressionValueIsNotNull(paramString, "drawable");
      paramString.setTag(URLDrawableHelper.a(localURLDrawableOptions.mRequestWidth, localURLDrawableOptions.mRequestHeight, paramInt1));
      paramString.setDecodeHandler(URLDrawableHelper.a);
    }
    if (paramImageView != null) {
      paramImageView.setImageDrawable((Drawable)paramString);
    }
  }
  
  private final void a(boolean paramBoolean)
  {
    Button localButton = this.jdField_a_of_type_AndroidWidgetButton;
    if (localButton != null)
    {
      Object localObject = this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IOnlineStatusService.class, "");
      Intrinsics.checkExpressionValueIsNotNull(localObject, "app.getRuntimeService(IO…va, ProcessConstant.MAIN)");
      if (((IOnlineStatusService)localObject).getExtOnlineStatus() == 1030)
      {
        int j;
        if (paramBoolean) {
          j = 2131691333;
        } else {
          j = 2131693121;
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("change: ");
          ((StringBuilder)localObject).append(paramBoolean);
          QLog.d("WeatherView", 2, new Object[] { "updateButtonText: called. ", ((StringBuilder)localObject).toString() });
        }
        this.jdField_a_of_type_Boolean = (paramBoolean ^ true);
        localButton.setText(this.jdField_a_of_type_MqqAppAppRuntime.getApp().getText(j));
        localButton.setEnabled(paramBoolean);
        return;
      }
      localButton.setText(this.jdField_a_of_type_MqqAppAppRuntime.getApp().getText(2131694929));
      localButton.setEnabled(true);
    }
  }
  
  private final void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusWeatherWeatherObserver = ((WeatherObserver)new WeatherView.initData.1(this));
  }
  
  private final void c()
  {
    Object localObject;
    if (QQTheme.a())
    {
      this.jdField_e_of_type_AndroidViewView.setBackgroundResource(2130846335);
      a(false, null, Color.parseColor("#FF010101"));
      localObject = this.jdField_c_of_type_AndroidViewView;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
    }
    else
    {
      this.jdField_e_of_type_AndroidViewView.setBackgroundResource(2130846334);
      localObject = new OnLineStatusBlurBg.BlurBgItem();
      QBaseActivity localQBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
      if (localQBaseActivity == null) {
        break label103;
      }
      ((OnLineStatusBlurBg.BlurBgItem)localObject).jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = localQBaseActivity;
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusBlurBg.a((OnLineStatusBlurBg.BlurBgItem)localObject, (OnLineStatusBlurBg.OnLineStatusBlurBgListener)this);
      localObject = this.jdField_c_of_type_AndroidViewView;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
    }
    return;
    label103:
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
  }
  
  private final void c(boolean paramBoolean)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentQphoneBaseUtilBaseApplication;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "appContext");
    Object localObject2 = ((BaseApplication)localObject1).getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "appContext.resources");
    localObject1 = ((Resources)localObject2).getString(2131691331);
    if (paramBoolean) {
      localObject1 = ((Resources)localObject2).getString(2131691337);
    }
    Ref.ObjectRef localObjectRef = new Ref.ObjectRef();
    localObjectRef.element = ((Resources)localObject2).getString(2131691336);
    localObject2 = this.f;
    if (localObject2 != null)
    {
      localObject1 = (CharSequence)localObject1;
      ((TextView)localObject2).setText((CharSequence)localObject1);
      ((TextView)localObject2).setContentDescription((CharSequence)localObject1);
    }
    localObject1 = this.g;
    if (localObject1 != null)
    {
      ((TextView)localObject1).setText((CharSequence)localObjectRef.element);
      ((TextView)localObject1).setClickable(true);
      ((TextView)localObject1).setOnClickListener((View.OnClickListener)new WeatherView.bindTextView..inlined.apply.lambda.1(this, localObjectRef, paramBoolean));
      ((TextView)localObject1).setOnTouchListener((View.OnTouchListener)new AutoStatusSelectView.MyViewAlphaOnTouchListener());
      if (ThemeImageWrapper.isNightMode())
      {
        ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130837596, 0);
        return;
      }
      ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130837595, 0);
    }
  }
  
  private final void g()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem;
    boolean bool2 = false;
    boolean bool1;
    if (localObject != null)
    {
      bool2 = ((OnlineStatusPermissionChecker.OnlineStatusPermissionItem)localObject).isAllHasPermission() ^ true;
      localObject = this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IOnlineStatusManagerService.class, "");
      Intrinsics.checkExpressionValueIsNotNull(localObject, "app.getRuntimeService(IO…va, ProcessConstant.MAIN)");
      localObject = ((IOnlineStatusManagerService)localObject).getManager(IOnlineStatusPermissionManager.class);
      if (localObject != null) {
        bool1 = ((OnlineStatusPermissionManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem, (OnlineStatusPermissionManager.ReceiveDataListener)this);
      } else {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.onlinestatus.manager.OnlineStatusPermissionManager");
      }
    }
    else
    {
      bool1 = false;
    }
    c(bool2);
    a(bool1);
  }
  
  @NotNull
  public final View a()
  {
    View localView = View.inflate((Context)BaseApplication.context, 2131561501, null);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131381051));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131370632));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378377));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131381052));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131377160));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131381050));
    this.f = ((TextView)localView.findViewById(2131377146));
    this.g = ((TextView)localView.findViewById(2131377139));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131362254));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131365401));
    this.jdField_c_of_type_AndroidViewView = localView.findViewById(2131371889);
    this.h = ((TextView)localView.findViewById(2131370648));
    this.i = ((TextView)localView.findViewById(2131378039));
    Intrinsics.checkExpressionValueIsNotNull(localView, "view");
    return localView;
  }
  
  @NotNull
  public final QBaseActivity a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
  }
  
  @NotNull
  public final String a(long paramLong)
  {
    Object localObject = new Date(paramLong);
    localObject = ConstellationUtilKt.a().format((Date)localObject);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "defaultDateFormat.format(date)");
    return localObject;
  }
  
  @SuppressLint({"SetTextI18n"})
  public final void a()
  {
    Object localObject1 = this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IFriendDataService.class, "");
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "app.getRuntimeService(IF…va, ProcessConstant.MAIN)");
    Friends localFriends = ((IFriendDataService)localObject1).getFriend(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentUin(), true, true, true);
    Object localObject2 = this.jdField_c_of_type_AndroidWidgetTextView;
    if (localObject2 != null)
    {
      localObject1 = localFriends.weatherTip;
      if (localObject1 != null) {
        localObject1 = (CharSequence)localObject1;
      } else {
        localObject1 = (CharSequence)"";
      }
      ((TextView)localObject2).setText((CharSequence)localObject1);
    }
    localObject2 = this.jdField_b_of_type_AndroidWidgetTextView;
    if (localObject2 != null)
    {
      localObject1 = localFriends.weatherType;
      if (localObject1 != null) {
        localObject1 = (CharSequence)localObject1;
      } else {
        localObject1 = (CharSequence)"";
      }
      ((TextView)localObject2).setText((CharSequence)localObject1);
    }
    localObject2 = this.jdField_d_of_type_AndroidWidgetTextView;
    if (localObject2 != null)
    {
      localStringBuilder = new StringBuilder();
      localObject1 = localFriends.city;
      if (localObject1 == null) {
        localObject1 = "";
      }
      localStringBuilder.append((String)localObject1);
      localObject1 = localFriends.area;
      if (localObject1 == null) {
        localObject1 = "";
      }
      localStringBuilder.append(localObject1);
      ((TextView)localObject2).setText((CharSequence)localStringBuilder.toString());
    }
    localObject2 = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject2 != null)
    {
      localObject1 = localFriends.temper;
      if (localObject1 != null) {
        localObject1 = (CharSequence)localObject1;
      } else {
        localObject1 = (CharSequence)"";
      }
      ((TextView)localObject2).setText((CharSequence)localObject1);
    }
    localObject1 = this.jdField_a_of_type_AndroidWidgetButton;
    if (localObject1 != null) {
      ((Button)localObject1).setOnClickListener((View.OnClickListener)new WeatherView.bindView.1(this));
    }
    this.jdField_a_of_type_Boolean = true;
    boolean bool2 = false;
    a(false);
    Object localObject3 = (OnlineAutoStatusBean)QConfigManager.a().a(652);
    localObject1 = this.jdField_a_of_type_ComTencentQphoneBaseUtilBaseApplication;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "appContext");
    int j = Utils.a(26.0F, ((BaseApplication)localObject1).getResources());
    StringBuilder localStringBuilder = null;
    if (localObject3 != null)
    {
      localObject1 = ((OnlineAutoStatusBean)localObject3).a(localFriends.weatherTypeId);
      if (localObject1 != null)
      {
        localObject1 = ((WeatherUrl)localObject1).b;
        break label394;
      }
    }
    localObject1 = null;
    label394:
    a((String)localObject1, this.jdField_a_of_type_AndroidWidgetImageView, 0, j, j, URLDrawableHelperConstants.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    localObject2 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = URLDrawableHelperConstants.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    }
    localObject2 = localStringBuilder;
    if (localObject3 != null)
    {
      localObject3 = ((OnlineAutoStatusBean)localObject3).a(localFriends.weatherTypeId);
      localObject2 = localStringBuilder;
      if (localObject3 != null) {
        localObject2 = ((WeatherUrl)localObject3).c;
      }
    }
    a((String)localObject2, this.jdField_b_of_type_AndroidWidgetImageView, (int)this.jdField_c_of_type_Float, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, (Drawable)localObject1);
    if (localFriends.weatherUpdateTime <= 0L)
    {
      localObject1 = this.jdField_e_of_type_AndroidWidgetTextView;
      if (localObject1 != null) {
        ((TextView)localObject1).setText((CharSequence)"");
      }
    }
    else
    {
      localObject1 = this.jdField_e_of_type_AndroidWidgetTextView;
      if (localObject1 != null) {
        ((TextView)localObject1).setText((CharSequence)a(localFriends.weatherUpdateTime * 1000));
      }
    }
    localObject1 = (CharSequence)localFriends.temper;
    if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
      j = 0;
    } else {
      j = 1;
    }
    if (j != 0)
    {
      localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localObject1 != null) {
        ((TextView)localObject1).setText((CharSequence)"");
      }
    }
    else
    {
      localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localObject1 != null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(localFriends.temper);
        ((StringBuilder)localObject2).append("°");
        ((TextView)localObject1).setText((CharSequence)((StringBuilder)localObject2).toString());
      }
    }
    localObject1 = this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IOnlineStatusManagerService.class, "");
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "app.getRuntimeService(IO…va, ProcessConstant.MAIN)");
    localObject1 = ((IOnlineStatusManagerService)localObject1).getManager(IOnlineStatusPermissionManager.class);
    if (localObject1 != null)
    {
      localObject1 = ((OnlineStatusPermissionManager)localObject1).a(40001, false, (OnlineStatusPermissionManager.ReceiveDataListener)this);
      boolean bool1 = bool2;
      if (localObject1 != null)
      {
        bool1 = bool2;
        if (!((OnlineStatusFriendsPermissionItem)localObject1).allHasPermission) {
          bool1 = true;
        }
      }
      c(bool1);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.onlinestatus.manager.OnlineStatusPermissionManager");
  }
  
  public void a(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    if ((paramInt1 == 1030) && (paramInt2 == -1) && (paramIntent != null) && (paramIntent.getSerializableExtra("online_status_permission_item") != null))
    {
      paramIntent = paramIntent.getSerializableExtra("online_status_permission_item");
      if (paramIntent != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem = ((OnlineStatusPermissionChecker.OnlineStatusPermissionItem)paramIntent);
        g();
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker.OnlineStatusPermissionItem");
    }
  }
  
  public void a(@NotNull OnlineStatusFriendsPermissionItem paramOnlineStatusFriendsPermissionItem, @NotNull List<Integer> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramOnlineStatusFriendsPermissionItem, "item");
    Intrinsics.checkParameterIsNotNull(paramList, "smartSelectedList");
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem = OnlineStatusPermissionChecker.OnlineStatusPermissionItem.create(40001, paramOnlineStatusFriendsPermissionItem.allHasPermission, paramOnlineStatusFriendsPermissionItem.permissionUins);
      g();
    }
  }
  
  public void a(boolean paramBoolean, @Nullable Bitmap paramBitmap, int paramInt)
  {
    if ((paramBoolean) && (paramBitmap != null))
    {
      View localView = this.jdField_d_of_type_AndroidViewView;
      if (localView != null)
      {
        localView.setBackgroundDrawable((Drawable)new BitmapDrawable(paramBitmap));
        return;
      }
    }
    paramBitmap = this.jdField_d_of_type_AndroidViewView;
    if (paramBitmap != null) {
      paramBitmap.setBackgroundColor(paramInt);
    }
  }
  
  protected void a(@Nullable int[] paramArrayOfInt)
  {
    if (paramArrayOfInt != null)
    {
      View localView = this.jdField_b_of_type_AndroidViewView;
      Intrinsics.checkExpressionValueIsNotNull(localView, "cardView");
      if (localView.getWidth() != 0)
      {
        localView = this.jdField_b_of_type_AndroidViewView;
        Intrinsics.checkExpressionValueIsNotNull(localView, "cardView");
        if (localView.getHeight() != 0)
        {
          localView = this.jdField_b_of_type_AndroidViewView;
          Intrinsics.checkExpressionValueIsNotNull(localView, "cardView");
          paramArrayOfInt[0] = localView.getWidth();
          localView = this.jdField_b_of_type_AndroidViewView;
          Intrinsics.checkExpressionValueIsNotNull(localView, "cardView");
          paramArrayOfInt[1] = localView.getHeight();
          return;
        }
      }
      paramArrayOfInt[0] = this.jdField_a_of_type_Int;
      localView = this.jdField_b_of_type_AndroidViewView;
      Intrinsics.checkExpressionValueIsNotNull(localView, "cardView");
      paramArrayOfInt[1] = Utils.a(430.0F, localView.getResources());
    }
  }
  
  public void aL_()
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.requestPermissions(new WeatherView.showCard.1(this), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
      return;
    }
    Object localObject = this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IOnlineStatusManagerService.class, "");
    Intrinsics.checkExpressionValueIsNotNull(localObject, "app.getRuntimeService(IO…va, ProcessConstant.MAIN)");
    localObject = ((IOnlineStatusManagerService)localObject).getManager(IOnlineStatusDataManager.class);
    if (localObject != null)
    {
      ((OnlineStatusDataManager)localObject).a(9);
      show();
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.onlinestatus.manager.OnlineStatusDataManager");
  }
  
  protected void f()
  {
    this.jdField_a_of_type_MqqAppAppRuntime.unRegistObserver((BusinessObserver)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusWeatherWeatherObserver);
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewBaseStatusCardView$OnDismissCallback.a(1030);
  }
  
  public void show()
  {
    this.jdField_a_of_type_MqqAppAppRuntime.registObserver((BusinessObserver)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusWeatherWeatherObserver);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem = ((OnlineStatusPermissionChecker.OnlineStatusPermissionItem)null);
    a();
    c();
    try
    {
      a(this.h);
      a(this.i);
      super.show();
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("WeatherView", 2, new Object[] { "show: called. ", "", localException });
      }
    }
    b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.WeatherView
 * JD-Core Version:    0.7.0.1
 */
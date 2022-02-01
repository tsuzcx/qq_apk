package com.tencent.mobileqq.onlinestatus.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.utils.UITools.MyViewAlphaOnTouchListener;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.OnlineAutoStatusBean;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.onlinestatus.OnLineStatusBlurBg;
import com.tencent.mobileqq.onlinestatus.OnLineStatusBlurBg.BlurBgItem;
import com.tencent.mobileqq.onlinestatus.OnLineStatusBlurBg.OnLineStatusBlurBgListener;
import com.tencent.mobileqq.onlinestatus.OnlineStatusFriendsPermissionItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusManager;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker.OnlineStatusPermissionItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionManager;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionManager.ReceiveDataListener;
import com.tencent.mobileqq.onlinestatus.config.WeatherUrl;
import com.tencent.mobileqq.onlinestatus.constellation.ConstellationUtilKt;
import com.tencent.mobileqq.onlinestatus.weather.WeatherObserver;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.ImageUtil;
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
import mqq.manager.Manager;
import mqq.observer.BusinessObserver;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/onlinestatus/view/WeatherView;", "Lcom/tencent/mobileqq/onlinestatus/view/BaseStatusCardView;", "Lcom/tencent/mobileqq/onlinestatus/OnLineStatusBlurBg$OnLineStatusBlurBgListener;", "Lcom/tencent/mobileqq/onlinestatus/OnlineStatusPermissionManager$ReceiveDataListener;", "activity", "Lcom/tencent/mobileqq/app/BaseActivity;", "onLineStatusBlurBg", "Lcom/tencent/mobileqq/onlinestatus/OnLineStatusBlurBg;", "dismissCallback", "Lcom/tencent/mobileqq/onlinestatus/view/BaseStatusCardView$OnDismissCallback;", "(Lcom/tencent/mobileqq/app/BaseActivity;Lcom/tencent/mobileqq/onlinestatus/OnLineStatusBlurBg;Lcom/tencent/mobileqq/onlinestatus/view/BaseStatusCardView$OnDismissCallback;)V", "getActivity", "()Lcom/tencent/mobileqq/app/BaseActivity;", "setActivity", "(Lcom/tencent/mobileqq/app/BaseActivity;)V", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "appContext", "Lcom/tencent/qphone/base/util/BaseApplication;", "kotlin.jvm.PlatformType", "getAppContext", "()Lcom/tencent/qphone/base/util/BaseApplication;", "setAppContext", "(Lcom/tencent/qphone/base/util/BaseApplication;)V", "contentView", "Landroid/view/View;", "cornerBg", "", "getCornerBg", "()F", "setCornerBg", "(F)V", "defaultWeatherDrawable", "Landroid/graphics/drawable/Drawable;", "heightBg", "", "getHeightBg", "()I", "setHeightBg", "(I)V", "needSwitchOnlineStatus", "", "nightThemeBg", "getOnLineStatusBlurBg", "()Lcom/tencent/mobileqq/onlinestatus/OnLineStatusBlurBg;", "setOnLineStatusBlurBg", "(Lcom/tencent/mobileqq/onlinestatus/OnLineStatusBlurBg;)V", "permissionItem", "Lcom/tencent/mobileqq/onlinestatus/OnlineStatusPermissionChecker$OnlineStatusPermissionItem;", "viewAddress", "Landroid/widget/TextView;", "viewChangeFriends", "viewDate", "viewMainTitle", "viewSelectFriends", "viewSelectStatus", "Landroid/widget/Button;", "getViewSelectStatus", "()Landroid/widget/Button;", "setViewSelectStatus", "(Landroid/widget/Button;)V", "viewSubTitle", "viewTemperature", "viewWeatherBg", "Landroid/widget/ImageView;", "viewWeatherHint", "viewWeatherIcon", "viewWeatherName", "weatherObserver", "Lcom/tencent/mobileqq/onlinestatus/weather/WeatherObserver;", "weatherRootView", "widthBg", "getWidthBg", "setWidthBg", "beforeDismiss", "", "bindTextView", "hasPartPermission", "bindView", "blurBackground", "blurBgResult", "isSuccess", "bitmap", "Landroid/graphics/Bitmap;", "color", "createView", "initCardRect", "cardRect", "", "initData", "onActivityResult", "requestCode", "responseCode", "data", "Landroid/content/Intent;", "onBackPressed", "onDataReceived", "item", "Lcom/tencent/mobileqq/onlinestatus/OnlineStatusFriendsPermissionItem;", "smartSelectedList", "", "setImageDrawable", "url", "", "view", "corner", "outWidth", "outHeight", "drawable", "show", "showCard", "specialDate", "time", "", "updateButtonAndSpan", "updateButtonText", "change", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
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
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  @NotNull
  private OnLineStatusBlurBg jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusBlurBg;
  private OnlineStatusPermissionChecker.OnlineStatusPermissionItem jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem;
  private WeatherObserver jdField_a_of_type_ComTencentMobileqqOnlinestatusWeatherWeatherObserver;
  private BaseApplication jdField_a_of_type_ComTencentQphoneBaseUtilBaseApplication;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
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
  
  public WeatherView(@NotNull BaseActivity paramBaseActivity, @NotNull OnLineStatusBlurBg paramOnLineStatusBlurBg, @NotNull BaseStatusCardView.OnDismissCallback paramOnDismissCallback)
  {
    super((Context)paramBaseActivity, paramOnDismissCallback);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusBlurBg = paramOnLineStatusBlurBg;
    paramBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;
    Intrinsics.checkExpressionValueIsNotNull(paramBaseActivity, "activity.app");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseActivity;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentQphoneBaseUtilBaseApplication = BaseApplication.context;
    this.jdField_d_of_type_AndroidViewView = a();
    this.jdField_d_of_type_AndroidViewView.setOnClickListener((View.OnClickListener)new WeatherView.1(this));
    paramBaseActivity = this.jdField_d_of_type_AndroidViewView.findViewById(2131381837);
    Intrinsics.checkExpressionValueIsNotNull(paramBaseActivity, "contentView.findViewById(R.id.weather_root)");
    this.jdField_e_of_type_AndroidViewView = paramBaseActivity;
    this.jdField_e_of_type_AndroidViewView.setOnClickListener((View.OnClickListener)WeatherView.2.a);
    this.jdField_a_of_type_AndroidViewView = this.jdField_d_of_type_AndroidViewView;
    this.jdField_b_of_type_AndroidViewView = this.jdField_e_of_type_AndroidViewView;
    b();
    setContentView(this.jdField_d_of_type_AndroidViewView);
    paramBaseActivity = this.jdField_a_of_type_ComTencentQphoneBaseUtilBaseApplication;
    Intrinsics.checkExpressionValueIsNotNull(paramBaseActivity, "appContext");
    paramBaseActivity = paramBaseActivity.getResources();
    Intrinsics.checkExpressionValueIsNotNull(paramBaseActivity, "appContext.resources");
    int j = paramBaseActivity.getDisplayMetrics().widthPixels;
    paramBaseActivity = this.jdField_a_of_type_ComTencentQphoneBaseUtilBaseApplication;
    Intrinsics.checkExpressionValueIsNotNull(paramBaseActivity, "appContext");
    this.jdField_a_of_type_Int = (j - AIOUtils.a(80.0F, paramBaseActivity.getResources()));
    paramBaseActivity = this.jdField_a_of_type_ComTencentQphoneBaseUtilBaseApplication;
    Intrinsics.checkExpressionValueIsNotNull(paramBaseActivity, "appContext");
    this.jdField_b_of_type_Int = AIOUtils.a(211.0F, paramBaseActivity.getResources());
    this.jdField_c_of_type_Float = (12 * DeviceInfoUtil.a());
    paramBaseActivity = this.jdField_a_of_type_ComTencentQphoneBaseUtilBaseApplication;
    Intrinsics.checkExpressionValueIsNotNull(paramBaseActivity, "appContext");
    paramBaseActivity = BitmapManager.a(paramBaseActivity.getResources(), 2130841648, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    if (paramBaseActivity != null)
    {
      paramBaseActivity = ImageUtil.d(paramBaseActivity, this.jdField_c_of_type_Float, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      paramOnLineStatusBlurBg = this.jdField_a_of_type_ComTencentQphoneBaseUtilBaseApplication;
      Intrinsics.checkExpressionValueIsNotNull(paramOnLineStatusBlurBg, "appContext");
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((Drawable)new BitmapDrawable(paramOnLineStatusBlurBg.getResources(), paramBaseActivity));
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
    if ((paramDrawable == null) || (paramDrawable.length() == 0))
    {
      paramInt2 = 1;
      if (paramInt2 == 0) {
        break label82;
      }
      if (paramImageView != null) {
        paramImageView.setImageDrawable(localURLDrawableOptions.mFailedDrawable);
      }
    }
    label82:
    do
    {
      return;
      paramInt2 = 0;
      break;
      paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
      if (paramInt1 > 0)
      {
        Intrinsics.checkExpressionValueIsNotNull(paramString, "drawable");
        paramString.setTag(URLDrawableDecodeHandler.b(localURLDrawableOptions.mRequestWidth, localURLDrawableOptions.mRequestHeight, paramInt1));
        paramString.setDecodeHandler(URLDrawableDecodeHandler.h);
      }
    } while (paramImageView == null);
    paramImageView.setImageDrawable((Drawable)paramString);
  }
  
  private final void a(boolean paramBoolean)
  {
    boolean bool = true;
    Button localButton = this.jdField_a_of_type_AndroidWidgetButton;
    int j;
    if (localButton != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getExtOnlineStatus() != 1030) {
        break label126;
      }
      if (!paramBoolean) {
        break label114;
      }
      j = 2131691411;
      if (QLog.isColorLevel()) {
        QLog.d("WeatherView", 2, new Object[] { "updateButtonText: called. ", "change: " + paramBoolean });
      }
      if (paramBoolean) {
        break label121;
      }
      label86:
      this.jdField_a_of_type_Boolean = bool;
      localButton.setText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getText(j));
      localButton.setEnabled(paramBoolean);
    }
    for (;;)
    {
      return;
      label114:
      j = 2131693161;
      break;
      label121:
      bool = false;
      break label86;
      label126:
      localButton.setText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getText(2131694939));
      localButton.setEnabled(true);
    }
  }
  
  private final void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusWeatherWeatherObserver = ((WeatherObserver)new WeatherView.initData.1(this));
  }
  
  private final void b(boolean paramBoolean)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentQphoneBaseUtilBaseApplication;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "appContext");
    Object localObject2 = ((BaseApplication)localObject1).getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "appContext.resources");
    localObject1 = ((Resources)localObject2).getString(2131691409);
    if (paramBoolean) {
      localObject1 = ((Resources)localObject2).getString(2131691415);
    }
    Ref.ObjectRef localObjectRef = new Ref.ObjectRef();
    localObjectRef.element = ((Resources)localObject2).getString(2131691414);
    localObject2 = this.f;
    if (localObject2 != null)
    {
      ((TextView)localObject2).setText((CharSequence)localObject1);
      ((TextView)localObject2).setContentDescription((CharSequence)localObject1);
    }
    localObject1 = this.g;
    if (localObject1 != null)
    {
      ((TextView)localObject1).setText((CharSequence)localObjectRef.element);
      ((TextView)localObject1).setClickable(true);
      ((TextView)localObject1).setOnClickListener((View.OnClickListener)new WeatherView.bindTextView..inlined.apply.lambda.1(this, localObjectRef, paramBoolean));
      ((TextView)localObject1).setOnTouchListener((View.OnTouchListener)new UITools.MyViewAlphaOnTouchListener());
      if (!ThemeImageWrapper.isNightMode()) {
        break label166;
      }
      ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130837509, 0);
    }
    for (;;)
    {
      return;
      label166:
      ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130837508, 0);
    }
  }
  
  private final void c()
  {
    Object localObject;
    if (ThemeUtil.isNowThemeIsNight(null, false, ""))
    {
      this.jdField_e_of_type_AndroidViewView.setBackgroundResource(2130846455);
      a(false, null, Color.parseColor("#FF010101"));
      localObject = this.jdField_c_of_type_AndroidViewView;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
    }
    do
    {
      return;
      this.jdField_e_of_type_AndroidViewView.setBackgroundResource(2130846454);
      localObject = new OnLineStatusBlurBg.BlurBgItem();
      BaseActivity localBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
      if (localBaseActivity == null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.BaseActivity");
      }
      ((OnLineStatusBlurBg.BlurBgItem)localObject).jdField_a_of_type_ComTencentMobileqqAppBaseActivity = localBaseActivity;
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusBlurBg.a((OnLineStatusBlurBg.BlurBgItem)localObject, (OnLineStatusBlurBg.OnLineStatusBlurBgListener)this);
      localObject = this.jdField_c_of_type_AndroidViewView;
    } while (localObject == null);
    ((View)localObject).setVisibility(8);
  }
  
  private final void g()
  {
    boolean bool1 = false;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem;
    boolean bool2;
    if (localObject != null)
    {
      if (!((OnlineStatusPermissionChecker.OnlineStatusPermissionItem)localObject).isAllHasPermission()) {}
      for (bool1 = true;; bool1 = false)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.ONLINE_STATUS_PERMISSION_MANAGER);
        if (localObject != null) {
          break;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionManager");
      }
      boolean bool3 = ((OnlineStatusPermissionManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem, (OnlineStatusPermissionManager.ReceiveDataListener)this);
      bool2 = bool1;
      bool1 = bool3;
    }
    for (;;)
    {
      b(bool2);
      a(bool1);
      return;
      bool2 = false;
    }
  }
  
  @NotNull
  public final View a()
  {
    View localView = View.inflate((Context)BaseApplication.context, 2131561650, null);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131381834));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131370998));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131379001));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131381836));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131377732));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131381833));
    this.f = ((TextView)localView.findViewById(2131377717));
    this.g = ((TextView)localView.findViewById(2131377711));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131362231));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131365558));
    this.jdField_c_of_type_AndroidViewView = localView.findViewById(2131372301);
    this.h = ((TextView)localView.findViewById(2131371014));
    this.i = ((TextView)localView.findViewById(2131378646));
    Intrinsics.checkExpressionValueIsNotNull(localView, "view");
    return localView;
  }
  
  @NotNull
  public final BaseActivity a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
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
    boolean bool2 = false;
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (localObject1 == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.FriendsManager");
    }
    Friends localFriends = ((FriendsManager)localObject1).d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    Object localObject2 = this.jdField_c_of_type_AndroidWidgetTextView;
    label114:
    int j;
    if (localObject2 != null)
    {
      localObject1 = localFriends.weatherTip;
      if (localObject1 != null)
      {
        localObject1 = (CharSequence)localObject1;
        ((TextView)localObject2).setText((CharSequence)localObject1);
      }
    }
    else
    {
      localObject2 = this.jdField_b_of_type_AndroidWidgetTextView;
      if (localObject2 != null)
      {
        localObject1 = localFriends.weatherType;
        if (localObject1 == null) {
          break label540;
        }
        localObject1 = (CharSequence)localObject1;
        ((TextView)localObject2).setText((CharSequence)localObject1);
      }
      localObject2 = this.jdField_d_of_type_AndroidWidgetTextView;
      if (localObject2 != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localObject1 = localFriends.city;
        if (localObject1 == null) {
          break label551;
        }
        label153:
        localStringBuilder = localStringBuilder.append((String)localObject1);
        localObject1 = localFriends.area;
        if (localObject1 == null) {
          break label559;
        }
        label174:
        ((TextView)localObject2).setText((CharSequence)localObject1);
      }
      localObject2 = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localObject2 != null)
      {
        localObject1 = localFriends.temper;
        if (localObject1 == null) {
          break label567;
        }
        localObject1 = (CharSequence)localObject1;
        label222:
        ((TextView)localObject2).setText((CharSequence)localObject1);
      }
      localObject1 = this.jdField_a_of_type_AndroidWidgetButton;
      if (localObject1 != null) {
        ((Button)localObject1).setOnClickListener((View.OnClickListener)new WeatherView.bindView.1(this));
      }
      this.jdField_a_of_type_Boolean = true;
      a(false);
      localObject2 = (OnlineAutoStatusBean)QConfigManager.a().a(652);
      localObject1 = this.jdField_a_of_type_ComTencentQphoneBaseUtilBaseApplication;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "appContext");
      j = AIOUtils.a(26.0F, ((BaseApplication)localObject1).getResources());
      if (localObject2 == null) {
        break label578;
      }
      localObject1 = ((OnlineAutoStatusBean)localObject2).a(localFriends.weatherTypeId);
      if (localObject1 == null) {
        break label578;
      }
      localObject1 = ((WeatherUrl)localObject1).b;
      label334:
      a((String)localObject1, this.jdField_a_of_type_AndroidWidgetImageView, 0, j, j, URLDrawableHelper.TRANSPARENT);
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
        break label584;
      }
      localObject1 = URLDrawableHelper.TRANSPARENT;
      label362:
      if (localObject2 == null) {
        break label593;
      }
      localObject2 = ((OnlineAutoStatusBean)localObject2).a(localFriends.weatherTypeId);
      if (localObject2 == null) {
        break label593;
      }
      localObject2 = ((WeatherUrl)localObject2).c;
      label391:
      a((String)localObject2, this.jdField_b_of_type_AndroidWidgetImageView, (int)this.jdField_c_of_type_Float, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, (Drawable)localObject1);
      if (localFriends.weatherUpdateTime > 0L) {
        break label599;
      }
      localObject1 = this.jdField_e_of_type_AndroidWidgetTextView;
      if (localObject1 != null) {
        ((TextView)localObject1).setText((CharSequence)"");
      }
      label448:
      localObject1 = (CharSequence)localFriends.temper;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label635;
      }
      j = 1;
      label475:
      if (j == 0) {
        break label640;
      }
      localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localObject1 != null) {
        ((TextView)localObject1).setText((CharSequence)"");
      }
    }
    for (;;)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.ONLINE_STATUS_PERMISSION_MANAGER);
      if (localObject1 != null) {
        break label686;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionManager");
      localObject1 = (CharSequence)"";
      break;
      label540:
      localObject1 = (CharSequence)"";
      break label114;
      label551:
      localObject1 = "";
      break label153;
      label559:
      localObject1 = "";
      break label174;
      label567:
      localObject1 = (CharSequence)"";
      break label222;
      label578:
      localObject1 = null;
      break label334;
      label584:
      localObject1 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      break label362;
      label593:
      localObject2 = null;
      break label391;
      label599:
      localObject1 = this.jdField_e_of_type_AndroidWidgetTextView;
      if (localObject1 == null) {
        break label448;
      }
      ((TextView)localObject1).setText((CharSequence)a(localFriends.weatherUpdateTime * 1000));
      break label448;
      label635:
      j = 0;
      break label475;
      label640:
      localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localObject1 != null) {
        ((TextView)localObject1).setText((CharSequence)(localFriends.temper + "°"));
      }
    }
    label686:
    localObject1 = ((OnlineStatusPermissionManager)localObject1).a(40001, false, (OnlineStatusPermissionManager.ReceiveDataListener)this);
    boolean bool1 = bool2;
    if (localObject1 != null)
    {
      bool1 = bool2;
      if (!((OnlineStatusFriendsPermissionItem)localObject1).allHasPermission) {
        bool1 = true;
      }
    }
    b(bool1);
  }
  
  public void a(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    if ((paramInt1 == 1030) && (paramInt2 == -1) && (paramIntent != null) && (paramIntent.getSerializableExtra("online_status_permission_item") != null))
    {
      paramIntent = paramIntent.getSerializableExtra("online_status_permission_item");
      if (paramIntent == null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker.OnlineStatusPermissionItem");
      }
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem = ((OnlineStatusPermissionChecker.OnlineStatusPermissionItem)paramIntent);
      g();
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
    if ((paramBoolean) && (paramBitmap != null) && (this.jdField_d_of_type_AndroidViewView != null)) {
      this.jdField_d_of_type_AndroidViewView.setBackgroundDrawable((Drawable)new BitmapDrawable(paramBitmap));
    }
    while (this.jdField_d_of_type_AndroidViewView == null) {
      return;
    }
    this.jdField_d_of_type_AndroidViewView.setBackgroundColor(paramInt);
  }
  
  protected void a(@Nullable int[] paramArrayOfInt)
  {
    View localView;
    if (paramArrayOfInt != null)
    {
      localView = this.jdField_b_of_type_AndroidViewView;
      Intrinsics.checkExpressionValueIsNotNull(localView, "cardView");
      if (localView.getWidth() == 0) {
        break label81;
      }
      localView = this.jdField_b_of_type_AndroidViewView;
      Intrinsics.checkExpressionValueIsNotNull(localView, "cardView");
      if (localView.getHeight() == 0) {
        break label81;
      }
      localView = this.jdField_b_of_type_AndroidViewView;
      Intrinsics.checkExpressionValueIsNotNull(localView, "cardView");
      paramArrayOfInt[0] = localView.getWidth();
      localView = this.jdField_b_of_type_AndroidViewView;
      Intrinsics.checkExpressionValueIsNotNull(localView, "cardView");
      paramArrayOfInt[1] = localView.getHeight();
    }
    for (;;)
    {
      return;
      label81:
      paramArrayOfInt[0] = this.jdField_a_of_type_Int;
      localView = this.jdField_b_of_type_AndroidViewView;
      Intrinsics.checkExpressionValueIsNotNull(localView, "cardView");
      paramArrayOfInt[1] = AIOUtils.a(430.0F, localView.getResources());
    }
  }
  
  public void aA_()
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.requestPermissions(new WeatherView.showCard.1(this), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
      return;
    }
    Manager localManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.ONLINE_STATUS_MANAGER);
    if (localManager == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.onlinestatus.OnlineStatusManager");
    }
    ((OnlineStatusManager)localManager).a(9);
    show();
  }
  
  protected void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver((BusinessObserver)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusWeatherWeatherObserver);
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewBaseStatusCardView$OnDismissCallback.a(1030);
  }
  
  public void show()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver((BusinessObserver)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusWeatherWeatherObserver);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem = ((OnlineStatusPermissionChecker.OnlineStatusPermissionItem)null);
    a();
    c();
    try
    {
      a(this.h, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      a(this.i, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      super.show();
      b(true);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("WeatherView", 2, new Object[] { "show: called. ", "", localException });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.WeatherView
 * JD-Core Version:    0.7.0.1
 */
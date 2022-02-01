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
  private BaseApplication A;
  private int B;
  private int C;
  private float D;
  @NotNull
  private final Drawable E;
  @NotNull
  private QBaseActivity F;
  @NotNull
  private OnLineStatusBlurBg G;
  private ImageView a;
  private ImageView b;
  @Nullable
  private Button c;
  private TextView d;
  private TextView e;
  private TextView f;
  private TextView g;
  private TextView h;
  private View o;
  private TextView p;
  private TextView q;
  private WeatherObserver r;
  private final View s;
  private final View t;
  private TextView u;
  private TextView v;
  private OnlineStatusPermissionChecker.OnlineStatusPermissionItem w;
  private final AppRuntime x;
  private Drawable y;
  private boolean z;
  
  public WeatherView(@NotNull QBaseActivity paramQBaseActivity, @NotNull OnLineStatusBlurBg paramOnLineStatusBlurBg, @NotNull BaseStatusCardView.OnDismissCallback paramOnDismissCallback)
  {
    super((Context)paramQBaseActivity, paramOnDismissCallback);
    this.F = paramQBaseActivity;
    this.G = paramOnLineStatusBlurBg;
    paramQBaseActivity = this.F.getAppRuntime();
    Intrinsics.checkExpressionValueIsNotNull(paramQBaseActivity, "activity.appRuntime");
    this.x = paramQBaseActivity;
    this.z = true;
    this.A = BaseApplication.context;
    this.E = ((Drawable)new ColorDrawable(0));
    this.s = a();
    this.s.setOnClickListener((View.OnClickListener)new WeatherView.1(this));
    paramQBaseActivity = this.s.findViewById(2131450063);
    Intrinsics.checkExpressionValueIsNotNull(paramQBaseActivity, "contentView.findViewById(R.id.weather_root)");
    this.t = paramQBaseActivity;
    this.t.setOnClickListener((View.OnClickListener)WeatherView.2.a);
    this.i = this.s;
    this.j = this.t;
    d();
    setContentView(this.s);
    paramQBaseActivity = this.A;
    Intrinsics.checkExpressionValueIsNotNull(paramQBaseActivity, "appContext");
    paramQBaseActivity = paramQBaseActivity.getResources();
    Intrinsics.checkExpressionValueIsNotNull(paramQBaseActivity, "appContext.resources");
    int i = paramQBaseActivity.getDisplayMetrics().widthPixels;
    paramQBaseActivity = this.A;
    Intrinsics.checkExpressionValueIsNotNull(paramQBaseActivity, "appContext");
    this.B = (i - Utils.a(80.0F, paramQBaseActivity.getResources()));
    paramQBaseActivity = this.A;
    Intrinsics.checkExpressionValueIsNotNull(paramQBaseActivity, "appContext");
    this.C = Utils.a(211.0F, paramQBaseActivity.getResources());
    this.D = (12 * DeviceInfoUtil.A());
    paramQBaseActivity = this.A;
    Intrinsics.checkExpressionValueIsNotNull(paramQBaseActivity, "appContext");
    paramQBaseActivity = BitmapManager.a(paramQBaseActivity.getResources(), 2130842376, this.B, this.C);
    if (paramQBaseActivity != null)
    {
      paramQBaseActivity = BaseImageUtil.d(paramQBaseActivity, this.D, this.B, this.C);
      paramOnLineStatusBlurBg = this.A;
      Intrinsics.checkExpressionValueIsNotNull(paramOnLineStatusBlurBg, "appContext");
      this.y = ((Drawable)new BitmapDrawable(paramOnLineStatusBlurBg.getResources(), paramQBaseActivity));
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
      paramString.setDecodeHandler(URLDrawableHelper.b);
    }
    if (paramImageView != null) {
      paramImageView.setImageDrawable((Drawable)paramString);
    }
  }
  
  private final void a(boolean paramBoolean)
  {
    Button localButton = this.c;
    if (localButton != null)
    {
      Object localObject = this.x.getRuntimeService(IOnlineStatusService.class, "");
      Intrinsics.checkExpressionValueIsNotNull(localObject, "app.getRuntimeService(IO…va, ProcessConstant.MAIN)");
      if (((IOnlineStatusService)localObject).getExtOnlineStatus() == 1030)
      {
        int i;
        if (paramBoolean) {
          i = 2131888288;
        } else {
          i = 2131890660;
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("change: ");
          ((StringBuilder)localObject).append(paramBoolean);
          QLog.d("WeatherView", 2, new Object[] { "updateButtonText: called. ", ((StringBuilder)localObject).toString() });
        }
        this.z = (paramBoolean ^ true);
        localButton.setText(this.x.getApp().getText(i));
        localButton.setEnabled(paramBoolean);
        return;
      }
      localButton.setText(this.x.getApp().getText(2131892656));
      localButton.setEnabled(true);
    }
  }
  
  private final void c(boolean paramBoolean)
  {
    Object localObject1 = this.A;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "appContext");
    Object localObject2 = ((BaseApplication)localObject1).getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "appContext.resources");
    localObject1 = ((Resources)localObject2).getString(2131888286);
    if (paramBoolean) {
      localObject1 = ((Resources)localObject2).getString(2131888292);
    }
    Ref.ObjectRef localObjectRef = new Ref.ObjectRef();
    localObjectRef.element = ((Resources)localObject2).getString(2131888291);
    localObject2 = this.p;
    if (localObject2 != null)
    {
      localObject1 = (CharSequence)localObject1;
      ((TextView)localObject2).setText((CharSequence)localObject1);
      ((TextView)localObject2).setContentDescription((CharSequence)localObject1);
    }
    localObject1 = this.q;
    if (localObject1 != null)
    {
      ((TextView)localObject1).setText((CharSequence)localObjectRef.element);
      ((TextView)localObject1).setClickable(true);
      ((TextView)localObject1).setOnClickListener((View.OnClickListener)new WeatherView.bindTextView..inlined.apply.lambda.1(this, localObjectRef, paramBoolean));
      ((TextView)localObject1).setOnTouchListener((View.OnTouchListener)new AutoStatusSelectView.MyViewAlphaOnTouchListener());
      if (ThemeImageWrapper.isNightMode())
      {
        ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130837602, 0);
        return;
      }
      ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130837601, 0);
    }
  }
  
  private final void d()
  {
    this.r = ((WeatherObserver)new WeatherView.initData.1(this));
  }
  
  private final void e()
  {
    Object localObject;
    if (QQTheme.isNowThemeIsNight())
    {
      this.t.setBackgroundResource(2130847806);
      a(false, null, Color.parseColor("#FF010101"));
      localObject = this.o;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
    }
    else
    {
      this.t.setBackgroundResource(2130847805);
      localObject = new OnLineStatusBlurBg.BlurBgItem();
      QBaseActivity localQBaseActivity = this.F;
      if (localQBaseActivity == null) {
        break label103;
      }
      ((OnLineStatusBlurBg.BlurBgItem)localObject).a = localQBaseActivity;
      this.G.a((OnLineStatusBlurBg.BlurBgItem)localObject, (OnLineStatusBlurBg.OnLineStatusBlurBgListener)this);
      localObject = this.o;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
    }
    return;
    label103:
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
  }
  
  private final void f()
  {
    Object localObject = this.w;
    boolean bool2 = false;
    boolean bool1;
    if (localObject != null)
    {
      bool2 = ((OnlineStatusPermissionChecker.OnlineStatusPermissionItem)localObject).isAllHasPermission() ^ true;
      localObject = this.x.getRuntimeService(IOnlineStatusManagerService.class, "");
      Intrinsics.checkExpressionValueIsNotNull(localObject, "app.getRuntimeService(IO…va, ProcessConstant.MAIN)");
      localObject = ((IOnlineStatusManagerService)localObject).getManager(IOnlineStatusPermissionManager.class);
      if (localObject != null) {
        bool1 = ((OnlineStatusPermissionManager)localObject).a(this.w, (OnlineStatusPermissionManager.ReceiveDataListener)this);
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
    View localView = View.inflate((Context)BaseApplication.context, 2131627859, null);
    this.a = ((ImageView)localView.findViewById(2131450061));
    this.b = ((ImageView)localView.findViewById(2131437907));
    this.d = ((TextView)localView.findViewById(2131446976));
    this.e = ((TextView)localView.findViewById(2131450062));
    this.c = ((Button)localView.findViewById(2131445538));
    this.f = ((TextView)localView.findViewById(2131450060));
    this.p = ((TextView)localView.findViewById(2131445523));
    this.q = ((TextView)localView.findViewById(2131445514));
    this.g = ((TextView)localView.findViewById(2131427835));
    this.h = ((TextView)localView.findViewById(2131431602));
    this.o = localView.findViewById(2131439332);
    this.u = ((TextView)localView.findViewById(2131437924));
    this.v = ((TextView)localView.findViewById(2131446539));
    Intrinsics.checkExpressionValueIsNotNull(localView, "view");
    return localView;
  }
  
  @NotNull
  public final String a(long paramLong)
  {
    Object localObject = new Date(paramLong);
    localObject = ConstellationUtilKt.e().format((Date)localObject);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "defaultDateFormat.format(date)");
    return localObject;
  }
  
  public void a(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    if ((paramInt1 == 1030) && (paramInt2 == -1) && (paramIntent != null) && (paramIntent.getSerializableExtra("online_status_permission_item") != null))
    {
      paramIntent = paramIntent.getSerializableExtra("online_status_permission_item");
      if (paramIntent != null)
      {
        this.w = ((OnlineStatusPermissionChecker.OnlineStatusPermissionItem)paramIntent);
        f();
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker.OnlineStatusPermissionItem");
    }
  }
  
  public void a(@NotNull OnlineStatusFriendsPermissionItem paramOnlineStatusFriendsPermissionItem, @NotNull List<Integer> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramOnlineStatusFriendsPermissionItem, "item");
    Intrinsics.checkParameterIsNotNull(paramList, "smartSelectedList");
    if (this.w == null)
    {
      this.w = OnlineStatusPermissionChecker.OnlineStatusPermissionItem.create(40001, paramOnlineStatusFriendsPermissionItem.allHasPermission, paramOnlineStatusFriendsPermissionItem.permissionUins);
      f();
    }
  }
  
  public void a(boolean paramBoolean, @Nullable Bitmap paramBitmap, int paramInt)
  {
    if ((paramBoolean) && (paramBitmap != null))
    {
      View localView = this.s;
      if (localView != null)
      {
        localView.setBackgroundDrawable((Drawable)new BitmapDrawable(paramBitmap));
        return;
      }
    }
    paramBitmap = this.s;
    if (paramBitmap != null) {
      paramBitmap.setBackgroundColor(paramInt);
    }
  }
  
  protected void a(@Nullable int[] paramArrayOfInt)
  {
    if (paramArrayOfInt != null)
    {
      View localView = this.j;
      Intrinsics.checkExpressionValueIsNotNull(localView, "cardView");
      if (localView.getWidth() != 0)
      {
        localView = this.j;
        Intrinsics.checkExpressionValueIsNotNull(localView, "cardView");
        if (localView.getHeight() != 0)
        {
          localView = this.j;
          Intrinsics.checkExpressionValueIsNotNull(localView, "cardView");
          paramArrayOfInt[0] = localView.getWidth();
          localView = this.j;
          Intrinsics.checkExpressionValueIsNotNull(localView, "cardView");
          paramArrayOfInt[1] = localView.getHeight();
          return;
        }
      }
      paramArrayOfInt[0] = this.B;
      localView = this.j;
      Intrinsics.checkExpressionValueIsNotNull(localView, "cardView");
      paramArrayOfInt[1] = Utils.a(430.0F, localView.getResources());
    }
  }
  
  @SuppressLint({"SetTextI18n"})
  public final void b()
  {
    Object localObject1 = this.x.getRuntimeService(IFriendDataService.class, "");
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "app.getRuntimeService(IF…va, ProcessConstant.MAIN)");
    Friends localFriends = ((IFriendDataService)localObject1).getFriend(this.x.getCurrentUin(), true, true, true);
    Object localObject2 = this.f;
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
    localObject2 = this.e;
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
    localObject2 = this.g;
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
    localObject2 = this.d;
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
    localObject1 = this.c;
    if (localObject1 != null) {
      ((Button)localObject1).setOnClickListener((View.OnClickListener)new WeatherView.bindView.1(this));
    }
    this.z = true;
    boolean bool2 = false;
    a(false);
    Object localObject3 = (OnlineAutoStatusBean)QConfigManager.b().b(652);
    localObject1 = this.A;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "appContext");
    int i = Utils.a(26.0F, ((BaseApplication)localObject1).getResources());
    StringBuilder localStringBuilder = null;
    if (localObject3 != null)
    {
      localObject1 = ((OnlineAutoStatusBean)localObject3).b(localFriends.weatherTypeId);
      if (localObject1 != null)
      {
        localObject1 = ((WeatherUrl)localObject1).b;
        break label395;
      }
    }
    localObject1 = null;
    label395:
    a((String)localObject1, this.a, 0, i, i, URLDrawableHelperConstants.a);
    localObject2 = this.y;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = URLDrawableHelperConstants.a;
    }
    localObject2 = localStringBuilder;
    if (localObject3 != null)
    {
      localObject3 = ((OnlineAutoStatusBean)localObject3).b(localFriends.weatherTypeId);
      localObject2 = localStringBuilder;
      if (localObject3 != null) {
        localObject2 = ((WeatherUrl)localObject3).c;
      }
    }
    a((String)localObject2, this.b, (int)this.D, this.B, this.C, (Drawable)localObject1);
    if (localFriends.weatherUpdateTime <= 0L)
    {
      localObject1 = this.h;
      if (localObject1 != null) {
        ((TextView)localObject1).setText((CharSequence)"");
      }
    }
    else
    {
      localObject1 = this.h;
      if (localObject1 != null) {
        ((TextView)localObject1).setText((CharSequence)a(localFriends.weatherUpdateTime * 1000));
      }
    }
    localObject1 = (CharSequence)localFriends.temper;
    if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      localObject1 = this.d;
      if (localObject1 != null) {
        ((TextView)localObject1).setText((CharSequence)"");
      }
    }
    else
    {
      localObject1 = this.d;
      if (localObject1 != null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(localFriends.temper);
        ((StringBuilder)localObject2).append("°");
        ((TextView)localObject1).setText((CharSequence)((StringBuilder)localObject2).toString());
      }
    }
    localObject1 = this.x.getRuntimeService(IOnlineStatusManagerService.class, "");
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
  
  @NotNull
  public final QBaseActivity c()
  {
    return this.F;
  }
  
  public void dg_()
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      this.F.requestPermissions(new WeatherView.showCard.1(this), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
      return;
    }
    Object localObject = this.x.getRuntimeService(IOnlineStatusManagerService.class, "");
    Intrinsics.checkExpressionValueIsNotNull(localObject, "app.getRuntimeService(IO…va, ProcessConstant.MAIN)");
    localObject = ((IOnlineStatusManagerService)localObject).getManager(IOnlineStatusDataManager.class);
    if (localObject != null)
    {
      ((OnlineStatusDataManager)localObject).b(9);
      show();
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.onlinestatus.manager.OnlineStatusDataManager");
  }
  
  protected void k()
  {
    this.x.unRegistObserver((BusinessObserver)this.r);
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    this.n.a(1030);
  }
  
  public void show()
  {
    this.x.registObserver((BusinessObserver)this.r);
    this.w = ((OnlineStatusPermissionChecker.OnlineStatusPermissionItem)null);
    b();
    e();
    try
    {
      a(this.u);
      a(this.v);
      super.show();
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("WeatherView", 2, new Object[] { "show: called. ", "", localException });
      }
    }
    e(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.WeatherView
 * JD-Core Version:    0.7.0.1
 */
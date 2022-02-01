package com.tencent.mobileqq.onlinestatus.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.onlinestatus.OnLineStatusBlurBg;
import com.tencent.mobileqq.onlinestatus.OnLineStatusBlurBg.BlurBgItem;
import com.tencent.mobileqq.onlinestatus.OnLineStatusBlurBg.OnLineStatusBlurBgListener;
import com.tencent.mobileqq.onlinestatus.OnlineStatusExtInfoServlet;
import com.tencent.mobileqq.onlinestatus.OnlineStatusUtil;
import com.tencent.mobileqq.onlinestatus.constellation.ConstellationLauncher;
import com.tencent.mobileqq.onlinestatus.constellation.ConstellationUtilKt;
import com.tencent.mobileqq.onlinestatus.constellation.StatusExtInfoObserver;
import com.tencent.mobileqq.onlinestatus.utils.URLDrawableHelper;
import com.tencent.mobileqq.profilesetting.api.IProfileSettingApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IProfileCardUtil;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeImageWrapper;
import java.util.concurrent.CompletableFuture;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.IntRef;
import mqq.app.AppRuntime;
import mqq.observer.BusinessObserver;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/onlinestatus/view/ConstellationView;", "Lcom/tencent/mobileqq/onlinestatus/view/BaseStatusCardView;", "Lcom/tencent/mobileqq/onlinestatus/OnLineStatusBlurBg$OnLineStatusBlurBgListener;", "activity", "Lcom/tencent/mobileqq/app/QBaseActivity;", "onLineStatusBlurBg", "Lcom/tencent/mobileqq/onlinestatus/OnLineStatusBlurBg;", "dismissCallback", "Lcom/tencent/mobileqq/onlinestatus/view/BaseStatusCardView$OnDismissCallback;", "(Lcom/tencent/mobileqq/app/QBaseActivity;Lcom/tencent/mobileqq/onlinestatus/OnLineStatusBlurBg;Lcom/tencent/mobileqq/onlinestatus/view/BaseStatusCardView$OnDismissCallback;)V", "getActivity", "()Lcom/tencent/mobileqq/app/QBaseActivity;", "setActivity", "(Lcom/tencent/mobileqq/app/QBaseActivity;)V", "app", "Lmqq/app/AppRuntime;", "appContext", "Lcom/tencent/qphone/base/util/BaseApplication;", "kotlin.jvm.PlatformType", "getAppContext", "()Lcom/tencent/qphone/base/util/BaseApplication;", "setAppContext", "(Lcom/tencent/qphone/base/util/BaseApplication;)V", "birthdayValue", "", "constellationIndex", "constellationStr", "", "contentView", "Landroid/view/View;", "defaultBgDrawable", "Landroid/graphics/drawable/BitmapDrawable;", "getOnLineStatusBlurBg", "()Lcom/tencent/mobileqq/onlinestatus/OnLineStatusBlurBg;", "setOnLineStatusBlurBg", "(Lcom/tencent/mobileqq/onlinestatus/OnLineStatusBlurBg;)V", "selfProfileCard", "Lcom/tencent/mobileqq/data/Card;", "statusExtInfoObserver", "Lcom/tencent/mobileqq/onlinestatus/constellation/StatusExtInfoObserver;", "todayConstellationTrend", "viewChangeConstellation", "Landroid/widget/TextView;", "viewConstellationDate", "viewConstellationIcon", "Landroid/widget/ImageView;", "viewConstellationName", "viewConstellationTrend", "viewMainBackground", "viewMainTitle", "viewNightThemeBg", "viewSelectConstellation", "viewSelectStatus", "Landroid/widget/Button;", "viewSubTitle", "widthBg", "getWidthBg", "()I", "setWidthBg", "(I)V", "beforeDismiss", "", "bindTextView", "bindView", "blurBackground", "blurBgResult", "isSuccess", "", "bitmap", "Landroid/graphics/Bitmap;", "color", "createView", "initCardRect", "cardRect", "", "initData", "isConstellationVisible", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onProfileVisibleLoaded", "Landroid/app/Activity;", "okClicked", "Lkotlin/Function0;", "onCanceled", "setViewDrawable", "url", "view", "show", "Companion", "qqonlinestatus-impl_release"}, k=1, mv={1, 1, 16})
public final class ConstellationView
  extends BaseStatusCardView
  implements OnLineStatusBlurBg.OnLineStatusBlurBgListener
{
  public static final ConstellationView.Companion a;
  private int jdField_a_of_type_Int;
  private BitmapDrawable jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  @NotNull
  private QBaseActivity jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
  private Card jdField_a_of_type_ComTencentMobileqqDataCard;
  @NotNull
  private OnLineStatusBlurBg jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusBlurBg;
  private StatusExtInfoObserver jdField_a_of_type_ComTencentMobileqqOnlinestatusConstellationStatusExtInfoObserver;
  private BaseApplication jdField_a_of_type_ComTencentQphoneBaseUtilBaseApplication;
  private String jdField_a_of_type_JavaLangString;
  private final AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  private int jdField_b_of_type_Int;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private final View jdField_d_of_type_AndroidViewView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private TextView e;
  private TextView f;
  private TextView g;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqOnlinestatusViewConstellationView$Companion = new ConstellationView.Companion(null);
  }
  
  public ConstellationView(@NotNull QBaseActivity paramQBaseActivity, @NotNull OnLineStatusBlurBg paramOnLineStatusBlurBg, @NotNull BaseStatusCardView.OnDismissCallback paramOnDismissCallback)
  {
    super((Context)paramQBaseActivity, paramOnDismissCallback);
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = paramQBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusBlurBg = paramOnLineStatusBlurBg;
    paramQBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime();
    Intrinsics.checkExpressionValueIsNotNull(paramQBaseActivity, "activity.getAppRuntime()");
    this.jdField_a_of_type_MqqAppAppRuntime = paramQBaseActivity;
    this.jdField_a_of_type_ComTencentQphoneBaseUtilBaseApplication = BaseApplication.context;
    paramQBaseActivity = a();
    paramQBaseActivity.findViewById(2131376818).setOnClickListener((View.OnClickListener)new ConstellationView..special..inlined.apply.lambda.1(this));
    this.jdField_b_of_type_AndroidViewView = paramQBaseActivity.findViewById(2131365187);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener((View.OnClickListener)ConstellationView.1.2.a);
    this.jdField_d_of_type_AndroidViewView = paramQBaseActivity;
    b();
    a();
    setContentView(this.jdField_d_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidViewView = this.jdField_d_of_type_AndroidViewView;
    paramQBaseActivity = this.jdField_a_of_type_ComTencentQphoneBaseUtilBaseApplication;
    Intrinsics.checkExpressionValueIsNotNull(paramQBaseActivity, "appContext");
    this.jdField_c_of_type_Int = Utils.a(296.0F, paramQBaseActivity.getResources());
    paramQBaseActivity = this.jdField_a_of_type_ComTencentQphoneBaseUtilBaseApplication;
    Intrinsics.checkExpressionValueIsNotNull(paramQBaseActivity, "appContext");
    int i = Utils.a(211.0F, paramQBaseActivity.getResources());
    float f1 = 12;
    float f2 = DeviceInfoUtil.a();
    paramQBaseActivity = this.jdField_a_of_type_ComTencentQphoneBaseUtilBaseApplication;
    Intrinsics.checkExpressionValueIsNotNull(paramQBaseActivity, "appContext");
    paramQBaseActivity = BitmapManager.a(paramQBaseActivity.getResources(), 2130841526, this.jdField_c_of_type_Int, i);
    if (paramQBaseActivity != null)
    {
      paramQBaseActivity = BaseImageUtil.d(paramQBaseActivity, f1 * f2, this.jdField_c_of_type_Int, i);
      paramOnLineStatusBlurBg = this.jdField_a_of_type_ComTencentQphoneBaseUtilBaseApplication;
      Intrinsics.checkExpressionValueIsNotNull(paramOnLineStatusBlurBg, "appContext");
      this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = new BitmapDrawable(paramOnLineStatusBlurBg.getResources(), paramQBaseActivity);
    }
    if (Build.VERSION.SDK_INT >= 24) {
      CompletableFuture.runAsync((Runnable)new ConstellationView.3(this));
    }
  }
  
  private final void a(Activity paramActivity, Function0<Unit> paramFunction01, Function0<Unit> paramFunction02)
  {
    boolean bool = a();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("constellationVisible: ");
      localStringBuilder.append(bool);
      QLog.d("ConstellationView", 2, new Object[] { "onProfileVisibleLoaded: called. ", localStringBuilder.toString() });
    }
    if (!bool)
    {
      paramActivity = DialogUtil.a((Context)paramActivity, 230, paramActivity.getResources().getString(2131698473), paramActivity.getResources().getString(2131698470), 2131698471, 2131698472, (DialogInterface.OnClickListener)new ConstellationView.onProfileVisibleLoaded.dialog.1(paramFunction01), (DialogInterface.OnClickListener)new ConstellationView.onProfileVisibleLoaded.dialog.2(paramFunction02));
      try
      {
        paramActivity.show();
        return;
      }
      catch (Exception paramActivity)
      {
        QLog.e("ConstellationView", 1, (Throwable)paramActivity, new Object[0]);
        return;
      }
    }
    paramFunction01.invoke();
  }
  
  private final boolean a()
  {
    IProfileSettingApi localIProfileSettingApi = (IProfileSettingApi)QRoute.api(IProfileSettingApi.class);
    Card localCard = this.jdField_a_of_type_ComTencentMobileqqDataCard;
    if (localCard == null) {
      Intrinsics.throwUninitializedPropertyAccessException("selfProfileCard");
    }
    return localIProfileSettingApi.getProfileSettingStateFromCard(41609, localCard) != 2;
  }
  
  private final boolean a(String paramString, ImageView paramImageView)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    Object localObject = this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
    localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
    localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
    if (paramImageView != null)
    {
      localURLDrawableOptions.mRequestWidth = paramImageView.getWidth();
      localURLDrawableOptions.mRequestHeight = paramImageView.getHeight();
    }
    localObject = (CharSequence)paramString;
    int i;
    if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i == 0)
    {
      paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "drawable");
      paramString.setTag(URLDrawableHelper.a(localURLDrawableOptions.mRequestWidth, localURLDrawableOptions.mRequestHeight, (int)(12 * DeviceInfoUtil.a())));
      paramString.setDecodeHandler(URLDrawableHelper.b);
      if (paramImageView != null) {
        paramImageView.setImageDrawable((Drawable)paramString);
      }
      return paramString.getStatus() != 2;
    }
    if (paramImageView != null) {
      paramImageView.setImageDrawable((Drawable)this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
    }
    return false;
  }
  
  private final void b()
  {
    Object localObject = (IProfileCardUtil)QRoute.api(IProfileCardUtil.class);
    AppRuntime localAppRuntime = this.jdField_a_of_type_MqqAppAppRuntime;
    localObject = ((IProfileCardUtil)localObject).initCard(localAppRuntime, localAppRuntime.getCurrentAccountUin());
    Intrinsics.checkExpressionValueIsNotNull(localObject, "QRoute.api(IProfileCardU…p, app.currentAccountUin)");
    this.jdField_a_of_type_ComTencentMobileqqDataCard = ((Card)localObject);
    localObject = this.jdField_a_of_type_ComTencentMobileqqDataCard;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("selfProfileCard");
    }
    this.jdField_b_of_type_Int = ((int)((Card)localObject).lBirthday);
    localObject = this.jdField_a_of_type_ComTencentMobileqqDataCard;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("selfProfileCard");
    }
    this.jdField_a_of_type_Int = ((Card)localObject).constellation;
    this.jdField_a_of_type_JavaLangString = OnlineStatusUtil.b(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusConstellationStatusExtInfoObserver = ((StatusExtInfoObserver)new ConstellationView.initData.1(this));
  }
  
  private final void c()
  {
    OnLineStatusBlurBg.BlurBgItem localBlurBgItem = new OnLineStatusBlurBg.BlurBgItem();
    QBaseActivity localQBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
    if (localQBaseActivity != null)
    {
      localBlurBgItem.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = localQBaseActivity;
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusBlurBg.a(localBlurBgItem, (OnLineStatusBlurBg.OnLineStatusBlurBgListener)this);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
  }
  
  private final void g()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentQphoneBaseUtilBaseApplication;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "appContext");
    localObject1 = ((BaseApplication)localObject1).getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "appContext.resources");
    int i;
    if (this.jdField_a_of_type_Int != 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      localObject2 = ((Resources)localObject1).getString(2131698477);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "res.getString(R.string.q…nstellation_select_part1)");
      localObject1 = ((Resources)localObject1).getString(2131698478);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "res.getString(R.string.q…nstellation_select_part2)");
    }
    else
    {
      localObject2 = ((Resources)localObject1).getString(2131698475);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "res.getString(R.string.q…select_no_birthday_part1)");
      localObject1 = ((Resources)localObject1).getString(2131698476);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "res.getString(R.string.q…select_no_birthday_part2)");
    }
    TextView localTextView = this.e;
    if (localTextView != null) {
      localTextView.setText((CharSequence)localObject2);
    }
    Object localObject2 = this.f;
    if (localObject2 != null)
    {
      ((TextView)localObject2).setText((CharSequence)localObject1);
      ((TextView)localObject2).setClickable(true);
      ((TextView)localObject2).setOnClickListener((View.OnClickListener)new ConstellationView.bindTextView..inlined.apply.lambda.1(this, (String)localObject1));
      ((TextView)localObject2).setOnTouchListener((View.OnTouchListener)new AutoStatusSelectView.MyViewAlphaOnTouchListener());
      if (ThemeImageWrapper.isNightMode())
      {
        ((TextView)localObject2).setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130837596, 0);
        return;
      }
      ((TextView)localObject2).setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130837595, 0);
    }
  }
  
  @NotNull
  public final View a()
  {
    View localView = View.inflate((Context)BaseApplication.context, 2131561499, null);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131365103));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131365104));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131377160));
    this.e = ((TextView)localView.findViewById(2131377142));
    this.f = ((TextView)localView.findViewById(2131377137));
    this.g = ((TextView)localView.findViewById(2131365100));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131365101));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131370632));
    this.jdField_c_of_type_AndroidViewView = localView.findViewById(2131371889);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131370648));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378039));
    Intrinsics.checkExpressionValueIsNotNull(localView, "view");
    return localView;
  }
  
  @NotNull
  public final QBaseActivity a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
  }
  
  public final void a()
  {
    a(ConstellationUtilKt.b(this.jdField_a_of_type_MqqAppAppRuntime), this.jdField_a_of_type_AndroidWidgetImageView);
    boolean bool1;
    if (this.jdField_a_of_type_Int != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if (bool1) {
      bool2 = a(ConstellationUtilKt.c(this.jdField_a_of_type_MqqAppAppRuntime), this.jdField_b_of_type_AndroidWidgetImageView);
    } else {
      bool2 = false;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("bgSuccessLoad: ");
      ((StringBuilder)localObject1).append(bool2);
      ((StringBuilder)localObject1).append("  hasBirthdaySet: ");
      ((StringBuilder)localObject1).append(bool1);
      QLog.d("ConstellationView", 2, new Object[] { "bindView: called. ", ((StringBuilder)localObject1).toString() });
    }
    if (bool2)
    {
      localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(0);
      }
      localObject1 = this.g;
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(0);
      }
      localObject1 = this.jdField_a_of_type_AndroidWidgetImageView;
      if (localObject1 != null) {
        ((ImageView)localObject1).setVisibility(0);
      }
      localObject1 = this.jdField_b_of_type_AndroidWidgetTextView;
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(0);
      }
    }
    else
    {
      localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(4);
      }
      localObject1 = this.g;
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(4);
      }
      localObject1 = this.jdField_a_of_type_AndroidWidgetImageView;
      if (localObject1 != null) {
        ((ImageView)localObject1).setVisibility(4);
      }
      localObject1 = this.jdField_b_of_type_AndroidWidgetTextView;
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(4);
      }
      localObject1 = this.jdField_b_of_type_AndroidWidgetImageView;
      if (localObject1 != null) {
        ((ImageView)localObject1).setImageDrawable((Drawable)this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
      }
    }
    Object localObject1 = new Ref.IntRef();
    try
    {
      localObject2 = ConstellationUtilKt.d(this.jdField_a_of_type_MqqAppAppRuntime);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("constellationStr: ");
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
        localStringBuilder.append(",  textColorFromSp: ");
        localStringBuilder.append((String)localObject2);
        QLog.d("ConstellationView", 2, new Object[] { "bindView: called. ", localStringBuilder.toString() });
      }
      ((Ref.IntRef)localObject1).element = Color.parseColor((String)localObject2);
    }
    catch (Exception localException)
    {
      Object localObject2;
      label365:
      break label365;
    }
    ((Ref.IntRef)localObject1).element = -16777216;
    localObject2 = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject2 != null)
    {
      ((TextView)localObject2).setText((CharSequence)this.jdField_a_of_type_JavaLangString);
      ((TextView)localObject2).setTextColor(((Ref.IntRef)localObject1).element);
    }
    localObject2 = this.jdField_b_of_type_AndroidWidgetTextView;
    if (localObject2 != null)
    {
      ((TextView)localObject2).setText((CharSequence)this.jdField_b_of_type_JavaLangString);
      ((TextView)localObject2).setTextColor(((Ref.IntRef)localObject1).element);
    }
    localObject2 = this.g;
    if (localObject2 != null)
    {
      ((TextView)localObject2).setText((CharSequence)ConstellationUtilKt.a());
      ((TextView)localObject2).setTextColor(((Ref.IntRef)localObject1).element);
    }
    localObject1 = this.jdField_a_of_type_AndroidWidgetButton;
    if (localObject1 != null)
    {
      ((Button)localObject1).setOnClickListener((View.OnClickListener)new ConstellationView.bindView..inlined.apply.lambda.1(this, bool1));
      if (bool1)
      {
        if (ConstellationUtilKt.b(this.jdField_a_of_type_MqqAppAppRuntime))
        {
          ((Button)localObject1).setText(this.jdField_a_of_type_MqqAppAppRuntime.getApp().getText(2131693121));
          ((Button)localObject1).setEnabled(false);
        }
        else
        {
          ((Button)localObject1).setText(this.jdField_a_of_type_MqqAppAppRuntime.getApp().getText(2131694929));
          ((Button)localObject1).setEnabled(true);
        }
      }
      else
      {
        ((Button)localObject1).setText(this.jdField_a_of_type_MqqAppAppRuntime.getApp().getText(2131694929));
        ((Button)localObject1).setEnabled(false);
      }
    }
    g();
  }
  
  public void a(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    if ((paramInt1 == ConstellationLauncher.jdField_a_of_type_Int) && (paramIntent != null))
    {
      paramIntent = ConstellationViewKt.a(this.jdField_a_of_type_MqqAppAppRuntime, paramIntent, this.jdField_a_of_type_JavaLangString);
      if (this.jdField_b_of_type_Int != ((Number)paramIntent.getFirst()).intValue()) {
        QQToast.a((Context)BaseApplication.context, 0, 2131691083, 0).a();
      }
      this.jdField_b_of_type_Int = ((Number)paramIntent.getFirst()).intValue();
      this.jdField_a_of_type_JavaLangString = ((String)paramIntent.getSecond());
      a();
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
    this.jdField_d_of_type_AndroidViewView.setBackgroundColor(paramInt);
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
      paramArrayOfInt[0] = this.jdField_c_of_type_Int;
      localView = this.jdField_b_of_type_AndroidViewView;
      Intrinsics.checkExpressionValueIsNotNull(localView, "cardView");
      paramArrayOfInt[1] = Utils.a(430.0F, localView.getResources());
    }
  }
  
  protected void f()
  {
    this.jdField_a_of_type_MqqAppAppRuntime.unRegistObserver((BusinessObserver)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusConstellationStatusExtInfoObserver);
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewBaseStatusCardView$OnDismissCallback.a(1040);
  }
  
  public void show()
  {
    View localView;
    if (QQTheme.a())
    {
      localView = this.jdField_b_of_type_AndroidViewView;
      if (localView != null) {
        localView.setBackgroundResource(2130846335);
      }
      a(false, null, Color.parseColor("#FF010101"));
      localView = this.jdField_c_of_type_AndroidViewView;
      if (localView != null) {
        localView.setVisibility(0);
      }
    }
    else
    {
      localView = this.jdField_b_of_type_AndroidViewView;
      if (localView != null) {
        localView.setBackgroundResource(2130846334);
      }
      c();
      localView = this.jdField_c_of_type_AndroidViewView;
      if (localView != null) {
        localView.setVisibility(8);
      }
    }
    this.jdField_a_of_type_MqqAppAppRuntime.registObserver((BusinessObserver)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusConstellationStatusExtInfoObserver);
    OnlineStatusExtInfoServlet.a(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_JavaLangString);
    try
    {
      a(this.jdField_c_of_type_AndroidWidgetTextView);
      a(this.jdField_d_of_type_AndroidWidgetTextView);
      super.show();
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ConstellationView", 2, new Object[] { "show: called. ", "", localException });
      }
    }
    b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.ConstellationView
 * JD-Core Version:    0.7.0.1
 */
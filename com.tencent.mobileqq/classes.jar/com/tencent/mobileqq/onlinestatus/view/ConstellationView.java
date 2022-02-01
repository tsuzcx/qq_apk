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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.notification.modularize.OnlineModulePushReceiverKt;
import com.tencent.mobileqq.onlinestatus.OnLineStatusBlurBg;
import com.tencent.mobileqq.onlinestatus.OnLineStatusBlurBg.BlurBgItem;
import com.tencent.mobileqq.onlinestatus.OnLineStatusBlurBg.OnLineStatusBlurBgListener;
import com.tencent.mobileqq.onlinestatus.OnlineStatusExtInfoServlet;
import com.tencent.mobileqq.onlinestatus.constellation.ConstellationLauncher;
import com.tencent.mobileqq.onlinestatus.constellation.ConstellationUtilKt;
import com.tencent.mobileqq.onlinestatus.constellation.StatusExtInfoObserver;
import com.tencent.mobileqq.profilesetting.ProfileSettingUtils;
import com.tencent.mobileqq.profilesetting.ProfileSettingUtils.Companion;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeImageWrapper;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.IntRef;
import mqq.observer.BusinessObserver;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/onlinestatus/view/ConstellationView;", "Lcom/tencent/mobileqq/onlinestatus/view/BaseStatusCardView;", "Lcom/tencent/mobileqq/onlinestatus/OnLineStatusBlurBg$OnLineStatusBlurBgListener;", "activity", "Lcom/tencent/mobileqq/app/BaseActivity;", "onLineStatusBlurBg", "Lcom/tencent/mobileqq/onlinestatus/OnLineStatusBlurBg;", "dismissCallback", "Lcom/tencent/mobileqq/onlinestatus/view/BaseStatusCardView$OnDismissCallback;", "(Lcom/tencent/mobileqq/app/BaseActivity;Lcom/tencent/mobileqq/onlinestatus/OnLineStatusBlurBg;Lcom/tencent/mobileqq/onlinestatus/view/BaseStatusCardView$OnDismissCallback;)V", "getActivity", "()Lcom/tencent/mobileqq/app/BaseActivity;", "setActivity", "(Lcom/tencent/mobileqq/app/BaseActivity;)V", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "appContext", "Lcom/tencent/qphone/base/util/BaseApplication;", "kotlin.jvm.PlatformType", "getAppContext", "()Lcom/tencent/qphone/base/util/BaseApplication;", "setAppContext", "(Lcom/tencent/qphone/base/util/BaseApplication;)V", "birthdayValue", "", "constellationIndex", "constellationStr", "", "contentView", "Landroid/view/View;", "defaultBgDrawable", "Landroid/graphics/drawable/BitmapDrawable;", "getOnLineStatusBlurBg", "()Lcom/tencent/mobileqq/onlinestatus/OnLineStatusBlurBg;", "setOnLineStatusBlurBg", "(Lcom/tencent/mobileqq/onlinestatus/OnLineStatusBlurBg;)V", "selfProfileCard", "Lcom/tencent/mobileqq/data/Card;", "statusExtInfoObserver", "Lcom/tencent/mobileqq/onlinestatus/constellation/StatusExtInfoObserver;", "todayConstellationTrend", "viewChangeConstellation", "Landroid/widget/TextView;", "viewConstellationDate", "viewConstellationIcon", "Landroid/widget/ImageView;", "viewConstellationName", "viewConstellationTrend", "viewMainBackground", "viewMainTitle", "viewNightThemeBg", "viewSelectConstellation", "viewSelectStatus", "Landroid/widget/Button;", "viewSubTitle", "widthBg", "getWidthBg", "()I", "setWidthBg", "(I)V", "beforeDismiss", "", "bindTextView", "bindView", "blurBackground", "blurBgResult", "isSuccess", "", "bitmap", "Landroid/graphics/Bitmap;", "color", "createView", "initCardRect", "cardRect", "", "initData", "isConstellationVisible", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onProfileVisibleLoaded", "Landroid/app/Activity;", "okClicked", "Lkotlin/Function0;", "onCanceled", "setViewDrawable", "url", "view", "show", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
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
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Card jdField_a_of_type_ComTencentMobileqqDataCard;
  @NotNull
  private OnLineStatusBlurBg jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusBlurBg;
  private StatusExtInfoObserver jdField_a_of_type_ComTencentMobileqqOnlinestatusConstellationStatusExtInfoObserver;
  private BaseApplication jdField_a_of_type_ComTencentQphoneBaseUtilBaseApplication;
  private String jdField_a_of_type_JavaLangString;
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
  
  public ConstellationView(@NotNull BaseActivity paramBaseActivity, @NotNull OnLineStatusBlurBg paramOnLineStatusBlurBg, @NotNull BaseStatusCardView.OnDismissCallback paramOnDismissCallback)
  {
    super((Context)paramBaseActivity, paramOnDismissCallback);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusBlurBg = paramOnLineStatusBlurBg;
    paramBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;
    Intrinsics.checkExpressionValueIsNotNull(paramBaseActivity, "activity.app");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseActivity;
    this.jdField_a_of_type_ComTencentQphoneBaseUtilBaseApplication = BaseApplication.context;
    paramBaseActivity = a();
    paramBaseActivity.findViewById(2131377366).setOnClickListener((View.OnClickListener)new ConstellationView..special..inlined.apply.lambda.1(this));
    this.jdField_b_of_type_AndroidViewView = paramBaseActivity.findViewById(2131365312);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener((View.OnClickListener)ConstellationView.1.2.a);
    this.jdField_d_of_type_AndroidViewView = paramBaseActivity;
    b();
    a();
    setContentView(this.jdField_d_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidViewView = this.jdField_d_of_type_AndroidViewView;
    paramBaseActivity = this.jdField_a_of_type_ComTencentQphoneBaseUtilBaseApplication;
    Intrinsics.checkExpressionValueIsNotNull(paramBaseActivity, "appContext");
    this.jdField_c_of_type_Int = AIOUtils.a(296.0F, paramBaseActivity.getResources());
    paramBaseActivity = this.jdField_a_of_type_ComTencentQphoneBaseUtilBaseApplication;
    Intrinsics.checkExpressionValueIsNotNull(paramBaseActivity, "appContext");
    int i = AIOUtils.a(211.0F, paramBaseActivity.getResources());
    float f1 = 12;
    float f2 = DeviceInfoUtil.a();
    paramBaseActivity = this.jdField_a_of_type_ComTencentQphoneBaseUtilBaseApplication;
    Intrinsics.checkExpressionValueIsNotNull(paramBaseActivity, "appContext");
    paramBaseActivity = BitmapManager.a(paramBaseActivity.getResources(), 2130841641, this.jdField_c_of_type_Int, i);
    if (paramBaseActivity != null)
    {
      paramBaseActivity = ImageUtil.d(paramBaseActivity, f1 * f2, this.jdField_c_of_type_Int, i);
      paramOnLineStatusBlurBg = this.jdField_a_of_type_ComTencentQphoneBaseUtilBaseApplication;
      Intrinsics.checkExpressionValueIsNotNull(paramOnLineStatusBlurBg, "appContext");
      this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = new BitmapDrawable(paramOnLineStatusBlurBg.getResources(), paramBaseActivity);
    }
    OnlineModulePushReceiverKt.a((Function0)new ConstellationView.3(this));
  }
  
  private final void a(Activity paramActivity, Function0<Unit> paramFunction01, Function0<Unit> paramFunction02)
  {
    boolean bool = a();
    if (QLog.isColorLevel()) {
      QLog.d("ConstellationView", 2, new Object[] { "onProfileVisibleLoaded: called. ", "constellationVisible: " + bool });
    }
    if (!bool)
    {
      paramActivity = DialogUtil.a((Context)paramActivity, 230, paramActivity.getResources().getString(2131698407), paramActivity.getResources().getString(2131698404), 2131698405, 2131698406, (DialogInterface.OnClickListener)new ConstellationView.onProfileVisibleLoaded.dialog.1(paramFunction01), (DialogInterface.OnClickListener)new ConstellationView.onProfileVisibleLoaded.dialog.2(paramFunction02));
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
    ProfileSettingUtils.Companion localCompanion = ProfileSettingUtils.a;
    Card localCard = this.jdField_a_of_type_ComTencentMobileqqDataCard;
    if (localCard == null) {
      Intrinsics.throwUninitializedPropertyAccessException("selfProfileCard");
    }
    return localCompanion.a(41609, localCard, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != 2;
  }
  
  private final boolean a(String paramString, ImageView paramImageView)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = ((Drawable)this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
    localURLDrawableOptions.mFailedDrawable = ((Drawable)this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
    if (paramImageView != null)
    {
      localURLDrawableOptions.mRequestWidth = paramImageView.getWidth();
      localURLDrawableOptions.mRequestHeight = paramImageView.getHeight();
    }
    CharSequence localCharSequence = (CharSequence)paramString;
    int i;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {
      i = 1;
    }
    while (i == 0)
    {
      paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "drawable");
      paramString.setTag(URLDrawableDecodeHandler.b(localURLDrawableOptions.mRequestWidth, localURLDrawableOptions.mRequestHeight, (int)(12 * DeviceInfoUtil.a())));
      paramString.setDecodeHandler(URLDrawableDecodeHandler.g);
      if (paramImageView != null) {
        paramImageView.setImageDrawable((Drawable)paramString);
      }
      if (paramString.getStatus() != 2)
      {
        return true;
        i = 0;
      }
      else
      {
        return false;
      }
    }
    if (paramImageView != null) {
      paramImageView.setImageDrawable((Drawable)this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
    }
    return false;
  }
  
  private final void b()
  {
    Card localCard = ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    Intrinsics.checkExpressionValueIsNotNull(localCard, "ProfileCardUtil.initCard…p, app.currentAccountUin)");
    this.jdField_a_of_type_ComTencentMobileqqDataCard = localCard;
    localCard = this.jdField_a_of_type_ComTencentMobileqqDataCard;
    if (localCard == null) {
      Intrinsics.throwUninitializedPropertyAccessException("selfProfileCard");
    }
    this.jdField_b_of_type_Int = ((int)localCard.lBirthday);
    localCard = this.jdField_a_of_type_ComTencentMobileqqDataCard;
    if (localCard == null) {
      Intrinsics.throwUninitializedPropertyAccessException("selfProfileCard");
    }
    this.jdField_a_of_type_Int = localCard.constellation;
    this.jdField_a_of_type_JavaLangString = NearbyProfileUtil.c(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusConstellationStatusExtInfoObserver = ((StatusExtInfoObserver)new ConstellationView.initData.1(this));
  }
  
  private final void c()
  {
    OnLineStatusBlurBg.BlurBgItem localBlurBgItem = new OnLineStatusBlurBg.BlurBgItem();
    BaseActivity localBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    if (localBaseActivity == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.BaseActivity");
    }
    localBlurBgItem.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = localBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusBlurBg.a(localBlurBgItem, (OnLineStatusBlurBg.OnLineStatusBlurBgListener)this);
  }
  
  private final void g()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentQphoneBaseUtilBaseApplication;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "appContext");
    localObject1 = ((BaseApplication)localObject1).getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "appContext.resources");
    int i;
    Object localObject2;
    if (this.jdField_a_of_type_Int != 0)
    {
      i = 1;
      if (i == 0) {
        break label160;
      }
      localObject2 = ((Resources)localObject1).getString(2131698411);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "res.getString(R.string.q…nstellation_select_part1)");
      localObject1 = ((Resources)localObject1).getString(2131698412);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "res.getString(R.string.q…nstellation_select_part2)");
      label66:
      TextView localTextView = this.e;
      if (localTextView != null) {
        localTextView.setText((CharSequence)localObject2);
      }
      localObject2 = this.f;
      if (localObject2 != null)
      {
        ((TextView)localObject2).setText((CharSequence)localObject1);
        ((TextView)localObject2).setClickable(true);
        ((TextView)localObject2).setOnClickListener((View.OnClickListener)new ConstellationView.bindTextView..inlined.apply.lambda.1(this, (String)localObject1));
        ((TextView)localObject2).setOnTouchListener((View.OnTouchListener)new UITools.MyViewAlphaOnTouchListener());
        if (!ThemeImageWrapper.isNightMode()) {
          break label193;
        }
        ((TextView)localObject2).setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130837509, 0);
      }
    }
    for (;;)
    {
      return;
      i = 0;
      break;
      label160:
      localObject2 = ((Resources)localObject1).getString(2131698409);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "res.getString(R.string.q…select_no_birthday_part1)");
      localObject1 = ((Resources)localObject1).getString(2131698410);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "res.getString(R.string.q…select_no_birthday_part2)");
      break label66;
      label193:
      ((TextView)localObject2).setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130837508, 0);
    }
  }
  
  @NotNull
  public final View a()
  {
    View localView = View.inflate((Context)BaseApplication.context, 2131561649, null);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131365226));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131365227));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131377732));
    this.e = ((TextView)localView.findViewById(2131377714));
    this.f = ((TextView)localView.findViewById(2131377709));
    this.g = ((TextView)localView.findViewById(2131365223));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131365224));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131370998));
    this.jdField_c_of_type_AndroidViewView = localView.findViewById(2131372301);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131371014));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378646));
    Intrinsics.checkExpressionValueIsNotNull(localView, "view");
    return localView;
  }
  
  @NotNull
  public final BaseActivity a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  }
  
  public final void a()
  {
    a(ConstellationUtilKt.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), this.jdField_a_of_type_AndroidWidgetImageView);
    boolean bool1;
    boolean bool2;
    if (this.jdField_a_of_type_Int != 0)
    {
      bool1 = true;
      if (!bool1) {
        break label413;
      }
      bool2 = a(ConstellationUtilKt.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), this.jdField_b_of_type_AndroidWidgetImageView);
      label45:
      if (QLog.isColorLevel()) {
        QLog.d("ConstellationView", 2, new Object[] { "bindView: called. ", "bgSuccessLoad: " + bool2 + "  hasBirthdaySet: " + bool1 });
      }
      if (!bool2) {
        break label418;
      }
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
    for (;;)
    {
      localObject1 = new Ref.IntRef();
      try
      {
        localObject2 = ConstellationUtilKt.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (QLog.isColorLevel()) {
          QLog.d("ConstellationView", 2, new Object[] { "bindView: called. ", "constellationStr: " + this.jdField_a_of_type_JavaLangString + ",  textColorFromSp: " + (String)localObject2 });
        }
        ((Ref.IntRef)localObject1).element = Color.parseColor((String)localObject2);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject2;
          ((Ref.IntRef)localObject1).element = -16777216;
          continue;
          ((Button)localObject1).setText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getText(2131694939));
          ((Button)localObject1).setEnabled(true);
          continue;
          ((Button)localObject1).setText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getText(2131694939));
          ((Button)localObject1).setEnabled(false);
        }
      }
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
        if (!bool1) {
          break label534;
        }
        if (!ConstellationUtilKt.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
          break label509;
        }
        ((Button)localObject1).setText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getText(2131693161));
        ((Button)localObject1).setEnabled(false);
      }
      g();
      return;
      bool1 = false;
      break;
      label413:
      bool2 = false;
      break label45;
      label418:
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
  }
  
  public void a(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    if ((paramInt1 == ConstellationLauncher.jdField_a_of_type_Int) && (paramIntent != null))
    {
      paramIntent = ConstellationViewKt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramIntent, this.jdField_a_of_type_JavaLangString);
      if (this.jdField_b_of_type_Int != ((Number)paramIntent.getFirst()).intValue()) {
        QQToast.a((Context)BaseApplication.context, 0, 2131691163, 0).a();
      }
      this.jdField_b_of_type_Int = ((Number)paramIntent.getFirst()).intValue();
      this.jdField_a_of_type_JavaLangString = ((String)paramIntent.getSecond());
      a();
    }
  }
  
  public void a(boolean paramBoolean, @Nullable Bitmap paramBitmap, int paramInt)
  {
    if ((paramBoolean) && (paramBitmap != null) && (this.jdField_d_of_type_AndroidViewView != null))
    {
      this.jdField_d_of_type_AndroidViewView.setBackgroundDrawable((Drawable)new BitmapDrawable(paramBitmap));
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
      paramArrayOfInt[0] = this.jdField_c_of_type_Int;
      localView = this.jdField_b_of_type_AndroidViewView;
      Intrinsics.checkExpressionValueIsNotNull(localView, "cardView");
      paramArrayOfInt[1] = AIOUtils.a(430.0F, localView.getResources());
    }
  }
  
  protected void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver((BusinessObserver)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusConstellationStatusExtInfoObserver);
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewBaseStatusCardView$OnDismissCallback.a(1040);
  }
  
  public void show()
  {
    View localView;
    if (ThemeUtil.isNowThemeIsNight(null, false, ""))
    {
      localView = this.jdField_b_of_type_AndroidViewView;
      if (localView != null) {
        localView.setBackgroundResource(2130846455);
      }
      a(false, null, Color.parseColor("#FF010101"));
      localView = this.jdField_c_of_type_AndroidViewView;
      if (localView != null) {
        localView.setVisibility(0);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver((BusinessObserver)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusConstellationStatusExtInfoObserver);
      OnlineStatusExtInfoServlet.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
      try
      {
        a(this.jdField_c_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        a(this.jdField_d_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        super.show();
        b(true);
        return;
        localView = this.jdField_b_of_type_AndroidViewView;
        if (localView != null) {
          localView.setBackgroundResource(2130846454);
        }
        c();
        localView = this.jdField_c_of_type_AndroidViewView;
        if (localView == null) {
          continue;
        }
        localView.setVisibility(8);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("ConstellationView", 2, new Object[] { "show: called. ", "", localException });
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.ConstellationView
 * JD-Core Version:    0.7.0.1
 */
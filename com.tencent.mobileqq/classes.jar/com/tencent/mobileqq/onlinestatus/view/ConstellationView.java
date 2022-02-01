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
  public static final ConstellationView.Companion a = new ConstellationView.Companion(null);
  private int A;
  private final AppRuntime B;
  private BaseApplication C;
  @NotNull
  private QBaseActivity D;
  @NotNull
  private OnLineStatusBlurBg E;
  private Card b;
  private BitmapDrawable c;
  private String d;
  private String e;
  private StatusExtInfoObserver f;
  private int g;
  private int h;
  private ImageView o;
  private ImageView p;
  private View q;
  private TextView r;
  private TextView s;
  private TextView t;
  private TextView u;
  private Button v;
  private TextView w;
  private TextView x;
  private TextView y;
  private final View z;
  
  public ConstellationView(@NotNull QBaseActivity paramQBaseActivity, @NotNull OnLineStatusBlurBg paramOnLineStatusBlurBg, @NotNull BaseStatusCardView.OnDismissCallback paramOnDismissCallback)
  {
    super((Context)paramQBaseActivity, paramOnDismissCallback);
    this.D = paramQBaseActivity;
    this.E = paramOnLineStatusBlurBg;
    paramQBaseActivity = this.D.getAppRuntime();
    Intrinsics.checkExpressionValueIsNotNull(paramQBaseActivity, "activity.getAppRuntime()");
    this.B = paramQBaseActivity;
    this.C = BaseApplication.context;
    paramQBaseActivity = a();
    paramQBaseActivity.findViewById(2131445148).setOnClickListener((View.OnClickListener)new ConstellationView..special..inlined.apply.lambda.1(this));
    this.j = paramQBaseActivity.findViewById(2131431349);
    this.j.setOnClickListener((View.OnClickListener)ConstellationView.1.2.a);
    this.z = paramQBaseActivity;
    d();
    b();
    setContentView(this.z);
    this.i = this.z;
    paramQBaseActivity = this.C;
    Intrinsics.checkExpressionValueIsNotNull(paramQBaseActivity, "appContext");
    this.A = Utils.a(296.0F, paramQBaseActivity.getResources());
    paramQBaseActivity = this.C;
    Intrinsics.checkExpressionValueIsNotNull(paramQBaseActivity, "appContext");
    int i = Utils.a(211.0F, paramQBaseActivity.getResources());
    float f1 = 12;
    float f2 = DeviceInfoUtil.A();
    paramQBaseActivity = this.C;
    Intrinsics.checkExpressionValueIsNotNull(paramQBaseActivity, "appContext");
    paramQBaseActivity = BitmapManager.a(paramQBaseActivity.getResources(), 2130842369, this.A, i);
    if (paramQBaseActivity != null)
    {
      paramQBaseActivity = BaseImageUtil.d(paramQBaseActivity, f1 * f2, this.A, i);
      paramOnLineStatusBlurBg = this.C;
      Intrinsics.checkExpressionValueIsNotNull(paramOnLineStatusBlurBg, "appContext");
      this.c = new BitmapDrawable(paramOnLineStatusBlurBg.getResources(), paramQBaseActivity);
    }
    if (Build.VERSION.SDK_INT >= 24) {
      CompletableFuture.runAsync((Runnable)new ConstellationView.3(this));
    }
  }
  
  private final void a(Activity paramActivity, Function0<Unit> paramFunction01, Function0<Unit> paramFunction02)
  {
    boolean bool = i();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("constellationVisible: ");
      localStringBuilder.append(bool);
      QLog.d("ConstellationView", 2, new Object[] { "onProfileVisibleLoaded: called. ", localStringBuilder.toString() });
    }
    if (!bool)
    {
      paramActivity = DialogUtil.a((Context)paramActivity, 230, paramActivity.getResources().getString(2131896413), paramActivity.getResources().getString(2131896410), 2131896411, 2131896412, (DialogInterface.OnClickListener)new ConstellationView.onProfileVisibleLoaded.dialog.1(paramFunction01), (DialogInterface.OnClickListener)new ConstellationView.onProfileVisibleLoaded.dialog.2(paramFunction02));
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
  
  private final boolean a(String paramString, ImageView paramImageView)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    Object localObject = this.c;
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
      paramString.setTag(URLDrawableHelper.a(localURLDrawableOptions.mRequestWidth, localURLDrawableOptions.mRequestHeight, (int)(12 * DeviceInfoUtil.A())));
      paramString.setDecodeHandler(URLDrawableHelper.c);
      if (paramImageView != null) {
        paramImageView.setImageDrawable((Drawable)paramString);
      }
      return paramString.getStatus() != 2;
    }
    if (paramImageView != null) {
      paramImageView.setImageDrawable((Drawable)this.c);
    }
    return false;
  }
  
  private final void d()
  {
    Object localObject = (IProfileCardUtil)QRoute.api(IProfileCardUtil.class);
    AppRuntime localAppRuntime = this.B;
    localObject = ((IProfileCardUtil)localObject).initCard(localAppRuntime, localAppRuntime.getCurrentAccountUin());
    Intrinsics.checkExpressionValueIsNotNull(localObject, "QRoute.api(IProfileCardU…p, app.currentAccountUin)");
    this.b = ((Card)localObject);
    localObject = this.b;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("selfProfileCard");
    }
    this.h = ((int)((Card)localObject).lBirthday);
    localObject = this.b;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("selfProfileCard");
    }
    this.g = ((Card)localObject).constellation;
    this.d = OnlineStatusUtil.b(this.g);
    this.f = ((StatusExtInfoObserver)new ConstellationView.initData.1(this));
  }
  
  private final void e()
  {
    OnLineStatusBlurBg.BlurBgItem localBlurBgItem = new OnLineStatusBlurBg.BlurBgItem();
    QBaseActivity localQBaseActivity = this.D;
    if (localQBaseActivity != null)
    {
      localBlurBgItem.a = localQBaseActivity;
      this.E.a(localBlurBgItem, (OnLineStatusBlurBg.OnLineStatusBlurBgListener)this);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
  }
  
  private final void f()
  {
    Object localObject1 = this.C;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "appContext");
    localObject1 = ((BaseApplication)localObject1).getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "appContext.resources");
    int i;
    if (this.g != 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      localObject2 = ((Resources)localObject1).getString(2131896417);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "res.getString(R.string.q…nstellation_select_part1)");
      localObject1 = ((Resources)localObject1).getString(2131896418);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "res.getString(R.string.q…nstellation_select_part2)");
    }
    else
    {
      localObject2 = ((Resources)localObject1).getString(2131896415);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "res.getString(R.string.q…select_no_birthday_part1)");
      localObject1 = ((Resources)localObject1).getString(2131896416);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "res.getString(R.string.q…select_no_birthday_part2)");
    }
    TextView localTextView = this.w;
    if (localTextView != null) {
      localTextView.setText((CharSequence)localObject2);
    }
    Object localObject2 = this.x;
    if (localObject2 != null)
    {
      ((TextView)localObject2).setText((CharSequence)localObject1);
      ((TextView)localObject2).setClickable(true);
      ((TextView)localObject2).setOnClickListener((View.OnClickListener)new ConstellationView.bindTextView..inlined.apply.lambda.1(this, (String)localObject1));
      ((TextView)localObject2).setOnTouchListener((View.OnTouchListener)new AutoStatusSelectView.MyViewAlphaOnTouchListener());
      if (ThemeImageWrapper.isNightMode())
      {
        ((TextView)localObject2).setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130837602, 0);
        return;
      }
      ((TextView)localObject2).setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130837601, 0);
    }
  }
  
  private final boolean i()
  {
    IProfileSettingApi localIProfileSettingApi = (IProfileSettingApi)QRoute.api(IProfileSettingApi.class);
    Card localCard = this.b;
    if (localCard == null) {
      Intrinsics.throwUninitializedPropertyAccessException("selfProfileCard");
    }
    return localIProfileSettingApi.getProfileSettingStateFromCard(41609, localCard) != 2;
  }
  
  @NotNull
  public final View a()
  {
    View localView = View.inflate((Context)BaseApplication.context, 2131627856, null);
    this.r = ((TextView)localView.findViewById(2131431250));
    this.s = ((TextView)localView.findViewById(2131431251));
    this.v = ((Button)localView.findViewById(2131445538));
    this.w = ((TextView)localView.findViewById(2131445518));
    this.x = ((TextView)localView.findViewById(2131445512));
    this.y = ((TextView)localView.findViewById(2131431247));
    this.o = ((ImageView)localView.findViewById(2131431248));
    this.p = ((ImageView)localView.findViewById(2131437907));
    this.q = localView.findViewById(2131439332);
    this.t = ((TextView)localView.findViewById(2131437924));
    this.u = ((TextView)localView.findViewById(2131446539));
    Intrinsics.checkExpressionValueIsNotNull(localView, "view");
    return localView;
  }
  
  public void a(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    if ((paramInt1 == ConstellationLauncher.a) && (paramIntent != null))
    {
      paramIntent = ConstellationViewKt.a(this.B, paramIntent, this.d);
      if (this.h != ((Number)paramIntent.getFirst()).intValue()) {
        QQToast.makeText((Context)BaseApplication.context, 0, 2131888029, 0).show();
      }
      this.h = ((Number)paramIntent.getFirst()).intValue();
      this.d = ((String)paramIntent.getSecond());
      b();
    }
  }
  
  public void a(boolean paramBoolean, @Nullable Bitmap paramBitmap, int paramInt)
  {
    if ((paramBoolean) && (paramBitmap != null))
    {
      View localView = this.z;
      if (localView != null)
      {
        localView.setBackgroundDrawable((Drawable)new BitmapDrawable(paramBitmap));
        return;
      }
    }
    this.z.setBackgroundColor(paramInt);
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
      paramArrayOfInt[0] = this.A;
      localView = this.j;
      Intrinsics.checkExpressionValueIsNotNull(localView, "cardView");
      paramArrayOfInt[1] = Utils.a(430.0F, localView.getResources());
    }
  }
  
  public final void b()
  {
    a(ConstellationUtilKt.b(this.B), this.o);
    boolean bool1;
    if (this.g != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if (bool1) {
      bool2 = a(ConstellationUtilKt.c(this.B), this.p);
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
      localObject1 = this.r;
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(0);
      }
      localObject1 = this.y;
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(0);
      }
      localObject1 = this.o;
      if (localObject1 != null) {
        ((ImageView)localObject1).setVisibility(0);
      }
      localObject1 = this.s;
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(0);
      }
    }
    else
    {
      localObject1 = this.r;
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(4);
      }
      localObject1 = this.y;
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(4);
      }
      localObject1 = this.o;
      if (localObject1 != null) {
        ((ImageView)localObject1).setVisibility(4);
      }
      localObject1 = this.s;
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(4);
      }
      localObject1 = this.p;
      if (localObject1 != null) {
        ((ImageView)localObject1).setImageDrawable((Drawable)this.c);
      }
    }
    Object localObject1 = new Ref.IntRef();
    try
    {
      localObject2 = ConstellationUtilKt.e(this.B);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("constellationStr: ");
        localStringBuilder.append(this.d);
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
    localObject2 = this.r;
    if (localObject2 != null)
    {
      ((TextView)localObject2).setText((CharSequence)this.d);
      ((TextView)localObject2).setTextColor(((Ref.IntRef)localObject1).element);
    }
    localObject2 = this.s;
    if (localObject2 != null)
    {
      ((TextView)localObject2).setText((CharSequence)this.e);
      ((TextView)localObject2).setTextColor(((Ref.IntRef)localObject1).element);
    }
    localObject2 = this.y;
    if (localObject2 != null)
    {
      ((TextView)localObject2).setText((CharSequence)ConstellationUtilKt.a());
      ((TextView)localObject2).setTextColor(((Ref.IntRef)localObject1).element);
    }
    localObject1 = this.v;
    if (localObject1 != null)
    {
      ((Button)localObject1).setOnClickListener((View.OnClickListener)new ConstellationView.bindView..inlined.apply.lambda.1(this, bool1));
      if (bool1)
      {
        if (ConstellationUtilKt.i(this.B))
        {
          ((Button)localObject1).setText(this.B.getApp().getText(2131890660));
          ((Button)localObject1).setEnabled(false);
        }
        else
        {
          ((Button)localObject1).setText(this.B.getApp().getText(2131892656));
          ((Button)localObject1).setEnabled(true);
        }
      }
      else
      {
        ((Button)localObject1).setText(this.B.getApp().getText(2131892656));
        ((Button)localObject1).setEnabled(false);
      }
    }
    f();
  }
  
  @NotNull
  public final QBaseActivity c()
  {
    return this.D;
  }
  
  protected void k()
  {
    this.B.unRegistObserver((BusinessObserver)this.f);
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    this.n.a(1040);
  }
  
  public void show()
  {
    View localView;
    if (QQTheme.isNowThemeIsNight())
    {
      localView = this.j;
      if (localView != null) {
        localView.setBackgroundResource(2130847806);
      }
      a(false, null, Color.parseColor("#FF010101"));
      localView = this.q;
      if (localView != null) {
        localView.setVisibility(0);
      }
    }
    else
    {
      localView = this.j;
      if (localView != null) {
        localView.setBackgroundResource(2130847805);
      }
      e();
      localView = this.q;
      if (localView != null) {
        localView.setVisibility(8);
      }
    }
    this.B.registObserver((BusinessObserver)this.f);
    OnlineStatusExtInfoServlet.a(this.B, this.d);
    try
    {
      a(this.t);
      a(this.u);
      super.show();
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ConstellationView", 2, new Object[] { "show: called. ", "", localException });
      }
    }
    e(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.ConstellationView
 * JD-Core Version:    0.7.0.1
 */
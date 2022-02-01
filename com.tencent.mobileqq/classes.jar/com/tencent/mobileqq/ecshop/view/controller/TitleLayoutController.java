package com.tencent.mobileqq.ecshop.view.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.ecshop.conf.EcshopConfBean.MenuConfBean;
import com.tencent.mobileqq.ecshop.conf.EcshopConfBean.TabConfBean;
import com.tencent.mobileqq.ecshop.report.ReportUtil;
import com.tencent.mobileqq.ecshop.utils.AppUtils;
import com.tencent.mobileqq.ecshop.view.EcshopMenuDialog;
import com.tencent.mobileqq.ecshop.view.EcshopMenuDialog.OnClickActionListener;
import com.tencent.mobileqq.ecshop.widget.JumpUtil;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.MiniAppLaunchListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.utils.FlymeOSStatusBarFontUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/ecshop/view/controller/TitleLayoutController;", "", "titleLayout", "Landroid/widget/LinearLayout;", "activity", "Landroid/app/Activity;", "reportData", "", "", "(Landroid/widget/LinearLayout;Landroid/app/Activity;Ljava/util/Map;)V", "getActivity", "()Landroid/app/Activity;", "mBackImg", "Landroid/widget/ImageView;", "mFaceImg", "mFaceLayout", "Landroid/view/View;", "mRightImg", "mTitleText", "Landroid/widget/TextView;", "getTitleLayout", "()Landroid/widget/LinearLayout;", "goToMenuPage", "", "tabConfBean", "Lcom/tencent/mobileqq/ecshop/conf/EcshopConfBean$TabConfBean;", "initBackView", "color", "", "initFaceView", "menuConfs", "", "Lcom/tencent/mobileqq/ecshop/conf/EcshopConfBean$MenuConfBean;", "initRightView", "initTitleView", "showMenuDialog", "updateTitlelayout", "params", "Lcom/tencent/mtt/hippy/common/HippyMap;", "Companion", "qqshop-feature-impl_release"}, k=1, mv={1, 1, 16})
public final class TitleLayoutController
{
  public static final TitleLayoutController.Companion a;
  @NotNull
  private final Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  @NotNull
  private final LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private final Map<String, String> jdField_a_of_type_JavaUtilMap;
  private ImageView b;
  private ImageView c;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqEcshopViewControllerTitleLayoutController$Companion = new TitleLayoutController.Companion(null);
  }
  
  public TitleLayoutController(@NotNull LinearLayout paramLinearLayout, @NotNull Activity paramActivity, @NotNull Map<String, String> paramMap)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = paramLinearLayout;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_JavaUtilMap = paramMap;
    paramLinearLayout = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131374333);
    Intrinsics.checkExpressionValueIsNotNull(paramLinearLayout, "titleLayout.findViewById(R.id.qq_shop_menu_img)");
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLinearLayout);
    paramLinearLayout = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131374334);
    Intrinsics.checkExpressionValueIsNotNull(paramLinearLayout, "titleLayout.findViewById(R.id.qq_shop_menu_layout)");
    this.jdField_a_of_type_AndroidViewView = paramLinearLayout;
    paramLinearLayout = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131374332);
    Intrinsics.checkExpressionValueIsNotNull(paramLinearLayout, "titleLayout.findViewById(R.id.qq_shop_back_img)");
    this.b = ((ImageView)paramLinearLayout);
    paramLinearLayout = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131374339);
    Intrinsics.checkExpressionValueIsNotNull(paramLinearLayout, "titleLayout.findViewById(R.id.qq_shop_right_img)");
    this.c = ((ImageView)paramLinearLayout);
    paramLinearLayout = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131374341);
    Intrinsics.checkExpressionValueIsNotNull(paramLinearLayout, "titleLayout.findViewById(R.id.qq_shop_title_text)");
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLinearLayout);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener((View.OnClickListener)TitleLayoutController.1.a);
    this.b.setOnClickListener((View.OnClickListener)new TitleLayoutController.2(this));
    this.c.setOnClickListener((View.OnClickListener)new TitleLayoutController.3(this));
    a(-1);
    b(-1);
    c(-1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundColor(0);
    FlymeOSStatusBarFontUtils.a(this.jdField_a_of_type_AndroidAppActivity, false);
  }
  
  private final void a(EcshopConfBean.TabConfBean paramTabConfBean)
  {
    int i = paramTabConfBean.jdField_b_of_type_Int;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return;
        }
        ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp((Context)this.jdField_a_of_type_AndroidAppActivity, ReportUtil.a(paramTabConfBean.jdField_b_of_type_JavaLangString, "tab"), 1035, (MiniAppLaunchListener)TitleLayoutController.goToMenuPage.1.a);
        return;
      }
      JumpUtil.b((Context)this.jdField_a_of_type_AndroidAppActivity);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("url", ReportUtil.a(paramTabConfBean.jdField_b_of_type_JavaLangString, "tab"));
    RouteUtils.a((Context)this.jdField_a_of_type_AndroidAppActivity, localIntent, "/base/browser");
  }
  
  private final void b(List<? extends EcshopConfBean.MenuConfBean> paramList)
  {
    paramList = EcshopMenuDialog.a(this.jdField_a_of_type_AndroidAppActivity, paramList, null, (EcshopMenuDialog.OnClickActionListener)new TitleLayoutController.showMenuDialog.menuDialog.1(this));
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    paramList.showAsDropDown((View)localImageView, localImageView.getWidth() / 2 - ViewUtils.a(152.0F) / 2 - ViewUtils.a(11.0F), ViewUtils.a(10.0F));
  }
  
  @NotNull
  public final Activity a()
  {
    return this.jdField_a_of_type_AndroidAppActivity;
  }
  
  @NotNull
  public final LinearLayout a()
  {
    return this.jdField_a_of_type_AndroidWidgetLinearLayout;
  }
  
  public final void a(int paramInt)
  {
    Drawable localDrawable = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840447);
    Intrinsics.checkExpressionValueIsNotNull(localDrawable, "activity.resources.getDr…awable.ie_arrow_left_nor)");
    if ((localDrawable instanceof SkinnableBitmapDrawable))
    {
      localDrawable = ((SkinnableBitmapDrawable)localDrawable).mutate2();
      Intrinsics.checkExpressionValueIsNotNull(localDrawable, "drawable.mutate2()");
    }
    else
    {
      localDrawable = localDrawable.mutate();
      Intrinsics.checkExpressionValueIsNotNull(localDrawable, "drawable.mutate()");
    }
    localDrawable.setColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
    this.b.setImageDrawable(localDrawable);
  }
  
  public final void a(@NotNull HippyMap paramHippyMap)
  {
    Intrinsics.checkParameterIsNotNull(paramHippyMap, "params");
    this.jdField_a_of_type_AndroidWidgetLinearLayout.post((Runnable)new TitleLayoutController.updateTitlelayout.1(this, paramHippyMap));
  }
  
  public final void a(@NotNull List<? extends EcshopConfBean.MenuConfBean> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "menuConfs");
    if ((((Collection)paramList).isEmpty() ^ true))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      Object localObject = AppUtils.a();
      String str = ((AppRuntime)localObject).getAccount();
      if (TextUtils.isEmpty((CharSequence)((AppRuntime)localObject).getAccount())) {
        return;
      }
      Drawable localDrawable = FaceDrawable.getDefaultDrawable(1, 3);
      if (localObject != null)
      {
        localObject = FaceDrawable.getFaceDrawable((AppInterface)localObject, 1, str, 3, localDrawable, localDrawable);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener((View.OnClickListener)new TitleLayoutController.initFaceView.1(this, paramList));
        this.jdField_a_of_type_AndroidWidgetImageView.post((Runnable)new TitleLayoutController.initFaceView.2(this));
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.common.app.AppInterface");
    }
  }
  
  public final void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramInt);
  }
  
  public final void c(int paramInt)
  {
    Drawable localDrawable = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130848560);
    Intrinsics.checkExpressionValueIsNotNull(localDrawable, "activity.resources.getDr…ne_icon_title_more_black)");
    if ((localDrawable instanceof SkinnableBitmapDrawable))
    {
      localDrawable = ((SkinnableBitmapDrawable)localDrawable).mutate2();
      Intrinsics.checkExpressionValueIsNotNull(localDrawable, "drawable.mutate2()");
    }
    else
    {
      localDrawable = localDrawable.mutate();
      Intrinsics.checkExpressionValueIsNotNull(localDrawable, "drawable.mutate()");
    }
    localDrawable.setColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
    this.c.setImageDrawable(localDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.controller.TitleLayoutController
 * JD-Core Version:    0.7.0.1
 */
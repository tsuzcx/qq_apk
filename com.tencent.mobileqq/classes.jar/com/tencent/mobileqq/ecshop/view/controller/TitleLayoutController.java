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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/ecshop/view/controller/TitleLayoutController;", "", "titleLayout", "Landroid/widget/LinearLayout;", "activity", "Landroid/app/Activity;", "reportData", "", "", "(Landroid/widget/LinearLayout;Landroid/app/Activity;Ljava/util/Map;)V", "getActivity", "()Landroid/app/Activity;", "bubbleController", "Lcom/tencent/mobileqq/ecshop/view/controller/BubbleController;", "mBackImg", "Landroid/widget/ImageView;", "mFaceImg", "mFaceLayout", "Landroid/view/View;", "mMenuRedPoint", "mRightImg", "mTitleText", "Landroid/widget/TextView;", "getTitleLayout", "()Landroid/widget/LinearLayout;", "goToMenuPage", "", "menuConfBean", "Lcom/tencent/mobileqq/ecshop/conf/EcshopConfBean$MenuConfBean;", "initBackView", "color", "", "initFaceView", "menuConfs", "", "needShowRedPoint", "", "needShowBubble", "initRightView", "initTitleView", "onDestroy", "showMenuDialog", "updateTitlelayout", "params", "Lcom/tencent/mtt/hippy/common/HippyMap;", "Companion", "qqshop-feature-impl_release"}, k=1, mv={1, 1, 16})
public final class TitleLayoutController
{
  public static final TitleLayoutController.Companion a = new TitleLayoutController.Companion(null);
  private ImageView b;
  private View c;
  private View d;
  private ImageView e;
  private ImageView f;
  private TextView g;
  private BubbleController h;
  @NotNull
  private final LinearLayout i;
  @NotNull
  private final Activity j;
  private final Map<String, String> k;
  
  public TitleLayoutController(@NotNull LinearLayout paramLinearLayout, @NotNull Activity paramActivity, @NotNull Map<String, String> paramMap)
  {
    this.i = paramLinearLayout;
    this.j = paramActivity;
    this.k = paramMap;
    paramLinearLayout = this.i.findViewById(2131442496);
    Intrinsics.checkExpressionValueIsNotNull(paramLinearLayout, "titleLayout.findViewById(R.id.qq_shop_menu_img)");
    this.b = ((ImageView)paramLinearLayout);
    paramLinearLayout = this.i.findViewById(2131442497);
    Intrinsics.checkExpressionValueIsNotNull(paramLinearLayout, "titleLayout.findViewById(R.id.qq_shop_menu_layout)");
    this.c = paramLinearLayout;
    paramLinearLayout = this.i.findViewById(2131442498);
    Intrinsics.checkExpressionValueIsNotNull(paramLinearLayout, "titleLayout.findViewById…id.qq_shop_menu_redpoint)");
    this.d = paramLinearLayout;
    paramLinearLayout = this.i.findViewById(2131442495);
    Intrinsics.checkExpressionValueIsNotNull(paramLinearLayout, "titleLayout.findViewById(R.id.qq_shop_back_img)");
    this.e = ((ImageView)paramLinearLayout);
    paramLinearLayout = this.i.findViewById(2131442502);
    Intrinsics.checkExpressionValueIsNotNull(paramLinearLayout, "titleLayout.findViewById(R.id.qq_shop_right_img)");
    this.f = ((ImageView)paramLinearLayout);
    paramLinearLayout = this.i.findViewById(2131442503);
    Intrinsics.checkExpressionValueIsNotNull(paramLinearLayout, "titleLayout.findViewById(R.id.qq_shop_title_text)");
    this.g = ((TextView)paramLinearLayout);
    this.i.setOnClickListener((View.OnClickListener)TitleLayoutController.1.a);
    this.e.setOnClickListener((View.OnClickListener)new TitleLayoutController.2(this));
    this.f.setOnClickListener((View.OnClickListener)new TitleLayoutController.3(this));
    a(-1);
    b(-1);
    c(-1);
    this.i.setBackgroundColor(0);
    FlymeOSStatusBarFontUtils.a(this.j, false);
  }
  
  private final void a(EcshopConfBean.MenuConfBean paramMenuConfBean)
  {
    int m = paramMenuConfBean.i;
    if (m != 0)
    {
      if (m != 1)
      {
        if (m != 2) {
          return;
        }
        ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp((Context)this.j, ReportUtil.a(paramMenuConfBean.d, "tab"), 1035, (MiniAppLaunchListener)TitleLayoutController.goToMenuPage.1.a);
        return;
      }
      JumpUtil.b((Context)this.j);
      this.d.setVisibility(8);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("url", ReportUtil.a(paramMenuConfBean.d, "tab"));
    RouteUtils.a((Context)this.j, localIntent, "/base/browser");
  }
  
  private final void a(List<? extends EcshopConfBean.MenuConfBean> paramList)
  {
    paramList = EcshopMenuDialog.a(this.j, paramList, null, (EcshopMenuDialog.OnClickActionListener)new TitleLayoutController.showMenuDialog.menuDialog.1(this));
    ImageView localImageView = this.b;
    paramList.showAsDropDown((View)localImageView, localImageView.getWidth() / 2 - ViewUtils.dip2px(152.0F) / 2 - ViewUtils.dip2px(11.0F), ViewUtils.dip2px(10.0F));
  }
  
  public final void a()
  {
    BubbleController localBubbleController = this.h;
    if (localBubbleController != null) {
      localBubbleController.b();
    }
  }
  
  public final void a(int paramInt)
  {
    Drawable localDrawable = this.j.getResources().getDrawable(2130841209);
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
    this.e.setImageDrawable(localDrawable);
  }
  
  public final void a(@NotNull HippyMap paramHippyMap)
  {
    Intrinsics.checkParameterIsNotNull(paramHippyMap, "params");
    this.i.post((Runnable)new TitleLayoutController.updateTitlelayout.1(this, paramHippyMap));
  }
  
  public final void a(@NotNull List<? extends EcshopConfBean.MenuConfBean> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "menuConfs");
    if ((((Collection)paramList).isEmpty() ^ true))
    {
      this.c.setVisibility(0);
      Object localObject = AppUtils.a();
      String str = ((AppRuntime)localObject).getAccount();
      if (TextUtils.isEmpty((CharSequence)((AppRuntime)localObject).getAccount())) {
        return;
      }
      Drawable localDrawable = FaceDrawable.getDefaultDrawable(1, 3);
      if (localObject != null)
      {
        localObject = FaceDrawable.getFaceDrawable((AppInterface)localObject, 1, str, 3, localDrawable, localDrawable);
        this.b.setImageDrawable((Drawable)localObject);
        this.b.setOnClickListener((View.OnClickListener)new TitleLayoutController.initFaceView.1(this, paramList));
        this.b.post((Runnable)new TitleLayoutController.initFaceView.2(this, paramBoolean1, paramBoolean2, paramList));
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.common.app.AppInterface");
    }
  }
  
  @NotNull
  public final LinearLayout b()
  {
    return this.i;
  }
  
  public final void b(int paramInt)
  {
    this.g.setTextColor(paramInt);
  }
  
  @NotNull
  public final Activity c()
  {
    return this.j;
  }
  
  public final void c(int paramInt)
  {
    Drawable localDrawable = this.j.getResources().getDrawable(2130850223);
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
    this.f.setImageDrawable(localDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.controller.TitleLayoutController
 * JD-Core Version:    0.7.0.1
 */
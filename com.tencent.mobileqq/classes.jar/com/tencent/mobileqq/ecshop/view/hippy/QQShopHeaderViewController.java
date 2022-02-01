package com.tencent.mobileqq.ecshop.view.hippy;

import android.content.Context;
import android.view.View;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@HippyController(name="ShopMsgView")
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/ecshop/view/hippy/QQShopHeaderViewController;", "Lcom/tencent/mtt/hippy/uimanager/HippyViewController;", "Lcom/tencent/mobileqq/ecshop/view/hippy/QQShopHeaderView;", "()V", "createViewImpl", "Landroid/view/View;", "context", "Landroid/content/Context;", "hippyMap", "Lcom/tencent/mtt/hippy/common/HippyMap;", "Companion", "qqshop-feature-impl_release"}, k=1, mv={1, 1, 16})
public final class QQShopHeaderViewController
  extends HippyViewController<QQShopHeaderView>
{
  @NotNull
  public static final String CLASS_NAME = "ShopMsgView";
  public static final QQShopHeaderViewController.Companion Companion = new QQShopHeaderViewController.Companion(null);
  private static final String TAG = "QQShopHeaderViewControl";
  
  @NotNull
  protected View createViewImpl(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    return (View)new QQShopHeaderView(paramContext);
  }
  
  @NotNull
  protected View createViewImpl(@NotNull Context paramContext, @Nullable HippyMap paramHippyMap)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    return (View)new QQShopHeaderView(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.hippy.QQShopHeaderViewController
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.xaction.view;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.xaction.api.IDecorView;
import com.tencent.xaction.api.ITimeline;
import com.tencent.xaction.api.IView;
import com.tencent.xaction.api.base.BaseAnim;
import com.tencent.xaction.api.data.ViewData;
import com.tencent.xaction.api.style.BorderStyle;
import com.tencent.xaction.api.style.Style;
import com.tencent.xaction.api.util.ScreenUnit;
import com.tencent.xaction.api.util.ScreenUnit.Companion;
import com.tencent.xaction.impl.BorderDrawable;
import com.tencent.xaction.impl.XAEngine;
import com.tencent.xaction.impl.XAEngine.Companion;
import com.tencent.xaction.impl.XATimeline;
import com.tencent.xaction.trigger.BaseTrigger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/view/XAEmptyView$Companion;", "", "()V", "bindAnim", "", "engine", "Lcom/tencent/xaction/impl/XAEngine;", "iview", "Lcom/tencent/xaction/api/IView;", "data", "Lcom/tencent/xaction/api/data/ViewData;", "bindStyle", "bindStyleAnim", "bindStyleLayout", "params", "Landroid/view/ViewGroup$MarginLayoutParams;", "view", "Landroid/view/View;", "setBcStyle", "bc", "", "hierarchy", "", "setBgStyle", "bg", "setDrawable", "borderStyle", "Lcom/tencent/xaction/api/style/BorderStyle;", "XActionEngine_release"}, k=1, mv={1, 1, 16})
public final class XAEmptyView$Companion
{
  private final void a(View paramView, BorderStyle paramBorderStyle)
  {
    Drawable localDrawable1 = paramView.getBackground();
    Drawable localDrawable2;
    if ((localDrawable1 instanceof BorderDrawable))
    {
      localDrawable2 = (Drawable)null;
      paramBorderStyle = localDrawable1;
      if (localDrawable2 != null) {
        break label57;
      }
      if (Build.VERSION.SDK_INT >= 16) {
        paramView.setBackground(paramBorderStyle);
      }
    }
    label57:
    do
    {
      return;
      paramBorderStyle = (Drawable)new BorderDrawable(paramBorderStyle);
      localDrawable2 = localDrawable1;
      break;
      paramBorderStyle = new LayerDrawable(new Drawable[] { localDrawable2, paramBorderStyle });
    } while (Build.VERSION.SDK_INT < 16);
    paramView.setBackground((Drawable)paramBorderStyle);
  }
  
  private final void a(ViewData paramViewData, ViewGroup.MarginLayoutParams paramMarginLayoutParams, View paramView)
  {
    if (paramViewData.getSt().getX() != -1.0F) {
      paramMarginLayoutParams.leftMargin = ScreenUnit.a.a(paramViewData.getSt().getX() + paramViewData.getSt().getMl());
    }
    if (paramViewData.getSt().getY() != -1.0F) {
      paramMarginLayoutParams.topMargin = ScreenUnit.a.a(paramViewData.getSt().getY() + paramViewData.getSt().getMt());
    }
    if (paramViewData.getSt().getW() != -1.0F) {
      paramMarginLayoutParams.width = ScreenUnit.a.a(paramViewData.getSt().getW());
    }
    if (paramViewData.getSt().getH() != -1.0F) {
      paramMarginLayoutParams.height = ScreenUnit.a.a(paramViewData.getSt().getH());
    }
    if ((paramViewData.getSt().getElev() != 0.0F) && (Build.VERSION.SDK_INT >= 21)) {
      paramView.setElevation(paramViewData.getSt().getElev());
    }
  }
  
  private final void a(XAEngine paramXAEngine, String paramString, int paramInt, View paramView)
  {
    if (TextUtils.isEmpty((CharSequence)paramString)) {}
    while (!StringsKt.contains$default((CharSequence)paramString, (CharSequence)"#", false, 2, null)) {
      return;
    }
    try
    {
      paramView.setBackgroundColor(Color.parseColor(paramString));
      return;
    }
    catch (Exception paramXAEngine)
    {
      paramXAEngine.printStackTrace();
    }
  }
  
  @SuppressLint({"NewApi"})
  private final void b(XAEngine paramXAEngine, String paramString, int paramInt, View paramView)
  {
    if (TextUtils.isEmpty((CharSequence)paramString)) {
      return;
    }
    XAEngine.Companion.a().execute((Runnable)new XAEmptyView.Companion.setBgStyle.1(paramString, paramXAEngine, paramView, paramInt));
  }
  
  public final void a(@NotNull XAEngine paramXAEngine, @NotNull IView paramIView, @Nullable ViewData paramViewData)
  {
    Intrinsics.checkParameterIsNotNull(paramXAEngine, "engine");
    Intrinsics.checkParameterIsNotNull(paramIView, "iview");
    View localView = paramIView.a().a();
    if ((paramViewData == null) || (localView == null)) {}
    for (;;)
    {
      return;
      Object localObject1 = paramViewData.getTr().iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (BaseTrigger)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          ((BaseTrigger)localObject2).setEngine(paramXAEngine);
          ((BaseTrigger)localObject2).monitor(paramViewData, paramIView);
        }
      }
      paramIView = paramViewData.getAnim().iterator();
      while (paramIView.hasNext())
      {
        localObject1 = (BaseAnim)paramIView.next();
        if (localObject1 != null)
        {
          ((BaseAnim)localObject1).init(localView, paramXAEngine);
          localObject2 = paramViewData.getTl();
          if (localObject2 != null) {
            ((XATimeline)localObject2).a((ITimeline)localObject1);
          }
        }
      }
    }
  }
  
  public final void b(@NotNull XAEngine paramXAEngine, @NotNull IView paramIView, @Nullable ViewData paramViewData)
  {
    Intrinsics.checkParameterIsNotNull(paramXAEngine, "engine");
    Intrinsics.checkParameterIsNotNull(paramIView, "iview");
    paramIView = paramIView.a().a();
    if ((paramIView == null) || (paramViewData == null) || (paramIView.getLayoutParams() == null)) {}
    while (!(paramIView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
      return;
    }
    Object localObject = paramIView.getLayoutParams();
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }
    localObject = (ViewGroup.MarginLayoutParams)localObject;
    ((Companion)this).a(paramViewData, (ViewGroup.MarginLayoutParams)localObject, paramIView);
    paramIView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    ((Companion)this).a(paramXAEngine, paramViewData.getSt().getBc(), paramViewData.getSt().getHierarchy(), paramIView);
    ((Companion)this).b(paramXAEngine, paramViewData.getSt().getBg(), paramViewData.getSt().getHierarchy(), paramIView);
    paramIView.setAlpha(paramViewData.getSt().getOp());
    if (paramViewData.getSt().getVi()) {
      paramIView.setVisibility(0);
    }
    for (;;)
    {
      paramXAEngine = new BorderStyle();
      paramXAEngine.setStyle(paramViewData);
      ((Companion)this).a(paramIView, paramXAEngine);
      paramIView.invalidate();
      return;
      paramIView.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.view.XAEmptyView.Companion
 * JD-Core Version:    0.7.0.1
 */
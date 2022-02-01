package com.tencent.xaction.view;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.xaction.api.IDecorView;
import com.tencent.xaction.api.ITimeline;
import com.tencent.xaction.api.IView;
import com.tencent.xaction.api.base.BaseAnim;
import com.tencent.xaction.api.data.ViewData;
import com.tencent.xaction.api.style.BorderStyle;
import com.tencent.xaction.api.style.Style;
import com.tencent.xaction.api.util.ScreenUnit;
import com.tencent.xaction.api.util.ScreenUnit.Companion;
import com.tencent.xaction.helper.ViewHelper;
import com.tencent.xaction.impl.BorderDrawable;
import com.tencent.xaction.impl.XAEngine;
import com.tencent.xaction.impl.XAEngine.Companion;
import com.tencent.xaction.impl.XATimeline;
import com.tencent.xaction.openapi.api.IXAEngine;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/view/XAEmptyView$Companion;", "", "()V", "bindAnim", "", "engine", "Lcom/tencent/xaction/impl/XAEngine;", "iview", "Lcom/tencent/xaction/api/IView;", "data", "Lcom/tencent/xaction/api/data/ViewData;", "bindStyle", "bindStyleAnim", "bindStyleLayout", "params", "Landroid/view/ViewGroup$MarginLayoutParams;", "view", "Landroid/view/View;", "getLayoutPxValue", "", "stValue", "defaultValue", "screenValue", "setBcStyle", "bc", "", "hierarchy", "setBgStyle", "bg", "setDrawable", "borderStyle", "Lcom/tencent/xaction/api/style/BorderStyle;", "XActionCore_release"}, k=1, mv={1, 1, 16})
public final class XAEmptyView$Companion
{
  private final int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == -3) {
      return -2;
    }
    if (paramInt1 == -2) {
      return paramInt3;
    }
    if (paramInt1 == -4) {
      return -1;
    }
    return ScreenUnit.a.a(paramInt1, paramInt2);
  }
  
  private final void a(View paramView, BorderStyle paramBorderStyle)
  {
    Object localObject = paramView.getBackground();
    if ((localObject instanceof BorderDrawable))
    {
      paramBorderStyle = (Drawable)null;
    }
    else
    {
      Drawable localDrawable = (Drawable)new BorderDrawable(paramBorderStyle);
      paramBorderStyle = (BorderStyle)localObject;
      localObject = localDrawable;
    }
    if (paramBorderStyle == null)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        paramView.setBackground((Drawable)localObject);
      }
    }
    else
    {
      paramBorderStyle = new LayerDrawable(new Drawable[] { paramBorderStyle, localObject });
      if (Build.VERSION.SDK_INT >= 16) {
        paramView.setBackground((Drawable)paramBorderStyle);
      }
    }
  }
  
  private final void a(ViewData paramViewData, ViewGroup.MarginLayoutParams paramMarginLayoutParams, View paramView)
  {
    paramViewData = paramViewData.getSt();
    paramMarginLayoutParams.leftMargin = ScreenUnit.a.a(paramViewData.getX(), paramViewData.getMl(), paramMarginLayoutParams.leftMargin);
    paramMarginLayoutParams.topMargin = ScreenUnit.a.a(paramViewData.getY(), paramViewData.getMt(), paramMarginLayoutParams.topMargin);
    paramMarginLayoutParams.rightMargin = ScreenUnit.a.a(paramViewData.getMr(), paramMarginLayoutParams.rightMargin);
    paramMarginLayoutParams.bottomMargin = ScreenUnit.a.a(paramViewData.getMb(), paramMarginLayoutParams.bottomMargin);
    Companion localCompanion = (Companion)this;
    paramMarginLayoutParams.width = localCompanion.a(paramViewData.getW(), paramMarginLayoutParams.width, (int)ScreenUnit.a.c());
    paramMarginLayoutParams.height = localCompanion.a(paramViewData.getH(), paramMarginLayoutParams.height, (int)ScreenUnit.a.d());
    if (((paramMarginLayoutParams instanceof RelativeLayout.LayoutParams)) && (paramViewData.getAlign() != ScreenUnit.a.a()))
    {
      if ((paramViewData.getAlign() & 0x1) == 1) {
        ((RelativeLayout.LayoutParams)paramMarginLayoutParams).addRule(9);
      }
      if ((paramViewData.getAlign() & 0x2) == 2) {
        ((RelativeLayout.LayoutParams)paramMarginLayoutParams).addRule(10);
      }
      if ((paramViewData.getAlign() & 0x4) == 4) {
        ((RelativeLayout.LayoutParams)paramMarginLayoutParams).addRule(11);
      }
      if ((paramViewData.getAlign() & 0x8) == 8) {
        ((RelativeLayout.LayoutParams)paramMarginLayoutParams).addRule(12);
      }
      if ((paramViewData.getAlign() & 0x10) == 16) {
        ((RelativeLayout.LayoutParams)paramMarginLayoutParams).addRule(13);
      }
      if ((paramViewData.getAlign() & 0x20) == 32) {
        ((RelativeLayout.LayoutParams)paramMarginLayoutParams).addRule(14);
      }
      if ((paramViewData.getAlign() & 0x40) == 64) {
        ((RelativeLayout.LayoutParams)paramMarginLayoutParams).addRule(15);
      }
    }
    if ((paramViewData.getElev() > 0.0F) && (Build.VERSION.SDK_INT >= 21)) {
      paramView.setElevation(paramViewData.getElev());
    }
    paramView.setPadding(ScreenUnit.a.a(paramViewData.getPl(), paramView.getPaddingLeft()), ScreenUnit.a.a(paramViewData.getPt(), paramView.getPaddingTop()), ScreenUnit.a.a(paramViewData.getPr(), paramView.getPaddingRight()), ScreenUnit.a.a(paramViewData.getPb(), paramView.getPaddingBottom()));
  }
  
  private final void a(XAEngine paramXAEngine, String paramString, int paramInt, View paramView)
  {
    paramXAEngine = (CharSequence)paramString;
    if (TextUtils.isEmpty(paramXAEngine)) {
      return;
    }
    if (StringsKt.contains$default(paramXAEngine, (CharSequence)"#", false, 2, null)) {
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
  }
  
  public final void a(@NotNull XAEngine paramXAEngine, @NotNull IView paramIView, @Nullable ViewData paramViewData)
  {
    Intrinsics.checkParameterIsNotNull(paramXAEngine, "engine");
    Intrinsics.checkParameterIsNotNull(paramIView, "iview");
    View localView = paramIView.getDecor().b();
    if (paramViewData == null) {
      return;
    }
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
    if (localView == null) {
      return;
    }
    paramIView = paramViewData.getAnim().iterator();
    while (paramIView.hasNext())
    {
      localObject1 = (BaseAnim)paramIView.next();
      if (localObject1 != null)
      {
        ((BaseAnim)localObject1).init(localView, (IXAEngine)paramXAEngine);
        localObject2 = paramViewData.getTl();
        if (localObject2 != null) {
          ((XATimeline)localObject2).a((ITimeline)localObject1);
        }
      }
    }
  }
  
  @SuppressLint({"NewApi"})
  public final void a(@NotNull XAEngine paramXAEngine, @NotNull String paramString, int paramInt, @NotNull View paramView, @NotNull ViewData paramViewData)
  {
    Intrinsics.checkParameterIsNotNull(paramXAEngine, "engine");
    Intrinsics.checkParameterIsNotNull(paramString, "bg");
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    Intrinsics.checkParameterIsNotNull(paramViewData, "data");
    if (TextUtils.isEmpty((CharSequence)paramString)) {
      return;
    }
    XAEngine.Companion.a().execute((Runnable)new XAEmptyView.Companion.setBgStyle.1(paramString, paramXAEngine, paramView, paramViewData, paramInt));
  }
  
  public final void b(@NotNull XAEngine paramXAEngine, @NotNull IView paramIView, @Nullable ViewData paramViewData)
  {
    Intrinsics.checkParameterIsNotNull(paramXAEngine, "engine");
    Intrinsics.checkParameterIsNotNull(paramIView, "iview");
    Companion localCompanion = (Companion)this;
    localCompanion.c(paramXAEngine, paramIView, paramViewData);
    localCompanion.a(paramXAEngine, paramIView, paramViewData);
  }
  
  public final void c(@NotNull XAEngine paramXAEngine, @NotNull IView paramIView, @Nullable ViewData paramViewData)
  {
    Intrinsics.checkParameterIsNotNull(paramXAEngine, "engine");
    Intrinsics.checkParameterIsNotNull(paramIView, "iview");
    paramIView = paramIView.getDecor().b();
    if ((paramIView != null) && (paramViewData != null))
    {
      if (paramIView.getLayoutParams() == null) {
        return;
      }
      if (!(paramIView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
        return;
      }
      Object localObject = paramIView.getLayoutParams();
      if (localObject != null)
      {
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localObject;
        localObject = (Companion)this;
        ((Companion)localObject).a(paramViewData, localMarginLayoutParams, paramIView);
        ((Companion)localObject).a(paramXAEngine, paramViewData.getSt().getBc(), paramViewData.getSt().getHierarchy(), paramIView);
        ((Companion)localObject).a(paramXAEngine, paramViewData.getSt().getBg(), paramViewData.getSt().getHierarchy(), paramIView, paramViewData);
        paramIView.setAlpha(paramViewData.getSt().getOp());
        if (paramViewData.getSt().getVi()) {
          paramIView.setVisibility(0);
        } else {
          paramIView.setVisibility(4);
        }
        paramIView.setRotation(ScreenUnit.a.b(paramViewData.getSt().getRz() * 1.0F, paramIView.getRotation()));
        paramIView.setRotationX(ScreenUnit.a.b(paramViewData.getSt().getRx() * 1.0F, paramIView.getRotationX()));
        paramIView.setRotationY(ScreenUnit.a.b(paramViewData.getSt().getRy() * 1.0F, paramIView.getRotationY()));
        paramIView.setScaleX(ScreenUnit.a.b(paramViewData.getSt().getSx(), paramIView.getScaleX()));
        paramIView.setScaleY(ScreenUnit.a.b(paramViewData.getSt().getSy(), paramIView.getScaleY()));
        if (Build.VERSION.SDK_INT >= 21) {
          ViewHelper.a.a(paramIView, ScreenUnit.a.a(paramViewData.getSt().getRad(), 0), 0);
        }
        paramXAEngine = new BorderStyle();
        paramXAEngine.setStyle(paramViewData);
        ((Companion)localObject).a(paramIView, paramXAEngine);
        paramIView.invalidate();
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.view.XAEmptyView.Companion
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.xaction.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tencent.xaction.api.IView;
import com.tencent.xaction.api.base.DecorView;
import com.tencent.xaction.api.data.ViewData;
import com.tencent.xaction.impl.XAEngine;
import com.tencent.xaction.impl.XATimeline;
import com.tencent.xaction.log.QLog;
import com.tencent.xaction.openapi.api.IXAEngine;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/view/ComponentDecorView;", "Lcom/tencent/xaction/api/base/DecorView;", "component", "Lcom/tencent/xaction/view/Component;", "xaEngine", "Lcom/tencent/xaction/impl/XAEngine;", "(Lcom/tencent/xaction/view/Component;Lcom/tencent/xaction/impl/XAEngine;)V", "getComponent", "()Lcom/tencent/xaction/view/Component;", "setComponent", "(Lcom/tencent/xaction/view/Component;)V", "getXaEngine", "()Lcom/tencent/xaction/impl/XAEngine;", "setXaEngine", "(Lcom/tencent/xaction/impl/XAEngine;)V", "setStyle", "", "viewData", "Lcom/tencent/xaction/api/data/ViewData;", "XActionCore_release"}, k=1, mv={1, 1, 16})
public final class ComponentDecorView
  extends DecorView
{
  @NotNull
  private Component a;
  @NotNull
  private XAEngine b;
  
  public ComponentDecorView(@NotNull Component paramComponent, @NotNull XAEngine paramXAEngine)
  {
    super((IView)paramComponent);
    this.a = paramComponent;
    this.b = paramXAEngine;
    a((IXAEngine)this.b);
  }
  
  public void setStyle(@NotNull ViewData paramViewData)
  {
    Intrinsics.checkParameterIsNotNull(paramViewData, "viewData");
    a(paramViewData);
    Object localObject2 = null;
    Object localObject3 = (View)null;
    if (this.a.getCData().getViews() != null)
    {
      paramViewData = this.a.getCData().getViews();
      if (paramViewData == null) {
        Intrinsics.throwNpe();
      }
      if (paramViewData.size() == 0) {
        return;
      }
      paramViewData = this.a.getCData().getViews();
      if (paramViewData != null) {
        localObject1 = Integer.valueOf(paramViewData.size());
      } else {
        localObject1 = null;
      }
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      paramViewData = (ViewData)localObject3;
      if (((Integer)localObject1).intValue() > 0) {
        if (Intrinsics.areEqual(this.a.getCData().getGt(), "frame"))
        {
          paramViewData = (View)new FrameLayout(this.b.getContext());
        }
        else if (!Intrinsics.areEqual(this.a.getCData().getGt(), "relative"))
        {
          paramViewData = (ViewData)localObject3;
          if (!TextUtils.isEmpty((CharSequence)this.a.getCData().getGt())) {}
        }
        else
        {
          paramViewData = (View)new RelativeLayout(this.b.getContext());
        }
      }
      Object localObject1 = this.a.getCData().getViews();
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      localObject3 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject1 = (ViewData)((Iterator)localObject3).next();
        if (((ViewData)localObject1).getComptId() == this.a.getCData().getId())
        {
          paramViewData = new StringBuilder();
          paramViewData.append("component 出现循环嵌套，请检查 comptId：");
          paramViewData.append(((ViewData)localObject1).getComptId());
          paramViewData.append(" \n cData:");
          paramViewData.append(this.a.getCData());
          QLog.a("Component", 1, paramViewData.toString(), null);
          return;
        }
      }
      this.a.getViewList().clear();
      localObject3 = this.b;
      localObject1 = localObject2;
      if ((paramViewData instanceof ViewGroup)) {
        localObject1 = (ViewGroup)paramViewData;
      }
      localObject2 = this.a.getCData().getViews();
      if (localObject2 == null) {
        Intrinsics.throwNpe();
      }
      ((XAEngine)localObject3).data2View((ViewGroup)localObject1, (ArrayList)localObject2, this.a.getViewList(), this.b.getAnimTimeline().a());
      localObject1 = paramViewData;
      if (this.a.getViewList().size() == 1)
      {
        localObject1 = paramViewData;
        if (paramViewData == null)
        {
          localObject1 = this.a.getViewList().get(0);
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "component.viewList[0]");
          localObject2 = (IView)localObject1;
          localObject1 = paramViewData;
          if ((localObject2 instanceof View)) {
            localObject1 = (View)localObject2;
          }
        }
      }
      a((View)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.view.ComponentDecorView
 * JD-Core Version:    0.7.0.1
 */
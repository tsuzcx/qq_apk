package com.tencent.xaction.api.base;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.xaction.api.IDecorView;
import com.tencent.xaction.api.ITimeline;
import com.tencent.xaction.api.IView;
import com.tencent.xaction.api.data.ViewData;
import com.tencent.xaction.impl.XAEngine;
import com.tencent.xaction.impl.XAEngine.Companion;
import com.tencent.xaction.impl.XATimeline;
import com.tencent.xaction.openapi.api.IXAEngine;
import com.tencent.xaction.view.XAEmptyView;
import com.tencent.xaction.view.XAEmptyView.Companion;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/api/base/DecorView;", "Lcom/tencent/xaction/api/IDecorView;", "", "iView", "Lcom/tencent/xaction/api/IView;", "(Lcom/tencent/xaction/api/IView;)V", "data", "Lcom/tencent/xaction/api/data/ViewData;", "getData", "()Lcom/tencent/xaction/api/data/ViewData;", "setData", "(Lcom/tencent/xaction/api/data/ViewData;)V", "value", "Landroid/graphics/drawable/Drawable;", "drawable", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "setDrawable", "(Landroid/graphics/drawable/Drawable;)V", "drawableImpl", "engine", "Lcom/tencent/xaction/openapi/api/IXAEngine;", "getEngine", "()Lcom/tencent/xaction/openapi/api/IXAEngine;", "setEngine", "(Lcom/tencent/xaction/openapi/api/IXAEngine;)V", "getIView", "()Lcom/tencent/xaction/api/IView;", "setIView", "isStyle", "", "isStyle$XActionCore_release", "()Z", "setStyle$XActionCore_release", "(Z)V", "linkViews", "Ljava/util/ArrayList;", "Landroid/view/View;", "Lkotlin/collections/ArrayList;", "proxyView", "getProxyView", "()Landroid/view/View;", "setProxyView", "(Landroid/view/View;)V", "bindData", "", "destroy", "getProxy", "getStyle", "init", "viewLayout", "Landroid/view/ViewGroup;", "linkAnim", "anims", "Lcom/tencent/xaction/api/base/BaseAnim;", "timeline", "Lcom/tencent/xaction/impl/XATimeline;", "setProxy", "view", "setStyle", "viewData", "stateNotify", "status", "", "XActionCore_release"}, k=1, mv={1, 1, 16})
public class DecorView
  implements IDecorView, Cloneable
{
  @Nullable
  private IXAEngine a;
  @Nullable
  private ViewData b;
  @Nullable
  private IView c;
  @Nullable
  private View d;
  private ArrayList<View> e;
  private boolean f;
  private transient Drawable g;
  
  public DecorView(@Nullable IView paramIView)
  {
    this.c = paramIView;
    if ((paramIView instanceof View)) {
      paramIView = (View)paramIView;
    } else {
      paramIView = null;
    }
    this.d = paramIView;
    this.f = true;
  }
  
  public void a()
  {
    if (this.b != null)
    {
      if (this.a == null) {
        return;
      }
      IView localIView;
      if (this.f)
      {
        localCompanion = XAEmptyView.a;
        localObject = this.a;
        if (localObject != null)
        {
          localObject = (XAEngine)localObject;
          localIView = this.c;
          if (localIView == null) {
            Intrinsics.throwNpe();
          }
          localCompanion.c((XAEngine)localObject, localIView, this.b);
        }
        else
        {
          throw new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.impl.XAEngine");
        }
      }
      XAEmptyView.Companion localCompanion = XAEmptyView.a;
      Object localObject = this.a;
      if (localObject != null)
      {
        localObject = (XAEngine)localObject;
        localIView = this.c;
        if (localIView == null) {
          Intrinsics.throwNpe();
        }
        localCompanion.a((XAEngine)localObject, localIView, this.b);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.impl.XAEngine");
    }
  }
  
  protected final void a(@Nullable View paramView)
  {
    this.d = paramView;
  }
  
  public void a(@Nullable View paramView, boolean paramBoolean)
  {
    this.f = paramBoolean;
    b(paramView);
  }
  
  public final void a(@Nullable ViewData paramViewData)
  {
    this.b = paramViewData;
  }
  
  public final void a(@Nullable IXAEngine paramIXAEngine)
  {
    this.a = paramIXAEngine;
  }
  
  public void a(@NotNull IXAEngine paramIXAEngine, @Nullable ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramIXAEngine, "engine");
    this.a = paramIXAEngine;
    if (b() != null)
    {
      paramIXAEngine = this.b;
      if (paramIXAEngine != null)
      {
        if (paramIXAEngine == null) {
          Intrinsics.throwNpe();
        }
        if ((!paramIXAEngine.getTemplate()) && (paramViewGroup != null)) {
          paramViewGroup.addView(b());
        }
      }
    }
  }
  
  public final void a(@NotNull String paramString, @NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "status");
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    Object localObject1 = this.b;
    if (localObject1 != null)
    {
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      if (((ViewData)localObject1).getTag() == null)
      {
        localObject1 = this.b;
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        localObject1 = String.valueOf(((ViewData)localObject1).getId());
      }
      else
      {
        localObject1 = this.b;
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        localObject2 = ((ViewData)localObject1).getTag();
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          Intrinsics.throwNpe();
          localObject1 = localObject2;
        }
      }
      Object localObject2 = this.a;
      if (localObject2 != null) {
        XAEngine.Companion.a((String)localObject1, paramString, paramView, (IXAEngine)localObject2);
      }
    }
  }
  
  public void a(@NotNull ArrayList<View> paramArrayList, @NotNull ArrayList<BaseAnim> paramArrayList1, @NotNull XATimeline paramXATimeline)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "linkViews");
    Intrinsics.checkParameterIsNotNull(paramArrayList1, "anims");
    Intrinsics.checkParameterIsNotNull(paramXATimeline, "timeline");
    this.e = paramArrayList;
    if (this.a != null)
    {
      if (paramArrayList1.size() == 0) {
        return;
      }
      long l1 = 0L;
      paramArrayList = this.e;
      if (paramArrayList == null) {
        Intrinsics.throwNpe();
      }
      paramArrayList = ((Iterable)paramArrayList).iterator();
      if (paramArrayList.hasNext())
      {
        View localView = (View)paramArrayList.next();
        Iterator localIterator = paramArrayList1.iterator();
        Object localObject;
        for (long l2 = l1;; l2 += ((ViewData)localObject).getLinkDelay())
        {
          l1 = l2;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = ((BaseAnim)localIterator.next()).clone();
          ((BaseAnim)localObject).setDelay(((BaseAnim)localObject).getDelay() + l2);
          IXAEngine localIXAEngine = this.a;
          if (localIXAEngine == null) {
            Intrinsics.throwNpe();
          }
          ((BaseAnim)localObject).init(localView, localIXAEngine);
          paramXATimeline.a((ITimeline)localObject);
          localObject = this.b;
          if (localObject == null) {
            Intrinsics.throwNpe();
          }
        }
      }
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  @Nullable
  public View b()
  {
    return this.d;
  }
  
  public final void b(@Nullable View paramView)
  {
    this.d = paramView;
    a();
  }
  
  public void c()
  {
    this.a = ((IXAEngine)null);
  }
  
  @NotNull
  public Object clone()
  {
    return super.clone();
  }
  
  @Nullable
  public final IXAEngine d()
  {
    return this.a;
  }
  
  @Nullable
  public final ViewData e()
  {
    return this.b;
  }
  
  @Nullable
  public Drawable getDrawable()
  {
    return this.g;
  }
  
  @Nullable
  public ViewData getStyle()
  {
    return this.b;
  }
  
  public void setDrawable(@Nullable Drawable paramDrawable)
  {
    this.g = paramDrawable;
  }
  
  public void setStyle(@NotNull ViewData paramViewData)
  {
    Intrinsics.checkParameterIsNotNull(paramViewData, "viewData");
    this.b = paramViewData;
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.api.base.DecorView
 * JD-Core Version:    0.7.0.1
 */
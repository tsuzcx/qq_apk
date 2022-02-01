package com.tencent.xaction.api.base;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.xaction.api.IDecorView;
import com.tencent.xaction.api.IView;
import com.tencent.xaction.api.data.ViewData;
import com.tencent.xaction.impl.XAEngine;
import com.tencent.xaction.view.XAEmptyView;
import com.tencent.xaction.view.XAEmptyView.Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/api/base/DecorView;", "Lcom/tencent/xaction/api/IDecorView;", "iView", "Lcom/tencent/xaction/api/IView;", "(Lcom/tencent/xaction/api/IView;)V", "data", "Lcom/tencent/xaction/api/data/ViewData;", "getData", "()Lcom/tencent/xaction/api/data/ViewData;", "setData", "(Lcom/tencent/xaction/api/data/ViewData;)V", "value", "Landroid/graphics/drawable/Drawable;", "drawable", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "setDrawable", "(Landroid/graphics/drawable/Drawable;)V", "drawableImpl", "engine", "Lcom/tencent/xaction/impl/XAEngine;", "getEngine", "()Lcom/tencent/xaction/impl/XAEngine;", "setEngine", "(Lcom/tencent/xaction/impl/XAEngine;)V", "isStyle", "", "proxyView", "Landroid/view/View;", "bindData", "", "getProxy", "getStyle", "init", "viewLayout", "Landroid/view/ViewGroup;", "setProxy", "view", "setStyle", "viewData", "XActionEngine_release"}, k=1, mv={1, 1, 16})
public class DecorView
  implements IDecorView
{
  private transient Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private View jdField_a_of_type_AndroidViewView;
  private IView jdField_a_of_type_ComTencentXactionApiIView;
  @Nullable
  private ViewData jdField_a_of_type_ComTencentXactionApiDataViewData;
  @Nullable
  private XAEngine jdField_a_of_type_ComTencentXactionImplXAEngine;
  private boolean jdField_a_of_type_Boolean;
  
  public DecorView(@Nullable IView paramIView)
  {
    this.jdField_a_of_type_ComTencentXactionApiIView = paramIView;
    if ((paramIView instanceof View)) {}
    for (paramIView = (View)paramIView;; paramIView = null)
    {
      this.jdField_a_of_type_AndroidViewView = paramIView;
      this.jdField_a_of_type_Boolean = true;
      return;
    }
  }
  
  @Nullable
  public Drawable a()
  {
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  @Nullable
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  @Nullable
  public final XAEngine a()
  {
    return this.jdField_a_of_type_ComTencentXactionImplXAEngine;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentXactionApiDataViewData == null) || (this.jdField_a_of_type_AndroidViewView == null)) {
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      localCompanion = XAEmptyView.a;
      localXAEngine = this.jdField_a_of_type_ComTencentXactionImplXAEngine;
      if (localXAEngine == null) {
        Intrinsics.throwNpe();
      }
      localIView = this.jdField_a_of_type_ComTencentXactionApiIView;
      if (localIView == null) {
        Intrinsics.throwNpe();
      }
      localCompanion.b(localXAEngine, localIView, this.jdField_a_of_type_ComTencentXactionApiDataViewData);
    }
    XAEmptyView.Companion localCompanion = XAEmptyView.a;
    XAEngine localXAEngine = this.jdField_a_of_type_ComTencentXactionImplXAEngine;
    if (localXAEngine == null) {
      Intrinsics.throwNpe();
    }
    IView localIView = this.jdField_a_of_type_ComTencentXactionApiIView;
    if (localIView == null) {
      Intrinsics.throwNpe();
    }
    localCompanion.a(localXAEngine, localIView, this.jdField_a_of_type_ComTencentXactionApiDataViewData);
  }
  
  public void a(@Nullable Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  public final void a(@Nullable View paramView)
  {
    if (paramView == null) {
      Intrinsics.throwNpe();
    }
    this.jdField_a_of_type_AndroidViewView = paramView;
    a();
  }
  
  public void a(@Nullable View paramView, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    a(paramView);
  }
  
  public void a(@NotNull XAEngine paramXAEngine, @Nullable ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramXAEngine, "engine");
    this.jdField_a_of_type_ComTencentXactionImplXAEngine = paramXAEngine;
    if ((a() != null) && (paramViewGroup != null)) {
      paramViewGroup.addView(a());
    }
  }
  
  @Nullable
  public ViewData getStyle()
  {
    return this.jdField_a_of_type_ComTencentXactionApiDataViewData;
  }
  
  public void setStyle(@NotNull ViewData paramViewData)
  {
    Intrinsics.checkParameterIsNotNull(paramViewData, "viewData");
    this.jdField_a_of_type_ComTencentXactionApiDataViewData = paramViewData;
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.api.base.DecorView
 * JD-Core Version:    0.7.0.1
 */
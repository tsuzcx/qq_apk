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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/api/base/DecorView;", "Lcom/tencent/xaction/api/IDecorView;", "iView", "Lcom/tencent/xaction/api/IView;", "(Lcom/tencent/xaction/api/IView;)V", "data", "Lcom/tencent/xaction/api/data/ViewData;", "getData", "()Lcom/tencent/xaction/api/data/ViewData;", "setData", "(Lcom/tencent/xaction/api/data/ViewData;)V", "value", "Landroid/graphics/drawable/Drawable;", "drawable", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "setDrawable", "(Landroid/graphics/drawable/Drawable;)V", "drawableImpl", "engine", "Lcom/tencent/xaction/openapi/api/IXAEngine;", "getEngine", "()Lcom/tencent/xaction/openapi/api/IXAEngine;", "setEngine", "(Lcom/tencent/xaction/openapi/api/IXAEngine;)V", "isStyle", "", "linkViews", "Ljava/util/ArrayList;", "Landroid/view/View;", "Lkotlin/collections/ArrayList;", "proxyView", "bindData", "", "destroy", "getProxy", "getStyle", "init", "viewLayout", "Landroid/view/ViewGroup;", "linkAnim", "setProxy", "view", "setStyle", "viewData", "stateNotify", "status", "", "XActionCore_release"}, k=1, mv={1, 1, 16})
public class DecorView
  implements IDecorView
{
  private transient Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private View jdField_a_of_type_AndroidViewView;
  private IView jdField_a_of_type_ComTencentXactionApiIView;
  @Nullable
  private ViewData jdField_a_of_type_ComTencentXactionApiDataViewData;
  @Nullable
  private IXAEngine jdField_a_of_type_ComTencentXactionOpenapiApiIXAEngine;
  private ArrayList<View> jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean;
  
  public DecorView(@Nullable IView paramIView)
  {
    this.jdField_a_of_type_ComTencentXactionApiIView = paramIView;
    if ((paramIView instanceof View)) {
      paramIView = (View)paramIView;
    } else {
      paramIView = null;
    }
    this.jdField_a_of_type_AndroidViewView = paramIView;
    this.jdField_a_of_type_Boolean = true;
  }
  
  @Nullable
  public final ViewData a()
  {
    return this.jdField_a_of_type_ComTencentXactionApiDataViewData;
  }
  
  @Nullable
  public final IXAEngine a()
  {
    return this.jdField_a_of_type_ComTencentXactionOpenapiApiIXAEngine;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentXactionApiDataViewData != null) && (this.jdField_a_of_type_AndroidViewView != null))
    {
      if (this.jdField_a_of_type_ComTencentXactionOpenapiApiIXAEngine == null) {
        return;
      }
      IView localIView;
      if (this.jdField_a_of_type_Boolean)
      {
        localCompanion = XAEmptyView.a;
        localObject = this.jdField_a_of_type_ComTencentXactionOpenapiApiIXAEngine;
        if (localObject != null)
        {
          localObject = (XAEngine)localObject;
          localIView = this.jdField_a_of_type_ComTencentXactionApiIView;
          if (localIView == null) {
            Intrinsics.throwNpe();
          }
          localCompanion.c((XAEngine)localObject, localIView, this.jdField_a_of_type_ComTencentXactionApiDataViewData);
        }
        else
        {
          throw new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.impl.XAEngine");
        }
      }
      XAEmptyView.Companion localCompanion = XAEmptyView.a;
      Object localObject = this.jdField_a_of_type_ComTencentXactionOpenapiApiIXAEngine;
      if (localObject != null)
      {
        localObject = (XAEngine)localObject;
        localIView = this.jdField_a_of_type_ComTencentXactionApiIView;
        if (localIView == null) {
          Intrinsics.throwNpe();
        }
        localCompanion.a((XAEngine)localObject, localIView, this.jdField_a_of_type_ComTencentXactionApiDataViewData);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.impl.XAEngine");
    }
  }
  
  public final void a(@Nullable View paramView)
  {
    if (paramView == null) {
      Intrinsics.throwNpe();
    }
    this.jdField_a_of_type_AndroidViewView = paramView;
    a();
  }
  
  public final void a(@NotNull String paramString, @NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "status");
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    Object localObject1 = this.jdField_a_of_type_ComTencentXactionApiDataViewData;
    if (localObject1 != null)
    {
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      if (((ViewData)localObject1).getTag() == null)
      {
        localObject1 = this.jdField_a_of_type_ComTencentXactionApiDataViewData;
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        localObject1 = String.valueOf(((ViewData)localObject1).getId());
      }
      else
      {
        localObject1 = this.jdField_a_of_type_ComTencentXactionApiDataViewData;
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
      Object localObject2 = XAEngine.Companion;
      IXAEngine localIXAEngine = this.jdField_a_of_type_ComTencentXactionOpenapiApiIXAEngine;
      if (localIXAEngine == null) {
        Intrinsics.throwNpe();
      }
      ((XAEngine.Companion)localObject2).a((String)localObject1, paramString, paramView, localIXAEngine);
    }
  }
  
  public void destroy()
  {
    this.jdField_a_of_type_ComTencentXactionOpenapiApiIXAEngine = ((IXAEngine)null);
  }
  
  @Nullable
  public Drawable getDrawable()
  {
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  @Nullable
  public View getProxy()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  @Nullable
  public ViewData getStyle()
  {
    return this.jdField_a_of_type_ComTencentXactionApiDataViewData;
  }
  
  public void init(@NotNull IXAEngine paramIXAEngine, @Nullable ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramIXAEngine, "engine");
    this.jdField_a_of_type_ComTencentXactionOpenapiApiIXAEngine = paramIXAEngine;
    if ((getProxy() != null) && (paramViewGroup != null)) {
      paramViewGroup.addView(getProxy());
    }
  }
  
  public void linkAnim(@NotNull ArrayList<View> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "linkViews");
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    if (this.jdField_a_of_type_ComTencentXactionOpenapiApiIXAEngine == null) {
      return;
    }
    long l1 = 0L;
    paramArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (paramArrayList == null) {
      Intrinsics.throwNpe();
    }
    paramArrayList = ((Iterable)paramArrayList).iterator();
    if (paramArrayList.hasNext())
    {
      View localView = (View)paramArrayList.next();
      Object localObject1 = this.jdField_a_of_type_ComTencentXactionApiDataViewData;
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      localObject1 = ((ViewData)localObject1).getAnim().iterator();
      long l2 = l1;
      for (;;)
      {
        l1 = l2;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        Object localObject2 = (BaseAnim)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          localObject2 = ((BaseAnim)localObject2).clone();
          ((BaseAnim)localObject2).setDelay(((BaseAnim)localObject2).getDelay() + l2);
          Object localObject3 = this.jdField_a_of_type_ComTencentXactionOpenapiApiIXAEngine;
          if (localObject3 == null) {
            Intrinsics.throwNpe();
          }
          ((BaseAnim)localObject2).init(localView, (IXAEngine)localObject3);
          localObject3 = this.jdField_a_of_type_ComTencentXactionApiDataViewData;
          if (localObject3 == null) {
            Intrinsics.throwNpe();
          }
          localObject3 = ((ViewData)localObject3).getTl();
          if (localObject3 != null) {
            ((XATimeline)localObject3).a((ITimeline)localObject2);
          }
          localObject2 = this.jdField_a_of_type_ComTencentXactionApiDataViewData;
          if (localObject2 == null) {
            Intrinsics.throwNpe();
          }
          l2 += ((ViewData)localObject2).getLinkDelay();
        }
      }
    }
  }
  
  public void setDrawable(@Nullable Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  public void setProxy(@Nullable View paramView, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    a(paramView);
  }
  
  public void setStyle(@NotNull ViewData paramViewData)
  {
    Intrinsics.checkParameterIsNotNull(paramViewData, "viewData");
    this.jdField_a_of_type_ComTencentXactionApiDataViewData = paramViewData;
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.api.base.DecorView
 * JD-Core Version:    0.7.0.1
 */
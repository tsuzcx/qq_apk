package com.tencent.xaction.api.data;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.gson.Gson;
import com.tencent.xaction.api.IDecorView;
import com.tencent.xaction.api.IView;
import com.tencent.xaction.api.base.DecorView;
import com.tencent.xaction.impl.XAEngine;
import com.tencent.xaction.impl.XATimeline;
import com.tencent.xaction.view.XAView;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/api/data/Component;", "Lcom/tencent/xaction/api/IView;", "Lcom/tencent/xaction/api/IDecorView;", "", "context", "Landroid/content/Context;", "engine", "Lcom/tencent/xaction/impl/XAEngine;", "data", "Lcom/tencent/xaction/api/data/ViewData;", "(Landroid/content/Context;Lcom/tencent/xaction/impl/XAEngine;Lcom/tencent/xaction/api/data/ViewData;)V", "comptId", "", "getComptId", "()I", "setComptId", "(I)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "dataStr", "", "decor", "getDecor", "()Lcom/tencent/xaction/api/IDecorView;", "value", "Landroid/graphics/drawable/Drawable;", "drawable", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "setDrawable", "(Landroid/graphics/drawable/Drawable;)V", "drawaleImpl", "groupView", "Landroid/view/View;", "id", "getId", "setId", "timeline", "Lcom/tencent/xaction/impl/XATimeline;", "viewData", "clone", "getProxy", "getStyle", "init", "", "viewLayout", "Landroid/view/ViewGroup;", "setProxy", "view", "isStyle", "", "setStyle", "Companion", "XActionEngine_release"}, k=1, mv={1, 1, 16})
public final class Component
  implements IDecorView, IView, Cloneable
{
  public static final Component.Companion a;
  private int jdField_a_of_type_Int;
  @NotNull
  private Context jdField_a_of_type_AndroidContentContext;
  private transient Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private View jdField_a_of_type_AndroidViewView;
  @NotNull
  private final IDecorView jdField_a_of_type_ComTencentXactionApiIDecorView = (IDecorView)new DecorView(null);
  private ViewData jdField_a_of_type_ComTencentXactionApiDataViewData;
  private final XAEngine jdField_a_of_type_ComTencentXactionImplXAEngine;
  private final XATimeline jdField_a_of_type_ComTencentXactionImplXATimeline;
  private final String jdField_a_of_type_JavaLangString;
  private int b;
  
  static
  {
    jdField_a_of_type_ComTencentXactionApiDataComponent$Companion = new Component.Companion(null);
  }
  
  public Component(@NotNull Context paramContext, @NotNull XAEngine paramXAEngine, @NotNull ViewData paramViewData)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentXactionImplXAEngine = paramXAEngine;
    this.jdField_a_of_type_ComTencentXactionApiDataViewData = paramViewData;
    this.jdField_a_of_type_ComTencentXactionImplXATimeline = paramXAEngine.createTimeLine();
    paramContext = new Gson().toJson(this.jdField_a_of_type_ComTencentXactionApiDataViewData, (Type)this.jdField_a_of_type_ComTencentXactionApiDataViewData.getClass());
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "Gson().toJson(viewData, viewData.javaClass)");
    this.jdField_a_of_type_JavaLangString = paramContext;
    a().setStyle(paramViewData);
    a().a(paramXAEngine, null);
  }
  
  public final int a()
  {
    return this.b;
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
  
  @NotNull
  public IDecorView a()
  {
    return this.jdField_a_of_type_ComTencentXactionApiIDecorView;
  }
  
  @NotNull
  public Component a()
  {
    Object localObject = super.clone();
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.api.data.Component");
    }
    localObject = (Component)localObject;
    ((Component)localObject).a();
    return localObject;
  }
  
  public final void a()
  {
    setStyle(this.jdField_a_of_type_ComTencentXactionApiDataViewData);
  }
  
  public final void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(@Nullable Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  public void a(@Nullable View paramView, boolean paramBoolean) {}
  
  public void a(@NotNull XAEngine paramXAEngine, @Nullable ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramXAEngine, "engine");
  }
  
  @Nullable
  public ViewData getStyle()
  {
    return this.jdField_a_of_type_ComTencentXactionApiDataViewData;
  }
  
  public void setStyle(@NotNull ViewData paramViewData)
  {
    Intrinsics.checkParameterIsNotNull(paramViewData, "viewData");
    this.b = paramViewData.getId();
    this.jdField_a_of_type_ComTencentXactionApiDataViewData = paramViewData;
    Object localObject1 = paramViewData.getViews();
    if (localObject1 != null)
    {
      localObject1 = Integer.valueOf(((ArrayList)localObject1).size());
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      if (((Integer)localObject1).intValue() > 1)
      {
        if (!Intrinsics.areEqual(paramViewData.getGt(), "frame")) {
          break label194;
        }
        this.jdField_a_of_type_AndroidViewView = ((View)new FrameLayout(this.jdField_a_of_type_AndroidContentContext));
      }
    }
    int i;
    ViewData localViewData;
    for (;;)
    {
      i = 0;
      localObject1 = paramViewData.getViews();
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      localObject1 = ((Iterable)localObject1).iterator();
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label404;
        }
        localViewData = (ViewData)((Iterator)localObject1).next();
        if (localViewData != null)
        {
          i = Math.max(localViewData.getTp().getDuration(), i);
          if (!Intrinsics.areEqual(localViewData.getType(), "compt")) {
            break;
          }
          localObject2 = this.jdField_a_of_type_ComTencentXactionImplXAEngine.getLayout();
          if (localObject2 != null) {
            jdField_a_of_type_ComTencentXactionApiDataComponent$Companion.a(this.jdField_a_of_type_ComTencentXactionImplXAEngine, localViewData, (ViewGroup)localObject2);
          }
        }
      }
      localObject1 = null;
      break;
      label194:
      if (Intrinsics.areEqual(paramViewData.getGt(), "relative")) {
        this.jdField_a_of_type_AndroidViewView = ((View)new RelativeLayout(this.jdField_a_of_type_AndroidContentContext));
      }
    }
    Object localObject2 = new XAView(this.jdField_a_of_type_AndroidContentContext);
    if ((this.jdField_a_of_type_AndroidViewView instanceof ViewGroup))
    {
      Object localObject3 = this.jdField_a_of_type_AndroidViewView;
      if (localObject3 == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
      }
      ((ViewGroup)localObject3).addView((View)localObject2);
      label286:
      if (localViewData.getTp().getRc() == 0) {
        break label392;
      }
      localObject3 = this.jdField_a_of_type_ComTencentXactionImplXAEngine.createTimeLine();
      XAEngine localXAEngine = this.jdField_a_of_type_ComTencentXactionImplXAEngine;
      localXAEngine.setTimelineCount(localXAEngine.getTimelineCount() + 1);
      ((XATimeline)localObject3).a(localXAEngine.getTimelineCount());
      ((XATimeline)localObject3).a().set(localViewData.getTp());
      localViewData.setTl((XATimeline)localObject3);
    }
    for (;;)
    {
      ((XAView)localObject2).a().a(this.jdField_a_of_type_ComTencentXactionImplXAEngine, null);
      ((XAView)localObject2).a().setStyle(localViewData);
      break;
      this.jdField_a_of_type_AndroidViewView = ((View)localObject2);
      break label286;
      label392:
      localViewData.setTl(this.jdField_a_of_type_ComTencentXactionImplXATimeline);
    }
    label404:
    paramViewData.setTl(this.jdField_a_of_type_ComTencentXactionImplXATimeline);
    this.jdField_a_of_type_ComTencentXactionImplXATimeline.a().setDuration(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.api.data.Component
 * JD-Core Version:    0.7.0.1
 */
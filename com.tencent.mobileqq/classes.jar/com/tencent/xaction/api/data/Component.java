package com.tencent.xaction.api.data;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Keep;
import com.google.gson.Gson;
import com.tencent.xaction.api.IDecorView;
import com.tencent.xaction.api.IView;
import com.tencent.xaction.api.base.DecorView;
import com.tencent.xaction.impl.XAEngine;
import com.tencent.xaction.impl.XATimeline;
import com.tencent.xaction.openapi.api.IXAEngine;
import com.tencent.xaction.view.XAView;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/api/data/Component;", "Lcom/tencent/xaction/api/IView;", "Lcom/tencent/xaction/api/IDecorView;", "", "context", "Landroid/content/Context;", "engine", "Lcom/tencent/xaction/impl/XAEngine;", "data", "Lcom/tencent/xaction/api/data/ViewData;", "(Landroid/content/Context;Lcom/tencent/xaction/impl/XAEngine;Lcom/tencent/xaction/api/data/ViewData;)V", "comptId", "", "getComptId", "()I", "setComptId", "(I)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "dataStr", "", "decor", "getDecor", "()Lcom/tencent/xaction/api/IDecorView;", "value", "Landroid/graphics/drawable/Drawable;", "drawable", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "setDrawable", "(Landroid/graphics/drawable/Drawable;)V", "drawaleImpl", "groupView", "Landroid/view/View;", "id", "getId", "setId", "timeline", "Lcom/tencent/xaction/impl/XATimeline;", "viewData", "bindData", "", "clone", "destroy", "getProxy", "getStyle", "init", "Lcom/tencent/xaction/openapi/api/IXAEngine;", "viewLayout", "Landroid/view/ViewGroup;", "linkAnim", "linkViews", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "setProxy", "view", "isStyle", "", "setStyle", "Companion", "XActionCore_release"}, k=1, mv={1, 1, 16})
@Keep
public final class Component
  implements IDecorView, IView, Cloneable
{
  public static final Component.Companion Companion = new Component.Companion(null);
  private int comptId;
  @NotNull
  private Context context;
  private final String dataStr;
  @NotNull
  private final IDecorView decor = (IDecorView)new DecorView(null);
  private transient Drawable drawaleImpl;
  private final XAEngine engine;
  private View groupView;
  private int id;
  private final XATimeline timeline;
  private ViewData viewData;
  
  public Component(@NotNull Context paramContext, @NotNull XAEngine paramXAEngine, @NotNull ViewData paramViewData)
  {
    this.context = paramContext;
    this.engine = paramXAEngine;
    this.viewData = paramViewData;
    this.timeline = paramXAEngine.createTimeLine();
    paramContext = new Gson();
    ViewData localViewData = this.viewData;
    paramContext = paramContext.toJson(localViewData, (Type)localViewData.getClass());
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "Gson().toJson(viewData, viewData.javaClass)");
    this.dataStr = paramContext;
    getDecor().setStyle(paramViewData);
    getDecor().init((IXAEngine)paramXAEngine, null);
  }
  
  public void bindData() {}
  
  @NotNull
  public Component clone()
  {
    Object localObject = super.clone();
    if (localObject != null)
    {
      localObject = (Component)localObject;
      ((Component)localObject).init();
      return localObject;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.api.data.Component");
  }
  
  public void destroy() {}
  
  public final int getComptId()
  {
    return this.comptId;
  }
  
  @NotNull
  public final Context getContext()
  {
    return this.context;
  }
  
  @NotNull
  public IDecorView getDecor()
  {
    return this.decor;
  }
  
  @Nullable
  public Drawable getDrawable()
  {
    return this.drawaleImpl;
  }
  
  public final int getId()
  {
    return this.id;
  }
  
  @Nullable
  public View getProxy()
  {
    return this.groupView;
  }
  
  @Nullable
  public ViewData getStyle()
  {
    return this.viewData;
  }
  
  public final void init()
  {
    setStyle(this.viewData);
  }
  
  public void init(@NotNull IXAEngine paramIXAEngine, @Nullable ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramIXAEngine, "engine");
  }
  
  public void linkAnim(@NotNull ArrayList<View> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "linkViews");
  }
  
  public final void setComptId(int paramInt)
  {
    this.comptId = paramInt;
  }
  
  public final void setContext(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "<set-?>");
    this.context = paramContext;
  }
  
  public void setDrawable(@Nullable Drawable paramDrawable)
  {
    this.drawaleImpl = paramDrawable;
  }
  
  public final void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setProxy(@Nullable View paramView, boolean paramBoolean) {}
  
  public void setStyle(@NotNull ViewData paramViewData)
  {
    Intrinsics.checkParameterIsNotNull(paramViewData, "viewData");
    this.comptId = paramViewData.getId();
    this.viewData = paramViewData;
    Object localObject1 = paramViewData.getViews();
    if (localObject1 != null) {
      localObject1 = Integer.valueOf(((ArrayList)localObject1).size());
    } else {
      localObject1 = null;
    }
    if (localObject1 == null) {
      Intrinsics.throwNpe();
    }
    if (((Integer)localObject1).intValue() > 1) {
      if (Intrinsics.areEqual(paramViewData.getGt(), "frame")) {
        this.groupView = ((View)new FrameLayout(this.context));
      } else if (Intrinsics.areEqual(paramViewData.getGt(), "relative")) {
        this.groupView = ((View)new RelativeLayout(this.context));
      }
    }
    int i = 0;
    localObject1 = paramViewData.getViews();
    if (localObject1 == null) {
      Intrinsics.throwNpe();
    }
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      ViewData localViewData = (ViewData)((Iterator)localObject1).next();
      if (localViewData != null)
      {
        int j = Math.max(localViewData.getTp().getDuration(), i);
        Object localObject2;
        if (Intrinsics.areEqual(localViewData.getType(), "compt"))
        {
          localObject2 = this.engine.getLayout();
          i = j;
          if (localObject2 != null)
          {
            Companion.a(this.engine, localViewData, (ViewGroup)localObject2);
            i = j;
          }
        }
        else
        {
          localObject2 = new XAView(this.context);
          Object localObject3 = this.groupView;
          if ((localObject3 instanceof ViewGroup))
          {
            if (localObject3 != null) {
              ((ViewGroup)localObject3).addView((View)localObject2);
            } else {
              throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
            }
          }
          else {
            this.groupView = ((View)localObject2);
          }
          if (localViewData.getTp().getRc() != 0)
          {
            localObject3 = this.engine.createTimeLine();
            XAEngine localXAEngine = this.engine;
            localXAEngine.setTimelineCount(localXAEngine.getTimelineCount() + 1);
            ((XATimeline)localObject3).a(localXAEngine.getTimelineCount());
            ((XATimeline)localObject3).a().set(localViewData.getTp());
            localViewData.setTl((XATimeline)localObject3);
          }
          else
          {
            localViewData.setTl(this.timeline);
          }
          ((XAView)localObject2).a().init((IXAEngine)this.engine, null);
          ((XAView)localObject2).a().setStyle(localViewData);
          i = j;
        }
      }
    }
    paramViewData.setTl(this.timeline);
    this.timeline.a().setDuration(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.api.data.Component
 * JD-Core Version:    0.7.0.1
 */
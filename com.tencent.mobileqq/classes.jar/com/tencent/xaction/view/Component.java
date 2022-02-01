package com.tencent.xaction.view;

import android.content.Context;
import androidx.annotation.Keep;
import com.tencent.xaction.api.IDecorView;
import com.tencent.xaction.api.IView;
import com.tencent.xaction.api.data.ViewData;
import com.tencent.xaction.impl.XAEngine;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/view/Component;", "Lcom/tencent/xaction/api/IView;", "", "context", "Landroid/content/Context;", "xaEngine", "Lcom/tencent/xaction/impl/XAEngine;", "cData", "Lcom/tencent/xaction/api/data/ViewData;", "(Landroid/content/Context;Lcom/tencent/xaction/impl/XAEngine;Lcom/tencent/xaction/api/data/ViewData;)V", "getCData", "()Lcom/tencent/xaction/api/data/ViewData;", "setCData", "(Lcom/tencent/xaction/api/data/ViewData;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "decor", "Lcom/tencent/xaction/api/IDecorView;", "getDecor", "()Lcom/tencent/xaction/api/IDecorView;", "setDecor", "(Lcom/tencent/xaction/api/IDecorView;)V", "viewList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getViewList", "()Ljava/util/ArrayList;", "setViewList", "(Ljava/util/ArrayList;)V", "getXaEngine", "()Lcom/tencent/xaction/impl/XAEngine;", "setXaEngine", "(Lcom/tencent/xaction/impl/XAEngine;)V", "clone", "destroy", "", "Companion", "XActionCore_release"}, k=1, mv={1, 1, 16})
@Keep
public final class Component
  implements IView, Cloneable
{
  public static final Component.Companion Companion = new Component.Companion(null);
  @NotNull
  private ViewData cData;
  @NotNull
  private Context context;
  @NotNull
  private IDecorView decor;
  @NotNull
  private ArrayList<IView> viewList;
  @NotNull
  private XAEngine xaEngine;
  
  public Component(@NotNull Context paramContext, @NotNull XAEngine paramXAEngine, @NotNull ViewData paramViewData)
  {
    this.context = paramContext;
    this.xaEngine = paramXAEngine;
    this.cData = paramViewData;
    this.viewList = new ArrayList();
    this.decor = ((IDecorView)new ComponentDecorView(this, this.xaEngine));
  }
  
  @NotNull
  public Component clone()
  {
    Object localObject1 = super.clone();
    if (localObject1 != null)
    {
      localObject1 = (Component)localObject1;
      ((Component)localObject1).setDecor((IDecorView)new ComponentDecorView((Component)localObject1, this.xaEngine));
      ((Component)localObject1).viewList = new ArrayList();
      ((Component)localObject1).cData = this.cData.deepCopy();
      if (this.cData.getViews() != null)
      {
        Object localObject2 = this.cData.getViews();
        if (localObject2 == null) {
          Intrinsics.throwNpe();
        }
        if (((ArrayList)localObject2).size() > 0)
        {
          ((Component)localObject1).cData.setViews(new ArrayList());
          localObject2 = this.cData.getViews();
          if (localObject2 == null) {
            Intrinsics.throwNpe();
          }
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            ViewData localViewData = (ViewData)((Iterator)localObject2).next();
            ArrayList localArrayList = ((Component)localObject1).cData.getViews();
            if (localArrayList == null) {
              Intrinsics.throwNpe();
            }
            localArrayList.add(localViewData.deepCopy());
          }
        }
      }
      return localObject1;
    }
    localObject1 = new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.view.Component");
    for (;;)
    {
      throw ((Throwable)localObject1);
    }
  }
  
  public final void destroy()
  {
    this.xaEngine.viewsDestroy(this.viewList);
  }
  
  @NotNull
  public final ViewData getCData()
  {
    return this.cData;
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
  
  @NotNull
  public final ArrayList<IView> getViewList()
  {
    return this.viewList;
  }
  
  @NotNull
  public final XAEngine getXaEngine()
  {
    return this.xaEngine;
  }
  
  public final void setCData(@NotNull ViewData paramViewData)
  {
    Intrinsics.checkParameterIsNotNull(paramViewData, "<set-?>");
    this.cData = paramViewData;
  }
  
  public final void setContext(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "<set-?>");
    this.context = paramContext;
  }
  
  public void setDecor(@NotNull IDecorView paramIDecorView)
  {
    Intrinsics.checkParameterIsNotNull(paramIDecorView, "<set-?>");
    this.decor = paramIDecorView;
  }
  
  public final void setViewList(@NotNull ArrayList<IView> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "<set-?>");
    this.viewList = paramArrayList;
  }
  
  public final void setXaEngine(@NotNull XAEngine paramXAEngine)
  {
    Intrinsics.checkParameterIsNotNull(paramXAEngine, "<set-?>");
    this.xaEngine = paramXAEngine;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.view.Component
 * JD-Core Version:    0.7.0.1
 */
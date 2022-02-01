package com.tencent.tkd.topicsdk.mediaselector;

import android.view.View;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/mediaselector/PanelController;", "", "()V", "value", "", "currentPanelIndex", "getCurrentPanelIndex", "()I", "setCurrentPanelIndex", "(I)V", "currentPanelType", "Lcom/tencent/tkd/topicsdk/mediaselector/PanelType;", "getCurrentPanelType", "()Lcom/tencent/tkd/topicsdk/mediaselector/PanelType;", "currentPanelView", "Landroid/view/View;", "getCurrentPanelView", "()Landroid/view/View;", "iconViewList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getIconViewList", "()Ljava/util/ArrayList;", "setIconViewList", "(Ljava/util/ArrayList;)V", "onDisableItemClickListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "clickPanel", "", "getOnDisableItemClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnDisableItemClickListener", "(Lkotlin/jvm/functions/Function1;)V", "onDoubleClickListener", "panelType", "getOnDoubleClickListener", "setOnDoubleClickListener", "onPanelChangeListener", "Lkotlin/Function2;", "oldPanel", "newPanel", "getOnPanelChangeListener", "()Lkotlin/jvm/functions/Function2;", "setOnPanelChangeListener", "(Lkotlin/jvm/functions/Function2;)V", "panelEnableList", "", "getPanelEnableList", "setPanelEnableList", "panelList", "getPanelList", "setPanelList", "panelTitleList", "", "getPanelTitleList", "setPanelTitleList", "panelTypeList", "getPanelTypeList", "setPanelTypeList", "addPanel", "icon", "panelView", "getPanelEnable", "getPanelTitle", "getPanelView", "setSelectedIndex", "index", "userAction", "updatePanelTitle", "title", "updatePanelsVisibility", "selectedIconView", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class PanelController
{
  @NotNull
  private ArrayList<View> a = new ArrayList();
  @NotNull
  private ArrayList<PanelType> b = new ArrayList();
  @NotNull
  private ArrayList<View> c = new ArrayList();
  @NotNull
  private ArrayList<String> d = new ArrayList();
  private int e;
  @NotNull
  private ArrayList<Boolean> f;
  @Nullable
  private Function1<? super PanelType, Unit> g;
  @Nullable
  private Function2<? super PanelType, ? super PanelType, Unit> h;
  @Nullable
  private Function1<? super PanelType, Unit> i;
  
  public PanelController()
  {
    Boolean localBoolean = Boolean.valueOf(true);
    this.f = CollectionsKt.arrayListOf(new Boolean[] { localBoolean, localBoolean });
  }
  
  private final void a(int paramInt, PanelType paramPanelType, boolean paramBoolean)
  {
    Object localObject1;
    if (paramInt != this.e)
    {
      if (!c(paramPanelType))
      {
        paramPanelType = this.g;
        if (paramPanelType != null)
        {
          localObject1 = this.b.get(paramInt);
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "panelTypeList[index]");
          paramPanelType = (Unit)paramPanelType.invoke(localObject1);
        }
      }
      else
      {
        int j = this.e;
        a(paramInt);
        paramPanelType = this.h;
        if (paramPanelType != null)
        {
          localObject1 = this.b.get(j);
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "panelTypeList[lastPanelIndex]");
          Object localObject2 = this.b.get(paramInt);
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "panelTypeList[index]");
          paramPanelType = (Unit)paramPanelType.invoke(localObject1, localObject2);
        }
      }
    }
    else if (paramBoolean)
    {
      paramPanelType = this.i;
      if (paramPanelType != null)
      {
        localObject1 = this.b.get(paramInt);
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "panelTypeList[index]");
        paramPanelType = (Unit)paramPanelType.invoke(localObject1);
      }
    }
  }
  
  private final void a(View paramView)
  {
    paramView.setSelected(true);
    Object localObject1 = (Iterable)this.a;
    Collection localCollection = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      if ((Intrinsics.areEqual((View)localObject2, paramView) ^ true)) {
        localCollection.add(localObject2);
      }
    }
    paramView = ((Iterable)localCollection).iterator();
    while (paramView.hasNext()) {
      ((View)paramView.next()).setSelected(false);
    }
    paramView = this.c.get(this.e);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "panelList[currentPanelIndex]");
    paramView = (View)paramView;
    paramView.setVisibility(0);
    localObject1 = (Iterable)this.c;
    localCollection = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      if ((Intrinsics.areEqual((View)localObject2, paramView) ^ true)) {
        localCollection.add(localObject2);
      }
    }
    paramView = ((Iterable)localCollection).iterator();
    while (paramView.hasNext()) {
      ((View)paramView.next()).setVisibility(8);
    }
  }
  
  private final boolean c(PanelType paramPanelType)
  {
    int j = PanelController.WhenMappings.$EnumSwitchMapping$0[paramPanelType.ordinal()];
    if (j != 1)
    {
      if (j != 2) {
        return true;
      }
      paramPanelType = this.f.get(1);
      Intrinsics.checkExpressionValueIsNotNull(paramPanelType, "panelEnableList[1]");
      return ((Boolean)paramPanelType).booleanValue();
    }
    paramPanelType = this.f.get(0);
    Intrinsics.checkExpressionValueIsNotNull(paramPanelType, "panelEnableList[0]");
    return ((Boolean)paramPanelType).booleanValue();
  }
  
  @NotNull
  public final ArrayList<View> a()
  {
    return this.a;
  }
  
  public final void a(int paramInt)
  {
    this.e = paramInt;
    if (this.a.size() > this.e)
    {
      Object localObject = this.a.get(paramInt);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "iconViewList[value]");
      a((View)localObject);
    }
  }
  
  public final void a(@NotNull PanelType paramPanelType)
  {
    Intrinsics.checkParameterIsNotNull(paramPanelType, "panelType");
    a(this.b.indexOf(paramPanelType), paramPanelType, false);
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "title");
    this.d.set(this.e, paramString);
  }
  
  public final void a(@Nullable Function1<? super PanelType, Unit> paramFunction1)
  {
    this.g = paramFunction1;
  }
  
  public final void a(@Nullable Function2<? super PanelType, ? super PanelType, Unit> paramFunction2)
  {
    this.h = paramFunction2;
  }
  
  @NotNull
  public final View b(@NotNull PanelType paramPanelType)
  {
    Intrinsics.checkParameterIsNotNull(paramPanelType, "panelType");
    paramPanelType = this.c.get(this.b.indexOf(paramPanelType));
    Intrinsics.checkExpressionValueIsNotNull(paramPanelType, "panelList[panelTypeList.indexOf(panelType)]");
    return (View)paramPanelType;
  }
  
  @NotNull
  public final ArrayList<View> b()
  {
    return this.c;
  }
  
  public final void b(@Nullable Function1<? super PanelType, Unit> paramFunction1)
  {
    this.i = paramFunction1;
  }
  
  public final int c()
  {
    return this.e;
  }
  
  @NotNull
  public final ArrayList<Boolean> d()
  {
    return this.f;
  }
  
  @Nullable
  public final View e()
  {
    if (this.c.size() > 0) {
      return (View)this.c.get(this.e);
    }
    return null;
  }
  
  @NotNull
  public final PanelType f()
  {
    if (this.c.size() > 0)
    {
      Object localObject = this.b.get(this.e);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "panelTypeList[currentPanelIndex]");
      return (PanelType)localObject;
    }
    return PanelType.NONE;
  }
  
  @NotNull
  public final String g()
  {
    Object localObject = this.d.get(this.e);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "panelTitleList[currentPanelIndex]");
    return (String)localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mediaselector.PanelController
 * JD-Core Version:    0.7.0.1
 */
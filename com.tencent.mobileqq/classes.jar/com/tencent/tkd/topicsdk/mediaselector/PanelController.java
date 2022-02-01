package com.tencent.tkd.topicsdk.mediaselector;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.tkd.R.string;
import com.tencent.tkd.topicsdk.framework.AppContext;
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
  private int jdField_a_of_type_Int;
  @NotNull
  private ArrayList<View> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  @Nullable
  private Function1<? super PanelType, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction1;
  @Nullable
  private Function2<? super PanelType, ? super PanelType, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction2;
  @NotNull
  private ArrayList<PanelType> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  @Nullable
  private Function1<? super PanelType, Unit> jdField_b_of_type_KotlinJvmFunctionsFunction1;
  @NotNull
  private ArrayList<View> c = new ArrayList();
  @NotNull
  private ArrayList<String> d = new ArrayList();
  @NotNull
  private ArrayList<Boolean> e;
  
  public PanelController()
  {
    Boolean localBoolean = Boolean.valueOf(true);
    this.e = CollectionsKt.arrayListOf(new Boolean[] { localBoolean, localBoolean });
  }
  
  private final void a(int paramInt, PanelType paramPanelType, boolean paramBoolean)
  {
    Object localObject1;
    if (paramInt != this.jdField_a_of_type_Int)
    {
      if (!a(paramPanelType))
      {
        paramPanelType = this.jdField_a_of_type_KotlinJvmFunctionsFunction1;
        if (paramPanelType != null)
        {
          localObject1 = this.jdField_b_of_type_JavaUtilArrayList.get(paramInt);
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "panelTypeList[index]");
          paramPanelType = (Unit)paramPanelType.invoke(localObject1);
        }
      }
      else
      {
        int i = this.jdField_a_of_type_Int;
        a(paramInt);
        paramPanelType = this.jdField_a_of_type_KotlinJvmFunctionsFunction2;
        if (paramPanelType != null)
        {
          localObject1 = this.jdField_b_of_type_JavaUtilArrayList.get(i);
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "panelTypeList[lastPanelIndex]");
          Object localObject2 = this.jdField_b_of_type_JavaUtilArrayList.get(paramInt);
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "panelTypeList[index]");
          paramPanelType = (Unit)paramPanelType.invoke(localObject1, localObject2);
        }
      }
    }
    else if (paramBoolean)
    {
      paramPanelType = this.jdField_b_of_type_KotlinJvmFunctionsFunction1;
      if (paramPanelType != null)
      {
        localObject1 = this.jdField_b_of_type_JavaUtilArrayList.get(paramInt);
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "panelTypeList[index]");
        paramPanelType = (Unit)paramPanelType.invoke(localObject1);
      }
    }
  }
  
  private final void a(View paramView)
  {
    paramView.setSelected(true);
    Object localObject1 = (Iterable)this.jdField_a_of_type_JavaUtilArrayList;
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
    paramView = this.c.get(this.jdField_a_of_type_Int);
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
  
  private final boolean a(PanelType paramPanelType)
  {
    int i = PanelController.WhenMappings.a[paramPanelType.ordinal()];
    if (i != 1)
    {
      if (i != 2) {
        return true;
      }
      paramPanelType = this.e.get(1);
      Intrinsics.checkExpressionValueIsNotNull(paramPanelType, "panelEnableList[1]");
      return ((Boolean)paramPanelType).booleanValue();
    }
    paramPanelType = this.e.get(0);
    Intrinsics.checkExpressionValueIsNotNull(paramPanelType, "panelEnableList[0]");
    return ((Boolean)paramPanelType).booleanValue();
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @Nullable
  public final View a()
  {
    if (this.c.size() > 0) {
      return (View)this.c.get(this.jdField_a_of_type_Int);
    }
    return null;
  }
  
  @NotNull
  public final View a(@NotNull PanelType paramPanelType)
  {
    Intrinsics.checkParameterIsNotNull(paramPanelType, "panelType");
    paramPanelType = this.c.get(this.jdField_b_of_type_JavaUtilArrayList.indexOf(paramPanelType));
    Intrinsics.checkExpressionValueIsNotNull(paramPanelType, "panelList[panelTypeList.indexOf(panelType)]");
    return (View)paramPanelType;
  }
  
  @NotNull
  public final PanelType a()
  {
    if (this.c.size() > 0)
    {
      Object localObject = this.jdField_b_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "panelTypeList[currentPanelIndex]");
      return (PanelType)localObject;
    }
    return PanelType.NONE;
  }
  
  @NotNull
  public final String a()
  {
    Object localObject = this.d.get(this.jdField_a_of_type_Int);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "panelTitleList[currentPanelIndex]");
    return (String)localObject;
  }
  
  @NotNull
  public final ArrayList<View> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public final void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > this.jdField_a_of_type_Int)
    {
      Object localObject = this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "iconViewList[value]");
      a((View)localObject);
    }
  }
  
  public final void a(@NotNull View paramView1, @NotNull View paramView2, @NotNull PanelType paramPanelType)
  {
    Intrinsics.checkParameterIsNotNull(paramView1, "icon");
    Intrinsics.checkParameterIsNotNull(paramView2, "panelView");
    Intrinsics.checkParameterIsNotNull(paramPanelType, "panelType");
    this.jdField_a_of_type_JavaUtilArrayList.add(paramView1);
    this.c.add(paramView2);
    this.jdField_b_of_type_JavaUtilArrayList.add(paramPanelType);
    paramView1.setOnClickListener((View.OnClickListener)new PanelController.addPanel.1(this, paramView1, paramPanelType));
    this.d.add(AppContext.a.a().getResources().getString(R.string.W));
  }
  
  public final void a(@NotNull PanelType paramPanelType)
  {
    Intrinsics.checkParameterIsNotNull(paramPanelType, "panelType");
    a(this.jdField_b_of_type_JavaUtilArrayList.indexOf(paramPanelType), paramPanelType, false);
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "title");
    this.d.set(this.jdField_a_of_type_Int, paramString);
  }
  
  public final void a(@Nullable Function1<? super PanelType, Unit> paramFunction1)
  {
    this.jdField_a_of_type_KotlinJvmFunctionsFunction1 = paramFunction1;
  }
  
  public final void a(@Nullable Function2<? super PanelType, ? super PanelType, Unit> paramFunction2)
  {
    this.jdField_a_of_type_KotlinJvmFunctionsFunction2 = paramFunction2;
  }
  
  @NotNull
  public final ArrayList<View> b()
  {
    return this.c;
  }
  
  public final void b(@Nullable Function1<? super PanelType, Unit> paramFunction1)
  {
    this.jdField_b_of_type_KotlinJvmFunctionsFunction1 = paramFunction1;
  }
  
  @NotNull
  public final ArrayList<Boolean> c()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mediaselector.PanelController
 * JD-Core Version:    0.7.0.1
 */
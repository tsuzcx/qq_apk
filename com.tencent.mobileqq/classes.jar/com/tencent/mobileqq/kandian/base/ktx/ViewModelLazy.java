package com.tencent.mobileqq.kandian.base.ktx;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.lifecycle.ViewModelStore;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/ktx/ViewModelLazy;", "VM", "Landroidx/lifecycle/ViewModel;", "Lkotlin/Lazy;", "viewModelClass", "Lkotlin/reflect/KClass;", "storeProducer", "Lkotlin/Function0;", "Landroidx/lifecycle/ViewModelStore;", "factoryProducer", "Landroidx/lifecycle/ViewModelProvider$Factory;", "(Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "cached", "Landroidx/lifecycle/ViewModel;", "value", "getValue", "()Landroidx/lifecycle/ViewModel;", "isInitialized", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ViewModelLazy<VM extends ViewModel>
  implements Lazy<VM>
{
  private VM a;
  private final KClass<VM> b;
  private final Function0<ViewModelStore> c;
  private final Function0<ViewModelProvider.Factory> d;
  
  public ViewModelLazy(@NotNull KClass<VM> paramKClass, @NotNull Function0<? extends ViewModelStore> paramFunction0, @NotNull Function0<? extends ViewModelProvider.Factory> paramFunction01)
  {
    this.b = paramKClass;
    this.c = paramFunction0;
    this.d = paramFunction01;
  }
  
  @NotNull
  public VM a()
  {
    ViewModel localViewModel = this.a;
    Object localObject = localViewModel;
    if (localViewModel == null)
    {
      localObject = (ViewModelProvider.Factory)this.d.invoke();
      localObject = new ViewModelProvider((ViewModelStore)this.c.invoke(), (ViewModelProvider.Factory)localObject).get(JvmClassMappingKt.getJavaClass(this.b));
      this.a = ((ViewModel)localObject);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "ViewModelProvider(store,…ed = it\n                }");
    }
    return localObject;
  }
  
  public boolean isInitialized()
  {
    return this.a != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.ktx.ViewModelLazy
 * JD-Core Version:    0.7.0.1
 */
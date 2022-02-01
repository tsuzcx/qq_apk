package com.tencent.tkd.topicsdk.framework;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.tkd.topicsdk.interfaces.IPagerAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/framework/PagerAdapterProxy;", "", "()V", "pagerAdapterImpl", "Lcom/tencent/tkd/topicsdk/interfaces/IPagerAdapter;", "getPagerAdapterImpl", "()Lcom/tencent/tkd/topicsdk/interfaces/IPagerAdapter;", "setPagerAdapterImpl", "(Lcom/tencent/tkd/topicsdk/interfaces/IPagerAdapter;)V", "destroyItem", "", "container", "Landroid/view/ViewGroup;", "position", "", "obj", "getCount", "getItemPosition", "getPageTitle", "", "getPageWidth", "", "instantiateItem", "isViewFromObject", "", "view", "Landroid/view/View;", "notifyDataSetChanged", "registerDataSetObserver", "observer", "Landroid/database/DataSetObserver;", "restoreState", "state", "Landroid/os/Parcelable;", "loader", "Ljava/lang/ClassLoader;", "saveState", "setPrimaryItem", "unregisterDataSetObserver", "topicsdk-framework_release"}, k=1, mv={1, 1, 16})
public abstract class PagerAdapterProxy
{
  @Nullable
  private IPagerAdapter a;
  
  public abstract int a();
  
  public int a(@NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "obj");
    IPagerAdapter localIPagerAdapter = this.a;
    if (localIPagerAdapter != null) {
      return localIPagerAdapter.a(paramObject);
    }
    return -1;
  }
  
  @NotNull
  public abstract Object a(@NotNull ViewGroup paramViewGroup, int paramInt);
  
  public void a(@NotNull ViewGroup paramViewGroup, int paramInt, @NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "container");
    Intrinsics.checkParameterIsNotNull(paramObject, "obj");
  }
  
  public final void a(@Nullable IPagerAdapter paramIPagerAdapter)
  {
    this.a = paramIPagerAdapter;
  }
  
  public abstract boolean a(@NotNull View paramView, @NotNull Object paramObject);
  
  public void b()
  {
    IPagerAdapter localIPagerAdapter = this.a;
    if (localIPagerAdapter != null) {
      localIPagerAdapter.a();
    }
  }
  
  public void b(@NotNull ViewGroup paramViewGroup, int paramInt, @NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "container");
    Intrinsics.checkParameterIsNotNull(paramObject, "obj");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.framework.PagerAdapterProxy
 * JD-Core Version:    0.7.0.1
 */
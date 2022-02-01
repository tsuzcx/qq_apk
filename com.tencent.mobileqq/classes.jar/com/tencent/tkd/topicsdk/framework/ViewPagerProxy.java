package com.tencent.tkd.topicsdk.framework;

import android.content.Context;
import android.view.View;
import com.tencent.tkd.topicsdk.interfaces.IViewPager;
import com.tencent.tkd.topicsdk.interfaces.OnPageChangeListenerProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/framework/ViewPagerProxy;", "", "context", "Landroid/content/Context;", "viewPagerImpl", "Lcom/tencent/tkd/topicsdk/interfaces/IViewPager;", "(Landroid/content/Context;Lcom/tencent/tkd/topicsdk/interfaces/IViewPager;)V", "value", "Lcom/tencent/tkd/topicsdk/framework/PagerAdapterProxy;", "adapter", "getAdapter", "()Lcom/tencent/tkd/topicsdk/framework/PagerAdapterProxy;", "setAdapter", "(Lcom/tencent/tkd/topicsdk/framework/PagerAdapterProxy;)V", "getContext", "()Landroid/content/Context;", "", "isScrollEnabled", "()Z", "setScrollEnabled", "(Z)V", "viewPager", "Landroid/view/View;", "getViewPager", "()Landroid/view/View;", "setViewPager", "(Landroid/view/View;)V", "addOnPageChangeListener", "", "listener", "Lcom/tencent/tkd/topicsdk/interfaces/OnPageChangeListenerProxy;", "clearOnPageChangeListeners", "getCurrentItem", "", "onViewDetached", "removeOnPageChangeListener", "setCurrentItem", "item", "smoothScroll", "setOffscreenPageLimit", "limit", "topicsdk-framework_release"}, k=1, mv={1, 1, 16})
public final class ViewPagerProxy
{
  @NotNull
  private final Context jdField_a_of_type_AndroidContentContext;
  @Nullable
  private View jdField_a_of_type_AndroidViewView;
  @Nullable
  private PagerAdapterProxy jdField_a_of_type_ComTencentTkdTopicsdkFrameworkPagerAdapterProxy;
  private final IViewPager jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIViewPager;
  private boolean jdField_a_of_type_Boolean;
  
  public ViewPagerProxy(@NotNull Context paramContext, @NotNull IViewPager paramIViewPager)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIViewPager = paramIViewPager;
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIViewPager.a(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIViewPager.a();
  }
  
  @Nullable
  public final View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public final void a()
  {
    this.jdField_a_of_type_AndroidViewView = ((View)null);
    this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIViewPager.a();
  }
  
  public final void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIViewPager.a(paramInt);
  }
  
  public final void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIViewPager.a(paramInt, paramBoolean);
  }
  
  public final void a(@Nullable PagerAdapterProxy paramPagerAdapterProxy)
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIViewPager.a(paramPagerAdapterProxy);
    this.jdField_a_of_type_ComTencentTkdTopicsdkFrameworkPagerAdapterProxy = paramPagerAdapterProxy;
  }
  
  public final void a(@NotNull OnPageChangeListenerProxy paramOnPageChangeListenerProxy)
  {
    Intrinsics.checkParameterIsNotNull(paramOnPageChangeListenerProxy, "listener");
    this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIViewPager.a(paramOnPageChangeListenerProxy);
  }
  
  public final void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIViewPager.a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.framework.ViewPagerProxy
 * JD-Core Version:    0.7.0.1
 */
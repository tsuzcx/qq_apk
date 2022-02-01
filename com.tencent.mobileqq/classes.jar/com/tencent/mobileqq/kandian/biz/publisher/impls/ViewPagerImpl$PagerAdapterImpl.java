package com.tencent.mobileqq.kandian.biz.publisher.impls;

import androidx.viewpager.widget.PagerAdapter;
import com.tencent.tkd.topicsdk.interfaces.IPagerAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/publisher/impls/ViewPagerImpl$PagerAdapterImpl;", "Lcom/tencent/tkd/topicsdk/interfaces/IPagerAdapter;", "pageAdapter", "Landroidx/viewpager/widget/PagerAdapter;", "(Landroidx/viewpager/widget/PagerAdapter;)V", "getPageAdapter", "()Landroidx/viewpager/widget/PagerAdapter;", "getItemPosition", "", "obj", "", "getPageTitle", "", "position", "getPageWidth", "", "notifyDataSetChanged", "", "registerDataSetObserver", "observer", "Landroid/database/DataSetObserver;", "restoreState", "state", "Landroid/os/Parcelable;", "loader", "Ljava/lang/ClassLoader;", "saveState", "unregisterDataSetObserver", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
final class ViewPagerImpl$PagerAdapterImpl
  implements IPagerAdapter
{
  @NotNull
  private final PagerAdapter a;
  
  public ViewPagerImpl$PagerAdapterImpl(@NotNull PagerAdapter paramPagerAdapter)
  {
    this.a = paramPagerAdapter;
  }
  
  public int a(@NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "obj");
    return this.a.getItemPosition(paramObject);
  }
  
  public void a()
  {
    this.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.impls.ViewPagerImpl.PagerAdapterImpl
 * JD-Core Version:    0.7.0.1
 */
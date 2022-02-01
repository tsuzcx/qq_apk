package com.tencent.mobileqq.kandian.biz.publisher.impls;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.tkd.topicsdk.interfaces.IPage;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/publisher/impls/PageImpl;", "Lcom/tencent/tkd/topicsdk/interfaces/IPage;", "BaseFragment", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "(Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;)V", "getActivity", "Landroid/app/Activity;", "getArguments", "Landroid/os/Bundle;", "setArguments", "", "bundle", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class PageImpl
  implements IPage
{
  private final QPublicBaseFragment a;
  
  public PageImpl(@NotNull QPublicBaseFragment paramQPublicBaseFragment)
  {
    this.a = paramQPublicBaseFragment;
  }
  
  @Nullable
  public Bundle a()
  {
    return this.a.getArguments();
  }
  
  @Nullable
  public Activity b()
  {
    return (Activity)this.a.getActivity();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.impls.PageImpl
 * JD-Core Version:    0.7.0.1
 */
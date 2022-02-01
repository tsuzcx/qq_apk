package com.tencent.mobileqq.kandian.biz.publisher.impls;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.tencent.tkd.topicsdk.interfaces.IPage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/publisher/impls/PageImpl;", "Lcom/tencent/tkd/topicsdk/interfaces/IPage;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "getActivity", "Landroid/app/Activity;", "getArguments", "Landroid/os/Bundle;", "setArguments", "", "bundle", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class PageImpl
  implements IPage
{
  private final Fragment a;
  
  public PageImpl(@NotNull Fragment paramFragment)
  {
    this.a = paramFragment;
  }
  
  @Nullable
  public Activity a()
  {
    return (Activity)this.a.getActivity();
  }
  
  @NotNull
  public Bundle a()
  {
    Bundle localBundle = this.a.getArguments();
    Intrinsics.checkExpressionValueIsNotNull(localBundle, "fragment.arguments");
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.impls.PageImpl
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.kandian.biz.publisher.impls;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.tkd.topicsdk.interfaces.IPageOpener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/publisher/impls/PageOpenerImpl;", "Lcom/tencent/tkd/topicsdk/interfaces/IPageOpener;", "()V", "openPage", "", "context", "Landroid/content/Context;", "bundle", "Landroid/os/Bundle;", "openPageForResult", "activity", "Landroid/app/Activity;", "requestCode", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class PageOpenerImpl
  implements IPageOpener
{
  public void a(@NotNull Activity paramActivity, @NotNull Bundle paramBundle, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramBundle, "bundle");
    Intent localIntent = new Intent();
    localIntent.putExtras(paramBundle);
    localIntent.putExtra("big_brother_source_key", "biz_src_feeds_kandian");
    QPublicFragmentActivity.startForResult(paramActivity, localIntent, PublishFragment.class, paramInt);
  }
  
  public void a(@NotNull Context paramContext, @NotNull Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramBundle, "bundle");
    Intent localIntent = new Intent();
    localIntent.putExtras(paramBundle);
    localIntent.putExtra("big_brother_source_key", "biz_src_feeds_kandian");
    QPublicFragmentActivity.start(paramContext, localIntent, PublishFragment.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.impls.PageOpenerImpl
 * JD-Core Version:    0.7.0.1
 */
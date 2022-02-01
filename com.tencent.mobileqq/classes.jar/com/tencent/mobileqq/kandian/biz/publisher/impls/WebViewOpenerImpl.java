package com.tencent.mobileqq.kandian.biz.publisher.impls;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.tkd.topicsdk.interfaces.IWebViewOpener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/publisher/impls/WebViewOpenerImpl;", "Lcom/tencent/tkd/topicsdk/interfaces/IWebViewOpener;", "()V", "loadUrl", "", "context", "Landroid/content/Context;", "url", "", "extra", "Landroid/os/Bundle;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class WebViewOpenerImpl
  implements IWebViewOpener
{
  public void a(@Nullable Context paramContext, @NotNull String paramString, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    RIJJumpUtils.a(paramContext, paramString, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.impls.WebViewOpenerImpl
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.kandian.biz.publisher.impls;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.tencent.tkd.topicsdk.bean.GlobalPublisherConfig;
import com.tencent.tkd.topicsdk.entry.EntryView;
import com.tencent.tkd.topicsdk.entry.IEntryViewBridge;
import com.tencent.tkd.topicsdk.entry.IEntryViewBridge.DefaultImpls;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/publisher/impls/EntryViewBridgeImpl;", "Lcom/tencent/tkd/topicsdk/entry/IEntryViewBridge;", "()V", "theme", "", "getTheme", "()I", "setTheme", "(I)V", "onAddPublishViewClicked", "", "view", "Lcom/tencent/tkd/topicsdk/entry/EntryView;", "config", "Lcom/tencent/tkd/topicsdk/bean/GlobalPublisherConfig;", "innerBundle", "Landroid/os/Bundle;", "outerBundle", "onCreateTopicViewClicked", "onPublishArticleViewClicked", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class EntryViewBridgeImpl
  implements IEntryViewBridge
{
  private int a = -1;
  
  @NotNull
  public Drawable a()
  {
    return IEntryViewBridge.DefaultImpls.b(this);
  }
  
  public void a(@NotNull EntryView paramEntryView, @Nullable GlobalPublisherConfig paramGlobalPublisherConfig, @Nullable Bundle paramBundle1, @Nullable Bundle paramBundle2)
  {
    Intrinsics.checkParameterIsNotNull(paramEntryView, "view");
  }
  
  @NotNull
  public Drawable b()
  {
    return IEntryViewBridge.DefaultImpls.d(this);
  }
  
  public void b(@NotNull EntryView paramEntryView, @Nullable GlobalPublisherConfig paramGlobalPublisherConfig, @Nullable Bundle paramBundle1, @Nullable Bundle paramBundle2)
  {
    Intrinsics.checkParameterIsNotNull(paramEntryView, "view");
  }
  
  @NotNull
  public Drawable c()
  {
    return IEntryViewBridge.DefaultImpls.a(this);
  }
  
  public void c(@NotNull EntryView paramEntryView, @Nullable GlobalPublisherConfig paramGlobalPublisherConfig, @Nullable Bundle paramBundle1, @Nullable Bundle paramBundle2)
  {
    Intrinsics.checkParameterIsNotNull(paramEntryView, "view");
  }
  
  @NotNull
  public Drawable d()
  {
    return IEntryViewBridge.DefaultImpls.c(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.impls.EntryViewBridgeImpl
 * JD-Core Version:    0.7.0.1
 */
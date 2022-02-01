package com.tencent.tkd.topicsdk.entry;

import android.widget.TextView;
import com.tencent.tkd.topicsdk.bean.GlobalPublisherConfig;
import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import com.tencent.tkd.topicsdk.publisharticle.PublishManager.IPublishArticleListener;
import com.tencent.tkd.topicsdk.widget.RoundProgressView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/entry/EntryView$publishListener$1", "Lcom/tencent/tkd/topicsdk/publisharticle/PublishManager$IPublishArticleListener;", "onFailed", "", "globalPublisherConfig", "Lcom/tencent/tkd/topicsdk/bean/GlobalPublisherConfig;", "publishArticleInfo", "Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "onProgress", "publishId", "", "progress", "", "onStart", "coverPath", "onSuccess", "serverPublishData", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class EntryView$publishListener$1
  implements PublishManager.IPublishArticleListener
{
  public void a(@NotNull GlobalPublisherConfig paramGlobalPublisherConfig, @NotNull PublishArticleInfo paramPublishArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramGlobalPublisherConfig, "globalPublisherConfig");
    Intrinsics.checkParameterIsNotNull(paramPublishArticleInfo, "publishArticleInfo");
    EntryView.c(this.a);
    EntryView.d(this.a);
  }
  
  public void a(@NotNull GlobalPublisherConfig paramGlobalPublisherConfig, @NotNull PublishArticleInfo paramPublishArticleInfo, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramGlobalPublisherConfig, "globalPublisherConfig");
    Intrinsics.checkParameterIsNotNull(paramPublishArticleInfo, "publishArticleInfo");
    Intrinsics.checkParameterIsNotNull(paramString, "serverPublishData");
    if (EntryView.a(this.a))
    {
      EntryView.a(this.a).setNeedNumProgress(false);
      EntryView.b(this.a, (Function0)new EntryView.publishListener.1.onSuccess.1(this));
      return;
    }
    EntryView.a(this.a, (Function0)new EntryView.publishListener.1.onSuccess.2(this));
  }
  
  public void a(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "publishId");
    EntryView.b(this.a);
    EntryView.f(this.a);
    EntryView.b(this.a).setText((CharSequence)(paramInt + '%'));
    EntryView.a(this.a).setNeedNumProgress(EntryView.a(this.a));
    EntryView.a(this.a).setCurrentProgress(paramInt);
  }
  
  public void a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "publishId");
    Intrinsics.checkParameterIsNotNull(paramString2, "coverPath");
    EntryView.a(this.a, paramString1);
    this.a.a();
    EntryView.e(this.a);
    EntryView.b(this.a);
    EntryView.f(this.a);
    EntryView.b(this.a).setText((CharSequence)"0%");
    EntryView.a(this.a).setCurrentProgress(0);
    EntryView.b(this.a, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.entry.EntryView.publishListener.1
 * JD-Core Version:    0.7.0.1
 */
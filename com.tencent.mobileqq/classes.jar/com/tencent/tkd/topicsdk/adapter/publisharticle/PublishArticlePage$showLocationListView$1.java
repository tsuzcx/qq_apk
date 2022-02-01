package com.tencent.tkd.topicsdk.adapter.publisharticle;

import com.tencent.tkd.topicsdk.bean.LocationInfo;
import com.tencent.tkd.topicsdk.widget.AddLocationView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "newLocationInfo", "Lcom/tencent/tkd/topicsdk/bean/LocationInfo;", "invoke"}, k=3, mv={1, 1, 16})
final class PublishArticlePage$showLocationListView$1
  extends Lambda
  implements Function1<LocationInfo, Unit>
{
  PublishArticlePage$showLocationListView$1(PublishArticlePage paramPublishArticlePage)
  {
    super(1);
  }
  
  public final void invoke(@Nullable LocationInfo paramLocationInfo)
  {
    PublishArticlePage.a(this.this$0).setLocationInfo(paramLocationInfo);
    boolean bool;
    if (paramLocationInfo != null) {
      bool = true;
    } else {
      bool = false;
    }
    QQPublishArticleReportUtils.a.a(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.adapter.publisharticle.PublishArticlePage.showLocationListView.1
 * JD-Core Version:    0.7.0.1
 */
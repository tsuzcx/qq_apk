package com.tencent.tkd.topicsdk.publisharticle;

import com.tencent.tkd.topicsdk.bean.LocationInfo;
import com.tencent.tkd.topicsdk.framework.eventdispatch.DispatchManager;
import com.tencent.tkd.topicsdk.framework.eventdispatch.IEvent;
import com.tencent.tkd.topicsdk.framework.events.LocationChangeEvent;
import com.tencent.tkd.topicsdk.framework.events.LocationChangeEvent.Companion;
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
    if (paramLocationInfo != null)
    {
      DispatchManager.a.a((IEvent)new LocationChangeEvent(LocationChangeEvent.a.a(), 0, 2, null));
      return;
    }
    DispatchManager.a.a((IEvent)new LocationChangeEvent(LocationChangeEvent.a.b(), 0, 2, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishArticlePage.showLocationListView.1
 * JD-Core Version:    0.7.0.1
 */
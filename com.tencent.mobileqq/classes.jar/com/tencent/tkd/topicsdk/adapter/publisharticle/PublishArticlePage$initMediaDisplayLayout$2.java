package com.tencent.tkd.topicsdk.adapter.publisharticle;

import com.tencent.tkd.topicsdk.bean.DisplayItem;
import com.tencent.tkd.topicsdk.bean.Media;
import com.tencent.tkd.topicsdk.mediaselector.BottomSelectorLayout;
import com.tencent.tkd.topicsdk.widget.MediaDisplayLayout;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/adapter/publisharticle/PublishArticlePage$initMediaDisplayLayout$2", "Lkotlin/Function1;", "", "", "invoke", "position", "qq-adapter_release"}, k=1, mv={1, 1, 16})
public final class PublishArticlePage$initMediaDisplayLayout$2
  implements Function1<Integer, Unit>
{
  public void a(int paramInt)
  {
    Media localMedia = ((DisplayItem)PublishArticlePage.a(this.a).a().get(paramInt)).getMedia();
    PublishArticlePage.a(this.a).a(localMedia.getFilePath());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.adapter.publisharticle.PublishArticlePage.initMediaDisplayLayout.2
 * JD-Core Version:    0.7.0.1
 */
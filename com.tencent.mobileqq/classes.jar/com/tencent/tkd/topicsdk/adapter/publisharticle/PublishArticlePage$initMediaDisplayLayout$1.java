package com.tencent.tkd.topicsdk.adapter.publisharticle;

import android.app.Activity;
import com.tencent.tkd.topicsdk.bean.DisplayItem;
import com.tencent.tkd.topicsdk.bean.Media;
import com.tencent.tkd.topicsdk.bean.MediaType;
import com.tencent.tkd.topicsdk.mediaselector.PreviewPhotoPage;
import com.tencent.tkd.topicsdk.mediaselector.PreviewPhotoPage.Companion;
import com.tencent.tkd.topicsdk.widget.MediaDisplayLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/adapter/publisharticle/PublishArticlePage$initMediaDisplayLayout$1", "Lkotlin/Function1;", "", "", "invoke", "position", "qq-adapter_release"}, k=1, mv={1, 1, 16})
public final class PublishArticlePage$initMediaDisplayLayout$1
  implements Function1<Integer, Unit>
{
  PublishArticlePage$initMediaDisplayLayout$1(Activity paramActivity) {}
  
  public void a(int paramInt)
  {
    Object localObject1 = PublishArticlePage.l(this.a).getDisplayItems().get(paramInt);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "mediaDisplayLayout.displayItems[position]");
    if (((DisplayItem)localObject1).getMedia().getType() == MediaType.PHOTO)
    {
      Object localObject2 = (Iterable)PublishArticlePage.l(this.a).getDisplayItems();
      localObject1 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((Collection)localObject1).add(((DisplayItem)((Iterator)localObject2).next()).getMedia().getFilePath());
      }
      localObject1 = (List)localObject1;
      PreviewPhotoPage.f.a(this.b, 3, paramInt, (List)localObject1, (List)localObject1, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.adapter.publisharticle.PublishArticlePage.initMediaDisplayLayout.1
 * JD-Core Version:    0.7.0.1
 */
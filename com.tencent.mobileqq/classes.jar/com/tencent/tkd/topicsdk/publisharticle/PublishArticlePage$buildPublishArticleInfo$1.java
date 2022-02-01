package com.tencent.tkd.topicsdk.publisharticle;

import com.tencent.tkd.topicsdk.bean.ImageInfo;
import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import com.tencent.tkd.topicsdk.common.BitmapUtils;
import com.tencent.tkd.topicsdk.framework.ThreadManagerKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class PublishArticlePage$buildPublishArticleInfo$1
  extends Lambda
  implements Function0<Unit>
{
  PublishArticlePage$buildPublishArticleInfo$1(PublishArticleInfo paramPublishArticleInfo, Function1 paramFunction1)
  {
    super(0);
  }
  
  public final void invoke()
  {
    Object localObject = this.$publishArticleInfo.getImageList();
    if (localObject != null)
    {
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ImageInfo localImageInfo = (ImageInfo)((Iterator)localObject).next();
        Pair localPair = BitmapUtils.a.a(localImageInfo.getFilePath());
        localImageInfo.setWidth(((Number)localPair.getFirst()).intValue());
        localImageInfo.setHeight(((Number)localPair.getSecond()).intValue());
      }
    }
    ThreadManagerKt.a((Function0)new PublishArticlePage.buildPublishArticleInfo.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishArticlePage.buildPublishArticleInfo.1
 * JD-Core Version:    0.7.0.1
 */
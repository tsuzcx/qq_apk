package com.tencent.tkd.topicsdk.publisharticle;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.tkd.topicsdk.bean.DisplayItem;
import com.tencent.tkd.topicsdk.bean.Media;
import com.tencent.tkd.topicsdk.bean.MediaType;
import com.tencent.tkd.topicsdk.framework.TopicSDKHelperKt;
import com.tencent.tkd.topicsdk.mediaselector.PreviewPhotoPage;
import com.tencent.tkd.topicsdk.mediaselector.PreviewPhotoPage.Companion;
import com.tencent.tkd.topicsdk.videoprocess.videopreview.VideoPreviewPage;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/publisharticle/PublishArticlePage$initMediaDisplayLayout$1", "Lkotlin/Function1;", "", "", "invoke", "position", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class PublishArticlePage$initMediaDisplayLayout$1
  implements Function1<Integer, Unit>
{
  PublishArticlePage$initMediaDisplayLayout$1(Activity paramActivity) {}
  
  public void a(int paramInt)
  {
    Object localObject1 = PublishArticlePage.a(this.jdField_a_of_type_ComTencentTkdTopicsdkPublisharticlePublishArticlePage).a().get(paramInt);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "mediaDisplayLayout.displayItems[position]");
    localObject1 = (DisplayItem)localObject1;
    if (((DisplayItem)localObject1).getMedia().getType() == MediaType.PHOTO)
    {
      localObject1 = PreviewPhotoPage.a;
      localObject2 = this.jdField_a_of_type_AndroidAppActivity;
      localObject4 = (Iterable)PublishArticlePage.a(this.jdField_a_of_type_ComTencentTkdTopicsdkPublisharticlePublishArticlePage).a();
      localObject3 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject4, 10));
      localObject4 = ((Iterable)localObject4).iterator();
      while (((Iterator)localObject4).hasNext()) {
        ((Collection)localObject3).add(((DisplayItem)((Iterator)localObject4).next()).getMedia().getFilePath());
      }
      localObject3 = (List)localObject3;
      localObject5 = (Iterable)PublishArticlePage.a(this.jdField_a_of_type_ComTencentTkdTopicsdkPublisharticlePublishArticlePage).a();
      localObject4 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject5, 10));
      localObject5 = ((Iterable)localObject5).iterator();
      while (((Iterator)localObject5).hasNext()) {
        ((Collection)localObject4).add(((DisplayItem)((Iterator)localObject5).next()).getMedia().getFilePath());
      }
      ((PreviewPhotoPage.Companion)localObject1).a((Activity)localObject2, (List)localObject3, paramInt, 3, (List)localObject4, 9);
    }
    while (((DisplayItem)localObject1).getMedia().getType() != MediaType.VIDEO)
    {
      Object localObject4;
      Object localObject3;
      Object localObject5;
      return;
    }
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putString("video_url", ((DisplayItem)localObject1).getRealPath());
    TopicSDKHelperKt.a((Context)this.jdField_a_of_type_AndroidAppActivity, VideoPreviewPage.class, (Bundle)localObject2, null, null, 24, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishArticlePage.initMediaDisplayLayout.1
 * JD-Core Version:    0.7.0.1
 */
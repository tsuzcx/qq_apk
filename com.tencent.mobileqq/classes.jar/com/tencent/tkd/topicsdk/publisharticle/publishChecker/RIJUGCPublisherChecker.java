package com.tencent.tkd.topicsdk.publisharticle.publishChecker;

import com.tencent.tkd.topicsdk.bean.GlobalPublisherConfig;
import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import com.tencent.tkd.weibo.bean.EditObject;
import com.tencent.tkd.weibo.bean.EditObject.EditObjectType;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/publisharticle/publishChecker/RIJUGCPublisherChecker;", "Lcom/tencent/tkd/topicsdk/publisharticle/publishChecker/BasePublisherChecker;", "info", "Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "config", "Lcom/tencent/tkd/topicsdk/bean/GlobalPublisherConfig;", "(Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;Lcom/tencent/tkd/topicsdk/bean/GlobalPublisherConfig;)V", "getValidCode", "", "isContentNotEmpty", "", "isTextOnlyAtSpanAndSpace", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class RIJUGCPublisherChecker
  extends BasePublisherChecker
{
  public RIJUGCPublisherChecker(@NotNull PublishArticleInfo paramPublishArticleInfo, @Nullable GlobalPublisherConfig paramGlobalPublisherConfig)
  {
    super(paramPublishArticleInfo, paramGlobalPublisherConfig);
  }
  
  private final boolean a(PublishArticleInfo paramPublishArticleInfo)
  {
    if (Intrinsics.areEqual("rijugc", paramPublishArticleInfo.getPublishScene()))
    {
      Object localObject = paramPublishArticleInfo.getContent();
      Iterator localIterator = paramPublishArticleInfo.getContentList().iterator();
      paramPublishArticleInfo = (PublishArticleInfo)localObject;
      while (localIterator.hasNext())
      {
        localObject = (EditObject)localIterator.next();
        if (((EditObject)localObject).getType() == EditObject.EditObjectType.TYPE_AT) {
          paramPublishArticleInfo = StringsKt.replace$default(paramPublishArticleInfo, ((EditObject)localObject).getWording(), "", false, 4, null);
        }
      }
      if (paramPublishArticleInfo != null)
      {
        if (((CharSequence)StringsKt.trim((CharSequence)paramPublishArticleInfo).toString()).length() == 0) {
          return true;
        }
      }
      else {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
      }
    }
    else if (((CharSequence)paramPublishArticleInfo.getContent()).length() == 0)
    {
      return true;
    }
    return false;
  }
  
  public int a()
  {
    int i = super.a();
    if (i != 0) {
      return i;
    }
    Object localObject = a().getVideoInfo();
    int k = 1;
    if (localObject != null) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (((CharSequence)a().getContent()).length() == 0) {
      j = 1;
    } else {
      j = 0;
    }
    if ((i != 0) && (j != 0)) {
      return 7;
    }
    if ((i == 0) && (j == 0)) {
      return 8;
    }
    localObject = a();
    if ((localObject != null) && (((GlobalPublisherConfig)localObject).getShowDeliverToKDCommunity() == true))
    {
      if (((CharSequence)a().getCommunityId()).length() == 0) {
        i = k;
      } else {
        i = 0;
      }
      if (i != 0) {
        return 9;
      }
    }
    return 0;
  }
  
  public boolean a()
  {
    return (super.a()) && (!a(a()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.publishChecker.RIJUGCPublisherChecker
 * JD-Core Version:    0.7.0.1
 */
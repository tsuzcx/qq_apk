package com.tencent.tkd.topicsdk.publisharticle.publishChecker;

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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/publisharticle/publishChecker/RIJUGCPublisherChecker;", "Lcom/tencent/tkd/topicsdk/publisharticle/publishChecker/BasePublisherChecker;", "info", "Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "(Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;)V", "getValidCode", "", "isContentNotEmpty", "", "isTextOnlyAtSpanAndSpace", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class RIJUGCPublisherChecker
  extends BasePublisherChecker
{
  public RIJUGCPublisherChecker(@NotNull PublishArticleInfo paramPublishArticleInfo)
  {
    super(paramPublishArticleInfo);
  }
  
  private final boolean a(PublishArticleInfo paramPublishArticleInfo)
  {
    boolean bool = false;
    if (Intrinsics.areEqual("rijugc", paramPublishArticleInfo.getPublishScene()))
    {
      localObject = paramPublishArticleInfo.getContent();
      localIterator = paramPublishArticleInfo.getContentList().iterator();
      paramPublishArticleInfo = (PublishArticleInfo)localObject;
      while (localIterator.hasNext())
      {
        localObject = (EditObject)localIterator.next();
        if (((EditObject)localObject).getType() == EditObject.EditObjectType.TYPE_AT) {
          paramPublishArticleInfo = StringsKt.replace$default(paramPublishArticleInfo, ((EditObject)localObject).getWording(), "", false, 4, null);
        }
      }
      if (paramPublishArticleInfo == null) {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
      }
      if (((CharSequence)StringsKt.trim((CharSequence)paramPublishArticleInfo).toString()).length() == 0) {
        bool = true;
      }
    }
    while (((CharSequence)paramPublishArticleInfo.getContent()).length() != 0)
    {
      Object localObject;
      Iterator localIterator;
      return bool;
    }
    return true;
  }
  
  public int a()
  {
    int k = 1;
    int m = 0;
    int j = super.a();
    if (j != 0) {}
    label62:
    label67:
    do
    {
      int i;
      do
      {
        return j;
        if (a().getVideoInfo() != null)
        {
          i = 1;
          if (((CharSequence)a().getContent()).length() != 0) {
            break label62;
          }
        }
        for (;;)
        {
          if ((i == 0) || (k == 0)) {
            break label67;
          }
          return 7;
          i = 0;
          break;
          k = 0;
        }
        j = m;
      } while (i != 0);
      j = m;
    } while (k != 0);
    return 8;
  }
  
  public boolean a()
  {
    return (super.a()) && (!a(a()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.publishChecker.RIJUGCPublisherChecker
 * JD-Core Version:    0.7.0.1
 */
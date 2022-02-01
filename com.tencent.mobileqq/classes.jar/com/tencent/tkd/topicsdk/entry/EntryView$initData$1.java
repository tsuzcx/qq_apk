package com.tencent.tkd.topicsdk.entry;

import com.tencent.tkd.topicsdk.bean.ImageInfo;
import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import com.tencent.tkd.topicsdk.bean.VideoInfo;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "invoke"}, k=3, mv={1, 1, 16})
final class EntryView$initData$1
  extends Lambda
  implements Function1<PublishArticleInfo, Unit>
{
  EntryView$initData$1(EntryView paramEntryView)
  {
    super(1);
  }
  
  public final void invoke(@Nullable PublishArticleInfo paramPublishArticleInfo)
  {
    if (this.this$0.b())
    {
      if (paramPublishArticleInfo != null)
      {
        EntryView.a(this.this$0, paramPublishArticleInfo.getPublishId());
        Object localObject = paramPublishArticleInfo.getImageList();
        int i;
        if (localObject != null) {
          if (!((Collection)localObject).isEmpty())
          {
            i = 1;
            if (i == 0) {
              break label97;
            }
            EntryView.b(this.this$0, ((ImageInfo)((ArrayList)localObject).get(0)).getFilePath());
          }
        }
        for (;;)
        {
          if (!paramPublishArticleInfo.isPublishing()) {
            break label120;
          }
          EntryView.b(this.this$0);
          this.this$0.a();
          return;
          i = 0;
          break;
          label97:
          localObject = paramPublishArticleInfo.getVideoInfo();
          if (localObject != null) {
            EntryView.b(this.this$0, ((VideoInfo)localObject).getCoverPath());
          }
        }
        label120:
        EntryView.b(this.this$0);
        EntryView.c(this.this$0);
        this.this$0.a();
        EntryView.d(this.this$0);
        return;
      }
      EntryView.a(this.this$0);
      return;
    }
    if (this.this$0.a())
    {
      EntryView.a(this.this$0);
      return;
    }
    this.this$0.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.entry.EntryView.initData.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.tkd.topicsdk.publisharticle;

import com.tencent.tkd.topicsdk.bean.DisplayItem;
import com.tencent.tkd.topicsdk.bean.Media;
import com.tencent.tkd.topicsdk.bean.MediaType;
import com.tencent.tkd.topicsdk.framework.TLog;
import com.tencent.tkd.topicsdk.mediaselector.BottomSelectorLayout;
import com.tencent.tkd.topicsdk.mediaselector.PanelType;
import com.tencent.tkd.topicsdk.widget.MediaDisplayLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "selectedMedias", "", "Lcom/tencent/tkd/topicsdk/bean/Media;", "invoke"}, k=3, mv={1, 1, 16})
final class PublishArticlePage$initBottomSelectorLayout$5
  extends Lambda
  implements Function1<List<? extends Media>, Unit>
{
  PublishArticlePage$initBottomSelectorLayout$5(PublishArticlePage paramPublishArticlePage)
  {
    super(1);
  }
  
  public final void invoke(@NotNull List<Media> paramList)
  {
    int m = 1;
    Intrinsics.checkParameterIsNotNull(paramList, "selectedMedias");
    TLog.b("PublishArticleFragment", "selectMedia, size=" + paramList.size());
    int i;
    label112:
    int j;
    label135:
    label186:
    ArrayList localArrayList;
    label247:
    DisplayItem localDisplayItem;
    if (!((Collection)PublishArticlePage.a(this.this$0).a()).isEmpty())
    {
      i = 1;
      if ((i == 0) || (((DisplayItem)PublishArticlePage.a(this.this$0).a().get(0)).getMedia().getType() != MediaType.VIDEO) || (PublishArticlePage.a(this.this$0).a() != PanelType.PHOTO)) {
        break label349;
      }
      i = 1;
      if (((Collection)PublishArticlePage.a(this.this$0).a()).isEmpty()) {
        break label354;
      }
      j = 1;
      if ((j == 0) || (((DisplayItem)PublishArticlePage.a(this.this$0).a().get(0)).getMedia().getType() != MediaType.PHOTO) || (PublishArticlePage.a(this.this$0).a() != PanelType.VIDEO)) {
        break label359;
      }
      j = 1;
      int k = m;
      if (paramList.isEmpty()) {
        if (i == 0)
        {
          k = m;
          if (j == 0) {}
        }
        else
        {
          k = 0;
        }
      }
      if (k == 0) {
        return;
      }
      PublishArticlePage.a(this.this$0, paramList);
      localArrayList = new ArrayList();
      Iterator localIterator = ((Iterable)paramList).iterator();
      if (!localIterator.hasNext()) {
        break label370;
      }
      localDisplayItem = new DisplayItem((Media)localIterator.next());
      if (localDisplayItem.getMedia().getType() == MediaType.VIDEO)
      {
        paramList = (String)PublishArticlePage.a(this.this$0).get(localDisplayItem.getMedia().getFilePath());
        if (paramList == null) {
          break label364;
        }
      }
    }
    for (;;)
    {
      localDisplayItem.setMergePath(paramList);
      PublishArticlePage.a(this.this$0, localDisplayItem);
      localArrayList.add(localDisplayItem);
      break label247;
      i = 0;
      break;
      label349:
      i = 0;
      break label112;
      label354:
      j = 0;
      break label135;
      label359:
      j = 0;
      break label186;
      label364:
      paramList = "";
    }
    label370:
    PublishArticlePage.a(this.this$0).setDisplayItems(localArrayList);
    PublishArticlePage.a(this.this$0);
    PublishArticlePage.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishArticlePage.initBottomSelectorLayout.5
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.tkd.topicsdk.adapter.publisharticle;

import android.widget.RelativeLayout;
import com.tencent.tkd.topicsdk.adapter.widget.BigVideoCoverLayout;
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
final class PublishArticlePage$initBottomSelectorLayout$4
  extends Lambda
  implements Function1<List<? extends Media>, Unit>
{
  PublishArticlePage$initBottomSelectorLayout$4(PublishArticlePage paramPublishArticlePage)
  {
    super(1);
  }
  
  public final void invoke(@NotNull List<Media> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "selectedMedias");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("selectMedia, size=");
    ((StringBuilder)localObject).append(paramList.size());
    TLog.b("PublishArticleFragment", ((StringBuilder)localObject).toString());
    int i;
    if (((((Collection)PublishArticlePage.a(this.this$0).a()).isEmpty() ^ true)) && (((DisplayItem)PublishArticlePage.a(this.this$0).a().get(0)).getMedia().getType() == MediaType.VIDEO) && (PublishArticlePage.a(this.this$0).a() == PanelType.PHOTO)) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (((((Collection)PublishArticlePage.a(this.this$0).a()).isEmpty() ^ true)) && (((DisplayItem)PublishArticlePage.a(this.this$0).a().get(0)).getMedia().getType() == MediaType.PHOTO) && (PublishArticlePage.a(this.this$0).a() == PanelType.VIDEO)) {
      j = 1;
    } else {
      j = 0;
    }
    if ((paramList.isEmpty()) && ((i != 0) || (j != 0))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      PublishArticlePage.a(this.this$0, paramList);
      localObject = new ArrayList();
      Iterator localIterator = ((Iterable)paramList).iterator();
      while (localIterator.hasNext())
      {
        DisplayItem localDisplayItem = new DisplayItem((Media)localIterator.next());
        if (localDisplayItem.getMedia().getType() == MediaType.VIDEO)
        {
          paramList = (String)PublishArticlePage.a(this.this$0).get(localDisplayItem.getMedia().getFilePath());
          if (paramList == null) {
            paramList = "";
          }
          localDisplayItem.setMergePath(paramList);
          PublishArticlePage.a(this.this$0, localDisplayItem);
        }
        ((ArrayList)localObject).add(localDisplayItem);
      }
      if (((((Collection)localObject).isEmpty() ^ true)) && (((DisplayItem)((ArrayList)localObject).get(0)).getMedia().getType() == MediaType.VIDEO))
      {
        PublishArticlePage.a(this.this$0).setVisibility(0);
        PublishArticlePage.a(this.this$0).setVisibility(8);
        PublishArticlePage.a(this.this$0).setDisplayItem((DisplayItem)((ArrayList)localObject).get(0));
        PublishArticlePage.a(this.this$0).setDisplayItems(new ArrayList());
      }
      else
      {
        PublishArticlePage.a(this.this$0).setVisibility(8);
        PublishArticlePage.a(this.this$0).setVisibility(0);
        PublishArticlePage.a(this.this$0).setDisplayItems((ArrayList)localObject);
        PublishArticlePage.a(this.this$0).setDisplayItem((DisplayItem)null);
      }
      PublishArticlePage.a(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.adapter.publisharticle.PublishArticlePage.initBottomSelectorLayout.4
 * JD-Core Version:    0.7.0.1
 */
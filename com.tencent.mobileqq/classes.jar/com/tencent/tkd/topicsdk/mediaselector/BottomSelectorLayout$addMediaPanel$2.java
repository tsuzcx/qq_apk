package com.tencent.tkd.topicsdk.mediaselector;

import android.view.View;
import com.tencent.tkd.topicsdk.bean.Media;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "Lcom/tencent/tkd/topicsdk/bean/Media;", "invoke"}, k=3, mv={1, 1, 16})
final class BottomSelectorLayout$addMediaPanel$2
  extends Lambda
  implements Function1<List<? extends Media>, Unit>
{
  BottomSelectorLayout$addMediaPanel$2(BottomSelectorLayout paramBottomSelectorLayout, MediaSelectorPanel paramMediaSelectorPanel)
  {
    super(1);
  }
  
  public final void invoke(@NotNull List<Media> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "it");
    if ((((Collection)paramList).isEmpty() ^ true))
    {
      localObject = ((Iterable)BottomSelectorLayout.a(this.this$0).b()).iterator();
      while (((Iterator)localObject).hasNext())
      {
        View localView = (View)((Iterator)localObject).next();
        if (((Intrinsics.areEqual(localView, this.$mediaSelectorView) ^ true)) && ((localView instanceof MediaSelectorPanel))) {
          ((MediaSelectorPanel)localView).a();
        }
      }
    }
    Object localObject = this.this$0.a();
    if (localObject != null) {
      paramList = (Unit)((Function1)localObject).invoke(paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mediaselector.BottomSelectorLayout.addMediaPanel.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.tkd.topicsdk.mediaselector;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class MediaSelectorPanel$updateSelectMediaList$1$1
  extends Lambda
  implements Function0<Unit>
{
  MediaSelectorPanel$updateSelectMediaList$1$1(MediaSelectorPanel.updateSelectMediaList.1 param1, List paramList)
  {
    super(0);
  }
  
  public final void invoke()
  {
    this.this$0.this$0.getSelectedMedias().addAll((Collection)this.$tempSelectedMediaList);
    Object localObject = this.this$0.this$0.getOnSelectChangeListener();
    if (localObject != null) {
      localObject = (Unit)((Function1)localObject).invoke(this.$tempSelectedMediaList);
    }
    MediaSelectorPanel.a(this.this$0.this$0).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mediaselector.MediaSelectorPanel.updateSelectMediaList.1.1
 * JD-Core Version:    0.7.0.1
 */
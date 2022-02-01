package com.tencent.tkd.topicsdk.mediaselector;

import com.tencent.tkd.topicsdk.bean.Media;
import com.tencent.tkd.topicsdk.framework.ThreadManagerKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class MediaSelectorPanel$updateSelectMediaList$1
  extends Lambda
  implements Function0<Unit>
{
  MediaSelectorPanel$updateSelectMediaList$1(MediaSelectorPanel paramMediaSelectorPanel, ArrayList paramArrayList)
  {
    super(0);
  }
  
  public final void invoke()
  {
    Object localObject1 = (Iterable)this.this$0.a();
    Collection localCollection = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      Media localMedia = (Media)localObject2;
      if (this.$selectMediaList.contains(localMedia.getFilePath())) {
        localCollection.add(localObject2);
      }
    }
    ThreadManagerKt.a((Function0)new MediaSelectorPanel.updateSelectMediaList.1.1(this, (List)localCollection));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mediaselector.MediaSelectorPanel.updateSelectMediaList.1
 * JD-Core Version:    0.7.0.1
 */
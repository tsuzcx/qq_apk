package com.tencent.tmediacodec.preload;

import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 15})
final class PreloadCodecManager$preload$1
  implements Runnable
{
  PreloadCodecManager$preload$1(PreloadCodecManager paramPreloadCodecManager, Set paramSet) {}
  
  public final void run()
  {
    Iterator localIterator = ((Iterable)this.$sampleMimeTypeSet).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (PreloadCodecManager.Companion.isInvalideMimeType(str)) {
        PreloadCodecManager.access$preloadCodecByMimeType(this.this$0, str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmediacodec.preload.PreloadCodecManager.preload.1
 * JD-Core Version:    0.7.0.1
 */
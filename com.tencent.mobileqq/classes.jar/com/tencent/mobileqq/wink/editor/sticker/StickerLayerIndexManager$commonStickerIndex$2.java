package com.tencent.mobileqq.wink.editor.sticker;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Ljava/util/concurrent/atomic/AtomicInteger;", "invoke"}, k=3, mv={1, 1, 16})
final class StickerLayerIndexManager$commonStickerIndex$2
  extends Lambda
  implements Function0<AtomicInteger>
{
  public static final 2 INSTANCE = new 2();
  
  StickerLayerIndexManager$commonStickerIndex$2()
  {
    super(0);
  }
  
  @NotNull
  public final AtomicInteger invoke()
  {
    return new AtomicInteger(65536);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.sticker.StickerLayerIndexManager.commonStickerIndex.2
 * JD-Core Version:    0.7.0.1
 */
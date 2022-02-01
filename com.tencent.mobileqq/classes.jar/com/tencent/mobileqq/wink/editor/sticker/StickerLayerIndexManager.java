package com.tencent.mobileqq.wink.editor.sticker;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/sticker/StickerLayerIndexManager;", "", "()V", "commonStickerIndex", "Ljava/util/concurrent/atomic/AtomicInteger;", "getCommonStickerIndex", "()Ljava/util/concurrent/atomic/AtomicInteger;", "commonStickerIndex$delegate", "Lkotlin/Lazy;", "commonStickerIndexStart", "", "reservedStickerIndex", "getReservedStickerIndex", "reservedStickerIndex$delegate", "reservedStickerIndexStart", "getCommonStickerLayerIndex", "getReservedStickerLayerIndex", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class StickerLayerIndexManager
{
  public static final StickerLayerIndexManager a = new StickerLayerIndexManager();
  private static final Lazy b = LazyKt.lazy((Function0)StickerLayerIndexManager.reservedStickerIndex.2.INSTANCE);
  private static final Lazy c = LazyKt.lazy((Function0)StickerLayerIndexManager.commonStickerIndex.2.INSTANCE);
  
  private final AtomicInteger b()
  {
    return (AtomicInteger)c.getValue();
  }
  
  public final int a()
  {
    return b().getAndIncrement();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.sticker.StickerLayerIndexManager
 * JD-Core Version:    0.7.0.1
 */
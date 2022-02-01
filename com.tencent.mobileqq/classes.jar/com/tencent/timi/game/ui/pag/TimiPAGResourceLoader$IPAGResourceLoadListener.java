package com.tencent.timi.game.ui.pag;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.libpag.PAGFile;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/ui/pag/TimiPAGResourceLoader$IPAGResourceLoadListener;", "", "onPAGResourceLoad", "", "url", "", "pagFile", "Lorg/libpag/PAGFile;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface TimiPAGResourceLoader$IPAGResourceLoadListener
{
  public abstract void a(@NotNull String paramString, @NotNull PAGFile paramPAGFile);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.ui.pag.TimiPAGResourceLoader.IPAGResourceLoadListener
 * JD-Core Version:    0.7.0.1
 */
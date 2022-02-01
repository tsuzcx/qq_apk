package com.tencent.timi.game.liveroom.impl.widget;

import com.tencent.timi.game.ui.pag.TimiPAGResourceLoader.IPAGResourceLoadListener;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.libpag.PAGFile;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/widget/GiftEntranceView$giftEntrancePAGDownloadListener$1", "Lcom/tencent/timi/game/ui/pag/TimiPAGResourceLoader$IPAGResourceLoadListener;", "onPAGResourceLoad", "", "url", "", "pagFile", "Lorg/libpag/PAGFile;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class GiftEntranceView$giftEntrancePAGDownloadListener$1
  implements TimiPAGResourceLoader.IPAGResourceLoadListener
{
  public void a(@NotNull String paramString, @NotNull PAGFile paramPAGFile)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    Intrinsics.checkParameterIsNotNull(paramPAGFile, "pagFile");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPAGResourceLoad# isPlaying: ");
    localStringBuilder.append(GiftEntranceView.a(this.a));
    localStringBuilder.append(" playCalled ");
    localStringBuilder.append(GiftEntranceView.b(this.a));
    Logger.c("GiftEntranceView", localStringBuilder.toString());
    if ((GiftEntranceView.b(this.a)) && (Intrinsics.areEqual(paramString, "https://cdn.yes.qq.com/client_business/gift_entrance_2.pag"))) {
      this.a.a(paramPAGFile);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.widget.GiftEntranceView.giftEntrancePAGDownloadListener.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.timi.game.liveroom.impl.widget;

import com.tencent.timi.game.initer.api.OnPAGLibraryLoadedListener;
import com.tencent.timi.game.ui.pag.TimiPAGResourceLoader;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import org.libpag.PAGFile;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/widget/GiftEntranceView$onPAGLibraryLoadedListener$1", "Lcom/tencent/timi/game/initer/api/OnPAGLibraryLoadedListener;", "onLoaded", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class GiftEntranceView$onPAGLibraryLoadedListener$1
  implements OnPAGLibraryLoadedListener
{
  public void a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onLoaded# isPlaying: ");
    ((StringBuilder)localObject).append(GiftEntranceView.a(this.a));
    ((StringBuilder)localObject).append(" playCalled ");
    ((StringBuilder)localObject).append(GiftEntranceView.b(this.a));
    Logger.c("GiftEntranceView", ((StringBuilder)localObject).toString());
    GiftEntranceView.c(this.a);
    if (GiftEntranceView.b(this.a))
    {
      localObject = TimiPAGResourceLoader.a(TimiPAGResourceLoader.a, "https://cdn.yes.qq.com/client_business/gift_entrance_2.pag", null, 2, null);
      if (localObject != null) {
        GiftEntranceView.a(this.a, (PAGFile)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.widget.GiftEntranceView.onPAGLibraryLoadedListener.1
 * JD-Core Version:    0.7.0.1
 */
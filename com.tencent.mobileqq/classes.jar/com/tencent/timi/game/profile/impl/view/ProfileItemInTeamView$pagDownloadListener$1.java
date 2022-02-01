package com.tencent.timi.game.profile.impl.view;

import com.tencent.timi.game.ui.pag.TimiPAGResourceLoader.IPAGResourceLoadListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.libpag.PAGFile;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/profile/impl/view/ProfileItemInTeamView$pagDownloadListener$1", "Lcom/tencent/timi/game/ui/pag/TimiPAGResourceLoader$IPAGResourceLoadListener;", "onPAGResourceLoad", "", "url", "", "pagFile", "Lorg/libpag/PAGFile;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class ProfileItemInTeamView$pagDownloadListener$1
  implements TimiPAGResourceLoader.IPAGResourceLoadListener
{
  public void a(@NotNull String paramString, @NotNull PAGFile paramPAGFile)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    Intrinsics.checkParameterIsNotNull(paramPAGFile, "pagFile");
    if (!ProfileItemInTeamView.e(this.a)) {
      ProfileItemInTeamView.a(this.a, paramPAGFile);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.profile.impl.view.ProfileItemInTeamView.pagDownloadListener.1
 * JD-Core Version:    0.7.0.1
 */
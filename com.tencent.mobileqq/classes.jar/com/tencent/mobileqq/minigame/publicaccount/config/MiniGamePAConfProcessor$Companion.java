package com.tencent.mobileqq.minigame.publicaccount.config;

import com.tencent.mobileqq.config.QConfigManager;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/minigame/publicaccount/config/MiniGamePAConfProcessor$Companion;", "", "()V", "CONFIG_ID", "", "TAG", "", "loadConfig", "Lcom/tencent/mobileqq/minigame/publicaccount/config/MiniGamePAConfBean;", "qqmini_impl_release"}, k=1, mv={1, 1, 16})
public final class MiniGamePAConfProcessor$Companion
{
  @JvmStatic
  @NotNull
  public final MiniGamePAConfBean loadConfig()
  {
    MiniGamePAConfBean localMiniGamePAConfBean = (MiniGamePAConfBean)QConfigManager.b().b(741);
    if (localMiniGamePAConfBean != null) {
      return localMiniGamePAConfBean;
    }
    return new MiniGamePAConfBean();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.config.MiniGamePAConfProcessor.Companion
 * JD-Core Version:    0.7.0.1
 */
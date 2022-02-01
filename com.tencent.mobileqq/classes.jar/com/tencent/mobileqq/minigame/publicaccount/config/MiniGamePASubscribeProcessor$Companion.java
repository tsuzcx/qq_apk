package com.tencent.mobileqq.minigame.publicaccount.config;

import com.tencent.mobileqq.config.QConfigManager;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/minigame/publicaccount/config/MiniGamePASubscribeProcessor$Companion;", "", "()V", "CONFIG_ID", "", "TAG", "", "loadConfig", "Lcom/tencent/mobileqq/minigame/publicaccount/config/MiniGamePASubscribeConfBean;", "qqmini_impl_release"}, k=1, mv={1, 1, 16})
public final class MiniGamePASubscribeProcessor$Companion
{
  @JvmStatic
  @NotNull
  public final MiniGamePASubscribeConfBean loadConfig()
  {
    MiniGamePASubscribeConfBean localMiniGamePASubscribeConfBean = (MiniGamePASubscribeConfBean)QConfigManager.b().b(762);
    if (localMiniGamePASubscribeConfBean != null) {
      return localMiniGamePASubscribeConfBean;
    }
    return new MiniGamePASubscribeConfBean(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.config.MiniGamePASubscribeProcessor.Companion
 * JD-Core Version:    0.7.0.1
 */
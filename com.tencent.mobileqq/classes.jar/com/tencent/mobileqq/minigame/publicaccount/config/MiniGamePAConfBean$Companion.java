package com.tencent.mobileqq.minigame.publicaccount.config;

import com.tencent.mobileqq.jsonconverter.JSONConverter;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/minigame/publicaccount/config/MiniGamePAConfBean$Companion;", "", "()V", "convertFromJSONObject", "Lcom/tencent/mobileqq/minigame/publicaccount/config/MiniGamePAConfBean;", "content", "", "qqmini_impl_release"}, k=1, mv={1, 1, 16})
public final class MiniGamePAConfBean$Companion
{
  @Nullable
  public final MiniGamePAConfBean convertFromJSONObject(@Nullable String paramString)
  {
    return (MiniGamePAConfBean)JSONConverter.a(paramString, MiniGamePAConfBean.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.config.MiniGamePAConfBean.Companion
 * JD-Core Version:    0.7.0.1
 */
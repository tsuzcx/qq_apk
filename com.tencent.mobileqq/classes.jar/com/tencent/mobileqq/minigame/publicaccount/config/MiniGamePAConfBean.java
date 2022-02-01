package com.tencent.mobileqq.minigame.publicaccount.config;

import com.tencent.mobileqq.jsonconverter.Alias;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/minigame/publicaccount/config/MiniGamePAConfBean;", "", "()V", "enable", "", "getEnable", "()I", "setEnable", "(I)V", "enableDomain", "", "getEnableDomain", "()Ljava/lang/String;", "setEnableDomain", "(Ljava/lang/String;)V", "openParams", "Lcom/tencent/mobileqq/minigame/publicaccount/config/OpenHippyParam;", "getOpenParams", "()Lcom/tencent/mobileqq/minigame/publicaccount/config/OpenHippyParam;", "setOpenParams", "(Lcom/tencent/mobileqq/minigame/publicaccount/config/OpenHippyParam;)V", "Companion", "qqmini_impl_release"}, k=1, mv={1, 1, 16})
public final class MiniGamePAConfBean
{
  public static final MiniGamePAConfBean.Companion Companion = new MiniGamePAConfBean.Companion(null);
  @Alias(a="enable")
  private int enable;
  @Alias(a="enableDomain")
  @Nullable
  private String enableDomain;
  @Alias(a="openParams")
  @Nullable
  private OpenHippyParam openParams;
  
  public final int getEnable()
  {
    return this.enable;
  }
  
  @Nullable
  public final String getEnableDomain()
  {
    return this.enableDomain;
  }
  
  @Nullable
  public final OpenHippyParam getOpenParams()
  {
    return this.openParams;
  }
  
  public final void setEnable(int paramInt)
  {
    this.enable = paramInt;
  }
  
  public final void setEnableDomain(@Nullable String paramString)
  {
    this.enableDomain = paramString;
  }
  
  public final void setOpenParams(@Nullable OpenHippyParam paramOpenHippyParam)
  {
    this.openParams = paramOpenHippyParam;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.config.MiniGamePAConfBean
 * JD-Core Version:    0.7.0.1
 */
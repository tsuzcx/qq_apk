package com.tencent.mobileqq.config.business.avatar;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/config/business/avatar/DynamicAvatarConfBean;", "", "content", "", "config", "Lcom/tencent/mobileqq/config/business/avatar/DynamicAvatarConfBean$DynamicAvatarConfig;", "(Ljava/lang/String;Lcom/tencent/mobileqq/config/business/avatar/DynamicAvatarConfBean$DynamicAvatarConfig;)V", "()V", "mConfig", "mContent", "getConfig", "getContent", "isEmpty", "", "Companion", "DynamicAvatarConfig", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class DynamicAvatarConfBean
{
  public static final DynamicAvatarConfBean.Companion a = new DynamicAvatarConfBean.Companion(null);
  private String b = "";
  private DynamicAvatarConfBean.DynamicAvatarConfig c = new DynamicAvatarConfBean.DynamicAvatarConfig();
  
  public DynamicAvatarConfBean() {}
  
  public DynamicAvatarConfBean(@NotNull String paramString, @Nullable DynamicAvatarConfBean.DynamicAvatarConfig paramDynamicAvatarConfig)
  {
    this();
    this.b = paramString;
    this.c = paramDynamicAvatarConfig;
  }
  
  @Nullable
  public final DynamicAvatarConfBean.DynamicAvatarConfig a()
  {
    DynamicAvatarConfBean.DynamicAvatarConfig localDynamicAvatarConfig = this.c;
    if (localDynamicAvatarConfig != null) {
      return localDynamicAvatarConfig;
    }
    return new DynamicAvatarConfBean.DynamicAvatarConfig();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.avatar.DynamicAvatarConfBean
 * JD-Core Version:    0.7.0.1
 */
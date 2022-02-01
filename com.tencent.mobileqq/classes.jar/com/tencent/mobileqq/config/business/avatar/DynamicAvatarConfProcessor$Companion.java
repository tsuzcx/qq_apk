package com.tencent.mobileqq.config.business.avatar;

import com.tencent.mobileqq.config.QConfigManager;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/config/business/avatar/DynamicAvatarConfProcessor$Companion;", "", "()V", "CONFIG_ID", "", "TAG", "", "loadConfig", "Lcom/tencent/mobileqq/config/business/avatar/DynamicAvatarConfBean;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class DynamicAvatarConfProcessor$Companion
{
  @NotNull
  public final DynamicAvatarConfBean a()
  {
    DynamicAvatarConfBean localDynamicAvatarConfBean = (DynamicAvatarConfBean)QConfigManager.b().b(726);
    if (localDynamicAvatarConfBean != null) {
      return localDynamicAvatarConfBean;
    }
    return new DynamicAvatarConfBean();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.avatar.DynamicAvatarConfProcessor.Companion
 * JD-Core Version:    0.7.0.1
 */
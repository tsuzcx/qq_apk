package com.tencent.mobileqq.config.business.avatar;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/config/business/avatar/DynamicAvatarConfBean;", "", "content", "", "config", "Lcom/tencent/mobileqq/config/business/avatar/DynamicAvatarConfBean$DynamicAvatarConfig;", "(Ljava/lang/String;Lcom/tencent/mobileqq/config/business/avatar/DynamicAvatarConfBean$DynamicAvatarConfig;)V", "()V", "mConfig", "mContent", "getConfig", "getContent", "isEmpty", "", "Companion", "DynamicAvatarConfig", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class DynamicAvatarConfBean
{
  public static final DynamicAvatarConfBean.Companion a;
  private DynamicAvatarConfBean.DynamicAvatarConfig jdField_a_of_type_ComTencentMobileqqConfigBusinessAvatarDynamicAvatarConfBean$DynamicAvatarConfig = new DynamicAvatarConfBean.DynamicAvatarConfig();
  private String jdField_a_of_type_JavaLangString = "";
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqConfigBusinessAvatarDynamicAvatarConfBean$Companion = new DynamicAvatarConfBean.Companion(null);
  }
  
  public DynamicAvatarConfBean() {}
  
  public DynamicAvatarConfBean(@NotNull String paramString, @Nullable DynamicAvatarConfBean.DynamicAvatarConfig paramDynamicAvatarConfig)
  {
    this();
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqConfigBusinessAvatarDynamicAvatarConfBean$DynamicAvatarConfig = paramDynamicAvatarConfig;
  }
  
  @Nullable
  public final DynamicAvatarConfBean.DynamicAvatarConfig a()
  {
    DynamicAvatarConfBean.DynamicAvatarConfig localDynamicAvatarConfig = this.jdField_a_of_type_ComTencentMobileqqConfigBusinessAvatarDynamicAvatarConfBean$DynamicAvatarConfig;
    if (localDynamicAvatarConfig != null) {
      return localDynamicAvatarConfig;
    }
    return new DynamicAvatarConfBean.DynamicAvatarConfig();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.avatar.DynamicAvatarConfBean
 * JD-Core Version:    0.7.0.1
 */
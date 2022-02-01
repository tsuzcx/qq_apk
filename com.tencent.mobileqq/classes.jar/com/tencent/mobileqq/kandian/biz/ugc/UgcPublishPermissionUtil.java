package com.tencent.mobileqq.kandian.biz.ugc;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/ugc/UgcPublishPermissionUtil;", "", "()V", "hasCreateColumnPermissions", "", "publishEntranceDisplayEnable", "publishLevelLimitEnable", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class UgcPublishPermissionUtil
{
  public static final UgcPublishPermissionUtil a = new UgcPublishPermissionUtil();
  
  public final boolean a()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(388);
    boolean bool = false;
    if (localAladdinConfig.getIntegerFromString("publish_permission_binding_level", 0) > 0) {
      bool = true;
    }
    return bool;
  }
  
  public final boolean b()
  {
    return Aladdin.getConfig(388).getIntegerFromString("publish_entrance_display", 1) > 0;
  }
  
  public final boolean c()
  {
    return Aladdin.getConfig(388).getIntegerFromString("create_column_permissions", 1) > 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.UgcPublishPermissionUtil
 * JD-Core Version:    0.7.0.1
 */
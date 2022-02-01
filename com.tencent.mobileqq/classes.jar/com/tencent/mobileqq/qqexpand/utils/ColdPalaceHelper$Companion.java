package com.tencent.mobileqq.qqexpand.utils;

import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/utils/ColdPalaceHelper$Companion;", "", "()V", "COLD_PALACE_IMAGE_URL", "", "PUNISH_FOREVER", "", "PUNISH_NONE", "SP_FILE", "SP_KEY_ME_IN_COLD_PALACE_TIMES", "SP_KEY_PUNISH_LEFT_TIME", "SP_KEY_PUNISH_TIME_SINCE", "SP_KEY_SHOW_GRAY_TIP_ENTRY", "SP_KEY_SKILL_TIP", "SP_KEY_SKILL_USEUP_TIP", "SP_KEY_SKILL_USEUP_TITLE", "SP_KEY_WARN_ME_FORBBIDEN", "SP_KEY_WARN_ME_IN_COLDPALACE", "TAG", "type_skill_tip", "", "type_skill_useup_tip", "type_skill_useup_title", "type_warn_free_time_tip", "type_warn_me_forbbiden", "type_warn_me_in_coldpalace_tip", "getHelper", "Lcom/tencent/mobileqq/qqexpand/utils/ColdPalaceHelper;", "app", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "isExtendMsgRspType", "", "ntRspType", "qqexpand_impl_release"}, k=1, mv={1, 1, 16})
public final class ColdPalaceHelper$Companion
{
  @JvmStatic
  @NotNull
  public final ColdPalaceHelper a(@NotNull BaseQQAppInterface paramBaseQQAppInterface)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseQQAppInterface, "app");
    paramBaseQQAppInterface = ((IColdPalaceUtils)QRoute.api(IColdPalaceUtils.class)).getColdPalaceHelper((AppInterface)paramBaseQQAppInterface);
    if (paramBaseQQAppInterface != null) {
      return (ColdPalaceHelper)paramBaseQQAppInterface;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.qqexpand.utils.ColdPalaceHelper");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.utils.ColdPalaceHelper.Companion
 * JD-Core Version:    0.7.0.1
 */
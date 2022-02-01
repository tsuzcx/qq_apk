package com.tencent.mobileqq.kandian.repo.common.api.impl;

import com.tencent.mobileqq.kandian.repo.common.ReadInJoySrtUtils;
import com.tencent.mobileqq.kandian.repo.common.api.IReadInJoySrtUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0x64e.oidb_cmd0x64e.SRTClickInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/common/api/impl/ReadInJoySrtUtilsImpl;", "Lcom/tencent/mobileqq/kandian/repo/common/api/IReadInJoySrtUtils;", "()V", "getNoDifferenceDiversionInfo", "Ltencent/im/oidb/cmd0x64e/oidb_cmd0x64e$SRTClickInfo;", "judgeHasSrtInfoHandle", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoySrtUtilsImpl
  implements IReadInJoySrtUtils
{
  @Nullable
  public oidb_cmd0x64e.SRTClickInfo getNoDifferenceDiversionInfo()
  {
    ReadInJoySrtUtils localReadInJoySrtUtils = ReadInJoySrtUtils.a();
    Intrinsics.checkExpressionValueIsNotNull(localReadInJoySrtUtils, "ReadInJoySrtUtils.getInstance()");
    return localReadInJoySrtUtils.b();
  }
  
  public boolean judgeHasSrtInfoHandle()
  {
    return ReadInJoySrtUtils.a().e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.common.api.impl.ReadInJoySrtUtilsImpl
 * JD-Core Version:    0.7.0.1
 */
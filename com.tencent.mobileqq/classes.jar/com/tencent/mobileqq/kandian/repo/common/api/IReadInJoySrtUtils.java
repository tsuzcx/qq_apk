package com.tencent.mobileqq.kandian.repo.common.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0x64e.oidb_cmd0x64e.SRTClickInfo;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/common/api/IReadInJoySrtUtils;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getNoDifferenceDiversionInfo", "Ltencent/im/oidb/cmd0x64e/oidb_cmd0x64e$SRTClickInfo;", "judgeHasSrtInfoHandle", "", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IReadInJoySrtUtils
  extends QRouteApi
{
  @Nullable
  public abstract oidb_cmd0x64e.SRTClickInfo getNoDifferenceDiversionInfo();
  
  public abstract boolean judgeHasSrtInfoHandle();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.common.api.IReadInJoySrtUtils
 * JD-Core Version:    0.7.0.1
 */
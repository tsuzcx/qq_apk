package com.tencent.mobileqq.kandian.biz.common.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.persistence.Entity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/common/api/impl/PublicAccountReportUtilsImpl;", "Lcom/tencent/mobileqq/kandian/biz/common/api/IPublicAccountReportUtils;", "()V", "changeToUTF8", "", "str", "doVideoDataReportWithFansInfoInR5", "", "app", "Lcom/tencent/common/app/AppInterface;", "toUin", "subAction", "actionName", "fromType", "", "result", "r2", "r3", "r4", "r5", "shouldEncode", "", "publicAccountReportClickEvent", "publicAccountReportClickEventForMigrate", "tag", "mainAction", "publicAccountSimpleReportWithR5", "action", "from", "reportFollowEvent", "puin", "source", "reportLabelsClick", "articleInfo", "Lcom/tencent/mobileqq/persistence/Entity;", "reportPAinfoToLighthouse", "t", "d1", "d2", "d3", "d4", "reportPubAccMsg", "list", "", "Lcom/tencent/mobileqq/data/MessageRecord;", "videoDataReportWithFansInfoInR5", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class PublicAccountReportUtilsImpl
  implements IPublicAccountReportUtils
{
  @NotNull
  public String changeToUTF8(@Nullable String paramString)
  {
    paramString = PublicAccountReportUtils.a(paramString);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "PublicAccountReportUtils.changeToUTF8(str)");
    return paramString;
  }
  
  public void doVideoDataReportWithFansInfoInR5(@Nullable AppInterface paramAppInterface, @Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, int paramInt1, int paramInt2, @Nullable String paramString4, @Nullable String paramString5, @Nullable String paramString6, @Nullable String paramString7, boolean paramBoolean)
  {
    PublicAccountReportUtils.c(paramAppInterface, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramString4, paramString5, paramString6, paramString7, paramBoolean);
  }
  
  public void publicAccountReportClickEvent(@Nullable AppInterface paramAppInterface, @Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, int paramInt1, int paramInt2, @Nullable String paramString4, @Nullable String paramString5, @Nullable String paramString6, @Nullable String paramString7)
  {
    PublicAccountReportUtils.a(paramAppInterface, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramString4, paramString5, paramString6, paramString7);
  }
  
  public void publicAccountReportClickEvent(@Nullable AppInterface paramAppInterface, @Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, int paramInt1, int paramInt2, @Nullable String paramString4, @Nullable String paramString5, @Nullable String paramString6, @Nullable String paramString7, boolean paramBoolean)
  {
    PublicAccountReportUtils.a(paramAppInterface, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramString4, paramString5, paramString6, paramString7, paramBoolean);
  }
  
  public void publicAccountReportClickEventForMigrate(@Nullable AppInterface paramAppInterface, @Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @Nullable String paramString4, @Nullable String paramString5, int paramInt1, int paramInt2, @Nullable String paramString6, @Nullable String paramString7, @Nullable String paramString8, @Nullable String paramString9)
  {
    PublicAccountReportUtils.a(paramAppInterface, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
  }
  
  public void publicAccountReportClickEventForMigrate(@Nullable AppInterface paramAppInterface, @Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @Nullable String paramString4, @Nullable String paramString5, int paramInt1, int paramInt2, @Nullable String paramString6, @Nullable String paramString7, @Nullable String paramString8, @Nullable String paramString9, boolean paramBoolean)
  {
    PublicAccountReportUtils.a(paramAppInterface, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9, paramBoolean);
  }
  
  public void publicAccountSimpleReportWithR5(@Nullable String paramString1, int paramInt, @Nullable String paramString2)
  {
    PublicAccountReportUtils.a(paramString1, paramInt, paramString2);
  }
  
  public void publicAccountSimpleReportWithR5(@Nullable String paramString1, @Nullable String paramString2)
  {
    PublicAccountReportUtils.a(paramString1, paramString2);
  }
  
  public void reportFollowEvent(@Nullable AppInterface paramAppInterface, @Nullable String paramString, int paramInt)
  {
    PublicAccountReportUtils.a(paramAppInterface, paramString, paramInt);
  }
  
  public void reportLabelsClick(@Nullable Entity paramEntity)
  {
    PublicAccountReportUtils.a(paramEntity);
  }
  
  public void reportPAinfoToLighthouse(@Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @Nullable String paramString4, @Nullable String paramString5, @Nullable String paramString6)
  {
    PublicAccountReportUtils.a(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6);
  }
  
  public void reportPubAccMsg(@Nullable List<MessageRecord> paramList)
  {
    PublicAccountReportUtils.a(paramList);
  }
  
  public void videoDataReportWithFansInfoInR5(@Nullable AppInterface paramAppInterface, @Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, int paramInt1, int paramInt2, @Nullable String paramString4, @Nullable String paramString5, @Nullable String paramString6, @Nullable String paramString7, boolean paramBoolean)
  {
    PublicAccountReportUtils.b(paramAppInterface, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramString4, paramString5, paramString6, paramString7, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtilsImpl
 * JD-Core Version:    0.7.0.1
 */
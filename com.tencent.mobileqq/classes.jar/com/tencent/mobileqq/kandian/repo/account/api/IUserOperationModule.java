package com.tencent.mobileqq.kandian.repo.account.api;

import com.tencent.mobileqq.kandian.repo.report.ReportInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/account/api/IUserOperationModule;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getKandianTopFromServer", "", "uin", "", "request0x64eKandianActionReport", "info", "", "Lcom/tencent/mobileqq/kandian/repo/report/ReportInfo;", "reportFolderStatus", "", "request0x64eUserOperationReport", "list", "request0x80aPushEffectEvent", "eventId", "eventName", "version", "attris", "Ltencent/im/oidb/cmd0x80a/oidb_cmd0x80a$AttributeList;", "cmd", "command", "request0x978", "selfUin", "followUin", "isFollow", "", "avatarUrl", "callback", "Lcom/tencent/mobileqq/kandian/repo/account/api/Ox978RespCallBack;", "followAccountType", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IUserOperationModule
  extends QRouteApi
{
  public abstract void getKandianTopFromServer(@Nullable String paramString);
  
  public abstract void request0x64eKandianActionReport(@Nullable List<? extends ReportInfo> paramList, int paramInt);
  
  public abstract void request0x64eUserOperationReport(@Nullable List<? extends ReportInfo> paramList);
  
  public abstract void request0x80aPushEffectEvent(int paramInt1, @Nullable String paramString1, int paramInt2, @Nullable List<oidb_cmd0x80a.AttributeList> paramList, @Nullable String paramString2, int paramInt3);
  
  public abstract void request0x80aPushEffectEvent(int paramInt, @Nullable String paramString, @Nullable List<oidb_cmd0x80a.AttributeList> paramList);
  
  public abstract void request0x978(@Nullable String paramString1, @Nullable String paramString2, boolean paramBoolean, @Nullable String paramString3, @Nullable Ox978RespCallBack paramOx978RespCallBack);
  
  public abstract void request0x978(@Nullable String paramString1, @Nullable String paramString2, boolean paramBoolean, @Nullable String paramString3, @Nullable Ox978RespCallBack paramOx978RespCallBack, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.account.api.IUserOperationModule
 * JD-Core Version:    0.7.0.1
 */
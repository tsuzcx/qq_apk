package com.tencent.mobileqq.kandian.repo.account.api.impl;

import com.tencent.mobileqq.kandian.repo.account.api.IUserOperationModule;
import com.tencent.mobileqq.kandian.repo.account.api.Ox978RespCallBack;
import com.tencent.mobileqq.kandian.repo.report.ReportInfo;
import com.tencent.mobileqq.kandian.repo.report.UserOperationModule;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/account/api/impl/UserOperationModuleImpl;", "Lcom/tencent/mobileqq/kandian/repo/account/api/IUserOperationModule;", "()V", "getKandianTopFromServer", "", "uin", "", "request0x64eKandianActionReport", "info", "", "Lcom/tencent/mobileqq/kandian/repo/report/ReportInfo;", "reportFolderStatus", "", "request0x64eUserOperationReport", "list", "request0x80aPushEffectEvent", "eventId", "eventName", "version", "attris", "Ltencent/im/oidb/cmd0x80a/oidb_cmd0x80a$AttributeList;", "cmd", "command", "request0x978", "selfUin", "followUin", "isFollow", "", "avatarUrl", "callback", "Lcom/tencent/mobileqq/kandian/repo/account/api/Ox978RespCallBack;", "followAccountType", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class UserOperationModuleImpl
  implements IUserOperationModule
{
  public UserOperationModuleImpl()
  {
    UserOperationModule localUserOperationModule = UserOperationModule.getInstance();
    Intrinsics.checkExpressionValueIsNotNull(localUserOperationModule, "UserOperationModule.getInstance()");
    this.$$delegate_0 = localUserOperationModule;
  }
  
  public void getKandianTopFromServer(@Nullable String paramString)
  {
    this.$$delegate_0.getKandianTopFromServer(paramString);
  }
  
  public void request0x64eKandianActionReport(@Nullable List<? extends ReportInfo> paramList, int paramInt)
  {
    this.$$delegate_0.request0x64eKandianActionReport(paramList, paramInt);
  }
  
  public void request0x64eUserOperationReport(@Nullable List<? extends ReportInfo> paramList)
  {
    this.$$delegate_0.request0x64eUserOperationReport(paramList);
  }
  
  public void request0x80aPushEffectEvent(int paramInt1, @Nullable String paramString1, int paramInt2, @Nullable List<oidb_cmd0x80a.AttributeList> paramList, @Nullable String paramString2, int paramInt3)
  {
    this.$$delegate_0.request0x80aPushEffectEvent(paramInt1, paramString1, paramInt2, paramList, paramString2, paramInt3);
  }
  
  public void request0x80aPushEffectEvent(int paramInt, @Nullable String paramString, @Nullable List<oidb_cmd0x80a.AttributeList> paramList)
  {
    this.$$delegate_0.request0x80aPushEffectEvent(paramInt, paramString, paramList);
  }
  
  public void request0x978(@Nullable String paramString1, @Nullable String paramString2, boolean paramBoolean, @Nullable String paramString3, @Nullable Ox978RespCallBack paramOx978RespCallBack)
  {
    this.$$delegate_0.request0x978(paramString1, paramString2, paramBoolean, paramString3, paramOx978RespCallBack);
  }
  
  public void request0x978(@Nullable String paramString1, @Nullable String paramString2, boolean paramBoolean, @Nullable String paramString3, @Nullable Ox978RespCallBack paramOx978RespCallBack, int paramInt)
  {
    this.$$delegate_0.request0x978(paramString1, paramString2, paramBoolean, paramString3, paramOx978RespCallBack, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.account.api.impl.UserOperationModuleImpl
 * JD-Core Version:    0.7.0.1
 */
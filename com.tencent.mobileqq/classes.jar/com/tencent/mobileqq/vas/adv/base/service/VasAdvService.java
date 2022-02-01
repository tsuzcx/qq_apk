package com.tencent.mobileqq.vas.adv.base.service;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.vas.adv.base.VasAdvBizCallback;
import com.tencent.mobileqq.vas.adv.base.support.VasAdvSupport;
import com.tencent.mobileqq.vas.adv.base.support.VasAdvSupport.Companion;
import com.tencent.mobileqq.vas.adv.base.support.app.VasAdvCallback;
import com.tencent.mobileqq.vas.adv.common.data.VasAdvServiceCode;
import com.tencent.mobileqq.vas.adv.common.pb.AdvPush.AdvPushReq;
import com.tencent.mobileqq.vas.adv.common.pb.AdvPush.AdvPushRsp;
import com.tencent.mobileqq.vas.adv.common.pb.adv_report.MobileAdvReportReq;
import com.tencent.mobileqq.vas.adv.common.pb.adv_report.MobileAdvReportRsp;
import com.tencent.mobileqq.vas.adv.common.pb.vac_adv_get.VacAdvReq;
import com.tencent.mobileqq.vas.adv.common.pb.vac_adv_get.VacAdvRsp;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/adv/base/service/VasAdvService;", "", "()V", "CMD_ADV_GET", "", "CMD_ADV_REPORT", "CMD_PA_ADV_PUSH", "TAG", "generateCmdKey", "generateReportRsp", "Lcom/tencent/mobileqq/vas/adv/common/pb/adv_report$MobileAdvReportRsp;", "rspBytes", "", "generateVacAdvRsp", "Lcom/tencent/mobileqq/vas/adv/common/pb/vac_adv_get$VacAdvRsp;", "handleCommonError", "", "T", "Lcom/tencent/mobileqq/pb/MessageMicro;", "callback", "Lcom/tencent/mobileqq/vas/adv/base/VasAdvBizCallback;", "errCode", "Lcom/tencent/mobileqq/vas/adv/common/data/VasAdvServiceCode;", "errMsg", "e", "", "handleReportAdResult", "reportRsp", "handleRequestAdResult", "advRsp", "reportAd", "request", "Lcom/tencent/mobileqq/vas/adv/common/pb/adv_report$MobileAdvReportReq;", "requestAd", "Lcom/tencent/mobileqq/vas/adv/common/pb/vac_adv_get$VacAdvReq;", "requestPublicAccountAd", "Lcom/tencent/mobileqq/vas/adv/common/pb/AdvPush$AdvPushReq;", "Lcom/tencent/mobileqq/vas/adv/common/pb/AdvPush$AdvPushRsp;", "sendCmd", "cmd", "cmdKey", "reqBytes", "Lcom/tencent/mobileqq/vas/adv/base/support/app/VasAdvCallback;", "isSuccess", "", "vas-adv-impl_release"}, k=1, mv={1, 1, 16})
public final class VasAdvService
{
  public static final VasAdvService a = new VasAdvService();
  
  private final vac_adv_get.VacAdvRsp a(byte[] paramArrayOfByte)
  {
    vac_adv_get.VacAdvRsp localVacAdvRsp = new vac_adv_get.VacAdvRsp();
    localVacAdvRsp.mergeFrom(paramArrayOfByte);
    return localVacAdvRsp;
  }
  
  private final String a()
  {
    String str = UUID.randomUUID().toString();
    Intrinsics.checkExpressionValueIsNotNull(str, "UUID.randomUUID().toString()");
    return str;
  }
  
  private final <T extends MessageMicro<T>> void a(VasAdvBizCallback<T> paramVasAdvBizCallback, VasAdvServiceCode paramVasAdvServiceCode, String paramString, Throwable paramThrowable)
  {
    paramVasAdvBizCallback.a(paramVasAdvServiceCode, paramString, paramThrowable);
  }
  
  private final void a(adv_report.MobileAdvReportRsp paramMobileAdvReportRsp, VasAdvBizCallback<adv_report.MobileAdvReportRsp> paramVasAdvBizCallback)
  {
    boolean bool = a(paramMobileAdvReportRsp);
    if (bool == true)
    {
      paramVasAdvBizCallback.a((MessageMicro)paramMobileAdvReportRsp);
      return;
    }
    if (!bool)
    {
      VasAdvServiceCode localVasAdvServiceCode = VasAdvServiceCode.REPORT_RSP_FAIL;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("report rsp ret code:");
      localStringBuilder.append(paramMobileAdvReportRsp.ret_code.get());
      a(paramVasAdvBizCallback, localVasAdvServiceCode, localStringBuilder.toString(), null);
    }
  }
  
  private final void a(vac_adv_get.VacAdvRsp paramVacAdvRsp, VasAdvBizCallback<vac_adv_get.VacAdvRsp> paramVasAdvBizCallback)
  {
    boolean bool = a(paramVacAdvRsp);
    if (bool == true)
    {
      paramVasAdvBizCallback.a((MessageMicro)paramVacAdvRsp);
      return;
    }
    if (!bool)
    {
      VasAdvServiceCode localVasAdvServiceCode = VasAdvServiceCode.REQUEST_RSP_FAIL;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("rsp err code:");
      localStringBuilder.append(paramVacAdvRsp.err_code.get());
      a(paramVasAdvBizCallback, localVasAdvServiceCode, localStringBuilder.toString(), null);
    }
  }
  
  private final void a(String paramString1, String paramString2, byte[] paramArrayOfByte, VasAdvCallback paramVasAdvCallback)
  {
    VasAdvSupport.a.a().a(paramString1, paramString2, paramArrayOfByte, paramVasAdvCallback);
  }
  
  private final boolean a(@NotNull adv_report.MobileAdvReportRsp paramMobileAdvReportRsp)
  {
    return paramMobileAdvReportRsp.ret_code.get() == 0;
  }
  
  private final boolean a(@NotNull vac_adv_get.VacAdvRsp paramVacAdvRsp)
  {
    return paramVacAdvRsp.err_code.get() == 0;
  }
  
  private final adv_report.MobileAdvReportRsp b(byte[] paramArrayOfByte)
  {
    adv_report.MobileAdvReportRsp localMobileAdvReportRsp = new adv_report.MobileAdvReportRsp();
    localMobileAdvReportRsp.mergeFrom(paramArrayOfByte);
    return localMobileAdvReportRsp;
  }
  
  public final void a(@NotNull AdvPush.AdvPushReq paramAdvPushReq, @NotNull VasAdvBizCallback<AdvPush.AdvPushRsp> paramVasAdvBizCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramAdvPushReq, "request");
    Intrinsics.checkParameterIsNotNull(paramVasAdvBizCallback, "callback");
    paramVasAdvBizCallback = new VasAdvService.requestPublicAccountAd.innerCallback.1(paramVasAdvBizCallback);
    String str = a();
    paramAdvPushReq = paramAdvPushReq.toByteArray();
    Intrinsics.checkExpressionValueIsNotNull(paramAdvPushReq, "request.toByteArray()");
    a("trpc.sq_adv.official_account_adv_push.OfficialAccountAdvPush.AdvPush", str, paramAdvPushReq, (VasAdvCallback)paramVasAdvBizCallback);
  }
  
  public final void a(@NotNull adv_report.MobileAdvReportReq paramMobileAdvReportReq, @NotNull VasAdvBizCallback<adv_report.MobileAdvReportRsp> paramVasAdvBizCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramMobileAdvReportReq, "request");
    Intrinsics.checkParameterIsNotNull(paramVasAdvBizCallback, "callback");
    try
    {
      paramMobileAdvReportReq = paramMobileAdvReportReq.toByteArray();
      paramVasAdvBizCallback = new VasAdvService.reportAd.innerCallback.1(paramVasAdvBizCallback);
      String str = a();
      Intrinsics.checkExpressionValueIsNotNull(paramMobileAdvReportReq, "reportReqBytes");
      a("MobileAdv.AdvReport", str, paramMobileAdvReportReq, (VasAdvCallback)paramVasAdvBizCallback);
      return;
    }
    catch (Throwable paramMobileAdvReportReq)
    {
      a(paramVasAdvBizCallback, VasAdvServiceCode.CREATE_REPORT_ERR, "create report request error, abort report ad", paramMobileAdvReportReq);
      QLog.e("VasAdvService", 1, "create report request error, abort report ad", paramMobileAdvReportReq);
    }
  }
  
  public final void a(@NotNull vac_adv_get.VacAdvReq paramVacAdvReq, @NotNull VasAdvBizCallback<vac_adv_get.VacAdvRsp> paramVasAdvBizCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramVacAdvReq, "request");
    Intrinsics.checkParameterIsNotNull(paramVasAdvBizCallback, "callback");
    try
    {
      paramVacAdvReq = paramVacAdvReq.toByteArray();
      paramVasAdvBizCallback = new VasAdvService.requestAd.innerCallback.1(paramVasAdvBizCallback);
      String str = a();
      Intrinsics.checkExpressionValueIsNotNull(paramVacAdvReq, "reqBytes");
      a("MobileAdv.AdvGet", str, paramVacAdvReq, (VasAdvCallback)paramVasAdvBizCallback);
      return;
    }
    catch (Throwable paramVacAdvReq)
    {
      a(paramVasAdvBizCallback, VasAdvServiceCode.CREATE_REQUEST_ERR, "create request ad error, abort request ad", paramVacAdvReq);
      QLog.e("VasAdvService", 1, "create request ad error, abort request ad", paramVacAdvReq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.base.service.VasAdvService
 * JD-Core Version:    0.7.0.1
 */
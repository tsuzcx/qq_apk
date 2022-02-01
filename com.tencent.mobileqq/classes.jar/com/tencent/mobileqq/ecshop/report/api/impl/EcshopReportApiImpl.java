package com.tencent.mobileqq.ecshop.report.api.impl;

import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.ecshop.ad.EcshopAdHandler;
import com.tencent.mobileqq.ecshop.ad.IEcshopAdHandler.ReportInfo;
import com.tencent.mobileqq.ecshop.report.ReportUtil;
import com.tencent.mobileqq.ecshop.report.api.IEcshopReportApi;
import com.tencent.mobileqq.ecshop.temp.api.IEcshopMessageApi;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/ecshop/report/api/impl/EcshopReportApiImpl;", "Lcom/tencent/mobileqq/ecshop/report/api/IEcshopReportApi;", "()V", "TAG", "", "doArrivalArkReport", "", "record", "Lcom/tencent/mobileqq/data/MessageRecord;", "doArrivalReport", "app", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "doClickReport", "index", "", "isReportForClick", "", "reportForClick", "report", "opName", "reportEcshopTo644", "opType", "d2", "d1", "reportEcshopToBeacon", "reportSetTopOrCancleSetTop", "uinType", "uin", "isSetTop", "qqshop-feature-impl_release"}, k=1, mv={1, 1, 16})
public final class EcshopReportApiImpl
  implements IEcshopReportApi
{
  private final String TAG = "EcshopReportApi";
  
  public void doArrivalArkReport(@Nullable MessageRecord paramMessageRecord)
  {
    try
    {
      localObject1 = QRoute.api(IEcshopMessageApi.class);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "QRoute.api(IEcshopMessageApi::class.java)");
      localObject1 = (IEcshopMessageApi)localObject1;
      localObject2 = ((IEcshopMessageApi)localObject1).getArkMsgSourceAd(paramMessageRecord);
      if (!StringUtil.isEmpty((String)localObject2))
      {
        localObject2 = new JSONObject((String)localObject2);
        if (QLog.isColorLevel())
        {
          str = this.TAG;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("sourceAdObj: ");
          localStringBuilder.append(localObject2);
          QLog.i(str, 1, localStringBuilder.toString());
        }
        if (Intrinsics.areEqual("gw", ((JSONObject)localObject2).optString("from")))
        {
          localObject2 = ReportUtil.a(paramMessageRecord);
          i = 0;
        }
      }
    }
    catch (Exception paramMessageRecord)
    {
      Object localObject1;
      Object localObject2;
      String str;
      int i;
      int j;
      label152:
      return;
    }
    try
    {
      str = ((IEcshopMessageApi)QRoute.api(IEcshopMessageApi.class)).getLastMsgType(paramMessageRecord);
      Intrinsics.checkExpressionValueIsNotNull(str, "QRoute.api(IEcshopMessag…a).getLastMsgType(record)");
      j = Integer.parseInt(str);
      i = j;
    }
    catch (Exception localException)
    {
      break label152;
    }
    paramMessageRecord = ((IEcshopMessageApi)localObject1).getArkMsgMsg(paramMessageRecord);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(String.valueOf(NetConnInfoCenter.getServerTimeMillis()));
    ((StringBuilder)localObject1).append("");
    ReportUtil.a("qgg.push.arrive", paramMessageRecord, ((StringBuilder)localObject1).toString(), (String)localObject2, i);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(String.valueOf(NetConnInfoCenter.getServerTimeMillis()));
    ((StringBuilder)localObject1).append("");
    ReportUtil.b("qgg_push_arrive", paramMessageRecord, ((StringBuilder)localObject1).toString(), (String)localObject2, i);
  }
  
  public void doArrivalReport(@NotNull BaseQQAppInterface paramBaseQQAppInterface, @Nullable MessageRecord paramMessageRecord)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseQQAppInterface, "app");
    try
    {
      localObject = new IEcshopAdHandler.ReportInfo();
      ((IEcshopAdHandler.ReportInfo)localObject).a = 1;
      localObject = EcshopAdHandler.a((IEcshopAdHandler.ReportInfo)localObject, paramMessageRecord);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "EcshopAdHandler.rebuildReportParam(info, record)");
      paramBaseQQAppInterface = paramBaseQQAppInterface.getBusinessHandler(EcshopAdHandler.class.getName());
      if (paramBaseQQAppInterface != null)
      {
        ((EcshopAdHandler)paramBaseQQAppInterface).a((IEcshopAdHandler.ReportInfo)localObject, null);
        paramBaseQQAppInterface = QRoute.api(IEcshopMessageApi.class);
        Intrinsics.checkExpressionValueIsNotNull(paramBaseQQAppInterface, "QRoute.api(IEcshopMessageApi::class.java)");
        paramBaseQQAppInterface = (IEcshopMessageApi)paramBaseQQAppInterface;
      }
    }
    catch (Exception paramBaseQQAppInterface)
    {
      Object localObject;
      int i;
      label102:
      boolean bool;
      return;
    }
    try
    {
      localObject = paramBaseQQAppInterface.getLastMsgType(paramMessageRecord);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "messageApi.getLastMsgType(record)");
      i = Integer.parseInt((String)localObject);
    }
    catch (Exception localException)
    {
      break label102;
    }
    i = 0;
    bool = paramBaseQQAppInterface.isMessageForStructing(paramMessageRecord);
    if (bool)
    {
      paramBaseQQAppInterface.GdtC2SReportStructMsg(paramMessageRecord, 0);
      paramBaseQQAppInterface = paramBaseQQAppInterface.getStructMsgContentTitle(paramMessageRecord);
      if (!TextUtils.isEmpty((CharSequence)paramBaseQQAppInterface))
      {
        paramMessageRecord = new StringBuilder();
        paramMessageRecord.append(String.valueOf(NetConnInfoCenter.getServerTimeMillis()));
        paramMessageRecord.append("");
        ReportUtil.a("qgg.push.arrive", paramBaseQQAppInterface, paramMessageRecord.toString(), "", i);
        paramMessageRecord = new StringBuilder();
        paramMessageRecord.append(String.valueOf(NetConnInfoCenter.getServerTimeMillis()));
        paramMessageRecord.append("");
        ReportUtil.b("qgg_push_arrive", paramBaseQQAppInterface, paramMessageRecord.toString(), "", i);
      }
    }
    else if (paramBaseQQAppInterface.isMessageForArkApp(paramMessageRecord))
    {
      paramBaseQQAppInterface.GdtC2SReportArkMsg(paramMessageRecord, 0);
      localObject = paramBaseQQAppInterface.getArkMsgSourceAd(paramMessageRecord);
      if ((!StringUtil.isEmpty((String)localObject)) && (Intrinsics.areEqual("gw", new JSONObject((String)localObject).optString("from"))))
      {
        localObject = ReportUtil.a(paramMessageRecord);
        paramBaseQQAppInterface = paramBaseQQAppInterface.getArkMsgMsg(paramMessageRecord);
        paramMessageRecord = new StringBuilder();
        paramMessageRecord.append(String.valueOf(NetConnInfoCenter.getServerTimeMillis()));
        paramMessageRecord.append("");
        ReportUtil.a("qgg.push.arrive", paramBaseQQAppInterface, paramMessageRecord.toString(), (String)localObject, i);
        paramMessageRecord = new StringBuilder();
        paramMessageRecord.append(String.valueOf(NetConnInfoCenter.getServerTimeMillis()));
        paramMessageRecord.append("");
        ReportUtil.b("qgg_push_arrive", paramBaseQQAppInterface, paramMessageRecord.toString(), (String)localObject, i);
        return;
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.ecshop.ad.EcshopAdHandler");
      }
    }
  }
  
  public void doClickReport(@NotNull BaseQQAppInterface paramBaseQQAppInterface, @Nullable MessageRecord paramMessageRecord, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseQQAppInterface, "app");
    try
    {
      Object localObject = QRoute.api(IEcshopMessageApi.class);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "QRoute.api(IEcshopMessageApi::class.java)");
      localObject = (IEcshopMessageApi)localObject;
      boolean bool = false;
      if (((IEcshopMessageApi)localObject).isMessageForStructing(paramMessageRecord))
      {
        localObject = ((IEcshopMessageApi)localObject).getStructMsgReportClick(paramMessageRecord);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          bool = isReportForClick((String)localObject);
        }
      }
      else if (((IEcshopMessageApi)localObject).isMessageForArkApp(paramMessageRecord))
      {
        bool = ((IEcshopMessageApi)localObject).getArkMsgReportClick(paramMessageRecord);
      }
      if (!bool)
      {
        localObject = new IEcshopAdHandler.ReportInfo();
        ((IEcshopAdHandler.ReportInfo)localObject).a = 3;
        paramMessageRecord = EcshopAdHandler.a((IEcshopAdHandler.ReportInfo)localObject, paramMessageRecord);
        Intrinsics.checkExpressionValueIsNotNull(paramMessageRecord, "EcshopAdHandler.rebuildReportParam(info, record)");
        paramMessageRecord.r = paramInt;
        paramBaseQQAppInterface = paramBaseQQAppInterface.getBusinessHandler(EcshopAdHandler.class.getName());
        if (paramBaseQQAppInterface != null)
        {
          ((EcshopAdHandler)paramBaseQQAppInterface).a(paramMessageRecord, null);
          return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.ecshop.ad.EcshopAdHandler");
      }
      return;
    }
    catch (Throwable paramBaseQQAppInterface) {}
  }
  
  public boolean isReportForClick(@Nullable String paramString)
  {
    return Intrinsics.areEqual("1", paramString);
  }
  
  public void report(@Nullable String paramString)
  {
    ReportUtil.a(paramString);
  }
  
  public void reportEcshopTo644(@Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @Nullable String paramString4)
  {
    ReportUtil.a(paramString1, paramString2, paramString3, paramString4);
  }
  
  public void reportEcshopToBeacon(@Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @Nullable String paramString4)
  {
    ReportUtil.b(paramString1, paramString2, paramString3, paramString4);
  }
  
  public void reportSetTopOrCancleSetTop(int paramInt, @NotNull String paramString, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uin");
    ReportUtil.a(paramInt, paramString, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.report.api.impl.EcshopReportApiImpl
 * JD-Core Version:    0.7.0.1
 */
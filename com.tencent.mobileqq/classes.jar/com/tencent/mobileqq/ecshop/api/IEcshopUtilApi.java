package com.tencent.mobileqq.ecshop.api;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.QPublicFragmentActivityForTool;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.ecshop.conf.EcshopConfBean;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/ecshop/api/IEcshopUtilApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "createCustomQQShopMsgSummary", "", "app", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "msgSummary", "Lcom/tencent/mobileqq/activity/recent/MsgSummary;", "getEcshopConfBean", "Lcom/tencent/mobileqq/ecshop/conf/EcshopConfBean;", "getEcshopIPCModule", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "isArkReportOpen", "", "jump", "context", "Landroid/content/Context;", "processUiApiPluginOpenUrl", "activity", "Lcom/tencent/mobileqq/activity/QPublicFragmentActivityForTool;", "qqshop-feature-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IEcshopUtilApi
  extends QRouteApi
{
  public abstract void createCustomQQShopMsgSummary(@NotNull BaseQQAppInterface paramBaseQQAppInterface, @NotNull MsgSummary paramMsgSummary);
  
  @NotNull
  public abstract EcshopConfBean getEcshopConfBean();
  
  @NotNull
  public abstract QIPCModule getEcshopIPCModule();
  
  public abstract boolean isArkReportOpen();
  
  public abstract void jump(@NotNull Context paramContext);
  
  public abstract void processUiApiPluginOpenUrl(@NotNull QPublicFragmentActivityForTool paramQPublicFragmentActivityForTool);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.api.IEcshopUtilApi
 * JD-Core Version:    0.7.0.1
 */
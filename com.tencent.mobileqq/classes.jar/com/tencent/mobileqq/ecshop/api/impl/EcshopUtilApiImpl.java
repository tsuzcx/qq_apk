package com.tencent.mobileqq.ecshop.api.impl;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.QPublicFragmentActivityForTool;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.ecshop.EcshopIPCModule;
import com.tencent.mobileqq.ecshop.api.IEcshopUtilApi;
import com.tencent.mobileqq.ecshop.conf.EcshopConfBean;
import com.tencent.mobileqq.ecshop.conf.EcshopConfUtil;
import com.tencent.mobileqq.ecshop.utils.EcshopUtils;
import com.tencent.mobileqq.ecshop.widget.EcshopNewPageFragment;
import com.tencent.mobileqq.ecshop.widget.JumpUtil;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qipc.QIPCModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/ecshop/api/impl/EcshopUtilApiImpl;", "Lcom/tencent/mobileqq/ecshop/api/IEcshopUtilApi;", "()V", "createCustomQQShopMsgSummary", "", "app", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "msgSummary", "Lcom/tencent/mobileqq/activity/recent/MsgSummary;", "getEcshopConfBean", "Lcom/tencent/mobileqq/ecshop/conf/EcshopConfBean;", "getEcshopIPCModule", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "isArkReportOpen", "", "jump", "context", "Landroid/content/Context;", "processUiApiPluginOpenUrl", "activity", "Lcom/tencent/mobileqq/activity/QPublicFragmentActivityForTool;", "qqshop-feature-impl_release"}, k=1, mv={1, 1, 16})
public final class EcshopUtilApiImpl
  implements IEcshopUtilApi
{
  public void createCustomQQShopMsgSummary(@NotNull BaseQQAppInterface paramBaseQQAppInterface, @NotNull MsgSummary paramMsgSummary)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseQQAppInterface, "app");
    Intrinsics.checkParameterIsNotNull(paramMsgSummary, "msgSummary");
    EcshopUtils.a(paramMsgSummary);
  }
  
  @NotNull
  public EcshopConfBean getEcshopConfBean()
  {
    EcshopConfBean localEcshopConfBean = EcshopConfUtil.a();
    Intrinsics.checkExpressionValueIsNotNull(localEcshopConfBean, "EcshopConfUtil.getEcshopConfBean()");
    return localEcshopConfBean;
  }
  
  @NotNull
  public QIPCModule getEcshopIPCModule()
  {
    EcshopIPCModule localEcshopIPCModule = EcshopIPCModule.a();
    Intrinsics.checkExpressionValueIsNotNull(localEcshopIPCModule, "EcshopIPCModule.getInstance()");
    return (QIPCModule)localEcshopIPCModule;
  }
  
  public boolean isArkReportOpen()
  {
    return EcshopConfUtil.c();
  }
  
  public void jump(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    JumpUtil.a(paramContext);
  }
  
  public void processUiApiPluginOpenUrl(@NotNull QPublicFragmentActivityForTool paramQPublicFragmentActivityForTool)
  {
    Intrinsics.checkParameterIsNotNull(paramQPublicFragmentActivityForTool, "activity");
    QPublicBaseFragment localQPublicBaseFragment = paramQPublicFragmentActivityForTool.getFragment();
    paramQPublicFragmentActivityForTool = localQPublicBaseFragment;
    if (!(localQPublicBaseFragment instanceof EcshopNewPageFragment)) {
      paramQPublicFragmentActivityForTool = null;
    }
    paramQPublicFragmentActivityForTool = (EcshopNewPageFragment)paramQPublicFragmentActivityForTool;
    if (paramQPublicFragmentActivityForTool != null) {
      paramQPublicFragmentActivityForTool.a = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.api.impl.EcshopUtilApiImpl
 * JD-Core Version:    0.7.0.1
 */
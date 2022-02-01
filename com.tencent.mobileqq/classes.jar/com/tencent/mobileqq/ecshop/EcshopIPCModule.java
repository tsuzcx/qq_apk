package com.tencent.mobileqq.ecshop;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.ecshop.report.ReportUtil;
import com.tencent.mobileqq.ecshop.temp.api.IEcshopOtherApi;
import com.tencent.mobileqq.ecshop.utils.AppUtils;
import com.tencent.mobileqq.ecshop.utils.EcshopUtils;
import com.tencent.mobileqq.ecshop.widget.JumpUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.HashMap;
import mqq.app.MobileQQ;

public class EcshopIPCModule
  extends QIPCModule
{
  private static volatile EcshopIPCModule a;
  
  public EcshopIPCModule(String paramString)
  {
    super(paramString);
  }
  
  private int a(BaseQQAppInterface paramBaseQQAppInterface, String paramString)
  {
    Object localObject = ((IRecentUserProxyService)paramBaseQQAppInterface.getRuntimeService(IRecentUserProxyService.class)).getRecentUserCache();
    int i = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getUinType(paramBaseQQAppInterface, paramString);
    localObject = ((RecentUserProxy)localObject).c(paramString, i);
    paramBaseQQAppInterface = (BaseQQAppInterface)localObject;
    if (localObject == null)
    {
      paramBaseQQAppInterface = new StringBuilder();
      paramBaseQQAppInterface.append("isPublicAccoutMsgTabSetTop pUin = ");
      paramBaseQQAppInterface.append(paramString);
      paramBaseQQAppInterface.append(" userType = ");
      paramBaseQQAppInterface.append(i);
      paramBaseQQAppInterface.append(" not in the msglist");
      QLog.d("EcshopIPCModule", 1, paramBaseQQAppInterface.toString());
      paramBaseQQAppInterface = new RecentUser(paramString, i);
    }
    if (paramBaseQQAppInterface.showUpTime != 0L) {
      return 1;
    }
    return 0;
  }
  
  public static EcshopIPCModule a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new EcshopIPCModule("EcshopIPCModule");
        }
      }
      finally {}
    }
    return a;
  }
  
  private int b(BaseQQAppInterface paramBaseQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EcshopIPCModule", 1, "ActionSheet setOrCancelSetTop");
    }
    int i = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getUinType(paramBaseQQAppInterface, paramString);
    if (i == 1024)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setOrCancelTop pUin = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" userType = ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" is UIN_TYPE_BUSINESS_CMR_TMP");
      QLog.d("EcshopIPCModule", 1, ((StringBuilder)localObject).toString());
    }
    RecentUserProxy localRecentUserProxy = ((IRecentUserProxyService)paramBaseQQAppInterface.getRuntimeService(IRecentUserProxyService.class)).getRecentUserCache();
    RecentUser localRecentUser = localRecentUserProxy.c(paramString, i);
    Object localObject = localRecentUser;
    if (localRecentUser == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setOrCancelTop pUin = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" userType = ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" not in the msglist");
      QLog.d("EcshopIPCModule", 1, ((StringBuilder)localObject).toString());
      localObject = new RecentUser(paramString, i);
    }
    if (a(paramBaseQQAppInterface, paramString) == 1) {
      ((RecentUser)localObject).showUpTime = 0L;
    } else {
      ((RecentUser)localObject).showUpTime = (System.currentTimeMillis() / 1000L);
    }
    localRecentUserProxy.b((RecentUser)localObject);
    ((IEcshopOtherApi)QRoute.api(IEcshopOtherApi.class)).updateRecentList(paramBaseQQAppInterface);
    return 0;
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    boolean bool;
    try
    {
      Object localObject = AppUtils.a();
      if (!(localObject instanceof BaseQQAppInterface)) {
        return null;
      }
      localObject = (BaseQQAppInterface)localObject;
      if ("reportToBeacon".equals(paramString))
      {
        ReportUtil.a(paramBundle.getString("key_report_event"), (HashMap)paramBundle.getSerializable("key_report_params"));
        return null;
      }
      bool = "setPublicAccountTop".equals(paramString);
      if (bool)
      {
        paramInt = paramBundle.getInt("isTop");
        int i = a((BaseQQAppInterface)localObject, "3046055438");
        paramString = new StringBuilder();
        paramString.append(paramInt);
        paramString.append("");
        paramString = paramString.toString();
        paramBundle = new StringBuilder();
        paramBundle.append(NetConnInfoCenter.getServerTimeMillis());
        paramBundle.append("");
        ReportUtil.a("gouwu.top.click", paramString, paramBundle.toString(), "");
        if (paramInt == 1)
        {
          if (i == 0) {
            return EIPCResult.createResult(b((BaseQQAppInterface)localObject, "3046055438"), null);
          }
          return EIPCResult.createResult(0, null);
        }
        if (paramInt != 0) {
          break label335;
        }
        if (i == 0) {
          return EIPCResult.createResult(0, null);
        }
        return EIPCResult.createResult(b((BaseQQAppInterface)localObject, "3046055438"), null);
      }
      if ("queryPublicAccountTop".equals(paramString)) {
        return EIPCResult.createResult(a((BaseQQAppInterface)localObject, "3046055438"), null);
      }
      if (!"startQQShopPublicAccount".equals(paramString)) {
        break label335;
      }
      bool = EcshopUtils.a("3046055438");
      paramInt = paramBundle.getInt("shouldOpenCard");
      paramBundle = paramBundle.getString("qggExt");
      paramString = paramBundle;
      if (!TextUtils.isEmpty(paramBundle)) {
        break label337;
      }
      paramString = "";
    }
    catch (Throwable paramString)
    {
      QLog.e("EcshopIPCModule", 1, paramString, new Object[0]);
    }
    paramString = new ActivityURIRequest(MobileQQ.getContext(), "/pubaccount/detail");
    paramString.extra().putString("uin", "3046055438");
    paramString.extra().putInt("source", 5);
    QRoute.startUri(paramString, null);
    for (;;)
    {
      JumpUtil.a(MobileQQ.getContext(), paramString);
      paramString = EIPCResult.createResult(0, null);
      return paramString;
      label335:
      return null;
      label337:
      if (!bool) {
        if (paramInt != 0) {
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.EcshopIPCModule
 * JD-Core Version:    0.7.0.1
 */
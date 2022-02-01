package com.tencent.mobileqq.emoticonview.ipc.proxy;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.VipIPSiteInfo;
import com.tencent.mobileqq.model.CommercialDrainageManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import mqq.app.AppRuntime;

public class CommercialDrainageManagerProxy
  extends AbsManagerProxy<CommercialDrainageManager>
{
  public static final String ACTION_COMMERCIAL_ISRICHIPSITE = "action_commercial_isrichipsite";
  public static final String COMMERCIAL_RICHIPSITE = "commercial_richipsite";
  public static final String COMMERCIAL_RICHIPSITE_INFO = "commercial_richipsite_info";
  public static final String TAG = "CommercialDrainageManagerProxy";
  
  public CommercialDrainageManagerProxy(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface, QQManagerFactory.COMMERCIAL_DRAINAGE_MANAGER);
  }
  
  public static EIPCResult checkMatch(AppRuntime paramAppRuntime, String paramString, Bundle paramBundle, int paramInt)
  {
    if ("action_commercial_isrichipsite".equals(paramString)) {
      return onIsRichIPSite((QQAppInterface)paramAppRuntime, paramString, paramBundle, paramInt);
    }
    return null;
  }
  
  public static EIPCResult onIsRichIPSite(QQAppInterface paramQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    boolean bool = ((CommercialDrainageManager)paramQQAppInterface.getManager(QQManagerFactory.COMMERCIAL_DRAINAGE_MANAGER)).a((VipIPSiteInfo)paramBundle.getParcelable("commercial_richipsite_info"));
    paramQQAppInterface = new Bundle();
    paramQQAppInterface.putBoolean("commercial_richipsite", bool);
    return EIPCResult.createSuccessResult(paramQQAppInterface);
  }
  
  public boolean isRichIPSite(VipIPSiteInfo paramVipIPSiteInfo)
  {
    if (this.manager != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CommercialDrainageManagerProxy", 4, "do isRichIPSite.");
      }
      return ((CommercialDrainageManager)this.manager).a(paramVipIPSiteInfo);
    }
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("commercial_richipsite_info", paramVipIPSiteInfo);
    paramVipIPSiteInfo = QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "action_commercial_isrichipsite", localBundle);
    if ((paramVipIPSiteInfo != null) && (paramVipIPSiteInfo.isSuccess())) {
      return paramVipIPSiteInfo.data.getBoolean("commercial_richipsite");
    }
    QLog.e("CommercialDrainageManagerProxy", 4, "isRichIPSite fail.");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.ipc.proxy.CommercialDrainageManagerProxy
 * JD-Core Version:    0.7.0.1
 */
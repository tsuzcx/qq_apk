package com.tencent.mobileqq.emoticonview.ipc.proxy;

import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.VipIPSiteInfo;
import com.tencent.mobileqq.model.api.ICommercialDrainageManagerService;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import mqq.app.AppRuntime;

public class CommercialDrainageManagerServiceProxy
  extends AbsEmoRuntimeServiceProxy<ICommercialDrainageManagerService>
{
  public static final String ACTION_COMMERCIAL_ISRICHIPSITE = "action_commercial_isrichipsite";
  public static final String COMMERCIAL_RICHIPSITE = "commercial_richipsite";
  public static final String COMMERCIAL_RICHIPSITE_INFO = "commercial_richipsite_info";
  public static final String TAG = "CommercialDrainageManagerServiceProxy";
  
  public CommercialDrainageManagerServiceProxy(BaseQQAppInterface paramBaseQQAppInterface)
  {
    super(paramBaseQQAppInterface, ICommercialDrainageManagerService.class);
  }
  
  public static EIPCResult checkMatch(AppRuntime paramAppRuntime, String paramString, Bundle paramBundle, int paramInt)
  {
    if ("action_commercial_isrichipsite".equals(paramString)) {
      return onIsRichIPSite((BaseQQAppInterface)paramAppRuntime, paramString, paramBundle, paramInt);
    }
    return null;
  }
  
  public static EIPCResult onIsRichIPSite(BaseQQAppInterface paramBaseQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    boolean bool = ((ICommercialDrainageManagerService)paramBaseQQAppInterface.getRuntimeService(ICommercialDrainageManagerService.class)).isRichIPSite((VipIPSiteInfo)paramBundle.getParcelable("commercial_richipsite_info"));
    paramBaseQQAppInterface = new Bundle();
    paramBaseQQAppInterface.putBoolean("commercial_richipsite", bool);
    return EIPCResult.createSuccessResult(paramBaseQQAppInterface);
  }
  
  public boolean isRichIPSite(VipIPSiteInfo paramVipIPSiteInfo)
  {
    if (this.manager != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CommercialDrainageManagerServiceProxy", 4, "do isRichIPSite.");
      }
      return ((ICommercialDrainageManagerService)this.manager).isRichIPSite(paramVipIPSiteInfo);
    }
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("commercial_richipsite_info", paramVipIPSiteInfo);
    paramVipIPSiteInfo = QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "action_commercial_isrichipsite", localBundle);
    if ((paramVipIPSiteInfo != null) && (paramVipIPSiteInfo.isSuccess())) {
      return paramVipIPSiteInfo.data.getBoolean("commercial_richipsite");
    }
    QLog.e("CommercialDrainageManagerServiceProxy", 4, "isRichIPSite fail.");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.ipc.proxy.CommercialDrainageManagerServiceProxy
 * JD-Core Version:    0.7.0.1
 */
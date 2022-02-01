package com.tencent.mobileqq.emoticonview.ipc.proxy;

import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandlerProxy;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;

public class SVIPHandlerProxy
  extends AbsHandlerProxy<ISVIPHandler>
{
  public static final String ACTION_SVIPHANDLER_GETCURRENTUSERVIPTYPE = "svip_viptype";
  private static final String SVIP_HANDLER = ((ISVIPHandlerProxy)QRoute.api(ISVIPHandlerProxy.class)).getImplClassName();
  public static final String TAG = "SVIPHandlerProxy";
  private static final String VIP_TYPE = "vip_type";
  
  public SVIPHandlerProxy(BaseQQAppInterface paramBaseQQAppInterface)
  {
    super(paramBaseQQAppInterface, SVIP_HANDLER);
  }
  
  public static EIPCResult onGetCurrentUserVipType(BaseQQAppInterface paramBaseQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    paramInt = ((ISVIPHandler)paramBaseQQAppInterface.getBusinessHandler(SVIP_HANDLER)).j();
    paramBaseQQAppInterface = new Bundle();
    paramBaseQQAppInterface.putInt("vip_type", paramInt);
    return EIPCResult.createSuccessResult(paramBaseQQAppInterface);
  }
  
  @Deprecated
  public int getCurrentUserVipType()
  {
    if (this.businessHandler != null) {
      return ((ISVIPHandler)this.businessHandler).j();
    }
    EIPCResult localEIPCResult = QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "svip_viptype", null);
    if ((localEIPCResult != null) && (localEIPCResult.isSuccess())) {
      return localEIPCResult.data.getInt("vip_type");
    }
    QLog.e("SVIPHandlerProxy", 4, "getCurrentUserVipType fail.");
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.ipc.proxy.SVIPHandlerProxy
 * JD-Core Version:    0.7.0.1
 */
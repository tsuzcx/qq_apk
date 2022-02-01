package com.tencent.mobileqq.emoticonview.ipc.proxy;

import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;

public class SVIPHandlerProxy
  extends AbsHandlerProxy<SVIPHandler>
{
  public static final String ACTION_SVIPHANDLER_GETCURRENTUSERVIPTYPE = "svip_viptype";
  public static final String TAG = "SVIPHandlerProxy";
  private static final String VIP_TYPE = "vip_type";
  
  public SVIPHandlerProxy(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface, BusinessHandlerFactory.SVIP_HANDLER);
  }
  
  public static EIPCResult onGetCurrentUserVipType(QQAppInterface paramQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    paramInt = ((SVIPHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).g();
    paramQQAppInterface = new Bundle();
    paramQQAppInterface.putInt("vip_type", paramInt);
    return EIPCResult.createSuccessResult(paramQQAppInterface);
  }
  
  public int getCurrentUserVipType()
  {
    if (this.businessHandler != null) {
      return ((SVIPHandler)this.businessHandler).g();
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
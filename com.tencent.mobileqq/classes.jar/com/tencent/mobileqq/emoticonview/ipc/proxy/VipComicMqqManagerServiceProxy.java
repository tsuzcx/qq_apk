package com.tencent.mobileqq.emoticonview.ipc.proxy;

import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.emosm.api.IVipComicMqqManagerService;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;

public class VipComicMqqManagerServiceProxy
  extends AbsEmoRuntimeServiceProxy<IVipComicMqqManagerService>
{
  public static final String ACTION_VIPCOMICM_UPLOADINITCOMICEINFO = "vipcomicm_uploadinitcomiceinfo";
  public static final String TAG = "VipComicMqqManagerServiceProxy";
  
  public VipComicMqqManagerServiceProxy(BaseQQAppInterface paramBaseQQAppInterface)
  {
    super(paramBaseQQAppInterface, IVipComicMqqManagerService.class);
  }
  
  public static EIPCResult onUploadInitComicEmoStructMsgInfo(BaseQQAppInterface paramBaseQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    ((IVipComicMqqManagerService)paramBaseQQAppInterface.getRuntimeService(IVipComicMqqManagerService.class, "")).uploadInitComicEmoStructMsgInfo();
    return EIPCResult.createSuccessResult(null);
  }
  
  public void uploadInitComicEmoStructMsgInfo()
  {
    if (this.manager != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VipComicMqqManagerServiceProxy", 4, "do uploadInitComicEmoStructMsgInfo.");
      }
      ((IVipComicMqqManagerService)this.manager).uploadInitComicEmoStructMsgInfo();
      return;
    }
    EIPCResult localEIPCResult = QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "vipcomicm_uploadinitcomiceinfo", null);
    if ((localEIPCResult != null) && (localEIPCResult.isSuccess()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VipComicMqqManagerServiceProxy", 4, "uploadInitComicEmoStructMsgInfo suc.");
      }
    }
    else {
      QLog.e("VipComicMqqManagerServiceProxy", 4, "uploadInitComicEmoStructMsgInfo fail.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.ipc.proxy.VipComicMqqManagerServiceProxy
 * JD-Core Version:    0.7.0.1
 */
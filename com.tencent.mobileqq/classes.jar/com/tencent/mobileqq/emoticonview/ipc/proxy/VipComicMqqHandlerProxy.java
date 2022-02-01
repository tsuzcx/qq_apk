package com.tencent.mobileqq.emoticonview.ipc.proxy;

import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.emosm.vipcomic.VipComicMqqHandler;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;

public class VipComicMqqHandlerProxy
  extends AbsHandlerProxy<VipComicMqqHandler>
{
  public static final String ACTION_VIPCOMICM_FAVOREMOTICONS = "vipcomicm_favoremoticons";
  public static final String TAG = "VipComicMqqHandlerProxy";
  
  public VipComicMqqHandlerProxy(BaseQQAppInterface paramBaseQQAppInterface)
  {
    super(paramBaseQQAppInterface, VipComicMqqHandler.a);
  }
  
  public static EIPCResult onGetMyComicFavorEmotIcons(BaseQQAppInterface paramBaseQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    ((VipComicMqqHandler)paramBaseQQAppInterface.getBusinessHandler(VipComicMqqHandler.a)).a();
    return EIPCResult.createSuccessResult(null);
  }
  
  public void getMyComicFavorEmotIcons()
  {
    if (this.businessHandler != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VipComicMqqHandlerProxy", 4, "do myComicFavorEmotIcons.");
      }
      ((VipComicMqqHandler)this.businessHandler).a();
      return;
    }
    EIPCResult localEIPCResult = QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "vipcomicm_favoremoticons", null);
    if ((localEIPCResult != null) && (localEIPCResult.isSuccess()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VipComicMqqHandlerProxy", 4, "getMyComicFavorEmotIcons suc.");
      }
    }
    else {
      QLog.e("VipComicMqqHandlerProxy", 4, "getMyComicFavorEmotIcons fail.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.ipc.proxy.VipComicMqqHandlerProxy
 * JD-Core Version:    0.7.0.1
 */
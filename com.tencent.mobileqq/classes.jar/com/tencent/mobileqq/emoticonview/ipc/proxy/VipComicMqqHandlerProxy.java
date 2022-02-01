package com.tencent.mobileqq.emoticonview.ipc.proxy;

import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
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
  
  public VipComicMqqHandlerProxy(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface, BusinessHandlerFactory.MQQ_COMIC_HANDLER);
  }
  
  public static EIPCResult onGetMyComicFavorEmotIcons(QQAppInterface paramQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    ((VipComicMqqHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.MQQ_COMIC_HANDLER)).a();
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
    }
    do
    {
      return;
      EIPCResult localEIPCResult = QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "vipcomicm_favoremoticons", null);
      if ((localEIPCResult == null) || (!localEIPCResult.isSuccess())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("VipComicMqqHandlerProxy", 4, "getMyComicFavorEmotIcons suc.");
    return;
    QLog.e("VipComicMqqHandlerProxy", 4, "getMyComicFavorEmotIcons fail.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.ipc.proxy.VipComicMqqHandlerProxy
 * JD-Core Version:    0.7.0.1
 */
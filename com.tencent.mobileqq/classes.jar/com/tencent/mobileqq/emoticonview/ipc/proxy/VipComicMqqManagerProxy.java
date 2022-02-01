package com.tencent.mobileqq.emoticonview.ipc.proxy;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.emosm.vipcomic.VipComicMqqManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;

public class VipComicMqqManagerProxy
  extends AbsManagerProxy<VipComicMqqManager>
{
  public static final String ACTION_VIPCOMICM_UPLOADINITCOMICEINFO = "vipcomicm_uploadinitcomiceinfo";
  public static final String TAG = "VipComicMqqManagerProxy";
  
  public VipComicMqqManagerProxy(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface, QQManagerFactory.MQQ_COMIC_MANAGER);
  }
  
  public static EIPCResult onUploadInitComicEmoStructMsgInfo(QQAppInterface paramQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    ((VipComicMqqManager)paramQQAppInterface.getManager(QQManagerFactory.MQQ_COMIC_MANAGER)).a();
    return EIPCResult.createSuccessResult(null);
  }
  
  public void uploadInitComicEmoStructMsgInfo()
  {
    if (this.manager != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VipComicMqqManagerProxy", 4, "do uploadInitComicEmoStructMsgInfo.");
      }
      ((VipComicMqqManager)this.manager).a();
    }
    do
    {
      return;
      EIPCResult localEIPCResult = QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "vipcomicm_uploadinitcomiceinfo", null);
      if ((localEIPCResult == null) || (!localEIPCResult.isSuccess())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("VipComicMqqManagerProxy", 4, "uploadInitComicEmoStructMsgInfo suc.");
    return;
    QLog.e("VipComicMqqManagerProxy", 4, "uploadInitComicEmoStructMsgInfo fail.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.ipc.proxy.VipComicMqqManagerProxy
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.emoticonview.ipc.proxy;

import android.os.Bundle;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.IMqqHandlerProxy;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import mqq.os.MqqHandler;

public class MqqHandlerProxy
  implements IMqqHandlerProxy
{
  public static final String ACTION_MQQHANDLER_SENDTOTARGET = "sendtotarget";
  private static final String PARAM_CLAZZ = "param_clazz";
  private static final String PARAM_MSGUPDATE = "param_msgupdate";
  public static final String TAG = "MqqHandlerProxy";
  private QQAppInterface mApp;
  private Class mClass;
  private MqqHandler mMqqHandler;
  
  public MqqHandlerProxy(QQAppInterface paramQQAppInterface, Class paramClass)
  {
    this.mApp = paramQQAppInterface;
    this.mClass = paramClass;
    if (this.mApp != null) {
      this.mMqqHandler = this.mApp.getHandler(paramClass);
    }
  }
  
  public static EIPCResult onSendToTarget(QQAppInterface paramQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    paramQQAppInterface.getHandler((Class)paramBundle.getSerializable("param_clazz")).obtainMessage(paramBundle.getInt("param_msgupdate")).sendToTarget();
    return EIPCResult.createSuccessResult(null);
  }
  
  public void sendToTarget(int paramInt)
  {
    if (this.mMqqHandler != null) {
      this.mMqqHandler.obtainMessage(paramInt).sendToTarget();
    }
    do
    {
      return;
      Object localObject = new Bundle();
      ((Bundle)localObject).putInt("param_msgupdate", paramInt);
      ((Bundle)localObject).putSerializable("param_clazz", this.mClass);
      localObject = QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "sendtotarget", (Bundle)localObject);
      if ((localObject == null) || (!((EIPCResult)localObject).isSuccess())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("MqqHandlerProxy", 4, "sendToTarget suc.");
    return;
    QLog.e("MqqHandlerProxy", 4, "sendToTarget fail.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.ipc.proxy.MqqHandlerProxy
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.emoticonview.ipc.proxy;

import android.os.Bundle;
import android.os.Message;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
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
  private BaseQQAppInterface mApp;
  private Class mClass;
  private MqqHandler mMqqHandler;
  
  public MqqHandlerProxy(BaseQQAppInterface paramBaseQQAppInterface, Class paramClass)
  {
    this.mApp = paramBaseQQAppInterface;
    this.mClass = paramClass;
    paramBaseQQAppInterface = this.mApp;
    if (paramBaseQQAppInterface != null) {
      this.mMqqHandler = paramBaseQQAppInterface.getHandler(paramClass);
    }
  }
  
  public static EIPCResult onSendToTarget(AppInterface paramAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    paramAppInterface.getHandler((Class)paramBundle.getSerializable("param_clazz")).obtainMessage(paramBundle.getInt("param_msgupdate")).sendToTarget();
    return EIPCResult.createSuccessResult(null);
  }
  
  public void sendToTarget(int paramInt)
  {
    Object localObject = this.mMqqHandler;
    if (localObject != null)
    {
      ((MqqHandler)localObject).obtainMessage(paramInt).sendToTarget();
      return;
    }
    localObject = new Bundle();
    ((Bundle)localObject).putInt("param_msgupdate", paramInt);
    ((Bundle)localObject).putSerializable("param_clazz", this.mClass);
    localObject = QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "sendtotarget", (Bundle)localObject);
    if ((localObject != null) && (((EIPCResult)localObject).isSuccess()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MqqHandlerProxy", 4, "sendToTarget suc.");
      }
    }
    else {
      QLog.e("MqqHandlerProxy", 4, "sendToTarget fail.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.ipc.proxy.MqqHandlerProxy
 * JD-Core Version:    0.7.0.1
 */
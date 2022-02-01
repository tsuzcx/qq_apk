package com.tencent.mobileqq.emosm.favroaming;

import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.MobileQQ;

public class EmoticonIPCModule
  extends QIPCModule
  implements IEmoticonIPCModule
{
  private static EmoticonIPCModule a;
  
  private EmoticonIPCModule(String paramString)
  {
    super(paramString);
  }
  
  public static EmoticonIPCModule a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new EmoticonIPCModule("EmoticonIPCModule");
        }
      }
      finally {}
    }
    return a;
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onCall action = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("EmoticonIPCModule", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (!(localObject instanceof BaseQQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonIPCModule", 2, "cannot get QQAppInterface.");
      }
      return null;
    }
    localObject = (BaseQQAppInterface)localObject;
    ThreadManager.post(new EmoticonIPCModule.1(this, paramBundle, paramString, (EmoticonFromGroupManager)((IEmosmService)QRoute.api(IEmosmService.class)).getEmoticonFromGroupManager((BaseQQAppInterface)localObject), paramInt), 5, null, true);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.EmoticonIPCModule
 * JD-Core Version:    0.7.0.1
 */
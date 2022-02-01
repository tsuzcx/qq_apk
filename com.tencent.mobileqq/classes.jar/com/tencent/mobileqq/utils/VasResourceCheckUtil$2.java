package com.tencent.mobileqq.utils;

import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;

final class VasResourceCheckUtil$2
  implements Handler.Callback
{
  public boolean handleMessage(Message paramMessage)
  {
    if ((BaseApplicationImpl.getApplication().waitAppRuntime(null) instanceof QQAppInterface))
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().waitAppRuntime(null);
      switch (paramMessage.what)
      {
      default: 
        break;
      case 260: 
        QQToast.a(localQQAppInterface.getApplication(), HardCodeUtil.a(2131715800), 0).a();
        break;
      case 259: 
        QQToast.a(localQQAppInterface.getApplication(), HardCodeUtil.a(2131715798), 0).a();
        break;
      case 258: 
        QQToast.a(localQQAppInterface.getApplication(), HardCodeUtil.a(2131715797), 0).a();
        break;
      case 257: 
        QQToast.a(localQQAppInterface.getApplication(), HardCodeUtil.a(2131715799), 0).a();
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.VasResourceCheckUtil.2
 * JD-Core Version:    0.7.0.1
 */
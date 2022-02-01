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
        QQToast.makeText(localQQAppInterface.getApplication(), HardCodeUtil.a(2131913257), 0).show();
        break;
      case 259: 
        QQToast.makeText(localQQAppInterface.getApplication(), HardCodeUtil.a(2131913255), 0).show();
        break;
      case 258: 
        QQToast.makeText(localQQAppInterface.getApplication(), HardCodeUtil.a(2131913254), 0).show();
        break;
      case 257: 
        QQToast.makeText(localQQAppInterface.getApplication(), HardCodeUtil.a(2131913256), 0).show();
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.VasResourceCheckUtil.2
 * JD-Core Version:    0.7.0.1
 */
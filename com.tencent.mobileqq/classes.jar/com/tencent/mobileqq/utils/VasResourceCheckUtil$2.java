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
    QQAppInterface localQQAppInterface;
    if ((BaseApplicationImpl.getApplication().waitAppRuntime(null) instanceof QQAppInterface))
    {
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().waitAppRuntime(null);
      switch (paramMessage.what)
      {
      }
    }
    for (;;)
    {
      return true;
      QQToast.a(localQQAppInterface.getApplication(), HardCodeUtil.a(2131715876), 0).a();
      continue;
      QQToast.a(localQQAppInterface.getApplication(), HardCodeUtil.a(2131715875), 0).a();
      continue;
      QQToast.a(localQQAppInterface.getApplication(), HardCodeUtil.a(2131715874), 0).a();
      continue;
      QQToast.a(localQQAppInterface.getApplication(), HardCodeUtil.a(2131715877), 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.VasResourceCheckUtil.2
 * JD-Core Version:    0.7.0.1
 */
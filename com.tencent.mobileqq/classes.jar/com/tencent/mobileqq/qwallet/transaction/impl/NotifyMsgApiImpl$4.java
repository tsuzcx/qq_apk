package com.tencent.mobileqq.qwallet.transaction.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;
import java.util.ArrayList;
import mqq.app.MobileQQ;

final class NotifyMsgApiImpl$4
  implements Runnable
{
  NotifyMsgApiImpl$4(boolean paramBoolean, ArrayList paramArrayList) {}
  
  public void run()
  {
    synchronized (NotifyMsgApiImpl.gDbHelperLock)
    {
      if (NotifyMsgApiImpl.gDbHelper == null) {
        NotifyMsgApiImpl.gDbHelper = new NotifyMsgDBHelper(MobileQQ.getContext());
      }
      ??? = QWalletTools.a();
      if (??? == null) {
        return;
      }
      if (NotifyMsgApiImpl.gDbHelper != null)
      {
        if (this.jdField_a_of_type_Boolean)
        {
          NotifyMsgApiImpl.gDbHelper.b(((BaseQQAppInterface)???).getCurrentUin(), this.jdField_a_of_type_JavaUtilArrayList);
          return;
        }
        NotifyMsgApiImpl.gDbHelper.c(((BaseQQAppInterface)???).getCurrentUin(), this.jdField_a_of_type_JavaUtilArrayList);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.transaction.impl.NotifyMsgApiImpl.4
 * JD-Core Version:    0.7.0.1
 */
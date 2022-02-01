package com.tencent.mobileqq.qwallet.impl;

import android.os.Bundle;
import mqq.observer.BusinessObserver;

class QWalletCommonServlet$1
  implements Runnable
{
  QWalletCommonServlet$1(QWalletCommonServlet paramQWalletCommonServlet, BusinessObserver paramBusinessObserver, int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  public void run()
  {
    this.jdField_a_of_type_MqqObserverBusinessObserver.onReceive(this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_AndroidOsBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.impl.QWalletCommonServlet.1
 * JD-Core Version:    0.7.0.1
 */
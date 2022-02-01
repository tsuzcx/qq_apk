package com.tencent.mobileqq.miniapp;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class AKOfflineDownloader$1$1
  implements Runnable
{
  AKOfflineDownloader$1$1(AKOfflineDownloader.1 param1) {}
  
  public void run()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("bid", this.a.jdField_a_of_type_JavaLangString);
    localBundle.putString("path", AKOfflineDownloader.a(this.a.jdField_a_of_type_JavaLangString, ""));
    AKOfflineDownloader.a(this.a.jdField_a_of_type_ComTencentMobileqqMiniappAKOfflineDownloader.a(localBundle), this.a.b, this.a.c, 1, this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_JavaLangObject);
    QLog.d("AKOfflineDownloader", 2, new Object[] { " checkUpByBusinessId load success. param null. cost=", Long.valueOf(System.currentTimeMillis() - this.a.jdField_a_of_type_Long) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.miniapp.AKOfflineDownloader.1.1
 * JD-Core Version:    0.7.0.1
 */
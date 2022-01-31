package com.tencent.mobileqq.miniapp;

import android.os.Bundle;
import asir;
import asis;
import com.tencent.qphone.base.util.QLog;

public class AKOfflineDownloader$1$1
  implements Runnable
{
  public AKOfflineDownloader$1$1(asis paramasis) {}
  
  public void run()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("bid", this.a.jdField_a_of_type_JavaLangString);
    localBundle.putString("path", asir.a(this.a.jdField_a_of_type_JavaLangString, ""));
    asir.a(this.a.jdField_a_of_type_Asir.a(localBundle), this.a.b, this.a.c, 1, this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_JavaLangObject);
    QLog.d("AKOfflineDownloader", 2, new Object[] { " checkUpByBusinessId load success. param null. cost=", Long.valueOf(System.currentTimeMillis() - this.a.jdField_a_of_type_Long) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.miniapp.AKOfflineDownloader.1.1
 * JD-Core Version:    0.7.0.1
 */
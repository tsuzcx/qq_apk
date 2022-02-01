package com.tencent.mobileqq.miniapp;

import android.os.Bundle;
import avrj;
import avrk;
import com.tencent.qphone.base.util.QLog;

public class AKOfflineDownloader$1$1
  implements Runnable
{
  public AKOfflineDownloader$1$1(avrk paramavrk) {}
  
  public void run()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("bid", this.a.jdField_a_of_type_JavaLangString);
    localBundle.putString("path", avrj.a(this.a.jdField_a_of_type_JavaLangString, ""));
    avrj.a(this.a.jdField_a_of_type_Avrj.a(localBundle), this.a.b, this.a.c, 1, this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_JavaLangObject);
    QLog.d("AKOfflineDownloader", 2, new Object[] { " checkUpByBusinessId load success. param null. cost=", Long.valueOf(System.currentTimeMillis() - this.a.jdField_a_of_type_Long) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.miniapp.AKOfflineDownloader.1.1
 * JD-Core Version:    0.7.0.1
 */
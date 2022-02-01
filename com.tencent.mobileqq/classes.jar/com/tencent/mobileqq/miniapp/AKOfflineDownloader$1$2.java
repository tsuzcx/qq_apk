package com.tencent.mobileqq.miniapp;

import android.os.Bundle;
import awlk;
import awll;
import com.tencent.qphone.base.util.QLog;

public class AKOfflineDownloader$1$2
  implements Runnable
{
  public AKOfflineDownloader$1$2(awll paramawll) {}
  
  public void run()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("bid", this.a.jdField_a_of_type_JavaLangString);
    localBundle.putString("path", awlk.a(this.a.jdField_a_of_type_JavaLangString, ""));
    awlk.a(this.a.jdField_a_of_type_Awlk.a(localBundle), this.a.b, this.a.c, 3, this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_JavaLangObject);
    QLog.d("AKOfflineDownloader", 2, new Object[] { "checkUpByBusinessId load success. no update. cost=", Long.valueOf(System.currentTimeMillis() - this.a.jdField_a_of_type_Long) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.miniapp.AKOfflineDownloader.1.2
 * JD-Core Version:    0.7.0.1
 */
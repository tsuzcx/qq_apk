package com.tencent.mobileqq.miniapp;

import android.os.Bundle;
import armm;
import armn;
import com.tencent.qphone.base.util.QLog;

public class AKOfflineDownloader$1$2
  implements Runnable
{
  public AKOfflineDownloader$1$2(armn paramarmn) {}
  
  public void run()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("bid", this.a.jdField_a_of_type_JavaLangString);
    localBundle.putString("path", armm.a(this.a.jdField_a_of_type_JavaLangString, ""));
    armm.a(this.a.jdField_a_of_type_Armm.a(localBundle), this.a.b, this.a.c, 3, this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_JavaLangObject);
    QLog.d("AKOfflineDownloader", 2, new Object[] { "checkUpByBusinessId load success. no update. cost=", Long.valueOf(System.currentTimeMillis() - this.a.jdField_a_of_type_Long) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.miniapp.AKOfflineDownloader.1.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.webview.webso;

import android.net.Uri;
import android.text.TextUtils;
import bbdj;
import bcgp;
import bchc;
import bche;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

class WebSoService$3
  implements Runnable
{
  WebSoService$3(WebSoService paramWebSoService, File paramFile, String paramString, bchc parambchc, Uri paramUri) {}
  
  public void run()
  {
    try
    {
      long l = System.currentTimeMillis();
      String str = bbdj.b(this.jdField_a_of_type_JavaIoFile);
      if (QLog.isColorLevel()) {
        QLog.d("WebSoService", 2, "readFileToString cost=" + (System.currentTimeMillis() - l));
      }
      if (!TextUtils.isEmpty(str))
      {
        l = System.currentTimeMillis();
        if (bcgp.a(str).equals(this.jdField_a_of_type_JavaLangString))
        {
          if (QLog.isColorLevel()) {
            QLog.d("WebSoService", 2, "verify html success cost=" + (System.currentTimeMillis() - l));
          }
          this.jdField_a_of_type_Bchc.a(str);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("WebSoService", 2, "verify html fail cost=" + (System.currentTimeMillis() - l));
        }
        bche.a(this.jdField_a_of_type_AndroidNetUri);
        this.jdField_a_of_type_Bchc.a("");
        return;
      }
    }
    catch (IOException localIOException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebSoService", 2, "deal eTag exception=" + localIOException.getMessage());
      }
      bche.a(this.jdField_a_of_type_AndroidNetUri);
      this.jdField_a_of_type_Bchc.a("");
      localIOException.printStackTrace();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebSoService", 2, "verify load data exception=" + localOutOfMemoryError.getMessage());
      }
      this.jdField_a_of_type_Bchc.a("");
      localOutOfMemoryError.printStackTrace();
      VipUtils.a(null, "webview_report", "0X8006511", "0X8006511", 1, 1, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.WebSoService.3
 * JD-Core Version:    0.7.0.1
 */
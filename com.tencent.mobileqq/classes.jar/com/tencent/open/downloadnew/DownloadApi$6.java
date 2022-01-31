package com.tencent.open.downloadnew;

import bfhg;
import bfju;
import bfkb;
import bfki;
import java.util.ArrayList;
import java.util.List;

public final class DownloadApi$6
  implements Runnable
{
  public DownloadApi$6(String paramString, bfki parambfki) {}
  
  public void run()
  {
    bfhg.a(bfju.jdField_a_of_type_JavaLangString, "getQueryDownloadActionByVia enter");
    try
    {
      new ArrayList();
      List localList = bfkb.a().b(this.jdField_a_of_type_JavaLangString);
      bfhg.a(bfju.jdField_a_of_type_JavaLangString, "getQueryDownloadActionByVia result = " + localList);
      if (this.jdField_a_of_type_Bfki != null) {
        this.jdField_a_of_type_Bfki.a(localList);
      }
      return;
    }
    catch (Exception localException)
    {
      do
      {
        bfhg.c(bfju.jdField_a_of_type_JavaLangString, "getQueryDownloadActionByVia Exception>>>", localException);
      } while (this.jdField_a_of_type_Bfki == null);
      this.jdField_a_of_type_Bfki.a(-1, localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadApi.6
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.open.downloadnew;

import bhzm;
import bibs;
import biby;
import bicf;
import java.util.ArrayList;
import java.util.List;

public final class DownloadApi$6
  implements Runnable
{
  public DownloadApi$6(String paramString, bicf parambicf) {}
  
  public void run()
  {
    bhzm.a(bibs.jdField_a_of_type_JavaLangString, "getQueryDownloadActionByVia enter");
    try
    {
      new ArrayList();
      List localList = biby.a().b(this.jdField_a_of_type_JavaLangString);
      bhzm.a(bibs.jdField_a_of_type_JavaLangString, "getQueryDownloadActionByVia result = " + localList);
      if (this.jdField_a_of_type_Bicf != null) {
        this.jdField_a_of_type_Bicf.a(localList);
      }
      return;
    }
    catch (Exception localException)
    {
      do
      {
        bhzm.c(bibs.jdField_a_of_type_JavaLangString, "getQueryDownloadActionByVia Exception>>>", localException);
      } while (this.jdField_a_of_type_Bicf == null);
      this.jdField_a_of_type_Bicf.a(-1, localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadApi.6
 * JD-Core Version:    0.7.0.1
 */
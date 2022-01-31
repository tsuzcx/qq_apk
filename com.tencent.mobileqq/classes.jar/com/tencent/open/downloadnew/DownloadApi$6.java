package com.tencent.open.downloadnew;

import bdht;
import bdki;
import bdkp;
import bdkw;
import java.util.ArrayList;
import java.util.List;

public final class DownloadApi$6
  implements Runnable
{
  public DownloadApi$6(String paramString, bdkw parambdkw) {}
  
  public void run()
  {
    bdht.a(bdki.jdField_a_of_type_JavaLangString, "getQueryDownloadActionByVia enter");
    try
    {
      new ArrayList();
      List localList = bdkp.a().b(this.jdField_a_of_type_JavaLangString);
      bdht.a(bdki.jdField_a_of_type_JavaLangString, "getQueryDownloadActionByVia result = " + localList);
      if (this.jdField_a_of_type_Bdkw != null) {
        this.jdField_a_of_type_Bdkw.a(localList);
      }
      return;
    }
    catch (Exception localException)
    {
      do
      {
        bdht.c(bdki.jdField_a_of_type_JavaLangString, "getQueryDownloadActionByVia Exception>>>", localException);
      } while (this.jdField_a_of_type_Bdkw == null);
      this.jdField_a_of_type_Bdkw.a(-1, localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadApi.6
 * JD-Core Version:    0.7.0.1
 */
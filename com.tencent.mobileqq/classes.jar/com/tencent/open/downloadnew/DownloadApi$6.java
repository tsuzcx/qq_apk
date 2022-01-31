package com.tencent.open.downloadnew;

import bdii;
import bdkx;
import bdle;
import bdll;
import java.util.ArrayList;
import java.util.List;

public final class DownloadApi$6
  implements Runnable
{
  public DownloadApi$6(String paramString, bdll parambdll) {}
  
  public void run()
  {
    bdii.a(bdkx.jdField_a_of_type_JavaLangString, "getQueryDownloadActionByVia enter");
    try
    {
      new ArrayList();
      List localList = bdle.a().b(this.jdField_a_of_type_JavaLangString);
      bdii.a(bdkx.jdField_a_of_type_JavaLangString, "getQueryDownloadActionByVia result = " + localList);
      if (this.jdField_a_of_type_Bdll != null) {
        this.jdField_a_of_type_Bdll.a(localList);
      }
      return;
    }
    catch (Exception localException)
    {
      do
      {
        bdii.c(bdkx.jdField_a_of_type_JavaLangString, "getQueryDownloadActionByVia Exception>>>", localException);
      } while (this.jdField_a_of_type_Bdll == null);
      this.jdField_a_of_type_Bdll.a(-1, localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadApi.6
 * JD-Core Version:    0.7.0.1
 */
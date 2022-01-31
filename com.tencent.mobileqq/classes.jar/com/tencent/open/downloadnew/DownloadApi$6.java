package com.tencent.open.downloadnew;

import bcds;
import bcgh;
import bcgo;
import bcgv;
import java.util.ArrayList;
import java.util.List;

public final class DownloadApi$6
  implements Runnable
{
  public DownloadApi$6(String paramString, bcgv parambcgv) {}
  
  public void run()
  {
    bcds.a(bcgh.jdField_a_of_type_JavaLangString, "getQueryDownloadActionByVia enter");
    try
    {
      new ArrayList();
      List localList = bcgo.a().b(this.jdField_a_of_type_JavaLangString);
      bcds.a(bcgh.jdField_a_of_type_JavaLangString, "getQueryDownloadActionByVia result = " + localList);
      if (this.jdField_a_of_type_Bcgv != null) {
        this.jdField_a_of_type_Bcgv.a(localList);
      }
      return;
    }
    catch (Exception localException)
    {
      do
      {
        bcds.c(bcgh.jdField_a_of_type_JavaLangString, "getQueryDownloadActionByVia Exception>>>", localException);
      } while (this.jdField_a_of_type_Bcgv == null);
      this.jdField_a_of_type_Bcgv.a(-1, localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadApi.6
 * JD-Core Version:    0.7.0.1
 */
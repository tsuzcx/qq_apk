package com.tencent.open.downloadnew;

import bflp;
import bfod;
import bfok;
import bfor;
import java.util.ArrayList;
import java.util.List;

public final class DownloadApi$6
  implements Runnable
{
  public DownloadApi$6(String paramString, bfor parambfor) {}
  
  public void run()
  {
    bflp.a(bfod.jdField_a_of_type_JavaLangString, "getQueryDownloadActionByVia enter");
    try
    {
      new ArrayList();
      List localList = bfok.a().b(this.jdField_a_of_type_JavaLangString);
      bflp.a(bfod.jdField_a_of_type_JavaLangString, "getQueryDownloadActionByVia result = " + localList);
      if (this.jdField_a_of_type_Bfor != null) {
        this.jdField_a_of_type_Bfor.a(localList);
      }
      return;
    }
    catch (Exception localException)
    {
      do
      {
        bflp.c(bfod.jdField_a_of_type_JavaLangString, "getQueryDownloadActionByVia Exception>>>", localException);
      } while (this.jdField_a_of_type_Bfor == null);
      this.jdField_a_of_type_Bfor.a(-1, localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadApi.6
 * JD-Core Version:    0.7.0.1
 */
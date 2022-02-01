package com.tencent.open.downloadnew;

import bjtx;
import bjwk;
import bjwq;
import bjwx;
import java.util.ArrayList;
import java.util.List;

public final class DownloadApi$6
  implements Runnable
{
  public DownloadApi$6(String paramString, bjwx parambjwx) {}
  
  public void run()
  {
    bjtx.a(bjwk.jdField_a_of_type_JavaLangString, "getQueryDownloadActionByVia enter");
    try
    {
      new ArrayList();
      List localList = bjwq.a().b(this.jdField_a_of_type_JavaLangString);
      bjtx.a(bjwk.jdField_a_of_type_JavaLangString, "getQueryDownloadActionByVia result = " + localList);
      if (this.jdField_a_of_type_Bjwx != null) {
        this.jdField_a_of_type_Bjwx.a(localList);
      }
      return;
    }
    catch (Exception localException)
    {
      do
      {
        bjtx.c(bjwk.jdField_a_of_type_JavaLangString, "getQueryDownloadActionByVia Exception>>>", localException);
      } while (this.jdField_a_of_type_Bjwx == null);
      this.jdField_a_of_type_Bjwx.a(-1, localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadApi.6
 * JD-Core Version:    0.7.0.1
 */
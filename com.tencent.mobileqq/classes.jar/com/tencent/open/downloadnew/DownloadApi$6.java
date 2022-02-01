package com.tencent.open.downloadnew;

import bisy;
import bivl;
import bivr;
import bivy;
import java.util.ArrayList;
import java.util.List;

public final class DownloadApi$6
  implements Runnable
{
  public DownloadApi$6(String paramString, bivy parambivy) {}
  
  public void run()
  {
    bisy.a(bivl.jdField_a_of_type_JavaLangString, "getQueryDownloadActionByVia enter");
    try
    {
      new ArrayList();
      List localList = bivr.a().b(this.jdField_a_of_type_JavaLangString);
      bisy.a(bivl.jdField_a_of_type_JavaLangString, "getQueryDownloadActionByVia result = " + localList);
      if (this.jdField_a_of_type_Bivy != null) {
        this.jdField_a_of_type_Bivy.a(localList);
      }
      return;
    }
    catch (Exception localException)
    {
      do
      {
        bisy.c(bivl.jdField_a_of_type_JavaLangString, "getQueryDownloadActionByVia Exception>>>", localException);
      } while (this.jdField_a_of_type_Bivy == null);
      this.jdField_a_of_type_Bivy.a(-1, localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadApi.6
 * JD-Core Version:    0.7.0.1
 */
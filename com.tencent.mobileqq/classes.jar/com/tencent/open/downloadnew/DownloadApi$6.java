package com.tencent.open.downloadnew;

import bjko;
import bjmu;
import bjna;
import bjnh;
import java.util.ArrayList;
import java.util.List;

public final class DownloadApi$6
  implements Runnable
{
  public DownloadApi$6(String paramString, bjnh parambjnh) {}
  
  public void run()
  {
    bjko.a(bjmu.jdField_a_of_type_JavaLangString, "getQueryDownloadActionByVia enter");
    try
    {
      new ArrayList();
      List localList = bjna.a().b(this.jdField_a_of_type_JavaLangString);
      bjko.a(bjmu.jdField_a_of_type_JavaLangString, "getQueryDownloadActionByVia result = " + localList);
      if (this.jdField_a_of_type_Bjnh != null) {
        this.jdField_a_of_type_Bjnh.a(localList);
      }
      return;
    }
    catch (Exception localException)
    {
      do
      {
        bjko.c(bjmu.jdField_a_of_type_JavaLangString, "getQueryDownloadActionByVia Exception>>>", localException);
      } while (this.jdField_a_of_type_Bjnh == null);
      this.jdField_a_of_type_Bjnh.a(-1, localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadApi.6
 * JD-Core Version:    0.7.0.1
 */
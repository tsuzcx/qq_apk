package com.tencent.mobileqq.filemanager.multisave;

import apap;
import apaq;
import apdq;
import com.tencent.qphone.base.util.BaseApplication;

public class QFileMultiSaveReq$1
  implements Runnable
{
  public QFileMultiSaveReq$1(apap paramapap, String paramString, apaq paramapaq) {}
  
  public void run()
  {
    try
    {
      boolean bool = apdq.a(BaseApplication.getContext(), this.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_Apaq != null)
      {
        if (bool)
        {
          this.jdField_a_of_type_Apaq.a();
          return;
        }
        this.jdField_a_of_type_Apaq.a(-1, "save file fail. filePath[" + this.jdField_a_of_type_JavaLangString + "]");
        return;
      }
    }
    catch (Exception localException)
    {
      if (this.jdField_a_of_type_Apaq != null) {
        this.jdField_a_of_type_Apaq.a(-1, localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.multisave.QFileMultiSaveReq.1
 * JD-Core Version:    0.7.0.1
 */
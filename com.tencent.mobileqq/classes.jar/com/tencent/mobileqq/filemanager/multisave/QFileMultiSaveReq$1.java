package com.tencent.mobileqq.filemanager.multisave;

import arlp;
import arlq;
import aroo;
import com.tencent.qphone.base.util.BaseApplication;

public class QFileMultiSaveReq$1
  implements Runnable
{
  public QFileMultiSaveReq$1(arlp paramarlp, String paramString, arlq paramarlq) {}
  
  public void run()
  {
    try
    {
      boolean bool = aroo.a(BaseApplication.getContext(), this.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_Arlq != null)
      {
        if (bool)
        {
          this.jdField_a_of_type_Arlq.a();
          return;
        }
        this.jdField_a_of_type_Arlq.a(-1, "save file fail. filePath[" + this.jdField_a_of_type_JavaLangString + "]");
        return;
      }
    }
    catch (Exception localException)
    {
      if (this.jdField_a_of_type_Arlq != null) {
        this.jdField_a_of_type_Arlq.a(-1, localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.multisave.QFileMultiSaveReq.1
 * JD-Core Version:    0.7.0.1
 */
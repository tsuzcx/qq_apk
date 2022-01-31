package com.tencent.mobileqq.filemanager.multisave;

import apsj;
import apsk;
import apvk;
import com.tencent.qphone.base.util.BaseApplication;

public class QFileMultiSaveReq$1
  implements Runnable
{
  public QFileMultiSaveReq$1(apsj paramapsj, String paramString, apsk paramapsk) {}
  
  public void run()
  {
    try
    {
      boolean bool = apvk.a(BaseApplication.getContext(), this.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_Apsk != null)
      {
        if (bool)
        {
          this.jdField_a_of_type_Apsk.a();
          return;
        }
        this.jdField_a_of_type_Apsk.a(-1, "save file fail. filePath[" + this.jdField_a_of_type_JavaLangString + "]");
        return;
      }
    }
    catch (Exception localException)
    {
      if (this.jdField_a_of_type_Apsk != null) {
        this.jdField_a_of_type_Apsk.a(-1, localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.multisave.QFileMultiSaveReq.1
 * JD-Core Version:    0.7.0.1
 */
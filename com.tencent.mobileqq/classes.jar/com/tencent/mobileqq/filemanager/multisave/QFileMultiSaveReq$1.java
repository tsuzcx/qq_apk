package com.tencent.mobileqq.filemanager.multisave;

import arpy;
import arpz;
import arsx;
import com.tencent.qphone.base.util.BaseApplication;

public class QFileMultiSaveReq$1
  implements Runnable
{
  public QFileMultiSaveReq$1(arpy paramarpy, String paramString, arpz paramarpz) {}
  
  public void run()
  {
    try
    {
      boolean bool = arsx.a(BaseApplication.getContext(), this.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_Arpz != null)
      {
        if (bool)
        {
          this.jdField_a_of_type_Arpz.a();
          return;
        }
        this.jdField_a_of_type_Arpz.a(-1, "save file fail. filePath[" + this.jdField_a_of_type_JavaLangString + "]");
        return;
      }
    }
    catch (Exception localException)
    {
      if (this.jdField_a_of_type_Arpz != null) {
        this.jdField_a_of_type_Arpz.a(-1, localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.multisave.QFileMultiSaveReq.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.filemanager.multisave;

import android.text.TextUtils;
import attv;
import attw;
import atwe;

public class QFileMultiSaveReq$1
  implements Runnable
{
  public QFileMultiSaveReq$1(attv paramattv, String paramString, attw paramattw) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(atwe.b(this.jdField_a_of_type_JavaLangString))) {
          break label97;
        }
        i = 1;
        if (this.jdField_a_of_type_Attw != null)
        {
          if (i != 0)
          {
            this.jdField_a_of_type_Attw.a();
            return;
          }
          this.jdField_a_of_type_Attw.a(-1, "save file fail. filePath[" + this.jdField_a_of_type_JavaLangString + "]");
          return;
        }
      }
      catch (Exception localException)
      {
        if (this.jdField_a_of_type_Attw != null) {
          this.jdField_a_of_type_Attw.a(-1, localException.getMessage());
        }
      }
      return;
      label97:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.multisave.QFileMultiSaveReq.1
 * JD-Core Version:    0.7.0.1
 */
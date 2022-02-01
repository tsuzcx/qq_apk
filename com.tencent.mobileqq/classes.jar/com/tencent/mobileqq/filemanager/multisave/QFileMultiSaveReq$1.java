package com.tencent.mobileqq.filemanager.multisave;

import android.text.TextUtils;
import auch;
import auci;
import aueq;

public class QFileMultiSaveReq$1
  implements Runnable
{
  public QFileMultiSaveReq$1(auch paramauch, String paramString, auci paramauci) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(aueq.b(this.jdField_a_of_type_JavaLangString))) {
          break label97;
        }
        i = 1;
        if (this.jdField_a_of_type_Auci != null)
        {
          if (i != 0)
          {
            this.jdField_a_of_type_Auci.a();
            return;
          }
          this.jdField_a_of_type_Auci.a(-1, "save file fail. filePath[" + this.jdField_a_of_type_JavaLangString + "]");
          return;
        }
      }
      catch (Exception localException)
      {
        if (this.jdField_a_of_type_Auci != null) {
          this.jdField_a_of_type_Auci.a(-1, localException.getMessage());
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
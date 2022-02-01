package com.tencent.mobileqq.filemanager.multisave;

import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.util.FilePathUtil;

class QFileMultiSaveReq$1
  implements Runnable
{
  QFileMultiSaveReq$1(QFileMultiSaveReq paramQFileMultiSaveReq, String paramString, QFileMultiSaveReq.ISaveFileCallBack paramISaveFileCallBack) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(FilePathUtil.b(this.jdField_a_of_type_JavaLangString))) {
          break label97;
        }
        i = 1;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq$ISaveFileCallBack != null)
        {
          if (i != 0)
          {
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq$ISaveFileCallBack.a();
            return;
          }
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq$ISaveFileCallBack.a(-1, "save file fail. filePath[" + this.jdField_a_of_type_JavaLangString + "]");
          return;
        }
      }
      catch (Exception localException)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq$ISaveFileCallBack != null) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq$ISaveFileCallBack.a(-1, localException.getMessage());
        }
      }
      return;
      label97:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.multisave.QFileMultiSaveReq.1
 * JD-Core Version:    0.7.0.1
 */
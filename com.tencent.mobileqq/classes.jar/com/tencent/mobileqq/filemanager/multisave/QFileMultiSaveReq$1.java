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
        if (TextUtils.isEmpty(FilePathUtil.a(this.jdField_a_of_type_JavaLangString))) {
          break label109;
        }
        i = 1;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq$ISaveFileCallBack != null)
        {
          if (i != 0)
          {
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq$ISaveFileCallBack.a();
            return;
          }
          QFileMultiSaveReq.ISaveFileCallBack localISaveFileCallBack = this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq$ISaveFileCallBack;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("save file fail. filePath[");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject).append("]");
          localISaveFileCallBack.a(-1, ((StringBuilder)localObject).toString());
          return;
        }
      }
      catch (Exception localException)
      {
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq$ISaveFileCallBack;
        if (localObject != null) {
          ((QFileMultiSaveReq.ISaveFileCallBack)localObject).a(-1, localException.getMessage());
        }
      }
      return;
      label109:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.multisave.QFileMultiSaveReq.1
 * JD-Core Version:    0.7.0.1
 */
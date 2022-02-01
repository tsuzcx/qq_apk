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
        if (TextUtils.isEmpty(FilePathUtil.a(this.a))) {
          break label109;
        }
        i = 1;
        if (this.b != null)
        {
          if (i != 0)
          {
            this.b.a();
            return;
          }
          QFileMultiSaveReq.ISaveFileCallBack localISaveFileCallBack = this.b;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("save file fail. filePath[");
          ((StringBuilder)localObject).append(this.a);
          ((StringBuilder)localObject).append("]");
          localISaveFileCallBack.a(-1, ((StringBuilder)localObject).toString());
          return;
        }
      }
      catch (Exception localException)
      {
        Object localObject = this.b;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.multisave.QFileMultiSaveReq.1
 * JD-Core Version:    0.7.0.1
 */
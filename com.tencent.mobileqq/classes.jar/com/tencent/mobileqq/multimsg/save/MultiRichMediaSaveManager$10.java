package com.tencent.mobileqq.multimsg.save;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.filemanager.multisave.QFileMultiSaveReq;
import com.tencent.mobileqq.filemanager.multisave.QFileMultiSaveReq.ISaveFileCallBack;
import com.tencent.qphone.base.util.QLog;

class MultiRichMediaSaveManager$10
  implements QFileMultiSaveReq.ISaveFileCallBack
{
  MultiRichMediaSaveManager$10(MultiRichMediaSaveManager paramMultiRichMediaSaveManager, QFileMultiSaveReq paramQFileMultiSaveReq) {}
  
  public void a()
  {
    Message localMessage = MultiRichMediaSaveManager.b(this.b).obtainMessage(1);
    FileSaveResult localFileSaveResult = this.b.a(this.a.b());
    if (localFileSaveResult != null)
    {
      localFileSaveResult.b = 0;
      localMessage.obj = localFileSaveResult;
      MultiRichMediaSaveManager.b(this.b).sendMessage(localMessage);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("saveVideoFile fail, errorCode = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" ,errorMsg = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.e("MultiRichMediaSaveManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.b.a(this.a.b());
    if (localObject != null)
    {
      ((FileSaveResult)localObject).b = -1;
      ((FileSaveResult)localObject).c = paramInt;
      ((FileSaveResult)localObject).d = paramString;
      MultiRichMediaSaveManager.a(this.b, (FileSaveResult)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.save.MultiRichMediaSaveManager.10
 * JD-Core Version:    0.7.0.1
 */
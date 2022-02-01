package com.tencent.mobileqq.multimsg.save;

import com.tencent.mobileqq.filemanager.multisave.QFileMultiSaveReq;
import com.tencent.mobileqq.filemanager.multisave.QFileSaveReqUiCallback;
import com.tencent.qphone.base.util.QLog;

class MultiRichMediaSaveManager$9
  implements QFileSaveReqUiCallback
{
  MultiRichMediaSaveManager$9(MultiRichMediaSaveManager paramMultiRichMediaSaveManager, String paramString, FileSaveReq paramFileSaveReq) {}
  
  public void a(int paramInt)
  {
    Object localObject = this.b;
    if ((localObject != null) && (((FileSaveReq)localObject).d != null))
    {
      localObject = this.b.d.b();
      FileSaveResult localFileSaveResult = this.c.a((String)localObject);
      if ((localFileSaveResult != null) && (!localFileSaveResult.a))
      {
        localFileSaveResult.e = paramInt;
        this.c.a((String)localObject, localFileSaveResult);
        MultiRichMediaSaveManager.a(this.c, localFileSaveResult, paramInt);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("downloadFile key = ");
      localStringBuilder.append(this.a);
      localStringBuilder.append(", result = ");
      localStringBuilder.append(paramBoolean);
      QLog.i("MultiRichMediaSaveManager", 2, localStringBuilder.toString());
    }
    MultiRichMediaSaveManager.a(this.c, this.b, paramBoolean);
  }
  
  public void b(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.save.MultiRichMediaSaveManager.9
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.multimsg.save;

import com.tencent.mobileqq.filemanager.multisave.QFileMultiSaveReq;
import com.tencent.mobileqq.filemanager.multisave.QFileSaveReqUiCallback;

class MultiRichMediaSaveManager$5
  implements QFileSaveReqUiCallback
{
  MultiRichMediaSaveManager$5(MultiRichMediaSaveManager paramMultiRichMediaSaveManager, FileSaveReq paramFileSaveReq) {}
  
  public void a(int paramInt)
  {
    Object localObject = this.a;
    if ((localObject != null) && (((FileSaveReq)localObject).d != null))
    {
      localObject = this.a.d.b();
      FileSaveResult localFileSaveResult = this.b.a((String)localObject);
      if ((localFileSaveResult != null) && (!localFileSaveResult.a))
      {
        localFileSaveResult.e = paramInt;
        this.b.a((String)localObject, localFileSaveResult);
        MultiRichMediaSaveManager.a(this.b, localFileSaveResult, paramInt);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    MultiRichMediaSaveManager.a(this.b, this.a, paramBoolean);
  }
  
  public void b(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.save.MultiRichMediaSaveManager.5
 * JD-Core Version:    0.7.0.1
 */
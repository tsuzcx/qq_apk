package com.tencent.mobileqq.multimsg.save;

import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.VideoDownCallback;
import com.tencent.qphone.base.util.QLog;

class MultiRichMediaSaveManager$8
  implements VideoDownCallback
{
  MultiRichMediaSaveManager$8(MultiRichMediaSaveManager paramMultiRichMediaSaveManager, FileSaveReq paramFileSaveReq, String paramString) {}
  
  public void a(int paramInt)
  {
    if ((this.a.c != null) && (this.a.c.j != null) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("downloadVideo onComplete, key = ");
      localStringBuilder.append(this.b);
      localStringBuilder.append(", result = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" , uniseq = ");
      localStringBuilder.append(this.a.c.j.uniseq);
      QLog.d("MultiRichMediaSaveManager", 2, localStringBuilder.toString());
    }
    this.c.a(this.a, paramInt, 0, "");
  }
  
  public void b(int paramInt)
  {
    Object localObject;
    if ((this.a.c != null) && (this.a.c.j != null) && (QLog.isColorLevel()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("downloadVideo onProgress , key = ");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append(", pos = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" , uniseq = ");
      ((StringBuilder)localObject).append(this.a.c.j.uniseq);
      QLog.d("MultiRichMediaSaveManager", 2, ((StringBuilder)localObject).toString());
    }
    if (this.a.c != null)
    {
      localObject = this.c.a(this.a.c.e);
      FileSaveResult localFileSaveResult = this.c.a((String)localObject);
      if ((localFileSaveResult != null) && (!localFileSaveResult.a))
      {
        localFileSaveResult.e = paramInt;
        this.c.a((String)localObject, localFileSaveResult);
        MultiRichMediaSaveManager.a(this.c, localFileSaveResult, localFileSaveResult.e);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.save.MultiRichMediaSaveManager.8
 * JD-Core Version:    0.7.0.1
 */
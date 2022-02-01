package com.tencent.mobileqq.multimsg.save;

import com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.SVUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.VideoDownCallback;
import com.tencent.qphone.base.util.QLog;

class MultiRichMediaSaveManager$12
  implements VideoDownCallback
{
  MultiRichMediaSaveManager$12(MultiRichMediaSaveManager paramMultiRichMediaSaveManager, long paramLong, FileSaveReq paramFileSaveReq, String paramString, int paramInt1, int paramInt2) {}
  
  public void a(int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("downloadVideo id = ");
      ((StringBuilder)localObject).append(this.a);
      ((StringBuilder)localObject).append(", result =");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("MultiRichMediaSaveManager", 2, ((StringBuilder)localObject).toString());
    }
    if (this.b.c.j != null)
    {
      localObject = SVUtils.a(this.b.c.j, "mp4");
      FileSaveResult localFileSaveResult = this.f.a(this.c);
      if ((localFileSaveResult != null) && (!localFileSaveResult.a))
      {
        localFileSaveResult.b = paramInt;
        localFileSaveResult.g.a = 3;
        if (paramInt == 0) {
          paramInt = 1;
        } else {
          paramInt = 2;
        }
        localFileSaveResult.h = new PeakDownloadCallBackInfo(this.a, this.d, this.e, paramInt, (String)localObject, false);
        this.f.a(this.c, localFileSaveResult);
        this.f.a(localFileSaveResult.g, 0, 0, "");
      }
    }
  }
  
  public void b(int paramInt)
  {
    if ((this.f.a != null) && (this.b.c.j != null)) {
      this.f.a.a(this.a, this.d, this.e, paramInt, this.b.c.j.videoFileSize, true);
    }
    if (this.b.c != null)
    {
      FileSaveResult localFileSaveResult = this.f.a(this.c);
      if ((localFileSaveResult != null) && (!localFileSaveResult.a))
      {
        localFileSaveResult.e = paramInt;
        this.f.a(this.c, localFileSaveResult);
        if (MultiRichMediaSaveManager.c(this.f))
        {
          MultiRichMediaSaveManager.a(this.f, localFileSaveResult, localFileSaveResult.e);
          return;
        }
        MultiRichMediaSaveManager.b(this.f, localFileSaveResult, paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.save.MultiRichMediaSaveManager.12
 * JD-Core Version:    0.7.0.1
 */
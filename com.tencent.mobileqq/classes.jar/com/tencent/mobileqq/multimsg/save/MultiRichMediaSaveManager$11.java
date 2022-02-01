package com.tencent.mobileqq.multimsg.save;

import com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack;
import com.tencent.mobileqq.pic.PicInfoInterface.ErrInfo;
import com.tencent.mobileqq.pic.PicResult;
import com.tencent.mobileqq.pic.UiCallBack.DownAdapter;
import com.tencent.qphone.base.util.QLog;

class MultiRichMediaSaveManager$11
  extends UiCallBack.DownAdapter
{
  MultiRichMediaSaveManager$11(MultiRichMediaSaveManager paramMultiRichMediaSaveManager, long paramLong1, int paramInt1, int paramInt2, long paramLong2, String paramString1, String paramString2) {}
  
  public void a(int paramInt, PicResult paramPicResult)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("downloadRawImage id = ");
      ((StringBuilder)localObject).append(this.a);
      ((StringBuilder)localObject).append(", result = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("MultiRichMediaSaveManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.g.a(this.e);
    if ((localObject != null) && (!((FileSaveResult)localObject).a))
    {
      ((FileSaveResult)localObject).b = paramInt;
      if (paramInt == 0) {
        paramInt = 1;
      } else {
        paramInt = 2;
      }
      ((FileSaveResult)localObject).g.a = 1;
      boolean bool;
      if (paramPicResult != null)
      {
        ((FileSaveResult)localObject).b = paramPicResult.a;
        if ((paramPicResult.a != 0) && (paramPicResult.b != null))
        {
          ((FileSaveResult)localObject).c = paramPicResult.b.c;
          ((FileSaveResult)localObject).d = paramPicResult.b.b;
        }
        if (paramPicResult.a == 0) {
          paramInt = 1;
        } else {
          paramInt = 2;
        }
        bool = paramPicResult.e;
      }
      else
      {
        bool = false;
      }
      ((FileSaveResult)localObject).h = new PeakDownloadCallBackInfo(this.a, this.b, this.c, paramInt, this.f, bool);
      this.g.a(this.e, (FileSaveResult)localObject);
      MultiRichMediaSaveManager.a(this.g, ((FileSaveResult)localObject).g, 0, ((FileSaveResult)localObject).c, ((FileSaveResult)localObject).d);
    }
  }
  
  public void a_(int paramInt, boolean paramBoolean)
  {
    if (this.g.a != null) {
      this.g.a.a(this.a, this.b, this.c, paramInt, this.d, paramBoolean);
    }
    FileSaveResult localFileSaveResult = this.g.a(this.e);
    if ((localFileSaveResult != null) && (!localFileSaveResult.a))
    {
      if (MultiRichMediaSaveManager.c(this.g))
      {
        MultiRichMediaSaveManager.a(this.g, localFileSaveResult.g, paramInt);
        return;
      }
      paramInt /= 100;
      localFileSaveResult.e = paramInt;
      this.g.a(this.e, localFileSaveResult);
      MultiRichMediaSaveManager.b(this.g, localFileSaveResult, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.save.MultiRichMediaSaveManager.11
 * JD-Core Version:    0.7.0.1
 */
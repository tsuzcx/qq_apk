package com.tencent.mobileqq.multimsg.save;

import com.tencent.mobileqq.pic.PicInfoInterface.ErrInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoResult;
import com.tencent.mobileqq.shortvideo.UiCallBack.DownAdapter;
import com.tencent.qphone.base.util.QLog;

class MultiRichMediaSaveManager$7
  extends UiCallBack.DownAdapter
{
  MultiRichMediaSaveManager$7(MultiRichMediaSaveManager paramMultiRichMediaSaveManager, String paramString, FileSaveReq paramFileSaveReq) {}
  
  public void a(int paramInt)
  {
    if (this.b.c != null)
    {
      String str = this.c.a(this.b.c.e);
      FileSaveResult localFileSaveResult = this.c.a(str);
      if ((localFileSaveResult != null) && (!localFileSaveResult.a))
      {
        paramInt /= 100;
        localFileSaveResult.e = paramInt;
        this.c.a(str, localFileSaveResult);
        MultiRichMediaSaveManager.a(this.c, localFileSaveResult, paramInt);
      }
    }
  }
  
  public void a(int paramInt, ShortVideoResult paramShortVideoResult)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("downloadShortVideo key = ");
      localStringBuilder.append(this.a);
      localStringBuilder.append(", result = ");
      localStringBuilder.append(paramInt);
      QLog.i("MultiRichMediaSaveManager", 2, localStringBuilder.toString());
    }
    int i = 0;
    if ((paramShortVideoResult != null) && (paramShortVideoResult.b != null))
    {
      i = paramShortVideoResult.b.c;
      paramShortVideoResult = paramShortVideoResult.b.b;
    }
    else
    {
      paramShortVideoResult = "";
    }
    this.c.a(this.b, paramInt, i, paramShortVideoResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.save.MultiRichMediaSaveManager.7
 * JD-Core Version:    0.7.0.1
 */
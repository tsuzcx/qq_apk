package com.tencent.mobileqq.multimsg.save;

import com.tencent.mobileqq.pic.PicInfoInterface.ErrInfo;
import com.tencent.mobileqq.pic.PicResult;
import com.tencent.mobileqq.pic.UiCallBack.DownAdapter;
import com.tencent.qphone.base.util.QLog;

class MultiRichMediaSaveManager$6
  extends UiCallBack.DownAdapter
{
  MultiRichMediaSaveManager$6(MultiRichMediaSaveManager paramMultiRichMediaSaveManager, String paramString, FileSaveReq paramFileSaveReq) {}
  
  public void a(int paramInt, PicResult paramPicResult)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("downloadPic key = ");
      localStringBuilder.append(this.a);
      localStringBuilder.append(", result = ");
      localStringBuilder.append(paramInt);
      QLog.i("MultiRichMediaSaveManager", 2, localStringBuilder.toString());
    }
    int i = 0;
    if ((paramPicResult != null) && (paramPicResult.b != null))
    {
      i = paramPicResult.b.c;
      paramPicResult = paramPicResult.b.b;
    }
    else
    {
      paramPicResult = "";
    }
    MultiRichMediaSaveManager.a(this.c, this.b, paramInt, i, paramPicResult);
  }
  
  public void a_(int paramInt, boolean paramBoolean)
  {
    MultiRichMediaSaveManager.a(this.c, this.b, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.save.MultiRichMediaSaveManager.6
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.multimsg.save;

import com.tencent.mobileqq.pic.DownCallBack;
import com.tencent.mobileqq.pic.DownCallBack.DownResult;
import com.tencent.mobileqq.pic.PicInfoInterface.ErrInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.qphone.base.util.QLog;

class MultiRichMediaSaveManager$4
  implements DownCallBack
{
  MultiRichMediaSaveManager$4(MultiRichMediaSaveManager paramMultiRichMediaSaveManager, FileSaveReq paramFileSaveReq) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.a.c != null)
    {
      String str = this.b.a(this.a.c.e);
      FileSaveResult localFileSaveResult = this.b.a(str);
      if ((localFileSaveResult != null) && (!localFileSaveResult.a))
      {
        paramInt /= 100;
        localFileSaveResult.e = paramInt;
        this.b.a(str, localFileSaveResult);
        MultiRichMediaSaveManager.a(this.b, localFileSaveResult, paramInt);
      }
    }
  }
  
  public void a(DownCallBack.DownResult paramDownResult)
  {
    int j = 0;
    String str = "";
    int i;
    if (paramDownResult != null)
    {
      int k = paramDownResult.a;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isFilePreDownload shortVideoReq result = ");
        localStringBuilder.append(k);
        QLog.d("MultiRichMediaSaveManager", 2, localStringBuilder.toString());
      }
      i = k;
      if (paramDownResult.d != null)
      {
        j = paramDownResult.d.c;
        str = paramDownResult.d.b;
        i = k;
      }
    }
    else
    {
      i = 0;
    }
    this.b.a(this.a, i, j, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.save.MultiRichMediaSaveManager.4
 * JD-Core Version:    0.7.0.1
 */
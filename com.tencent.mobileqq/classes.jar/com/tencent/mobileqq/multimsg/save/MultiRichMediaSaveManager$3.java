package com.tencent.mobileqq.multimsg.save;

import com.tencent.mobileqq.pic.DownCallBack;
import com.tencent.mobileqq.pic.DownCallBack.DownResult;
import com.tencent.mobileqq.pic.PicInfoInterface.ErrInfo;
import com.tencent.qphone.base.util.QLog;

class MultiRichMediaSaveManager$3
  implements DownCallBack
{
  MultiRichMediaSaveManager$3(MultiRichMediaSaveManager paramMultiRichMediaSaveManager, FileSaveReq paramFileSaveReq) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    MultiRichMediaSaveManager.a(this.b, this.a, paramInt);
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
        localStringBuilder.append("isFilePreDownload picReq result = ");
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
    MultiRichMediaSaveManager.a(this.b, this.a, i, j, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.save.MultiRichMediaSaveManager.3
 * JD-Core Version:    0.7.0.1
 */
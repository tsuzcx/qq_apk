package com.tencent.mobileqq.emoticonview;

import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.RejectedExecutionException;

class BigEmotionDownloadedAdapter$8
  implements URLDrawable.URLDrawableListener
{
  BigEmotionDownloadedAdapter$8(BigEmotionDownloadedAdapter paramBigEmotionDownloadedAdapter) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if ((paramThrowable instanceof RejectedExecutionException))
    {
      if (QLog.isColorLevel())
      {
        paramThrowable = new StringBuilder();
        paramThrowable.append("arg0.getConstantState() = ");
        paramThrowable.append(paramURLDrawable.getConstantState());
        QLog.i("BigEmotionDownloadedAdapter", 2, paramThrowable.toString());
      }
    }
    else if (paramURLDrawable != null)
    {
      paramThrowable = paramURLDrawable.getFileInLocal();
      if ((paramThrowable != null) && (paramThrowable.exists())) {
        paramThrowable.delete();
      }
      paramThrowable = paramURLDrawable.getTag();
      if ((paramThrowable instanceof Integer))
      {
        int i = ((Integer)paramThrowable).intValue();
        if (i < 3)
        {
          i += 1;
          paramURLDrawable.setTag(Integer.valueOf(i));
          paramURLDrawable.restartDownload();
          if (QLog.isColorLevel())
          {
            paramURLDrawable = new StringBuilder();
            paramURLDrawable.append("download recomment comic pic , try count = ");
            paramURLDrawable.append(i);
            QLog.i("BigEmotionDownloadedAdapter", 2, paramURLDrawable.toString());
          }
        }
      }
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.BigEmotionDownloadedAdapter.8
 * JD-Core Version:    0.7.0.1
 */
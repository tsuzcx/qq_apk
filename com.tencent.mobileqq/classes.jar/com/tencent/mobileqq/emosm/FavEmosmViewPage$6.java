package com.tencent.mobileqq.emosm;

import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.qphone.base.util.QLog;

class FavEmosmViewPage$6
  implements URLDrawableDownListener
{
  FavEmosmViewPage$6(FavEmosmViewPage paramFavEmosmViewPage, EmoticonInfo paramEmoticonInfo, FavEmosmViewPage.Holder paramHolder) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    paramView = new StringBuilder();
    paramView.append("onLoadFailed: ");
    paramView.append(this.a.toString());
    QLog.e("FavEmosmViewPage", 1, paramView.toString());
    FavEmosmViewPage.a(this.c, this.b.a, this.b);
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    paramView = new StringBuilder();
    paramView.append("onLoadFailed: ");
    paramView.append(this.a.toString());
    QLog.e("FavEmosmViewPage", 1, paramView.toString());
    FavEmosmViewPage.a(this.c, this.b.a, this.b);
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException)
  {
    paramView = new StringBuilder();
    paramView.append("onLoadInterrupted: ");
    paramView.append(this.a.toString());
    QLog.e("FavEmosmViewPage", 1, paramView.toString());
    FavEmosmViewPage.a(this.c, this.b.a, this.b);
  }
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("onLoadProgressed: ");
      paramView.append(this.a.toString());
      QLog.i("FavEmosmViewPage", 2, paramView.toString());
    }
    FavEmosmViewPage.a(this.c, this.b.a, this.b);
  }
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("onLoadSuccess: ");
      paramView.append(this.a.toString());
      QLog.i("FavEmosmViewPage", 2, paramView.toString());
    }
    FavEmosmViewPage.a(this.c, this.b.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.FavEmosmViewPage.6
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.vip;

import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

class GameCardManagerImpl$1
  implements URLDrawable.URLDrawableListener
{
  GameCardManagerImpl$1(GameCardManagerImpl paramGameCardManagerImpl, IGameCardManager.OnResultCallBack paramOnResultCallBack) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    this.a.c(paramURLDrawable);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    this.a.b(paramURLDrawable);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    this.a.a(paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vip.GameCardManagerImpl.1
 * JD-Core Version:    0.7.0.1
 */
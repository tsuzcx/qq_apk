package com.tencent.mobileqq.emosm.favroaming;

import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.pic.UpCallBack;

public abstract interface IEmoBatchAddedCallback
  extends UpCallBack
{
  public abstract int a();
  
  public abstract IEmoBatchAddedHandler a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(CustomEmotionData paramCustomEmotionData);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.IEmoBatchAddedCallback
 * JD-Core Version:    0.7.0.1
 */
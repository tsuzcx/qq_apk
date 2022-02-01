package com.tencent.mobileqq.hotchat.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotchat.anim.HeartAnimator;
import com.tencent.mobileqq.hotchat.anim.HeartAnimator.Config;

public abstract class BaseFloatViewBuilder
{
  protected Bitmap a;
  protected int b;
  protected Context c;
  protected HeartAnimator d;
  
  public BaseFloatViewBuilder(Context paramContext, int paramInt)
  {
    this.c = paramContext;
    this.b = paramInt;
  }
  
  public BaseFloatViewBuilder(Context paramContext, int paramInt, HeartAnimator paramHeartAnimator)
  {
    this.c = paramContext;
    this.b = paramInt;
    this.d = paramHeartAnimator;
  }
  
  public Bitmap a()
  {
    HeartAnimator localHeartAnimator = this.d;
    if (localHeartAnimator != null) {
      a(localHeartAnimator.b());
    }
    return null;
  }
  
  public void a(HeartAnimator.Config paramConfig)
  {
    paramConfig.p = 1.0F;
  }
  
  public Drawable[] a(QQAppInterface paramQQAppInterface)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.ui.BaseFloatViewBuilder
 * JD-Core Version:    0.7.0.1
 */
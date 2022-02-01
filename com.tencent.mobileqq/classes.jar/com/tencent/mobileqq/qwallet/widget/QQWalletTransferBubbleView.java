package com.tencent.mobileqq.qwallet.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class QQWalletTransferBubbleView
  extends RelativeLayout
{
  int a;
  boolean b;
  int c = 255;
  LightingColorFilter d;
  
  public QQWalletTransferBubbleView(Context paramContext)
  {
    super(paramContext);
    setWillNotDraw(false);
  }
  
  public QQWalletTransferBubbleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setWillNotDraw(false);
  }
  
  public QQWalletTransferBubbleView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setWillNotDraw(false);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.d == null) {
      return;
    }
    Drawable localDrawable = getResources().getDrawable(this.a);
    localDrawable.setBounds(0, 0, getWidth(), getHeight());
    localDrawable.setColorFilter(this.d);
    localDrawable.setAlpha(this.c);
    if (this.b)
    {
      localDrawable.draw(paramCanvas);
      return;
    }
    paramCanvas.save();
    paramCanvas.scale(-1.0F, 1.0F, getWidth() / 2, getHeight() / 2);
    localDrawable.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  public void setBubbleBackground(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.a = paramInt1;
    this.b = paramBoolean;
    this.d = new LightingColorFilter(Color.argb(255, 0, 0, 0), paramInt2);
    this.c = 255;
  }
  
  public void setBubbleNightBackground(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.a = paramInt1;
    this.b = paramBoolean;
    this.d = new LightingColorFilter(Color.argb(255, 0, 0, 0), paramInt2);
    this.c = 178;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.widget.QQWalletTransferBubbleView
 * JD-Core Version:    0.7.0.1
 */
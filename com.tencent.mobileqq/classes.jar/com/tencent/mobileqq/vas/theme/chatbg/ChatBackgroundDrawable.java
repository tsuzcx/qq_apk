package com.tencent.mobileqq.vas.theme.chatbg;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.qphone.base.util.QLog;

public class ChatBackgroundDrawable
  extends BitmapDrawable
{
  public int a;
  private final Paint b = new Paint(2);
  private Bitmap c = null;
  private Rect d = new Rect();
  
  public ChatBackgroundDrawable(Resources paramResources, Bitmap paramBitmap)
  {
    super(paramResources, paramBitmap);
    this.c = paramBitmap;
  }
  
  protected Rect a(Rect paramRect)
  {
    if (getBitmap() == null) {
      return this.d;
    }
    int i = getBitmap().getHeight();
    int j = getBitmap().getWidth();
    if (paramRect == null) {
      return new Rect(0, 0, j, i);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dstRect = ");
    localStringBuilder.append(paramRect);
    QLog.d("chatbg", 1, localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("img width = ");
    localStringBuilder.append(j);
    localStringBuilder.append(" img height = ");
    localStringBuilder.append(i);
    QLog.d("chatbg", 1, localStringBuilder.toString());
    if (this.a < paramRect.height()) {
      this.a = paramRect.height();
    }
    int k;
    double d1;
    if (this.a / paramRect.width() >= i / j)
    {
      int m = paramRect.width();
      k = this.a;
      m = m * i / k;
      d1 = j - m;
      Double.isNaN(d1);
      j = (int)(d1 * 0.5D);
      if (k > paramRect.height()) {
        i = getBitmap().getHeight() * paramRect.height() / this.a;
      }
      paramRect = new Rect(j, 0, m + j, i);
    }
    else
    {
      k = paramRect.height() * j / paramRect.width();
      d1 = i - this.a * j / paramRect.width();
      Double.isNaN(d1);
      i = (int)(d1 * 0.5D);
      paramRect = new Rect(0, i, j, k + i);
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(" result = ");
    localStringBuilder.append(paramRect);
    localStringBuilder.append(" chatWindowHeight ");
    localStringBuilder.append(this.a);
    QLog.d("chatbg", 1, localStringBuilder.toString());
    return paramRect;
  }
  
  public void draw(Canvas paramCanvas)
  {
    Object localObject = this.c;
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
    {
      localObject = getBounds();
      paramCanvas.drawBitmap(this.c, this.d, (Rect)localObject, this.b);
    }
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    this.d = a(getBounds());
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.theme.chatbg.ChatBackgroundDrawable
 * JD-Core Version:    0.7.0.1
 */
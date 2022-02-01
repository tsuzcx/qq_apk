package com.tencent.mobileqq.emoticonview;

import afur;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import arwh;

public class BigEmotionDownloadedAdapter$1
  implements Runnable
{
  public BigEmotionDownloadedAdapter$1(arwh paramarwh, Context paramContext) {}
  
  public void run()
  {
    this.this$0.a = new ColorDrawable(Color.parseColor("#fafafa"));
    Bitmap localBitmap = Bitmap.createBitmap(afur.a(44.0F, this.a.getResources()), afur.a(44.0F, this.a.getResources()), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    Rect localRect = new Rect(0, 0, localBitmap.getWidth(), localBitmap.getHeight());
    RectF localRectF = new RectF(new Rect(0, 0, localBitmap.getWidth(), localBitmap.getHeight()));
    localPaint.setAntiAlias(true);
    localCanvas.drawARGB(0, 0, 0, 0);
    localPaint.setColor(-16777216);
    localCanvas.drawRoundRect(localRectF, 4.0F, 4.0F, localPaint);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    localCanvas.drawBitmap(localBitmap, new Rect(0, 0, localBitmap.getWidth(), localBitmap.getHeight()), localRect, localPaint);
    this.this$0.a.draw(localCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.BigEmotionDownloadedAdapter.1
 * JD-Core Version:    0.7.0.1
 */
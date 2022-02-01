package com.tencent.mobileqq.lyric.data;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import java.util.ArrayList;

public class SentenceUI
{
  public final String a;
  public final int b;
  public final int c;
  public final int d;
  public final ArrayList<Character> e;
  public SentenceAttachInfo f = new SentenceAttachInfo();
  public SentenceAttachInfo g = new SentenceAttachInfo();
  private final int h;
  
  public SentenceUI(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, ArrayList<Character> paramArrayList)
  {
    this.b = paramInt1;
    this.h = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.a = paramString;
    this.e = paramArrayList;
  }
  
  public SentenceUI(String paramString, int paramInt1, int paramInt2, ArrayList<Character> paramArrayList)
  {
    this.b = paramInt1;
    this.h = paramInt2;
    this.c = 0;
    this.d = 0;
    this.a = paramString;
    this.e = paramArrayList;
  }
  
  public long a()
  {
    ArrayList localArrayList = this.e;
    if ((localArrayList != null) && (localArrayList.size() > 0)) {
      return ((Character)this.e.get(0)).a;
    }
    return 0L;
  }
  
  public void a(Canvas paramCanvas, int paramInt1, int paramInt2, Paint paramPaint1, Paint paramPaint2)
  {
    a(paramCanvas, paramInt1, paramInt2, paramPaint1, paramPaint2, null, null, 1);
  }
  
  public void a(Canvas paramCanvas, int paramInt1, int paramInt2, Paint paramPaint1, Paint paramPaint2, Bitmap paramBitmap1, Bitmap paramBitmap2, int paramInt3)
  {
    paramInt1 += this.b;
    paramBitmap1 = this.f;
    if ((paramBitmap1 != null) && (paramBitmap1.a != null) && (!this.f.a.isRecycled()))
    {
      paramBitmap1 = new Rect(paramInt1 - this.f.d - this.f.a.getWidth(), (int)(paramInt2 - paramPaint1.getTextSize()), paramInt1 - this.f.d, (int)(this.f.a.getHeight() + paramInt2 - paramPaint1.getTextSize()));
      paramCanvas.drawBitmap(this.f.a, null, paramBitmap1, null);
    }
    paramBitmap1 = this.a;
    float f1 = paramInt1 - paramInt3;
    float f4 = paramInt2 - paramInt3;
    paramCanvas.drawText(paramBitmap1, f1, f4, paramPaint2);
    paramBitmap1 = this.a;
    float f2 = paramInt1;
    paramCanvas.drawText(paramBitmap1, f2, f4, paramPaint2);
    paramBitmap1 = this.a;
    float f3 = paramInt1 + paramInt3;
    paramCanvas.drawText(paramBitmap1, f3, f4, paramPaint2);
    paramBitmap1 = this.a;
    f4 = paramInt2;
    paramCanvas.drawText(paramBitmap1, f3, f4, paramPaint2);
    paramBitmap1 = this.a;
    float f5 = paramInt2 + paramInt3;
    paramCanvas.drawText(paramBitmap1, f3, f5, paramPaint2);
    paramCanvas.drawText(this.a, f2, f5, paramPaint2);
    paramCanvas.drawText(this.a, f1, f5, paramPaint2);
    paramCanvas.drawText(this.a, f1, f4, paramPaint2);
    paramCanvas.drawText(this.a, f2, f4, paramPaint1);
  }
  
  public void a(Canvas paramCanvas, int paramInt1, int paramInt2, Paint paramPaint1, Paint paramPaint2, Paint paramPaint3, int paramInt3, float paramFloat1, float paramFloat2, int[] paramArrayOfInt, float[] paramArrayOfFloat)
  {
    int i = this.h;
    paramFloat2 += i;
    float f1 = paramInt2;
    paramFloat1 = paramFloat2 + paramFloat1;
    paramPaint3.setShader(new LinearGradient(paramFloat2, f1, paramFloat1, f1, paramArrayOfInt, paramArrayOfFloat, Shader.TileMode.CLAMP));
    if (paramInt3 > 0)
    {
      paramArrayOfInt = (Character)this.e.get(paramInt3 - 1);
      paramCanvas.drawText(this.a.substring(0, paramArrayOfInt.d), paramInt1 + i, f1, paramPaint2);
    }
    paramPaint2 = (Character)this.e.get(paramInt3);
    if (paramInt3 == this.e.size() - 1) {
      paramPaint2 = this.a.substring(paramPaint2.c, this.a.length());
    } else {
      paramPaint2 = this.a.substring(paramPaint2.c, paramPaint2.d);
    }
    paramCanvas.drawText(paramPaint2, paramFloat2, f1, paramPaint3);
    if (paramInt3 < this.e.size() - 1)
    {
      paramPaint2 = (Character)this.e.get(paramInt3 + 1);
      paramCanvas.drawText(this.a.substring(paramPaint2.c, this.a.length()), paramFloat1, f1, paramPaint1);
    }
  }
  
  public void a(Canvas paramCanvas, int paramInt1, int paramInt2, Paint paramPaint, boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = this.h;
    } else {
      i = this.b;
    }
    paramCanvas.drawText(this.a, paramInt1 + i, paramInt2, paramPaint);
  }
  
  public long b()
  {
    Object localObject = this.e;
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = this.e;
      localObject = (Character)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
      return ((Character)localObject).a + ((Character)localObject).b;
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.lyric.data.SentenceUI
 * JD-Core Version:    0.7.0.1
 */
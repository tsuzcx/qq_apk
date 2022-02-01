package com.tencent.mobileqq.wink.editor.music.lyric.data;

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
  
  private void a(Canvas paramCanvas, int paramInt1, int paramInt2, Paint paramPaint)
  {
    paramInt1 += this.b;
    SentenceAttachInfo localSentenceAttachInfo = this.f;
    if ((localSentenceAttachInfo != null) && (localSentenceAttachInfo.a != null) && (!this.f.a.isRecycled()))
    {
      paramPaint = new Rect(paramInt1 - this.f.d - this.f.a.getWidth(), (int)(paramInt2 - paramPaint.getTextSize() + 2.0F), paramInt1 - this.f.d, (int)(paramInt2 + this.f.a.getHeight() - paramPaint.getTextSize() + 2.0F));
      paramCanvas.drawBitmap(this.f.a, (Rect)null, paramPaint, (Paint)null);
    }
  }
  
  public long a()
  {
    ArrayList localArrayList = this.e;
    if ((localArrayList != null) && (localArrayList.size() > 0)) {
      return ((Character)this.e.get(0)).a;
    }
    return 0L;
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
  
  public void a(Canvas paramCanvas, int paramInt1, int paramInt2, Paint paramPaint1, Paint paramPaint2, boolean paramBoolean)
  {
    a(paramCanvas, paramInt1, paramInt2, paramPaint1);
    if (paramBoolean) {
      a(paramCanvas, paramInt1, paramInt2, paramPaint2, false);
    }
    b(paramCanvas, paramInt1, paramInt2, paramPaint1, false);
  }
  
  public void a(Canvas paramCanvas, int paramInt1, int paramInt2, Paint paramPaint, boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = this.h;
    } else {
      i = this.b;
    }
    paramInt1 += i;
    String str = this.a;
    float f1 = paramInt1 - 1;
    float f4 = paramInt2 - 1;
    paramCanvas.drawText(str, f1, f4, paramPaint);
    str = this.a;
    float f2 = paramInt1;
    paramCanvas.drawText(str, f2, f4, paramPaint);
    str = this.a;
    float f3 = paramInt1 + 1;
    paramCanvas.drawText(str, f3, f4, paramPaint);
    str = this.a;
    f4 = paramInt2;
    paramCanvas.drawText(str, f3, f4, paramPaint);
    str = this.a;
    float f5 = paramInt2 + 1;
    paramCanvas.drawText(str, f3, f5, paramPaint);
    paramCanvas.drawText(this.a, f2, f5, paramPaint);
    paramCanvas.drawText(this.a, f1, f5, paramPaint);
    paramCanvas.drawText(this.a, f1, f4, paramPaint);
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
  
  public void b(Canvas paramCanvas, int paramInt1, int paramInt2, Paint paramPaint, boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = this.h;
    } else {
      i = this.b;
    }
    paramCanvas.drawText(this.a, paramInt1 + i, paramInt2, paramPaint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.lyric.data.SentenceUI
 * JD-Core Version:    0.7.0.1
 */
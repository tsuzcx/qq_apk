package com.tencent.mobileqq.surfaceviewaction.gl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;

public class Label
  extends Sprite
{
  private Paint E = new Paint();
  private String s = "";
  private int t = 20;
  private int u = -1;
  
  public Label(SpriteGLView paramSpriteGLView, Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    this.E.setAntiAlias(true);
    e(paramInt1);
    f(paramInt2);
    a(paramSpriteGLView, paramString);
  }
  
  public void a(SpriteGLView paramSpriteGLView, String paramString)
  {
    if (paramString.equals(this.s)) {
      return;
    }
    this.s = paramString;
    paramString = Bitmap.createBitmap((int)this.E.measureText(paramString), this.t, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(paramString);
    localCanvas.drawColor(-16777216, PorterDuff.Mode.CLEAR);
    localCanvas.drawText(this.s, 0.0F, this.t * 0.8F, this.E);
    if (this.w != null) {
      this.w.c();
    }
    this.w = new Texture(paramSpriteGLView, paramString);
    m();
    l();
  }
  
  public void e(int paramInt)
  {
    this.u = paramInt;
    this.E.setColor(this.u);
  }
  
  public void f(int paramInt)
  {
    this.t = paramInt;
    this.E.setTextSize(this.t);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.Label
 * JD-Core Version:    0.7.0.1
 */
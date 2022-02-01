package com.tencent.smtt.sdk.ui.dialog.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.StateListDrawable;
import android.widget.Button;

public class b
  extends Button
{
  private int a;
  private int b;
  private float c;
  private float d;
  private float e;
  private float f;
  private c g = null;
  private c h = null;
  private c i = null;
  
  public b(Context paramContext, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt)
  {
    super(paramContext);
    this.c = paramFloat1;
    this.d = paramFloat2;
    this.e = paramFloat3;
    this.f = paramFloat4;
    this.a = paramInt;
    this.b = Color.parseColor("#D0D0D0");
    a();
  }
  
  public b(Context paramContext, int paramInt1, int paramInt2)
  {
    this(paramContext, f1, f1, f1, f1, paramInt2);
  }
  
  public void a()
  {
    this.g = new c(this.a, this.c, this.d, this.e, this.f);
    this.g.a(getWidth(), getHeight());
    this.h = new c(0x50000000 | this.a & 0xFFFFFF, this.c, this.d, this.e, this.f);
    this.h.a(getWidth(), getHeight());
    this.i = new c(this.b, this.c, this.d, this.e, this.f);
    this.i.a(getWidth(), getHeight());
    StateListDrawable localStateListDrawable = new StateListDrawable();
    c localc = this.g;
    localStateListDrawable.addState(new int[] { 16842910, -16842919 }, localc);
    localc = this.h;
    localStateListDrawable.addState(new int[] { 16842910, 16842919 }, localc);
    localc = this.i;
    localStateListDrawable.addState(new int[] { -16842910 }, localc);
    setBackgroundDrawable(localStateListDrawable);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    c localc = this.g;
    if (localc != null) {
      localc.a(paramInt3 - paramInt1, paramInt4 - paramInt2);
    }
    localc = this.h;
    if (localc != null) {
      localc.a(paramInt3 - paramInt1, paramInt4 - paramInt2);
    }
    localc = this.i;
    if (localc != null) {
      localc.a(paramInt3 - paramInt1, paramInt4 - paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.smtt.sdk.ui.dialog.widget.b
 * JD-Core Version:    0.7.0.1
 */
package dov.com.qq.im.ae.current;

import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;

public class CircleCaptureStyle
{
  public static final CircleCaptureStyle a;
  public static final CircleCaptureStyle b;
  public static final CircleCaptureStyle c;
  public static final CircleCaptureStyle d;
  public static final CircleCaptureStyle e;
  public static final CircleCaptureStyle f;
  public static final CircleCaptureStyle[] g;
  @DrawableRes
  public final int A;
  @DrawableRes
  public final int B;
  @ColorInt
  public final int C;
  @ColorInt
  public final int D;
  @NonNull
  public final String h;
  @DrawableRes
  public final int i;
  @DrawableRes
  public final int j;
  @DrawableRes
  public final int k;
  @DrawableRes
  public final int l;
  @DrawableRes
  public final int m;
  @DrawableRes
  public final int n;
  @NonNull
  public final float[] o;
  @ColorInt
  public final int p;
  @DrawableRes
  public final int q;
  @ColorInt
  public final int r;
  public final boolean s;
  @DrawableRes
  public final int t;
  @DrawableRes
  public final int u;
  @DrawableRes
  public final int v;
  @DrawableRes
  public final int w;
  @DrawableRes
  public final int x;
  @DrawableRes
  public final int y;
  @DrawableRes
  public final int z;
  
  static
  {
    int i1 = Color.parseColor("#9095A8");
    int i2 = Color.parseColor("#7A7A8D");
    a = new CircleCaptureStyle("1to1_light", 2130837724, 2130837723, 2130837725, 2130837722, 2130837912, 2130837738, new float[] { 0.0F, 1.0F }, i1, 2130837729, -16777216, false, 2130837742, 2130837731, 2130837734, 2130837737, 2130837715, 2130837746, 2130837748, 2130837718, 2130837747, -16777216, i2);
    i1 = Color.parseColor("#E6FFFFFF");
    b = new CircleCaptureStyle("full_light", 2130837727, 2130837728, 2130837725, 2130837726, 2130837913, 2130837739, new float[] { 0.0F, 1.0F }, -1, 2130837730, -1, true, 2130837743, 2130837731, 2130837734, 2130837737, 2130837715, 2130837746, 2130837748, 2130837719, 2130837747, -1, i1);
    i1 = Color.parseColor("#9095A8");
    i2 = Color.parseColor("#7A7A8D");
    c = new CircleCaptureStyle("4to3_no_top_margin_light", 2130837724, 2130837723, 2130837725, 2130837722, 2130837912, 2130837738, new float[] { 0.0F, 1.0F }, i1, 2130837729, -16777216, false, 2130837743, 2130837731, 2130837734, 2130837737, 2130837715, 2130837746, 2130837748, 2130837719, 2130837747, -16777216, i2);
    i1 = Color.parseColor("#9095A8");
    i2 = Color.parseColor("#7A7A8D");
    d = new CircleCaptureStyle("4to3_with_top_margin_light", 2130837724, 2130837723, 2130837725, 2130837722, 2130837912, 2130837738, new float[] { 0.0F, 1.0F }, i1, 2130837729, -16777216, false, 2130837742, 2130837731, 2130837734, 2130837737, 2130837715, 2130837746, 2130837748, 2130837719, 2130837747, -16777216, i2);
    CircleCaptureStyle localCircleCaptureStyle1 = a;
    e = localCircleCaptureStyle1;
    CircleCaptureStyle localCircleCaptureStyle2 = b;
    f = localCircleCaptureStyle2;
    g = new CircleCaptureStyle[] { localCircleCaptureStyle1, localCircleCaptureStyle2, e, f };
  }
  
  private CircleCaptureStyle(@NonNull String paramString, @DrawableRes int paramInt1, @DrawableRes int paramInt2, @DrawableRes int paramInt3, @DrawableRes int paramInt4, @DrawableRes int paramInt5, @DrawableRes int paramInt6, @NonNull float[] paramArrayOfFloat, @ColorInt int paramInt7, @DrawableRes int paramInt8, @ColorInt int paramInt9, boolean paramBoolean, @DrawableRes int paramInt10, @DrawableRes int paramInt11, @DrawableRes int paramInt12, @DrawableRes int paramInt13, @DrawableRes int paramInt14, @DrawableRes int paramInt15, @DrawableRes int paramInt16, @DrawableRes int paramInt17, @DrawableRes int paramInt18, @ColorInt int paramInt19, @ColorInt int paramInt20)
  {
    this.h = paramString;
    this.i = paramInt1;
    this.j = paramInt2;
    this.l = paramInt3;
    this.k = paramInt4;
    this.m = paramInt5;
    this.n = paramInt6;
    this.o = paramArrayOfFloat;
    this.p = paramInt7;
    this.q = paramInt8;
    this.r = paramInt9;
    this.s = paramBoolean;
    this.t = paramInt10;
    this.u = paramInt11;
    this.v = paramInt12;
    this.w = paramInt13;
    this.x = paramInt14;
    this.y = paramInt15;
    this.z = paramInt16;
    this.A = paramInt17;
    this.B = paramInt18;
    this.C = paramInt19;
    this.D = paramInt20;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     dov.com.qq.im.ae.current.CircleCaptureStyle
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.smtt.flexbox;

import com.tencent.mtt.hippy.dom.a.b;
import com.tencent.mtt.hippy.dom.a.d;
import com.tencent.mtt.hippy.dom.a.e;
import com.tencent.mtt.hippy.dom.a.i;
import com.tencent.mtt.hippy.dom.a.j;
import com.tencent.mtt.hippy.dom.a.k;

public class FlexNodeStyle
{
  private long a = 0L;
  private d b = d.b;
  private b c;
  private e d;
  private com.tencent.mtt.hippy.dom.a.a e;
  private com.tencent.mtt.hippy.dom.a.a f;
  private com.tencent.mtt.hippy.dom.a.a g;
  private j h;
  private k i;
  private i j;
  private FlexNodeStyle.a k;
  private float l = 0.0F;
  private float m;
  private float n = 0.0F;
  private float o = 0.0F;
  private float[] p = new float[FlexNodeStyle.b.i.ordinal() + 1];
  private float[] q = new float[FlexNodeStyle.b.i.ordinal() + 1];
  private float[] r = new float[FlexNodeStyle.b.i.ordinal() + 1];
  private float[] s = new float[FlexNodeStyle.b.i.ordinal() + 1];
  private float t = 0.0F;
  private float u = 0.0F;
  private float v;
  private float w;
  private float x;
  private float y;
  
  public FlexNodeStyle(long paramLong)
  {
    long l1 = this.a;
    if (l1 != 0L)
    {
      nativeSetFlexNode(l1, paramLong);
      return;
    }
    throw new IllegalStateException("Failed to allocate native memory");
  }
  
  private native void nativeFlexNodeStyleFree(long paramLong);
  
  private native int nativeFlexNodeStyleGetAlignContent(long paramLong);
  
  private native int nativeFlexNodeStyleGetAlignItems(long paramLong);
  
  private native int nativeFlexNodeStyleGetAlignSelf(long paramLong);
  
  private native float nativeFlexNodeStyleGetAspectRatio(long paramLong);
  
  private native Object nativeFlexNodeStyleGetBorder(long paramLong, int paramInt);
  
  private native int nativeFlexNodeStyleGetDirection(long paramLong);
  
  private native int nativeFlexNodeStyleGetDisplay(long paramLong);
  
  private native float nativeFlexNodeStyleGetFlex(long paramLong);
  
  private native Object nativeFlexNodeStyleGetFlexBasis(long paramLong);
  
  private native int nativeFlexNodeStyleGetFlexDirection(long paramLong);
  
  private native float nativeFlexNodeStyleGetFlexGrow(long paramLong);
  
  private native float nativeFlexNodeStyleGetFlexShrink(long paramLong);
  
  private native int nativeFlexNodeStyleGetFlexWrap(long paramLong);
  
  private native Object nativeFlexNodeStyleGetHeight(long paramLong);
  
  private native int nativeFlexNodeStyleGetJustifyContent(long paramLong);
  
  private native Object nativeFlexNodeStyleGetMargin(long paramLong, int paramInt);
  
  private native Object nativeFlexNodeStyleGetMaxHeight(long paramLong);
  
  private native Object nativeFlexNodeStyleGetMaxWidth(long paramLong);
  
  private native Object nativeFlexNodeStyleGetMinHeight(long paramLong);
  
  private native Object nativeFlexNodeStyleGetMinWidth(long paramLong);
  
  private native int nativeFlexNodeStyleGetOverflow(long paramLong);
  
  private native Object nativeFlexNodeStyleGetPadding(long paramLong, int paramInt);
  
  private native Object nativeFlexNodeStyleGetPosition(long paramLong, int paramInt);
  
  private native int nativeFlexNodeStyleGetPositionType(long paramLong);
  
  private native Object nativeFlexNodeStyleGetWidth(long paramLong);
  
  private native long nativeFlexNodeStyleNew();
  
  private native void nativeFlexNodeStyleSetAlignContent(long paramLong, int paramInt);
  
  private native void nativeFlexNodeStyleSetAlignItems(long paramLong, int paramInt);
  
  private native void nativeFlexNodeStyleSetAlignSelf(long paramLong, int paramInt);
  
  private native void nativeFlexNodeStyleSetAspectRatio(long paramLong, float paramFloat);
  
  private native void nativeFlexNodeStyleSetBorder(long paramLong, int paramInt, float paramFloat);
  
  private native void nativeFlexNodeStyleSetDirection(long paramLong, int paramInt);
  
  private native void nativeFlexNodeStyleSetDisplay(long paramLong, int paramInt);
  
  private native void nativeFlexNodeStyleSetFlex(long paramLong, float paramFloat);
  
  private native void nativeFlexNodeStyleSetFlexBasis(long paramLong, float paramFloat);
  
  private native void nativeFlexNodeStyleSetFlexBasisAuto(long paramLong);
  
  private native void nativeFlexNodeStyleSetFlexBasisPercent(long paramLong, float paramFloat);
  
  private native void nativeFlexNodeStyleSetFlexDirection(long paramLong, int paramInt);
  
  private native void nativeFlexNodeStyleSetFlexGrow(long paramLong, float paramFloat);
  
  private native void nativeFlexNodeStyleSetFlexShrink(long paramLong, float paramFloat);
  
  private native void nativeFlexNodeStyleSetFlexWrap(long paramLong, int paramInt);
  
  private native void nativeFlexNodeStyleSetHeight(long paramLong, float paramFloat);
  
  private native void nativeFlexNodeStyleSetHeightAuto(long paramLong);
  
  private native void nativeFlexNodeStyleSetHeightPercent(long paramLong, float paramFloat);
  
  private native void nativeFlexNodeStyleSetJustifyContent(long paramLong, int paramInt);
  
  private native void nativeFlexNodeStyleSetMargin(long paramLong, int paramInt, float paramFloat);
  
  private native void nativeFlexNodeStyleSetMarginAuto(long paramLong, int paramInt);
  
  private native void nativeFlexNodeStyleSetMarginPercent(long paramLong, int paramInt, float paramFloat);
  
  private native void nativeFlexNodeStyleSetMaxHeight(long paramLong, float paramFloat);
  
  private native void nativeFlexNodeStyleSetMaxHeightPercent(long paramLong, float paramFloat);
  
  private native void nativeFlexNodeStyleSetMaxWidth(long paramLong, float paramFloat);
  
  private native void nativeFlexNodeStyleSetMaxWidthPercent(long paramLong, float paramFloat);
  
  private native void nativeFlexNodeStyleSetMinHeight(long paramLong, float paramFloat);
  
  private native void nativeFlexNodeStyleSetMinHeightPercent(long paramLong, float paramFloat);
  
  private native void nativeFlexNodeStyleSetMinWidth(long paramLong, float paramFloat);
  
  private native void nativeFlexNodeStyleSetMinWidthPercent(long paramLong, float paramFloat);
  
  private native void nativeFlexNodeStyleSetOverflow(long paramLong, int paramInt);
  
  private native void nativeFlexNodeStyleSetPadding(long paramLong, int paramInt, float paramFloat);
  
  private native void nativeFlexNodeStyleSetPaddingPercent(long paramLong, int paramInt, float paramFloat);
  
  private native void nativeFlexNodeStyleSetPosition(long paramLong, int paramInt, float paramFloat);
  
  private native void nativeFlexNodeStyleSetPositionPercent(long paramLong, int paramInt, float paramFloat);
  
  private native void nativeFlexNodeStyleSetPositionType(long paramLong, int paramInt);
  
  private native void nativeFlexNodeStyleSetWidth(long paramLong, float paramFloat);
  
  private native void nativeFlexNodeStyleSetWidthAuto(long paramLong);
  
  private native void nativeFlexNodeStyleSetWidthPercent(long paramLong, float paramFloat);
  
  private native void nativeSetFlexNode(long paramLong1, long paramLong2);
  
  public d a()
  {
    return this.b;
  }
  
  public a a(FlexNodeStyle.b paramb)
  {
    return new a(this.p[paramb.ordinal()], a.a.b);
  }
  
  public void a(float paramFloat)
  {
    this.l = paramFloat;
    nativeFlexNodeStyleSetFlex(this.a, paramFloat);
  }
  
  public void a(com.tencent.mtt.hippy.dom.a.a parama)
  {
    this.e = parama;
    nativeFlexNodeStyleSetAlignItems(this.a, parama.ordinal());
  }
  
  public void a(b paramb)
  {
    this.c = paramb;
    nativeFlexNodeStyleSetFlexDirection(this.a, paramb.ordinal());
  }
  
  public void a(d paramd)
  {
    this.b = paramd;
    nativeFlexNodeStyleSetDirection(this.a, paramd.ordinal());
  }
  
  public void a(e parame)
  {
    int i2 = parame.ordinal();
    this.d = parame;
    int i1 = 3;
    if (i2 != 0)
    {
      if (i2 == 1) {
        break label53;
      }
      if (i2 == 2) {
        break label55;
      }
      if (i2 == 3) {
        break label47;
      }
      if (i2 == 4) {}
    }
    else
    {
      i1 = 1;
      break label55;
    }
    i1 = 7;
    break label55;
    label47:
    i1 = 6;
    break label55;
    label53:
    i1 = 2;
    label55:
    nativeFlexNodeStyleSetJustifyContent(this.a, i1);
  }
  
  public void a(i parami)
  {
    this.j = parami;
    nativeFlexNodeStyleSetOverflow(this.a, parami.ordinal());
  }
  
  public void a(j paramj)
  {
    this.h = paramj;
    nativeFlexNodeStyleSetPositionType(this.a, paramj.ordinal());
  }
  
  public void a(k paramk)
  {
    this.i = paramk;
    nativeFlexNodeStyleSetFlexWrap(this.a, paramk.ordinal());
  }
  
  public void a(FlexNodeStyle.a parama)
  {
    this.k = parama;
    nativeFlexNodeStyleSetDisplay(this.a, parama.ordinal());
  }
  
  public void a(FlexNodeStyle.b paramb, float paramFloat)
  {
    this.p[paramb.ordinal()] = paramFloat;
    nativeFlexNodeStyleSetMargin(this.a, paramb.ordinal(), paramFloat);
  }
  
  public b b()
  {
    return this.c;
  }
  
  public a b(FlexNodeStyle.b paramb)
  {
    return new a(this.q[paramb.ordinal()], a.a.b);
  }
  
  public void b(float paramFloat)
  {
    this.m = paramFloat;
    nativeFlexNodeStyleSetFlexGrow(this.a, paramFloat);
  }
  
  public void b(com.tencent.mtt.hippy.dom.a.a parama)
  {
    this.f = parama;
    nativeFlexNodeStyleSetAlignSelf(this.a, parama.ordinal());
  }
  
  public void b(FlexNodeStyle.b paramb, float paramFloat)
  {
    this.q[paramb.ordinal()] = paramFloat;
    nativeFlexNodeStyleSetPadding(this.a, paramb.ordinal(), paramFloat);
  }
  
  public e c()
  {
    return this.d;
  }
  
  public a c(FlexNodeStyle.b paramb)
  {
    return new a(this.r[paramb.ordinal()], a.a.b);
  }
  
  public void c(float paramFloat)
  {
    this.n = paramFloat;
    nativeFlexNodeStyleSetFlexShrink(this.a, paramFloat);
  }
  
  public void c(com.tencent.mtt.hippy.dom.a.a parama)
  {
    this.g = parama;
    nativeFlexNodeStyleSetAlignContent(this.a, parama.ordinal());
  }
  
  public void c(FlexNodeStyle.b paramb, float paramFloat)
  {
    this.r[paramb.ordinal()] = paramFloat;
    nativeFlexNodeStyleSetBorder(this.a, paramb.ordinal(), paramFloat);
  }
  
  public com.tencent.mtt.hippy.dom.a.a d()
  {
    return this.e;
  }
  
  public a d(FlexNodeStyle.b paramb)
  {
    return new a(this.s[paramb.ordinal()], a.a.b);
  }
  
  public void d(float paramFloat)
  {
    this.o = paramFloat;
    nativeFlexNodeStyleSetFlexBasis(this.a, paramFloat);
  }
  
  public void d(FlexNodeStyle.b paramb, float paramFloat)
  {
    this.s[paramb.ordinal()] = paramFloat;
    nativeFlexNodeStyleSetPosition(this.a, paramb.ordinal(), paramFloat);
  }
  
  public com.tencent.mtt.hippy.dom.a.a e()
  {
    return this.f;
  }
  
  public void e(float paramFloat)
  {
    this.t = paramFloat;
    nativeFlexNodeStyleSetWidth(this.a, paramFloat);
  }
  
  public com.tencent.mtt.hippy.dom.a.a f()
  {
    return this.g;
  }
  
  public void f(float paramFloat)
  {
    this.u = paramFloat;
    nativeFlexNodeStyleSetHeight(this.a, paramFloat);
  }
  
  protected void finalize()
  {
    try
    {
      nativeFlexNodeStyleFree(this.a);
      this.a = 0L;
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public j g()
  {
    return this.h;
  }
  
  public void g(float paramFloat)
  {
    this.v = paramFloat;
    nativeFlexNodeStyleSetMinWidth(this.a, paramFloat);
  }
  
  public k h()
  {
    return this.i;
  }
  
  public void h(float paramFloat)
  {
    this.w = paramFloat;
    nativeFlexNodeStyleSetMinHeight(this.a, paramFloat);
  }
  
  public i i()
  {
    return this.j;
  }
  
  public void i(float paramFloat)
  {
    this.x = paramFloat;
    nativeFlexNodeStyleSetMaxWidth(this.a, paramFloat);
  }
  
  public float j()
  {
    return this.m;
  }
  
  public void j(float paramFloat)
  {
    this.y = paramFloat;
    nativeFlexNodeStyleSetMaxHeight(this.a, paramFloat);
  }
  
  public float k()
  {
    return this.n;
  }
  
  public a l()
  {
    return new a(this.o, a.a.b);
  }
  
  public a m()
  {
    return new a(this.t, a.a.b);
  }
  
  public a n()
  {
    return new a(this.u, a.a.b);
  }
  
  public a o()
  {
    return new a(this.v, a.a.b);
  }
  
  public a p()
  {
    return new a(this.w, a.a.b);
  }
  
  public a q()
  {
    return new a(this.x, a.a.b);
  }
  
  public a r()
  {
    return new a(this.y, a.a.b);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("style: {");
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("flex-direction: ");
    localStringBuilder2.append(b().toString().toLowerCase());
    localStringBuilder2.append(", ");
    localStringBuilder1.append(localStringBuilder2.toString());
    if (j() != 0.0F)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("flex-grow: ");
      localStringBuilder2.append(j());
      localStringBuilder2.append(", ");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    if (l().a() != (0.0F / 0.0F))
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("flex-basis: ");
      localStringBuilder2.append(l().a());
      localStringBuilder2.append(", ");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    if (k() != 0.0F)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("flex-shrink: ");
      localStringBuilder2.append(k());
      localStringBuilder2.append(", ");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    if (c() != e.a)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("justifycontent: ");
      localStringBuilder2.append(c().toString().toLowerCase());
      localStringBuilder2.append(", ");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    if (f() != com.tencent.mtt.hippy.dom.a.a.b)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("aligncontent: ");
      localStringBuilder2.append(f().toString().toLowerCase());
      localStringBuilder2.append(", ");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    if (d() != com.tencent.mtt.hippy.dom.a.a.e)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("alignitems: ");
      localStringBuilder2.append(d().toString().toLowerCase());
      localStringBuilder2.append(", ");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    if (e() != com.tencent.mtt.hippy.dom.a.a.a)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("alignself: ");
      localStringBuilder2.append(e().toString().toLowerCase());
      localStringBuilder2.append(", ");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    if (h() != k.a)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("wrap: ");
      localStringBuilder2.append(h().toString().toLowerCase());
      localStringBuilder2.append(", ");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    if (i() != i.a)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("overflow: ");
      localStringBuilder2.append(i().toString().toLowerCase());
      localStringBuilder2.append(", ");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    if (g() != j.a)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("positionType: ");
      localStringBuilder2.append(g().toString().toLowerCase());
      localStringBuilder2.append(", ");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    if (m().a() != 0.0F)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("width: ");
      localStringBuilder2.append(m().a());
      localStringBuilder2.append(", ");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    if (n().a() != 0.0F)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("height: ");
      localStringBuilder2.append(n().a());
      localStringBuilder2.append(", ");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    if (q().a() != 0.0F)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("max-width: ");
      localStringBuilder2.append(q().a());
      localStringBuilder2.append(", ");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    if (r().a() != 0.0F)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("max-height: ");
      localStringBuilder2.append(r().a());
      localStringBuilder2.append(", ");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    if (o().a() != 0.0F)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("min-height: ");
      localStringBuilder2.append(o().a());
      localStringBuilder2.append(", ");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    if (p().a() != 0.0F)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("min-height: ");
      localStringBuilder2.append(p().a());
      localStringBuilder2.append(", ");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    localStringBuilder1.append("}");
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.smtt.flexbox.FlexNodeStyle
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.troopgift;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.util.AttributeSet;
import aybi;
import aybj;
import aybk;
import aybl;
import aybm;
import aybo;
import aybq;
import aybr;
import aycc;
import aycd;
import aycm;
import aycp;
import bash;
import basj;
import baxn;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite;

public class TroopGiftToPersonalSurfaceView
  extends SpriteGLView
{
  protected int a;
  private aycm jdField_a_of_type_Aycm;
  private aycm[] jdField_a_of_type_ArrayOfAycm;
  protected int b;
  private aycm b;
  private aycm c;
  private int d;
  
  public TroopGiftToPersonalSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int i = baxn.a(getContext(), 4.0F);
    try
    {
      Bitmap localBitmap1 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      Bitmap localBitmap2 = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap1);
      Object localObject = new Canvas(localBitmap2);
      Paint localPaint = new Paint();
      Rect localRect = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
      localPaint.setAntiAlias(true);
      ((Canvas)localObject).drawCircle(paramBitmap.getWidth() / 2, paramBitmap.getHeight() / 2, paramBitmap.getWidth() / 2, localPaint);
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      ((Canvas)localObject).drawBitmap(paramBitmap, localRect, localRect, localPaint);
      paramBitmap = new Paint();
      paramBitmap.setColor(-1);
      paramBitmap.setAntiAlias(true);
      localCanvas.drawCircle(localBitmap1.getWidth() / 2, localBitmap1.getHeight() / 2, localBitmap1.getWidth() / 2, paramBitmap);
      localObject = new Matrix();
      ((Matrix)localObject).postScale((paramInt1 - i) / localBitmap2.getWidth(), (paramInt2 - i) / localBitmap2.getHeight());
      ((Matrix)localObject).postTranslate(i / 2, i / 2);
      localCanvas.drawBitmap(localBitmap2, (Matrix)localObject, paramBitmap);
      paramBitmap = new Paint();
      paramBitmap.setColor(-16777216);
      paramBitmap.setAlpha(43);
      paramBitmap.setStyle(Paint.Style.STROKE);
      paramBitmap.setAntiAlias(true);
      paramBitmap.setStrokeWidth(baxn.a(getContext(), 1.0F));
      localCanvas.drawCircle(localBitmap1.getWidth() / 2, localBitmap1.getHeight() / 2, localBitmap1.getWidth() / 2, paramBitmap);
      localBitmap2.recycle();
      return localBitmap1;
    }
    catch (OutOfMemoryError paramBitmap) {}
    return null;
  }
  
  public void a(int paramInt, aybj paramaybj)
  {
    int i = this.jdField_a_of_type_Aycm.d();
    int j = (int)(i * 0.15F);
    this.jdField_a_of_type_Aycm.a(new aybi[] { new aybr(new aybi[] { new aybk(paramInt), new aybq(200, 1.0F, 1.05F), new aybq(200, 1.05F, 0.0F) }), new aybr(new aybi[] { new aybk(paramInt), new aybm(200, (int)this.jdField_a_of_type_Aycm.c, (int)this.jdField_a_of_type_Aycm.d, (int)this.jdField_a_of_type_Aycm.c - j / 2, (int)this.jdField_a_of_type_Aycm.d), new aybm(200, (int)this.jdField_a_of_type_Aycm.c, (int)this.jdField_a_of_type_Aycm.d, (int)this.jdField_a_of_type_Aycm.c + j / 2 + i, (int)this.jdField_a_of_type_Aycm.d) }) });
    if (this.jdField_b_of_type_Aycm.a() == null)
    {
      if (paramaybj != null) {
        paramaybj.a();
      }
      return;
    }
    aybq localaybq = new aybq(200, 1.05F, 0.0F);
    this.jdField_b_of_type_Aycm.a(new aybi[] { new aybr(new aybi[] { new aybk(paramInt), new aybq(200, 1.0F, 1.05F), localaybq }), new aybr(new aybi[] { new aybm(200, (int)this.jdField_b_of_type_Aycm.c, (int)this.jdField_b_of_type_Aycm.d, (int)this.jdField_b_of_type_Aycm.c + j / 2, (int)this.jdField_b_of_type_Aycm.d), new aybm(200, (int)this.jdField_b_of_type_Aycm.c, (int)this.jdField_b_of_type_Aycm.d, (int)this.jdField_b_of_type_Aycm.c - j / 2 - i, (int)this.jdField_b_of_type_Aycm.d) }) });
    localaybq.a(paramaybj);
  }
  
  public void a(aycd paramaycd)
  {
    this.jdField_a_of_type_Aycm.e = 0.0F;
    this.jdField_b_of_type_Aycm.e = 0.0F;
    int i = this.jdField_a_of_type_Aycm.d();
    int j = i / 10;
    this.jdField_a_of_type_Aycm.a(this.jdField_a_of_type_Int / 2 - i, this.d);
    this.jdField_b_of_type_Aycm.a(this.jdField_a_of_type_Int / 2 + i, this.d);
    this.jdField_a_of_type_ArrayOfAycm[0].a(this.jdField_a_of_type_Int / 2 - i, this.d - j * 2);
    this.jdField_a_of_type_ArrayOfAycm[1].a(this.jdField_a_of_type_Int / 2 - i, this.d - j);
    this.jdField_a_of_type_ArrayOfAycm[2].a(this.jdField_a_of_type_Int / 2 - i, this.d);
    this.jdField_a_of_type_ArrayOfAycm[3].a(this.jdField_a_of_type_Int / 2 - i * 6 / 5, this.d + j);
    this.jdField_a_of_type_ArrayOfAycm[4].a(this.jdField_a_of_type_Int / 2 - i * 6 / 5, this.d + j * 2);
    this.jdField_a_of_type_ArrayOfAycm[5].a(this.jdField_a_of_type_Int / 2 - i, j * 2 + this.d);
    this.jdField_a_of_type_Aycm.a(new aybi[] { new aybr(new aybi[] { new aybq(200, 0.0F, 1.05F), new aybq(150, 1.05F, 1.0F) }) });
    this.jdField_b_of_type_Aycm.a(new aybi[] { new aybr(new aybi[] { new aybk(200), new aybq(200, 0.0F, 1.05F), new aybq(150, 1.05F, 1.0F) }) });
    float f = 9.0F / (this.jdField_b_of_type_Aycm.c - this.jdField_a_of_type_Aycm.c);
    aybr localaybr1 = new aybr(new aybi[] { new aybk(500), new aybl(600, (int)this.jdField_a_of_type_ArrayOfAycm[0].c, (int)this.jdField_a_of_type_ArrayOfAycm[0].d, (int)this.jdField_b_of_type_Aycm.c, i / 20, f) });
    aybr localaybr2 = new aybr(new aybi[] { new aybk(700), new aybl(600, (int)this.jdField_a_of_type_ArrayOfAycm[1].c, (int)this.jdField_a_of_type_ArrayOfAycm[1].d, (int)this.jdField_b_of_type_Aycm.c, i / 20, f) });
    aybr localaybr3 = new aybr(new aybi[] { new aybk(600), new aybl(600, (int)this.jdField_a_of_type_ArrayOfAycm[2].c, (int)this.jdField_a_of_type_ArrayOfAycm[2].d, (int)this.jdField_b_of_type_Aycm.c, i / 20, f) });
    aybr localaybr4 = new aybr(new aybi[] { new aybk(900), new aybl(600, (int)this.jdField_a_of_type_ArrayOfAycm[3].c, (int)this.jdField_a_of_type_ArrayOfAycm[3].d, (int)this.jdField_b_of_type_Aycm.c, i / 20, f * 0.6F) });
    aybr localaybr5 = new aybr(new aybi[] { new aybk(800), new aybl(600, (int)this.jdField_a_of_type_ArrayOfAycm[4].c, (int)this.jdField_a_of_type_ArrayOfAycm[4].d, (int)this.jdField_b_of_type_Aycm.c, i / 20, f * 0.6F) });
    aybr localaybr6 = new aybr(new aybi[] { new aybk(1000), new aybl(600, (int)this.jdField_a_of_type_ArrayOfAycm[5].c, (int)this.jdField_a_of_type_ArrayOfAycm[5].d, (int)this.jdField_b_of_type_Aycm.c, i / 20, f) });
    i = 0;
    while (i < this.jdField_a_of_type_ArrayOfAycm.length)
    {
      this.jdField_a_of_type_ArrayOfAycm[i].e = 0.0F;
      this.jdField_a_of_type_ArrayOfAycm[i].jdField_a_of_type_Int = 255;
      this.jdField_a_of_type_ArrayOfAycm[i].a(new aybi[] { new aybi[] { localaybr1, localaybr2, localaybr3, localaybr4, localaybr5, localaybr6 }[i], new aybr(new aybi[] { new aybk(1300), new aybo(300, 255, 0) }) });
      i += 1;
    }
    if ((this.c != null) && ((this.c instanceof aycc)))
    {
      ((aycc)this.c).a = new bash(this, paramaycd);
      ((aycc)this.c).a(getContext(), this);
    }
    while (a())
    {
      a(this.c);
      a(this.jdField_a_of_type_Aycm);
      a(this.jdField_b_of_type_Aycm);
      i = 0;
      while (i < this.jdField_a_of_type_ArrayOfAycm.length)
      {
        a(this.jdField_a_of_type_ArrayOfAycm[i]);
        i += 1;
      }
      if ((this.c != null) && ((this.c instanceof VideoSprite))) {
        ((VideoSprite)this.c).a(new basj(this, paramaycd));
      }
    }
  }
  
  public void setHeadPositionY(int paramInt1, int paramInt2, float paramFloat, int paramInt3, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    int j = paramInt1 / 6;
    int i;
    if (paramInt3 < j) {
      i = j;
    }
    for (;;)
    {
      this.d = i;
      this.c.a(paramInt1 / 2, paramInt2 / 2);
      this.c.e = paramFloat;
      this.c.jdField_a_of_type_Int = 255;
      return;
      i = paramInt3;
      if (paramInt3 + j > paramInt2) {
        i = paramInt2 - j;
      }
    }
  }
  
  public void setReceiveHeadBitmap(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (this.jdField_b_of_type_Aycm != null)) {
      this.jdField_b_of_type_Aycm.a(this, a(paramBitmap.copy(Bitmap.Config.ARGB_8888, false), baxn.a(getContext(), 70.0F), baxn.a(getContext(), 70.0F)));
    }
  }
  
  public void setResourceWithFps(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, String paramString, int paramInt1, int paramInt2)
  {
    this.c = new VideoSprite(this, getContext(), true);
    ((VideoSprite)this.c).c(paramString);
    this.c.c = (paramInt1 / 2);
    this.c.d = (paramInt2 / 2);
    a(this.c);
    this.jdField_a_of_type_Aycm = new aycm();
    a(this.jdField_a_of_type_Aycm);
    this.jdField_b_of_type_Aycm = new aycm();
    a(this.jdField_b_of_type_Aycm);
    this.jdField_a_of_type_Aycm.e = 0.0F;
    this.jdField_b_of_type_Aycm.e = 0.0F;
    this.jdField_a_of_type_ArrayOfAycm = new aycm[6];
    paramInt1 = 0;
    while (paramInt1 < 6)
    {
      this.jdField_a_of_type_ArrayOfAycm[paramInt1] = new aycm();
      this.jdField_a_of_type_ArrayOfAycm[paramInt1].e = 0.0F;
      a(this.jdField_a_of_type_ArrayOfAycm[paramInt1]);
      paramInt1 += 1;
    }
    if (paramBitmap1 != null) {
      this.jdField_a_of_type_Aycm.a(this, a(paramBitmap1.copy(Bitmap.Config.ARGB_8888, false), baxn.a(getContext(), 70.0F), baxn.a(getContext(), 70.0F)));
    }
    if (paramBitmap2 != null) {
      this.jdField_b_of_type_Aycm.a(this, a(paramBitmap2.copy(Bitmap.Config.ARGB_8888, false), baxn.a(getContext(), 70.0F), baxn.a(getContext(), 70.0F)));
    }
    paramBitmap1 = new aycp(this, paramBitmap3);
    paramInt1 = 0;
    while (paramInt1 < 6)
    {
      this.jdField_a_of_type_ArrayOfAycm[paramInt1].a(paramBitmap1);
      paramInt1 += 1;
    }
  }
  
  public void setResourceWithFps(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, String[] paramArrayOfString, int paramInt)
  {
    this.c = new aycc(this, paramArrayOfString);
    ((aycc)this.c).e(paramInt);
    a(this.c);
    this.jdField_a_of_type_Aycm = new aycm();
    a(this.jdField_a_of_type_Aycm);
    this.jdField_b_of_type_Aycm = new aycm();
    a(this.jdField_b_of_type_Aycm);
    this.jdField_a_of_type_Aycm.e = 0.0F;
    this.jdField_b_of_type_Aycm.e = 0.0F;
    this.jdField_a_of_type_ArrayOfAycm = new aycm[6];
    paramInt = 0;
    while (paramInt < 6)
    {
      this.jdField_a_of_type_ArrayOfAycm[paramInt] = new aycm();
      this.jdField_a_of_type_ArrayOfAycm[paramInt].e = 0.0F;
      a(this.jdField_a_of_type_ArrayOfAycm[paramInt]);
      paramInt += 1;
    }
    if (paramBitmap1 != null) {
      this.jdField_a_of_type_Aycm.a(this, a(paramBitmap1.copy(Bitmap.Config.ARGB_8888, false), baxn.a(getContext(), 70.0F), baxn.a(getContext(), 70.0F)));
    }
    if (paramBitmap2 != null) {
      this.jdField_b_of_type_Aycm.a(this, a(paramBitmap2.copy(Bitmap.Config.ARGB_8888, false), baxn.a(getContext(), 70.0F), baxn.a(getContext(), 70.0F)));
    }
    paramBitmap1 = new aycp(this, paramBitmap3);
    paramInt = 0;
    while (paramInt < 6)
    {
      this.jdField_a_of_type_ArrayOfAycm[paramInt].a(paramBitmap1);
      paramInt += 1;
    }
  }
  
  public void setSendHeadBitmap(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (this.jdField_a_of_type_Aycm != null)) {
      this.jdField_a_of_type_Aycm.a(this, a(paramBitmap.copy(Bitmap.Config.ARGB_8888, false), baxn.a(getContext(), 70.0F), baxn.a(getContext(), 70.0F)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopGiftToPersonalSurfaceView
 * JD-Core Version:    0.7.0.1
 */
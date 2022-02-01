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
import bdes;
import bdet;
import bdeu;
import bdev;
import bdew;
import bdey;
import bdfa;
import bdfb;
import bdfm;
import bdfn;
import bdfw;
import bdfz;
import bfzv;
import bfzx;
import bggq;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite;

public class TroopGiftToPersonalSurfaceView
  extends SpriteGLView
{
  protected int a;
  private bdfw jdField_a_of_type_Bdfw;
  private bdfw[] jdField_a_of_type_ArrayOfBdfw;
  protected int b;
  private bdfw b;
  private bdfw c;
  private int d;
  
  public TroopGiftToPersonalSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int i = bggq.a(getContext(), 4.0F);
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
      paramBitmap.setStrokeWidth(bggq.a(getContext(), 1.0F));
      localCanvas.drawCircle(localBitmap1.getWidth() / 2, localBitmap1.getHeight() / 2, localBitmap1.getWidth() / 2, paramBitmap);
      localBitmap2.recycle();
      return localBitmap1;
    }
    catch (OutOfMemoryError paramBitmap) {}
    return null;
  }
  
  public void a(int paramInt, bdet parambdet)
  {
    int i = this.jdField_a_of_type_Bdfw.d();
    int j = (int)(i * 0.15F);
    this.jdField_a_of_type_Bdfw.a(new bdes[] { new bdfb(new bdes[] { new bdeu(paramInt), new bdfa(200, 1.0F, 1.05F), new bdfa(200, 1.05F, 0.0F) }), new bdfb(new bdes[] { new bdeu(paramInt), new bdew(200, (int)this.jdField_a_of_type_Bdfw.c, (int)this.jdField_a_of_type_Bdfw.d, (int)this.jdField_a_of_type_Bdfw.c - j / 2, (int)this.jdField_a_of_type_Bdfw.d), new bdew(200, (int)this.jdField_a_of_type_Bdfw.c, (int)this.jdField_a_of_type_Bdfw.d, (int)this.jdField_a_of_type_Bdfw.c + j / 2 + i, (int)this.jdField_a_of_type_Bdfw.d) }) });
    if (this.jdField_b_of_type_Bdfw.a() == null)
    {
      if (parambdet != null) {
        parambdet.a();
      }
      return;
    }
    bdfa localbdfa = new bdfa(200, 1.05F, 0.0F);
    this.jdField_b_of_type_Bdfw.a(new bdes[] { new bdfb(new bdes[] { new bdeu(paramInt), new bdfa(200, 1.0F, 1.05F), localbdfa }), new bdfb(new bdes[] { new bdew(200, (int)this.jdField_b_of_type_Bdfw.c, (int)this.jdField_b_of_type_Bdfw.d, (int)this.jdField_b_of_type_Bdfw.c + j / 2, (int)this.jdField_b_of_type_Bdfw.d), new bdew(200, (int)this.jdField_b_of_type_Bdfw.c, (int)this.jdField_b_of_type_Bdfw.d, (int)this.jdField_b_of_type_Bdfw.c - j / 2 - i, (int)this.jdField_b_of_type_Bdfw.d) }) });
    localbdfa.a(parambdet);
  }
  
  public void a(bdfn parambdfn)
  {
    this.jdField_a_of_type_Bdfw.e = 0.0F;
    this.jdField_b_of_type_Bdfw.e = 0.0F;
    int i = this.jdField_a_of_type_Bdfw.d();
    int j = i / 10;
    this.jdField_a_of_type_Bdfw.a(this.jdField_a_of_type_Int / 2 - i, this.d);
    this.jdField_b_of_type_Bdfw.a(this.jdField_a_of_type_Int / 2 + i, this.d);
    this.jdField_a_of_type_ArrayOfBdfw[0].a(this.jdField_a_of_type_Int / 2 - i, this.d - j * 2);
    this.jdField_a_of_type_ArrayOfBdfw[1].a(this.jdField_a_of_type_Int / 2 - i, this.d - j);
    this.jdField_a_of_type_ArrayOfBdfw[2].a(this.jdField_a_of_type_Int / 2 - i, this.d);
    this.jdField_a_of_type_ArrayOfBdfw[3].a(this.jdField_a_of_type_Int / 2 - i * 6 / 5, this.d + j);
    this.jdField_a_of_type_ArrayOfBdfw[4].a(this.jdField_a_of_type_Int / 2 - i * 6 / 5, this.d + j * 2);
    this.jdField_a_of_type_ArrayOfBdfw[5].a(this.jdField_a_of_type_Int / 2 - i, j * 2 + this.d);
    this.jdField_a_of_type_Bdfw.a(new bdes[] { new bdfb(new bdes[] { new bdfa(200, 0.0F, 1.05F), new bdfa(150, 1.05F, 1.0F) }) });
    this.jdField_b_of_type_Bdfw.a(new bdes[] { new bdfb(new bdes[] { new bdeu(200), new bdfa(200, 0.0F, 1.05F), new bdfa(150, 1.05F, 1.0F) }) });
    float f = 9.0F / (this.jdField_b_of_type_Bdfw.c - this.jdField_a_of_type_Bdfw.c);
    bdfb localbdfb1 = new bdfb(new bdes[] { new bdeu(500), new bdev(600, (int)this.jdField_a_of_type_ArrayOfBdfw[0].c, (int)this.jdField_a_of_type_ArrayOfBdfw[0].d, (int)this.jdField_b_of_type_Bdfw.c, i / 20, f) });
    bdfb localbdfb2 = new bdfb(new bdes[] { new bdeu(700), new bdev(600, (int)this.jdField_a_of_type_ArrayOfBdfw[1].c, (int)this.jdField_a_of_type_ArrayOfBdfw[1].d, (int)this.jdField_b_of_type_Bdfw.c, i / 20, f) });
    bdfb localbdfb3 = new bdfb(new bdes[] { new bdeu(600), new bdev(600, (int)this.jdField_a_of_type_ArrayOfBdfw[2].c, (int)this.jdField_a_of_type_ArrayOfBdfw[2].d, (int)this.jdField_b_of_type_Bdfw.c, i / 20, f) });
    bdfb localbdfb4 = new bdfb(new bdes[] { new bdeu(900), new bdev(600, (int)this.jdField_a_of_type_ArrayOfBdfw[3].c, (int)this.jdField_a_of_type_ArrayOfBdfw[3].d, (int)this.jdField_b_of_type_Bdfw.c, i / 20, f * 0.6F) });
    bdfb localbdfb5 = new bdfb(new bdes[] { new bdeu(800), new bdev(600, (int)this.jdField_a_of_type_ArrayOfBdfw[4].c, (int)this.jdField_a_of_type_ArrayOfBdfw[4].d, (int)this.jdField_b_of_type_Bdfw.c, i / 20, f * 0.6F) });
    bdfb localbdfb6 = new bdfb(new bdes[] { new bdeu(1000), new bdev(600, (int)this.jdField_a_of_type_ArrayOfBdfw[5].c, (int)this.jdField_a_of_type_ArrayOfBdfw[5].d, (int)this.jdField_b_of_type_Bdfw.c, i / 20, f) });
    i = 0;
    while (i < this.jdField_a_of_type_ArrayOfBdfw.length)
    {
      this.jdField_a_of_type_ArrayOfBdfw[i].e = 0.0F;
      this.jdField_a_of_type_ArrayOfBdfw[i].jdField_a_of_type_Int = 255;
      this.jdField_a_of_type_ArrayOfBdfw[i].a(new bdes[] { new bdes[] { localbdfb1, localbdfb2, localbdfb3, localbdfb4, localbdfb5, localbdfb6 }[i], new bdfb(new bdes[] { new bdeu(1300), new bdey(300, 255, 0) }) });
      i += 1;
    }
    if ((this.c != null) && ((this.c instanceof bdfm)))
    {
      ((bdfm)this.c).a = new bfzv(this, parambdfn);
      ((bdfm)this.c).a(getContext(), this);
    }
    while (a())
    {
      a(this.c);
      a(this.jdField_a_of_type_Bdfw);
      a(this.jdField_b_of_type_Bdfw);
      i = 0;
      while (i < this.jdField_a_of_type_ArrayOfBdfw.length)
      {
        a(this.jdField_a_of_type_ArrayOfBdfw[i]);
        i += 1;
      }
      if ((this.c != null) && ((this.c instanceof VideoSprite))) {
        ((VideoSprite)this.c).a(new bfzx(this, parambdfn));
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
    if ((paramBitmap != null) && (this.jdField_b_of_type_Bdfw != null)) {
      this.jdField_b_of_type_Bdfw.a(this, a(paramBitmap.copy(Bitmap.Config.ARGB_8888, false), bggq.a(getContext(), 70.0F), bggq.a(getContext(), 70.0F)));
    }
  }
  
  public void setResourceWithFps(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, String paramString, int paramInt1, int paramInt2)
  {
    this.c = new VideoSprite(this, getContext(), true);
    ((VideoSprite)this.c).c(paramString);
    this.c.c = (paramInt1 / 2);
    this.c.d = (paramInt2 / 2);
    a(this.c);
    this.jdField_a_of_type_Bdfw = new bdfw();
    a(this.jdField_a_of_type_Bdfw);
    this.jdField_b_of_type_Bdfw = new bdfw();
    a(this.jdField_b_of_type_Bdfw);
    this.jdField_a_of_type_Bdfw.e = 0.0F;
    this.jdField_b_of_type_Bdfw.e = 0.0F;
    this.jdField_a_of_type_ArrayOfBdfw = new bdfw[6];
    paramInt1 = 0;
    while (paramInt1 < 6)
    {
      this.jdField_a_of_type_ArrayOfBdfw[paramInt1] = new bdfw();
      this.jdField_a_of_type_ArrayOfBdfw[paramInt1].e = 0.0F;
      a(this.jdField_a_of_type_ArrayOfBdfw[paramInt1]);
      paramInt1 += 1;
    }
    if (paramBitmap1 != null) {
      this.jdField_a_of_type_Bdfw.a(this, a(paramBitmap1.copy(Bitmap.Config.ARGB_8888, false), bggq.a(getContext(), 70.0F), bggq.a(getContext(), 70.0F)));
    }
    if (paramBitmap2 != null) {
      this.jdField_b_of_type_Bdfw.a(this, a(paramBitmap2.copy(Bitmap.Config.ARGB_8888, false), bggq.a(getContext(), 70.0F), bggq.a(getContext(), 70.0F)));
    }
    paramBitmap1 = new bdfz(this, paramBitmap3);
    paramInt1 = 0;
    while (paramInt1 < 6)
    {
      this.jdField_a_of_type_ArrayOfBdfw[paramInt1].a(paramBitmap1);
      paramInt1 += 1;
    }
  }
  
  public void setResourceWithFps(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, String[] paramArrayOfString, int paramInt)
  {
    this.c = new bdfm(this, paramArrayOfString);
    ((bdfm)this.c).e(paramInt);
    a(this.c);
    this.jdField_a_of_type_Bdfw = new bdfw();
    a(this.jdField_a_of_type_Bdfw);
    this.jdField_b_of_type_Bdfw = new bdfw();
    a(this.jdField_b_of_type_Bdfw);
    this.jdField_a_of_type_Bdfw.e = 0.0F;
    this.jdField_b_of_type_Bdfw.e = 0.0F;
    this.jdField_a_of_type_ArrayOfBdfw = new bdfw[6];
    paramInt = 0;
    while (paramInt < 6)
    {
      this.jdField_a_of_type_ArrayOfBdfw[paramInt] = new bdfw();
      this.jdField_a_of_type_ArrayOfBdfw[paramInt].e = 0.0F;
      a(this.jdField_a_of_type_ArrayOfBdfw[paramInt]);
      paramInt += 1;
    }
    if (paramBitmap1 != null) {
      this.jdField_a_of_type_Bdfw.a(this, a(paramBitmap1.copy(Bitmap.Config.ARGB_8888, false), bggq.a(getContext(), 70.0F), bggq.a(getContext(), 70.0F)));
    }
    if (paramBitmap2 != null) {
      this.jdField_b_of_type_Bdfw.a(this, a(paramBitmap2.copy(Bitmap.Config.ARGB_8888, false), bggq.a(getContext(), 70.0F), bggq.a(getContext(), 70.0F)));
    }
    paramBitmap1 = new bdfz(this, paramBitmap3);
    paramInt = 0;
    while (paramInt < 6)
    {
      this.jdField_a_of_type_ArrayOfBdfw[paramInt].a(paramBitmap1);
      paramInt += 1;
    }
  }
  
  public void setSendHeadBitmap(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (this.jdField_a_of_type_Bdfw != null)) {
      this.jdField_a_of_type_Bdfw.a(this, a(paramBitmap.copy(Bitmap.Config.ARGB_8888, false), bggq.a(getContext(), 70.0F), bggq.a(getContext(), 70.0F)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopGiftToPersonalSurfaceView
 * JD-Core Version:    0.7.0.1
 */
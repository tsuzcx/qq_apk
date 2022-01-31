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
import bado;
import badp;
import badq;
import badr;
import bads;
import badu;
import badw;
import badx;
import baei;
import baej;
import baes;
import baev;
import bcvk;
import bcvm;
import bdaq;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite;

public class TroopGiftToPersonalSurfaceView
  extends SpriteGLView
{
  protected int a;
  private baes jdField_a_of_type_Baes;
  private baes[] jdField_a_of_type_ArrayOfBaes;
  protected int b;
  private baes b;
  private baes c;
  private int d;
  
  public TroopGiftToPersonalSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int i = bdaq.a(getContext(), 4.0F);
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
      paramBitmap.setStrokeWidth(bdaq.a(getContext(), 1.0F));
      localCanvas.drawCircle(localBitmap1.getWidth() / 2, localBitmap1.getHeight() / 2, localBitmap1.getWidth() / 2, paramBitmap);
      localBitmap2.recycle();
      return localBitmap1;
    }
    catch (OutOfMemoryError paramBitmap) {}
    return null;
  }
  
  public void a(int paramInt, badp parambadp)
  {
    int i = this.jdField_a_of_type_Baes.d();
    int j = (int)(i * 0.15F);
    this.jdField_a_of_type_Baes.a(new bado[] { new badx(new bado[] { new badq(paramInt), new badw(200, 1.0F, 1.05F), new badw(200, 1.05F, 0.0F) }), new badx(new bado[] { new badq(paramInt), new bads(200, (int)this.jdField_a_of_type_Baes.c, (int)this.jdField_a_of_type_Baes.d, (int)this.jdField_a_of_type_Baes.c - j / 2, (int)this.jdField_a_of_type_Baes.d), new bads(200, (int)this.jdField_a_of_type_Baes.c, (int)this.jdField_a_of_type_Baes.d, (int)this.jdField_a_of_type_Baes.c + j / 2 + i, (int)this.jdField_a_of_type_Baes.d) }) });
    if (this.jdField_b_of_type_Baes.a() == null)
    {
      if (parambadp != null) {
        parambadp.a();
      }
      return;
    }
    badw localbadw = new badw(200, 1.05F, 0.0F);
    this.jdField_b_of_type_Baes.a(new bado[] { new badx(new bado[] { new badq(paramInt), new badw(200, 1.0F, 1.05F), localbadw }), new badx(new bado[] { new bads(200, (int)this.jdField_b_of_type_Baes.c, (int)this.jdField_b_of_type_Baes.d, (int)this.jdField_b_of_type_Baes.c + j / 2, (int)this.jdField_b_of_type_Baes.d), new bads(200, (int)this.jdField_b_of_type_Baes.c, (int)this.jdField_b_of_type_Baes.d, (int)this.jdField_b_of_type_Baes.c - j / 2 - i, (int)this.jdField_b_of_type_Baes.d) }) });
    localbadw.a(parambadp);
  }
  
  public void a(baej parambaej)
  {
    this.jdField_a_of_type_Baes.e = 0.0F;
    this.jdField_b_of_type_Baes.e = 0.0F;
    int i = this.jdField_a_of_type_Baes.d();
    int j = i / 10;
    this.jdField_a_of_type_Baes.a(this.jdField_a_of_type_Int / 2 - i, this.d);
    this.jdField_b_of_type_Baes.a(this.jdField_a_of_type_Int / 2 + i, this.d);
    this.jdField_a_of_type_ArrayOfBaes[0].a(this.jdField_a_of_type_Int / 2 - i, this.d - j * 2);
    this.jdField_a_of_type_ArrayOfBaes[1].a(this.jdField_a_of_type_Int / 2 - i, this.d - j);
    this.jdField_a_of_type_ArrayOfBaes[2].a(this.jdField_a_of_type_Int / 2 - i, this.d);
    this.jdField_a_of_type_ArrayOfBaes[3].a(this.jdField_a_of_type_Int / 2 - i * 6 / 5, this.d + j);
    this.jdField_a_of_type_ArrayOfBaes[4].a(this.jdField_a_of_type_Int / 2 - i * 6 / 5, this.d + j * 2);
    this.jdField_a_of_type_ArrayOfBaes[5].a(this.jdField_a_of_type_Int / 2 - i, j * 2 + this.d);
    this.jdField_a_of_type_Baes.a(new bado[] { new badx(new bado[] { new badw(200, 0.0F, 1.05F), new badw(150, 1.05F, 1.0F) }) });
    this.jdField_b_of_type_Baes.a(new bado[] { new badx(new bado[] { new badq(200), new badw(200, 0.0F, 1.05F), new badw(150, 1.05F, 1.0F) }) });
    float f = 9.0F / (this.jdField_b_of_type_Baes.c - this.jdField_a_of_type_Baes.c);
    badx localbadx1 = new badx(new bado[] { new badq(500), new badr(600, (int)this.jdField_a_of_type_ArrayOfBaes[0].c, (int)this.jdField_a_of_type_ArrayOfBaes[0].d, (int)this.jdField_b_of_type_Baes.c, i / 20, f) });
    badx localbadx2 = new badx(new bado[] { new badq(700), new badr(600, (int)this.jdField_a_of_type_ArrayOfBaes[1].c, (int)this.jdField_a_of_type_ArrayOfBaes[1].d, (int)this.jdField_b_of_type_Baes.c, i / 20, f) });
    badx localbadx3 = new badx(new bado[] { new badq(600), new badr(600, (int)this.jdField_a_of_type_ArrayOfBaes[2].c, (int)this.jdField_a_of_type_ArrayOfBaes[2].d, (int)this.jdField_b_of_type_Baes.c, i / 20, f) });
    badx localbadx4 = new badx(new bado[] { new badq(900), new badr(600, (int)this.jdField_a_of_type_ArrayOfBaes[3].c, (int)this.jdField_a_of_type_ArrayOfBaes[3].d, (int)this.jdField_b_of_type_Baes.c, i / 20, f * 0.6F) });
    badx localbadx5 = new badx(new bado[] { new badq(800), new badr(600, (int)this.jdField_a_of_type_ArrayOfBaes[4].c, (int)this.jdField_a_of_type_ArrayOfBaes[4].d, (int)this.jdField_b_of_type_Baes.c, i / 20, f * 0.6F) });
    badx localbadx6 = new badx(new bado[] { new badq(1000), new badr(600, (int)this.jdField_a_of_type_ArrayOfBaes[5].c, (int)this.jdField_a_of_type_ArrayOfBaes[5].d, (int)this.jdField_b_of_type_Baes.c, i / 20, f) });
    i = 0;
    while (i < this.jdField_a_of_type_ArrayOfBaes.length)
    {
      this.jdField_a_of_type_ArrayOfBaes[i].e = 0.0F;
      this.jdField_a_of_type_ArrayOfBaes[i].jdField_a_of_type_Int = 255;
      this.jdField_a_of_type_ArrayOfBaes[i].a(new bado[] { new bado[] { localbadx1, localbadx2, localbadx3, localbadx4, localbadx5, localbadx6 }[i], new badx(new bado[] { new badq(1300), new badu(300, 255, 0) }) });
      i += 1;
    }
    if ((this.c != null) && ((this.c instanceof baei)))
    {
      ((baei)this.c).a = new bcvk(this, parambaej);
      ((baei)this.c).a(getContext(), this);
    }
    while (a())
    {
      a(this.c);
      a(this.jdField_a_of_type_Baes);
      a(this.jdField_b_of_type_Baes);
      i = 0;
      while (i < this.jdField_a_of_type_ArrayOfBaes.length)
      {
        a(this.jdField_a_of_type_ArrayOfBaes[i]);
        i += 1;
      }
      if ((this.c != null) && ((this.c instanceof VideoSprite))) {
        ((VideoSprite)this.c).a(new bcvm(this, parambaej));
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
    if ((paramBitmap != null) && (this.jdField_b_of_type_Baes != null)) {
      this.jdField_b_of_type_Baes.a(this, a(paramBitmap.copy(Bitmap.Config.ARGB_8888, false), bdaq.a(getContext(), 70.0F), bdaq.a(getContext(), 70.0F)));
    }
  }
  
  public void setResourceWithFps(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, String paramString, int paramInt1, int paramInt2)
  {
    this.c = new VideoSprite(this, getContext(), true);
    ((VideoSprite)this.c).c(paramString);
    this.c.c = (paramInt1 / 2);
    this.c.d = (paramInt2 / 2);
    a(this.c);
    this.jdField_a_of_type_Baes = new baes();
    a(this.jdField_a_of_type_Baes);
    this.jdField_b_of_type_Baes = new baes();
    a(this.jdField_b_of_type_Baes);
    this.jdField_a_of_type_Baes.e = 0.0F;
    this.jdField_b_of_type_Baes.e = 0.0F;
    this.jdField_a_of_type_ArrayOfBaes = new baes[6];
    paramInt1 = 0;
    while (paramInt1 < 6)
    {
      this.jdField_a_of_type_ArrayOfBaes[paramInt1] = new baes();
      this.jdField_a_of_type_ArrayOfBaes[paramInt1].e = 0.0F;
      a(this.jdField_a_of_type_ArrayOfBaes[paramInt1]);
      paramInt1 += 1;
    }
    if (paramBitmap1 != null) {
      this.jdField_a_of_type_Baes.a(this, a(paramBitmap1.copy(Bitmap.Config.ARGB_8888, false), bdaq.a(getContext(), 70.0F), bdaq.a(getContext(), 70.0F)));
    }
    if (paramBitmap2 != null) {
      this.jdField_b_of_type_Baes.a(this, a(paramBitmap2.copy(Bitmap.Config.ARGB_8888, false), bdaq.a(getContext(), 70.0F), bdaq.a(getContext(), 70.0F)));
    }
    paramBitmap1 = new baev(this, paramBitmap3);
    paramInt1 = 0;
    while (paramInt1 < 6)
    {
      this.jdField_a_of_type_ArrayOfBaes[paramInt1].a(paramBitmap1);
      paramInt1 += 1;
    }
  }
  
  public void setResourceWithFps(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, String[] paramArrayOfString, int paramInt)
  {
    this.c = new baei(this, paramArrayOfString);
    ((baei)this.c).e(paramInt);
    a(this.c);
    this.jdField_a_of_type_Baes = new baes();
    a(this.jdField_a_of_type_Baes);
    this.jdField_b_of_type_Baes = new baes();
    a(this.jdField_b_of_type_Baes);
    this.jdField_a_of_type_Baes.e = 0.0F;
    this.jdField_b_of_type_Baes.e = 0.0F;
    this.jdField_a_of_type_ArrayOfBaes = new baes[6];
    paramInt = 0;
    while (paramInt < 6)
    {
      this.jdField_a_of_type_ArrayOfBaes[paramInt] = new baes();
      this.jdField_a_of_type_ArrayOfBaes[paramInt].e = 0.0F;
      a(this.jdField_a_of_type_ArrayOfBaes[paramInt]);
      paramInt += 1;
    }
    if (paramBitmap1 != null) {
      this.jdField_a_of_type_Baes.a(this, a(paramBitmap1.copy(Bitmap.Config.ARGB_8888, false), bdaq.a(getContext(), 70.0F), bdaq.a(getContext(), 70.0F)));
    }
    if (paramBitmap2 != null) {
      this.jdField_b_of_type_Baes.a(this, a(paramBitmap2.copy(Bitmap.Config.ARGB_8888, false), bdaq.a(getContext(), 70.0F), bdaq.a(getContext(), 70.0F)));
    }
    paramBitmap1 = new baev(this, paramBitmap3);
    paramInt = 0;
    while (paramInt < 6)
    {
      this.jdField_a_of_type_ArrayOfBaes[paramInt].a(paramBitmap1);
      paramInt += 1;
    }
  }
  
  public void setSendHeadBitmap(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (this.jdField_a_of_type_Baes != null)) {
      this.jdField_a_of_type_Baes.a(this, a(paramBitmap.copy(Bitmap.Config.ARGB_8888, false), bdaq.a(getContext(), 70.0F), bdaq.a(getContext(), 70.0F)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopGiftToPersonalSurfaceView
 * JD-Core Version:    0.7.0.1
 */
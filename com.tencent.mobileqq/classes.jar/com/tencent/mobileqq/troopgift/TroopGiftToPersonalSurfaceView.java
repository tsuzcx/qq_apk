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
import bdxn;
import bdxo;
import bdxp;
import bdxq;
import bdxr;
import bdxt;
import bdxv;
import bdxw;
import bdyh;
import bdyi;
import bdyr;
import bdyu;
import bgzw;
import bgzy;
import bhgr;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite;

public class TroopGiftToPersonalSurfaceView
  extends SpriteGLView
{
  protected int a;
  private bdyr jdField_a_of_type_Bdyr;
  private bdyr[] jdField_a_of_type_ArrayOfBdyr;
  protected int b;
  private bdyr b;
  private bdyr c;
  private int d;
  
  public TroopGiftToPersonalSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int i = bhgr.a(getContext(), 4.0F);
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
      paramBitmap.setStrokeWidth(bhgr.a(getContext(), 1.0F));
      localCanvas.drawCircle(localBitmap1.getWidth() / 2, localBitmap1.getHeight() / 2, localBitmap1.getWidth() / 2, paramBitmap);
      localBitmap2.recycle();
      return localBitmap1;
    }
    catch (OutOfMemoryError paramBitmap) {}
    return null;
  }
  
  public void a(int paramInt, bdxo parambdxo)
  {
    int i = this.jdField_a_of_type_Bdyr.d();
    int j = (int)(i * 0.15F);
    this.jdField_a_of_type_Bdyr.a(new bdxn[] { new bdxw(new bdxn[] { new bdxp(paramInt), new bdxv(200, 1.0F, 1.05F), new bdxv(200, 1.05F, 0.0F) }), new bdxw(new bdxn[] { new bdxp(paramInt), new bdxr(200, (int)this.jdField_a_of_type_Bdyr.c, (int)this.jdField_a_of_type_Bdyr.d, (int)this.jdField_a_of_type_Bdyr.c - j / 2, (int)this.jdField_a_of_type_Bdyr.d), new bdxr(200, (int)this.jdField_a_of_type_Bdyr.c, (int)this.jdField_a_of_type_Bdyr.d, (int)this.jdField_a_of_type_Bdyr.c + j / 2 + i, (int)this.jdField_a_of_type_Bdyr.d) }) });
    if (this.jdField_b_of_type_Bdyr.a() == null)
    {
      if (parambdxo != null) {
        parambdxo.a();
      }
      return;
    }
    bdxv localbdxv = new bdxv(200, 1.05F, 0.0F);
    this.jdField_b_of_type_Bdyr.a(new bdxn[] { new bdxw(new bdxn[] { new bdxp(paramInt), new bdxv(200, 1.0F, 1.05F), localbdxv }), new bdxw(new bdxn[] { new bdxr(200, (int)this.jdField_b_of_type_Bdyr.c, (int)this.jdField_b_of_type_Bdyr.d, (int)this.jdField_b_of_type_Bdyr.c + j / 2, (int)this.jdField_b_of_type_Bdyr.d), new bdxr(200, (int)this.jdField_b_of_type_Bdyr.c, (int)this.jdField_b_of_type_Bdyr.d, (int)this.jdField_b_of_type_Bdyr.c - j / 2 - i, (int)this.jdField_b_of_type_Bdyr.d) }) });
    localbdxv.a(parambdxo);
  }
  
  public void a(bdyi parambdyi)
  {
    this.jdField_a_of_type_Bdyr.e = 0.0F;
    this.jdField_b_of_type_Bdyr.e = 0.0F;
    int i = this.jdField_a_of_type_Bdyr.d();
    int j = i / 10;
    this.jdField_a_of_type_Bdyr.a(this.jdField_a_of_type_Int / 2 - i, this.d);
    this.jdField_b_of_type_Bdyr.a(this.jdField_a_of_type_Int / 2 + i, this.d);
    this.jdField_a_of_type_ArrayOfBdyr[0].a(this.jdField_a_of_type_Int / 2 - i, this.d - j * 2);
    this.jdField_a_of_type_ArrayOfBdyr[1].a(this.jdField_a_of_type_Int / 2 - i, this.d - j);
    this.jdField_a_of_type_ArrayOfBdyr[2].a(this.jdField_a_of_type_Int / 2 - i, this.d);
    this.jdField_a_of_type_ArrayOfBdyr[3].a(this.jdField_a_of_type_Int / 2 - i * 6 / 5, this.d + j);
    this.jdField_a_of_type_ArrayOfBdyr[4].a(this.jdField_a_of_type_Int / 2 - i * 6 / 5, this.d + j * 2);
    this.jdField_a_of_type_ArrayOfBdyr[5].a(this.jdField_a_of_type_Int / 2 - i, j * 2 + this.d);
    this.jdField_a_of_type_Bdyr.a(new bdxn[] { new bdxw(new bdxn[] { new bdxv(200, 0.0F, 1.05F), new bdxv(150, 1.05F, 1.0F) }) });
    this.jdField_b_of_type_Bdyr.a(new bdxn[] { new bdxw(new bdxn[] { new bdxp(200), new bdxv(200, 0.0F, 1.05F), new bdxv(150, 1.05F, 1.0F) }) });
    float f = 9.0F / (this.jdField_b_of_type_Bdyr.c - this.jdField_a_of_type_Bdyr.c);
    bdxw localbdxw1 = new bdxw(new bdxn[] { new bdxp(500), new bdxq(600, (int)this.jdField_a_of_type_ArrayOfBdyr[0].c, (int)this.jdField_a_of_type_ArrayOfBdyr[0].d, (int)this.jdField_b_of_type_Bdyr.c, i / 20, f) });
    bdxw localbdxw2 = new bdxw(new bdxn[] { new bdxp(700), new bdxq(600, (int)this.jdField_a_of_type_ArrayOfBdyr[1].c, (int)this.jdField_a_of_type_ArrayOfBdyr[1].d, (int)this.jdField_b_of_type_Bdyr.c, i / 20, f) });
    bdxw localbdxw3 = new bdxw(new bdxn[] { new bdxp(600), new bdxq(600, (int)this.jdField_a_of_type_ArrayOfBdyr[2].c, (int)this.jdField_a_of_type_ArrayOfBdyr[2].d, (int)this.jdField_b_of_type_Bdyr.c, i / 20, f) });
    bdxw localbdxw4 = new bdxw(new bdxn[] { new bdxp(900), new bdxq(600, (int)this.jdField_a_of_type_ArrayOfBdyr[3].c, (int)this.jdField_a_of_type_ArrayOfBdyr[3].d, (int)this.jdField_b_of_type_Bdyr.c, i / 20, f * 0.6F) });
    bdxw localbdxw5 = new bdxw(new bdxn[] { new bdxp(800), new bdxq(600, (int)this.jdField_a_of_type_ArrayOfBdyr[4].c, (int)this.jdField_a_of_type_ArrayOfBdyr[4].d, (int)this.jdField_b_of_type_Bdyr.c, i / 20, f * 0.6F) });
    bdxw localbdxw6 = new bdxw(new bdxn[] { new bdxp(1000), new bdxq(600, (int)this.jdField_a_of_type_ArrayOfBdyr[5].c, (int)this.jdField_a_of_type_ArrayOfBdyr[5].d, (int)this.jdField_b_of_type_Bdyr.c, i / 20, f) });
    i = 0;
    while (i < this.jdField_a_of_type_ArrayOfBdyr.length)
    {
      this.jdField_a_of_type_ArrayOfBdyr[i].e = 0.0F;
      this.jdField_a_of_type_ArrayOfBdyr[i].jdField_a_of_type_Int = 255;
      this.jdField_a_of_type_ArrayOfBdyr[i].a(new bdxn[] { new bdxn[] { localbdxw1, localbdxw2, localbdxw3, localbdxw4, localbdxw5, localbdxw6 }[i], new bdxw(new bdxn[] { new bdxp(1300), new bdxt(300, 255, 0) }) });
      i += 1;
    }
    if ((this.c != null) && ((this.c instanceof bdyh)))
    {
      ((bdyh)this.c).a = new bgzw(this, parambdyi);
      ((bdyh)this.c).a(getContext(), this);
    }
    while (a())
    {
      a(this.c);
      a(this.jdField_a_of_type_Bdyr);
      a(this.jdField_b_of_type_Bdyr);
      i = 0;
      while (i < this.jdField_a_of_type_ArrayOfBdyr.length)
      {
        a(this.jdField_a_of_type_ArrayOfBdyr[i]);
        i += 1;
      }
      if ((this.c != null) && ((this.c instanceof VideoSprite))) {
        ((VideoSprite)this.c).a(new bgzy(this, parambdyi));
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
    if ((paramBitmap != null) && (this.jdField_b_of_type_Bdyr != null)) {
      this.jdField_b_of_type_Bdyr.a(this, a(paramBitmap.copy(Bitmap.Config.ARGB_8888, false), bhgr.a(getContext(), 70.0F), bhgr.a(getContext(), 70.0F)));
    }
  }
  
  public void setResourceWithFps(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, String paramString, int paramInt1, int paramInt2)
  {
    this.c = new VideoSprite(this, getContext(), true);
    ((VideoSprite)this.c).c(paramString);
    this.c.c = (paramInt1 / 2);
    this.c.d = (paramInt2 / 2);
    a(this.c);
    this.jdField_a_of_type_Bdyr = new bdyr();
    a(this.jdField_a_of_type_Bdyr);
    this.jdField_b_of_type_Bdyr = new bdyr();
    a(this.jdField_b_of_type_Bdyr);
    this.jdField_a_of_type_Bdyr.e = 0.0F;
    this.jdField_b_of_type_Bdyr.e = 0.0F;
    this.jdField_a_of_type_ArrayOfBdyr = new bdyr[6];
    paramInt1 = 0;
    while (paramInt1 < 6)
    {
      this.jdField_a_of_type_ArrayOfBdyr[paramInt1] = new bdyr();
      this.jdField_a_of_type_ArrayOfBdyr[paramInt1].e = 0.0F;
      a(this.jdField_a_of_type_ArrayOfBdyr[paramInt1]);
      paramInt1 += 1;
    }
    if (paramBitmap1 != null) {
      this.jdField_a_of_type_Bdyr.a(this, a(paramBitmap1.copy(Bitmap.Config.ARGB_8888, false), bhgr.a(getContext(), 70.0F), bhgr.a(getContext(), 70.0F)));
    }
    if (paramBitmap2 != null) {
      this.jdField_b_of_type_Bdyr.a(this, a(paramBitmap2.copy(Bitmap.Config.ARGB_8888, false), bhgr.a(getContext(), 70.0F), bhgr.a(getContext(), 70.0F)));
    }
    paramBitmap1 = new bdyu(this, paramBitmap3);
    paramInt1 = 0;
    while (paramInt1 < 6)
    {
      this.jdField_a_of_type_ArrayOfBdyr[paramInt1].a(paramBitmap1);
      paramInt1 += 1;
    }
  }
  
  public void setResourceWithFps(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, String[] paramArrayOfString, int paramInt)
  {
    this.c = new bdyh(this, paramArrayOfString);
    ((bdyh)this.c).e(paramInt);
    a(this.c);
    this.jdField_a_of_type_Bdyr = new bdyr();
    a(this.jdField_a_of_type_Bdyr);
    this.jdField_b_of_type_Bdyr = new bdyr();
    a(this.jdField_b_of_type_Bdyr);
    this.jdField_a_of_type_Bdyr.e = 0.0F;
    this.jdField_b_of_type_Bdyr.e = 0.0F;
    this.jdField_a_of_type_ArrayOfBdyr = new bdyr[6];
    paramInt = 0;
    while (paramInt < 6)
    {
      this.jdField_a_of_type_ArrayOfBdyr[paramInt] = new bdyr();
      this.jdField_a_of_type_ArrayOfBdyr[paramInt].e = 0.0F;
      a(this.jdField_a_of_type_ArrayOfBdyr[paramInt]);
      paramInt += 1;
    }
    if (paramBitmap1 != null) {
      this.jdField_a_of_type_Bdyr.a(this, a(paramBitmap1.copy(Bitmap.Config.ARGB_8888, false), bhgr.a(getContext(), 70.0F), bhgr.a(getContext(), 70.0F)));
    }
    if (paramBitmap2 != null) {
      this.jdField_b_of_type_Bdyr.a(this, a(paramBitmap2.copy(Bitmap.Config.ARGB_8888, false), bhgr.a(getContext(), 70.0F), bhgr.a(getContext(), 70.0F)));
    }
    paramBitmap1 = new bdyu(this, paramBitmap3);
    paramInt = 0;
    while (paramInt < 6)
    {
      this.jdField_a_of_type_ArrayOfBdyr[paramInt].a(paramBitmap1);
      paramInt += 1;
    }
  }
  
  public void setSendHeadBitmap(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (this.jdField_a_of_type_Bdyr != null)) {
      this.jdField_a_of_type_Bdyr.a(this, a(paramBitmap.copy(Bitmap.Config.ARGB_8888, false), bhgr.a(getContext(), 70.0F), bhgr.a(getContext(), 70.0F)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopGiftToPersonalSurfaceView
 * JD-Core Version:    0.7.0.1
 */
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
import axbe;
import axbf;
import axbg;
import axbh;
import axbi;
import axbk;
import axbm;
import axbn;
import axby;
import axbz;
import axci;
import axcl;
import azqp;
import azqr;
import azvv;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite;

public class TroopGiftToPersonalSurfaceView
  extends SpriteGLView
{
  protected int a;
  private axci jdField_a_of_type_Axci;
  private axci[] jdField_a_of_type_ArrayOfAxci;
  protected int b;
  private axci b;
  private axci c;
  private int d;
  
  public TroopGiftToPersonalSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int i = azvv.a(getContext(), 4.0F);
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
      paramBitmap.setStrokeWidth(azvv.a(getContext(), 1.0F));
      localCanvas.drawCircle(localBitmap1.getWidth() / 2, localBitmap1.getHeight() / 2, localBitmap1.getWidth() / 2, paramBitmap);
      localBitmap2.recycle();
      return localBitmap1;
    }
    catch (OutOfMemoryError paramBitmap) {}
    return null;
  }
  
  public void a(int paramInt, axbf paramaxbf)
  {
    int i = this.jdField_a_of_type_Axci.d();
    int j = (int)(i * 0.15F);
    this.jdField_a_of_type_Axci.a(new axbe[] { new axbn(new axbe[] { new axbg(paramInt), new axbm(200, 1.0F, 1.05F), new axbm(200, 1.05F, 0.0F) }), new axbn(new axbe[] { new axbg(paramInt), new axbi(200, (int)this.jdField_a_of_type_Axci.c, (int)this.jdField_a_of_type_Axci.d, (int)this.jdField_a_of_type_Axci.c - j / 2, (int)this.jdField_a_of_type_Axci.d), new axbi(200, (int)this.jdField_a_of_type_Axci.c, (int)this.jdField_a_of_type_Axci.d, (int)this.jdField_a_of_type_Axci.c + j / 2 + i, (int)this.jdField_a_of_type_Axci.d) }) });
    if (this.jdField_b_of_type_Axci.a() == null)
    {
      if (paramaxbf != null) {
        paramaxbf.a();
      }
      return;
    }
    axbm localaxbm = new axbm(200, 1.05F, 0.0F);
    this.jdField_b_of_type_Axci.a(new axbe[] { new axbn(new axbe[] { new axbg(paramInt), new axbm(200, 1.0F, 1.05F), localaxbm }), new axbn(new axbe[] { new axbi(200, (int)this.jdField_b_of_type_Axci.c, (int)this.jdField_b_of_type_Axci.d, (int)this.jdField_b_of_type_Axci.c + j / 2, (int)this.jdField_b_of_type_Axci.d), new axbi(200, (int)this.jdField_b_of_type_Axci.c, (int)this.jdField_b_of_type_Axci.d, (int)this.jdField_b_of_type_Axci.c - j / 2 - i, (int)this.jdField_b_of_type_Axci.d) }) });
    localaxbm.a(paramaxbf);
  }
  
  public void a(axbz paramaxbz)
  {
    this.jdField_a_of_type_Axci.e = 0.0F;
    this.jdField_b_of_type_Axci.e = 0.0F;
    int i = this.jdField_a_of_type_Axci.d();
    int j = i / 10;
    this.jdField_a_of_type_Axci.a(this.jdField_a_of_type_Int / 2 - i, this.d);
    this.jdField_b_of_type_Axci.a(this.jdField_a_of_type_Int / 2 + i, this.d);
    this.jdField_a_of_type_ArrayOfAxci[0].a(this.jdField_a_of_type_Int / 2 - i, this.d - j * 2);
    this.jdField_a_of_type_ArrayOfAxci[1].a(this.jdField_a_of_type_Int / 2 - i, this.d - j);
    this.jdField_a_of_type_ArrayOfAxci[2].a(this.jdField_a_of_type_Int / 2 - i, this.d);
    this.jdField_a_of_type_ArrayOfAxci[3].a(this.jdField_a_of_type_Int / 2 - i * 6 / 5, this.d + j);
    this.jdField_a_of_type_ArrayOfAxci[4].a(this.jdField_a_of_type_Int / 2 - i * 6 / 5, this.d + j * 2);
    this.jdField_a_of_type_ArrayOfAxci[5].a(this.jdField_a_of_type_Int / 2 - i, j * 2 + this.d);
    this.jdField_a_of_type_Axci.a(new axbe[] { new axbn(new axbe[] { new axbm(200, 0.0F, 1.05F), new axbm(150, 1.05F, 1.0F) }) });
    this.jdField_b_of_type_Axci.a(new axbe[] { new axbn(new axbe[] { new axbg(200), new axbm(200, 0.0F, 1.05F), new axbm(150, 1.05F, 1.0F) }) });
    float f = 9.0F / (this.jdField_b_of_type_Axci.c - this.jdField_a_of_type_Axci.c);
    axbn localaxbn1 = new axbn(new axbe[] { new axbg(500), new axbh(600, (int)this.jdField_a_of_type_ArrayOfAxci[0].c, (int)this.jdField_a_of_type_ArrayOfAxci[0].d, (int)this.jdField_b_of_type_Axci.c, i / 20, f) });
    axbn localaxbn2 = new axbn(new axbe[] { new axbg(700), new axbh(600, (int)this.jdField_a_of_type_ArrayOfAxci[1].c, (int)this.jdField_a_of_type_ArrayOfAxci[1].d, (int)this.jdField_b_of_type_Axci.c, i / 20, f) });
    axbn localaxbn3 = new axbn(new axbe[] { new axbg(600), new axbh(600, (int)this.jdField_a_of_type_ArrayOfAxci[2].c, (int)this.jdField_a_of_type_ArrayOfAxci[2].d, (int)this.jdField_b_of_type_Axci.c, i / 20, f) });
    axbn localaxbn4 = new axbn(new axbe[] { new axbg(900), new axbh(600, (int)this.jdField_a_of_type_ArrayOfAxci[3].c, (int)this.jdField_a_of_type_ArrayOfAxci[3].d, (int)this.jdField_b_of_type_Axci.c, i / 20, f * 0.6F) });
    axbn localaxbn5 = new axbn(new axbe[] { new axbg(800), new axbh(600, (int)this.jdField_a_of_type_ArrayOfAxci[4].c, (int)this.jdField_a_of_type_ArrayOfAxci[4].d, (int)this.jdField_b_of_type_Axci.c, i / 20, f * 0.6F) });
    axbn localaxbn6 = new axbn(new axbe[] { new axbg(1000), new axbh(600, (int)this.jdField_a_of_type_ArrayOfAxci[5].c, (int)this.jdField_a_of_type_ArrayOfAxci[5].d, (int)this.jdField_b_of_type_Axci.c, i / 20, f) });
    i = 0;
    while (i < this.jdField_a_of_type_ArrayOfAxci.length)
    {
      this.jdField_a_of_type_ArrayOfAxci[i].e = 0.0F;
      this.jdField_a_of_type_ArrayOfAxci[i].jdField_a_of_type_Int = 255;
      this.jdField_a_of_type_ArrayOfAxci[i].a(new axbe[] { new axbe[] { localaxbn1, localaxbn2, localaxbn3, localaxbn4, localaxbn5, localaxbn6 }[i], new axbn(new axbe[] { new axbg(1300), new axbk(300, 255, 0) }) });
      i += 1;
    }
    if ((this.c != null) && ((this.c instanceof axby)))
    {
      ((axby)this.c).a = new azqp(this, paramaxbz);
      ((axby)this.c).a(getContext(), this);
    }
    while (a())
    {
      a(this.c);
      a(this.jdField_a_of_type_Axci);
      a(this.jdField_b_of_type_Axci);
      i = 0;
      while (i < this.jdField_a_of_type_ArrayOfAxci.length)
      {
        a(this.jdField_a_of_type_ArrayOfAxci[i]);
        i += 1;
      }
      if ((this.c != null) && ((this.c instanceof VideoSprite))) {
        ((VideoSprite)this.c).a(new azqr(this, paramaxbz));
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
    if ((paramBitmap != null) && (this.jdField_b_of_type_Axci != null)) {
      this.jdField_b_of_type_Axci.a(this, a(paramBitmap.copy(Bitmap.Config.ARGB_8888, false), azvv.a(getContext(), 70.0F), azvv.a(getContext(), 70.0F)));
    }
  }
  
  public void setResourceWithFps(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, String paramString, int paramInt1, int paramInt2)
  {
    this.c = new VideoSprite(this, getContext(), true);
    ((VideoSprite)this.c).c(paramString);
    this.c.c = (paramInt1 / 2);
    this.c.d = (paramInt2 / 2);
    a(this.c);
    this.jdField_a_of_type_Axci = new axci();
    a(this.jdField_a_of_type_Axci);
    this.jdField_b_of_type_Axci = new axci();
    a(this.jdField_b_of_type_Axci);
    this.jdField_a_of_type_Axci.e = 0.0F;
    this.jdField_b_of_type_Axci.e = 0.0F;
    this.jdField_a_of_type_ArrayOfAxci = new axci[6];
    paramInt1 = 0;
    while (paramInt1 < 6)
    {
      this.jdField_a_of_type_ArrayOfAxci[paramInt1] = new axci();
      this.jdField_a_of_type_ArrayOfAxci[paramInt1].e = 0.0F;
      a(this.jdField_a_of_type_ArrayOfAxci[paramInt1]);
      paramInt1 += 1;
    }
    if (paramBitmap1 != null) {
      this.jdField_a_of_type_Axci.a(this, a(paramBitmap1.copy(Bitmap.Config.ARGB_8888, false), azvv.a(getContext(), 70.0F), azvv.a(getContext(), 70.0F)));
    }
    if (paramBitmap2 != null) {
      this.jdField_b_of_type_Axci.a(this, a(paramBitmap2.copy(Bitmap.Config.ARGB_8888, false), azvv.a(getContext(), 70.0F), azvv.a(getContext(), 70.0F)));
    }
    paramBitmap1 = new axcl(this, paramBitmap3);
    paramInt1 = 0;
    while (paramInt1 < 6)
    {
      this.jdField_a_of_type_ArrayOfAxci[paramInt1].a(paramBitmap1);
      paramInt1 += 1;
    }
  }
  
  public void setResourceWithFps(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, String[] paramArrayOfString, int paramInt)
  {
    this.c = new axby(this, paramArrayOfString);
    ((axby)this.c).e(paramInt);
    a(this.c);
    this.jdField_a_of_type_Axci = new axci();
    a(this.jdField_a_of_type_Axci);
    this.jdField_b_of_type_Axci = new axci();
    a(this.jdField_b_of_type_Axci);
    this.jdField_a_of_type_Axci.e = 0.0F;
    this.jdField_b_of_type_Axci.e = 0.0F;
    this.jdField_a_of_type_ArrayOfAxci = new axci[6];
    paramInt = 0;
    while (paramInt < 6)
    {
      this.jdField_a_of_type_ArrayOfAxci[paramInt] = new axci();
      this.jdField_a_of_type_ArrayOfAxci[paramInt].e = 0.0F;
      a(this.jdField_a_of_type_ArrayOfAxci[paramInt]);
      paramInt += 1;
    }
    if (paramBitmap1 != null) {
      this.jdField_a_of_type_Axci.a(this, a(paramBitmap1.copy(Bitmap.Config.ARGB_8888, false), azvv.a(getContext(), 70.0F), azvv.a(getContext(), 70.0F)));
    }
    if (paramBitmap2 != null) {
      this.jdField_b_of_type_Axci.a(this, a(paramBitmap2.copy(Bitmap.Config.ARGB_8888, false), azvv.a(getContext(), 70.0F), azvv.a(getContext(), 70.0F)));
    }
    paramBitmap1 = new axcl(this, paramBitmap3);
    paramInt = 0;
    while (paramInt < 6)
    {
      this.jdField_a_of_type_ArrayOfAxci[paramInt].a(paramBitmap1);
      paramInt += 1;
    }
  }
  
  public void setSendHeadBitmap(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (this.jdField_a_of_type_Axci != null)) {
      this.jdField_a_of_type_Axci.a(this, a(paramBitmap.copy(Bitmap.Config.ARGB_8888, false), azvv.a(getContext(), 70.0F), azvv.a(getContext(), 70.0F)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopGiftToPersonalSurfaceView
 * JD-Core Version:    0.7.0.1
 */
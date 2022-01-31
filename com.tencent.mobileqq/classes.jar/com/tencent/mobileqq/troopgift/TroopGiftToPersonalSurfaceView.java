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
import azzf;
import azzg;
import azzh;
import azzi;
import azzj;
import azzl;
import azzn;
import azzo;
import azzz;
import baaa;
import baaj;
import baam;
import bcrb;
import bcrd;
import bcwh;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite;

public class TroopGiftToPersonalSurfaceView
  extends SpriteGLView
{
  protected int a;
  private baaj jdField_a_of_type_Baaj;
  private baaj[] jdField_a_of_type_ArrayOfBaaj;
  protected int b;
  private baaj b;
  private baaj c;
  private int d;
  
  public TroopGiftToPersonalSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int i = bcwh.a(getContext(), 4.0F);
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
      paramBitmap.setStrokeWidth(bcwh.a(getContext(), 1.0F));
      localCanvas.drawCircle(localBitmap1.getWidth() / 2, localBitmap1.getHeight() / 2, localBitmap1.getWidth() / 2, paramBitmap);
      localBitmap2.recycle();
      return localBitmap1;
    }
    catch (OutOfMemoryError paramBitmap) {}
    return null;
  }
  
  public void a(int paramInt, azzg paramazzg)
  {
    int i = this.jdField_a_of_type_Baaj.d();
    int j = (int)(i * 0.15F);
    this.jdField_a_of_type_Baaj.a(new azzf[] { new azzo(new azzf[] { new azzh(paramInt), new azzn(200, 1.0F, 1.05F), new azzn(200, 1.05F, 0.0F) }), new azzo(new azzf[] { new azzh(paramInt), new azzj(200, (int)this.jdField_a_of_type_Baaj.c, (int)this.jdField_a_of_type_Baaj.d, (int)this.jdField_a_of_type_Baaj.c - j / 2, (int)this.jdField_a_of_type_Baaj.d), new azzj(200, (int)this.jdField_a_of_type_Baaj.c, (int)this.jdField_a_of_type_Baaj.d, (int)this.jdField_a_of_type_Baaj.c + j / 2 + i, (int)this.jdField_a_of_type_Baaj.d) }) });
    if (this.jdField_b_of_type_Baaj.a() == null)
    {
      if (paramazzg != null) {
        paramazzg.a();
      }
      return;
    }
    azzn localazzn = new azzn(200, 1.05F, 0.0F);
    this.jdField_b_of_type_Baaj.a(new azzf[] { new azzo(new azzf[] { new azzh(paramInt), new azzn(200, 1.0F, 1.05F), localazzn }), new azzo(new azzf[] { new azzj(200, (int)this.jdField_b_of_type_Baaj.c, (int)this.jdField_b_of_type_Baaj.d, (int)this.jdField_b_of_type_Baaj.c + j / 2, (int)this.jdField_b_of_type_Baaj.d), new azzj(200, (int)this.jdField_b_of_type_Baaj.c, (int)this.jdField_b_of_type_Baaj.d, (int)this.jdField_b_of_type_Baaj.c - j / 2 - i, (int)this.jdField_b_of_type_Baaj.d) }) });
    localazzn.a(paramazzg);
  }
  
  public void a(baaa parambaaa)
  {
    this.jdField_a_of_type_Baaj.e = 0.0F;
    this.jdField_b_of_type_Baaj.e = 0.0F;
    int i = this.jdField_a_of_type_Baaj.d();
    int j = i / 10;
    this.jdField_a_of_type_Baaj.a(this.jdField_a_of_type_Int / 2 - i, this.d);
    this.jdField_b_of_type_Baaj.a(this.jdField_a_of_type_Int / 2 + i, this.d);
    this.jdField_a_of_type_ArrayOfBaaj[0].a(this.jdField_a_of_type_Int / 2 - i, this.d - j * 2);
    this.jdField_a_of_type_ArrayOfBaaj[1].a(this.jdField_a_of_type_Int / 2 - i, this.d - j);
    this.jdField_a_of_type_ArrayOfBaaj[2].a(this.jdField_a_of_type_Int / 2 - i, this.d);
    this.jdField_a_of_type_ArrayOfBaaj[3].a(this.jdField_a_of_type_Int / 2 - i * 6 / 5, this.d + j);
    this.jdField_a_of_type_ArrayOfBaaj[4].a(this.jdField_a_of_type_Int / 2 - i * 6 / 5, this.d + j * 2);
    this.jdField_a_of_type_ArrayOfBaaj[5].a(this.jdField_a_of_type_Int / 2 - i, j * 2 + this.d);
    this.jdField_a_of_type_Baaj.a(new azzf[] { new azzo(new azzf[] { new azzn(200, 0.0F, 1.05F), new azzn(150, 1.05F, 1.0F) }) });
    this.jdField_b_of_type_Baaj.a(new azzf[] { new azzo(new azzf[] { new azzh(200), new azzn(200, 0.0F, 1.05F), new azzn(150, 1.05F, 1.0F) }) });
    float f = 9.0F / (this.jdField_b_of_type_Baaj.c - this.jdField_a_of_type_Baaj.c);
    azzo localazzo1 = new azzo(new azzf[] { new azzh(500), new azzi(600, (int)this.jdField_a_of_type_ArrayOfBaaj[0].c, (int)this.jdField_a_of_type_ArrayOfBaaj[0].d, (int)this.jdField_b_of_type_Baaj.c, i / 20, f) });
    azzo localazzo2 = new azzo(new azzf[] { new azzh(700), new azzi(600, (int)this.jdField_a_of_type_ArrayOfBaaj[1].c, (int)this.jdField_a_of_type_ArrayOfBaaj[1].d, (int)this.jdField_b_of_type_Baaj.c, i / 20, f) });
    azzo localazzo3 = new azzo(new azzf[] { new azzh(600), new azzi(600, (int)this.jdField_a_of_type_ArrayOfBaaj[2].c, (int)this.jdField_a_of_type_ArrayOfBaaj[2].d, (int)this.jdField_b_of_type_Baaj.c, i / 20, f) });
    azzo localazzo4 = new azzo(new azzf[] { new azzh(900), new azzi(600, (int)this.jdField_a_of_type_ArrayOfBaaj[3].c, (int)this.jdField_a_of_type_ArrayOfBaaj[3].d, (int)this.jdField_b_of_type_Baaj.c, i / 20, f * 0.6F) });
    azzo localazzo5 = new azzo(new azzf[] { new azzh(800), new azzi(600, (int)this.jdField_a_of_type_ArrayOfBaaj[4].c, (int)this.jdField_a_of_type_ArrayOfBaaj[4].d, (int)this.jdField_b_of_type_Baaj.c, i / 20, f * 0.6F) });
    azzo localazzo6 = new azzo(new azzf[] { new azzh(1000), new azzi(600, (int)this.jdField_a_of_type_ArrayOfBaaj[5].c, (int)this.jdField_a_of_type_ArrayOfBaaj[5].d, (int)this.jdField_b_of_type_Baaj.c, i / 20, f) });
    i = 0;
    while (i < this.jdField_a_of_type_ArrayOfBaaj.length)
    {
      this.jdField_a_of_type_ArrayOfBaaj[i].e = 0.0F;
      this.jdField_a_of_type_ArrayOfBaaj[i].jdField_a_of_type_Int = 255;
      this.jdField_a_of_type_ArrayOfBaaj[i].a(new azzf[] { new azzf[] { localazzo1, localazzo2, localazzo3, localazzo4, localazzo5, localazzo6 }[i], new azzo(new azzf[] { new azzh(1300), new azzl(300, 255, 0) }) });
      i += 1;
    }
    if ((this.c != null) && ((this.c instanceof azzz)))
    {
      ((azzz)this.c).a = new bcrb(this, parambaaa);
      ((azzz)this.c).a(getContext(), this);
    }
    while (a())
    {
      a(this.c);
      a(this.jdField_a_of_type_Baaj);
      a(this.jdField_b_of_type_Baaj);
      i = 0;
      while (i < this.jdField_a_of_type_ArrayOfBaaj.length)
      {
        a(this.jdField_a_of_type_ArrayOfBaaj[i]);
        i += 1;
      }
      if ((this.c != null) && ((this.c instanceof VideoSprite))) {
        ((VideoSprite)this.c).a(new bcrd(this, parambaaa));
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
    if ((paramBitmap != null) && (this.jdField_b_of_type_Baaj != null)) {
      this.jdField_b_of_type_Baaj.a(this, a(paramBitmap.copy(Bitmap.Config.ARGB_8888, false), bcwh.a(getContext(), 70.0F), bcwh.a(getContext(), 70.0F)));
    }
  }
  
  public void setResourceWithFps(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, String paramString, int paramInt1, int paramInt2)
  {
    this.c = new VideoSprite(this, getContext(), true);
    ((VideoSprite)this.c).c(paramString);
    this.c.c = (paramInt1 / 2);
    this.c.d = (paramInt2 / 2);
    a(this.c);
    this.jdField_a_of_type_Baaj = new baaj();
    a(this.jdField_a_of_type_Baaj);
    this.jdField_b_of_type_Baaj = new baaj();
    a(this.jdField_b_of_type_Baaj);
    this.jdField_a_of_type_Baaj.e = 0.0F;
    this.jdField_b_of_type_Baaj.e = 0.0F;
    this.jdField_a_of_type_ArrayOfBaaj = new baaj[6];
    paramInt1 = 0;
    while (paramInt1 < 6)
    {
      this.jdField_a_of_type_ArrayOfBaaj[paramInt1] = new baaj();
      this.jdField_a_of_type_ArrayOfBaaj[paramInt1].e = 0.0F;
      a(this.jdField_a_of_type_ArrayOfBaaj[paramInt1]);
      paramInt1 += 1;
    }
    if (paramBitmap1 != null) {
      this.jdField_a_of_type_Baaj.a(this, a(paramBitmap1.copy(Bitmap.Config.ARGB_8888, false), bcwh.a(getContext(), 70.0F), bcwh.a(getContext(), 70.0F)));
    }
    if (paramBitmap2 != null) {
      this.jdField_b_of_type_Baaj.a(this, a(paramBitmap2.copy(Bitmap.Config.ARGB_8888, false), bcwh.a(getContext(), 70.0F), bcwh.a(getContext(), 70.0F)));
    }
    paramBitmap1 = new baam(this, paramBitmap3);
    paramInt1 = 0;
    while (paramInt1 < 6)
    {
      this.jdField_a_of_type_ArrayOfBaaj[paramInt1].a(paramBitmap1);
      paramInt1 += 1;
    }
  }
  
  public void setResourceWithFps(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, String[] paramArrayOfString, int paramInt)
  {
    this.c = new azzz(this, paramArrayOfString);
    ((azzz)this.c).e(paramInt);
    a(this.c);
    this.jdField_a_of_type_Baaj = new baaj();
    a(this.jdField_a_of_type_Baaj);
    this.jdField_b_of_type_Baaj = new baaj();
    a(this.jdField_b_of_type_Baaj);
    this.jdField_a_of_type_Baaj.e = 0.0F;
    this.jdField_b_of_type_Baaj.e = 0.0F;
    this.jdField_a_of_type_ArrayOfBaaj = new baaj[6];
    paramInt = 0;
    while (paramInt < 6)
    {
      this.jdField_a_of_type_ArrayOfBaaj[paramInt] = new baaj();
      this.jdField_a_of_type_ArrayOfBaaj[paramInt].e = 0.0F;
      a(this.jdField_a_of_type_ArrayOfBaaj[paramInt]);
      paramInt += 1;
    }
    if (paramBitmap1 != null) {
      this.jdField_a_of_type_Baaj.a(this, a(paramBitmap1.copy(Bitmap.Config.ARGB_8888, false), bcwh.a(getContext(), 70.0F), bcwh.a(getContext(), 70.0F)));
    }
    if (paramBitmap2 != null) {
      this.jdField_b_of_type_Baaj.a(this, a(paramBitmap2.copy(Bitmap.Config.ARGB_8888, false), bcwh.a(getContext(), 70.0F), bcwh.a(getContext(), 70.0F)));
    }
    paramBitmap1 = new baam(this, paramBitmap3);
    paramInt = 0;
    while (paramInt < 6)
    {
      this.jdField_a_of_type_ArrayOfBaaj[paramInt].a(paramBitmap1);
      paramInt += 1;
    }
  }
  
  public void setSendHeadBitmap(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (this.jdField_a_of_type_Baaj != null)) {
      this.jdField_a_of_type_Baaj.a(this, a(paramBitmap.copy(Bitmap.Config.ARGB_8888, false), bcwh.a(getContext(), 70.0F), bcwh.a(getContext(), 70.0F)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopGiftToPersonalSurfaceView
 * JD-Core Version:    0.7.0.1
 */
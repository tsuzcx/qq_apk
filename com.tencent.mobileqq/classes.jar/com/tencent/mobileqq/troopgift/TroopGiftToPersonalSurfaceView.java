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
import aybg;
import aybh;
import aybi;
import aybj;
import aybk;
import aybm;
import aybo;
import aybp;
import ayca;
import aycb;
import ayck;
import aycn;
import bart;
import barv;
import bawz;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite;

public class TroopGiftToPersonalSurfaceView
  extends SpriteGLView
{
  protected int a;
  private ayck jdField_a_of_type_Ayck;
  private ayck[] jdField_a_of_type_ArrayOfAyck;
  protected int b;
  private ayck b;
  private ayck c;
  private int d;
  
  public TroopGiftToPersonalSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int i = bawz.a(getContext(), 4.0F);
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
      paramBitmap.setStrokeWidth(bawz.a(getContext(), 1.0F));
      localCanvas.drawCircle(localBitmap1.getWidth() / 2, localBitmap1.getHeight() / 2, localBitmap1.getWidth() / 2, paramBitmap);
      localBitmap2.recycle();
      return localBitmap1;
    }
    catch (OutOfMemoryError paramBitmap) {}
    return null;
  }
  
  public void a(int paramInt, aybh paramaybh)
  {
    int i = this.jdField_a_of_type_Ayck.d();
    int j = (int)(i * 0.15F);
    this.jdField_a_of_type_Ayck.a(new aybg[] { new aybp(new aybg[] { new aybi(paramInt), new aybo(200, 1.0F, 1.05F), new aybo(200, 1.05F, 0.0F) }), new aybp(new aybg[] { new aybi(paramInt), new aybk(200, (int)this.jdField_a_of_type_Ayck.c, (int)this.jdField_a_of_type_Ayck.d, (int)this.jdField_a_of_type_Ayck.c - j / 2, (int)this.jdField_a_of_type_Ayck.d), new aybk(200, (int)this.jdField_a_of_type_Ayck.c, (int)this.jdField_a_of_type_Ayck.d, (int)this.jdField_a_of_type_Ayck.c + j / 2 + i, (int)this.jdField_a_of_type_Ayck.d) }) });
    if (this.jdField_b_of_type_Ayck.a() == null)
    {
      if (paramaybh != null) {
        paramaybh.a();
      }
      return;
    }
    aybo localaybo = new aybo(200, 1.05F, 0.0F);
    this.jdField_b_of_type_Ayck.a(new aybg[] { new aybp(new aybg[] { new aybi(paramInt), new aybo(200, 1.0F, 1.05F), localaybo }), new aybp(new aybg[] { new aybk(200, (int)this.jdField_b_of_type_Ayck.c, (int)this.jdField_b_of_type_Ayck.d, (int)this.jdField_b_of_type_Ayck.c + j / 2, (int)this.jdField_b_of_type_Ayck.d), new aybk(200, (int)this.jdField_b_of_type_Ayck.c, (int)this.jdField_b_of_type_Ayck.d, (int)this.jdField_b_of_type_Ayck.c - j / 2 - i, (int)this.jdField_b_of_type_Ayck.d) }) });
    localaybo.a(paramaybh);
  }
  
  public void a(aycb paramaycb)
  {
    this.jdField_a_of_type_Ayck.e = 0.0F;
    this.jdField_b_of_type_Ayck.e = 0.0F;
    int i = this.jdField_a_of_type_Ayck.d();
    int j = i / 10;
    this.jdField_a_of_type_Ayck.a(this.jdField_a_of_type_Int / 2 - i, this.d);
    this.jdField_b_of_type_Ayck.a(this.jdField_a_of_type_Int / 2 + i, this.d);
    this.jdField_a_of_type_ArrayOfAyck[0].a(this.jdField_a_of_type_Int / 2 - i, this.d - j * 2);
    this.jdField_a_of_type_ArrayOfAyck[1].a(this.jdField_a_of_type_Int / 2 - i, this.d - j);
    this.jdField_a_of_type_ArrayOfAyck[2].a(this.jdField_a_of_type_Int / 2 - i, this.d);
    this.jdField_a_of_type_ArrayOfAyck[3].a(this.jdField_a_of_type_Int / 2 - i * 6 / 5, this.d + j);
    this.jdField_a_of_type_ArrayOfAyck[4].a(this.jdField_a_of_type_Int / 2 - i * 6 / 5, this.d + j * 2);
    this.jdField_a_of_type_ArrayOfAyck[5].a(this.jdField_a_of_type_Int / 2 - i, j * 2 + this.d);
    this.jdField_a_of_type_Ayck.a(new aybg[] { new aybp(new aybg[] { new aybo(200, 0.0F, 1.05F), new aybo(150, 1.05F, 1.0F) }) });
    this.jdField_b_of_type_Ayck.a(new aybg[] { new aybp(new aybg[] { new aybi(200), new aybo(200, 0.0F, 1.05F), new aybo(150, 1.05F, 1.0F) }) });
    float f = 9.0F / (this.jdField_b_of_type_Ayck.c - this.jdField_a_of_type_Ayck.c);
    aybp localaybp1 = new aybp(new aybg[] { new aybi(500), new aybj(600, (int)this.jdField_a_of_type_ArrayOfAyck[0].c, (int)this.jdField_a_of_type_ArrayOfAyck[0].d, (int)this.jdField_b_of_type_Ayck.c, i / 20, f) });
    aybp localaybp2 = new aybp(new aybg[] { new aybi(700), new aybj(600, (int)this.jdField_a_of_type_ArrayOfAyck[1].c, (int)this.jdField_a_of_type_ArrayOfAyck[1].d, (int)this.jdField_b_of_type_Ayck.c, i / 20, f) });
    aybp localaybp3 = new aybp(new aybg[] { new aybi(600), new aybj(600, (int)this.jdField_a_of_type_ArrayOfAyck[2].c, (int)this.jdField_a_of_type_ArrayOfAyck[2].d, (int)this.jdField_b_of_type_Ayck.c, i / 20, f) });
    aybp localaybp4 = new aybp(new aybg[] { new aybi(900), new aybj(600, (int)this.jdField_a_of_type_ArrayOfAyck[3].c, (int)this.jdField_a_of_type_ArrayOfAyck[3].d, (int)this.jdField_b_of_type_Ayck.c, i / 20, f * 0.6F) });
    aybp localaybp5 = new aybp(new aybg[] { new aybi(800), new aybj(600, (int)this.jdField_a_of_type_ArrayOfAyck[4].c, (int)this.jdField_a_of_type_ArrayOfAyck[4].d, (int)this.jdField_b_of_type_Ayck.c, i / 20, f * 0.6F) });
    aybp localaybp6 = new aybp(new aybg[] { new aybi(1000), new aybj(600, (int)this.jdField_a_of_type_ArrayOfAyck[5].c, (int)this.jdField_a_of_type_ArrayOfAyck[5].d, (int)this.jdField_b_of_type_Ayck.c, i / 20, f) });
    i = 0;
    while (i < this.jdField_a_of_type_ArrayOfAyck.length)
    {
      this.jdField_a_of_type_ArrayOfAyck[i].e = 0.0F;
      this.jdField_a_of_type_ArrayOfAyck[i].jdField_a_of_type_Int = 255;
      this.jdField_a_of_type_ArrayOfAyck[i].a(new aybg[] { new aybg[] { localaybp1, localaybp2, localaybp3, localaybp4, localaybp5, localaybp6 }[i], new aybp(new aybg[] { new aybi(1300), new aybm(300, 255, 0) }) });
      i += 1;
    }
    if ((this.c != null) && ((this.c instanceof ayca)))
    {
      ((ayca)this.c).a = new bart(this, paramaycb);
      ((ayca)this.c).a(getContext(), this);
    }
    while (a())
    {
      a(this.c);
      a(this.jdField_a_of_type_Ayck);
      a(this.jdField_b_of_type_Ayck);
      i = 0;
      while (i < this.jdField_a_of_type_ArrayOfAyck.length)
      {
        a(this.jdField_a_of_type_ArrayOfAyck[i]);
        i += 1;
      }
      if ((this.c != null) && ((this.c instanceof VideoSprite))) {
        ((VideoSprite)this.c).a(new barv(this, paramaycb));
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
    if ((paramBitmap != null) && (this.jdField_b_of_type_Ayck != null)) {
      this.jdField_b_of_type_Ayck.a(this, a(paramBitmap.copy(Bitmap.Config.ARGB_8888, false), bawz.a(getContext(), 70.0F), bawz.a(getContext(), 70.0F)));
    }
  }
  
  public void setResourceWithFps(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, String paramString, int paramInt1, int paramInt2)
  {
    this.c = new VideoSprite(this, getContext(), true);
    ((VideoSprite)this.c).c(paramString);
    this.c.c = (paramInt1 / 2);
    this.c.d = (paramInt2 / 2);
    a(this.c);
    this.jdField_a_of_type_Ayck = new ayck();
    a(this.jdField_a_of_type_Ayck);
    this.jdField_b_of_type_Ayck = new ayck();
    a(this.jdField_b_of_type_Ayck);
    this.jdField_a_of_type_Ayck.e = 0.0F;
    this.jdField_b_of_type_Ayck.e = 0.0F;
    this.jdField_a_of_type_ArrayOfAyck = new ayck[6];
    paramInt1 = 0;
    while (paramInt1 < 6)
    {
      this.jdField_a_of_type_ArrayOfAyck[paramInt1] = new ayck();
      this.jdField_a_of_type_ArrayOfAyck[paramInt1].e = 0.0F;
      a(this.jdField_a_of_type_ArrayOfAyck[paramInt1]);
      paramInt1 += 1;
    }
    if (paramBitmap1 != null) {
      this.jdField_a_of_type_Ayck.a(this, a(paramBitmap1.copy(Bitmap.Config.ARGB_8888, false), bawz.a(getContext(), 70.0F), bawz.a(getContext(), 70.0F)));
    }
    if (paramBitmap2 != null) {
      this.jdField_b_of_type_Ayck.a(this, a(paramBitmap2.copy(Bitmap.Config.ARGB_8888, false), bawz.a(getContext(), 70.0F), bawz.a(getContext(), 70.0F)));
    }
    paramBitmap1 = new aycn(this, paramBitmap3);
    paramInt1 = 0;
    while (paramInt1 < 6)
    {
      this.jdField_a_of_type_ArrayOfAyck[paramInt1].a(paramBitmap1);
      paramInt1 += 1;
    }
  }
  
  public void setResourceWithFps(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, String[] paramArrayOfString, int paramInt)
  {
    this.c = new ayca(this, paramArrayOfString);
    ((ayca)this.c).e(paramInt);
    a(this.c);
    this.jdField_a_of_type_Ayck = new ayck();
    a(this.jdField_a_of_type_Ayck);
    this.jdField_b_of_type_Ayck = new ayck();
    a(this.jdField_b_of_type_Ayck);
    this.jdField_a_of_type_Ayck.e = 0.0F;
    this.jdField_b_of_type_Ayck.e = 0.0F;
    this.jdField_a_of_type_ArrayOfAyck = new ayck[6];
    paramInt = 0;
    while (paramInt < 6)
    {
      this.jdField_a_of_type_ArrayOfAyck[paramInt] = new ayck();
      this.jdField_a_of_type_ArrayOfAyck[paramInt].e = 0.0F;
      a(this.jdField_a_of_type_ArrayOfAyck[paramInt]);
      paramInt += 1;
    }
    if (paramBitmap1 != null) {
      this.jdField_a_of_type_Ayck.a(this, a(paramBitmap1.copy(Bitmap.Config.ARGB_8888, false), bawz.a(getContext(), 70.0F), bawz.a(getContext(), 70.0F)));
    }
    if (paramBitmap2 != null) {
      this.jdField_b_of_type_Ayck.a(this, a(paramBitmap2.copy(Bitmap.Config.ARGB_8888, false), bawz.a(getContext(), 70.0F), bawz.a(getContext(), 70.0F)));
    }
    paramBitmap1 = new aycn(this, paramBitmap3);
    paramInt = 0;
    while (paramInt < 6)
    {
      this.jdField_a_of_type_ArrayOfAyck[paramInt].a(paramBitmap1);
      paramInt += 1;
    }
  }
  
  public void setSendHeadBitmap(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (this.jdField_a_of_type_Ayck != null)) {
      this.jdField_a_of_type_Ayck.a(this, a(paramBitmap.copy(Bitmap.Config.ARGB_8888, false), bawz.a(getContext(), 70.0F), bawz.a(getContext(), 70.0F)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopGiftToPersonalSurfaceView
 * JD-Core Version:    0.7.0.1
 */
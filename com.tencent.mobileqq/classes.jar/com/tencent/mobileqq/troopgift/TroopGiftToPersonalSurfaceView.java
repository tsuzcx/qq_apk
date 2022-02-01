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
import bdyd;
import bdye;
import bdyf;
import bdyg;
import bdyh;
import bdyj;
import bdyl;
import bdym;
import bdyx;
import bdyy;
import bdzh;
import bdzk;
import bgrz;
import bgsb;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite;
import com.tencent.mobileqq.util.DisplayUtil;

public class TroopGiftToPersonalSurfaceView
  extends SpriteGLView
{
  protected int a;
  private bdzh jdField_a_of_type_Bdzh;
  private bdzh[] jdField_a_of_type_ArrayOfBdzh;
  protected int b;
  private bdzh b;
  private bdzh c;
  private int d;
  
  public TroopGiftToPersonalSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int i = DisplayUtil.dip2px(getContext(), 4.0F);
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
      paramBitmap.setStrokeWidth(DisplayUtil.dip2px(getContext(), 1.0F));
      localCanvas.drawCircle(localBitmap1.getWidth() / 2, localBitmap1.getHeight() / 2, localBitmap1.getWidth() / 2, paramBitmap);
      localBitmap2.recycle();
      return localBitmap1;
    }
    catch (OutOfMemoryError paramBitmap) {}
    return null;
  }
  
  public void a(int paramInt, bdye parambdye)
  {
    int i = this.jdField_a_of_type_Bdzh.d();
    int j = (int)(i * 0.15F);
    this.jdField_a_of_type_Bdzh.a(new bdyd[] { new bdym(new bdyd[] { new bdyf(paramInt), new bdyl(200, 1.0F, 1.05F), new bdyl(200, 1.05F, 0.0F) }), new bdym(new bdyd[] { new bdyf(paramInt), new bdyh(200, (int)this.jdField_a_of_type_Bdzh.c, (int)this.jdField_a_of_type_Bdzh.d, (int)this.jdField_a_of_type_Bdzh.c - j / 2, (int)this.jdField_a_of_type_Bdzh.d), new bdyh(200, (int)this.jdField_a_of_type_Bdzh.c, (int)this.jdField_a_of_type_Bdzh.d, (int)this.jdField_a_of_type_Bdzh.c + j / 2 + i, (int)this.jdField_a_of_type_Bdzh.d) }) });
    if (this.jdField_b_of_type_Bdzh.a() == null)
    {
      if (parambdye != null) {
        parambdye.a();
      }
      return;
    }
    bdyl localbdyl = new bdyl(200, 1.05F, 0.0F);
    this.jdField_b_of_type_Bdzh.a(new bdyd[] { new bdym(new bdyd[] { new bdyf(paramInt), new bdyl(200, 1.0F, 1.05F), localbdyl }), new bdym(new bdyd[] { new bdyh(200, (int)this.jdField_b_of_type_Bdzh.c, (int)this.jdField_b_of_type_Bdzh.d, (int)this.jdField_b_of_type_Bdzh.c + j / 2, (int)this.jdField_b_of_type_Bdzh.d), new bdyh(200, (int)this.jdField_b_of_type_Bdzh.c, (int)this.jdField_b_of_type_Bdzh.d, (int)this.jdField_b_of_type_Bdzh.c - j / 2 - i, (int)this.jdField_b_of_type_Bdzh.d) }) });
    localbdyl.a(parambdye);
  }
  
  public void a(bdyy parambdyy)
  {
    this.jdField_a_of_type_Bdzh.e = 0.0F;
    this.jdField_b_of_type_Bdzh.e = 0.0F;
    int i = this.jdField_a_of_type_Bdzh.d();
    int j = i / 10;
    this.jdField_a_of_type_Bdzh.a(this.jdField_a_of_type_Int / 2 - i, this.d);
    this.jdField_b_of_type_Bdzh.a(this.jdField_a_of_type_Int / 2 + i, this.d);
    this.jdField_a_of_type_ArrayOfBdzh[0].a(this.jdField_a_of_type_Int / 2 - i, this.d - j * 2);
    this.jdField_a_of_type_ArrayOfBdzh[1].a(this.jdField_a_of_type_Int / 2 - i, this.d - j);
    this.jdField_a_of_type_ArrayOfBdzh[2].a(this.jdField_a_of_type_Int / 2 - i, this.d);
    this.jdField_a_of_type_ArrayOfBdzh[3].a(this.jdField_a_of_type_Int / 2 - i * 6 / 5, this.d + j);
    this.jdField_a_of_type_ArrayOfBdzh[4].a(this.jdField_a_of_type_Int / 2 - i * 6 / 5, this.d + j * 2);
    this.jdField_a_of_type_ArrayOfBdzh[5].a(this.jdField_a_of_type_Int / 2 - i, j * 2 + this.d);
    this.jdField_a_of_type_Bdzh.a(new bdyd[] { new bdym(new bdyd[] { new bdyl(200, 0.0F, 1.05F), new bdyl(150, 1.05F, 1.0F) }) });
    this.jdField_b_of_type_Bdzh.a(new bdyd[] { new bdym(new bdyd[] { new bdyf(200), new bdyl(200, 0.0F, 1.05F), new bdyl(150, 1.05F, 1.0F) }) });
    float f = 9.0F / (this.jdField_b_of_type_Bdzh.c - this.jdField_a_of_type_Bdzh.c);
    bdym localbdym1 = new bdym(new bdyd[] { new bdyf(500), new bdyg(600, (int)this.jdField_a_of_type_ArrayOfBdzh[0].c, (int)this.jdField_a_of_type_ArrayOfBdzh[0].d, (int)this.jdField_b_of_type_Bdzh.c, i / 20, f) });
    bdym localbdym2 = new bdym(new bdyd[] { new bdyf(700), new bdyg(600, (int)this.jdField_a_of_type_ArrayOfBdzh[1].c, (int)this.jdField_a_of_type_ArrayOfBdzh[1].d, (int)this.jdField_b_of_type_Bdzh.c, i / 20, f) });
    bdym localbdym3 = new bdym(new bdyd[] { new bdyf(600), new bdyg(600, (int)this.jdField_a_of_type_ArrayOfBdzh[2].c, (int)this.jdField_a_of_type_ArrayOfBdzh[2].d, (int)this.jdField_b_of_type_Bdzh.c, i / 20, f) });
    bdym localbdym4 = new bdym(new bdyd[] { new bdyf(900), new bdyg(600, (int)this.jdField_a_of_type_ArrayOfBdzh[3].c, (int)this.jdField_a_of_type_ArrayOfBdzh[3].d, (int)this.jdField_b_of_type_Bdzh.c, i / 20, f * 0.6F) });
    bdym localbdym5 = new bdym(new bdyd[] { new bdyf(800), new bdyg(600, (int)this.jdField_a_of_type_ArrayOfBdzh[4].c, (int)this.jdField_a_of_type_ArrayOfBdzh[4].d, (int)this.jdField_b_of_type_Bdzh.c, i / 20, f * 0.6F) });
    bdym localbdym6 = new bdym(new bdyd[] { new bdyf(1000), new bdyg(600, (int)this.jdField_a_of_type_ArrayOfBdzh[5].c, (int)this.jdField_a_of_type_ArrayOfBdzh[5].d, (int)this.jdField_b_of_type_Bdzh.c, i / 20, f) });
    i = 0;
    while (i < this.jdField_a_of_type_ArrayOfBdzh.length)
    {
      this.jdField_a_of_type_ArrayOfBdzh[i].e = 0.0F;
      this.jdField_a_of_type_ArrayOfBdzh[i].jdField_a_of_type_Int = 255;
      this.jdField_a_of_type_ArrayOfBdzh[i].a(new bdyd[] { new bdyd[] { localbdym1, localbdym2, localbdym3, localbdym4, localbdym5, localbdym6 }[i], new bdym(new bdyd[] { new bdyf(1300), new bdyj(300, 255, 0) }) });
      i += 1;
    }
    if ((this.c != null) && ((this.c instanceof bdyx)))
    {
      ((bdyx)this.c).a = new bgrz(this, parambdyy);
      ((bdyx)this.c).a(getContext(), this);
    }
    while (a())
    {
      a(this.c);
      a(this.jdField_a_of_type_Bdzh);
      a(this.jdField_b_of_type_Bdzh);
      i = 0;
      while (i < this.jdField_a_of_type_ArrayOfBdzh.length)
      {
        a(this.jdField_a_of_type_ArrayOfBdzh[i]);
        i += 1;
      }
      if ((this.c != null) && ((this.c instanceof VideoSprite))) {
        ((VideoSprite)this.c).a(new bgsb(this, parambdyy));
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
    if ((paramBitmap != null) && (this.jdField_b_of_type_Bdzh != null)) {
      this.jdField_b_of_type_Bdzh.a(this, a(paramBitmap.copy(Bitmap.Config.ARGB_8888, false), DisplayUtil.dip2px(getContext(), 70.0F), DisplayUtil.dip2px(getContext(), 70.0F)));
    }
  }
  
  public void setResourceWithFps(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, String paramString, int paramInt1, int paramInt2)
  {
    this.c = new VideoSprite(this, getContext(), true);
    ((VideoSprite)this.c).c(paramString);
    this.c.c = (paramInt1 / 2);
    this.c.d = (paramInt2 / 2);
    a(this.c);
    this.jdField_a_of_type_Bdzh = new bdzh();
    a(this.jdField_a_of_type_Bdzh);
    this.jdField_b_of_type_Bdzh = new bdzh();
    a(this.jdField_b_of_type_Bdzh);
    this.jdField_a_of_type_Bdzh.e = 0.0F;
    this.jdField_b_of_type_Bdzh.e = 0.0F;
    this.jdField_a_of_type_ArrayOfBdzh = new bdzh[6];
    paramInt1 = 0;
    while (paramInt1 < 6)
    {
      this.jdField_a_of_type_ArrayOfBdzh[paramInt1] = new bdzh();
      this.jdField_a_of_type_ArrayOfBdzh[paramInt1].e = 0.0F;
      a(this.jdField_a_of_type_ArrayOfBdzh[paramInt1]);
      paramInt1 += 1;
    }
    if (paramBitmap1 != null) {
      this.jdField_a_of_type_Bdzh.a(this, a(paramBitmap1.copy(Bitmap.Config.ARGB_8888, false), DisplayUtil.dip2px(getContext(), 70.0F), DisplayUtil.dip2px(getContext(), 70.0F)));
    }
    if (paramBitmap2 != null) {
      this.jdField_b_of_type_Bdzh.a(this, a(paramBitmap2.copy(Bitmap.Config.ARGB_8888, false), DisplayUtil.dip2px(getContext(), 70.0F), DisplayUtil.dip2px(getContext(), 70.0F)));
    }
    paramBitmap1 = new bdzk(this, paramBitmap3);
    paramInt1 = 0;
    while (paramInt1 < 6)
    {
      this.jdField_a_of_type_ArrayOfBdzh[paramInt1].a(paramBitmap1);
      paramInt1 += 1;
    }
  }
  
  public void setResourceWithFps(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, String[] paramArrayOfString, int paramInt)
  {
    this.c = new bdyx(this, paramArrayOfString);
    ((bdyx)this.c).e(paramInt);
    a(this.c);
    this.jdField_a_of_type_Bdzh = new bdzh();
    a(this.jdField_a_of_type_Bdzh);
    this.jdField_b_of_type_Bdzh = new bdzh();
    a(this.jdField_b_of_type_Bdzh);
    this.jdField_a_of_type_Bdzh.e = 0.0F;
    this.jdField_b_of_type_Bdzh.e = 0.0F;
    this.jdField_a_of_type_ArrayOfBdzh = new bdzh[6];
    paramInt = 0;
    while (paramInt < 6)
    {
      this.jdField_a_of_type_ArrayOfBdzh[paramInt] = new bdzh();
      this.jdField_a_of_type_ArrayOfBdzh[paramInt].e = 0.0F;
      a(this.jdField_a_of_type_ArrayOfBdzh[paramInt]);
      paramInt += 1;
    }
    if (paramBitmap1 != null) {
      this.jdField_a_of_type_Bdzh.a(this, a(paramBitmap1.copy(Bitmap.Config.ARGB_8888, false), DisplayUtil.dip2px(getContext(), 70.0F), DisplayUtil.dip2px(getContext(), 70.0F)));
    }
    if (paramBitmap2 != null) {
      this.jdField_b_of_type_Bdzh.a(this, a(paramBitmap2.copy(Bitmap.Config.ARGB_8888, false), DisplayUtil.dip2px(getContext(), 70.0F), DisplayUtil.dip2px(getContext(), 70.0F)));
    }
    paramBitmap1 = new bdzk(this, paramBitmap3);
    paramInt = 0;
    while (paramInt < 6)
    {
      this.jdField_a_of_type_ArrayOfBdzh[paramInt].a(paramBitmap1);
      paramInt += 1;
    }
  }
  
  public void setSendHeadBitmap(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (this.jdField_a_of_type_Bdzh != null)) {
      this.jdField_a_of_type_Bdzh.a(this, a(paramBitmap.copy(Bitmap.Config.ARGB_8888, false), DisplayUtil.dip2px(getContext(), 70.0F), DisplayUtil.dip2px(getContext(), 70.0F)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopGiftToPersonalSurfaceView
 * JD-Core Version:    0.7.0.1
 */
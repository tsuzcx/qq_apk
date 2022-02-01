package com.tencent.mobileqq.troopgift;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import bdyd;
import bdye;
import bdyf;
import bdyj;
import bdyl;
import bdym;
import bdyx;
import bdyy;
import bdzb;
import bdzc;
import bdzd;
import bdzh;
import bgrt;
import bgru;
import bgrv;
import bgrw;
import bgry;
import bhdz;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite;
import com.tencent.qphone.base.util.QLog;

public class TroopGiftToAllSurfaceView
  extends SpriteGLView
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private bdzb jdField_a_of_type_Bdzb;
  private bdzd jdField_a_of_type_Bdzd;
  private bdzh jdField_a_of_type_Bdzh;
  private bgry jdField_a_of_type_Bgry;
  private String jdField_a_of_type_JavaLangString;
  private bdzb jdField_b_of_type_Bdzb;
  private bdzh jdField_b_of_type_Bdzh;
  
  public TroopGiftToAllSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bdzb != null)
    {
      bdyj localbdyj = new bdyj(500, 255, 0);
      localbdyj.a(new bgrw(this));
      this.jdField_a_of_type_Bdzb.a(new bdyd[] { localbdyj });
    }
  }
  
  protected void a(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, bdzc parambdzc, bgry parambgry)
  {
    Bitmap localBitmap;
    Canvas localCanvas;
    Paint localPaint;
    float f1;
    int j;
    if ((!parambgry.jdField_a_of_type_Boolean) && (paramBitmap1 != null))
    {
      localBitmap = paramBitmap1.copy(Bitmap.Config.ARGB_8888, true);
      localCanvas = new Canvas(localBitmap);
      localPaint = new Paint();
      localPaint.setAntiAlias(true);
      localPaint.setColor(parambgry.g);
      localPaint.setTextSize(34.0F);
      paramBitmap1 = new Matrix();
      f1 = 140.0F / paramBitmap2.getWidth();
      paramBitmap1.postScale(f1, f1);
      paramBitmap1.postTranslate((localBitmap.getWidth() - f1 * paramBitmap2.getWidth()) / 2.0F, 154.0F);
      localCanvas.drawBitmap(paramBitmap2, paramBitmap1, localPaint);
      if ((!TextUtils.isEmpty(parambgry.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(parambgry.jdField_a_of_type_JavaLangString)))
      {
        float f2 = localPaint.measureText(parambgry.jdField_b_of_type_JavaLangString);
        f1 = 0.0F;
        j = 0;
        paramBitmap1 = parambgry.jdField_b_of_type_JavaLangString;
        int i = 0;
        while (i < parambgry.jdField_a_of_type_JavaLangString.length())
        {
          float f3 = localPaint.measureText("" + parambgry.jdField_a_of_type_JavaLangString.charAt(i));
          if (f1 + f3 + f2 > 475.0F) {
            break;
          }
          f1 += f3;
          j += 1;
          i += 1;
        }
        if (j <= 0) {
          break label577;
        }
        if (j != parambgry.jdField_a_of_type_JavaLangString.length()) {
          break label524;
        }
        paramBitmap1 = parambgry.jdField_a_of_type_JavaLangString + paramBitmap1;
      }
    }
    label524:
    label577:
    for (;;)
    {
      f1 = localPaint.measureText(paramBitmap1);
      localCanvas.drawText(paramBitmap1, localBitmap.getWidth() / 2 - f1 / 2.0F, 359.20001F, localPaint);
      this.jdField_a_of_type_Bdzh = new bdzh(this, localBitmap);
      this.jdField_a_of_type_Bdzh.c = (this.jdField_a_of_type_Bgry.jdField_a_of_type_Int / 2);
      this.jdField_a_of_type_Bdzh.d = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Bdzh.e = 0.0F;
      a(this.jdField_a_of_type_Bdzh);
      if (paramBitmap3 != null)
      {
        this.jdField_a_of_type_Bdzb = new bdzb(this, paramBitmap3, false);
        this.jdField_a_of_type_Bdzb.a(this.jdField_a_of_type_Bgry.jdField_a_of_type_Int / 2, this.jdField_a_of_type_Bgry.jdField_b_of_type_Int * this.jdField_a_of_type_Bgry.f / 100);
      }
      try
      {
        this.jdField_b_of_type_Bdzb = new bdzb(this, BitmapFactory.decodeResource(getResources(), 2130847187), true);
        this.jdField_b_of_type_Bdzb.a(parambgry.jdField_a_of_type_Int - bhdz.a(getContext(), 40.0F), bhdz.a(getContext(), 120.0F));
        this.jdField_b_of_type_Bdzb.a(parambdzc);
        this.jdField_b_of_type_Bdzb.e = 0.75F;
        a(this.jdField_b_of_type_Bdzb);
        return;
        paramBitmap1 = parambgry.jdField_a_of_type_JavaLangString.substring(0, j) + "..." + paramBitmap1;
      }
      catch (OutOfMemoryError paramBitmap1)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("TroopGiftToAllSurfaceView", 2, "decode closeButton failed");
        return;
      }
    }
  }
  
  public void a(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, String paramString, bdzc parambdzc, bgry parambgry)
  {
    this.jdField_a_of_type_Bgry = parambgry;
    this.jdField_a_of_type_Int = (parambgry.jdField_b_of_type_Int * parambgry.c / 100);
    this.jdField_a_of_type_Float = (getResources().getDisplayMetrics().density / 2.0F);
    this.jdField_a_of_type_JavaLangString = paramString;
    paramString = new VideoSprite(this, getContext(), true);
    paramString.b = true;
    paramString.c = (this.jdField_a_of_type_Bgry.jdField_a_of_type_Int / 2);
    paramString.d = (this.jdField_a_of_type_Bgry.jdField_b_of_type_Int / 2);
    this.jdField_b_of_type_Bdzh = paramString;
    a(paramBitmap1, paramBitmap2, paramBitmap3, parambdzc, parambgry);
  }
  
  public void a(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, String[] paramArrayOfString, bdzc parambdzc, bgry parambgry)
  {
    this.jdField_a_of_type_Bgry = parambgry;
    this.jdField_a_of_type_Int = (parambgry.jdField_b_of_type_Int * parambgry.c / 100);
    this.jdField_a_of_type_Float = (getResources().getDisplayMetrics().density / 2.0F);
    paramArrayOfString = new bdyx(this, paramArrayOfString);
    this.jdField_b_of_type_Bdzh = paramArrayOfString;
    this.jdField_b_of_type_Bdzh.c = (this.jdField_a_of_type_Bgry.jdField_a_of_type_Int / 2);
    this.jdField_b_of_type_Bdzh.d = (this.jdField_a_of_type_Bgry.jdField_b_of_type_Int / 2);
    this.jdField_b_of_type_Bdzh.e = parambgry.jdField_a_of_type_Float;
    paramArrayOfString.e(parambgry.h);
    paramArrayOfString.a(true);
    a(paramBitmap1, paramBitmap2, paramBitmap3, parambdzc, parambgry);
  }
  
  public void a(bdye parambdye)
  {
    if (this.jdField_b_of_type_Bdzh != null) {
      this.jdField_b_of_type_Bdzh.a(new bdyd[] { new bdyj(500, 255, 0, 1) });
    }
    bdyj localbdyj = new bdyj(500, 255, 0, 1);
    localbdyj.a(parambdye);
    if (this.jdField_a_of_type_Bdzh != null) {
      this.jdField_a_of_type_Bdzh.a(new bdyd[] { localbdyj });
    }
    if (this.jdField_a_of_type_Bdzb != null)
    {
      this.jdField_a_of_type_Bdzb.a(null);
      this.jdField_a_of_type_Bdzb.a(new bdyd[] { new bdyj(500, 255, 0, 1) });
    }
    if (this.jdField_a_of_type_Bdzd != null) {
      this.jdField_a_of_type_Bdzd.a(new bdyd[] { new bdyj(500, 255, 0, 1) });
    }
    if (this.jdField_b_of_type_Bdzb != null) {
      this.jdField_b_of_type_Bdzb.a(new bdyd[] { new bdyj(500, 255, 0, 1) });
    }
  }
  
  public void a(bdyy parambdyy)
  {
    if (this.jdField_a_of_type_Bdzh != null)
    {
      bdym localbdym = new bdym(new bdyd[] { new bdyl(500, 0.0F, this.jdField_a_of_type_Float * 1.1F), new bdyl(200, this.jdField_a_of_type_Float * 1.1F, this.jdField_a_of_type_Float * 0.95F), new bdyl(200, this.jdField_a_of_type_Float * 0.95F, this.jdField_a_of_type_Float * 1.05F), new bdyl(200, this.jdField_a_of_type_Float * 1.05F, this.jdField_a_of_type_Float * 1.0F) });
      this.jdField_a_of_type_Bdzh.a(new bdyd[] { localbdym });
    }
    if ((this.jdField_b_of_type_Bdzh != null) && ((this.jdField_b_of_type_Bdzh instanceof bdyx)))
    {
      ((bdyx)this.jdField_b_of_type_Bdzh).a = new bgrt(this, parambdyy);
      ((bdyx)this.jdField_b_of_type_Bdzh).a(getContext(), this);
    }
    for (;;)
    {
      parambdyy = new bdyf(500);
      parambdyy.a(new bgru(this));
      if (this.jdField_a_of_type_Bdzh != null) {
        this.jdField_a_of_type_Bdzh.a(new bdyd[] { parambdyy });
      }
      return;
      if ((this.jdField_b_of_type_Bdzh != null) && ((this.jdField_b_of_type_Bdzh instanceof VideoSprite))) {
        ((VideoSprite)this.jdField_b_of_type_Bdzh).a(parambdyy);
      }
    }
  }
  
  public void a(bdzc parambdzc)
  {
    if (this.jdField_a_of_type_Bdzb != null)
    {
      this.jdField_a_of_type_Bdzb.a(parambdzc);
      this.jdField_a_of_type_Bdzb.e = 0.0F;
      a(this.jdField_a_of_type_Bdzb);
      parambdzc = new bdym(new bdyd[] { new bdyl(500, 0.0F, this.jdField_a_of_type_Float * 1.1F), new bdyl(200, this.jdField_a_of_type_Float * 1.1F, this.jdField_a_of_type_Float * 0.88F), new bdyl(200, this.jdField_a_of_type_Float * 0.88F, this.jdField_a_of_type_Float) });
      parambdzc.a(new bgrv(this));
      this.jdField_a_of_type_Bdzb.a(new bdyd[] { parambdzc });
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    b(new TroopGiftToAllSurfaceView.5(this, paramString, paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopGiftToAllSurfaceView
 * JD-Core Version:    0.7.0.1
 */
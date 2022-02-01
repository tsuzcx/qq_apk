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
import bdxn;
import bdxo;
import bdxp;
import bdxt;
import bdxv;
import bdxw;
import bdyh;
import bdyi;
import bdyl;
import bdym;
import bdyn;
import bdyr;
import bgzq;
import bgzr;
import bgzs;
import bgzt;
import bgzv;
import bhmg;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite;
import com.tencent.qphone.base.util.QLog;

public class TroopGiftToAllSurfaceView
  extends SpriteGLView
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private bdyl jdField_a_of_type_Bdyl;
  private bdyn jdField_a_of_type_Bdyn;
  private bdyr jdField_a_of_type_Bdyr;
  private bgzv jdField_a_of_type_Bgzv;
  private String jdField_a_of_type_JavaLangString;
  private bdyl jdField_b_of_type_Bdyl;
  private bdyr jdField_b_of_type_Bdyr;
  
  public TroopGiftToAllSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bdyl != null)
    {
      bdxt localbdxt = new bdxt(500, 255, 0);
      localbdxt.a(new bgzt(this));
      this.jdField_a_of_type_Bdyl.a(new bdxn[] { localbdxt });
    }
  }
  
  protected void a(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, bdym parambdym, bgzv parambgzv)
  {
    Bitmap localBitmap;
    Canvas localCanvas;
    Paint localPaint;
    float f1;
    int j;
    if ((!parambgzv.jdField_a_of_type_Boolean) && (paramBitmap1 != null))
    {
      localBitmap = paramBitmap1.copy(Bitmap.Config.ARGB_8888, true);
      localCanvas = new Canvas(localBitmap);
      localPaint = new Paint();
      localPaint.setAntiAlias(true);
      localPaint.setColor(parambgzv.g);
      localPaint.setTextSize(34.0F);
      paramBitmap1 = new Matrix();
      f1 = 140.0F / paramBitmap2.getWidth();
      paramBitmap1.postScale(f1, f1);
      paramBitmap1.postTranslate((localBitmap.getWidth() - f1 * paramBitmap2.getWidth()) / 2.0F, 154.0F);
      localCanvas.drawBitmap(paramBitmap2, paramBitmap1, localPaint);
      if ((!TextUtils.isEmpty(parambgzv.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(parambgzv.jdField_a_of_type_JavaLangString)))
      {
        float f2 = localPaint.measureText(parambgzv.jdField_b_of_type_JavaLangString);
        f1 = 0.0F;
        j = 0;
        paramBitmap1 = parambgzv.jdField_b_of_type_JavaLangString;
        int i = 0;
        while (i < parambgzv.jdField_a_of_type_JavaLangString.length())
        {
          float f3 = localPaint.measureText("" + parambgzv.jdField_a_of_type_JavaLangString.charAt(i));
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
        if (j != parambgzv.jdField_a_of_type_JavaLangString.length()) {
          break label524;
        }
        paramBitmap1 = parambgzv.jdField_a_of_type_JavaLangString + paramBitmap1;
      }
    }
    label524:
    label577:
    for (;;)
    {
      f1 = localPaint.measureText(paramBitmap1);
      localCanvas.drawText(paramBitmap1, localBitmap.getWidth() / 2 - f1 / 2.0F, 359.20001F, localPaint);
      this.jdField_a_of_type_Bdyr = new bdyr(this, localBitmap);
      this.jdField_a_of_type_Bdyr.c = (this.jdField_a_of_type_Bgzv.jdField_a_of_type_Int / 2);
      this.jdField_a_of_type_Bdyr.d = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Bdyr.e = 0.0F;
      a(this.jdField_a_of_type_Bdyr);
      if (paramBitmap3 != null)
      {
        this.jdField_a_of_type_Bdyl = new bdyl(this, paramBitmap3, false);
        this.jdField_a_of_type_Bdyl.a(this.jdField_a_of_type_Bgzv.jdField_a_of_type_Int / 2, this.jdField_a_of_type_Bgzv.jdField_b_of_type_Int * this.jdField_a_of_type_Bgzv.f / 100);
      }
      try
      {
        this.jdField_b_of_type_Bdyl = new bdyl(this, BitmapFactory.decodeResource(getResources(), 2130847181), true);
        this.jdField_b_of_type_Bdyl.a(parambgzv.jdField_a_of_type_Int - bhmg.a(getContext(), 40.0F), bhmg.a(getContext(), 120.0F));
        this.jdField_b_of_type_Bdyl.a(parambdym);
        this.jdField_b_of_type_Bdyl.e = 0.75F;
        a(this.jdField_b_of_type_Bdyl);
        return;
        paramBitmap1 = parambgzv.jdField_a_of_type_JavaLangString.substring(0, j) + "..." + paramBitmap1;
      }
      catch (OutOfMemoryError paramBitmap1)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("TroopGiftToAllSurfaceView", 2, "decode closeButton failed");
        return;
      }
    }
  }
  
  public void a(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, String paramString, bdym parambdym, bgzv parambgzv)
  {
    this.jdField_a_of_type_Bgzv = parambgzv;
    this.jdField_a_of_type_Int = (parambgzv.jdField_b_of_type_Int * parambgzv.c / 100);
    this.jdField_a_of_type_Float = (getResources().getDisplayMetrics().density / 2.0F);
    this.jdField_a_of_type_JavaLangString = paramString;
    paramString = new VideoSprite(this, getContext(), true);
    paramString.b = true;
    paramString.c = (this.jdField_a_of_type_Bgzv.jdField_a_of_type_Int / 2);
    paramString.d = (this.jdField_a_of_type_Bgzv.jdField_b_of_type_Int / 2);
    this.jdField_b_of_type_Bdyr = paramString;
    a(paramBitmap1, paramBitmap2, paramBitmap3, parambdym, parambgzv);
  }
  
  public void a(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, String[] paramArrayOfString, bdym parambdym, bgzv parambgzv)
  {
    this.jdField_a_of_type_Bgzv = parambgzv;
    this.jdField_a_of_type_Int = (parambgzv.jdField_b_of_type_Int * parambgzv.c / 100);
    this.jdField_a_of_type_Float = (getResources().getDisplayMetrics().density / 2.0F);
    paramArrayOfString = new bdyh(this, paramArrayOfString);
    this.jdField_b_of_type_Bdyr = paramArrayOfString;
    this.jdField_b_of_type_Bdyr.c = (this.jdField_a_of_type_Bgzv.jdField_a_of_type_Int / 2);
    this.jdField_b_of_type_Bdyr.d = (this.jdField_a_of_type_Bgzv.jdField_b_of_type_Int / 2);
    this.jdField_b_of_type_Bdyr.e = parambgzv.jdField_a_of_type_Float;
    paramArrayOfString.e(parambgzv.h);
    paramArrayOfString.a(true);
    a(paramBitmap1, paramBitmap2, paramBitmap3, parambdym, parambgzv);
  }
  
  public void a(bdxo parambdxo)
  {
    if (this.jdField_b_of_type_Bdyr != null) {
      this.jdField_b_of_type_Bdyr.a(new bdxn[] { new bdxt(500, 255, 0, 1) });
    }
    bdxt localbdxt = new bdxt(500, 255, 0, 1);
    localbdxt.a(parambdxo);
    if (this.jdField_a_of_type_Bdyr != null) {
      this.jdField_a_of_type_Bdyr.a(new bdxn[] { localbdxt });
    }
    if (this.jdField_a_of_type_Bdyl != null)
    {
      this.jdField_a_of_type_Bdyl.a(null);
      this.jdField_a_of_type_Bdyl.a(new bdxn[] { new bdxt(500, 255, 0, 1) });
    }
    if (this.jdField_a_of_type_Bdyn != null) {
      this.jdField_a_of_type_Bdyn.a(new bdxn[] { new bdxt(500, 255, 0, 1) });
    }
    if (this.jdField_b_of_type_Bdyl != null) {
      this.jdField_b_of_type_Bdyl.a(new bdxn[] { new bdxt(500, 255, 0, 1) });
    }
  }
  
  public void a(bdyi parambdyi)
  {
    if (this.jdField_a_of_type_Bdyr != null)
    {
      bdxw localbdxw = new bdxw(new bdxn[] { new bdxv(500, 0.0F, this.jdField_a_of_type_Float * 1.1F), new bdxv(200, this.jdField_a_of_type_Float * 1.1F, this.jdField_a_of_type_Float * 0.95F), new bdxv(200, this.jdField_a_of_type_Float * 0.95F, this.jdField_a_of_type_Float * 1.05F), new bdxv(200, this.jdField_a_of_type_Float * 1.05F, this.jdField_a_of_type_Float * 1.0F) });
      this.jdField_a_of_type_Bdyr.a(new bdxn[] { localbdxw });
    }
    if ((this.jdField_b_of_type_Bdyr != null) && ((this.jdField_b_of_type_Bdyr instanceof bdyh)))
    {
      ((bdyh)this.jdField_b_of_type_Bdyr).a = new bgzq(this, parambdyi);
      ((bdyh)this.jdField_b_of_type_Bdyr).a(getContext(), this);
    }
    for (;;)
    {
      parambdyi = new bdxp(500);
      parambdyi.a(new bgzr(this));
      if (this.jdField_a_of_type_Bdyr != null) {
        this.jdField_a_of_type_Bdyr.a(new bdxn[] { parambdyi });
      }
      return;
      if ((this.jdField_b_of_type_Bdyr != null) && ((this.jdField_b_of_type_Bdyr instanceof VideoSprite))) {
        ((VideoSprite)this.jdField_b_of_type_Bdyr).a(parambdyi);
      }
    }
  }
  
  public void a(bdym parambdym)
  {
    if (this.jdField_a_of_type_Bdyl != null)
    {
      this.jdField_a_of_type_Bdyl.a(parambdym);
      this.jdField_a_of_type_Bdyl.e = 0.0F;
      a(this.jdField_a_of_type_Bdyl);
      parambdym = new bdxw(new bdxn[] { new bdxv(500, 0.0F, this.jdField_a_of_type_Float * 1.1F), new bdxv(200, this.jdField_a_of_type_Float * 1.1F, this.jdField_a_of_type_Float * 0.88F), new bdxv(200, this.jdField_a_of_type_Float * 0.88F, this.jdField_a_of_type_Float) });
      parambdym.a(new bgzs(this));
      this.jdField_a_of_type_Bdyl.a(new bdxn[] { parambdym });
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
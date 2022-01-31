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
import bado;
import badp;
import badq;
import badu;
import badw;
import badx;
import baei;
import baej;
import baem;
import baen;
import baeo;
import baes;
import bcve;
import bcvf;
import bcvg;
import bcvh;
import bcvj;
import bdgz;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite;
import com.tencent.qphone.base.util.QLog;

public class TroopGiftToAllSurfaceView
  extends SpriteGLView
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private baem jdField_a_of_type_Baem;
  private baeo jdField_a_of_type_Baeo;
  private baes jdField_a_of_type_Baes;
  private bcvj jdField_a_of_type_Bcvj;
  private String jdField_a_of_type_JavaLangString;
  private baem jdField_b_of_type_Baem;
  private baes jdField_b_of_type_Baes;
  
  public TroopGiftToAllSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Baem != null)
    {
      badu localbadu = new badu(500, 255, 0);
      localbadu.a(new bcvh(this));
      this.jdField_a_of_type_Baem.a(new bado[] { localbadu });
    }
  }
  
  protected void a(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, baen parambaen, bcvj parambcvj)
  {
    Bitmap localBitmap;
    Canvas localCanvas;
    Paint localPaint;
    float f1;
    int j;
    if ((!parambcvj.jdField_a_of_type_Boolean) && (paramBitmap1 != null))
    {
      localBitmap = paramBitmap1.copy(Bitmap.Config.ARGB_8888, true);
      localCanvas = new Canvas(localBitmap);
      localPaint = new Paint();
      localPaint.setAntiAlias(true);
      localPaint.setColor(parambcvj.g);
      localPaint.setTextSize(34.0F);
      paramBitmap1 = new Matrix();
      f1 = 140.0F / paramBitmap2.getWidth();
      paramBitmap1.postScale(f1, f1);
      paramBitmap1.postTranslate((localBitmap.getWidth() - f1 * paramBitmap2.getWidth()) / 2.0F, 154.0F);
      localCanvas.drawBitmap(paramBitmap2, paramBitmap1, localPaint);
      if ((!TextUtils.isEmpty(parambcvj.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(parambcvj.jdField_a_of_type_JavaLangString)))
      {
        float f2 = localPaint.measureText(parambcvj.jdField_b_of_type_JavaLangString);
        f1 = 0.0F;
        j = 0;
        paramBitmap1 = parambcvj.jdField_b_of_type_JavaLangString;
        int i = 0;
        while (i < parambcvj.jdField_a_of_type_JavaLangString.length())
        {
          float f3 = localPaint.measureText("" + parambcvj.jdField_a_of_type_JavaLangString.charAt(i));
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
        if (j != parambcvj.jdField_a_of_type_JavaLangString.length()) {
          break label524;
        }
        paramBitmap1 = parambcvj.jdField_a_of_type_JavaLangString + paramBitmap1;
      }
    }
    label524:
    label577:
    for (;;)
    {
      f1 = localPaint.measureText(paramBitmap1);
      localCanvas.drawText(paramBitmap1, localBitmap.getWidth() / 2 - f1 / 2.0F, 359.20001F, localPaint);
      this.jdField_a_of_type_Baes = new baes(this, localBitmap);
      this.jdField_a_of_type_Baes.c = (this.jdField_a_of_type_Bcvj.jdField_a_of_type_Int / 2);
      this.jdField_a_of_type_Baes.d = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Baes.e = 0.0F;
      a(this.jdField_a_of_type_Baes);
      if (paramBitmap3 != null)
      {
        this.jdField_a_of_type_Baem = new baem(this, paramBitmap3, false);
        this.jdField_a_of_type_Baem.a(this.jdField_a_of_type_Bcvj.jdField_a_of_type_Int / 2, this.jdField_a_of_type_Bcvj.jdField_b_of_type_Int * this.jdField_a_of_type_Bcvj.f / 100);
      }
      try
      {
        this.jdField_b_of_type_Baem = new baem(this, BitmapFactory.decodeResource(getResources(), 2130846716), true);
        this.jdField_b_of_type_Baem.a(parambcvj.jdField_a_of_type_Int - bdgz.a(getContext(), 40.0F), bdgz.a(getContext(), 120.0F));
        this.jdField_b_of_type_Baem.a(parambaen);
        this.jdField_b_of_type_Baem.e = 0.75F;
        a(this.jdField_b_of_type_Baem);
        return;
        paramBitmap1 = parambcvj.jdField_a_of_type_JavaLangString.substring(0, j) + "..." + paramBitmap1;
      }
      catch (OutOfMemoryError paramBitmap1)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("TroopGiftToAllSurfaceView", 2, "decode closeButton failed");
        return;
      }
    }
  }
  
  public void a(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, String paramString, baen parambaen, bcvj parambcvj)
  {
    this.jdField_a_of_type_Bcvj = parambcvj;
    this.jdField_a_of_type_Int = (parambcvj.jdField_b_of_type_Int * parambcvj.c / 100);
    this.jdField_a_of_type_Float = (getResources().getDisplayMetrics().density / 2.0F);
    this.jdField_a_of_type_JavaLangString = paramString;
    paramString = new VideoSprite(this, getContext(), true);
    paramString.b = true;
    paramString.c = (this.jdField_a_of_type_Bcvj.jdField_a_of_type_Int / 2);
    paramString.d = (this.jdField_a_of_type_Bcvj.jdField_b_of_type_Int / 2);
    this.jdField_b_of_type_Baes = paramString;
    a(paramBitmap1, paramBitmap2, paramBitmap3, parambaen, parambcvj);
  }
  
  public void a(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, String[] paramArrayOfString, baen parambaen, bcvj parambcvj)
  {
    this.jdField_a_of_type_Bcvj = parambcvj;
    this.jdField_a_of_type_Int = (parambcvj.jdField_b_of_type_Int * parambcvj.c / 100);
    this.jdField_a_of_type_Float = (getResources().getDisplayMetrics().density / 2.0F);
    paramArrayOfString = new baei(this, paramArrayOfString);
    this.jdField_b_of_type_Baes = paramArrayOfString;
    this.jdField_b_of_type_Baes.c = (this.jdField_a_of_type_Bcvj.jdField_a_of_type_Int / 2);
    this.jdField_b_of_type_Baes.d = (this.jdField_a_of_type_Bcvj.jdField_b_of_type_Int / 2);
    this.jdField_b_of_type_Baes.e = parambcvj.jdField_a_of_type_Float;
    paramArrayOfString.e(parambcvj.h);
    paramArrayOfString.a(true);
    a(paramBitmap1, paramBitmap2, paramBitmap3, parambaen, parambcvj);
  }
  
  public void a(badp parambadp)
  {
    if (this.jdField_b_of_type_Baes != null) {
      this.jdField_b_of_type_Baes.a(new bado[] { new badu(500, 255, 0, 1) });
    }
    badu localbadu = new badu(500, 255, 0, 1);
    localbadu.a(parambadp);
    if (this.jdField_a_of_type_Baes != null) {
      this.jdField_a_of_type_Baes.a(new bado[] { localbadu });
    }
    if (this.jdField_a_of_type_Baem != null)
    {
      this.jdField_a_of_type_Baem.a(null);
      this.jdField_a_of_type_Baem.a(new bado[] { new badu(500, 255, 0, 1) });
    }
    if (this.jdField_a_of_type_Baeo != null) {
      this.jdField_a_of_type_Baeo.a(new bado[] { new badu(500, 255, 0, 1) });
    }
    if (this.jdField_b_of_type_Baem != null) {
      this.jdField_b_of_type_Baem.a(new bado[] { new badu(500, 255, 0, 1) });
    }
  }
  
  public void a(baej parambaej)
  {
    if (this.jdField_a_of_type_Baes != null)
    {
      badx localbadx = new badx(new bado[] { new badw(500, 0.0F, this.jdField_a_of_type_Float * 1.1F), new badw(200, this.jdField_a_of_type_Float * 1.1F, this.jdField_a_of_type_Float * 0.95F), new badw(200, this.jdField_a_of_type_Float * 0.95F, this.jdField_a_of_type_Float * 1.05F), new badw(200, this.jdField_a_of_type_Float * 1.05F, this.jdField_a_of_type_Float * 1.0F) });
      this.jdField_a_of_type_Baes.a(new bado[] { localbadx });
    }
    if ((this.jdField_b_of_type_Baes != null) && ((this.jdField_b_of_type_Baes instanceof baei)))
    {
      ((baei)this.jdField_b_of_type_Baes).a = new bcve(this, parambaej);
      ((baei)this.jdField_b_of_type_Baes).a(getContext(), this);
    }
    for (;;)
    {
      parambaej = new badq(500);
      parambaej.a(new bcvf(this));
      if (this.jdField_a_of_type_Baes != null) {
        this.jdField_a_of_type_Baes.a(new bado[] { parambaej });
      }
      return;
      if ((this.jdField_b_of_type_Baes != null) && ((this.jdField_b_of_type_Baes instanceof VideoSprite))) {
        ((VideoSprite)this.jdField_b_of_type_Baes).a(parambaej);
      }
    }
  }
  
  public void a(baen parambaen)
  {
    if (this.jdField_a_of_type_Baem != null)
    {
      this.jdField_a_of_type_Baem.a(parambaen);
      this.jdField_a_of_type_Baem.e = 0.0F;
      a(this.jdField_a_of_type_Baem);
      parambaen = new badx(new bado[] { new badw(500, 0.0F, this.jdField_a_of_type_Float * 1.1F), new badw(200, this.jdField_a_of_type_Float * 1.1F, this.jdField_a_of_type_Float * 0.88F), new badw(200, this.jdField_a_of_type_Float * 0.88F, this.jdField_a_of_type_Float) });
      parambaen.a(new bcvg(this));
      this.jdField_a_of_type_Baem.a(new bado[] { parambaen });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopGiftToAllSurfaceView
 * JD-Core Version:    0.7.0.1
 */
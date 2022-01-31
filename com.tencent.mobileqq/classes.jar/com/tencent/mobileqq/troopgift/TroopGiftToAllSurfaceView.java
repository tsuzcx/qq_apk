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
import axbe;
import axbf;
import axbg;
import axbk;
import axbm;
import axbn;
import axby;
import axbz;
import axcc;
import axcd;
import axce;
import axci;
import azqj;
import azqk;
import azql;
import azqm;
import azqo;
import bacc;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite;
import com.tencent.qphone.base.util.QLog;

public class TroopGiftToAllSurfaceView
  extends SpriteGLView
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private axcc jdField_a_of_type_Axcc;
  private axce jdField_a_of_type_Axce;
  private axci jdField_a_of_type_Axci;
  private azqo jdField_a_of_type_Azqo;
  private String jdField_a_of_type_JavaLangString;
  private axcc jdField_b_of_type_Axcc;
  private axci jdField_b_of_type_Axci;
  
  public TroopGiftToAllSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Axcc != null)
    {
      axbk localaxbk = new axbk(500, 255, 0);
      localaxbk.a(new azqm(this));
      this.jdField_a_of_type_Axcc.a(new axbe[] { localaxbk });
    }
  }
  
  protected void a(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, axcd paramaxcd, azqo paramazqo)
  {
    Bitmap localBitmap;
    Canvas localCanvas;
    Paint localPaint;
    float f1;
    int j;
    if ((!paramazqo.jdField_a_of_type_Boolean) && (paramBitmap1 != null))
    {
      localBitmap = paramBitmap1.copy(Bitmap.Config.ARGB_8888, true);
      localCanvas = new Canvas(localBitmap);
      localPaint = new Paint();
      localPaint.setAntiAlias(true);
      localPaint.setColor(paramazqo.g);
      localPaint.setTextSize(34.0F);
      paramBitmap1 = new Matrix();
      f1 = 140.0F / paramBitmap2.getWidth();
      paramBitmap1.postScale(f1, f1);
      paramBitmap1.postTranslate((localBitmap.getWidth() - f1 * paramBitmap2.getWidth()) / 2.0F, 154.0F);
      localCanvas.drawBitmap(paramBitmap2, paramBitmap1, localPaint);
      if ((!TextUtils.isEmpty(paramazqo.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramazqo.jdField_a_of_type_JavaLangString)))
      {
        float f2 = localPaint.measureText(paramazqo.jdField_b_of_type_JavaLangString);
        f1 = 0.0F;
        j = 0;
        paramBitmap1 = paramazqo.jdField_b_of_type_JavaLangString;
        int i = 0;
        while (i < paramazqo.jdField_a_of_type_JavaLangString.length())
        {
          float f3 = localPaint.measureText("" + paramazqo.jdField_a_of_type_JavaLangString.charAt(i));
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
        if (j != paramazqo.jdField_a_of_type_JavaLangString.length()) {
          break label524;
        }
        paramBitmap1 = paramazqo.jdField_a_of_type_JavaLangString + paramBitmap1;
      }
    }
    label524:
    label577:
    for (;;)
    {
      f1 = localPaint.measureText(paramBitmap1);
      localCanvas.drawText(paramBitmap1, localBitmap.getWidth() / 2 - f1 / 2.0F, 359.20001F, localPaint);
      this.jdField_a_of_type_Axci = new axci(this, localBitmap);
      this.jdField_a_of_type_Axci.c = (this.jdField_a_of_type_Azqo.jdField_a_of_type_Int / 2);
      this.jdField_a_of_type_Axci.d = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Axci.e = 0.0F;
      a(this.jdField_a_of_type_Axci);
      if (paramBitmap3 != null)
      {
        this.jdField_a_of_type_Axcc = new axcc(this, paramBitmap3, false);
        this.jdField_a_of_type_Axcc.a(this.jdField_a_of_type_Azqo.jdField_a_of_type_Int / 2, this.jdField_a_of_type_Azqo.jdField_b_of_type_Int * this.jdField_a_of_type_Azqo.f / 100);
      }
      try
      {
        this.jdField_b_of_type_Axcc = new axcc(this, BitmapFactory.decodeResource(getResources(), 2130846077), true);
        this.jdField_b_of_type_Axcc.a(paramazqo.jdField_a_of_type_Int - bacc.a(getContext(), 40.0F), bacc.a(getContext(), 120.0F));
        this.jdField_b_of_type_Axcc.a(paramaxcd);
        this.jdField_b_of_type_Axcc.e = 0.75F;
        a(this.jdField_b_of_type_Axcc);
        return;
        paramBitmap1 = paramazqo.jdField_a_of_type_JavaLangString.substring(0, j) + "..." + paramBitmap1;
      }
      catch (OutOfMemoryError paramBitmap1)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("TroopGiftToAllSurfaceView", 2, "decode closeButton failed");
        return;
      }
    }
  }
  
  public void a(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, String paramString, axcd paramaxcd, azqo paramazqo)
  {
    this.jdField_a_of_type_Azqo = paramazqo;
    this.jdField_a_of_type_Int = (paramazqo.jdField_b_of_type_Int * paramazqo.c / 100);
    this.jdField_a_of_type_Float = (getResources().getDisplayMetrics().density / 2.0F);
    this.jdField_a_of_type_JavaLangString = paramString;
    paramString = new VideoSprite(this, getContext(), true);
    paramString.b = true;
    paramString.c = (this.jdField_a_of_type_Azqo.jdField_a_of_type_Int / 2);
    paramString.d = (this.jdField_a_of_type_Azqo.jdField_b_of_type_Int / 2);
    this.jdField_b_of_type_Axci = paramString;
    a(paramBitmap1, paramBitmap2, paramBitmap3, paramaxcd, paramazqo);
  }
  
  public void a(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, String[] paramArrayOfString, axcd paramaxcd, azqo paramazqo)
  {
    this.jdField_a_of_type_Azqo = paramazqo;
    this.jdField_a_of_type_Int = (paramazqo.jdField_b_of_type_Int * paramazqo.c / 100);
    this.jdField_a_of_type_Float = (getResources().getDisplayMetrics().density / 2.0F);
    paramArrayOfString = new axby(this, paramArrayOfString);
    this.jdField_b_of_type_Axci = paramArrayOfString;
    this.jdField_b_of_type_Axci.c = (this.jdField_a_of_type_Azqo.jdField_a_of_type_Int / 2);
    this.jdField_b_of_type_Axci.d = (this.jdField_a_of_type_Azqo.jdField_b_of_type_Int / 2);
    this.jdField_b_of_type_Axci.e = paramazqo.jdField_a_of_type_Float;
    paramArrayOfString.e(paramazqo.h);
    paramArrayOfString.a(true);
    a(paramBitmap1, paramBitmap2, paramBitmap3, paramaxcd, paramazqo);
  }
  
  public void a(axbf paramaxbf)
  {
    if (this.jdField_b_of_type_Axci != null) {
      this.jdField_b_of_type_Axci.a(new axbe[] { new axbk(500, 255, 0, 1) });
    }
    axbk localaxbk = new axbk(500, 255, 0, 1);
    localaxbk.a(paramaxbf);
    if (this.jdField_a_of_type_Axci != null) {
      this.jdField_a_of_type_Axci.a(new axbe[] { localaxbk });
    }
    if (this.jdField_a_of_type_Axcc != null)
    {
      this.jdField_a_of_type_Axcc.a(null);
      this.jdField_a_of_type_Axcc.a(new axbe[] { new axbk(500, 255, 0, 1) });
    }
    if (this.jdField_a_of_type_Axce != null) {
      this.jdField_a_of_type_Axce.a(new axbe[] { new axbk(500, 255, 0, 1) });
    }
    if (this.jdField_b_of_type_Axcc != null) {
      this.jdField_b_of_type_Axcc.a(new axbe[] { new axbk(500, 255, 0, 1) });
    }
  }
  
  public void a(axbz paramaxbz)
  {
    if (this.jdField_a_of_type_Axci != null)
    {
      axbn localaxbn = new axbn(new axbe[] { new axbm(500, 0.0F, this.jdField_a_of_type_Float * 1.1F), new axbm(200, this.jdField_a_of_type_Float * 1.1F, this.jdField_a_of_type_Float * 0.95F), new axbm(200, this.jdField_a_of_type_Float * 0.95F, this.jdField_a_of_type_Float * 1.05F), new axbm(200, this.jdField_a_of_type_Float * 1.05F, this.jdField_a_of_type_Float * 1.0F) });
      this.jdField_a_of_type_Axci.a(new axbe[] { localaxbn });
    }
    if ((this.jdField_b_of_type_Axci != null) && ((this.jdField_b_of_type_Axci instanceof axby)))
    {
      ((axby)this.jdField_b_of_type_Axci).a = new azqj(this, paramaxbz);
      ((axby)this.jdField_b_of_type_Axci).a(getContext(), this);
    }
    for (;;)
    {
      paramaxbz = new axbg(500);
      paramaxbz.a(new azqk(this));
      if (this.jdField_a_of_type_Axci != null) {
        this.jdField_a_of_type_Axci.a(new axbe[] { paramaxbz });
      }
      return;
      if ((this.jdField_b_of_type_Axci != null) && ((this.jdField_b_of_type_Axci instanceof VideoSprite))) {
        ((VideoSprite)this.jdField_b_of_type_Axci).a(paramaxbz);
      }
    }
  }
  
  public void a(axcd paramaxcd)
  {
    if (this.jdField_a_of_type_Axcc != null)
    {
      this.jdField_a_of_type_Axcc.a(paramaxcd);
      this.jdField_a_of_type_Axcc.e = 0.0F;
      a(this.jdField_a_of_type_Axcc);
      paramaxcd = new axbn(new axbe[] { new axbm(500, 0.0F, this.jdField_a_of_type_Float * 1.1F), new axbm(200, this.jdField_a_of_type_Float * 1.1F, this.jdField_a_of_type_Float * 0.88F), new axbm(200, this.jdField_a_of_type_Float * 0.88F, this.jdField_a_of_type_Float) });
      paramaxcd.a(new azql(this));
      this.jdField_a_of_type_Axcc.a(new axbe[] { paramaxcd });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopGiftToAllSurfaceView
 * JD-Core Version:    0.7.0.1
 */
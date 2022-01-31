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
import azzf;
import azzg;
import azzh;
import azzl;
import azzn;
import azzo;
import azzz;
import baaa;
import baad;
import baae;
import baaf;
import baaj;
import bcqv;
import bcqw;
import bcqx;
import bcqy;
import bcra;
import bdcq;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite;
import com.tencent.qphone.base.util.QLog;

public class TroopGiftToAllSurfaceView
  extends SpriteGLView
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private baad jdField_a_of_type_Baad;
  private baaf jdField_a_of_type_Baaf;
  private baaj jdField_a_of_type_Baaj;
  private bcra jdField_a_of_type_Bcra;
  private String jdField_a_of_type_JavaLangString;
  private baad jdField_b_of_type_Baad;
  private baaj jdField_b_of_type_Baaj;
  
  public TroopGiftToAllSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Baad != null)
    {
      azzl localazzl = new azzl(500, 255, 0);
      localazzl.a(new bcqy(this));
      this.jdField_a_of_type_Baad.a(new azzf[] { localazzl });
    }
  }
  
  protected void a(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, baae parambaae, bcra parambcra)
  {
    Bitmap localBitmap;
    Canvas localCanvas;
    Paint localPaint;
    float f1;
    int j;
    if ((!parambcra.jdField_a_of_type_Boolean) && (paramBitmap1 != null))
    {
      localBitmap = paramBitmap1.copy(Bitmap.Config.ARGB_8888, true);
      localCanvas = new Canvas(localBitmap);
      localPaint = new Paint();
      localPaint.setAntiAlias(true);
      localPaint.setColor(parambcra.g);
      localPaint.setTextSize(34.0F);
      paramBitmap1 = new Matrix();
      f1 = 140.0F / paramBitmap2.getWidth();
      paramBitmap1.postScale(f1, f1);
      paramBitmap1.postTranslate((localBitmap.getWidth() - f1 * paramBitmap2.getWidth()) / 2.0F, 154.0F);
      localCanvas.drawBitmap(paramBitmap2, paramBitmap1, localPaint);
      if ((!TextUtils.isEmpty(parambcra.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(parambcra.jdField_a_of_type_JavaLangString)))
      {
        float f2 = localPaint.measureText(parambcra.jdField_b_of_type_JavaLangString);
        f1 = 0.0F;
        j = 0;
        paramBitmap1 = parambcra.jdField_b_of_type_JavaLangString;
        int i = 0;
        while (i < parambcra.jdField_a_of_type_JavaLangString.length())
        {
          float f3 = localPaint.measureText("" + parambcra.jdField_a_of_type_JavaLangString.charAt(i));
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
        if (j != parambcra.jdField_a_of_type_JavaLangString.length()) {
          break label524;
        }
        paramBitmap1 = parambcra.jdField_a_of_type_JavaLangString + paramBitmap1;
      }
    }
    label524:
    label577:
    for (;;)
    {
      f1 = localPaint.measureText(paramBitmap1);
      localCanvas.drawText(paramBitmap1, localBitmap.getWidth() / 2 - f1 / 2.0F, 359.20001F, localPaint);
      this.jdField_a_of_type_Baaj = new baaj(this, localBitmap);
      this.jdField_a_of_type_Baaj.c = (this.jdField_a_of_type_Bcra.jdField_a_of_type_Int / 2);
      this.jdField_a_of_type_Baaj.d = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Baaj.e = 0.0F;
      a(this.jdField_a_of_type_Baaj);
      if (paramBitmap3 != null)
      {
        this.jdField_a_of_type_Baad = new baad(this, paramBitmap3, false);
        this.jdField_a_of_type_Baad.a(this.jdField_a_of_type_Bcra.jdField_a_of_type_Int / 2, this.jdField_a_of_type_Bcra.jdField_b_of_type_Int * this.jdField_a_of_type_Bcra.f / 100);
      }
      try
      {
        this.jdField_b_of_type_Baad = new baad(this, BitmapFactory.decodeResource(getResources(), 2130846643), true);
        this.jdField_b_of_type_Baad.a(parambcra.jdField_a_of_type_Int - bdcq.a(getContext(), 40.0F), bdcq.a(getContext(), 120.0F));
        this.jdField_b_of_type_Baad.a(parambaae);
        this.jdField_b_of_type_Baad.e = 0.75F;
        a(this.jdField_b_of_type_Baad);
        return;
        paramBitmap1 = parambcra.jdField_a_of_type_JavaLangString.substring(0, j) + "..." + paramBitmap1;
      }
      catch (OutOfMemoryError paramBitmap1)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("TroopGiftToAllSurfaceView", 2, "decode closeButton failed");
        return;
      }
    }
  }
  
  public void a(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, String paramString, baae parambaae, bcra parambcra)
  {
    this.jdField_a_of_type_Bcra = parambcra;
    this.jdField_a_of_type_Int = (parambcra.jdField_b_of_type_Int * parambcra.c / 100);
    this.jdField_a_of_type_Float = (getResources().getDisplayMetrics().density / 2.0F);
    this.jdField_a_of_type_JavaLangString = paramString;
    paramString = new VideoSprite(this, getContext(), true);
    paramString.b = true;
    paramString.c = (this.jdField_a_of_type_Bcra.jdField_a_of_type_Int / 2);
    paramString.d = (this.jdField_a_of_type_Bcra.jdField_b_of_type_Int / 2);
    this.jdField_b_of_type_Baaj = paramString;
    a(paramBitmap1, paramBitmap2, paramBitmap3, parambaae, parambcra);
  }
  
  public void a(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, String[] paramArrayOfString, baae parambaae, bcra parambcra)
  {
    this.jdField_a_of_type_Bcra = parambcra;
    this.jdField_a_of_type_Int = (parambcra.jdField_b_of_type_Int * parambcra.c / 100);
    this.jdField_a_of_type_Float = (getResources().getDisplayMetrics().density / 2.0F);
    paramArrayOfString = new azzz(this, paramArrayOfString);
    this.jdField_b_of_type_Baaj = paramArrayOfString;
    this.jdField_b_of_type_Baaj.c = (this.jdField_a_of_type_Bcra.jdField_a_of_type_Int / 2);
    this.jdField_b_of_type_Baaj.d = (this.jdField_a_of_type_Bcra.jdField_b_of_type_Int / 2);
    this.jdField_b_of_type_Baaj.e = parambcra.jdField_a_of_type_Float;
    paramArrayOfString.e(parambcra.h);
    paramArrayOfString.a(true);
    a(paramBitmap1, paramBitmap2, paramBitmap3, parambaae, parambcra);
  }
  
  public void a(azzg paramazzg)
  {
    if (this.jdField_b_of_type_Baaj != null) {
      this.jdField_b_of_type_Baaj.a(new azzf[] { new azzl(500, 255, 0, 1) });
    }
    azzl localazzl = new azzl(500, 255, 0, 1);
    localazzl.a(paramazzg);
    if (this.jdField_a_of_type_Baaj != null) {
      this.jdField_a_of_type_Baaj.a(new azzf[] { localazzl });
    }
    if (this.jdField_a_of_type_Baad != null)
    {
      this.jdField_a_of_type_Baad.a(null);
      this.jdField_a_of_type_Baad.a(new azzf[] { new azzl(500, 255, 0, 1) });
    }
    if (this.jdField_a_of_type_Baaf != null) {
      this.jdField_a_of_type_Baaf.a(new azzf[] { new azzl(500, 255, 0, 1) });
    }
    if (this.jdField_b_of_type_Baad != null) {
      this.jdField_b_of_type_Baad.a(new azzf[] { new azzl(500, 255, 0, 1) });
    }
  }
  
  public void a(baaa parambaaa)
  {
    if (this.jdField_a_of_type_Baaj != null)
    {
      azzo localazzo = new azzo(new azzf[] { new azzn(500, 0.0F, this.jdField_a_of_type_Float * 1.1F), new azzn(200, this.jdField_a_of_type_Float * 1.1F, this.jdField_a_of_type_Float * 0.95F), new azzn(200, this.jdField_a_of_type_Float * 0.95F, this.jdField_a_of_type_Float * 1.05F), new azzn(200, this.jdField_a_of_type_Float * 1.05F, this.jdField_a_of_type_Float * 1.0F) });
      this.jdField_a_of_type_Baaj.a(new azzf[] { localazzo });
    }
    if ((this.jdField_b_of_type_Baaj != null) && ((this.jdField_b_of_type_Baaj instanceof azzz)))
    {
      ((azzz)this.jdField_b_of_type_Baaj).a = new bcqv(this, parambaaa);
      ((azzz)this.jdField_b_of_type_Baaj).a(getContext(), this);
    }
    for (;;)
    {
      parambaaa = new azzh(500);
      parambaaa.a(new bcqw(this));
      if (this.jdField_a_of_type_Baaj != null) {
        this.jdField_a_of_type_Baaj.a(new azzf[] { parambaaa });
      }
      return;
      if ((this.jdField_b_of_type_Baaj != null) && ((this.jdField_b_of_type_Baaj instanceof VideoSprite))) {
        ((VideoSprite)this.jdField_b_of_type_Baaj).a(parambaaa);
      }
    }
  }
  
  public void a(baae parambaae)
  {
    if (this.jdField_a_of_type_Baad != null)
    {
      this.jdField_a_of_type_Baad.a(parambaae);
      this.jdField_a_of_type_Baad.e = 0.0F;
      a(this.jdField_a_of_type_Baad);
      parambaae = new azzo(new azzf[] { new azzn(500, 0.0F, this.jdField_a_of_type_Float * 1.1F), new azzn(200, this.jdField_a_of_type_Float * 1.1F, this.jdField_a_of_type_Float * 0.88F), new azzn(200, this.jdField_a_of_type_Float * 0.88F, this.jdField_a_of_type_Float) });
      parambaae.a(new bcqx(this));
      this.jdField_a_of_type_Baad.a(new azzf[] { parambaae });
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
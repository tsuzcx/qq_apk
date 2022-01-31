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
import aybg;
import aybh;
import aybi;
import aybm;
import aybo;
import aybp;
import ayca;
import aycb;
import ayce;
import aycf;
import aycg;
import ayck;
import barn;
import baro;
import barp;
import barq;
import bars;
import bbdh;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite;
import com.tencent.qphone.base.util.QLog;

public class TroopGiftToAllSurfaceView
  extends SpriteGLView
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private ayce jdField_a_of_type_Ayce;
  private aycg jdField_a_of_type_Aycg;
  private ayck jdField_a_of_type_Ayck;
  private bars jdField_a_of_type_Bars;
  private String jdField_a_of_type_JavaLangString;
  private ayce jdField_b_of_type_Ayce;
  private ayck jdField_b_of_type_Ayck;
  
  public TroopGiftToAllSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Ayce != null)
    {
      aybm localaybm = new aybm(500, 255, 0);
      localaybm.a(new barq(this));
      this.jdField_a_of_type_Ayce.a(new aybg[] { localaybm });
    }
  }
  
  protected void a(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, aycf paramaycf, bars parambars)
  {
    Bitmap localBitmap;
    Canvas localCanvas;
    Paint localPaint;
    float f1;
    int j;
    if ((!parambars.jdField_a_of_type_Boolean) && (paramBitmap1 != null))
    {
      localBitmap = paramBitmap1.copy(Bitmap.Config.ARGB_8888, true);
      localCanvas = new Canvas(localBitmap);
      localPaint = new Paint();
      localPaint.setAntiAlias(true);
      localPaint.setColor(parambars.g);
      localPaint.setTextSize(34.0F);
      paramBitmap1 = new Matrix();
      f1 = 140.0F / paramBitmap2.getWidth();
      paramBitmap1.postScale(f1, f1);
      paramBitmap1.postTranslate((localBitmap.getWidth() - f1 * paramBitmap2.getWidth()) / 2.0F, 154.0F);
      localCanvas.drawBitmap(paramBitmap2, paramBitmap1, localPaint);
      if ((!TextUtils.isEmpty(parambars.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(parambars.jdField_a_of_type_JavaLangString)))
      {
        float f2 = localPaint.measureText(parambars.jdField_b_of_type_JavaLangString);
        f1 = 0.0F;
        j = 0;
        paramBitmap1 = parambars.jdField_b_of_type_JavaLangString;
        int i = 0;
        while (i < parambars.jdField_a_of_type_JavaLangString.length())
        {
          float f3 = localPaint.measureText("" + parambars.jdField_a_of_type_JavaLangString.charAt(i));
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
        if (j != parambars.jdField_a_of_type_JavaLangString.length()) {
          break label524;
        }
        paramBitmap1 = parambars.jdField_a_of_type_JavaLangString + paramBitmap1;
      }
    }
    label524:
    label577:
    for (;;)
    {
      f1 = localPaint.measureText(paramBitmap1);
      localCanvas.drawText(paramBitmap1, localBitmap.getWidth() / 2 - f1 / 2.0F, 359.20001F, localPaint);
      this.jdField_a_of_type_Ayck = new ayck(this, localBitmap);
      this.jdField_a_of_type_Ayck.c = (this.jdField_a_of_type_Bars.jdField_a_of_type_Int / 2);
      this.jdField_a_of_type_Ayck.d = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Ayck.e = 0.0F;
      a(this.jdField_a_of_type_Ayck);
      if (paramBitmap3 != null)
      {
        this.jdField_a_of_type_Ayce = new ayce(this, paramBitmap3, false);
        this.jdField_a_of_type_Ayce.a(this.jdField_a_of_type_Bars.jdField_a_of_type_Int / 2, this.jdField_a_of_type_Bars.jdField_b_of_type_Int * this.jdField_a_of_type_Bars.f / 100);
      }
      try
      {
        this.jdField_b_of_type_Ayce = new ayce(this, BitmapFactory.decodeResource(getResources(), 2130846258), true);
        this.jdField_b_of_type_Ayce.a(parambars.jdField_a_of_type_Int - bbdh.a(getContext(), 40.0F), bbdh.a(getContext(), 120.0F));
        this.jdField_b_of_type_Ayce.a(paramaycf);
        this.jdField_b_of_type_Ayce.e = 0.75F;
        a(this.jdField_b_of_type_Ayce);
        return;
        paramBitmap1 = parambars.jdField_a_of_type_JavaLangString.substring(0, j) + "..." + paramBitmap1;
      }
      catch (OutOfMemoryError paramBitmap1)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("TroopGiftToAllSurfaceView", 2, "decode closeButton failed");
        return;
      }
    }
  }
  
  public void a(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, String paramString, aycf paramaycf, bars parambars)
  {
    this.jdField_a_of_type_Bars = parambars;
    this.jdField_a_of_type_Int = (parambars.jdField_b_of_type_Int * parambars.c / 100);
    this.jdField_a_of_type_Float = (getResources().getDisplayMetrics().density / 2.0F);
    this.jdField_a_of_type_JavaLangString = paramString;
    paramString = new VideoSprite(this, getContext(), true);
    paramString.b = true;
    paramString.c = (this.jdField_a_of_type_Bars.jdField_a_of_type_Int / 2);
    paramString.d = (this.jdField_a_of_type_Bars.jdField_b_of_type_Int / 2);
    this.jdField_b_of_type_Ayck = paramString;
    a(paramBitmap1, paramBitmap2, paramBitmap3, paramaycf, parambars);
  }
  
  public void a(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, String[] paramArrayOfString, aycf paramaycf, bars parambars)
  {
    this.jdField_a_of_type_Bars = parambars;
    this.jdField_a_of_type_Int = (parambars.jdField_b_of_type_Int * parambars.c / 100);
    this.jdField_a_of_type_Float = (getResources().getDisplayMetrics().density / 2.0F);
    paramArrayOfString = new ayca(this, paramArrayOfString);
    this.jdField_b_of_type_Ayck = paramArrayOfString;
    this.jdField_b_of_type_Ayck.c = (this.jdField_a_of_type_Bars.jdField_a_of_type_Int / 2);
    this.jdField_b_of_type_Ayck.d = (this.jdField_a_of_type_Bars.jdField_b_of_type_Int / 2);
    this.jdField_b_of_type_Ayck.e = parambars.jdField_a_of_type_Float;
    paramArrayOfString.e(parambars.h);
    paramArrayOfString.a(true);
    a(paramBitmap1, paramBitmap2, paramBitmap3, paramaycf, parambars);
  }
  
  public void a(aybh paramaybh)
  {
    if (this.jdField_b_of_type_Ayck != null) {
      this.jdField_b_of_type_Ayck.a(new aybg[] { new aybm(500, 255, 0, 1) });
    }
    aybm localaybm = new aybm(500, 255, 0, 1);
    localaybm.a(paramaybh);
    if (this.jdField_a_of_type_Ayck != null) {
      this.jdField_a_of_type_Ayck.a(new aybg[] { localaybm });
    }
    if (this.jdField_a_of_type_Ayce != null)
    {
      this.jdField_a_of_type_Ayce.a(null);
      this.jdField_a_of_type_Ayce.a(new aybg[] { new aybm(500, 255, 0, 1) });
    }
    if (this.jdField_a_of_type_Aycg != null) {
      this.jdField_a_of_type_Aycg.a(new aybg[] { new aybm(500, 255, 0, 1) });
    }
    if (this.jdField_b_of_type_Ayce != null) {
      this.jdField_b_of_type_Ayce.a(new aybg[] { new aybm(500, 255, 0, 1) });
    }
  }
  
  public void a(aycb paramaycb)
  {
    if (this.jdField_a_of_type_Ayck != null)
    {
      aybp localaybp = new aybp(new aybg[] { new aybo(500, 0.0F, this.jdField_a_of_type_Float * 1.1F), new aybo(200, this.jdField_a_of_type_Float * 1.1F, this.jdField_a_of_type_Float * 0.95F), new aybo(200, this.jdField_a_of_type_Float * 0.95F, this.jdField_a_of_type_Float * 1.05F), new aybo(200, this.jdField_a_of_type_Float * 1.05F, this.jdField_a_of_type_Float * 1.0F) });
      this.jdField_a_of_type_Ayck.a(new aybg[] { localaybp });
    }
    if ((this.jdField_b_of_type_Ayck != null) && ((this.jdField_b_of_type_Ayck instanceof ayca)))
    {
      ((ayca)this.jdField_b_of_type_Ayck).a = new barn(this, paramaycb);
      ((ayca)this.jdField_b_of_type_Ayck).a(getContext(), this);
    }
    for (;;)
    {
      paramaycb = new aybi(500);
      paramaycb.a(new baro(this));
      if (this.jdField_a_of_type_Ayck != null) {
        this.jdField_a_of_type_Ayck.a(new aybg[] { paramaycb });
      }
      return;
      if ((this.jdField_b_of_type_Ayck != null) && ((this.jdField_b_of_type_Ayck instanceof VideoSprite))) {
        ((VideoSprite)this.jdField_b_of_type_Ayck).a(paramaycb);
      }
    }
  }
  
  public void a(aycf paramaycf)
  {
    if (this.jdField_a_of_type_Ayce != null)
    {
      this.jdField_a_of_type_Ayce.a(paramaycf);
      this.jdField_a_of_type_Ayce.e = 0.0F;
      a(this.jdField_a_of_type_Ayce);
      paramaycf = new aybp(new aybg[] { new aybo(500, 0.0F, this.jdField_a_of_type_Float * 1.1F), new aybo(200, this.jdField_a_of_type_Float * 1.1F, this.jdField_a_of_type_Float * 0.88F), new aybo(200, this.jdField_a_of_type_Float * 0.88F, this.jdField_a_of_type_Float) });
      paramaycf.a(new barp(this));
      this.jdField_a_of_type_Ayce.a(new aybg[] { paramaycf });
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
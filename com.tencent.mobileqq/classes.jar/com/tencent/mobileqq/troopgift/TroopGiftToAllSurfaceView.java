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
import bdes;
import bdet;
import bdeu;
import bdey;
import bdfa;
import bdfb;
import bdfm;
import bdfn;
import bdfq;
import bdfr;
import bdfs;
import bdfw;
import bfzp;
import bfzq;
import bfzr;
import bfzs;
import bfzu;
import bgme;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite;
import com.tencent.qphone.base.util.QLog;

public class TroopGiftToAllSurfaceView
  extends SpriteGLView
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private bdfq jdField_a_of_type_Bdfq;
  private bdfs jdField_a_of_type_Bdfs;
  private bdfw jdField_a_of_type_Bdfw;
  private bfzu jdField_a_of_type_Bfzu;
  private String jdField_a_of_type_JavaLangString;
  private bdfq jdField_b_of_type_Bdfq;
  private bdfw jdField_b_of_type_Bdfw;
  
  public TroopGiftToAllSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bdfq != null)
    {
      bdey localbdey = new bdey(500, 255, 0);
      localbdey.a(new bfzs(this));
      this.jdField_a_of_type_Bdfq.a(new bdes[] { localbdey });
    }
  }
  
  protected void a(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, bdfr parambdfr, bfzu parambfzu)
  {
    Bitmap localBitmap;
    Canvas localCanvas;
    Paint localPaint;
    float f1;
    int j;
    if ((!parambfzu.jdField_a_of_type_Boolean) && (paramBitmap1 != null))
    {
      localBitmap = paramBitmap1.copy(Bitmap.Config.ARGB_8888, true);
      localCanvas = new Canvas(localBitmap);
      localPaint = new Paint();
      localPaint.setAntiAlias(true);
      localPaint.setColor(parambfzu.g);
      localPaint.setTextSize(34.0F);
      paramBitmap1 = new Matrix();
      f1 = 140.0F / paramBitmap2.getWidth();
      paramBitmap1.postScale(f1, f1);
      paramBitmap1.postTranslate((localBitmap.getWidth() - f1 * paramBitmap2.getWidth()) / 2.0F, 154.0F);
      localCanvas.drawBitmap(paramBitmap2, paramBitmap1, localPaint);
      if ((!TextUtils.isEmpty(parambfzu.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(parambfzu.jdField_a_of_type_JavaLangString)))
      {
        float f2 = localPaint.measureText(parambfzu.jdField_b_of_type_JavaLangString);
        f1 = 0.0F;
        j = 0;
        paramBitmap1 = parambfzu.jdField_b_of_type_JavaLangString;
        int i = 0;
        while (i < parambfzu.jdField_a_of_type_JavaLangString.length())
        {
          float f3 = localPaint.measureText("" + parambfzu.jdField_a_of_type_JavaLangString.charAt(i));
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
        if (j != parambfzu.jdField_a_of_type_JavaLangString.length()) {
          break label524;
        }
        paramBitmap1 = parambfzu.jdField_a_of_type_JavaLangString + paramBitmap1;
      }
    }
    label524:
    label577:
    for (;;)
    {
      f1 = localPaint.measureText(paramBitmap1);
      localCanvas.drawText(paramBitmap1, localBitmap.getWidth() / 2 - f1 / 2.0F, 359.20001F, localPaint);
      this.jdField_a_of_type_Bdfw = new bdfw(this, localBitmap);
      this.jdField_a_of_type_Bdfw.c = (this.jdField_a_of_type_Bfzu.jdField_a_of_type_Int / 2);
      this.jdField_a_of_type_Bdfw.d = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Bdfw.e = 0.0F;
      a(this.jdField_a_of_type_Bdfw);
      if (paramBitmap3 != null)
      {
        this.jdField_a_of_type_Bdfq = new bdfq(this, paramBitmap3, false);
        this.jdField_a_of_type_Bdfq.a(this.jdField_a_of_type_Bfzu.jdField_a_of_type_Int / 2, this.jdField_a_of_type_Bfzu.jdField_b_of_type_Int * this.jdField_a_of_type_Bfzu.f / 100);
      }
      try
      {
        this.jdField_b_of_type_Bdfq = new bdfq(this, BitmapFactory.decodeResource(getResources(), 2130847164), true);
        this.jdField_b_of_type_Bdfq.a(parambfzu.jdField_a_of_type_Int - bgme.a(getContext(), 40.0F), bgme.a(getContext(), 120.0F));
        this.jdField_b_of_type_Bdfq.a(parambdfr);
        this.jdField_b_of_type_Bdfq.e = 0.75F;
        a(this.jdField_b_of_type_Bdfq);
        return;
        paramBitmap1 = parambfzu.jdField_a_of_type_JavaLangString.substring(0, j) + "..." + paramBitmap1;
      }
      catch (OutOfMemoryError paramBitmap1)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("TroopGiftToAllSurfaceView", 2, "decode closeButton failed");
        return;
      }
    }
  }
  
  public void a(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, String paramString, bdfr parambdfr, bfzu parambfzu)
  {
    this.jdField_a_of_type_Bfzu = parambfzu;
    this.jdField_a_of_type_Int = (parambfzu.jdField_b_of_type_Int * parambfzu.c / 100);
    this.jdField_a_of_type_Float = (getResources().getDisplayMetrics().density / 2.0F);
    this.jdField_a_of_type_JavaLangString = paramString;
    paramString = new VideoSprite(this, getContext(), true);
    paramString.b = true;
    paramString.c = (this.jdField_a_of_type_Bfzu.jdField_a_of_type_Int / 2);
    paramString.d = (this.jdField_a_of_type_Bfzu.jdField_b_of_type_Int / 2);
    this.jdField_b_of_type_Bdfw = paramString;
    a(paramBitmap1, paramBitmap2, paramBitmap3, parambdfr, parambfzu);
  }
  
  public void a(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, String[] paramArrayOfString, bdfr parambdfr, bfzu parambfzu)
  {
    this.jdField_a_of_type_Bfzu = parambfzu;
    this.jdField_a_of_type_Int = (parambfzu.jdField_b_of_type_Int * parambfzu.c / 100);
    this.jdField_a_of_type_Float = (getResources().getDisplayMetrics().density / 2.0F);
    paramArrayOfString = new bdfm(this, paramArrayOfString);
    this.jdField_b_of_type_Bdfw = paramArrayOfString;
    this.jdField_b_of_type_Bdfw.c = (this.jdField_a_of_type_Bfzu.jdField_a_of_type_Int / 2);
    this.jdField_b_of_type_Bdfw.d = (this.jdField_a_of_type_Bfzu.jdField_b_of_type_Int / 2);
    this.jdField_b_of_type_Bdfw.e = parambfzu.jdField_a_of_type_Float;
    paramArrayOfString.e(parambfzu.h);
    paramArrayOfString.a(true);
    a(paramBitmap1, paramBitmap2, paramBitmap3, parambdfr, parambfzu);
  }
  
  public void a(bdet parambdet)
  {
    if (this.jdField_b_of_type_Bdfw != null) {
      this.jdField_b_of_type_Bdfw.a(new bdes[] { new bdey(500, 255, 0, 1) });
    }
    bdey localbdey = new bdey(500, 255, 0, 1);
    localbdey.a(parambdet);
    if (this.jdField_a_of_type_Bdfw != null) {
      this.jdField_a_of_type_Bdfw.a(new bdes[] { localbdey });
    }
    if (this.jdField_a_of_type_Bdfq != null)
    {
      this.jdField_a_of_type_Bdfq.a(null);
      this.jdField_a_of_type_Bdfq.a(new bdes[] { new bdey(500, 255, 0, 1) });
    }
    if (this.jdField_a_of_type_Bdfs != null) {
      this.jdField_a_of_type_Bdfs.a(new bdes[] { new bdey(500, 255, 0, 1) });
    }
    if (this.jdField_b_of_type_Bdfq != null) {
      this.jdField_b_of_type_Bdfq.a(new bdes[] { new bdey(500, 255, 0, 1) });
    }
  }
  
  public void a(bdfn parambdfn)
  {
    if (this.jdField_a_of_type_Bdfw != null)
    {
      bdfb localbdfb = new bdfb(new bdes[] { new bdfa(500, 0.0F, this.jdField_a_of_type_Float * 1.1F), new bdfa(200, this.jdField_a_of_type_Float * 1.1F, this.jdField_a_of_type_Float * 0.95F), new bdfa(200, this.jdField_a_of_type_Float * 0.95F, this.jdField_a_of_type_Float * 1.05F), new bdfa(200, this.jdField_a_of_type_Float * 1.05F, this.jdField_a_of_type_Float * 1.0F) });
      this.jdField_a_of_type_Bdfw.a(new bdes[] { localbdfb });
    }
    if ((this.jdField_b_of_type_Bdfw != null) && ((this.jdField_b_of_type_Bdfw instanceof bdfm)))
    {
      ((bdfm)this.jdField_b_of_type_Bdfw).a = new bfzp(this, parambdfn);
      ((bdfm)this.jdField_b_of_type_Bdfw).a(getContext(), this);
    }
    for (;;)
    {
      parambdfn = new bdeu(500);
      parambdfn.a(new bfzq(this));
      if (this.jdField_a_of_type_Bdfw != null) {
        this.jdField_a_of_type_Bdfw.a(new bdes[] { parambdfn });
      }
      return;
      if ((this.jdField_b_of_type_Bdfw != null) && ((this.jdField_b_of_type_Bdfw instanceof VideoSprite))) {
        ((VideoSprite)this.jdField_b_of_type_Bdfw).a(parambdfn);
      }
    }
  }
  
  public void a(bdfr parambdfr)
  {
    if (this.jdField_a_of_type_Bdfq != null)
    {
      this.jdField_a_of_type_Bdfq.a(parambdfr);
      this.jdField_a_of_type_Bdfq.e = 0.0F;
      a(this.jdField_a_of_type_Bdfq);
      parambdfr = new bdfb(new bdes[] { new bdfa(500, 0.0F, this.jdField_a_of_type_Float * 1.1F), new bdfa(200, this.jdField_a_of_type_Float * 1.1F, this.jdField_a_of_type_Float * 0.88F), new bdfa(200, this.jdField_a_of_type_Float * 0.88F, this.jdField_a_of_type_Float) });
      parambdfr.a(new bfzr(this));
      this.jdField_a_of_type_Bdfq.a(new bdes[] { parambdfr });
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
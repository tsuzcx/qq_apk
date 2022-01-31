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
import aybi;
import aybj;
import aybk;
import aybo;
import aybq;
import aybr;
import aycc;
import aycd;
import aycg;
import aych;
import ayci;
import aycm;
import basb;
import basc;
import basd;
import base;
import basg;
import bbdv;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite;
import com.tencent.qphone.base.util.QLog;

public class TroopGiftToAllSurfaceView
  extends SpriteGLView
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private aycg jdField_a_of_type_Aycg;
  private ayci jdField_a_of_type_Ayci;
  private aycm jdField_a_of_type_Aycm;
  private basg jdField_a_of_type_Basg;
  private String jdField_a_of_type_JavaLangString;
  private aycg jdField_b_of_type_Aycg;
  private aycm jdField_b_of_type_Aycm;
  
  public TroopGiftToAllSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aycg != null)
    {
      aybo localaybo = new aybo(500, 255, 0);
      localaybo.a(new base(this));
      this.jdField_a_of_type_Aycg.a(new aybi[] { localaybo });
    }
  }
  
  protected void a(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, aych paramaych, basg parambasg)
  {
    Bitmap localBitmap;
    Canvas localCanvas;
    Paint localPaint;
    float f1;
    int j;
    if ((!parambasg.jdField_a_of_type_Boolean) && (paramBitmap1 != null))
    {
      localBitmap = paramBitmap1.copy(Bitmap.Config.ARGB_8888, true);
      localCanvas = new Canvas(localBitmap);
      localPaint = new Paint();
      localPaint.setAntiAlias(true);
      localPaint.setColor(parambasg.g);
      localPaint.setTextSize(34.0F);
      paramBitmap1 = new Matrix();
      f1 = 140.0F / paramBitmap2.getWidth();
      paramBitmap1.postScale(f1, f1);
      paramBitmap1.postTranslate((localBitmap.getWidth() - f1 * paramBitmap2.getWidth()) / 2.0F, 154.0F);
      localCanvas.drawBitmap(paramBitmap2, paramBitmap1, localPaint);
      if ((!TextUtils.isEmpty(parambasg.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(parambasg.jdField_a_of_type_JavaLangString)))
      {
        float f2 = localPaint.measureText(parambasg.jdField_b_of_type_JavaLangString);
        f1 = 0.0F;
        j = 0;
        paramBitmap1 = parambasg.jdField_b_of_type_JavaLangString;
        int i = 0;
        while (i < parambasg.jdField_a_of_type_JavaLangString.length())
        {
          float f3 = localPaint.measureText("" + parambasg.jdField_a_of_type_JavaLangString.charAt(i));
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
        if (j != parambasg.jdField_a_of_type_JavaLangString.length()) {
          break label524;
        }
        paramBitmap1 = parambasg.jdField_a_of_type_JavaLangString + paramBitmap1;
      }
    }
    label524:
    label577:
    for (;;)
    {
      f1 = localPaint.measureText(paramBitmap1);
      localCanvas.drawText(paramBitmap1, localBitmap.getWidth() / 2 - f1 / 2.0F, 359.20001F, localPaint);
      this.jdField_a_of_type_Aycm = new aycm(this, localBitmap);
      this.jdField_a_of_type_Aycm.c = (this.jdField_a_of_type_Basg.jdField_a_of_type_Int / 2);
      this.jdField_a_of_type_Aycm.d = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Aycm.e = 0.0F;
      a(this.jdField_a_of_type_Aycm);
      if (paramBitmap3 != null)
      {
        this.jdField_a_of_type_Aycg = new aycg(this, paramBitmap3, false);
        this.jdField_a_of_type_Aycg.a(this.jdField_a_of_type_Basg.jdField_a_of_type_Int / 2, this.jdField_a_of_type_Basg.jdField_b_of_type_Int * this.jdField_a_of_type_Basg.f / 100);
      }
      try
      {
        this.jdField_b_of_type_Aycg = new aycg(this, BitmapFactory.decodeResource(getResources(), 2130846264), true);
        this.jdField_b_of_type_Aycg.a(parambasg.jdField_a_of_type_Int - bbdv.a(getContext(), 40.0F), bbdv.a(getContext(), 120.0F));
        this.jdField_b_of_type_Aycg.a(paramaych);
        this.jdField_b_of_type_Aycg.e = 0.75F;
        a(this.jdField_b_of_type_Aycg);
        return;
        paramBitmap1 = parambasg.jdField_a_of_type_JavaLangString.substring(0, j) + "..." + paramBitmap1;
      }
      catch (OutOfMemoryError paramBitmap1)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("TroopGiftToAllSurfaceView", 2, "decode closeButton failed");
        return;
      }
    }
  }
  
  public void a(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, String paramString, aych paramaych, basg parambasg)
  {
    this.jdField_a_of_type_Basg = parambasg;
    this.jdField_a_of_type_Int = (parambasg.jdField_b_of_type_Int * parambasg.c / 100);
    this.jdField_a_of_type_Float = (getResources().getDisplayMetrics().density / 2.0F);
    this.jdField_a_of_type_JavaLangString = paramString;
    paramString = new VideoSprite(this, getContext(), true);
    paramString.b = true;
    paramString.c = (this.jdField_a_of_type_Basg.jdField_a_of_type_Int / 2);
    paramString.d = (this.jdField_a_of_type_Basg.jdField_b_of_type_Int / 2);
    this.jdField_b_of_type_Aycm = paramString;
    a(paramBitmap1, paramBitmap2, paramBitmap3, paramaych, parambasg);
  }
  
  public void a(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, String[] paramArrayOfString, aych paramaych, basg parambasg)
  {
    this.jdField_a_of_type_Basg = parambasg;
    this.jdField_a_of_type_Int = (parambasg.jdField_b_of_type_Int * parambasg.c / 100);
    this.jdField_a_of_type_Float = (getResources().getDisplayMetrics().density / 2.0F);
    paramArrayOfString = new aycc(this, paramArrayOfString);
    this.jdField_b_of_type_Aycm = paramArrayOfString;
    this.jdField_b_of_type_Aycm.c = (this.jdField_a_of_type_Basg.jdField_a_of_type_Int / 2);
    this.jdField_b_of_type_Aycm.d = (this.jdField_a_of_type_Basg.jdField_b_of_type_Int / 2);
    this.jdField_b_of_type_Aycm.e = parambasg.jdField_a_of_type_Float;
    paramArrayOfString.e(parambasg.h);
    paramArrayOfString.a(true);
    a(paramBitmap1, paramBitmap2, paramBitmap3, paramaych, parambasg);
  }
  
  public void a(aybj paramaybj)
  {
    if (this.jdField_b_of_type_Aycm != null) {
      this.jdField_b_of_type_Aycm.a(new aybi[] { new aybo(500, 255, 0, 1) });
    }
    aybo localaybo = new aybo(500, 255, 0, 1);
    localaybo.a(paramaybj);
    if (this.jdField_a_of_type_Aycm != null) {
      this.jdField_a_of_type_Aycm.a(new aybi[] { localaybo });
    }
    if (this.jdField_a_of_type_Aycg != null)
    {
      this.jdField_a_of_type_Aycg.a(null);
      this.jdField_a_of_type_Aycg.a(new aybi[] { new aybo(500, 255, 0, 1) });
    }
    if (this.jdField_a_of_type_Ayci != null) {
      this.jdField_a_of_type_Ayci.a(new aybi[] { new aybo(500, 255, 0, 1) });
    }
    if (this.jdField_b_of_type_Aycg != null) {
      this.jdField_b_of_type_Aycg.a(new aybi[] { new aybo(500, 255, 0, 1) });
    }
  }
  
  public void a(aycd paramaycd)
  {
    if (this.jdField_a_of_type_Aycm != null)
    {
      aybr localaybr = new aybr(new aybi[] { new aybq(500, 0.0F, this.jdField_a_of_type_Float * 1.1F), new aybq(200, this.jdField_a_of_type_Float * 1.1F, this.jdField_a_of_type_Float * 0.95F), new aybq(200, this.jdField_a_of_type_Float * 0.95F, this.jdField_a_of_type_Float * 1.05F), new aybq(200, this.jdField_a_of_type_Float * 1.05F, this.jdField_a_of_type_Float * 1.0F) });
      this.jdField_a_of_type_Aycm.a(new aybi[] { localaybr });
    }
    if ((this.jdField_b_of_type_Aycm != null) && ((this.jdField_b_of_type_Aycm instanceof aycc)))
    {
      ((aycc)this.jdField_b_of_type_Aycm).a = new basb(this, paramaycd);
      ((aycc)this.jdField_b_of_type_Aycm).a(getContext(), this);
    }
    for (;;)
    {
      paramaycd = new aybk(500);
      paramaycd.a(new basc(this));
      if (this.jdField_a_of_type_Aycm != null) {
        this.jdField_a_of_type_Aycm.a(new aybi[] { paramaycd });
      }
      return;
      if ((this.jdField_b_of_type_Aycm != null) && ((this.jdField_b_of_type_Aycm instanceof VideoSprite))) {
        ((VideoSprite)this.jdField_b_of_type_Aycm).a(paramaycd);
      }
    }
  }
  
  public void a(aych paramaych)
  {
    if (this.jdField_a_of_type_Aycg != null)
    {
      this.jdField_a_of_type_Aycg.a(paramaych);
      this.jdField_a_of_type_Aycg.e = 0.0F;
      a(this.jdField_a_of_type_Aycg);
      paramaych = new aybr(new aybi[] { new aybq(500, 0.0F, this.jdField_a_of_type_Float * 1.1F), new aybq(200, this.jdField_a_of_type_Float * 1.1F, this.jdField_a_of_type_Float * 0.88F), new aybq(200, this.jdField_a_of_type_Float * 0.88F, this.jdField_a_of_type_Float) });
      paramaych.a(new basd(this));
      this.jdField_a_of_type_Aycg.a(new aybi[] { paramaych });
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
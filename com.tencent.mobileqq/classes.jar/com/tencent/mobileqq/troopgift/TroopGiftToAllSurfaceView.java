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
import bcre;
import bcrf;
import bcrg;
import bcrk;
import bcrm;
import bcrn;
import bcry;
import bcrz;
import bcsc;
import bcsd;
import bcse;
import bcsi;
import bfjc;
import bfjd;
import bfje;
import bfjf;
import bfjh;
import bfvh;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite;
import com.tencent.qphone.base.util.QLog;

public class TroopGiftToAllSurfaceView
  extends SpriteGLView
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private bcsc jdField_a_of_type_Bcsc;
  private bcse jdField_a_of_type_Bcse;
  private bcsi jdField_a_of_type_Bcsi;
  private bfjh jdField_a_of_type_Bfjh;
  private String jdField_a_of_type_JavaLangString;
  private bcsc jdField_b_of_type_Bcsc;
  private bcsi jdField_b_of_type_Bcsi;
  
  public TroopGiftToAllSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bcsc != null)
    {
      bcrk localbcrk = new bcrk(500, 255, 0);
      localbcrk.a(new bfjf(this));
      this.jdField_a_of_type_Bcsc.a(new bcre[] { localbcrk });
    }
  }
  
  protected void a(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, bcsd parambcsd, bfjh parambfjh)
  {
    Bitmap localBitmap;
    Canvas localCanvas;
    Paint localPaint;
    float f1;
    int j;
    if ((!parambfjh.jdField_a_of_type_Boolean) && (paramBitmap1 != null))
    {
      localBitmap = paramBitmap1.copy(Bitmap.Config.ARGB_8888, true);
      localCanvas = new Canvas(localBitmap);
      localPaint = new Paint();
      localPaint.setAntiAlias(true);
      localPaint.setColor(parambfjh.g);
      localPaint.setTextSize(34.0F);
      paramBitmap1 = new Matrix();
      f1 = 140.0F / paramBitmap2.getWidth();
      paramBitmap1.postScale(f1, f1);
      paramBitmap1.postTranslate((localBitmap.getWidth() - f1 * paramBitmap2.getWidth()) / 2.0F, 154.0F);
      localCanvas.drawBitmap(paramBitmap2, paramBitmap1, localPaint);
      if ((!TextUtils.isEmpty(parambfjh.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(parambfjh.jdField_a_of_type_JavaLangString)))
      {
        float f2 = localPaint.measureText(parambfjh.jdField_b_of_type_JavaLangString);
        f1 = 0.0F;
        j = 0;
        paramBitmap1 = parambfjh.jdField_b_of_type_JavaLangString;
        int i = 0;
        while (i < parambfjh.jdField_a_of_type_JavaLangString.length())
        {
          float f3 = localPaint.measureText("" + parambfjh.jdField_a_of_type_JavaLangString.charAt(i));
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
        if (j != parambfjh.jdField_a_of_type_JavaLangString.length()) {
          break label524;
        }
        paramBitmap1 = parambfjh.jdField_a_of_type_JavaLangString + paramBitmap1;
      }
    }
    label524:
    label577:
    for (;;)
    {
      f1 = localPaint.measureText(paramBitmap1);
      localCanvas.drawText(paramBitmap1, localBitmap.getWidth() / 2 - f1 / 2.0F, 359.20001F, localPaint);
      this.jdField_a_of_type_Bcsi = new bcsi(this, localBitmap);
      this.jdField_a_of_type_Bcsi.c = (this.jdField_a_of_type_Bfjh.jdField_a_of_type_Int / 2);
      this.jdField_a_of_type_Bcsi.d = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Bcsi.e = 0.0F;
      a(this.jdField_a_of_type_Bcsi);
      if (paramBitmap3 != null)
      {
        this.jdField_a_of_type_Bcsc = new bcsc(this, paramBitmap3, false);
        this.jdField_a_of_type_Bcsc.a(this.jdField_a_of_type_Bfjh.jdField_a_of_type_Int / 2, this.jdField_a_of_type_Bfjh.jdField_b_of_type_Int * this.jdField_a_of_type_Bfjh.f / 100);
      }
      try
      {
        this.jdField_b_of_type_Bcsc = new bcsc(this, BitmapFactory.decodeResource(getResources(), 2130847089), true);
        this.jdField_b_of_type_Bcsc.a(parambfjh.jdField_a_of_type_Int - bfvh.a(getContext(), 40.0F), bfvh.a(getContext(), 120.0F));
        this.jdField_b_of_type_Bcsc.a(parambcsd);
        this.jdField_b_of_type_Bcsc.e = 0.75F;
        a(this.jdField_b_of_type_Bcsc);
        return;
        paramBitmap1 = parambfjh.jdField_a_of_type_JavaLangString.substring(0, j) + "..." + paramBitmap1;
      }
      catch (OutOfMemoryError paramBitmap1)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("TroopGiftToAllSurfaceView", 2, "decode closeButton failed");
        return;
      }
    }
  }
  
  public void a(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, String paramString, bcsd parambcsd, bfjh parambfjh)
  {
    this.jdField_a_of_type_Bfjh = parambfjh;
    this.jdField_a_of_type_Int = (parambfjh.jdField_b_of_type_Int * parambfjh.c / 100);
    this.jdField_a_of_type_Float = (getResources().getDisplayMetrics().density / 2.0F);
    this.jdField_a_of_type_JavaLangString = paramString;
    paramString = new VideoSprite(this, getContext(), true);
    paramString.b = true;
    paramString.c = (this.jdField_a_of_type_Bfjh.jdField_a_of_type_Int / 2);
    paramString.d = (this.jdField_a_of_type_Bfjh.jdField_b_of_type_Int / 2);
    this.jdField_b_of_type_Bcsi = paramString;
    a(paramBitmap1, paramBitmap2, paramBitmap3, parambcsd, parambfjh);
  }
  
  public void a(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, String[] paramArrayOfString, bcsd parambcsd, bfjh parambfjh)
  {
    this.jdField_a_of_type_Bfjh = parambfjh;
    this.jdField_a_of_type_Int = (parambfjh.jdField_b_of_type_Int * parambfjh.c / 100);
    this.jdField_a_of_type_Float = (getResources().getDisplayMetrics().density / 2.0F);
    paramArrayOfString = new bcry(this, paramArrayOfString);
    this.jdField_b_of_type_Bcsi = paramArrayOfString;
    this.jdField_b_of_type_Bcsi.c = (this.jdField_a_of_type_Bfjh.jdField_a_of_type_Int / 2);
    this.jdField_b_of_type_Bcsi.d = (this.jdField_a_of_type_Bfjh.jdField_b_of_type_Int / 2);
    this.jdField_b_of_type_Bcsi.e = parambfjh.jdField_a_of_type_Float;
    paramArrayOfString.e(parambfjh.h);
    paramArrayOfString.a(true);
    a(paramBitmap1, paramBitmap2, paramBitmap3, parambcsd, parambfjh);
  }
  
  public void a(bcrf parambcrf)
  {
    if (this.jdField_b_of_type_Bcsi != null) {
      this.jdField_b_of_type_Bcsi.a(new bcre[] { new bcrk(500, 255, 0, 1) });
    }
    bcrk localbcrk = new bcrk(500, 255, 0, 1);
    localbcrk.a(parambcrf);
    if (this.jdField_a_of_type_Bcsi != null) {
      this.jdField_a_of_type_Bcsi.a(new bcre[] { localbcrk });
    }
    if (this.jdField_a_of_type_Bcsc != null)
    {
      this.jdField_a_of_type_Bcsc.a(null);
      this.jdField_a_of_type_Bcsc.a(new bcre[] { new bcrk(500, 255, 0, 1) });
    }
    if (this.jdField_a_of_type_Bcse != null) {
      this.jdField_a_of_type_Bcse.a(new bcre[] { new bcrk(500, 255, 0, 1) });
    }
    if (this.jdField_b_of_type_Bcsc != null) {
      this.jdField_b_of_type_Bcsc.a(new bcre[] { new bcrk(500, 255, 0, 1) });
    }
  }
  
  public void a(bcrz parambcrz)
  {
    if (this.jdField_a_of_type_Bcsi != null)
    {
      bcrn localbcrn = new bcrn(new bcre[] { new bcrm(500, 0.0F, this.jdField_a_of_type_Float * 1.1F), new bcrm(200, this.jdField_a_of_type_Float * 1.1F, this.jdField_a_of_type_Float * 0.95F), new bcrm(200, this.jdField_a_of_type_Float * 0.95F, this.jdField_a_of_type_Float * 1.05F), new bcrm(200, this.jdField_a_of_type_Float * 1.05F, this.jdField_a_of_type_Float * 1.0F) });
      this.jdField_a_of_type_Bcsi.a(new bcre[] { localbcrn });
    }
    if ((this.jdField_b_of_type_Bcsi != null) && ((this.jdField_b_of_type_Bcsi instanceof bcry)))
    {
      ((bcry)this.jdField_b_of_type_Bcsi).a = new bfjc(this, parambcrz);
      ((bcry)this.jdField_b_of_type_Bcsi).a(getContext(), this);
    }
    for (;;)
    {
      parambcrz = new bcrg(500);
      parambcrz.a(new bfjd(this));
      if (this.jdField_a_of_type_Bcsi != null) {
        this.jdField_a_of_type_Bcsi.a(new bcre[] { parambcrz });
      }
      return;
      if ((this.jdField_b_of_type_Bcsi != null) && ((this.jdField_b_of_type_Bcsi instanceof VideoSprite))) {
        ((VideoSprite)this.jdField_b_of_type_Bcsi).a(parambcrz);
      }
    }
  }
  
  public void a(bcsd parambcsd)
  {
    if (this.jdField_a_of_type_Bcsc != null)
    {
      this.jdField_a_of_type_Bcsc.a(parambcsd);
      this.jdField_a_of_type_Bcsc.e = 0.0F;
      a(this.jdField_a_of_type_Bcsc);
      parambcsd = new bcrn(new bcre[] { new bcrm(500, 0.0F, this.jdField_a_of_type_Float * 1.1F), new bcrm(200, this.jdField_a_of_type_Float * 1.1F, this.jdField_a_of_type_Float * 0.88F), new bcrm(200, this.jdField_a_of_type_Float * 0.88F, this.jdField_a_of_type_Float) });
      parambcsd.a(new bfje(this));
      this.jdField_a_of_type_Bcsc.a(new bcre[] { parambcsd });
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
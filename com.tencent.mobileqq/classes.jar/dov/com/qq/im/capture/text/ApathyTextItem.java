package dov.com.qq.im.capture.text;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint.Align;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.TextUtils;
import anwc;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;

public class ApathyTextItem
  extends DynamicTextItem
{
  private float jdField_a_of_type_Float = 0.85F;
  private int jdField_a_of_type_Int = 4;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private TextPaint jdField_a_of_type_AndroidTextTextPaint;
  private String jdField_a_of_type_JavaLangString = "";
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private float jdField_b_of_type_Float = 0.9F;
  private int jdField_b_of_type_Int = 4;
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  private TextPaint jdField_b_of_type_AndroidTextTextPaint;
  private float jdField_c_of_type_Float = 2.0F;
  private int jdField_c_of_type_Int = 36;
  private Bitmap jdField_c_of_type_AndroidGraphicsBitmap;
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int = 36;
  private int e = 95;
  private int f = 180;
  private int g;
  private int h;
  private int i;
  private int j = 1;
  
  public ApathyTextItem(int paramInt, @NonNull List paramList, Typeface paramTypeface, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3)
  {
    super(paramInt, paramList);
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap1;
    this.jdField_b_of_type_AndroidGraphicsBitmap = paramBitmap2;
    this.jdField_c_of_type_AndroidGraphicsBitmap = paramBitmap3;
    this.jdField_a_of_type_AndroidContentResResources = BaseApplicationImpl.getContext().getResources();
    this.jdField_a_of_type_Int = AIOUtils.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidContentResResources);
    this.jdField_c_of_type_Int = AIOUtils.a(this.jdField_c_of_type_Int, this.jdField_a_of_type_AndroidContentResResources);
    this.jdField_b_of_type_Int = AIOUtils.a(this.jdField_b_of_type_Int, this.jdField_a_of_type_AndroidContentResResources);
    this.jdField_d_of_type_Int = AIOUtils.a(this.jdField_d_of_type_Int, this.jdField_a_of_type_AndroidContentResResources);
    this.e = AIOUtils.a(this.e, this.jdField_a_of_type_AndroidContentResResources);
    this.f = AIOUtils.a(this.f, this.jdField_a_of_type_AndroidContentResResources);
    this.i = this.jdField_a_of_type_Int;
    a(paramTypeface);
    int k = Math.min(paramList.size(), a());
    paramInt = 0;
    while (paramInt < k)
    {
      a(paramInt, (String)paramList.get(paramInt));
      paramInt += 1;
    }
  }
  
  private void a(Typeface paramTypeface)
  {
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
    this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(paramTypeface);
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(Color.parseColor("#045389"));
    this.jdField_a_of_type_AndroidTextTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.CENTER);
    this.jdField_b_of_type_AndroidTextTextPaint = new TextPaint();
    this.jdField_b_of_type_AndroidTextTextPaint.setTypeface(paramTypeface);
    this.jdField_b_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidTextTextPaint.setStyle(Paint.Style.STROKE);
    this.jdField_b_of_type_AndroidTextTextPaint.setStrokeJoin(Paint.Join.ROUND);
    this.jdField_b_of_type_AndroidTextTextPaint.setStrokeCap(Paint.Cap.ROUND);
    this.jdField_b_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.CENTER);
    this.jdField_b_of_type_AndroidTextTextPaint.setColor(Color.parseColor("#ddf3fd"));
    this.jdField_b_of_type_AndroidTextTextPaint.setStrokeWidth(AIOUtils.a(2.0F, this.jdField_a_of_type_AndroidContentResResources));
    this.jdField_b_of_type_AndroidTextTextPaint.setShadowLayer(AIOUtils.a(1.0F, this.jdField_a_of_type_AndroidContentResResources), AIOUtils.a(1.0F, this.jdField_a_of_type_AndroidContentResResources), AIOUtils.a(1.0F, this.jdField_a_of_type_AndroidContentResResources), Color.parseColor("#33000000"));
  }
  
  private void d()
  {
    this.jdField_d_of_type_Float *= this.jdField_b_of_type_Float;
  }
  
  public float a()
  {
    return this.jdField_b_of_type_AndroidGraphicsRectF.width();
  }
  
  public int a()
  {
    return 1;
  }
  
  public void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    paramString = TroopFileUtils.b(a(paramInt, new anwc(this))).replaceAll("\n", "");
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    paramInt = paramString.length();
    if (paramInt > 10)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramString.substring(0, 10));
      this.jdField_a_of_type_JavaUtilArrayList.add(paramString.substring(10, Math.min(20, paramInt)));
      this.jdField_d_of_type_Float = Math.min(this.f / 10, this.jdField_c_of_type_Int / this.jdField_c_of_type_Float);
      d();
      paramInt = (int)((this.jdField_c_of_type_Int - this.jdField_d_of_type_Float * 2.0F) / 3.0F);
      this.h = paramInt;
      this.g = paramInt;
      this.jdField_b_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, this.jdField_c_of_type_Int + this.jdField_b_of_type_Int * 2, 10.0F * this.jdField_d_of_type_Float + this.jdField_a_of_type_Int * 2 + this.i * 2);
      this.j = 3;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsRectF.set(this.jdField_b_of_type_AndroidGraphicsRectF.left + this.jdField_b_of_type_Int * 1.2F, this.jdField_b_of_type_AndroidGraphicsRectF.top + this.jdField_a_of_type_Int * 1.2F, this.jdField_b_of_type_AndroidGraphicsRectF.right - this.jdField_b_of_type_Int * 1.2F, this.jdField_b_of_type_AndroidGraphicsRectF.bottom - this.jdField_a_of_type_Int * 1.2F);
      return;
      if (paramInt > 5)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramString.substring(0, 5));
        this.jdField_a_of_type_JavaUtilArrayList.add(paramString.substring(5, paramInt));
        this.jdField_d_of_type_Float = ((int)Math.min(this.e / 5, this.jdField_c_of_type_Int / this.jdField_c_of_type_Float));
        d();
        paramInt = (int)((this.jdField_c_of_type_Int - this.jdField_d_of_type_Float * 2.0F) / 3.0F);
        this.h = paramInt;
        this.g = paramInt;
        this.jdField_b_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, this.jdField_c_of_type_Int + this.jdField_b_of_type_Int * 2, 5.0F * this.jdField_d_of_type_Float + this.jdField_a_of_type_Int * 2 + this.i * 2);
        this.j = 2;
      }
      else if (paramInt > 1)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
        this.jdField_d_of_type_Float = Math.min(this.jdField_c_of_type_Int, this.e / paramInt);
        d();
        this.g = 0;
        this.h = ((int)((this.jdField_c_of_type_Int - this.jdField_d_of_type_Float) / 2.0F));
        this.jdField_b_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, this.jdField_c_of_type_Int + this.jdField_b_of_type_Int * 2, paramInt * this.jdField_d_of_type_Float + this.jdField_a_of_type_Int * 2 + this.i * 2);
        this.j = 2;
      }
      else
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
        this.jdField_d_of_type_Float = this.jdField_c_of_type_Int;
        d();
        this.jdField_b_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, this.jdField_c_of_type_Int + this.jdField_b_of_type_Int * 2, this.jdField_d_of_type_Float + this.jdField_a_of_type_Int * 2 + this.i * 2);
        this.g = 0;
        this.h = ((int)((this.jdField_c_of_type_Int - this.jdField_d_of_type_Float) / 2.0F));
        this.j = 1;
      }
    }
  }
  
  protected void a(Canvas paramCanvas)
  {
    Object localObject;
    if (1 == this.j) {
      localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
    }
    for (;;)
    {
      if (localObject != null)
      {
        this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
        paramCanvas.drawBitmap((Bitmap)localObject, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_b_of_type_AndroidGraphicsRectF, null);
      }
      if (b(0)) {
        paramCanvas.drawRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, 6.0F, 6.0F, a());
      }
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_d_of_type_Float);
      this.jdField_b_of_type_AndroidTextTextPaint.setTextSize(this.jdField_d_of_type_Float);
      int n = (int)(this.jdField_b_of_type_Int + this.h + this.jdField_d_of_type_Float * 0.5D);
      int k = (int)(this.jdField_a_of_type_Int + this.jdField_d_of_type_Float * this.jdField_a_of_type_Float + this.i);
      int m = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
      for (;;)
      {
        if (m < 0) {
          break label341;
        }
        localObject = (String)this.jdField_a_of_type_JavaUtilArrayList.get(m);
        int i3 = ((String)localObject).length();
        int i2 = 0;
        int i1 = k;
        k = i2;
        for (;;)
        {
          if (k < i3)
          {
            paramCanvas.drawText(((String)localObject).substring(k, k + 1), n, i1, this.jdField_b_of_type_AndroidTextTextPaint);
            paramCanvas.drawText(((String)localObject).substring(k, k + 1), n, i1, this.jdField_a_of_type_AndroidTextTextPaint);
            i1 = (int)(i1 + this.jdField_d_of_type_Float);
            k += 1;
            continue;
            if (2 == this.j)
            {
              localObject = this.jdField_b_of_type_AndroidGraphicsBitmap;
              break;
            }
            if (3 != this.j) {
              break label342;
            }
            localObject = this.jdField_c_of_type_AndroidGraphicsBitmap;
            break;
          }
        }
        n = (int)(n + (this.g + this.jdField_d_of_type_Float));
        k = (int)(this.jdField_a_of_type_Int + this.jdField_d_of_type_Float * this.jdField_a_of_type_Float + this.i);
        m -= 1;
      }
      label341:
      return;
      label342:
      localObject = null;
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public float b()
  {
    return this.jdField_b_of_type_AndroidGraphicsRectF.height();
  }
  
  public boolean b()
  {
    return (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (super.b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.text.ApathyTextItem
 * JD-Core Version:    0.7.0.1
 */
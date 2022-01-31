package dov.com.qq.im.capture.text;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class FluorescenceTextItem
  extends DynamicTextItem
{
  private static final String jdField_a_of_type_JavaLangString = FluorescenceTextItem.class.getSimpleName();
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = -1;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private Typeface jdField_a_of_type_AndroidGraphicsTypeface;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = -65536;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int = -65536;
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int;
  private float jdField_e_of_type_Float;
  private int jdField_e_of_type_Int;
  private float f;
  private float g;
  private float h;
  private float i;
  
  public FluorescenceTextItem(int paramInt, @NonNull List paramList1, @NonNull List paramList2, Typeface paramTypeface)
  {
    super(paramInt, paramList1);
    this.jdField_a_of_type_JavaUtilList.addAll(paramList2);
    if (this.jdField_a_of_type_JavaUtilList.size() != 6) {
      throw new IllegalStateException("FluorescenceText Bitmap size error");
    }
    this.jdField_a_of_type_AndroidGraphicsTypeface = paramTypeface;
    d();
    if (!paramList1.isEmpty()) {
      a(0, (String)paramList1.get(0));
    }
  }
  
  private void a(Canvas paramCanvas, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    int k = 0;
    if (paramBoolean)
    {
      paramCanvas.drawColor(0);
      Paint localPaint = new Paint();
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
      paramCanvas.drawPaint(localPaint);
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
      paramCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
    }
    paramCanvas.save();
    paramCanvas.save();
    paramCanvas.translate(0.0F, this.jdField_e_of_type_Float);
    paramCanvas.save();
    a(FluorescenceTextItem.PaintStyle.TEXT_SHADOW);
    int j = 0;
    while (j < 2)
    {
      this.jdField_a_of_type_AndroidTextStaticLayout.draw(paramCanvas);
      j += 1;
    }
    paramCanvas.translate(this.jdField_a_of_type_Float, this.jdField_a_of_type_Float);
    j = 0;
    while (j < 2)
    {
      this.jdField_a_of_type_AndroidTextStaticLayout.draw(paramCanvas);
      j += 1;
    }
    a(FluorescenceTextItem.PaintStyle.TEXT_SHADOW_BG);
    this.jdField_a_of_type_AndroidTextStaticLayout.draw(paramCanvas);
    paramCanvas.restore();
    paramCanvas.save();
    a(FluorescenceTextItem.PaintStyle.SUB_TEXT);
    paramCanvas.translate(this.jdField_a_of_type_Float, this.jdField_a_of_type_Float);
    this.jdField_a_of_type_AndroidTextStaticLayout.draw(paramCanvas);
    paramCanvas.restore();
    paramCanvas.save();
    a(FluorescenceTextItem.PaintStyle.TEXT);
    paramCanvas.translate(0.0F, 0.0F);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidTextStaticLayout.draw(paramCanvas);
    if (b(0))
    {
      int m = this.jdField_a_of_type_AndroidTextStaticLayout.getLineCount();
      j = 0;
      paramFloat1 = 0.0F;
      while (j < m)
      {
        paramFloat1 = Math.max(paramFloat1, this.jdField_a_of_type_AndroidTextStaticLayout.getLineWidth(j));
        j += 1;
      }
      paramFloat1 = Math.min(Math.max(this.f, paramFloat1), this.g);
      paramFloat2 = this.jdField_a_of_type_AndroidTextStaticLayout.getHeight();
      this.jdField_a_of_type_AndroidGraphicsRectF.left = (-this.i);
      this.jdField_a_of_type_AndroidGraphicsRectF.top = (-this.i);
      this.jdField_a_of_type_AndroidGraphicsRectF.right = (paramFloat1 + 6.0F * this.i);
      this.jdField_a_of_type_AndroidGraphicsRectF.bottom = (paramFloat2 + 2.0F * this.i);
      paramCanvas.drawRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, 6.0F, 6.0F, a());
    }
    paramCanvas.restore();
    paramCanvas.restore();
    paramCanvas.save();
    paramCanvas.translate(0.0F, 0.0F);
    paramCanvas.drawBitmap((Bitmap)this.jdField_a_of_type_JavaUtilList.get(0), 0.0F, 0.0F, this.jdField_a_of_type_AndroidTextTextPaint);
    paramCanvas.restore();
    paramCanvas.save();
    paramCanvas.translate(this.g - ((Bitmap)this.jdField_a_of_type_JavaUtilList.get(2)).getWidth(), 0.0F);
    paramCanvas.drawBitmap((Bitmap)this.jdField_a_of_type_JavaUtilList.get(2), 0.0F, 0.0F, this.jdField_a_of_type_AndroidTextTextPaint);
    paramCanvas.restore();
    paramCanvas.save();
    paramCanvas.translate(0.0F, this.h - ((Bitmap)this.jdField_a_of_type_JavaUtilList.get(1)).getHeight());
    paramCanvas.drawBitmap((Bitmap)this.jdField_a_of_type_JavaUtilList.get(1), 0.0F, 0.0F, this.jdField_a_of_type_AndroidTextTextPaint);
    paramCanvas.restore();
    paramCanvas.save();
    paramCanvas.translate(this.g - ((Bitmap)this.jdField_a_of_type_JavaUtilList.get(3)).getWidth(), this.h - ((Bitmap)this.jdField_a_of_type_JavaUtilList.get(3)).getHeight());
    paramCanvas.drawBitmap((Bitmap)this.jdField_a_of_type_JavaUtilList.get(3), 0.0F, 0.0F, this.jdField_a_of_type_AndroidTextTextPaint);
    paramCanvas.restore();
    paramCanvas.save();
    paramCanvas.translate(((Bitmap)this.jdField_a_of_type_JavaUtilList.get(0)).getWidth() - ((Bitmap)this.jdField_a_of_type_JavaUtilList.get(4)).getWidth(), 0.0F);
    j = 0;
    while (j < this.jdField_d_of_type_Int)
    {
      paramCanvas.translate(((Bitmap)this.jdField_a_of_type_JavaUtilList.get(4)).getWidth(), 0.0F);
      paramCanvas.drawBitmap((Bitmap)this.jdField_a_of_type_JavaUtilList.get(4), 0.0F, 0.0F, this.jdField_a_of_type_AndroidTextTextPaint);
      j += 1;
    }
    paramCanvas.restore();
    paramCanvas.save();
    paramCanvas.translate(((Bitmap)this.jdField_a_of_type_JavaUtilList.get(0)).getWidth() - ((Bitmap)this.jdField_a_of_type_JavaUtilList.get(5)).getWidth(), this.h - ((Bitmap)this.jdField_a_of_type_JavaUtilList.get(5)).getHeight());
    j = k;
    while (j < this.jdField_e_of_type_Int)
    {
      paramCanvas.translate(((Bitmap)this.jdField_a_of_type_JavaUtilList.get(5)).getWidth(), 0.0F);
      paramCanvas.drawBitmap((Bitmap)this.jdField_a_of_type_JavaUtilList.get(5), 0.0F, 0.0F, this.jdField_a_of_type_AndroidTextTextPaint);
      j += 1;
    }
    paramCanvas.restore();
    paramCanvas.restore();
  }
  
  private void a(FluorescenceTextItem.PaintStyle paramPaintStyle)
  {
    this.jdField_a_of_type_AndroidTextTextPaint.reset();
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_b_of_type_Float);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSkewX(-0.25F);
    if (this.jdField_a_of_type_AndroidGraphicsTypeface != null) {
      this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(this.jdField_a_of_type_AndroidGraphicsTypeface);
    }
    switch (amxu.a[paramPaintStyle.ordinal()])
    {
    default: 
      return;
    case 1: 
      this.jdField_a_of_type_AndroidTextTextPaint.setColor(this.jdField_a_of_type_Int);
      return;
    case 2: 
      this.jdField_a_of_type_AndroidTextTextPaint.setColor(this.jdField_b_of_type_Int);
      return;
    case 3: 
      this.jdField_a_of_type_AndroidTextTextPaint.setColor(this.jdField_c_of_type_Int);
      this.jdField_a_of_type_AndroidTextTextPaint.setShadowLayer(this.jdField_c_of_type_Float, 0.0F, 0.0F, this.jdField_c_of_type_Int);
      return;
    }
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(this.jdField_c_of_type_Int);
    this.jdField_a_of_type_AndroidTextTextPaint.setShadowLayer(this.jdField_d_of_type_Float, 0.0F, 0.0F, this.jdField_c_of_type_Int);
  }
  
  public float a()
  {
    return this.g;
  }
  
  public int a()
  {
    return 1;
  }
  
  public void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    String str = b(paramInt);
    paramString = str;
    if (TextUtils.isEmpty(str)) {
      paramString = "  ";
    }
    this.f = ((int)Math.min(this.jdField_a_of_type_AndroidTextTextPaint.measureText("High Allnight"), this.jdField_a_of_type_AndroidTextTextPaint.measureText(paramString)));
    this.f = ((int)Math.max(this.f, this.jdField_a_of_type_AndroidTextTextPaint.measureText("老虎")));
    float f1 = this.f;
    paramInt = ((Bitmap)this.jdField_a_of_type_JavaUtilList.get(0)).getWidth();
    int j = ((Bitmap)this.jdField_a_of_type_JavaUtilList.get(2)).getWidth();
    this.f = Math.max(f1, ((Bitmap)this.jdField_a_of_type_JavaUtilList.get(4)).getWidth() * 10 + (paramInt + j));
    this.jdField_a_of_type_AndroidTextStaticLayout = StaticLayoutWithMaxLines.a(paramString, 0, paramString.length(), this.jdField_a_of_type_AndroidTextTextPaint, (int)this.f, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false, null, 0, 4);
    if (this.jdField_a_of_type_AndroidTextStaticLayout.getLineCount() == 4)
    {
      paramInt = Math.min(this.jdField_a_of_type_AndroidTextStaticLayout.getLineEnd(3), paramString.length());
      str = paramString;
      if (paramInt > 0)
      {
        str = paramString.substring(0, paramInt);
        if ((!str.endsWith("\n")) && (!str.endsWith("\r"))) {
          break label623;
        }
      }
    }
    label623:
    for (str = paramString.substring(0, paramInt - 1);; str = paramString.substring(0, paramInt))
    {
      this.jdField_a_of_type_AndroidTextStaticLayout = StaticLayoutWithMaxLines.a(str, 0, str.length(), this.jdField_a_of_type_AndroidTextTextPaint, (int)this.f, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false, null, 0, 4);
      this.g = this.jdField_a_of_type_AndroidTextStaticLayout.getWidth();
      f1 = this.jdField_a_of_type_AndroidTextStaticLayout.getHeight();
      float f2 = ((Bitmap)this.jdField_a_of_type_JavaUtilList.get(0)).getWidth();
      this.h = (((Bitmap)this.jdField_a_of_type_JavaUtilList.get(2)).getWidth() * 0.8F + (f1 + f2 * 0.8F));
      this.jdField_e_of_type_Float = (((Bitmap)this.jdField_a_of_type_JavaUtilList.get(0)).getHeight() * 0.8F);
      f1 = ((Bitmap)this.jdField_a_of_type_JavaUtilList.get(4)).getWidth();
      f2 = ((Bitmap)this.jdField_a_of_type_JavaUtilList.get(4)).getWidth();
      float f3 = this.g;
      float f4 = ((Bitmap)this.jdField_a_of_type_JavaUtilList.get(0)).getWidth();
      float f5 = ((Bitmap)this.jdField_a_of_type_JavaUtilList.get(2)).getWidth();
      float f6 = this.g;
      float f7 = ((Bitmap)this.jdField_a_of_type_JavaUtilList.get(1)).getWidth();
      float f8 = ((Bitmap)this.jdField_a_of_type_JavaUtilList.get(3)).getWidth();
      this.jdField_d_of_type_Int = ((int)Math.floor((f3 - f4 - f5) / f1));
      this.jdField_e_of_type_Int = ((int)Math.floor((f6 - f7 - f8) / f2));
      paramInt = ((Bitmap)this.jdField_a_of_type_JavaUtilList.get(0)).getWidth();
      j = ((Bitmap)this.jdField_a_of_type_JavaUtilList.get(2)).getWidth();
      int k = this.jdField_d_of_type_Int;
      this.g = (((Bitmap)this.jdField_a_of_type_JavaUtilList.get(4)).getWidth() * k + (paramInt + j));
      return;
    }
  }
  
  protected void a(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_AndroidTextStaticLayout != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("hardware", 2, "is support " + paramCanvas.isHardwareAccelerated());
      }
      a(paramCanvas, paramCanvas.getWidth(), paramCanvas.getHeight(), false);
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public float b()
  {
    return this.h;
  }
  
  public int b()
  {
    return 0;
  }
  
  public void d()
  {
    Resources localResources = BaseApplicationImpl.getContext().getResources();
    this.jdField_a_of_type_Float = (localResources.getDisplayMetrics().density * 2.0F);
    this.jdField_b_of_type_Float = AIOUtils.a(38.0F, localResources);
    this.jdField_c_of_type_Float = Math.min(AIOUtils.a(4.0F, localResources), 24);
    this.jdField_d_of_type_Float = Math.min(AIOUtils.a(8.0F, localResources), 24);
    this.jdField_a_of_type_Int = Color.parseColor("#ffdbdb");
    this.jdField_b_of_type_Int = Color.parseColor("#ff4947");
    this.jdField_c_of_type_Int = Color.parseColor("#ff4947");
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_b_of_type_Float);
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.i = AIOUtils.a(2.0F, localResources);
  }
  
  protected void finalize()
  {
    super.finalize();
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.text.FluorescenceTextItem
 * JD-Core Version:    0.7.0.1
 */
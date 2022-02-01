package dov.com.qq.im.capture.text;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;

public class IDonotCareTextItem
  extends DynamicTextItem
{
  public static final float a;
  public static final int b;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private TextPaint jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
  TextDrawImplement jdField_a_of_type_DovComQqImCaptureTextTextDrawImplement;
  private float jdField_b_of_type_Float;
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private RectF jdField_c_of_type_AndroidGraphicsRectF = new RectF();
  private int d;
  
  static
  {
    jdField_a_of_type_Float = ScreenUtil.dip2px(45.0F);
    jdField_b_of_type_Int = AIOUtils.a(24.0F, BaseApplicationImpl.getContext().getResources());
  }
  
  public IDonotCareTextItem(int paramInt, List<String> paramList, Bitmap paramBitmap1, Bitmap paramBitmap2, Typeface paramTypeface)
  {
    super(paramInt, paramList);
    this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(Typeface.DEFAULT);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.CENTER);
    if (paramTypeface == null) {
      this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(Typeface.defaultFromStyle(1));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
      this.jdField_a_of_type_AndroidTextTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
      this.jdField_a_of_type_AndroidTextTextPaint.setColor(-16777216);
      this.jdField_a_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.LEFT);
      this.d = (jdField_b_of_type_Int * 9);
      new BaseTextRegion.Builder().a(0.0F, 0.0F).a(this.d, jdField_b_of_type_Int, 5, 9).a();
      this.jdField_c_of_type_Int = jdField_b_of_type_Int;
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_c_of_type_Int);
      this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap1;
      this.jdField_b_of_type_AndroidGraphicsBitmap = paramBitmap2;
      if (!paramList.isEmpty()) {
        a(0, (String)paramList.get(0));
      }
      return;
      this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(paramTypeface);
    }
  }
  
  private void a(int paramInt, RectF paramRectF, Canvas paramCanvas, Paint paramPaint)
  {
    if ((paramInt < 0) || (paramRectF == null) || (paramCanvas == null) || (paramPaint == null)) {
      return;
    }
    if (paramInt < 4)
    {
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, paramRectF.left + (paramRectF.width() - this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth()) / 2.0F, paramRectF.top + (paramRectF.height() - this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight()) / 2.0F, paramPaint);
      return;
    }
    paramCanvas.drawBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, paramRectF.left + (paramRectF.width() - this.jdField_b_of_type_AndroidGraphicsBitmap.getWidth()) / 2.0F, paramRectF.top + (paramRectF.height() - this.jdField_b_of_type_AndroidGraphicsBitmap.getHeight()) / 2.0F, paramPaint);
  }
  
  public float a()
  {
    return this.jdField_b_of_type_Float;
  }
  
  public int a()
  {
    return 1;
  }
  
  public void a(int paramInt, String paramString)
  {
    int i = 0;
    super.a(paramInt, paramString);
    String str = super.b(paramInt);
    paramString = str;
    if (TextUtils.isEmpty(str)) {
      paramString = "　　";
    }
    this.jdField_a_of_type_DovComQqImCaptureTextTextDrawImplement = new TextDrawImplement(0);
    this.jdField_a_of_type_DovComQqImCaptureTextTextDrawImplement.a(paramString, this.d, jdField_b_of_type_Int, this.jdField_a_of_type_AndroidTextTextPaint);
    this.jdField_a_of_type_DovComQqImCaptureTextTextDrawImplement.a(new LineMarginCoverter((int)jdField_a_of_type_Float));
    this.jdField_b_of_type_Float = this.jdField_a_of_type_DovComQqImCaptureTextTextDrawImplement.a(1, this.jdField_a_of_type_DovComQqImCaptureTextTextDrawImplement.a()).width();
    this.jdField_c_of_type_Float = this.jdField_a_of_type_DovComQqImCaptureTextTextDrawImplement.a(1, this.jdField_a_of_type_DovComQqImCaptureTextTextDrawImplement.a()).height();
    paramInt = 0;
    if (paramInt < this.jdField_a_of_type_DovComQqImCaptureTextTextDrawImplement.a())
    {
      int j = this.jdField_a_of_type_DovComQqImCaptureTextTextDrawImplement.a(paramInt);
      if (i > j) {}
      for (;;)
      {
        paramInt += 1;
        break;
        i = j;
      }
    }
    if (i <= 4) {}
    for (this.jdField_b_of_type_Float = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();; this.jdField_b_of_type_Float = this.jdField_b_of_type_AndroidGraphicsBitmap.getWidth())
    {
      this.jdField_a_of_type_DovComQqImCaptureTextTextDrawImplement.a(new CenterMarginCoverter(this.jdField_b_of_type_Float, this.jdField_c_of_type_Float));
      return;
    }
  }
  
  protected void a(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_DovComQqImCaptureTextTextDrawImplement == null) {
      return;
    }
    paramCanvas.save();
    this.jdField_a_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.LEFT);
    paramCanvas.save();
    int i = 0;
    while (i < this.jdField_a_of_type_DovComQqImCaptureTextTextDrawImplement.a())
    {
      this.jdField_c_of_type_AndroidGraphicsRectF.set(this.jdField_a_of_type_DovComQqImCaptureTextTextDrawImplement.a(i));
      this.jdField_b_of_type_AndroidGraphicsRectF.set(this.jdField_c_of_type_AndroidGraphicsRectF);
      a(this.jdField_a_of_type_DovComQqImCaptureTextTextDrawImplement.a(i), this.jdField_b_of_type_AndroidGraphicsRectF, paramCanvas, this.jdField_a_of_type_AndroidTextTextPaint);
      RectF localRectF = this.jdField_c_of_type_AndroidGraphicsRectF;
      localRectF.bottom -= jdField_a_of_type_Float;
      this.jdField_b_of_type_AndroidGraphicsRectF.set(this.jdField_c_of_type_AndroidGraphicsRectF);
      i += 1;
    }
    paramCanvas.restore();
    paramCanvas.rotate(-10.0F, this.jdField_b_of_type_Float / 2.0F, this.jdField_c_of_type_Float / 2.0F);
    paramCanvas.translate(0.0F, -ScreenUtil.dip2px(5.0F));
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(-16777216);
    this.jdField_a_of_type_DovComQqImCaptureTextTextDrawImplement.a(paramCanvas, 0, 0);
    if (super.b(0))
    {
      this.jdField_a_of_type_AndroidGraphicsRectF.set(this.jdField_a_of_type_DovComQqImCaptureTextTextDrawImplement.a(1, this.jdField_a_of_type_DovComQqImCaptureTextTextDrawImplement.a()));
      paramCanvas.drawRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, 6.0F, 6.0F, a());
    }
    paramCanvas.restore();
  }
  
  public boolean a()
  {
    return true;
  }
  
  public float b()
  {
    return this.jdField_c_of_type_Float;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.text.IDonotCareTextItem
 * JD-Core Version:    0.7.0.1
 */
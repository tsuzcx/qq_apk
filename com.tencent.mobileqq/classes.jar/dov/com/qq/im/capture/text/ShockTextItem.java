package dov.com.qq.im.capture.text;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;

public class ShockTextItem
  extends DynamicTextItem
{
  private float jdField_a_of_type_Float;
  int jdField_a_of_type_Int = 0;
  Resources jdField_a_of_type_AndroidContentResResources = BaseApplicationImpl.getContext().getResources();
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private TextPaint jdField_a_of_type_AndroidTextTextPaint;
  int b = 0;
  int c;
  
  public ShockTextItem(int paramInt, @NonNull List paramList, Typeface paramTypeface, Bitmap paramBitmap)
  {
    super(paramInt, paramList);
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
    if (paramTypeface != null) {
      this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(paramTypeface);
    }
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    if (this.jdField_a_of_type_Int <= 0)
    {
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(AIOUtils.a(36.0F, this.jdField_a_of_type_AndroidContentResResources));
      this.jdField_a_of_type_Int = ((int)this.jdField_a_of_type_AndroidTextTextPaint.measureText("最多五个字"));
    }
    if (this.b <= 0)
    {
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(AIOUtils.a(21.0F, this.jdField_a_of_type_AndroidContentResResources));
      this.b = ((int)this.jdField_a_of_type_AndroidTextTextPaint.measureText("最多五个字"));
    }
    this.c = AIOUtils.a(-2.0F, this.jdField_a_of_type_AndroidContentResResources);
    if (!paramList.isEmpty()) {
      a(0, (String)paramList.get(0));
    }
    this.jdField_a_of_type_Float = AIOUtils.a(2.0F, this.jdField_a_of_type_AndroidContentResResources);
  }
  
  public float a()
  {
    return this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
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
    paramString = a(10, paramString);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(AIOUtils.a(40.0F, this.jdField_a_of_type_AndroidContentResResources));
    this.jdField_a_of_type_AndroidTextStaticLayout = StaticLayoutWithMaxLines.a(paramString, 0, paramString.length(), this.jdField_a_of_type_AndroidTextTextPaint, this.jdField_a_of_type_Int, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false, null, 0, 3);
    if (this.jdField_a_of_type_AndroidTextStaticLayout.getLineCount() == 1)
    {
      paramInt = 1;
      i = paramInt;
      if (paramInt == 0)
      {
        this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(AIOUtils.a(36.0F, this.jdField_a_of_type_AndroidContentResResources));
        this.jdField_a_of_type_AndroidTextStaticLayout = StaticLayoutWithMaxLines.a(paramString, 0, paramString.length(), this.jdField_a_of_type_AndroidTextTextPaint, this.jdField_a_of_type_Int, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false, null, 0, 3);
        if (this.jdField_a_of_type_AndroidTextStaticLayout.getLineCount() != 1) {
          break label218;
        }
      }
    }
    label218:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(AIOUtils.a(21.0F, this.jdField_a_of_type_AndroidContentResResources));
        this.jdField_a_of_type_AndroidTextStaticLayout = StaticLayoutWithMaxLines.a(paramString, 0, paramString.length(), this.jdField_a_of_type_AndroidTextTextPaint, this.b, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false, null, 0, 3);
      }
      return;
      paramInt = 0;
      break;
    }
  }
  
  protected void a(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, 0.0F, 0.0F, this.jdField_a_of_type_AndroidTextTextPaint);
    if (this.jdField_a_of_type_AndroidTextStaticLayout != null)
    {
      float f1 = a(this.jdField_a_of_type_AndroidTextStaticLayout);
      float f2 = this.jdField_a_of_type_AndroidTextStaticLayout.getHeight();
      paramCanvas.translate((this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() - f1) * 0.5F + this.c, (this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() - f2) * 0.5F);
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSkewX(-0.15F);
      this.jdField_a_of_type_AndroidTextTextPaint.setStyle(Paint.Style.STROKE);
      this.jdField_a_of_type_AndroidTextTextPaint.setStrokeJoin(Paint.Join.ROUND);
      this.jdField_a_of_type_AndroidTextTextPaint.setStrokeCap(Paint.Cap.ROUND);
      this.jdField_a_of_type_AndroidTextTextPaint.setStrokeWidth(AIOUtils.a(8.0F, this.jdField_a_of_type_AndroidContentResResources));
      this.jdField_a_of_type_AndroidTextTextPaint.setColor(-16777216);
      this.jdField_a_of_type_AndroidTextStaticLayout.draw(paramCanvas);
      this.jdField_a_of_type_AndroidTextTextPaint.setStyle(Paint.Style.FILL);
      this.jdField_a_of_type_AndroidTextTextPaint.setColor(-1);
      this.jdField_a_of_type_AndroidTextStaticLayout.draw(paramCanvas);
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSkewX(0.0F);
      if (b(0))
      {
        this.jdField_a_of_type_AndroidGraphicsRectF.left = (-this.jdField_a_of_type_Float);
        this.jdField_a_of_type_AndroidGraphicsRectF.top = (-this.jdField_a_of_type_Float);
        this.jdField_a_of_type_AndroidGraphicsRectF.right = (f1 + this.jdField_a_of_type_Float * 2.0F);
        this.jdField_a_of_type_AndroidGraphicsRectF.bottom = (f2 + this.jdField_a_of_type_Float * 2.0F);
        paramCanvas.drawRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, 6.0F, 6.0F, a());
      }
    }
    paramCanvas.restore();
  }
  
  public boolean a()
  {
    return true;
  }
  
  public float b()
  {
    return this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.text.ShockTextItem
 * JD-Core Version:    0.7.0.1
 */
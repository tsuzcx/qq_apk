package dov.com.qq.im.capture.text;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
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

public class LocationTextItem
  extends DynamicTextItem
{
  private static Resources jdField_a_of_type_AndroidContentResResources;
  private float jdField_a_of_type_Float;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private Typeface jdField_a_of_type_AndroidGraphicsTypeface;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint;
  private float b;
  private float c;
  private float d;
  private float e;
  private float f;
  private float g;
  private float h;
  
  public LocationTextItem(int paramInt, @NonNull List paramList, Bitmap paramBitmap, Typeface paramTypeface)
  {
    super(paramInt, paramList);
    if (jdField_a_of_type_AndroidContentResResources == null) {
      jdField_a_of_type_AndroidContentResResources = BaseApplicationImpl.getContext().getResources();
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_a_of_type_AndroidGraphicsTypeface = paramTypeface;
    d();
    if (!paramList.isEmpty()) {
      a(0, (String)paramList.get(0));
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_Float = AIOUtils.a(15.0F, jdField_a_of_type_AndroidContentResResources);
    this.b = AIOUtils.a(3.0F, jdField_a_of_type_AndroidContentResResources);
    this.c = AIOUtils.a(7.0F, jdField_a_of_type_AndroidContentResResources);
    this.h = AIOUtils.a(2.0F, jdField_a_of_type_AndroidContentResResources);
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(-1);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_a_of_type_Float);
    if (this.jdField_a_of_type_AndroidGraphicsTypeface != null) {
      this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(this.jdField_a_of_type_AndroidGraphicsTypeface);
    }
    this.d = this.jdField_a_of_type_AndroidTextTextPaint.measureText("最多十个字字个十多最.");
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
    float f1 = 0.0F;
    super.a(paramInt, paramString);
    String str = b(paramInt);
    paramString = str;
    if (TextUtils.isEmpty(str)) {
      paramString = "　　";
    }
    this.jdField_a_of_type_AndroidTextStaticLayout = StaticLayoutWithMaxLines.a(paramString, 0, paramString.length(), this.jdField_a_of_type_AndroidTextTextPaint, (int)this.d, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false, null, 0, 4);
    str = paramString;
    if (this.jdField_a_of_type_AndroidTextStaticLayout.getLineCount() == 4)
    {
      paramInt = Math.min(this.jdField_a_of_type_AndroidTextStaticLayout.getLineEnd(3), paramString.length());
      str = paramString;
      if (paramInt > 0)
      {
        str = paramString.substring(0, paramInt);
        if ((!str.endsWith("\n")) && (!str.endsWith("\r"))) {
          break label200;
        }
        str = paramString.substring(0, paramInt - 1);
      }
    }
    this.jdField_a_of_type_AndroidTextStaticLayout = StaticLayoutWithMaxLines.a(str, 0, str.length(), this.jdField_a_of_type_AndroidTextTextPaint, (int)this.d, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false, null, 0, 4);
    this.e = a(this.jdField_a_of_type_AndroidTextStaticLayout);
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {}
    for (;;)
    {
      this.g = Math.max(f1, this.e);
      return;
      label200:
      str = paramString.substring(0, paramInt);
      break;
      f1 = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
    }
  }
  
  protected void a(Canvas paramCanvas)
  {
    float f2;
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      f1 = this.g / 2.0F;
      f2 = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() / 2.0F;
      paramCanvas.save();
      paramCanvas.translate(f1 - f2, 0.0F);
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, 0.0F, 0.0F, this.jdField_a_of_type_AndroidTextTextPaint);
      paramCanvas.restore();
    }
    for (float f1 = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();; f1 = 0.0F)
    {
      paramCanvas.translate(0.0F, this.c + f1);
      f2 = this.g / 2.0F;
      float f3 = this.jdField_a_of_type_AndroidTextStaticLayout.getWidth() / 2.0F;
      paramCanvas.save();
      paramCanvas.translate(f2 - f3, 0.0F);
      this.jdField_a_of_type_AndroidTextStaticLayout.draw(paramCanvas);
      paramCanvas.restore();
      this.f = (f1 + this.c + this.jdField_a_of_type_AndroidTextStaticLayout.getHeight());
      if (b(0))
      {
        this.jdField_a_of_type_AndroidGraphicsRectF.left = (this.g / 2.0F - this.e / 2.0F - this.h);
        this.jdField_a_of_type_AndroidGraphicsRectF.top = (-this.h);
        this.jdField_a_of_type_AndroidGraphicsRectF.right = (this.g / 2.0F + this.e / 2.0F + this.h);
        this.jdField_a_of_type_AndroidGraphicsRectF.bottom = (this.jdField_a_of_type_AndroidTextStaticLayout.getHeight() + this.h);
        paramCanvas.drawRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, 6.0F, 6.0F, a());
      }
      return;
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public float b()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.text.LocationTextItem
 * JD-Core Version:    0.7.0.1
 */
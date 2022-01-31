package dov.com.qq.im.capture.text;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;

public class DonotGiveUpHealing
  extends DynamicTextItem
{
  private static final float e;
  private static final float f;
  private static final float g;
  private static final float h;
  private static final float i;
  private static final float j;
  private static final float k;
  private float jdField_a_of_type_Float = 0.0F;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private TextPaint jdField_a_of_type_AndroidTextTextPaint;
  private float jdField_b_of_type_Float = 0.0F;
  private RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  private float c = 0.0F;
  private float d = 0.0F;
  
  static
  {
    Resources localResources = BaseApplicationImpl.getContext().getResources();
    e = AIOUtils.a(36.0F, localResources);
    f = AIOUtils.a(12.5F, localResources);
    g = AIOUtils.a(6.0F, localResources);
    h = AIOUtils.a(57.0F, localResources);
    i = AIOUtils.a(41.5F, localResources);
    j = AIOUtils.a(137.5F, localResources);
    k = AIOUtils.a(0.5F, localResources);
  }
  
  public DonotGiveUpHealing(int paramInt, List paramList, Typeface paramTypeface)
  {
    super(paramInt, paramList);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inScaled = true;
    localOptions.inDensity = 320;
    this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130842062, localOptions);
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
    this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(paramTypeface);
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(-1);
    if (!paramList.isEmpty()) {
      a(0, (String)paramList.get(0));
    }
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
    this.jdField_b_of_type_Float = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
    this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, (int)this.jdField_a_of_type_Float, (int)this.jdField_b_of_type_Float);
    this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float);
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public int a()
  {
    return 1;
  }
  
  public void a(int paramInt, String paramString)
  {
    int m = 0;
    super.a(paramInt, paramString);
    String str = b(paramInt);
    paramString = str;
    if (TextUtils.isEmpty(str)) {
      paramString = "　　";
    }
    float f1 = e;
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(f1);
    float f2 = this.jdField_a_of_type_AndroidTextTextPaint.measureText(paramString);
    float f3;
    do
    {
      if (f2 <= j) {
        break;
      }
      f3 = f1 - k;
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(f3);
      f2 = this.jdField_a_of_type_AndroidTextTextPaint.measureText(paramString);
      f1 = f3;
    } while (f3 >= f);
    this.jdField_a_of_type_AndroidTextStaticLayout = StaticLayoutWithMaxLines.a(paramString, 0, paramString.length(), this.jdField_a_of_type_AndroidTextTextPaint, (int)j, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false, null, 0, 2);
    if (this.jdField_a_of_type_AndroidTextStaticLayout.getLineCount() == 1)
    {
      this.c = this.jdField_a_of_type_AndroidTextTextPaint.measureText(paramString);
      this.d = (this.jdField_a_of_type_AndroidTextTextPaint.descent() - this.jdField_a_of_type_AndroidTextTextPaint.ascent());
      return;
    }
    if (this.jdField_a_of_type_AndroidTextStaticLayout.getLineCount() == 2)
    {
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(f);
      this.jdField_a_of_type_AndroidTextStaticLayout = StaticLayoutWithMaxLines.a(paramString, 0, paramString.length(), this.jdField_a_of_type_AndroidTextTextPaint, (int)j, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false, null, 0, 2);
      this.c = 0.0F;
      paramInt = m;
      while (paramInt < 2)
      {
        this.c = Math.max(this.c, this.jdField_a_of_type_AndroidTextStaticLayout.getLineWidth(paramInt));
        paramInt += 1;
      }
      this.d = this.jdField_a_of_type_AndroidTextStaticLayout.getHeight();
      return;
    }
    this.c = this.jdField_a_of_type_AndroidTextStaticLayout.getWidth();
    this.d = this.jdField_a_of_type_AndroidTextStaticLayout.getHeight();
  }
  
  protected void a(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidTextTextPaint);
    paramCanvas.translate((this.jdField_a_of_type_Float - this.c) / 2.0F - g, h + (i - this.d) / 2.0F);
    this.jdField_a_of_type_AndroidTextStaticLayout.draw(paramCanvas);
    if (b(0))
    {
      float f1 = a(this.jdField_a_of_type_AndroidTextStaticLayout);
      float f2 = this.jdField_a_of_type_AndroidTextStaticLayout.getHeight();
      this.jdField_b_of_type_AndroidGraphicsRectF.left = 0.0F;
      this.jdField_b_of_type_AndroidGraphicsRectF.top = 0.0F;
      this.jdField_b_of_type_AndroidGraphicsRectF.right = f1;
      this.jdField_b_of_type_AndroidGraphicsRectF.bottom = f2;
      paramCanvas.drawRoundRect(this.jdField_b_of_type_AndroidGraphicsRectF, 6.0F, 6.0F, a());
    }
    paramCanvas.restore();
  }
  
  public boolean a()
  {
    return true;
  }
  
  public float b()
  {
    return this.jdField_b_of_type_Float;
  }
  
  public int b()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.text.DonotGiveUpHealing
 * JD-Core Version:    0.7.0.1
 */
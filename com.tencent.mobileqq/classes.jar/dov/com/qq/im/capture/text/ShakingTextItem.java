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

public class ShakingTextItem
  extends DynamicTextItem
{
  private int jdField_a_of_type_Int;
  Resources jdField_a_of_type_AndroidContentResResources = BaseApplicationImpl.getContext().getResources();
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private TextPaint jdField_a_of_type_AndroidTextTextPaint;
  private int b;
  
  public ShakingTextItem(int paramInt, @NonNull List paramList, Typeface paramTypeface, Bitmap paramBitmap)
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
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(AIOUtils.a(56.0F, this.jdField_a_of_type_AndroidContentResResources));
      this.jdField_a_of_type_Int = ((int)this.jdField_a_of_type_AndroidTextTextPaint.measureText("最多五个字"));
    }
    if (!paramList.isEmpty()) {
      a(0, (String)paramList.get(0));
    }
    if (this.b <= 0) {
      this.b = AIOUtils.a(4.0F, this.jdField_a_of_type_AndroidContentResResources);
    }
  }
  
  public float a()
  {
    return Math.max(this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), a(this.jdField_a_of_type_AndroidTextStaticLayout));
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
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(AIOUtils.a(56.0F, this.jdField_a_of_type_AndroidContentResResources));
    this.jdField_a_of_type_AndroidTextStaticLayout = StaticLayoutWithMaxLines.a(paramString, 0, paramString.length(), this.jdField_a_of_type_AndroidTextTextPaint, this.jdField_a_of_type_Int, Layout.Alignment.ALIGN_NORMAL, 1.0F, this.b, false, null, 0, 3);
    if (this.jdField_a_of_type_AndroidTextStaticLayout.getLineCount() == 1) {}
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt == 0)
      {
        this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(AIOUtils.a(28.0F, this.jdField_a_of_type_AndroidContentResResources));
        this.jdField_a_of_type_AndroidTextStaticLayout = StaticLayoutWithMaxLines.a(paramString, 0, paramString.length(), this.jdField_a_of_type_AndroidTextTextPaint, this.jdField_a_of_type_Int, Layout.Alignment.ALIGN_NORMAL, 1.0F, this.b, false, null, 0, 2147483647);
      }
      return;
    }
  }
  
  protected void a(Canvas paramCanvas)
  {
    float f2 = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
    float f3 = a(this.jdField_a_of_type_AndroidTextStaticLayout);
    float f4 = this.jdField_a_of_type_AndroidTextStaticLayout.getHeight();
    if (f3 < f2) {}
    for (float f1 = (f2 - f3) * 0.5F;; f1 = 0.0F)
    {
      paramCanvas.save();
      paramCanvas.translate(f1, 0.0F);
      f1 = AIOUtils.a(2.0F, this.jdField_a_of_type_AndroidContentResResources);
      paramCanvas.save();
      paramCanvas.translate(-f1, 0.0F);
      this.jdField_a_of_type_AndroidTextTextPaint.setColor(-1306460248);
      this.jdField_a_of_type_AndroidTextStaticLayout.draw(paramCanvas);
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.translate(f1, 0.0F);
      this.jdField_a_of_type_AndroidTextTextPaint.setColor(-1291910401);
      this.jdField_a_of_type_AndroidTextStaticLayout.draw(paramCanvas);
      paramCanvas.restore();
      this.jdField_a_of_type_AndroidTextTextPaint.setColor(-1);
      this.jdField_a_of_type_AndroidTextStaticLayout.draw(paramCanvas);
      if (b(0))
      {
        this.jdField_a_of_type_AndroidGraphicsRectF.left = 0.0F;
        this.jdField_a_of_type_AndroidGraphicsRectF.top = 0.0F;
        this.jdField_a_of_type_AndroidGraphicsRectF.right = f3;
        this.jdField_a_of_type_AndroidGraphicsRectF.bottom = f4;
        paramCanvas.drawRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, 6.0F, 6.0F, a());
      }
      paramCanvas.restore();
      paramCanvas.save();
      if (f3 < f2) {}
      for (f1 = 0.0F;; f1 = (f3 - f2) * 0.5F)
      {
        paramCanvas.translate(f1, this.jdField_a_of_type_AndroidTextStaticLayout.getHeight() + AIOUtils.a(8.0F, this.jdField_a_of_type_AndroidContentResResources));
        paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, 0.0F, 0.0F, this.jdField_a_of_type_AndroidTextTextPaint);
        paramCanvas.restore();
        return;
      }
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public float b()
  {
    return this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() + this.jdField_a_of_type_AndroidTextStaticLayout.getHeight() + AIOUtils.a(8.0F, this.jdField_a_of_type_AndroidContentResResources);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.text.ShakingTextItem
 * JD-Core Version:    0.7.0.1
 */
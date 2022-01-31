package dov.com.qq.im.capture.text;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.BaseApplication;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer;
import java.util.List;

public class NormalTextItem
  extends DynamicTextItem
{
  public static final int a;
  public static final int b;
  private float jdField_a_of_type_Float;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private TextPaint jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
  private float b;
  
  static
  {
    Resources localResources = BaseApplicationImpl.getContext().getResources();
    jdField_a_of_type_Int = AIOUtils.a(22.0F, localResources);
    jdField_b_of_type_Int = localResources.getDisplayMetrics().widthPixels - TextLayer.jdField_a_of_type_Int;
  }
  
  public NormalTextItem(int paramInt, List paramList)
  {
    super(paramInt, paramList);
    this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(Typeface.DEFAULT);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.CENTER);
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(-1);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.LEFT);
    if (!paramList.isEmpty()) {
      a(0, (String)paramList.get(0));
    }
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
    int i = 0;
    float f = 0.0F;
    super.a(paramInt, paramString);
    String str = b(paramInt);
    paramString = str;
    if (TextUtils.isEmpty(str)) {
      paramString = "　　";
    }
    this.jdField_a_of_type_AndroidTextStaticLayout = new StaticLayout(paramString, this.jdField_a_of_type_AndroidTextTextPaint, jdField_b_of_type_Int, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
    paramInt = i;
    if (this.jdField_a_of_type_AndroidTextStaticLayout.getLineCount() == 1)
    {
      this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidTextTextPaint.measureText(paramString);
      this.jdField_b_of_type_Float = (this.jdField_a_of_type_AndroidTextTextPaint.descent() - this.jdField_a_of_type_AndroidTextTextPaint.ascent());
      return;
    }
    while (paramInt < this.jdField_a_of_type_AndroidTextStaticLayout.getLineCount())
    {
      f = Math.max(f, this.jdField_a_of_type_AndroidTextStaticLayout.getLineWidth(paramInt));
      paramInt += 1;
    }
    this.jdField_a_of_type_Float = f;
    this.jdField_b_of_type_Float = this.jdField_a_of_type_AndroidTextStaticLayout.getHeight();
  }
  
  public void a(Canvas paramCanvas)
  {
    float f1;
    if (this.jdField_a_of_type_AndroidTextStaticLayout != null)
    {
      if (this.jdField_a_of_type_AndroidTextStaticLayout.getLineCount() == 1)
      {
        paramCanvas.save();
        paramCanvas.translate(a() / 2.0F, b() / 2.0F);
        this.jdField_a_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.CENTER);
        f1 = -((this.jdField_a_of_type_AndroidTextTextPaint.descent() + this.jdField_a_of_type_AndroidTextTextPaint.ascent()) / 2.0F);
        String str2 = b(0);
        String str1 = str2;
        if (TextUtils.isEmpty(str2)) {
          str1 = "　　";
        }
        paramCanvas.drawText(str1, 0.0F, f1, this.jdField_a_of_type_AndroidTextTextPaint);
        if (b(0))
        {
          int i = (int)this.jdField_a_of_type_AndroidTextTextPaint.measureText(str1);
          int j = (int)Math.ceil(this.jdField_a_of_type_AndroidTextTextPaint.descent() - this.jdField_a_of_type_AndroidTextTextPaint.ascent());
          this.jdField_a_of_type_AndroidGraphicsRectF.left = (-i / 2.0F);
          this.jdField_a_of_type_AndroidGraphicsRectF.top = (-j / 2.0F);
          this.jdField_a_of_type_AndroidGraphicsRectF.right = (i / 2.0F);
          this.jdField_a_of_type_AndroidGraphicsRectF.bottom = (j / 2.0F);
          paramCanvas.drawRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, 6.0F, 6.0F, a());
        }
        paramCanvas.restore();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.LEFT);
    paramCanvas.save();
    this.jdField_a_of_type_AndroidTextStaticLayout.draw(paramCanvas);
    if (b(0))
    {
      f1 = a(this.jdField_a_of_type_AndroidTextStaticLayout);
      float f2 = this.jdField_a_of_type_AndroidTextStaticLayout.getHeight();
      this.jdField_a_of_type_AndroidGraphicsRectF.left = 0.0F;
      this.jdField_a_of_type_AndroidGraphicsRectF.top = 0.0F;
      this.jdField_a_of_type_AndroidGraphicsRectF.right = f1;
      this.jdField_a_of_type_AndroidGraphicsRectF.bottom = f2;
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
    return this.jdField_b_of_type_Float;
  }
  
  public int b()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.text.NormalTextItem
 * JD-Core Version:    0.7.0.1
 */
package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Typeface;
import android.graphics.Xfermode;
import android.text.TextPaint;
import android.view.animation.LinearInterpolator;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class Left2RigthInfoStickerDrawable
  extends InfoStickerDrawable
{
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private Typeface jdField_a_of_type_AndroidGraphicsTypeface;
  private Xfermode jdField_a_of_type_AndroidGraphicsXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
  private TextPaint jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
  int jdField_b_of_type_Int = 0;
  private Typeface jdField_b_of_type_AndroidGraphicsTypeface;
  private String jdField_b_of_type_JavaLangString = "15:29";
  int jdField_c_of_type_Int = 0;
  private String jdField_c_of_type_JavaLangString = "万利达科技大厦";
  int jdField_d_of_type_Int = 0;
  private String jdField_d_of_type_JavaLangString;
  int e = 0;
  int f = 0;
  int g = 0;
  int h = 0;
  int i = 0;
  
  public Left2RigthInfoStickerDrawable(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    a(paramString);
    a();
    b();
  }
  
  public static String a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", paramInt);
      localJSONObject.put("first_line", paramString1);
      localJSONObject.put("second_line", paramString2);
      localJSONObject.put("font_path", paramString3);
      paramString1 = localJSONObject.toString();
      if (QLog.isColorLevel()) {
        QLog.d("Left2RightInfoStickerDrawable", 2, paramString1);
      }
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Left2RightInfoStickerDrawable", 2, paramString1, new Object[0]);
        }
        paramString1 = null;
      }
    }
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.ROUND);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-15322);
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setDither(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(-1);
    this.jdField_b_of_type_AndroidGraphicsTypeface = Typeface.createFromAsset(this.jdField_a_of_type_AndroidContentContext.getResources().getAssets(), "info_sticker_typeface/roboto-regular.ttf");
    if (new File(this.jdField_d_of_type_JavaLangString).exists()) {}
    for (this.jdField_a_of_type_AndroidGraphicsTypeface = Typeface.createFromFile(this.jdField_d_of_type_JavaLangString);; this.jdField_a_of_type_AndroidGraphicsTypeface = Typeface.DEFAULT_BOLD)
    {
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(a(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      Paint.FontMetrics localFontMetrics = this.jdField_a_of_type_AndroidTextTextPaint.getFontMetrics();
      this.e = ((int)(localFontMetrics.bottom - localFontMetrics.top));
      this.jdField_d_of_type_Int = ((int)this.jdField_a_of_type_AndroidTextTextPaint.measureText(this.jdField_b_of_type_JavaLangString, 0, this.jdField_b_of_type_JavaLangString.length()));
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localFontMetrics = this.jdField_a_of_type_AndroidTextTextPaint.getFontMetrics();
      this.g = ((int)(localFontMetrics.bottom - localFontMetrics.top));
      this.g = ((int)this.jdField_a_of_type_AndroidTextTextPaint.measureText(this.jdField_c_of_type_JavaLangString, 0, this.jdField_c_of_type_JavaLangString.length()));
      this.jdField_b_of_type_Int = (Math.max(this.jdField_d_of_type_Int, this.g) + a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      this.jdField_c_of_type_Int = (a(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources()) + a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()) + a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      this.h = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetAnimStateTypeEvaluator.a("lineHeight", 20L, 200L, 0, this.jdField_c_of_type_Int - a(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), new LinearInterpolator());
      this.i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetAnimStateTypeEvaluator.a("offsetX", 180L, 330L, -this.jdField_b_of_type_Int, 0, new LinearInterpolator());
      return;
    }
  }
  
  protected void a(Canvas paramCanvas, ArrayList paramArrayList)
  {
    int j = paramCanvas.saveLayer(0.0F, 0.0F, getIntrinsicWidth(), getIntrinsicHeight(), this.jdField_a_of_type_AndroidGraphicsPaint, 31);
    int k = a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(-1);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(a(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(this.jdField_a_of_type_AndroidGraphicsTypeface);
    float f1 = Math.abs(this.jdField_a_of_type_AndroidTextTextPaint.getFontMetrics().ascent);
    if (((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(this.i)).intValue() == 0) {
      this.jdField_a_of_type_AndroidTextTextPaint.setShadowLayer(1.0F, 1.0F, 1.0F, -1728053248);
    }
    for (;;)
    {
      paramArrayList = this.jdField_b_of_type_JavaLangString;
      int m = a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramCanvas.drawText(paramArrayList, ((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(this.i)).intValue() + m, k + f1, this.jdField_a_of_type_AndroidTextTextPaint);
      m = a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(this.jdField_b_of_type_AndroidGraphicsTypeface);
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      float f2 = Math.abs(this.jdField_a_of_type_AndroidTextTextPaint.getFontMetrics().ascent);
      paramArrayList = this.jdField_c_of_type_JavaLangString;
      int n = a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramCanvas.drawText(paramArrayList, ((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(this.i)).intValue() + n, k + m + (f1 + f2), this.jdField_a_of_type_AndroidTextTextPaint);
      this.jdField_a_of_type_AndroidTextTextPaint.setXfermode(this.jdField_a_of_type_AndroidGraphicsXfermode);
      this.jdField_a_of_type_AndroidTextTextPaint.setColor(-1);
      this.jdField_a_of_type_AndroidTextTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
      paramCanvas.drawRect(((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(this.i)).intValue(), 0.0F, a(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), this.jdField_c_of_type_Int, this.jdField_a_of_type_AndroidTextTextPaint);
      this.jdField_a_of_type_AndroidTextTextPaint.setXfermode(null);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-15322);
      paramCanvas.drawLine(a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), ((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(this.h)).intValue(), this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.restoreToCount(j);
      return;
      this.jdField_a_of_type_AndroidTextTextPaint.setShadowLayer(0.0F, 0.0F, 0.0F, -1);
    }
  }
  
  public String[] a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString != null)
      {
        this.jdField_a_of_type_Int = paramString.optInt("type", 0);
        this.jdField_b_of_type_JavaLangString = paramString.optString("first_line", "");
        this.jdField_c_of_type_JavaLangString = paramString.optString("second_line", "");
        this.jdField_d_of_type_JavaLangString = paramString.optString("font_path", "");
      }
      return new String[] { this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString };
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = null;
      }
    }
  }
  
  public String b()
  {
    return this.jdField_d_of_type_JavaLangString;
  }
  
  public int getIntrinsicHeight()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public int getIntrinsicWidth()
  {
    return this.jdField_b_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.Left2RigthInfoStickerDrawable
 * JD-Core Version:    0.7.0.1
 */
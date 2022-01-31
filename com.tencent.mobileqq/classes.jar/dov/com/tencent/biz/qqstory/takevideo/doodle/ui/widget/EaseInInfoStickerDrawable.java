package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.view.animation.LinearInterpolator;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class EaseInInfoStickerDrawable
  extends InfoStickerDrawable
{
  private float jdField_a_of_type_Float;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private Path jdField_a_of_type_AndroidGraphicsPath = new Path();
  private PorterDuffXfermode jdField_a_of_type_AndroidGraphicsPorterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private Typeface jdField_a_of_type_AndroidGraphicsTypeface;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private Typeface jdField_b_of_type_AndroidGraphicsTypeface;
  private String jdField_b_of_type_JavaLangString = "27";
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString = "OCT";
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString = "2017";
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  
  public EaseInInfoStickerDrawable(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    a(this.jdField_a_of_type_JavaLangString);
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
      localJSONObject.put("third_line", paramString3);
      paramString1 = localJSONObject.toString();
      if (QLog.isColorLevel()) {
        QLog.d("EaseInInfoStickerDrawable", 2, paramString1);
      }
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("EaseInInfoStickerDrawable", 2, paramString1, new Object[0]);
        }
        paramString1 = null;
      }
    }
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setDither(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(-1);
    this.jdField_b_of_type_Int = a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.jdField_c_of_type_Int = a(130.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect(0, 0, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsTypeface = Typeface.createFromAsset(this.jdField_a_of_type_AndroidContentContext.getResources().getAssets(), "info_sticker_typeface/roboto-medium.ttf");
    this.jdField_b_of_type_AndroidGraphicsTypeface = Typeface.createFromAsset(this.jdField_a_of_type_AndroidContentContext.getResources().getAssets(), "info_sticker_typeface/roboto-regular.ttf");
    this.h = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetAnimStateTypeEvaluator.a("X", 0L, 700L, -this.jdField_a_of_type_AndroidGraphicsRect.width(), this.jdField_a_of_type_AndroidGraphicsRect.width(), new LinearInterpolator());
    this.i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetAnimStateTypeEvaluator.a("Y", 0L, 700L, -this.jdField_a_of_type_AndroidGraphicsRect.height(), this.jdField_a_of_type_AndroidGraphicsRect.height(), new LinearInterpolator());
    this.jdField_d_of_type_Int = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetAnimStateTypeEvaluator.a("firstFont", 500L, 200L, 0, 255, new LinearInterpolator());
    this.jdField_a_of_type_Float = a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.e = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetAnimStateTypeEvaluator.a("secondLine", 600L, 400L, 0, (int)(this.jdField_a_of_type_AndroidGraphicsRect.width() - 2.0F * this.jdField_a_of_type_Float), new LinearInterpolator());
    this.f = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetAnimStateTypeEvaluator.a("thirdFont", 800L, 500L, 0, 255, new LinearInterpolator());
    this.g = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetAnimStateTypeEvaluator.a("fourthFont", 900L, 500L, 0, 255, new LinearInterpolator());
  }
  
  protected void a(Canvas paramCanvas, ArrayList paramArrayList)
  {
    int j = 0 + a(8.5F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(this.jdField_a_of_type_AndroidGraphicsTypeface);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(a(49.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    float f1 = Math.abs(this.jdField_a_of_type_AndroidTextTextPaint.getFontMetrics().ascent);
    if (Build.VERSION.SDK_INT >= 21) {
      this.jdField_a_of_type_AndroidTextTextPaint.setLetterSpacing(0.0F);
    }
    this.jdField_b_of_type_Float = this.jdField_a_of_type_AndroidTextTextPaint.measureText(this.jdField_b_of_type_JavaLangString, 0, this.jdField_b_of_type_JavaLangString.length());
    this.jdField_a_of_type_AndroidTextTextPaint.setAlpha(((Integer)paramArrayList.get(this.jdField_d_of_type_Int)).intValue());
    PerLineFontBitmapsInfo.a(((Integer)paramArrayList.get(this.jdField_d_of_type_Int)).intValue(), this.jdField_a_of_type_AndroidTextTextPaint);
    paramCanvas.drawText(this.jdField_b_of_type_JavaLangString, 0, this.jdField_b_of_type_JavaLangString.length(), (this.jdField_a_of_type_AndroidGraphicsRect.width() - this.jdField_b_of_type_Float) / 2.0F, f1 + j, this.jdField_a_of_type_AndroidTextTextPaint);
    int k = a(49.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    j = a(12.5F, this.jdField_a_of_type_AndroidContentContext.getResources()) + (k + j);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    paramCanvas.drawLine(this.jdField_a_of_type_Float, j, this.jdField_a_of_type_Float + ((Integer)paramArrayList.get(this.e)).intValue(), j, this.jdField_a_of_type_AndroidGraphicsPaint);
    if (((Integer)paramArrayList.get(this.e)).intValue() == (int)(this.jdField_a_of_type_AndroidGraphicsRect.width() - this.jdField_a_of_type_Float * 2.0F))
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setShadowLayer(1.0F, 1.0F, 1.0F, -1728053248);
      j += a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(a(19.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      f1 = Math.abs(this.jdField_a_of_type_AndroidTextTextPaint.getFontMetrics().ascent);
      if (Build.VERSION.SDK_INT >= 21) {
        this.jdField_a_of_type_AndroidTextTextPaint.setLetterSpacing(0.1F);
      }
      this.jdField_b_of_type_Float = this.jdField_a_of_type_AndroidTextTextPaint.measureText(this.jdField_c_of_type_JavaLangString, 0, this.jdField_c_of_type_JavaLangString.length());
      this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(this.jdField_b_of_type_AndroidGraphicsTypeface);
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(a(19.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      this.jdField_a_of_type_AndroidTextTextPaint.setAlpha(((Integer)paramArrayList.get(this.f)).intValue());
      PerLineFontBitmapsInfo.a(((Integer)paramArrayList.get(this.f)).intValue(), this.jdField_a_of_type_AndroidTextTextPaint);
      paramCanvas.drawText(this.jdField_c_of_type_JavaLangString, 0, this.jdField_c_of_type_JavaLangString.length(), (this.jdField_a_of_type_AndroidGraphicsRect.width() - this.jdField_b_of_type_Float) / 2.0F, f1 + j, this.jdField_a_of_type_AndroidTextTextPaint);
      k = a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      int m = a(9.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(this.jdField_b_of_type_AndroidGraphicsTypeface);
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(a(19.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      f1 = Math.abs(this.jdField_a_of_type_AndroidTextTextPaint.getFontMetrics().ascent);
      if (Build.VERSION.SDK_INT >= 21) {
        this.jdField_a_of_type_AndroidTextTextPaint.setLetterSpacing(0.0F);
      }
      this.jdField_b_of_type_Float = this.jdField_a_of_type_AndroidTextTextPaint.measureText(this.jdField_d_of_type_JavaLangString, 0, this.jdField_d_of_type_JavaLangString.length());
      this.jdField_a_of_type_AndroidTextTextPaint.setAlpha(((Integer)paramArrayList.get(this.g)).intValue());
      PerLineFontBitmapsInfo.a(((Integer)paramArrayList.get(this.g)).intValue(), this.jdField_a_of_type_AndroidTextTextPaint);
      paramCanvas.drawText(this.jdField_d_of_type_JavaLangString, 0, this.jdField_d_of_type_JavaLangString.length(), (this.jdField_a_of_type_AndroidGraphicsRect.width() - this.jdField_b_of_type_Float) / 2.0F, k + j + m + f1, this.jdField_a_of_type_AndroidTextTextPaint);
      j = paramCanvas.saveLayer(0.0F, 0.0F, this.jdField_a_of_type_AndroidGraphicsRect.width(), this.jdField_a_of_type_AndroidGraphicsRect.height(), this.jdField_a_of_type_AndroidGraphicsPaint, 31);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(a(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(this.jdField_a_of_type_AndroidGraphicsPorterDuffXfermode);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-65536);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(a(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL_AND_STROKE);
      this.jdField_a_of_type_AndroidGraphicsPath.reset();
      this.jdField_a_of_type_AndroidGraphicsPath.moveTo(this.jdField_a_of_type_AndroidGraphicsRect.width(), this.jdField_a_of_type_AndroidGraphicsRect.height());
      this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.jdField_a_of_type_AndroidGraphicsRect.width(), ((Integer)paramArrayList.get(this.i)).intValue());
      this.jdField_a_of_type_AndroidGraphicsPath.lineTo(((Integer)paramArrayList.get(this.h)).intValue(), this.jdField_a_of_type_AndroidGraphicsRect.height());
      this.jdField_a_of_type_AndroidGraphicsPath.close();
      if ((this.jdField_a_of_type_AndroidGraphicsRect.width() != this.h) || (this.jdField_a_of_type_AndroidGraphicsRect.height() != this.i)) {
        break label1056;
      }
      this.jdField_a_of_type_AndroidGraphicsPaint.setShadowLayer(1.0F, 1.0F, 1.0F, -1728053248);
    }
    for (;;)
    {
      paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(null);
      paramCanvas.restoreToCount(j);
      return;
      this.jdField_a_of_type_AndroidGraphicsPaint.setShadowLayer(0.0F, 0.0F, 0.0F, -1);
      break;
      label1056:
      this.jdField_a_of_type_AndroidGraphicsPaint.setShadowLayer(0.0F, 0.0F, 0.0F, -1);
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
        this.jdField_d_of_type_JavaLangString = paramString.optString("third_line", "");
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
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.EaseInInfoStickerDrawable
 * JD-Core Version:    0.7.0.1
 */
package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.view.animation.LinearInterpolator;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class EaseInLocationStickerDrawable
  extends InfoStickerDrawable
{
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap = null;
  Paint jdField_a_of_type_AndroidGraphicsPaint = null;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private Typeface jdField_a_of_type_AndroidGraphicsTypeface;
  TextPaint jdField_a_of_type_AndroidTextTextPaint = null;
  private int jdField_b_of_type_Int;
  private Typeface jdField_b_of_type_AndroidGraphicsTypeface;
  private String jdField_b_of_type_JavaLangString = "万利达科技大厦";
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString = "DEC 06 15:39";
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString;
  private int jdField_e_of_type_Int;
  private String jdField_e_of_type_JavaLangString;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  
  public EaseInLocationStickerDrawable(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    a(paramString);
    a();
    b();
  }
  
  private int a(int paramInt)
  {
    return (this.jdField_c_of_type_Int - paramInt) / 2;
  }
  
  public static String a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", paramInt);
      localJSONObject.put("first_line", paramString1);
      localJSONObject.put("second_line", paramString2);
      localJSONObject.put("icon_path", paramString3);
      localJSONObject.put("font_path", paramString4);
      paramString1 = localJSONObject.toString();
      if (QLog.isColorLevel()) {
        QLog.d("EaseInLocationStickerDrawable", 2, paramString1);
      }
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("EaseInLocationStickerDrawable", 2, paramString1, new Object[0]);
        }
        paramString1 = null;
      }
    }
  }
  
  public String a()
  {
    return this.jdField_e_of_type_JavaLangString;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    if (new File(this.jdField_e_of_type_JavaLangString).exists()) {
      this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeFile(this.jdField_e_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130839191);
    }
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setDither(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(-1);
    this.jdField_b_of_type_Int = a(36.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    this.jdField_e_of_type_Int = ((int)this.jdField_a_of_type_AndroidTextTextPaint.measureText(this.jdField_b_of_type_JavaLangString, 0, this.jdField_b_of_type_JavaLangString.length()));
    this.f = a(36.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(a(9.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    this.g = ((int)this.jdField_a_of_type_AndroidTextTextPaint.measureText(this.jdField_c_of_type_JavaLangString, 0, this.jdField_c_of_type_JavaLangString.length()));
    this.h = a(9.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect(0, 0, this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF(0.0F, 0.0F, a(8.5F, this.jdField_a_of_type_AndroidContentContext.getResources()), a(11.5F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    this.jdField_c_of_type_Int = Math.max(Math.max(this.jdField_b_of_type_Int, this.jdField_e_of_type_Int), this.g);
    this.jdField_d_of_type_Int = ((int)(this.jdField_a_of_type_AndroidGraphicsRectF.height() + this.f + this.h + a(19.0F, this.jdField_a_of_type_AndroidContentContext.getResources())));
    this.jdField_b_of_type_AndroidGraphicsTypeface = Typeface.createFromAsset(this.jdField_a_of_type_AndroidContentContext.getResources().getAssets(), "info_sticker_typeface/roboto-regular.ttf");
    if (new File(this.jdField_d_of_type_JavaLangString).exists()) {}
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_AndroidGraphicsTypeface = Typeface.createFromFile(this.jdField_d_of_type_JavaLangString);
        this.i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetAnimStateTypeEvaluator.a("iconAlpha", 20L, 230L, 0, 255, new LinearInterpolator());
        this.j = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetAnimStateTypeEvaluator.a("firstLineAlpha", 120L, 230L, 0, 255, new LinearInterpolator());
        this.l = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetAnimStateTypeEvaluator.a("lineAlpha", 220L, 230L, 0, 255, new LinearInterpolator());
        this.k = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetAnimStateTypeEvaluator.a("secondLineAlpha", 330L, 230L, 0, 255, new LinearInterpolator());
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        QLog.e("EaseInLocationStickerDrawable", 1, "createFromFile fail, ", localRuntimeException);
        this.jdField_a_of_type_AndroidGraphicsTypeface = Typeface.DEFAULT_BOLD;
        continue;
      }
      this.jdField_a_of_type_AndroidGraphicsTypeface = Typeface.DEFAULT_BOLD;
    }
  }
  
  protected void a(Canvas paramCanvas, ArrayList paramArrayList)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(this.i)).intValue());
    int m = a((int)this.jdField_a_of_type_AndroidGraphicsRectF.width());
    this.jdField_a_of_type_AndroidGraphicsRectF.set(m, 0.0F, m + a(8.5F, this.jdField_a_of_type_AndroidContentContext.getResources()), a(11.5F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    PerLineFontBitmapsInfo.a(((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(this.i)).intValue(), this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
    m = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
    m = a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()) + m;
    this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(this.jdField_a_of_type_AndroidGraphicsTypeface);
    this.jdField_a_of_type_AndroidTextTextPaint.setAlpha(((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(this.j)).intValue());
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    float f1 = Math.abs(this.jdField_a_of_type_AndroidTextTextPaint.getFontMetrics().ascent);
    PerLineFontBitmapsInfo.a(((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(this.j)).intValue(), this.jdField_a_of_type_AndroidTextTextPaint);
    paramCanvas.drawText(this.jdField_b_of_type_JavaLangString, a(this.jdField_e_of_type_Int), f1 + m, this.jdField_a_of_type_AndroidTextTextPaint);
    m = a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources()) + m + a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(this.l)).intValue());
    PerLineFontBitmapsInfo.a(((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(this.l)).intValue(), this.jdField_a_of_type_AndroidTextTextPaint);
    paramCanvas.drawLine(a(this.jdField_b_of_type_Int), m, a(this.jdField_b_of_type_Int) + this.jdField_b_of_type_Int, m, this.jdField_a_of_type_AndroidGraphicsPaint);
    int n = a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(this.jdField_b_of_type_AndroidGraphicsTypeface);
    this.jdField_a_of_type_AndroidTextTextPaint.setAlpha(((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(this.k)).intValue());
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(a(9.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    f1 = Math.abs(this.jdField_a_of_type_AndroidTextTextPaint.getFontMetrics().ascent);
    PerLineFontBitmapsInfo.a(((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(this.k)).intValue(), this.jdField_a_of_type_AndroidTextTextPaint);
    paramCanvas.drawText(this.jdField_c_of_type_JavaLangString, a(this.g), m + n + f1, this.jdField_a_of_type_AndroidTextTextPaint);
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
        this.jdField_e_of_type_JavaLangString = paramString.optString("icon_path", "");
      }
      return new String[] { this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString };
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
    return this.jdField_d_of_type_Int;
  }
  
  public int getIntrinsicWidth()
  {
    return this.jdField_c_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.EaseInLocationStickerDrawable
 * JD-Core Version:    0.7.0.1
 */
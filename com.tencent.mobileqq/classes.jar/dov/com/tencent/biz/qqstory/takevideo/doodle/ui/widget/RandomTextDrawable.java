package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.view.animation.LinearInterpolator;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class RandomTextDrawable
  extends InfoStickerDrawable
{
  int jdField_a_of_type_Int = 0;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private TextPaint jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
  PerLineFontBitmapsInfo jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetPerLineFontBitmapsInfo;
  PerLineFontBitmapsInfo jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetPerLineFontBitmapsInfo;
  private String jdField_b_of_type_JavaLangString = "05:36";
  private String c = "2017 SEPTEMBER 30";
  
  public RandomTextDrawable(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    a(paramString);
    b();
    c();
  }
  
  private PerLineFontBitmapsInfo a(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, Typeface paramTypeface, AnimStateTypeEvaluator paramAnimStateTypeEvaluator, int paramInt7)
  {
    paramTypeface = new PerLineFontBitmapsInfo(paramInt1, paramInt2, paramTypeface, paramInt3, paramInt4, paramInt5, paramInt6);
    paramTypeface.a(paramCharSequence, paramAnimStateTypeEvaluator, paramInt7);
    return paramTypeface;
  }
  
  public static String a(int paramInt, String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", paramInt);
      localJSONObject.put("first_line", paramString1);
      localJSONObject.put("second_line", paramString2);
      paramString1 = localJSONObject.toString();
      if (QLog.isColorLevel()) {
        QLog.d("RandomTextDrawable", 2, paramString1);
      }
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RandomTextDrawable", 2, paramString1, new Object[0]);
        }
        paramString1 = null;
      }
    }
  }
  
  protected void a(Canvas paramCanvas, ArrayList<Integer> paramArrayList)
  {
    if (paramArrayList == null) {}
    for (;;)
    {
      return;
      paramArrayList = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetPerLineFontBitmapsInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
      FontBitmapInfo localFontBitmapInfo;
      Bitmap localBitmap;
      TextPaint localTextPaint;
      while (paramArrayList.hasNext())
      {
        localFontBitmapInfo = (FontBitmapInfo)paramArrayList.next();
        localBitmap = localFontBitmapInfo.jdField_a_of_type_AndroidGraphicsBitmap;
        localTextPaint = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetPerLineFontBitmapsInfo.jdField_a_of_type_AndroidTextTextPaint;
        localTextPaint.setAlpha(((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(localFontBitmapInfo.b)).intValue());
        i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetPerLineFontBitmapsInfo.jdField_a_of_type_Int;
        paramCanvas.drawBitmap(localBitmap, localFontBitmapInfo.jdField_a_of_type_Int + i, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetPerLineFontBitmapsInfo.b, localTextPaint);
      }
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(AIOUtils.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      int i = AIOUtils.a(55.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramCanvas.drawLine(0.0F, i, ((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).intValue(), i, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramArrayList = this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetPerLineFontBitmapsInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localFontBitmapInfo = (FontBitmapInfo)paramArrayList.next();
        localBitmap = localFontBitmapInfo.jdField_a_of_type_AndroidGraphicsBitmap;
        localTextPaint = this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetPerLineFontBitmapsInfo.jdField_a_of_type_AndroidTextTextPaint;
        localTextPaint.setAlpha(((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(localFontBitmapInfo.b)).intValue());
        i = this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetPerLineFontBitmapsInfo.jdField_a_of_type_Int;
        paramCanvas.drawBitmap(localBitmap, localFontBitmapInfo.jdField_a_of_type_Int + i, this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetPerLineFontBitmapsInfo.b, localTextPaint);
      }
    }
  }
  
  public String[] a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString != null)
      {
        this.f = paramString.optInt("type", 0);
        this.jdField_b_of_type_JavaLangString = paramString.optString("first_line", "");
        this.c = paramString.optString("second_line", "");
      }
      return new String[] { this.jdField_b_of_type_JavaLangString, this.c };
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
  
  protected void b()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setDither(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(-1);
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getAssets();
    try
    {
      localTypeface1 = Typeface.createFromAsset((AssetManager)localObject, "info_sticker_typeface/roboto-medium.ttf");
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          Typeface localTypeface1;
          localObject = Typeface.createFromAsset((AssetManager)localObject, "info_sticker_typeface/roboto-regular.ttf");
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetPerLineFontBitmapsInfo = a(this.jdField_b_of_type_JavaLangString, AIOUtils.a(48.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), -1, 0, 0, 0, 600, localTypeface1, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetAnimStateTypeEvaluator, 0);
          this.jdField_a_of_type_Int = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetAnimStateTypeEvaluator.a("", 300L, 500L, 0, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetPerLineFontBitmapsInfo.e, new LinearInterpolator());
          this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetPerLineFontBitmapsInfo = a(this.c, AIOUtils.a(11.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), -1, 0, AIOUtils.a(60.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 500, 800, (Typeface)localObject, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetAnimStateTypeEvaluator, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetPerLineFontBitmapsInfo.e - 10);
          return;
          localException1 = localException1;
          Typeface localTypeface2 = Typeface.DEFAULT;
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Typeface localTypeface3 = Typeface.DEFAULT;
        }
      }
    }
  }
  
  public int getIntrinsicHeight()
  {
    return AIOUtils.a(75.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
  }
  
  public int getIntrinsicWidth()
  {
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetPerLineFontBitmapsInfo.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.RandomTextDrawable
 * JD-Core Version:    0.7.0.1
 */